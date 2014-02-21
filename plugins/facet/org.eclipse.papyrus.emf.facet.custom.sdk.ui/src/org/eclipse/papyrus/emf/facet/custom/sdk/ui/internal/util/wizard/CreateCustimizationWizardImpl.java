/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.ICustomizationActions;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.wizard.page.CreateCustomizationWizardPage;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.wizard.page.CustomPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.wizard.page.ICreateCustomizationWizardPage;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.wizard.page.ICustomizationPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
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

/**
 * Wizard for the creation of the "custom" file for customization.
 */
public class CreateCustimizationWizardImpl extends Wizard implements INewWizard {

	private WizardDialog dialog;

	private IStructuredSelection selection;
	private IWorkbench workbench;
	private final ICreateCustomizationWizardPage customWizardPage;
	private final ICustomizationPropertyWizardPage propertyWP;

	private boolean openCustom = true;

	public CreateCustimizationWizardImpl() {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection());
	}

	public CreateCustimizationWizardImpl(final ISelection selection,
			final boolean openCustom) {
		this(selection);
		this.openCustom = openCustom;
	}

	public CreateCustimizationWizardImpl(final ISelection selection) {
		super();
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}
		setWindowTitle(Messages.Create_Customization_Model);
		this.customWizardPage = new CreateCustomizationWizardPage("Whatever", //$NON-NLS-1$
				this.selection);
		this.propertyWP = new CustomPropertyWizardPage("Whatever"); //$NON-NLS-1$
	}

	@Override
	public void addPages() {
		addPage(this.customWizardPage);
		addPage(this.propertyWP);
	}

	public int open() {
		this.dialog = new WizardDialog(Display.getDefault().getShells()[0],
				this);
		int result = Window.CANCEL;

		if (this.dialog != null) {
			result = this.dialog.open();
		}
		return result;
	}

	@Override
	public boolean performFinish() {
		return finish();
	}

	protected IWorkbenchWindow selectWorkbenchWindow() {
		if (this.workbench == null) {
			this.workbench = PlatformUI.getWorkbench();
		}
		final IWorkbenchWindow workbenchWindow = this.workbench
				.getActiveWorkbenchWindow();
		return workbenchWindow;
	}

	protected WorkspaceModifyOperation createOperation(final IFile modelFile) {
		final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(final IProgressMonitor progressMonitor) {
				try {
					final Customization customization = createInitialCustomization();
					ICustomizationActions.INSTANCE.saveCustomization(
							customization, modelFile);
				} catch (final Exception exception) {
					Logger.logError(exception, Activator.getDefault());
				} finally {
					progressMonitor.done();
				}
			}
		};
		return operation;
	}

	protected void openNewFile(final IFile modelFile,
			final IWorkbenchWindow workbenchWindow, final IWorkbenchPage page) {
		// Open an editor on the new file.
		try {
			final String fileName = modelFile.getName();
			final IEditorRegistry editorRegistry = this.workbench
					.getEditorRegistry();
			final IEditorDescriptor defaultEditor = editorRegistry
					.getDefaultEditor(fileName);
			final String editorId = defaultEditor.getId();
			final FileEditorInput editorInput = new FileEditorInput(modelFile);
			page.openEditor(editorInput, editorId);
		} catch (final PartInitException exception) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Open Editor", exception.getMessage()); //$NON-NLS-1$
		}
	}

	protected IWorkbenchPage selectNewFile(final IFile modelFile,
			final IWorkbenchWindow workbenchWindow) {
		final IWorkbenchPage page = workbenchWindow.getActivePage();
		final IWorkbenchPart activePart = page.getActivePart();
		if (activePart instanceof ISetSelectionTarget) {
			final ISelection targetSelection = new StructuredSelection(
					modelFile);
			getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					((ISetSelectionTarget) activePart)
							.selectReveal(targetSelection);
				}
			});
		}
		return page;
	}

	@Override
	public boolean canFinish() {
		return this.propertyWP.isPageComplete();
	}

	public void init(final IWorkbench newWorkbench,
			final IStructuredSelection newSelection) {
		this.workbench = newWorkbench;
		this.selection = newSelection;
	}

	protected Customization createInitialCustomization() {
		final Customization customization = CustomPackage.eINSTANCE
				.getCustomFactory().createCustomization();
		final String projectName = getProjectName();
		final String modelCustomName = getModelFile().getName().replaceAll(
				".custom", ""); //$NON-NLS-1$ //$NON-NLS-2$
		customization.setName(projectName + "." + modelCustomName); //$NON-NLS-1$
		customization.setNsURI(this.propertyWP.getNsUri());
		customization.setNsPrefix(this.propertyWP.getPrefix());
		return customization;
	}

	/**
	 * @return
	 */
	private static String getProjectName() {
		String activeProjectName = null;
		final IEditorPart editorPart = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();

		if (editorPart != null) {
			final FileEditorInput input = (FileEditorInput) editorPart
					.getEditorInput();
			final IFile file = input.getFile();
			final IProject activeProject = file.getProject();
			activeProjectName = activeProject.getName();
		}
		return activeProjectName;
	}

	public IFile getModelFile() {
		return this.customWizardPage.getModelFile();
	}

	public IWizardPage next() {
		final IWizardPage nextPage = getNextPage(this.getCurrentPage());
		this.dialog.showPage(nextPage);
		return nextPage;

	}

	public IWizardPage previous() {
		final IWizardPage previousPage = getPreviousPage(this.getCurrentPage());
		this.dialog.showPage(previousPage);
		return previousPage;
	}

	public boolean finish() {
		boolean result = false;

		if (canFinish()) {
			try {
				// Remember the file.
				final IFile modelFile = getModelFile();

				// Do the work within an operation.
				final WorkspaceModifyOperation operation = createOperation(modelFile);

				getContainer().run(false, false, operation);

				if (this.openCustom) {
					// Select the new file resource in the current view.
					final IWorkbenchWindow workbenchWindow = selectWorkbenchWindow();
					final IWorkbenchPage page = selectNewFile(modelFile,
							workbenchWindow);

					openNewFile(modelFile, workbenchWindow, page);
				}

				result = true;
			} catch (final Exception exception) {
				Logger.logError(exception, Activator.getDefault());
			}
		}

		return result;
	}

	public WizardDialog getDialog() {
		return this.dialog;
	}

	public IWizardPage getCurrentPage() {
		return this.getContainer().getCurrentPage();
	}

}
