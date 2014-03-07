/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;

public class DiagramsRefCollapseQuery implements IJavaQuery2<EObject, Boolean> {
	public Boolean evaluate(final EObject context, 
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature=(EStructuralFeature)parameterValue.getValue();
		if((eStructuralFeature instanceof FacetReference)&&("diagrams".equals((eStructuralFeature).getName()))){
			return true;
		}
		return false;
	}
}
