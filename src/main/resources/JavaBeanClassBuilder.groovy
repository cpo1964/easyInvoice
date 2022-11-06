// Copyright © 2007 Object Generation AB.
// Feel free to modify this script as needed.
package com.objectgen.build

import com.objectgen.core.*
import com.objectgen.codegen.*

/**
 * This Groovy script will modify all classes with stereotype Java Bean.
 */
public class JavaBeanClassBuilder extends ClassBuilder {
   private Variable serialVersionUID
   
   void build() {
      addInterface("Comparable<Object>")
      addInterface("java.io.Serializable")
      serialVersionUID = createSerialVersionUID( cl.fullName.hashCode() )
      def constructor = createConstructor()
      callInitObjects(constructor)
      implementInterfaceOperations()
   }
   
   void clear() {
      if(serialVersionUID != null) {
         cl.removeVariable(serialVersionUID)
      }
      removeInterface("Comparable<Object>")
      removeInterface("java.io.Serializable")
      clearConstructor()
      removeInterfaceOperations()
   }
}
