/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected UMLCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected UMLCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return this.workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return this.selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return this.diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return this.openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(final boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.UMLCreationWizardTitle);
		setDefaultPageImageDescriptor(UMLDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewUMLWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	@Override
	public void addPages() {
		this.diagramModelFilePage = new UMLCreationWizardPage("DiagramModelFile", getSelection(), "PapyrusUMLTiming_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		this.diagramModelFilePage.setTitle(Messages.UMLCreationWizard_DiagramModelFilePageTitle);
		this.diagramModelFilePage.setDescription(Messages.UMLCreationWizard_DiagramModelFilePageDescription);
		addPage(this.diagramModelFilePage);

		this.domainModelFilePage = new UMLCreationWizardPage("DomainModelFile", getSelection(), "PapyrusUMLTiming") { //$NON-NLS-1$ //$NON-NLS-2$

			@Override
			public void setVisible(final boolean visible) {
				if (visible) {
					String fileName = UMLCreationWizard.this.diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".PapyrusUMLTiming_diagram".length()); //$NON-NLS-1$
					setFileName(UMLDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, "PapyrusUMLTiming")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		this.domainModelFilePage.setTitle(Messages.UMLCreationWizard_DomainModelFilePageTitle);
		this.domainModelFilePage.setDescription(Messages.UMLCreationWizard_DomainModelFilePageDescription);
		addPage(this.domainModelFilePage);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		final IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InterruptedException {
				UMLCreationWizard.this.diagram = UMLDiagramEditorUtil.createDiagram(UMLCreationWizard.this.diagramModelFilePage.getURI(),
						UMLCreationWizard.this.domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && UMLCreationWizard.this.diagram != null) {
					try {
						UMLDiagramEditorUtil.openDiagram(UMLCreationWizard.this.diagram);
					} catch (final PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), Messages.UMLCreationWizardOpenEditorError, null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), Messages.UMLCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				UMLDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return this.diagram != null;
	}
}
