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
package org.eclipse.papyrus.uml.nattable.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.uml.nattable.paste.StereotypeApplicationStructure;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
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
	 * 
	 * @return
	 *         the UML::Property or <code>null</code> if we can't resolve it (the required profile is not applied)
	 */
	public static Property getRealStereotypeProperty(final EObject eobject, final String id) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		if(eobject instanceof Element) {
			final Element element = (Element)eobject;
			if(element.getNearestPackage() != null) {
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

		}
		return null;
	}

	/**
	 * 
	 * @param eobject
	 *        an element of the model (currently, if it is not an UML::Element, we can't find the property)
	 * @param id
	 *        the id used to identify the property of the stereotype
	 * @param sharedMap
	 *        a map owning interesting information, like {@link StereotypeApplicationStructure} which can be used to find stereotype, stereotype
	 *        application and so on
	 * @return
	 *         the UML::Property or <code>null</code> if we can't resolve it (the required profile is not applied)
	 */
	public static Property getRealStereotypeProperty(final EObject eobject, final String id, final Map<?, ?> sharedMap) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		if(eobject instanceof Element) {
			final Element element = (Element)eobject;
			final String propertyQN = id.replace(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX, ""); //$NON-NLS-1$
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			final String stereotypeQN = NamedElementUtil.getParentQualifiedName(propertyQN);
			final String stereotypeName = NamedElementUtil.getNameFromQualifiedName(stereotypeQN);
			final String profileQN = NamedElementUtil.getParentQualifiedName(stereotypeQN);
			final Package nearestPackage;
			if(sharedMap != null) {
				final Element context = (Element)sharedMap.get(Constants.PASTED_ELEMENT_CONTAINER_KEY);
				nearestPackage = context.getNearestPackage();
			} else {
				nearestPackage = element.getNearestPackage();
			}
			if(nearestPackage != null) {
				final Profile profile = nearestPackage.getAppliedProfile(profileQN, true);
				if(profile != null) {
					final Stereotype ste = profile.getOwnedStereotype(stereotypeName);
					return (Property)ste.getMember(propertyName);
				}
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
	 * 
	 * @return
	 *         the list of UML::Stereotype which have the property identified by this id and which are applied on the Element or <code>null</code> if
	 *         we can't resolve it (the required profile is not applied)
	 */
	public static final List<Stereotype> getAppliedStereotypesWithThisProperty(final Element element, final String id) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		final List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		if(element.eResource() != null) {
			final Object prop = getRealStereotypeProperty(element, id);
			if(prop instanceof Property) {
				for(final Stereotype current : element.getAppliedStereotypes()) {
					if(current.getAllAttributes().contains(prop)) {
						stereotypes.add(current);
					}
				}
			}
		}
		return stereotypes;
	}

	/**
	 * 
	 * @param element
	 *        the UML::Element on which we are looking for applied Stereotype with the property identified by its id
	 * @param id
	 *        the id used to identify the property of the stereotype
	 * 
	 * @return
	 *         the list of UML::Stereotype which have the property identified by this id and which are applied on the Element or <code>null</code> if
	 *         we can't resolve it (the required profile is not applied)
	 */
	public static final List<Stereotype> getApplicableStereotypesWithThisProperty(final Element element, final String id) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		final List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		if(element.eResource() != null) {
			final Object prop = getRealStereotypeProperty(element, id);
			if(prop instanceof Property) {
				for(final Stereotype current : element.getApplicableStereotypes()) {
					if(current.getAllAttributes().contains(prop)) {
						stereotypes.add(current);
					}
				}
			}
		}
		return stereotypes;
	}

	/**
	 * 
	 * @param element
	 *        the UML::Element on which we are looking for applied Stereotype with the property identified by its id
	 * @param id
	 *        the id used to identify the property of the stereotype
	 * @param sharedMap
	 *        a map owning interesting information, like {@link StereotypeApplicationStructure} which can be used to find stereotype, stereotype
	 *        application and so on
	 * @return
	 *         the list of UML::Stereotype which have the property identified by this id and which are applied on the Element or <code>null</code> if
	 *         we can't resolve it (the required profile is not applied)
	 */
	public static final List<Stereotype> getAppliedStereotypesWithThisProperty(final Element element, final String id, Map<?, ?> sharedMap) {
		assert id.startsWith(PROPERTY_OF_STEREOTYPE_PREFIX);
		final List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		if(sharedMap != null) {
			final List<StereotypeApplicationStructure> struct = findStereotypeApplicationDataStructure(element, id, sharedMap);
			if(struct != null) {
				for(final StereotypeApplicationStructure current : struct) {
					stereotypes.add(current.getStereotype());
				}
			}
		}
		if(element.eResource() != null) {
			final Object prop = getRealStereotypeProperty(element, id, sharedMap);
			if(prop instanceof Property) {
				for(final Stereotype current : element.getAppliedStereotypes()) {
					if(current.getAllAttributes().contains(prop)) {
						stereotypes.add(current);
					}
				}
			}
		}
		return stereotypes;
	}
	
	/**
	 * 
	 * @param editedElement
	 *        the edited element
	 * @param id
	 *        the id of the edited stereotype feature
	 * @param sharedMap
	 *        a map owning interesting information, like {@link StereotypeApplicationStructure} which can be used to find stereotype, stereotype
	 *        application and so on
	 * @return
	 *         the list of the found data structure or <code>null</code> if not found
	 */
	public static final List<StereotypeApplicationStructure> findStereotypeApplicationDataStructure(final Element editedElement, final String id, final Map<?, ?> sharedMap) {
		//TODO : enhance the data structure to look for an editedElement + a propQn as Key!
		@SuppressWarnings("unchecked")
		List<StereotypeApplicationStructure> list = (List<StereotypeApplicationStructure>)sharedMap.get(editedElement);
		if(list != null && !list.isEmpty()) {
			final String propertyQN = id.replace(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX, ""); //$NON-NLS-1$
			for(final StereotypeApplicationStructure current : list) {
				if(current.getProperty().getQualifiedName().equals(propertyQN)) {
					return Collections.singletonList(current);//TODO : doesn't manage when several stereotype with the same property are applied
				}
			}
		}
		return null;
	}
}
