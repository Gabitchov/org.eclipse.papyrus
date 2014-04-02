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

public class EmptyReferenceAndAttributeNotVisibleQuery implements IJavaQuery2<EObject, Boolean> {
	public Boolean evaluate(final EObject context, 
		final IParameterValueList2 parameterValues,
		final IFacetManager facetManager)
			throws DerivedTypedElementException {
//		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eStructuralFeature");
//		EStructuralFeature eStructuralFeature=(EStructuralFeature)parameterValue.getValue();
//		if(!(eStructuralFeature instanceof FacetReference)){
//		if( eStructuralFeature instanceof EAttribute){
//			return false;
//		}
//		System.err.println(context.eGet(eStructuralFeature));
//		if( eStructuralFeature instanceof EReference){
//			if( context.eGet(eStructuralFeature)==null){
//			return false;
//			}
//				
//			if( context.eGet(eStructuralFeature) instanceof Collection){
//				if(((Collection)context.eGet(eStructuralFeature)).size()==0){
//					return false;
//				}
//			}
//		}
//		}
//		return true;
		return false;
	}
}
