/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal.query;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;

/**
 * Determines the default value for visibility
 *
 * False for EAttributes and empty references, true otherwise
 *
 * Default implementation in EMF Facet is always true (TrueLiteralQuery)
 *
 * @author Camille Letavernier
 *
 */
public class DefaultVisibilityQuery implements IJavaQuery2<EObject, Boolean> {

	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue paramValue = parameterValues.getParameterValueByName("eStructuralFeature");
		if(paramValue == null) {
			return true;
		}

		EStructuralFeature feature = (EStructuralFeature)paramValue.getValue();

		if(feature == null) {
			return true;
		}

		if(feature instanceof EAttribute) {
			return false;
		}

		if(feature instanceof FacetReference) {
			return true;
		}

		if(feature instanceof EReference) {
			Object value = source.eGet(feature);
			if(value == null) {
				return false;
			}
			if(value instanceof Collection<?>) {
				return !((Collection<?>)value).isEmpty();
			}
		}

		return true;
	}

}
