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
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Check whether the specific system class. This class can be identified, since it is the
 * classifier of the "main-instance" referenced by a deployment plan.
 *
 */
public class SystemHasNoPorts extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Package pkg = (Package) ctx.getTarget ();
		
		DeploymentPlan cdp = UMLUtil.getStereotypeApplication(pkg, DeploymentPlan.class);
			
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
