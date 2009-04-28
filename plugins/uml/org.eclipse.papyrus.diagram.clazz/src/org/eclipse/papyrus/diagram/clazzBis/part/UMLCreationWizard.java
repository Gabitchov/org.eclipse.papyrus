package org.eclipse.papyrus.diagram.clazzBis.part;

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
	protected org.eclipse.papyrus.diagram.clazzBis.part.UMLCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected org.eclipse.papyrus.diagram.clazzBis.part.UMLCreationWizardPage domainModelFilePage;

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
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizardTitle);
		setDefaultPageImageDescriptor(org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewUMLWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new org.eclipse.papyrus.diagram.clazzBis.part.UMLCreationWizardPage("DiagramModelFile", getSelection(), "PapyrusUMLClass"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new org.eclipse.papyrus.diagram.clazzBis.part.UMLCreationWizardPage("DomainModelFile", getSelection(), "uml") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".PapyrusUMLClass".length()); //$NON-NLS-1$
					setFileName(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, "uml")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage.setTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizardOpenEditorError, null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLCreationWizardCreationError, null, ((CoreException) e.getTargetException())
						.getStatus());
			} else {
				org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
