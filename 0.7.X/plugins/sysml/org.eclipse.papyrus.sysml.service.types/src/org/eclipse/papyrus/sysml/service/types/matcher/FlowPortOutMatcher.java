/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Port;

/**
 * Test if current Port is a FlowPort with OUT direction
 */
public class FlowPortOutMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isFlowPort_OUT = false;

		if(eObject instanceof Port) {

			Port port = (Port)eObject;
			FlowPort flowPort = ElementUtil.getStereotypeApplication(port, FlowPort.class);

			if((flowPort != null) && (flowPort.getDirection() == FlowDirection.OUT)) {
				isFlowPort_OUT = true;
			}
		}

		return isFlowPort_OUT;
	}
}
