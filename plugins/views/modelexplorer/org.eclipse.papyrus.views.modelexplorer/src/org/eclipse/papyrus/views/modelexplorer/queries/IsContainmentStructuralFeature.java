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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
/**
 * this query is used to return false, if the  given object is a references that is not containment or if it is a attribute.
 * it return true if the the feature is also a facetReferences
 *
 */
public class IsContainmentStructuralFeature implements IJavaQuery2<EObject, Boolean> {
	public Boolean evaluate(final EObject context, 
		final IParameterValueList2 parameterValues,
		final IFacetManager facetManager)
			throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature=(EStructuralFeature)parameterValue.getValue();
		// This is an UML element?
		if(context instanceof EObject){
			//the eStructure is a containmentReference or Facet Reference?
			if(eStructuralFeature instanceof EReference){
				if( ((EReference)eStructuralFeature).equals(EcorePackage.eINSTANCE.getEModelElement_EAnnotations())){
					return false;
				}
				if(((EReference)(eStructuralFeature)).isContainment()||(eStructuralFeature instanceof FacetReference)){
					return true;
				}
				else{
					return false;
				}
			}
			//this is not a ref like EAttribute
			else{
				return false;
			}
		}
		//this is not a UML element
		return false;
	}
}
