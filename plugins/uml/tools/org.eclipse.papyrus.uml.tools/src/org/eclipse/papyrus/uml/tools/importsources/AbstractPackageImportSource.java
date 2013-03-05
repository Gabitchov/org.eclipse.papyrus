/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the AbstractPackageImportSource type. Enjoy.
 */
public abstract class AbstractPackageImportSource
		implements IPackageImportSource {

	private ILabelProvider labelProvider;

	private IStaticContentProvider contentProvider;

	public AbstractPackageImportSource() {
		super();
	}

	public boolean canImportInto(Collection<?> selection) {
		return getPackage(selection) != null;
	}

	public void initialize(Collection<?> selection) {
		// pass
	}

	protected Package getPackage(Collection<?> selection) {
		Package result = null;

		for (Object next : selection) {
			if (next instanceof Package) {
				result = (Package) next;
				break;
			} else if (next instanceof IAdaptable) {
				Object adapter = ((IAdaptable) next).getAdapter(EObject.class);
				if (adapter instanceof Package) {
					result = (Package) adapter;
				}
			}
		}

		return result;
	}

	public final ILabelProvider getModelHierarchyLabelProvider() {
		if (labelProvider == null) {
			labelProvider = createModelHierarchyLabelProvider();
		}

		return labelProvider;
	}

	protected ILabelProvider createModelHierarchyLabelProvider() {
		return WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
	}

	public final IStaticContentProvider getModelHierarchyContentProvider() {
		if (contentProvider == null) {
			contentProvider = createModelHierarchyContentProvider();
		}

		return contentProvider;
	}

	protected abstract IStaticContentProvider createModelHierarchyContentProvider();

	protected String getText(Object object) {
		return getModelHierarchyLabelProvider().getText(object);
	}

	public List<Package> getPackages(ResourceSet resourceSet, Object model)
			throws CoreException {

		List<Package> result;

		Resource resource = null;

		validateSelection(model);

		try {
			if (model instanceof Resource) {
				resource = (Resource) model;
				if (!resource.isLoaded()) {
					resource.load(null);
				}
			} else if (model instanceof IFile) {
				IFile file = (IFile) model;
				resource = resourceSet.getResource(URI
					.createPlatformResourceURI(file.getFullPath().toString(),
						true), true);
			} else if (model instanceof URI) {
				resource = resourceSet.getResource((URI) model, true);
			}
		} catch (Exception e) {
			// resource load failed
			throw new CoreException(new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, NLS.bind(
					"Failed to load packages from resource \"{0}\".",
					getText(model)), e));
		}

		if (resource == null) {
			throw new CoreException(new Status(IStatus.WARNING,
				Activator.PLUGIN_ID, NLS.bind(
					"Could not determine a model resource for \"{0}\".",
					getText(model))));
		} else {
			validateResource(resource, model);

			result = new java.util.ArrayList<Package>(
				EcoreUtil.<Package> getObjectsByType(resource.getContents(),
					UMLPackage.Literals.PACKAGE));
		}

		if (result.isEmpty()) {
			throw new CoreException(new Status(IStatus.WARNING,
				Activator.PLUGIN_ID, NLS.bind(
					"No packages found in resource \"{0}\".", getText(model))));
		}

		return result;
	}

	protected void validateSelection(Object model)
			throws CoreException {
		// pass
	}

	protected void validateResource(Resource resource, Object model)
			throws CoreException {

		if (resource.getContents().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, NLS.bind(
					"The model resource is empty: \"{0}\".", getText(model))));
		}
	}

	public void dispose() {
		if (labelProvider != null) {
			labelProvider.dispose();
			labelProvider = null;
		}

		if (contentProvider != null) {
			contentProvider.dispose();
			contentProvider = null;
		}
	}

}
