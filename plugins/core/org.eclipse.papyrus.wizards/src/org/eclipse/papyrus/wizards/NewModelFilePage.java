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
	protected static int fileCount = 1;

	protected boolean createFromSemanticModel;
	
	private static final String DEFAULT_NAME = "model";

	/**
	 * Create a new wizard page instance.
	 * 
	 * @param workbench
	 *            the current workbench
	 * @param selection
	 *            the current object selection
	 * @see PapyrusCreationWizard#init(IWorkbench, IStructuredSelection)
	 */
	public NewModelFilePage(String title, String description, IStructuredSelection selection, boolean createFromSemanticModel) {
		super(title, selection);
		setTitle(title);
		setDescription(description);
		this.createFromSemanticModel = createFromSemanticModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		if (getFileName() == null || getFileName().length() == 0) {
			setFileName(DEFAULT_NAME + fileCount + ".di");
		}
		setPageComplete(validatePage());
	}

	/**
	 * Tests if the file name entered in this page is valid.
	 * 
	 * @return <code>true</code> if the file name is valid
	 */
	private boolean validateFilename() {
		// TODO validate the fileName to ensure that the given name will not result in overwriting an existing resource.
		
//		if ((getFileName() != null) && getFileName().endsWith("." + IPapyrusUIConstants.MODEL_EXTENSION)) {
//			// check if a semantic model already exist
//		//	IPath semanticModelPath = Platform.getLocation().append(getContainerFullPath()).append(getFileName()).removeFileExtension().addFileExtension(UMLResource.FILE_EXTENSION);
//			if (!createFromSemanticModel /*&& semanticModelPath.toFile().exists()*/) {
//				setErrorMessage("'" + semanticModelPath.lastSegment() + "' already exist. " + "Select this and restart this wizard to create a new '" + IPapyrusUIConstants.MODEL_EXTENSION
//						+ "' model " + "from an existing semantic model!");
//			} else {
//				return true;
//			}
//		} else {
//			setErrorMessage("The 'file' name must end with the extension ." + IPapyrusUIConstants.MODEL_EXTENSION);
//		}
//		return false;
		return true;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean validatePage() {
		return super.validatePage() && validateFilename();
	}

}
