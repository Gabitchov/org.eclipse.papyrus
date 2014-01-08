/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */

package org.eclipse.papyrus.FCM.util;

import java.util.ArrayList;

import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.uml2.uml.Collaboration;

public class ConnectorTypeUtil {

	protected Collaboration connectionPattern = null;

	protected InteractionComponent connectorComp = null;

	protected FCMUtil.RoleBindingTable bindingTable = null;

	public FCMUtil.RoleBindingTable getRoleBindings(org.eclipse.papyrus.FCM.Connector connector) {
		if(connector.getIc() instanceof InteractionComponent) {
			connectorComp = (InteractionComponent)connector.getIc();
			connectionPattern = connectorComp.getConnectionPattern();
			bindingTable = new FCMUtil.RoleBindingTable();
			for(org.eclipse.uml2.uml.ConnectableElement role : connectionPattern.getRoles()) {
				bindingTable.addEntry(role, new ArrayList<org.eclipse.uml2.uml.NamedElement>());
			}
			return bindingTable;
		}
		return null;
	}
}
