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
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerTrafo;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

/**
 * Check whether an attribute used the name that is reserved for executors within a container
 * 
 *
 */
public class ExecutorIsNotUsedAsPartName extends AbstractModelConstraint
{
	@Override
	public IStatus validate(IValidationContext ctx) {

		Class class_ = (Class) ctx.getTarget();

		if (StereotypeUtil.isApplied(class_, RuleApplication.class)) {
			// limit check to classes applying a container rule.
			for (Property attribute : class_.getOwnedAttributes ()) {
				if (attribute.getName().equals(ContainerTrafo.executorPartName)) {
					return ctx.createFailureStatus ("A property may not use the reserved name \"_executor\"");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
