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
package org.eclipse.papyrus.uml.nattable.celleditor.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This class provides useful methods to manage stereotypes in the table
 * 
 */
public class UMLTableUtils {

	public static final String PROPERTY_OF_STEREOTYPE_PREFIX = "property_of_stereotype:/"; //$NON-NLS-1$

	private UMLTableUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param eobject
	 *        an element of the model (currently, if it is not an UML::Element, we can't find the property)
	 * @param id
	 *        the id used to identify the property of the stereotype
	 * @return
	 *         the UML::Property or <code>null</code> if we can't resolve it (the required profile is not applied)
	 */
	public static Property getRealStereotypeProperty(final EObject eobject, final String id) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		if(eobject instanceof Element) {
			final Element element = (Element)eobject;
			final String propertyQN = id.replace(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX, ""); //$NON-NLS-1$
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			final String stereotypeQN = NamedElementUtil.getParentQualifiedName(propertyQN);
			final String stereotypeName = NamedElementUtil.getNameFromQualifiedName(stereotypeQN);
			final String profileQN = NamedElementUtil.getParentQualifiedName(stereotypeQN);
			final Profile profile = element.getNearestPackage().getAppliedProfile(profileQN, true);
			if(profile != null) {
				final Stereotype ste = profile.getOwnedStereotype(stereotypeName);
				return (Property)ste.getMember(propertyName);
			}

		}
		return null;
	}

	/**
	 * 
	 * @param element
	 *        the UML::Element on which we are looking for applied Stereotype with the property identified by its id
	 * @param id
	 *        the id used to identify the property of the stereotype
	 * @return
	 *         the list of UML::Stereotype which have the property identified by this id and which are applied on the Element or <code>null</code> if
	 *         we can't resolve it (the required profile is not applied)
	 */
	public static final List<Stereotype> getAppliedSteretoypesWithThisProperty(final Element element, final String id) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		final List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		final Object prop = getRealStereotypeProperty(element, id);
		if(prop instanceof Property) {
			for(final Stereotype current : element.getAppliedStereotypes()) {
				if(current.getAllAttributes().contains(prop)) {
					stereotypes.add(current);
				}
			}
		}
		return stereotypes;
	}
}
