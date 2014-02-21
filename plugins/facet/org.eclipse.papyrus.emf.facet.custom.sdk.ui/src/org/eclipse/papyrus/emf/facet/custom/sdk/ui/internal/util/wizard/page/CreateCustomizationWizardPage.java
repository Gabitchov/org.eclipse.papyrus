/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.wizard.page;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.wizard.page.ICreateCustomizationWizardPage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
//import org.eclipse.papyrus.emf.facet.util.core.internal.exported.PluginUtils;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * Wizard page for the creation of a custom model file.
 */
public class CreateCustomizationWizardPage extends WizardNewFileCreationPage
		implements ICreateCustomizationWizardPage {

	private static final String FILE_EXTENSION = "custom"; //$NON-NLS-1$
	private static final String MODEL_BASE = "My"; //$NON-NLS-1$

	/**
	 * @param pageName
	 * @param selection
	 */
	public CreateCustomizationWizardPage(final String pageName,
			final IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(Messages.CreateCustomizationWizardImpl_customization);
		setDescription(Messages.CreateCustomizationWizardImpl_Create_new_customization);
		setFileName(MODEL_BASE + "." + FILE_EXTENSION); //$NON-NLS-1$

		// Try and get the resource selection to determine a current directory
		// for the file dialog.
		if ((selection != null) && !selection.isEmpty()) {
			// Get the resource...
			final Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				getResourceParent(selectedElement);
			}
		}
	}

	private void getResourceParent(final Object selectedElement) {
		IResource selectedResource = (IResource) selectedElement;
		if (selectedResource.getType() == IResource.FILE) {
			selectedResource = selectedResource.getParent();
		}

		// This gives us a directory...
		if ((selectedResource instanceof IFolder)
				|| (selectedResource instanceof IProject)) {
			// Set this for the container.
			setContainerFullPath(selectedResource.getFullPath());

			// Make up a unique new name here.
			final String modelFileExt = FILE_EXTENSION;
			String modelFilename = MODEL_BASE + "." + modelFileExt; //$NON-NLS-1$
			for (int i = 1; ((IContainer) selectedResource)
					.findMember(modelFilename) != null; ++i) {
				modelFilename = MODEL_BASE + i + "." + modelFileExt; //$NON-NLS-1$
			}
			setFileName(modelFilename);
		}
	}

	@Override
	protected boolean validatePage() {
		boolean valid = super.validatePage();

		if (valid) {
			final String extension = new Path(getFileName()).getFileExtension();
			if ((extension == null)
					|| !FILE_EXTENSION.equalsIgnoreCase(extension)) {
				setErrorMessage(Messages.CreateCustomizationWizardImpl_File_extension_restriction);
				valid = false;
			}
			final IPath containerFullPath = getContainerFullPath();
//			try {
//				if (!PluginUtils.isInPluginProject(containerFullPath)) {
//					setMessage(
//							Messages.CreateCustomizationWizardPage_Not_a_Plugin_project,
//							IMessageProvider.WARNING);
//				}
//			} catch (final CoreException e) {
//				Logger.logError(e, Activator.getDefault());
//			}
		}

		return valid;
	}

	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot()
				.getFile(getContainerFullPath().append(getFileName()));
	}
}
