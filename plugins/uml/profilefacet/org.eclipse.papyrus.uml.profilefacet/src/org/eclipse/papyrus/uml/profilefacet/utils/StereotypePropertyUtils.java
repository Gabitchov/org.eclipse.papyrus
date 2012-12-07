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
package org.eclipse.papyrus.uml.profilefacet.utils;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This class provides methods to found the real Property represented by a {@link StereotypePropertyElement}
 * 
 */
public class StereotypePropertyUtils {


	private StereotypePropertyUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param tableContext
	 *        the context of the table
	 * @param el
	 *        a stereotype property element
	 * @return
	 *         the property represented by the {@link StereotypePropertyElement} or <code>null</code> if not found
	 */
	public static final Property findRealStereotypeProperty(final Namespace namespace, final StereotypePropertyElement el) {
		final String propertyQualifiedName = el.getPropertyQualifiedName();
		for(final Profile profile : namespace.getNearestPackage().getAllAppliedProfiles()) {
			final List<NamedElement> properties = NameResolutionUtils.getNamedElements(propertyQualifiedName, profile, UMLPackage.eINSTANCE.getProperty());
			if(properties.size() == 1) {
				return (Property)properties.get(0);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param stereotypedElement
	 *        a stereotyped element
	 * @param el
	 *        a representation of the stereotype property
	 * @return
	 *         the feature represented by the {@link StereotypePropertyElement} or <code>null</code> if not found
	 */
	public static final EStructuralFeature getEStructuralFeature(final Element stereotypedElement, final StereotypePropertyElement el) {
		final EObject stereotypeApplication = getStereotypeApplication(stereotypedElement, el);
		if(stereotypeApplication != null) {
			final String propertyQN = el.getPropertyQualifiedName();
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			return stereotypeApplication.eClass().getEStructuralFeature(propertyName);
		}
		return null;
	}

	/**
	 * 
	 * @param stereotypedElement
	 *        a stereotyped element
	 * @param el
	 *        a feature representing a stereotype property
	 * @return
	 *         the steretoype application required by the stereotype property or <code>null</code> if not found
	 */
	public static final EObject getStereotypeApplication(final Element stereotypedElement, final StereotypePropertyElement el) {
		return getStereotypeApplication(stereotypedElement, (StereotypeFacet)el.eContainer());
	}

	/**
	 * 
	 * @param stereotypedElement
	 *        a stereotyped element
	 * @param facet
	 *        a facet
	 * @return
	 *         the stereotype application represented by the facet or <code>null</code> if not found
	 */
	public static final EObject getStereotypeApplication(final Element stereotypedElement, final StereotypeFacet facet) {
		final String steQN = facet.getStereotypeQualifiedName();
		final Stereotype ste = getAppliedStereotype(stereotypedElement, steQN);
		if(ste != null) {
			return stereotypedElement.getStereotypeApplication(ste);
		}
		return null;
	}

	/**
	 * 
	 * @param el
	 *        an element
	 * @param stereotypeQN
	 *        a stereotype qualified name
	 * @return
	 *         the stereotype represented by the qualified name or a stereotype which inherits of the stereotype identified by its qualifiedname or
	 *         <code>null</code> if not found
	 */
	public static final Stereotype getAppliedStereotype(final Element el, final String stereotypeQN) {
		final Stereotype appliedStereotype = el.getAppliedStereotype(stereotypeQN);
		if(appliedStereotype != null) {
			return appliedStereotype;
		} else if(appliedStereotype == null) {//the property can comes from inheritance...
			for(Stereotype appliedSte : el.getAppliedStereotypes()) {
				final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
				for(final Stereotype current : superClasses) {
					if(current.getQualifiedName().equals(stereotypeQN)) {
						return appliedSte;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param el
	 *        an element
	 * @param facet
	 *        the facet representing a stereotype
	 * @return
	 *         the stereotype represented by the facet or a sub-stereotype which inherits of the stereotype represented by a facet or
	 *         <code>null</code> if not found
	 */
	public static final Stereotype getAppliedStereotype(final Element el, final StereotypeFacet facet) {
		return getAppliedStereotype(el, facet.getStereotypeQualifiedName());
	}

	/**
	 * 
	 * @param el
	 *        an element
	 * @param facetElement
	 *        a facet element which represents a property of a stereotype
	 * @return
	 *         the stereotype required by the facet element or a sub-stereotype which inherits of the stereotype required by the facetElement or
	 *         <code>null</code> if not found
	 */
	public static final Stereotype getAppliedStereotype(final Element el, final StereotypePropertyElement facetElement) {
		return getAppliedStereotype(el, (StereotypeFacet)facetElement.eContainer());
	}
}
