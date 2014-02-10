/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire DUPE (Mia-Software) - initial API and implementation
 */
package org.eclipse.emf.facet.infra.facet.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.facet.infra.facet.FacetSet;

public class FacetSetName extends AbstractModelConstraint {

	@Override
	public IStatus validate(final IValidationContext ctx) {
		FacetSet facetSet = (FacetSet) ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			String fileName = facetSet.eResource().getURI().lastSegment();
			if (!fileName.equals(facetSet.getName() + ".facetSet")) { //$NON-NLS-1$
				return ctx.createFailureStatus(fileName, facetSet
						.getName());
			}
		}
		return ctx.createSuccessStatus();
	}

}
