/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class UMLCreationWizardPage extends WizardNewFileCreationPage {

	/**
	 * @generated
	 */
	private final String fileExtension;

	/**
	 * @generated
	 */
	public UMLCreationWizardPage(String pageName,
			IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
	}

	/**
	 * Override to create files with this extension.
	 * 
	 * @generated
	 */
	protected String getExtension() {
		return fileExtension;
	}

	/**
	 * @generated
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 * @generated
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(UMLDiagramEditorUtil.getUniqueFileName(
				getContainerFullPath(), getFileName(), getExtension()));
		setPageComplete(validatePage());
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null
				&& !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(NLS.bind(
					Messages.UMLCreationWizardPageExtensionError, extension));
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	/**
	 * #174315 Automatically set diagram file extension
	 * @generated
	 */
	@Override
	public IWizardPage getNextPage() {
		IWizardPage nextPage = super.getNextPage();
		if ("DiagramModelFile".equals(getName())
				&& "DomainModelFile".equals(nextPage.getName())) {
			setDomainFileName(nextPage);
		}
		return nextPage;
	}

	/**
	 * #174315 Automatically set diagram file extension
	 * @generated
	 */
	protected void setDomainFileName(IWizardPage nextPage) {
		UMLCreationWizardPage nextWizardPage = (UMLCreationWizardPage) nextPage;
		String fileName = getFileName();
		String extension = getExtension();
		if (fileName.endsWith(extension)) {
			fileName = fileName.substring(0, fileName.length()
					- extension.length());
		}
		fileName += nextWizardPage.getExtension();
		nextWizardPage.setFileName(fileName);
	}
}
