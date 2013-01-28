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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * Verify that an operation has at most one return parameter
 * @author ansgar
 *
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
					return ctx.createFailureStatus ("The operation '" + operation.getName () + "' has more than one return parameter. It must have at most one");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
