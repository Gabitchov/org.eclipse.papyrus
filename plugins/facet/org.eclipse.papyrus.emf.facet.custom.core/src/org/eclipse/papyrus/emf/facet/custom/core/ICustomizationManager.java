/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * This interface allows to access the customization manager. A customization
 * manager will compute the customization property depending on the loaded
 * customizations. Be careful, the load order has an impact on the customization
 * property value. Customizations are loaded in a stack. If there is a conflict
 * between two customizations, the higher customization (the nearest from the
 * top of the stack) gets the priority.
 * 
 * @author Gregoire Dupe
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationManager {
	
	/**
	 * This method is used to get the customization stack. The top
	 * customization in the stack will be the first in the list.
	 * 
	 * @return a mutable list of customizations
	 */
	List<Customization> getManagedCustomizations();

	/**
	 * This method is used to get the value of a customization property for a
	 * chosen eObject.
	 * 
	 * @param eObject
	 * @param customProperty
	 * @param classs
	 *            the expected result type
	 * @return a value having a type depending a the customizationProperty type.
	 *         (Can be null.)
	 */
	<T> T getCustomValueOf(EObject eObject,
			FacetOperation customProperty, Class<T> classs)
			throws CustomizationException;

	/**
	 * This method is used to get the value of a customization property for a
	 * chosen eObject and a chosen eStructuralFeature.
	 * 
	 * @param eObject
	 * @param structuralFeature
	 *            must not be null
	 * @param customProperty
	 *            must not be null
	 * @param classs
	 *            the expected result type
	 * @return a value having a type depending a the customizationProperty type.
	 *         (Can be null.)
	 */
	<T> T getCustomValueOf(EObject eObject,
			ETypedElement structuralFeature,
			FacetOperation customProperty, Class<T> classs)
			throws CustomizationException;

	/**
	 * This method returns the resourceSet used to manage the customization
	 * models.
	 */
	ResourceSet getResourceSet();

	IFacetManager getFacetManager();

}
