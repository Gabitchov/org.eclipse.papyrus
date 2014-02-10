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

import java.util.HashSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.facet.infra.facet.FacetSet;

public class UniqueName extends AbstractModelConstraint {

	@Override
	public IStatus validate(final IValidationContext ctx) {
		HashSet<String> names = new HashSet<String>();
		FacetSet facetSet = (FacetSet) ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			for (EClassifier eClassifier : facetSet.getEClassifiers()) {
				if (names.contains(eClassifier.getName())) {
					return ctx.createFailureStatus(eClassifier.getName());
				}
				names.add(eClassifier.getName());
			}
		}
		return ctx.createSuccessStatus();
	}

}
