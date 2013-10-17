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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * Verify that an operation has at most one return parameter
 *
 * Whereas this rule would make sense in general, it has been made specific to
 * Qompass by verifying whether FCM is applied (check if DerivedElement stereotype
 * is applicable)
 */
public class OperationsWithTwoReturnValues extends AbstractModelConstraint
{
	@Override
	public IStatus validate (IValidationContext ctx)
	{
		Operation operation = (Operation) ctx.getTarget();
		boolean firstReturn = true;
		for (Parameter parameter : operation.getOwnedParameters ()) {
			if (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				if (firstReturn) {
					firstReturn = false;
				}
				else {
					if (StereotypeUtil.isApplicable(operation, DerivedElement.class)) {
						return ctx.createFailureStatus ("The operation '" + operation.getName () + "' has more than one return parameter. It must have at most one");
					}
					else {
						break;
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
