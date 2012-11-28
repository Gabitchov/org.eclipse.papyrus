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
package org.eclipse.papyrus.uml.profilefacet.queries.getter;

import java.util.Collection;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.ArgumentUtils;
import org.eclipse.papyrus.uml.tools.utils.EnumerationUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.TypedElement;


public class GetUMLEnumerationSingleValue extends GetGenericSingleValue<EnumerationLiteral> {

	@Override
	public EnumerationLiteral evaluate(Element source, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(ArgumentUtils.EDITED_FEATURE).getValue();
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
					return EnumerationUtil.findEnumerationLiteral(type, (Enumerator)value);
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
								return EnumerationUtil.findEnumerationLiteral(type, (Enumerator)value);
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
