/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * This WizardPage can create an empty .uml2 file for the PapyrusEditor.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class NewModelFilePage extends WizardNewFileCreationPage {

	/** The Constant DEFAULT_NAME. */
	public static final String DEFAULT_NAME = "model";

	/** The Constant DIAGRAM_EXTENSION. */
	public static final String DEFAULT_DIAGRAM_EXTENSION = "di";

	public static final String PAGE_ID = "NewPapyrusModel";

	/**
	 * Instantiates a new new model file page.
	 * 
	 * @param title
	 *        the title
	 * @param description
	 *        the description
	 * @param selection
	 *        the selection
	 * @param createFromSemanticModel
	 *        the create from semantic model
	 */
	public NewModelFilePage(IStructuredSelection selection) {
		super(PAGE_ID, selection);
		setTitle("Create a new Papyrus model");
		setDescription("Create a new empty Papyrus model");
		setFileExtension(DEFAULT_DIAGRAM_EXTENSION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(getUniqueFileName(getContainerFullPath(), getFileName(), getFileExtension()));
		setPageComplete(validatePage());
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
	public static String getUniqueFileName(IPath containerFullPath, String fileName, String extension) {
		if(extension == null) {
			extension = "";
		}

		if(containerFullPath == null) {
			containerFullPath = new Path(""); //$NON-NLS-1$
		}
		if(fileName == null || fileName.trim().length() == 0) {
			fileName = DEFAULT_NAME;
		}

		if(fileName.contains(".")) {
			fileName = fileName.substring(0, fileName.indexOf("."));
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

}
