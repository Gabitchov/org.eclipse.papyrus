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
import org.eclipse.uml2.uml.Property;

/**
 * Check whether all operations are implemented
 * TODO: change name - will serve same purpose, since operations of provided ports are automatically added
 * TODO? further tests: check whether implementation is good for target?
 * TODO? impossible since no history? check whether signature has changed without an update of the
 * 	implementation => warning. Better: lift errors/warnings from compiler to model level, but that's a different
 *  task ...
 * @author ansgar
 *
 */
public class ExecutorIsNotUsedAsPartName extends AbstractModelConstraint
{
	@Override
	public IStatus validate(IValidationContext ctx) {

		Class class_ = (Class) ctx.getTarget();

		for (Property attribute : class_.getOwnedAttributes ()) {
			if (attribute.getName().equals ("_executor")) {
				return ctx.createFailureStatus ("A property may not use the reserved name \"_executor\"");
			}
		}
		return ctx.createSuccessStatus();
	}
}
