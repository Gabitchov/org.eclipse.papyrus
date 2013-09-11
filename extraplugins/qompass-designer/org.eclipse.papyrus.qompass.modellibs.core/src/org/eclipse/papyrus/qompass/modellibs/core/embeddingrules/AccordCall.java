/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.embeddingrules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.util.ConnectorTypeUtil;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Embedding rule
 * TODO: currently unused
 *
 */
// @unused
public class AccordCall extends ConnectorTypeUtil {
	
	private ConnectableElement clientRole = null ;
	private ConnectableElement serverRole = null ;
	private ConnectableElement rtuRole = null ;
	private ConnectableElement connectorRole = null ;
	
	public FCMUtil.RoleBindingTable getRoleBindings(Connector connector) {
		super.getRoleBindings(connector) ;
		
		clientRole = bindingTable.getRoleKeyByName("client") ;
		serverRole = bindingTable.getRoleKeyByName("server") ;
		rtuRole = bindingTable.getRoleKeyByName("rtu") ;
		connectorRole = bindingTable.getRoleKeyByName("connector") ;
		
		for (org.eclipse.uml2.uml.ConnectorEnd end : connector.getBase_Connector().getEnds()) {
			if (end.getRole() instanceof org.eclipse.uml2.uml.Port) {
				org.eclipse.uml2.uml.Port port = (org.eclipse.uml2.uml.Port)end.getRole() ;
				org.eclipse.uml2.uml.Property part = end.getPartWithPort() ;
				if (StUtils.isApplied(port, org.eclipse.papyrus.FCM.Port.class)) {
					org.eclipse.papyrus.FCM.Port fcmPort = UMLUtil.getStereotypeApplication(port, org.eclipse.papyrus.FCM.Port.class);
					if (fcmPort.getKind().getBase_Class().getName().equals("UseInterfaceWithRtf")) {
						// => elements associated with the connector end play the client role
						List<NamedElement> clientActors = new ArrayList<NamedElement>() ;
						clientActors.add(port) ;
						clientActors.add(part) ;
						bindingTable.addEntry(clientRole, clientActors) ;
					}
					else if (fcmPort.getKind().getBase_Class().getName().equals("ProvideInterface")) {
						// => elements associated with the connector end play the server role
						List<NamedElement> serverActors = new ArrayList<NamedElement>() ;
						serverActors.add(port) ;
						serverActors.add(part) ;
						bindingTable.addEntry(serverRole, serverActors) ;
						// the property playing the server role must also play the rtu role
						port = ((org.eclipse.uml2.uml.Class)part.getType()).getOwnedPort("rtu", null) ;
						if (port == null) {
							if (((org.eclipse.uml2.uml.Class)part.getType()).getInheritedMember("rtu") != null &&
								((org.eclipse.uml2.uml.Class)part.getType()).getInheritedMember("rtu") instanceof org.eclipse.uml2.uml.Port) {	
								port = (org.eclipse.uml2.uml.Port)((org.eclipse.uml2.uml.Class)part.getType()).getInheritedMember("rtu") ;
							}
							else {
								System.out.println("Could not find a port rtu on part " + part.getName() + " : " + part.getType()) ;
							}
						}
						if (port != null) {
							List<NamedElement> rtuActors = new ArrayList<NamedElement>() ;
							rtuActors.add(port) ;
							rtuActors.add(part) ;
							bindingTable.addEntry(rtuRole, rtuActors) ;
						}
					}
				}
			}
		}
		List<NamedElement> connectorActors = new ArrayList<NamedElement>() ;
		connectorActors.add(connector.getBase_Connector()) ;
		bindingTable.addEntry(connectorRole, connectorActors) ;
		return bindingTable ;
	}
}
