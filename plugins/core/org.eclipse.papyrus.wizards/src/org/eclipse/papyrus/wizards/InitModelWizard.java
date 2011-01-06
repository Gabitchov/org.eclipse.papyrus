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
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.wizards.category.PapyrusModelFromExistingDomainModelCommand;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.wizards.pages.SelectRootElementPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage.CategoryProvider;
import org.eclipse.ui.IWorkbench;

/**
 * The Class InitModelWizard.
 */
public class InitModelWizard extends CreateModelWizard {

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	private boolean isInitFromExistingDomainModel;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		IFile file = getSelectedFile(selection);
		isInitFromExistingDomainModel = isSupportedDomainModelFile(file);
		selectRootElementPage = createSelectRootElementPage(file);
		if(isCreateFromExistingDomainModel()) {
			// Init Model not Create a new one
			setWindowTitle("Init Papyrus Diagram");
		}
	}

	protected SelectRootElementPage createSelectRootElementPage(IFile file) {
		if(!isCreateFromExistingDomainModel()) {
			// create model - nothing to choose from
			return null;
		}
		return new SelectRootElementPage(file);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		if(isCreateFromExistingDomainModel()) {
			return new SelectDiagramKindPage(false, new CategoryProvider() {

				public String getCurrentCategory() {
					return getDiagramCategoryId();
				}
				
			});
		};
		return super.createSelectDiagramKindPage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		if(!isCreateFromExistingDomainModel()) {
			return super.createNewModelFilePage(selection);
		}
		return new NewDiagramForExistingModelPage(selection);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	protected void createPapyrusModels(IFile newFile) {
		if(isCreateFromExistingDomainModel()) {
		RecordingCommand command = new PapyrusModelFromExistingDomainModelCommand(getResourseSet(), newFile, getRoot());
		getCommandStack().execute(command);
		} else {
			super.createPapyrusModels(newFile);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initDomainModel(final IFile newFile) {
		if(isCreateFromExistingDomainModel()) {
			// do nothing
		} else {
			super.initDomainModel(newFile);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initDiagrams() {
		initDiagrams(getRoot());
	}

	private boolean isCreateFromExistingDomainModel() {
		return isInitFromExistingDomainModel;
	}

	/**
	 * Suggests a name of diagram file for the domain model file
	 */
	private String getDiagramFileName(IFile domainModel) {
		IPath filePath = domainModel.getLocation().removeFileExtension();
		filePath = filePath.addFileExtension(getDiagramFileExtension());
		return filePath.lastSegment();
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
