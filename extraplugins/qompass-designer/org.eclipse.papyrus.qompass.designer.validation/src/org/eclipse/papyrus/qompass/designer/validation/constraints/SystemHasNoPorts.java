/*******************************************************************************
 * Copyright (c) 2008-2009 CEA LIST.
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
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;

import FCM.DeploymentPlan;

import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;

/**
 * Check whether system has no port. This is a particular test, since it should be applied
 * whenever the user selects a "system" class for creating a deployment plan.
 * However, it is also useful to check at any time whether an mainInstance (in a deployment plan)
 * references a class that has ports.
 * 
 * @author ansgar
 *
 */
public class SystemHasNoPorts extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Package pkg = (Package) ctx.getTarget ();
		
		DeploymentPlan cdp = StUtils.getApplication(pkg, DeploymentPlan.class);
			
		if (cdp != null) {
			InstanceSpecification mi =  cdp.getMainInstance();
			Class class_ = (Class) DepUtils.getClassifier (mi);

			if (class_.getOwnedPorts ().size () > 0) {
        		return ctx.createFailureStatus ("The main instance (class '" + class_.getName () + "') of deployment plan '" + pkg.getName () + "' owns ports. It should not, since these ports remain unconnected.");
        	}
		}
		return ctx.createSuccessStatus();
	}
}
