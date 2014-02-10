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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.plugin.FacetPlugin;
import org.eclipse.emf.facet.util.core.Logger;

public class ExtendedClassValidation extends AbstractModelConstraint {

	@Override
	public IStatus validate(final IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		try {
			IStatus result = ctx.createSuccessStatus();
			if (eType == EMFEventType.NULL) {
				Facet facet = (Facet) eObject;
				List<EClass> superTypes = facet.getESuperTypes();
				for (EClass superType : superTypes) {
					boolean found = superType.getEPackage().getNsURI()
							.equals(EcorePackage.eINSTANCE.getNsURI());
					EPackage ePackage = ((FacetSet) facet.getEPackage()).getExtendedPackage();
					if (ePackage.getEClassifiers().contains(superType)) {
						found = true;
					}
					if (found) {
						result = ctx.createSuccessStatus();
					} else {
						result = ctx.createFailureStatus(superType.getName(), facet.getName());
						break;
					}
				}
			} else {
				result = ctx.createSuccessStatus();
			}
			return result;
		} catch (NullPointerException e) {
			String message = "Unexpected null value in " + eObject.eResource().getURI().toString(); //$NON-NLS-1$
			Logger.logWarning(e, message, FacetPlugin.getDefault());
			return ctx.createSuccessStatus();
		}
	}
}
