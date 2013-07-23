/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.ServicePort;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

public class PortIsCorrectlyTyped extends AbstractModelConstraint {



	@Override
	public IStatus validate(IValidationContext ctx) {
		Port elt = (Port)ctx.getTarget();
		if (ConstraintsUtil.verifyRobotMLApplied(elt)){
		//1. verify if the port is typed
		if(elt.getType() == null) {
			return ctx.createFailureStatus("Port should have a type (" + elt.getQualifiedName() + ")");
		} else {//2. verify if the port is correctly typed
			ServicePort serviceport = UMLUtil.getStereotypeApplication(elt, ServicePort.class);
			if(serviceport != null) {
				if(!(elt.getType() instanceof Interface)) {

					return ctx.createFailureStatus("Port should be typed by an Interface (" + elt.getQualifiedName() + ")");
				}
			} else {
				DataFlowPort flowport = UMLUtil.getStereotypeApplication(elt, DataFlowPort.class);
				if(flowport != null) {
					if(!(elt.getType() instanceof DataType)) {
						return ctx.createFailureStatus("Port should be typed by a DataType (" + elt.getQualifiedName() + ")");
					}
				}
			}
		}
		}
		return ctx.createSuccessStatus();

	}
}
