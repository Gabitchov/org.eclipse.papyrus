/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.custom.core;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * This interface allows to access the customization catalog.
 * 
 * @author Gregoire Dupe
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationCatalogManager {

	/**
	 * This method is used to get all the registered customizations.
	 * 
	 * @return all the registered customizations (may contain aggregates)
	 */
	List<Customization> getRegisteredCustomizations();

	/**
	 * This method is used to get all the customization which can be applied on a list of
	 * eObjects and on the sub elements of those eObjects.
	 * 
	 * Inheritance is handled. For example, assuming meta-model A extends
	 * meta-model B, the customizations declared on meta-model B have to
	 * be available on the instances of meta-model A. Furthermore all
	 * customizations containing a customization of EObject have to be applicable
	 * on all the models.
	 * 
	 * @param eObjects the {@link EObject}s for which to get the applicable customizations
	 * @return a list of customizations
	 */
	List<Customization> getCustomizationsApplicableOn(
			Collection<EObject> eObjects);

	/**
	 * This method is used to register a customization which has not been declared through the
	 * regular way (extension point).
	 * 
	 * @param customization
	 *            the customization to register
	 */
	void registerCustomization(Customization customization);
	
}
