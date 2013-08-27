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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.BootLoaderGen;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;

/**
 * Verify that at exactly one blocking start routine is defined.
 * 
 * @author ansgar
 * 
 */
public class InitialEntryPoints extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Package pkg = (Package)ctx.getTarget();

		DeploymentPlan cdp = StUtils.getApplication(pkg, DeploymentPlan.class);
		if(cdp != null) {
			InstanceSpecification initIS = cdp.getMainInstance();
			if(initIS != null) {
				entryPoints = new BasicEList<String>();
				validate(initIS);
				if(entryPoints.size() > 1) {
					String msg = ""; //$NON-NLS-1$
					for(String entryPoint : entryPoints) {
						if(msg.length() > 0) {
							msg += ", "; //$NON-NLS-1$
						}
						msg += entryPoint;
					}
					return ctx.createFailureStatus("The deployment plan '" + pkg.getName() + "' contains more than one start entry point: " + msg); //$NON-NLS-1$
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	public void validate(InstanceSpecification is) {
		Classifier cl = DepUtils.getClassifier(is);
		if(cl instanceof Class) {
			Class implementation = (Class)cl;
			if(BootLoaderGen.hasUnconnectedStartRoutine(null, implementation, null)) {
				entryPoints.add(implementation.getName());
			}
		}
		for(InstanceSpecification subIS : DepUtils.getContainedInstances(is)) {
			validate(subIS);
		}
	}

	private EList<String> entryPoints;
}
