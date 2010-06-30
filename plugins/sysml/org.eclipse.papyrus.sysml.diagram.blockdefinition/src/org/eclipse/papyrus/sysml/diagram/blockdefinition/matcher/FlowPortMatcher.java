/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Port;

/**
 * Test if current Port is a FlowPort
 */
public class FlowPortMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isFlowPort = false;
		if(eObject instanceof Port) {

			Port port = (Port)eObject;
			if(port.getAppliedStereotype(SysmlResource.FLOW_PORT_ID) != null) {
				isFlowPort = true;
			}
		}
		return isFlowPort;
	}

}
