/*******************************************************************************
 * Copyright (c) 2008, 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - initial API and implementation
 *     Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *     
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * This WizardPage can create an empty .uml2 file for the PapyrusEditor.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class NewModelFilePage extends WizardNewFileCreationPage {

	/** The Constant DEFAULT_NAME. */
	public static final String DEFAULT_NAME = Messages.NewModelFilePage_default_diagram_name;

	/** The Constant DIAGRAM_EXTENSION. */
	public static final String DEFAULT_DIAGRAM_EXTENSION = "di"; //$NON-NLS-1$

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "NewPapyrusModel"; //$NON-NLS-1$

	/**
	 * Instantiates a new new model file page.
	 * 
	 * @param selection
	 *        the selection
	 * @param modelKindName
	 *        the kind of model to be created (translatable)
	 */
	public NewModelFilePage(IStructuredSelection selection, String modelKindName) {
		this(PAGE_ID, selection, modelKindName);
	}

	/**
	 * Instantiates a new new model file page.
	 * 
	 * @param pageId
	 *        the page id
	 * @param selection
	 *        the selection
	 * @param modelKindName
	 *        the kind of model to be created (translatable)
	 */
	public NewModelFilePage(String pageId, IStructuredSelection selection, String modelKindName) {
		super(pageId, selection);
		setTitle(NLS.bind(Messages.NewModelFilePage_3, modelKindName));
		setDescription(NLS.bind(Messages.NewModelFilePage_page_desc, modelKindName));
		setFileExtension(DEFAULT_DIAGRAM_EXTENSION);
	}

	/**
	 * Creates the control.
	 * 
	 * @param parent
	 *        the parent {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(getUniqueFileName(getContainerFullPath(), getFileName(), getFileExtension()));
		setPageComplete(validatePage());
	}

	/**
	 * Diagram extension changed.
	 * 
	 * @param newExtension
	 *        the new extension
	 * @return the i status
	 */
	public IStatus diagramExtensionChanged(String newExtension) {
		String currentExtension = getFileExtension();
		if(!currentExtension.equals(newExtension)) {

			String oldFileName = getFileName();
			String newFileName = NewModelFilePage.getUniqueFileName(getContainerFullPath(), getFileName(), newExtension);

			setFileName(newFileName);
			setFileExtension(newExtension);

			String message1 = Messages.NewModelFilePage_new_diagram_category_needs_specific_extension;
			String message2 = Messages.bind(Messages.NewModelFilePage_diagram_file_was_renamed, oldFileName, newFileName);
			String message = message1 + message2;
			Status resultStatus = new Status(Status.INFO, Activator.PLUGIN_ID, message);

			String errorMessage = getErrorMessage();
			if(errorMessage != null) {
				resultStatus = new Status(Status.ERROR, Activator.PLUGIN_ID, errorMessage);
			}
			return resultStatus;
		}
		return Status.OK_STATUS;
	}


	/**
	 * Gets the unique file name.
	 * 
	 * @param containerFullPath
	 *        the container full path
	 * @param fileName
	 *        the file name
	 * @param extension
	 *        the extension
	 * @return the unique file name
	 */
	protected static String getUniqueFileName(IPath containerFullPath, String fileName, String extension) {
		if(extension == null) {
			extension = ""; //$NON-NLS-1$
		}

		if(containerFullPath == null) {
			containerFullPath = new Path(""); //$NON-NLS-1$
		}
		if(fileName == null || fileName.trim().length() == 0) {
			fileName = DEFAULT_NAME;
		}

		if(fileName.contains(".")) { //$NON-NLS-1$
			fileName = fileName.substring(0, fileName.indexOf(".")); //$NON-NLS-1$
		}

		IPath filePath = containerFullPath.append(fileName);
		filePath = containerFullPath.append(fileName);
		filePath = filePath.addFileExtension(extension);

		int i = 1;
		while(ResourcesPlugin.getWorkspace().getRoot().exists(filePath)) {
			i++;
			filePath = containerFullPath.append(fileName + i);
			if(extension != null) {
				filePath = filePath.addFileExtension(extension);
			}
		}
		return filePath.lastSegment();
	}

	@Override
	protected void createAdvancedControls(Composite parent) {
		//Nothing: the standard "createAdvancedControls" method adds an option to "Link to file in the file system".
		//It is not properly integrated with Papyrus (Which creates 3 different files, and only one of them is actually linked to the file system)
	}

	@Override
	protected IStatus validateLinkedResource() {
		return Status.OK_STATUS; //Disable this method to avoid NPE (Because we override #createAdvancedControls)
	}

	@Override
	protected void createLinkTarget() {
		//Disable this method to avoid NPE (Because we override #createAdvancedControls)
	}

}
