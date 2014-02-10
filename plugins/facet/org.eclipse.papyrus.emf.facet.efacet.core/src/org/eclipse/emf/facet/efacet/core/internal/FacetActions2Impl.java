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
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Gregoire Dupe (Mia-Software) - Bug 362087 - [Deprecated] org.eclipse.emf.facet.util.emf.core.ICatalogSetManager
 */
package org.eclipse.emf.facet.efacet.core.internal;

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
import org.eclipse.emf.facet.efacet.core.internal.incubatingapi.IFacetActions2;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager2;
import org.eclipse.emf.facet.util.emf.core.exception.InvalidFacetSetException;
import org.eclipse.emf.facet.util.pde.core.internal.exported.BuildPropertiesUtils;

public class FacetActions2Impl implements IFacetActions2 {

	public void saveFacetSet(final FacetSet facetSet, final IFile file) throws IOException,
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
		ICatalogSetManager2.INSTANCE.registerModelDeclaration(file);
	}

	public Facet createFacetInFacetSet(final FacetSet facetSet, final Facet facet,
			final EditingDomain editingDomain) {
		Command command = createCreateFacetInFacetSetCommand(facetSet, facet, editingDomain);
		// If the current editingDomain's resourceSet does not contain the facetSet resource, then
		// we need to add it so that we can edit the facetSet
		if (!editingDomain.getResourceSet().getResources().contains(facetSet.eResource())) {
			editingDomain.getResourceSet().getResources().add(facetSet.eResource());
		}
		editingDomain.getCommandStack().execute(command);
		return facet;
	}

	public Command createCreateFacetInFacetSetCommand(final FacetSet facetSet, final Facet facet,
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

		return AddCommand.create(editingDomain, facetSet,
				EcorePackage.eINSTANCE.getEPackage_EClassifiers(), facet);
	}

	public void addAttributeInFacet(final Facet facet, final FacetAttribute facetAttribute,
			final EditingDomain editingDomain) {
		Command command = createAddAttributeInFacetCommand(facet, facetAttribute, editingDomain);
		editingDomain.getCommandStack().execute(command);
	}

	public Command createAddAttributeInFacetCommand(final Facet facet,
			final FacetAttribute facetAttribute, final EditingDomain editingDomain) {
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

		return AddCommand.create(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetElements(), facetAttribute);
	}

	public void addReferenceInFacet(final Facet facet, final FacetReference facetReference,
			final EditingDomain editingDomain) {
		Command command = createAddReferenceInFacetCommand(facet, facetReference, editingDomain);
		editingDomain.getCommandStack().execute(command);
	}

	public Command createAddReferenceInFacetCommand(final Facet facet,
			final FacetReference facetReference, final EditingDomain editingDomain) {
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

		return AddCommand.create(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetElements(), facetReference);
	}

	public void addOperationInFacet(final Facet facet, final FacetOperation facetOperation,
			final EditingDomain editingDomain) {
		Command command = createAddOperationInFacetCommand(facet, facetOperation, editingDomain);
		editingDomain.getCommandStack().execute(command);
	}

	public Command createAddOperationInFacetCommand(final Facet facet,
			final FacetOperation facetOperation, final EditingDomain editingDomain) {
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

		return AddCommand.create(editingDomain, facet,
				EFacetPackage.eINSTANCE.getFacet_FacetOperations(), facetOperation);
	}

	public void addParameterInOperation(final FacetOperation operation, final EParameter parameter,
			final EditingDomain editingDomain) {
		Command command = createAddParameterInOperationCommand(operation, parameter, editingDomain);
		editingDomain.getCommandStack().execute(command);
	}

	public Command createAddParameterInOperationCommand(final FacetOperation operation,
			final EParameter parameter, final EditingDomain editingDomain) {
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

		return AddCommand.create(editingDomain, operation,
				EcorePackage.eINSTANCE.getEOperation_EParameters(), parameter);
	}

	public void setFacetSetNsUri(final FacetSet facetSet, final String nsUri,
			final EditingDomain editingDomain) {
		Command command = createSetFacetSetNsUriCommand(facetSet, nsUri, editingDomain);
		editingDomain.getCommandStack().execute(command);
	}

	public Command createSetFacetSetNsUriCommand(final FacetSet facetSet, final String nsUri,
			final EditingDomain editingDomain) {
		if (editingDomain == null) {
			throw new IllegalArgumentException("The given EditingDomain cannot be null"); //$NON-NLS-1$
		}
		if (facetSet == null) {
			throw new IllegalArgumentException("The given FacetSet cannot be null"); //$NON-NLS-1$
		}
		return SetCommand.create(editingDomain, facetSet,
				EcorePackage.eINSTANCE.getEPackage_NsURI(), nsUri);
	}
}
