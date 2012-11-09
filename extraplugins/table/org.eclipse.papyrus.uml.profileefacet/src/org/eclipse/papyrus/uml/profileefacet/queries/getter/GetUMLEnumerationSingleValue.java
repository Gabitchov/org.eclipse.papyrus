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
package org.eclipse.papyrus.uml.profileefacet.queries.getter;

import java.util.Collection;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profileefacet.utils.Constants;
import org.eclipse.papyrus.uml.profileefacet.utils.EnumerationUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.TypedElement;


public class GetUMLEnumerationSingleValue extends GetGenericSingleValue<EnumerationLiteral> {

	public EnumerationLiteral evaluate(final Element source, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(Constants.EDITED_FEATURE).getValue();
		if(element != null) {
			final EObject container = element.eContainer();
			assert container instanceof StereotypeFacet;
			final StereotypeFacet facet = (StereotypeFacet)container;
			final String stereotypeQN = facet.getStereotypeQualifiedName();
			final Stereotype appliedStereotype = source.getAppliedStereotype(stereotypeQN);
			final String propertyQN = element.getPropertyQualifiedName();
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			if(appliedStereotype != null) {
				final Object value = source.getValue(appliedStereotype, propertyName);
				if(value instanceof Enumerator) {
					final Enumeration type = (Enumeration)((TypedElement)appliedStereotype.getOwnedMember(propertyName)).getType();
					return EnumerationUtils.findEnumerationLiteral(type, (Enumerator)value);
				}
				return (EnumerationLiteral)value;
			} else if(appliedStereotype == null) {//the property can comes from inheritance...
				for(Stereotype appliedSte : source.getAppliedStereotypes()) {
					final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
					for(final Stereotype current : superClasses) {
						if(current.getQualifiedName().equals(stereotypeQN)) {
							final Object value = source.getValue(appliedSte, propertyName);
							if(value instanceof Enumerator) {
								final Enumeration type = (Enumeration)((TypedElement)current.getOwnedMember(propertyName)).getType();
								return EnumerationUtils.findEnumerationLiteral(type, (Enumerator)value);
							}
							return (EnumerationLiteral)value;
						}
					}
				}
			}
		}

		return null;
	}
	
}
