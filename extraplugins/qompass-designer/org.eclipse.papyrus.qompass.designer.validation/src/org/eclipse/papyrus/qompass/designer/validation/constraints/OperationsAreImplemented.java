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
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;

/**
 * Check whether a non abstract operation has an implementation.
 * Whereas this rule would make sense in general, it has been made specific to
 * Qompass by verifying whether FCM is applied (check if DerivedElement stereotype
 * is applicable)
 */
public class OperationsAreImplemented extends AbstractModelConstraint
{
	@Override
	public IStatus validate(IValidationContext ctx) {

		Operation operation = (Operation) ctx.getTarget();
		if(operation.getNamespace() instanceof Interface) {
			// operations within an interface are always abstract
			return ctx.createSuccessStatus();
		}
		if((!operation.isAbstract() && operation.getMethods().size() == 0) && StereotypeUtil.isApplicable(operation, DerivedElement.class)) {
			return ctx.createFailureStatus ("The operation '" + operation.getName () +
				" has no implementation (and is not marked as abstract)");
		}
		return ctx.createSuccessStatus();
	}
}
