/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.ui.IWorkbench;

/**
 * The Class InitModelWizard.
 */
public class InitModelWizard extends CreateModelWizard {

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		IFile file = getSelectedFile(selection);
		if (isSupportedDomainModelFile(file)) {
			setWindowTitle("Init Papyrus Diagram");
			newModelFilePage.setTitle("Init a new Papyrus model");
			newModelFilePage
					.setDescription("Init a new Papyrus model from the existing domain model");

			final String diagramFileName = getDiagramFileName(file);
			newModelFilePage = new NewModelFilePage(selection) {
				protected boolean validatePage() {
					if (!super.validatePage()) {
						return false;
					}
					if (!diagramFileName.equals(getFileName())) {
						setErrorMessage(String
								.format("Diagram file name should be the same as domain model file name (%s)",
										diagramFileName));
						return false;
					}
					return true;
				};
			};
			newModelFilePage.setFileName(diagramFileName);
			selectRootElementPage = new SelectRootElementPage(file);
		}
	}

	/**
	 * Returns true is the file can be served as a model model for the diagram
	 */
	public static boolean isSupportedDomainModelFile(IFile file) {
		return file != null
				&& UmlModel.UML_FILE_EXTENSION.equals(file.getFileExtension());
	}

	public static boolean isSupportedDomainModelFile(
			IStructuredSelection sselection) {
		IFile file = getSelectedFile(sselection);
		return isSupportedDomainModelFile(file);
	}

	/**
	 * Returns the first file from the given selection
	 */
	private static IFile getSelectedFile(IStructuredSelection selection) {
		if (selection != null && !selection.isEmpty()
				&& selection.getFirstElement() instanceof IFile) {
			return (IFile) selection.getFirstElement();
		}
		return null;
	}

	@Override
	protected EObject getRoot() {
		if (isInitNotCreateModel()) {
			return selectRootElementPage.getModelElement();
		}
		return super.getRoot();
	}

	/**
	 * Suggests a name of diagram file for the domain model file
	 */
	private String getDiagramFileName(IFile domainModel) {
		IPath filePath = domainModel.getLocation().removeFileExtension();
		filePath = filePath.addFileExtension(selectDiagramCategoryPage
				.getDiagramFileExtension());
		return filePath.lastSegment();
	}

	private boolean isInitNotCreateModel() {
		return selectRootElementPage != null;
	}
}
