/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.queries.setter;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;


public class SetGenericSingleValue<R> implements IJavaModelQuery<Element, R> {


	//FIXME : maybe we should implements IJavaModelQueryWithEditingDomain
	public R evaluate(Element source, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		//FIXME
		//		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(Constants.EDITED_FEATURE).getValue();
		//		if(element != null) {
		//			final EObject container = element.eContainer();
		//			assert container instanceof StereotypeFacet;
		//			final StereotypeFacet facet = (StereotypeFacet)container;
		//			final String stereotypeQN = facet.getStereotypeQualifiedName();
		//			final Stereotype appliedStereotype = source.getAppliedStereotype(stereotypeQN);
		//			final String propertyQN = element.getPropertyQualifiedName();
		//			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
		//			if(appliedStereotype != null) {
		//				return (R)source.getValue(appliedStereotype, propertyName);
		//			} else if(appliedStereotype == null) {//the property can comes from inheritance...
		//				for(Stereotype appliedSte : source.getAppliedStereotypes()) {
		//					final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
		//					for(final Stereotype current : superClasses) {
		//						if(current.getQualifiedName().equals(stereotypeQN)) {
		//							return (R)source.getValue(appliedSte, propertyName);
		//						}
		//					}
		//				}
		//
		//			}
		//		}

		return null;
	}

	//	public R evaluate(final Element source, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
	//		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(Constants.EDITED_FEATURE).getValue();
	//		if(element != null) {
	//			final EObject container = element.eContainer();
	//			assert container instanceof StereotypeFacet;
	//			final StereotypeFacet facet = (StereotypeFacet)container;
	//			final String stereotypeQN = facet.getStereotypeQualifiedName();
	//			final Stereotype appliedStereotype = source.getAppliedStereotype(stereotypeQN);
	//			final String propertyQN = element.getPropertyQualifiedName();
	//			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
	//			if(appliedStereotype != null) {
	//				return (R)source.getValue(appliedStereotype, propertyName);
	//			} else if(appliedStereotype == null) {//the property can comes from inheritance...
	//				for(Stereotype appliedSte : source.getAppliedStereotypes()) {
	//					final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
	//					for(final Stereotype current : superClasses) {
	//						if(current.getQualifiedName().equals(stereotypeQN)) {
	//							return (R)source.getValue(appliedSte, propertyName);
	//						}
	//					}
	//				}
	//
	//			}
	//		}
	//	
	//		return null;
	//	}

}
