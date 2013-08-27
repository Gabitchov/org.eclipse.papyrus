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
import org.eclipse.papyrus.qompass.designer.core.StUtils;
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
			if (StUtils.isApplicable(class_, DerivedElement.class)) {
				// check whether DerivedElement is applicable => indirect check whether FCM is applied (make rule specific to Qompass)
				// TODO alternative? check whether behavior is referenced from either an activity, since that is possible in general?
				/*
				boolean hasRef = false;
				for (Setting setting : UML2Util.getNonNavigableInverseReferences(behavior)) {
					if (setting.getEObject() ...
						hasRefFromIS = true;
						break;
					}	
				}
				*/
				if (class_ instanceof NamedElement) {
					return ctx.createFailureStatus ("The behavior '" + behavior.getName () + "' of '" +
							((NamedElement) class_).getQualifiedName() + "' has no specification");
				}
				else {
					return ctx.createFailureStatus ("The behavior '" + behavior.getName () + "' has no specification");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
