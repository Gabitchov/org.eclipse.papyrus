/**
 *  Copyright (c) 2011-2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Nicolas Bros (Mia-Software) - Bug 378271 - [Table] Select Columns To Hide is broken
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

public class CustomizationManager implements ICustomizationManager {

	private final HashSet<FacetOperation> customProperties = new HashSet<FacetOperation>();
	private final IFacetManager facetManager;

	public CustomizationManager(final ResourceSet resourceSet) {
		this.facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(resourceSet);
	}
	
	public CustomizationManager(final IFacetManager facetManager) {
		this.facetManager = facetManager;
	}

	public void addFrontManagedCustomization(final Customization customization) {
		this.facetManager.getManagedFacetSets().add(0, customization);
	}

	public void removeCustomization(final Customization customization) {
		this.facetManager.getManagedFacetSets().remove(customization);
	}

	public List<Customization> getManagedCustomizations() {
		return new CustomizationsDelegatingList(this.facetManager.getManagedFacetSets());
	}

	public <T> T getCustomValueOf(final EObject eObject,
			final FacetOperation customizationProperty,
			final Class<T> classs)
			throws CustomizationException {
		// Begin precondition checking section
		/* The scope of a customization property is not available yet in new customization meta-model
		if (!(customizationProperty.getScope().contains(
				CustomizationPropertyScope.ECLASS) || (customizationProperty
				.getScope().contains(CustomizationPropertyScope.FACET)))) {
			throw new RuntimeException(
					"The customization property is expected to be applicable on an EClass or on a Facet"); //$NON-NLS-1$
		}
		*/
		// End precondition checking section
		T result = null;
		try {
			// the structural feature : null
			final Object[] args = new Object[] { null };
			result = this.facetManager.invoke(eObject, customizationProperty,
					classs, null, args);
		} catch (final Exception e) {
			throw new CustomizationException(e);
		} 
		return result;
	}

	public <T> T getCustomValueOf(final EObject eObject,
			final ETypedElement eTypedElement,
			final FacetOperation customizationProperty,
			final Class<T> classs)
			throws CustomizationException {
		// Begin precondition checking section
		if (eObject == null) {
			throw new IllegalArgumentException(
					"The parameter 'eObject' must not be null."); //$NON-NLS-1$
		}
		if (customizationProperty == null) {
			throw new IllegalArgumentException(
					"The parameter 'customizationProperty' must not be null."); //$NON-NLS-1$
		}
		/* The scope of a customization property is not available yet in new customization meta-model
		if (!(eStructuralFeature instanceof EReference)) {
			if (customizationProperty.getScope().equals(
					CustomizationPropertyScope.EREFERENCE)) {
				throw new CustomizationException(
						"The eStructuralFeature is an instance of " //$NON-NLS-1$
								+ eStructuralFeature.getClass().getName()
								+ " but EReference is expected."); //$NON-NLS-1$
			}
		}

		if (!(eStructuralFeature instanceof EAttribute)) {
			if (customizationProperty.getScope().equals(
					CustomizationPropertyScope.EATTRIBUTE)) {
				throw new CustomizationException(
						"The eStructuralFeature is an instance of " //$NON-NLS-1$
								+ eStructuralFeature.getClass().getName()
								+ " but EAttribute is expected."); //$NON-NLS-1$
			}
		}
		*/
		// End precondition checking section
		try {
			return this.facetManager.invoke(eObject, customizationProperty, classs, null, new Object[] { eTypedElement });
		} catch (Exception e) {
			throw new CustomizationException(e);
		}
	}

	public List<FacetOperation> getCustomizationPropertiesByName(
			final String name) {
		if (name == null) {
			throw new IllegalArgumentException(
					"The parameter 'name' must not be null."); //$NON-NLS-1$
		}
		List<FacetOperation> results = new ArrayList<FacetOperation>();
		for (FacetOperation customizationProperty : this.customProperties) {
			if (name.equals(customizationProperty.getName())) {
				results.add(customizationProperty);
			}
		}
		return results;
	}

	public void addCustomization(final URI uri) {
		if (uri == null) {
			throw new IllegalArgumentException(
					"The parameter 'uri' must not be null."); //$NON-NLS-1$
		}
		Resource resource = this.facetManager.getResourceSet().getResource(uri, true);
		Iterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof FacetOperation) {
				FacetOperation customizationProperty = (FacetOperation) eObject;
				this.customProperties.add(customizationProperty);
			}
		}
	}

	public ResourceSet getResourceSet() {
		return this.facetManager.getResourceSet();
	}

	public void removeAllCustomizations() {
		List<Customization> customizationsToRemove = new LinkedList<Customization>();
		for (FacetSet facetSet : this.facetManager.getManagedFacetSets()) {
			if (facetSet instanceof Customization) {
				Customization customization = (Customization) facetSet;
				customizationsToRemove.add(customization);
			}
		}
		for (Customization customization : customizationsToRemove) {
			this.facetManager.getManagedFacetSets().remove(customization);
		}
	}

	public IFacetManager getFacetManager() {
		return this.facetManager;
	}
}
