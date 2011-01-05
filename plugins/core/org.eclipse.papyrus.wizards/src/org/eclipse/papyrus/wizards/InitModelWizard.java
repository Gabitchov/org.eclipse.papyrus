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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.wizards.category.PapyrusModelFromExistingDomainModelCommand;
import org.eclipse.ui.IWorkbench;

/**
 * The Class InitModelWizard.
 */
public class InitModelWizard extends CreateModelWizard {

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	private boolean isInitNotCreateModel;

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		IFile file = getSelectedFile(selection);
		isInitNotCreateModel = isSupportedDomainModelFile(file);
		selectRootElementPage = createSelectRootElementPage(file);
		if(isInitNotCreateModel) {
			// Init Model not Create a new one
			setWindowTitle("Init Papyrus Diagram");
		}
	}

	protected SelectRootElementPage createSelectRootElementPage(IFile file) {
		if(!isInitNotCreateModel) {
			// create model - nothing to choose from
			return null;
		}
		return new SelectRootElementPage(file);
	}

	@Override
	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		if(isInitNotCreateModel) {
			return new SelectDiagramKindPage(false);
		}
		return super.createSelectDiagramKindPage();
	}

	@Override
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		if(!isInitNotCreateModel) {
			return super.createNewModelFilePage(selection);
		}
		return new NewDiagramForExistingModelPage(selection);
	}


	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#addPages()
	 * 
	 */
	public void addPages() {
		super.addPages();
		addPageIfNotNull(selectRootElementPage);
	};

	/**
	 * Returns true is the file can be served as a model model for the diagram.
	 * 
	 * @param file
	 *        the file
	 * @return true, if is supported domain model file
	 */
	public static boolean isSupportedDomainModelFile(IFile file) {
		return file != null && UmlModel.UML_FILE_EXTENSION.equals(file.getFileExtension());
	}

	/**
	 * Checks if is supported domain model file.
	 * 
	 * @param sselection
	 *        the sselection
	 * @return true, if is supported domain model file
	 */
	public static boolean isSupportedDomainModelFile(IStructuredSelection sselection) {
		IFile file = getSelectedFile(sselection);
		return isSupportedDomainModelFile(file);
	}

	/**
	 * Returns the first file from the given selection
	 */
	private static IFile getSelectedFile(IStructuredSelection selection) {
		if(selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof IFile) {
			return (IFile)selection.getFirstElement();
		}
		return null;
	}

	private EObject getRoot() {
		if (selectRootElementPage != null) {
			return selectRootElementPage.getModelElement();
		}
		return null;
	}

	protected RecordingCommand getCreatePapyrusModelCommand(DiResourceSet diResourceSet, final IFile newFile) {
		if(isInitNotCreateModel()) {
			return new PapyrusModelFromExistingDomainModelCommand(diResourceSet, newFile, getRoot());
		} else {
			return super.getCreatePapyrusModelCommand(diResourceSet, newFile);
		}
	}

	protected void initDomainModel(DiResourceSet diResourceSet, final IFile newFile) {
		if(!isInitNotCreateModel()) {
			super.initDomainModel(diResourceSet, newFile);
		} else {
			// do nothing
		}
	}

	/**
	 * Suggests a name of diagram file for the domain model file
	 */
	private String getDiagramFileName(IFile domainModel) {
		IPath filePath = domainModel.getLocation().removeFileExtension();
		filePath = filePath.addFileExtension(getDiagramFileExtension());
		return filePath.lastSegment();
	}

	private boolean isInitNotCreateModel() {
		return isInitNotCreateModel;
	}

	protected void initDiagrams(final DiResourceSet diResourceSet) {
		initDiagrams(diResourceSet, getRoot());
	}

	@Override
	protected boolean isToInitFromTemplate() {
		if(isInitNotCreateModel()) {
			return false;
		}
		return super.isToInitFromTemplate();
	}

	private class NewDiagramForExistingModelPage extends NewModelFilePage {

		private String diagramFileName;

		public NewDiagramForExistingModelPage(IStructuredSelection selection) {
			super(selection);
			diagramFileName = getDiagramFileName(getSelectedFile(selection));
			setFileName(diagramFileName);
			setTitle("Init a new Papyrus model");
			setDescription("Init a new Papyrus model from the existing domain model");
		}

		protected boolean validatePage() {
			if(!super.validatePage()) {
				return false;
			}
			if(!diagramFileName.equals(getFileName())) {
				setErrorMessage(String.format("Diagram file name should be the same as domain model file name (%s)", diagramFileName));
				return false;
			}
			return true;
		};

	}

}
