package org.eclipse.papyrus.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;


public class InitModelWizard extends CreateModelWizard {

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;
	
	public void addPages() {
		super.addPages();
		addPage(selectRootElementPage);
	}
	
	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 *
	 * @param workbench
	 * @param selection
	 */
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		IFile file = getSelectedFile(selection);
		if(isSupportedDomainModelFile(file)) {
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new Papyrus model from an existing semantic model", selection, true);
			this.newModelFilePage.setFileName(getDiagramFileName(file));

			selectRootElementPage = new SelectRootElementPage("Select the root element", file);

		}
	}

	/**
	 * Returns true is the file can be served as a model model for the diagram
	 */
	protected boolean isSupportedDomainModelFile(IFile file) {
		return file != null && getModelFileExtension().equals(file.getFileExtension());
	}

	private String getModelFileExtension() {
		return "uml";
	}

	/**
	 * Returns the first file from the given selection
	 */
	private IFile getSelectedFile(IStructuredSelection selection) {
		if(selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof IFile) {
			return (IFile)selection.getFirstElement();
		}
		return null;
	}
	
	@Override
	protected EObject getRoot() {
		return selectRootElementPage.getModelElement();
	}

}
