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
import org.eclipse.uml2.uml.Operation;

/**
 * Check whether all operations are implemented
 * TODO? check whether signature has changed without an update of the implementation
 *   => warning (check is impossible since no history?).
 *   Better?: lift errors/warnings from compiler to model level, but that's a different task ...
 */
public class OperationsAreImplemented extends AbstractModelConstraint
{
	@Override
	public IStatus validate(IValidationContext ctx) {

		Class clazz = (Class) ctx.getTarget();
		for (Operation operation : clazz.getOwnedOperations ()) {
			if (!operation.isAbstract () && operation.getMethods ().size () == 0) {
				return ctx.createFailureStatus ("The operation '" + operation.getName () + "' of class '" +
						clazz.getName () + "' has no implementation (and is not marked as abstract)");
			}
		}
		return ctx.createSuccessStatus();
	}
}
