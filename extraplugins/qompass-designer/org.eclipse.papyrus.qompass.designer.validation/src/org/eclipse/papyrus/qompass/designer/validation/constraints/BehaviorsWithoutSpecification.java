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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * Check whether all behaviors have a specification. This happens for instance, if the user
 * deletes a specification and "forgets" to delete the associated behavior.
 * 
 * @author ansgar
 *
 */
public class BehaviorsWithoutSpecification extends AbstractModelConstraint {
	
	@Override
	public IStatus validate(IValidationContext ctx) {

		OpaqueBehavior behavior = (OpaqueBehavior) ctx.getTarget();

		if (behavior.getSpecification () == null) {
			Element class_ = behavior.getOwner ();
			if (class_ instanceof NamedElement) {
				return ctx.createFailureStatus ("The behavior '" + behavior.getName () + "' of '" +
						((NamedElement) class_).getQualifiedName() + "' has no specification");
			}
			else {
				return ctx.createFailureStatus ("The behavior '" + behavior.getName () + "' has no specification");
			}
		}
		else {
			return ctx.createSuccessStatus();
		}
	}
}
