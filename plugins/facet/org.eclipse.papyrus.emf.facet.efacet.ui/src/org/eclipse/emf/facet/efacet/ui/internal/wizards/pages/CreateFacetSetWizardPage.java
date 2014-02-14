/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal.wizards.pages;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.CreateFacetSetWizardImpl;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.pde.core.internal.exported.PluginUtils;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class CreateFacetSetWizardPage extends WizardNewFileCreationPage {

	public CreateFacetSetWizardPage(final String pageId, final IStructuredSelection selection) {
		super(pageId, selection);

		setTitle(Messages.CreateFacetSetWizardImpl_FacetModel);
		setDescription(Messages.CreateFacetSetWizardImpl_Create_new_facet_Set);
		setFileName("My" //$NON-NLS-1$
				+ "." + CreateFacetSetWizardImpl.FILE_EXTENSION); //$NON-NLS-1$

		// Try and get the resource selection to determine a current directory
		// for the file dialog.
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = "My"; //$NON-NLS-1$
					String defaultModelFilenameExtension = CreateFacetSetWizardImpl.FILE_EXTENSION;
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension; //$NON-NLS-1$
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension; //$NON-NLS-1$
					}
					setFileName(modelFilename);
				}
			}
		}
	}

	@Override
	protected boolean validatePage() {
		boolean valid = super.validatePage();

		if (valid) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !CreateFacetSetWizardImpl.FILE_EXTENSION.equalsIgnoreCase((extension))) {
				setErrorMessage(Messages.CreateFacetSetWizardImpl_File_extension_restriction);
				valid = false;
			}
		}

		if (valid) {

			IPath containerFullPath = getContainerFullPath();
			try {
				if (!PluginUtils.isInPluginProject(containerFullPath)) {
					setMessage(Messages.CreateFacetSetWizardPage_Not_a_Plugin_project, IMessageProvider.WARNING);
				}
			} catch (CoreException e) {
				Logger.logError(e, Activator.getDefault());
			}
		}

		return valid;
	}

	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}

}
