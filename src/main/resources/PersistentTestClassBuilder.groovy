// Copyright © 2007 Object Generation AB.
// Feel free to modify this script as needed.
package com.objectgen.build

import java.lang.reflect.Modifier

import com.objectgen.core.*
import com.objectgen.codegen.*
import com.objectgen.codegen.hibernate.*

/**
 * This Groovy script will modify all classes with stereotype Persistent Test.
 */
public class PersistentTestClassBuilder extends ClassBuilder {
   public static final String HELPER = "persistenceHelper"
  
   BuildOperation tearDown
   BuildOperation setUp
   def operations = []
   
   void init() {
      tearDown = buildOperation("void", "tearDown")
      tearDown.access = Modifier.PROTECTED
      tearDown.addThrows("Exception")
      
      setUp = buildOperation("void", "setUp")
      setUp.access = Modifier.PROTECTED
      setUp.methodBody = "super.setUp(); " + ClassifierData.INIT_OBJECTS + "();\n"
      setUp.addThrows("Exception")
      
      operations = [ tearDown, setUp ]
   }

   void build() {
      superClass = "junit.framework.TestCase"
      
      Project project = cl.project
      boolean jpa = PersistentFactory.platformIsJPA(project)

      String configuredType = HibernateHelperBuilder.getConfiguredClassName(cl)
      TypeName helperType = new TypeName(configuredType)
      VariableData helper = cl.findVariable(HELPER)
      if(helper == null) {
         helper = new VariableData(helperType, Variable.ONE, 0, HELPER)
         helper.access = Modifier.PRIVATE
         cl.addVariable(helper)
      } else {
         helper.type = helperType
      }

      def constructor = cl.findConstructor(0)
      if(constructor == null) {
         constructor = AbstractFactory.createConstructor(cl)
      }
      
      // "helper = HibernateHelper.getInstance();"
      String code = HELPER + " = " + HibernateHelperBuilder.getConfiguredInstanceName(cl)
      setMethodBody(constructor, code)

      def designedObjects = cl.designObjects()
      
      tearDown.methodBody =
"""if(${HELPER} != null) { ${HELPER}.close(); }\n\
super.tearDown();
"""

      def variables = [:]
      for(op in operations) {
         op.build(variables)
      }
      implementInterfaceOperations()
   }

   void clear() {
      if("junit.framework.TestCase" == superClass)
         superClass = null

      def helper = cl.findVariable(HELPER)
      if(helper != null) {
         cl.removeVariable(helper)
         helper = null
      }
   
      def constructor = cl.findConstructor(0)
      if(constructor != null) {
         // Cannot just remove the constructor,
         // because if the new stereotype creates a constructor,
         // the new constructor will not clear the Java code in it.
         DesignedMethod method = constructor.method
         if(method != null)
            method.statements.clear()
         
         constructor.removeThrows("Exception")
      }

      // Automatically delete initObjects() if it is empty.
      def designedObjects = cl.designedObjects
      if(designedObjects != null && designedObjects.objects != null && designedObjects.objects.objects.size() == 0) {
         cl.removeOperation(designedObjects)
      }
 
      for(op in operations) {
         op.remove()
      }
      removeInterfaceOperations()
   }
}
