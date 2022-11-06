// Copyright © 2007 Object Generation AB.
// Feel free to modify this script as needed.
package com.objectgen.build

import java.lang.reflect.Modifier

import com.objectgen.core.*
import com.objectgen.codegen.*
import com.objectgen.codegen.hibernate.*

/**
 * This Groovy script will modify all classes with stereotype Unit Test.
 */
public class UnitTestClassBuilder extends ClassBuilder {

   void init() {
   }

   void build() {
      superClass = "junit.framework.TestCase"
      
      OperationData constructor = cl.findConstructor(0)
      if(constructor == null)
      {
         constructor = AbstractFactory.createConstructor(cl)
      }
      constructor.addThrows("Exception")
      
      BuildOperation setUp = buildSetUp()
      def variables = [:]
      setUp.build(variables)
      implementInterfaceOperations()
   }

   void clear() {
      if("junit.framework.TestCase" == superClass)
         superClass = null
         
      def constructor = cl.findConstructor(0)
      if(constructor != null) {
         // Cannot remove the constructor,
         // because if the new stereotype creates a constructor,
         // the new constructor will not clear the Java code in it.
         if(constructor.method != null)
            constructor.method.statements().clear()
         
         constructor.removeThrows("Exception")
      }

      def setUp = buildSetUp()
      setUp.remove()
      removeInterfaceOperations()
   }
   
   private BuildOperation buildSetUp() {
      def setUp = buildOperation("void", "setUp")
      setUp.access = java.lang.reflect.Modifier.PROTECTED
      String setUpCode = "super.setUp();\n"
      def initObjects = cl.designedObjects
      if(initObjects != null)
         setUpCode += initObjects.name + "();\n"
      setUp.bodyTemplate = setUpCode
      setUp.addThrows("Exception")
      return setUp
   }
}
