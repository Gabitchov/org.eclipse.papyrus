/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.profile.utils.ProfileConstraintUtils;
import org.eclipse.uml2.uml.Property;


public class PropertyMultiplicityLowerConstraint extends AbstractModelConstraint {

	public PropertyMultiplicityLowerConstraint() {
		super();
	}

	public IStatus validate(IValidationContext ctx) {

		if(ProfileConstraintUtils.isStereotypeProperty(ctx.getTarget())) {
			Property property = (Property)ctx.getTarget();

			if(!ProfileConstraintUtils.hasLowerMultiplicityRequired(property)) {
				return ctx.createFailureStatus(ctx.getTarget());
			}
		}

		return ctx.createSuccessStatus();
	}
}
