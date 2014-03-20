/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 338813 - [EMF Facet Framework] basic Facet actions
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetAction;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogSetManager;
import org.eclipse.papyrus.emf.facet.util.emf.core.exception.InvalidFacetSetException;
import org.eclipse.papyrus.emf.facet.util.pde.core.internal.exported.BuildPropertiesUtils;

/** @deprecated */
@Deprecated
public class FacetActionImpl implements IFacetAction {

	public Facet createFacetInFacetSet(final FacetSet facetSet, final Facet facet,
			final EditingDomain editingDomain) {

		if (facetSet == null) {
			throw new IllegalArgumentException("The given FacetSet cannot be null"); //$NON-NLS-1$
		}
		if (facet == null) {
			throw new IllegalArgumentException("The given Facet cannot be null"); //$NON-NLS-1$
		}
		if (facet.eResource() != null || facet.eContainer() != null) {
			throw new IllegalArgumentException("The given Facet cannot be contained by a resource"); //$NON-NLS-1$
		}
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}

		// If the current editingDomain's resourceSet does not contain the facetSet resource, then
		// we need to add it so that we can edit the facetSet
		if (!editingDomain.getResourceSet().getResources().contains(facetSet.eResource())) {
			editingDomain.getResourceSet().getResources().add(facetSet.eResource());
		}

		Command command = new AddCommand(editingDomain, facetSet,
				EFacetPackage.eINSTANCE.getFacetSet_Facets(), facet);
		editingDomain.getCommandStack().execute(command);
		return facet;
	}

	public void addAttributeInFacet(final Facet facet, final FacetAttribute facetAttribute,
			final EditingDomain editingDomain) {

		if (facet == null) {
			throw new IllegalArgumentException("The given Facet cannot be null"); //$NON-NLS-1$
		}
		if (facetAttribute == null) {
			throw new IllegalArgumentException("The given FacetAttribute cannot be null"); //$NON-NLS-1$
		}
		if (facetAttribute.eResource() != null || facetAttribute.eContainer() != null) {
			throw new IllegalArgumentException(
					"The given FacetAttribute cannot be contained by a resource"); //$NON-NLS-1$
		}
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}

		Command command = new AddCommand(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetElements(), facetAttribute);
		editingDomain.getCommandStack().execute(command);
	}

	public void addReferenceInFacet(final Facet facet, final FacetReference facetReference,
			final EditingDomain editingDomain) {
		if (facet == null) {
			throw new IllegalArgumentException("The given Facet cannot be null."); //$NON-NLS-1$
		}
		if (facetReference == null) {
			throw new IllegalArgumentException("The given FacetReference cannot be null"); //$NON-NLS-1$
		}
		if (facetReference.eResource() != null || facetReference.eContainer() != null) {
			throw new IllegalArgumentException(
					"The given FacetReference cannot be contained by a resource"); //$NON-NLS-1$
		}
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null."); //$NON-NLS-1$
		}

		Command command = new AddCommand(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetElements(), facetReference);
		editingDomain.getCommandStack().execute(command);
	}

	public void addOperationInFacet(final Facet facet, final FacetOperation facetOperation,
			final EditingDomain editingDomain) {
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}
		if (facetOperation == null) {
			throw new IllegalArgumentException("The given FacetOperation cannot be null"); //$NON-NLS-1$
		}
		if (facetOperation.eResource() != null || facetOperation.eContainer() != null) {
			throw new IllegalArgumentException(
					"The given FacetOperation cannot be contained by a resource"); //$NON-NLS-1$
		}
		if (facet == null) {
			throw new IllegalArgumentException("The given Facet cannot be null"); //$NON-NLS-1$
		}

		Command command = new AddCommand(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetElements(), facetOperation);
		editingDomain.getCommandStack().execute(command);
	}

	public void setFacetSetNsUri(final FacetSet facetSet, final String nsUri,
			final EditingDomain editingDomain) {
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}
		if (facetSet == null) {
			throw new IllegalArgumentException("The given FacetSet cannot be null"); //$NON-NLS-1$
		}
		Command command = new SetCommand(editingDomain, facetSet,
				EcorePackage.eINSTANCE.getEPackage_NsURI(), nsUri);
		editingDomain.getCommandStack().execute(command);
	}

	public void addParameterInOperation(final FacetOperation operation, final EParameter parameter,
			final EditingDomain editingDomain) {
		if (operation == null) {
			throw new IllegalArgumentException("The given FacetOperation cannot be null"); //$NON-NLS-1$
		}
		if (parameter == null) {
			throw new IllegalArgumentException("The given EParameter cannot be null"); //$NON-NLS-1$
		}
		if (parameter.eResource() != null || parameter.eContainer() != null) {
			throw new IllegalArgumentException(
					"The given EParameter cannot be contained by a resource"); //$NON-NLS-1$
		}
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}

		Command command = new AddCommand(editingDomain, operation,
				EcorePackage.eINSTANCE.getEOperation_EParameters(), parameter);
		editingDomain.getCommandStack().execute(command);
	}

	public void createFacetSet(final FacetSet facetSet, final IFile file) throws IOException,
			InvalidFacetSetException {
		if (facetSet == null) {
			throw new IllegalArgumentException("The given FacetSet cannot be null"); //$NON-NLS-1$
		}
		if (file == null) {
			throw new IllegalArgumentException("The given IFile cannot be null"); //$NON-NLS-1$
		}
		if (file.exists()) {
			throw new IllegalArgumentException("The given IFile already exists"); //$NON-NLS-1$
		}

		// Create a resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		// Add the facetSet the resource contents.
		resource.getContents().add(facetSet);

		// Save the contents of the resource to the file system.
		resource.save(null);

		try {
			BuildPropertiesUtils.addToBuild(file);
		} catch (Exception e) {
			Logger.logError(e, "Error adding file " + file.getFullPath() //$NON-NLS-1$
					+ " to the build.properties", Activator.getDefault()); //$NON-NLS-1$
		}
		ICatalogSetManager.INSTANCE.registerModelDeclaration(file);
	}
}
