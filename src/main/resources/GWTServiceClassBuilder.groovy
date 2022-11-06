// Copyright © 2008 Object Generation AB.
// Feel free to modify this script as needed.
package com.objectgen.build

import com.objectgen.core.*
import com.objectgen.codegen.*

/**
 * This Groovy script will modify all classes with stereotype GWT Serivce.
 */
class GWTServiceClassBuilder extends ClassBuilder {
   private String interfaceName
   private Classifier iface
   private boolean createInterface = false
   
   void init() {
   }

   void build() {
      superClass = "com.google.gwt.user.server.rpc.RemoteServiceServlet"
      if(interfaceName != null) {
         removeInterface(interfaceName)
      }
      interfaceName = getInterfaceName()
      addInterface(interfaceName)

      if(createInterface) {
         println "GWTServiceClassBuilder: Create interface ${cl.name}"
         iface = cl.project.getPackage(getInterfacePackageName()).createInterface(cl.name)
         iface.addInterface(new TypeName("com.google.gwt.user.client.rpc.RemoteService"))
      }
      implementInterfaceOperations()
   }
   
   void clear() {
      if("com.google.gwt.user.server.rpc.RemoteServiceServlet" == superClass) {
         superClass = null
      }
      removeInterface(interfaceName)
      
      if(createInterface) {
         println "GWTServiceClassBuilder: Remove interface ${iface.name}"
         iface.packageData.removeClassifier(iface)
      }
      removeInterfaceOperations()
   }
   
   String getInterfaceName() {
      return getInterfacePackageName() + '.' + cl.name
   }
   
   String getInterfacePackageName() {
      String serverPackage = cl.packageData.name
      if(serverPackage.endsWith(".server")) {
         int end = ".server".length() + 1
         serverPackage = serverPackage[0 .. -end]
      }
      return serverPackage + ".client"
   }
}
