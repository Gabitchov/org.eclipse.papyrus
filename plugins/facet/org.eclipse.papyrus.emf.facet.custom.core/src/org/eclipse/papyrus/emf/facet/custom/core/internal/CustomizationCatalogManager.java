/**
 *  Copyright (c) 2011-2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.internal.exception.CustomizationCatalogRuntimeException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationCatalog;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogFactory;
import org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet;

/**
 * Customization catalog implementation using the catalog manager features provided by the plug-in
 * org.eclipse.papyrus.emf.facet.util.emf.core
 * 
 * @author Gregoire Dupe
 * 
 */
public class CustomizationCatalogManager implements
		ICustomizationCatalogManager, ICatalogManager {

	private final CustomizationCatalog catalog = CustomizationcatalogFactory.eINSTANCE
			.createCustomizationCatalog();

	public boolean canBeManaged(final EObject root) {
		return root instanceof Customization;
	}

	public void manage(final EObject root) {
		if (root instanceof Customization) {
			Customization customization = (Customization) root;
			this.catalog.getInstalledEntries().add(customization);
		} else {
			throw new CustomizationCatalogRuntimeException("Only customizations (and aggregates) must be stored in the customization catalog"); //$NON-NLS-1$
		}
	}

	public void setCatalogSet(final CatalogSet catalogSet) {
		catalogSet.getCatalogs().add(this.catalog);
	}

	public List<Customization> getCustomizationsByName(final String name) {
		List<Customization> result = new ArrayList<Customization>();
		for (EObject eObject : this.catalog.getInstalledEntries()) {
			if (eObject instanceof Customization) {
				Customization customization = (Customization) eObject;
				if (name.equals(customization.getName())) {
					result.add(customization);
				}
			} else {
				throw new RuntimeException("Only customizations (and aggregates) must be stored in the customization catalog"); //$NON-NLS-1$
			}
		}
		return result;
	}

	public void registerCustomization(final Customization customization) {
		this.catalog.getInstalledEntries().add(customization);
	}

	public List<Customization> getCustomizationsApplicableOn(
			final Collection<EObject> eObjects) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Customization> getRegisteredCustomizations() {
		List<Customization> result = new ArrayList<Customization>();
		for (EObject eObject : this.catalog.getInstalledEntries()) {
			if (eObject instanceof Customization) {
				Customization customization = (Customization) eObject;
				result.add(customization);
			} else {
				throw new RuntimeException("Only customizations (and aggregates) must be stored in the customization catalog"); //$NON-NLS-1$
			}
		}
		return Collections.unmodifiableList(result);
	}

}
