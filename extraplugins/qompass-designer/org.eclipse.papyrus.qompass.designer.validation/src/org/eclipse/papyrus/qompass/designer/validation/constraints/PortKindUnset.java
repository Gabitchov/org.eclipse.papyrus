/*******************************************************************************
 * Copyright (c) 2008-2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

import org.eclipse.papyrus.qompass.designer.core.StUtils;

/**
 * Check whether the port kind is unset
 * @author ansgar
 *
 */
public class PortKindUnset  extends AbstractModelConstraint {

	@Override
	public IStatus validate (IValidationContext ctx)
	{
		Port port = (Port) ctx.getTarget ();
		org.eclipse.papyrus.FCM.Port fcmPort = StUtils.getApplication(port, org.eclipse.papyrus.FCM.Port.class);
		if (fcmPort != null) {
			
			if (fcmPort.getKind() == null) {
				Class class_ = port.getClass_ ();
				return ctx.createFailureStatus ("The stereotype attribute 'portKind' of port '" + port.getName () + "' owned by class '" + class_.getQualifiedName () + "' is unset");
			}
		}
		return ctx.createSuccessStatus();
	}

}
