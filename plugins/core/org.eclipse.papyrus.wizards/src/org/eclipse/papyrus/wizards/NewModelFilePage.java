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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * This WizardPage can create an empty .uml2 file for the PapyrusEditor.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class NewModelFilePage extends WizardNewFileCreationPage {

	/** index for several file creation */
	private static int fileCount = 1;

	/** The create from semantic model. */
	protected boolean createFromSemanticModel;

	/** The Constant DEFAULT_NAME. */
	public static final String DEFAULT_NAME = "model";

	/** The Constant DIAGRAM_EXTENSION. */
	public static final String DIAGRAM_EXTENSION = "di";

	/**
	 * Instantiates a new new model file page.
	 *
	 * @param title the title
	 * @param description the description
	 * @param selection the selection
	 * @param createFromSemanticModel the create from semantic model
	 */
	public NewModelFilePage(String title, String description, IStructuredSelection selection,
			boolean createFromSemanticModel) {
		super(title, selection);
		setTitle(title);
		setDescription(description);
		setFileExtension(DIAGRAM_EXTENSION);
		this.createFromSemanticModel = createFromSemanticModel;
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
	 * @param containerFullPath the container full path
	 * @param fileName the file name
	 * @param extension the extension
	 * @return the unique file name
	 */
	private static String getUniqueFileName(IPath containerFullPath, String fileName, String extension) {
		if(containerFullPath == null) {
			containerFullPath = new Path(""); //$NON-NLS-1$
		}
		if(fileName == null || fileName.trim().length() == 0) {
			fileName = DEFAULT_NAME;
		}
		IPath filePath = containerFullPath.append(fileName);
		if(extension != null && !extension.equals(filePath.getFileExtension())) {
			filePath = filePath.addFileExtension(extension);
		}
		extension = filePath.getFileExtension();
		fileName = filePath.removeFileExtension().lastSegment();
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

	/**
	 * Tests if the file name entered in this page is valid.
	 * 
	 * @return <code>true</code> if the file name is valid
	 */
	private boolean validateFilename() {
		// TODO validate the fileName to ensure that the given name will not result in overwriting
		// an existing resource.

		// if ((getFileName() != null) && getFileName().endsWith("." +
		// IPapyrusUIConstants.MODEL_EXTENSION)) {
		// // check if a semantic model already exist
		// // IPath semanticModelPath =
		// Platform.getLocation().append(getContainerFullPath()).append(getFileName()).removeFileExtension().addFileExtension(UMLResource.FILE_EXTENSION);
		// if (!createFromSemanticModel /*&& semanticModelPath.toFile().exists()*/) {
		// setErrorMessage("'" + semanticModelPath.lastSegment() + "' already exist. " +
		// "Select this and restart this wizard to create a new '" +
		// IPapyrusUIConstants.MODEL_EXTENSION
		// + "' model " + "from an existing semantic model!");
		// } else {
		// return true;
		// }
		// } else {
		// setErrorMessage("The 'file' name must end with the extension ." +
		// IPapyrusUIConstants.MODEL_EXTENSION);
		// }
		// return false;
		return true;
	}
	
	@Override
	public IFile createNewFile() {
		IFile created = super.createNewFile();
		fileCount++;
		return created;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean validatePage() {
		return super.validatePage() && validateFilename();
	}

}
