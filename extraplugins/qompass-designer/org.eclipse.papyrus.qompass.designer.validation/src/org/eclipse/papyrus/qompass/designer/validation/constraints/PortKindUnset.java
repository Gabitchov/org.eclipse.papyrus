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

package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Check whether the attribute port-kind of the FCM stereotype port is set
 *
 */
public class PortKindUnset  extends AbstractModelConstraint {

	@Override
	public IStatus validate (IValidationContext ctx)
	{
		Port port = (Port) ctx.getTarget ();
		org.eclipse.papyrus.FCM.Port fcmPort = UMLUtil.getStereotypeApplication(port, org.eclipse.papyrus.FCM.Port.class);
		if (fcmPort != null) {
			
			if (fcmPort.getKind() == null) {
				return ctx.createFailureStatus ("The stereotype attribute 'portKind' of port '" + port.getName () + "' is unset");
			}
		}
		return ctx.createSuccessStatus();
	}

}
