/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.Port;

/**
 * Test if current Port is a FlowPort with IN direction
 */
public class FlowPortINMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isFPIn = false;
		if(eObject instanceof Port) {

			Port port = (Port)eObject;
			FlowPort flowport = (FlowPort)port.getAppliedStereotype("SysML::Blocks::Block");

			if((flowport != null) && (flowport.getDirection() == FlowDirection.IN)) {
				isFPIn = true;
			}
		}

		return isFPIn;
	}

}
