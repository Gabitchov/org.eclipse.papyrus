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
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This action initialize the "CreateModelWizard" with the selected domain file, and launch the
 * wizard to create Diagram Interchange resources required by Papyrus editor.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InitDiagramAction implements IObjectActionDelegate {

	/**
	 * The active part
	 */
	private IWorkbenchPart targetPart;

	/**
	 * The current selection;
	 */
	IStructuredSelection selection;

	/**
	 * The URI of the selected domain file.
	 */
	private URI domainModelURI;

	/**
	 * {@inheritDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.domainModelURI = null;
		this.selection = null;
		action.setEnabled(false);
		if((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			IFile file = (IFile)((IStructuredSelection)selection).getFirstElement();
			this.domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			this.selection = (StructuredSelection)selection;
			action.setEnabled(true);
		}
	}

	/**
	 * @return the current Shell to display dialog
	 */
	private Shell getShell() {
		return targetPart.getSite().getShell();
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		if(domainModelURI != null) {
			CreateModelWizard wizard = new CreateModelWizard(domainModelURI);
			wizard.init(targetPart.getSite().getWorkbenchWindow().getWorkbench(), selection);
			WizardDialog dialog = new WizardDialog(getShell(), wizard);
			dialog.create();
			dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);
			dialog.open();
		}
	}

}
