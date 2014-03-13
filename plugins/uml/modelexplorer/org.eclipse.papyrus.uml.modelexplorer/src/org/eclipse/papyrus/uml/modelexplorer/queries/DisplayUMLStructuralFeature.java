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
package org.eclipse.papyrus.uml.modelexplorer.queries;

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
import org.eclipse.papyrus.views.modelexplorer.queries.IsContainmentStructuralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
/**
 * this query is used to return false, if the  given object is a references that is not containment or if it is a attribute.
 * it return true if the the feature is also a facetReferences
 *
 */
public class DisplayUMLStructuralFeature extends IsContainmentStructuralFeature implements IJavaQuery2<EObject, Boolean>  {
	public Boolean evaluate(final EObject context, 
		final IParameterValueList2 parameterValues,
		final IFacetManager facetManager)
			throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature=(EStructuralFeature)parameterValue.getValue();
		// This is an UML element?
		if(context instanceof Element){
			
			
			//the eStructure is a containmentReference or Facet Reference?
			if(eStructuralFeature instanceof EReference){
				if(UMLPackage.eINSTANCE.getPackageImport_ImportedPackage().equals(eStructuralFeature)){
					return true;
				}
				if(UMLPackage.eINSTANCE.getElementImport_ImportedElement().equals(eStructuralFeature)){
					return true;
				}
				if(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(eStructuralFeature)){
					return false;
				}
				if(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(eStructuralFeature)){
					return false;
				}
				if(UMLPackage.eINSTANCE.getPackage_ProfileApplication().equals(eStructuralFeature)){
					return false;
				}
				if(UMLPackage.eINSTANCE.getBehavior_Postcondition().equals(eStructuralFeature)){
					return false;
				}
				if(UMLPackage.eINSTANCE.getBehavior_Precondition().equals(eStructuralFeature)){
					return false;
				}
				if(UMLPackage.eINSTANCE.getOperation_BodyCondition().equals(eStructuralFeature)){
					return false;
				}
			}

		}
		return super.evaluate(context, parameterValues, facetManager);
	}
}