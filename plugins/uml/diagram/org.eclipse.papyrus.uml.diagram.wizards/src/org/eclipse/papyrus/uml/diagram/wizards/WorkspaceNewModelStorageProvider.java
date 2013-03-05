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
package org.eclipse.papyrus.uml.diagram.wizards;

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.adapt;
import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.getSelectedFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.InitModelWizard.NewDiagramForExistingModelPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;

/**
 * This is the WorkspaceNewModelStorageProvider type. Enjoy.
 */
public class WorkspaceNewModelStorageProvider
		extends AbstractNewModelStorageProvider {

	private CreateModelWizard wizard;

	/** New model file page for the file. */
	private NewModelFilePage newModelFilePage;

	public WorkspaceNewModelStorageProvider() {
		super();
	}

	public boolean canHandle(IStructuredSelection initialSelection) {
		boolean result = false;

		for (Object next : initialSelection.toList()) {
			if (adapt(next, IResource.class) != null) {
				result = true;
				break;
			}
		}

		return result;
	}

	public void init(CreateModelWizard wizard, IStructuredSelection selection) {
		super.init(wizard, selection);

		this.wizard = wizard;
		newModelFilePage = createNewModelFilePage(selection);
	}

	public List<? extends IWizardPage> createPages() {
		if (newModelFilePage == null) {
			return Collections.emptyList();
		}

		return Arrays.asList(newModelFilePage);
	}

	public IStatus validateDiagramCategories(String... newCategories) {
		if (newModelFilePage != null) {
			String firstCategory = newCategories.length > 0
				? newCategories[0]
				: null;
			if (newCategories.length > 0) {
				// 316943 - [Wizard] Wrong suffix for file name when creating a
				// profile model
				return newModelFilePage.diagramExtensionChanged(wizard
					.getDiagramFileExtension(firstCategory));
			}
		}

		return super.validateDiagramCategories(newCategories);
	}

	/**
	 * Creates the new model file page, if required.
	 * 
	 * @param selection
	 *            the selection
	 * 
	 * @return the new model file page, or {@code null} if none
	 */
	protected NewModelFilePage createNewModelFilePage(
			IStructuredSelection selection) {

		if (wizard.isCreateProjectWizard()
			|| wizard.isCreateMultipleModelsWizard()) {

			return null;
		}

		if (isCreateFromExistingDomainModel()) {
			return new NewDiagramForExistingModelPage(
				selection,
				wizard.getModelKindName(),
				getDiagramFileName(getSelectedFile(selection))
					+ "." + wizard.getDiagramFileExtension(null), wizard.getDiagramFileExtension(null)); //$NON-NLS-1$
		}

		return new NewModelFilePage(selection, wizard.getModelKindName());
	}

	/**
	 * Suggests a name of diagram file for the domain model file without
	 * extension.
	 * 
	 * @param domainModel
	 *            the domain model
	 * @return the diagram file name
	 */
	protected String getDiagramFileName(IFile domainModel) {
		return domainModel.getLocation().removeFileExtension().lastSegment();
	}

	protected boolean isCreateFromExistingDomainModel() {
		return wizard.isInitModelWizard()
			&& ((InitModelWizard) wizard).isCreateFromExistingDomainModel();
	}

	public URI createNewModelURI(String categoryId) {
		IFile newFile = newModelFilePage.createNewFile();
		return (newFile == null)
			? null
			: URI.createPlatformResourceURI(newFile.getFullPath().toString(),
				true);
	}

}
