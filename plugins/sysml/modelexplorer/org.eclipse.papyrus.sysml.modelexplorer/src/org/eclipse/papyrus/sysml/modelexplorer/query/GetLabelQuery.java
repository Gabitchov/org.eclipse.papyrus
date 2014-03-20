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
package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.NamedElement;

/** Create a basic label based on element name */
public class GetLabelQuery implements IJavaQuery2<NamedElement, String> {

	public static final String UNNAMED = "";


	@Override
	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eObject");
		if(parameterValue.getValue() instanceof EStructuralFeature){
			return ((EStructuralFeature)parameterValue.getValue()).getName();
		}
		
		String label = UNNAMED;
		if(source.isSetName() && (!"".equals(source.getName().trim()))) {
			label = source.getName();
		}
		return label;
	}
}
