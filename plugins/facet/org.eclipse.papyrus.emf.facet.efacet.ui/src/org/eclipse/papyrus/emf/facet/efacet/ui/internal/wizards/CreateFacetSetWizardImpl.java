/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetAction;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetSetWizard;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.utils.ImageProvider;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.pages.FacetSetPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.pages.CreateFacetSetWizardPage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class CreateFacetSetWizardImpl extends Wizard implements INewWizard, ICreateFacetSetWizard {

	public static final String FILE_EXTENSION = "efacet"; //$NON-NLS-1$

	private final CreateFacetSetWizardPage newFileCreationPage;
	private final FacetSetPropertyWizardPage facetSetPropertyWizardPage;

	private IStructuredSelection selection;

	private IWorkbench workbench;

	private final WizardDialog dialog;

	private boolean openCreatedFacet = true;

	public CreateFacetSetWizardImpl() {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
	}

	public CreateFacetSetWizardImpl(final ISelection selection2, final boolean openCreatedFacetSet) {
		this(selection2);
		this.openCreatedFacet = openCreatedFacetSet;
	}

	public CreateFacetSetWizardImpl(final ISelection selection2) {
		super();
		this.dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), this);
		if (selection2 != null && selection2 instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection2;
		}
		setWindowTitle(Messages.Create_FacetSet_Model);
		ImageProvider.getInstance();
		setDefaultPageImageDescriptor(ImageProvider.getFacetIconDescriptor());

		this.newFileCreationPage = new CreateFacetSetWizardPage("Whatever", this.selection); //$NON-NLS-1$

		this.facetSetPropertyWizardPage = new FacetSetPropertyWizardPage(null);
	}

	public void init(final IWorkbench workbench2, final IStructuredSelection selection2) {
		this.workbench = workbench2;
		this.selection = selection2;
	}

	protected FacetSet createInitialFacet() {
		FacetSet facetSet = EFacetPackage.eINSTANCE.getEFacetFactory().createFacetSet();
		String modelFacetSetName = getModelFile().getName().replaceAll(".facetSet$", ""); //$NON-NLS-1$ //$NON-NLS-2$
		facetSet.setName(modelFacetSetName);
		facetSet.setNsURI(this.facetSetPropertyWizardPage.getNsUri());
		facetSet.setNsPrefix(this.facetSetPropertyWizardPage.getPrefix());
		facetSet.setExtendedEPackage(this.facetSetPropertyWizardPage.getFirstSelectedEPackage());
		return facetSet;
	}

	@Override
	public boolean performFinish() {
		if (this.facetSetPropertyWizardPage.isPageComplete()) {
			try {
				// Remember the file.
				//
				final IFile modelFile = getModelFile();

				// Do the work within an operation.
				//
				WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
					@Override
					protected void execute(final IProgressMonitor progressMonitor) {
						try {
							FacetSet facetSet = createInitialFacet();
							IFacetAction.INSTANCE.createFacetSet(facetSet, modelFile);
						} catch (Exception exception) {
							Logger.logError(exception, Activator.getDefault());
						} finally {
							progressMonitor.done();
						}
					}
				};

				getContainer().run(false, false, operation);

				if (this.openCreatedFacet) {
					// Select the new file resource in the current view.
					if (this.workbench == null) {
						this.workbench = PlatformUI.getWorkbench();
					}
					IWorkbenchWindow workbenchWindow = this.workbench.getActiveWorkbenchWindow();
					IWorkbenchPage page = workbenchWindow.getActivePage();
					final IWorkbenchPart activePart = page.getActivePart();
					if (activePart instanceof ISetSelectionTarget) {
						final ISelection targetSelection = new StructuredSelection(modelFile);
						getShell().getDisplay().asyncExec(new Runnable() {
							public void run() {
								((ISetSelectionTarget) activePart).selectReveal(targetSelection);
							}
						});
					}

					// Open an editor on the new file.
					//
					try {
						page.openEditor(new FileEditorInput(modelFile),
								this.workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
					} catch (PartInitException exception) {
						MessageDialog.openError(workbenchWindow.getShell(), "Open Editor", exception.getMessage()); //$NON-NLS-1$
						return false;
					}
				}

				return true;
			} catch (Exception exception) {
				Logger.logError(exception, Activator.getDefault());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage() == this.facetSetPropertyWizardPage && this.facetSetPropertyWizardPage.isPageComplete();
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

	@Override
	public void addPages() {
		addPage(this.newFileCreationPage);
		addPage(this.facetSetPropertyWizardPage);
	}

	public IFile getModelFile() {
		return this.newFileCreationPage.getModelFile();
	}

	public int open() {
		if (this.dialog != null) {
			return this.dialog.open();
		}
		return Window.CANCEL;
	}
}
