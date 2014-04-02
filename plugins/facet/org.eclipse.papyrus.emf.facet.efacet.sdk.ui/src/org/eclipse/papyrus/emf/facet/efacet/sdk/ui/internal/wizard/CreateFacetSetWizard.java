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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetActions;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.WorkbenchUtils;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.wizard.page.ICreateFacetSetWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.wizard.page.IFacetSetPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard.page.CreateFacetSetWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard.page.FacetSetPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard.page.SynchronizedCreateFacetSetWizardPage;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard.page.SynchronizedFacetSetPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * Wizard for the creation of the "ecore" file with the main facetSet.
 */
public class CreateFacetSetWizard extends Wizard implements INewWizard,
		IExtendedWizard {

	private WizardDialog dialog;

	private IStructuredSelection selection;
	private IWorkbench workbench;
	private final ICreateFacetSetWizardPage facetSetWizard;
	private final IFacetSetPropertyWizardPage propertyWizard;

	private boolean openFacetSet = true;

	public CreateFacetSetWizard() {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection());
	}

	public CreateFacetSetWizard(final ISelection selection,
			final boolean openFacetSet) {
		this(selection);
		this.openFacetSet = openFacetSet;
	}

	public CreateFacetSetWizard(final ISelection selection) {
		super();
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}
		setWindowTitle(Messages.Create_FacetSet_Model);

		this.facetSetWizard = new CreateFacetSetWizardPage(
				"Whatever", this.selection); //$NON-NLS-1$
		this.propertyWizard = new FacetSetPropertyWizardPage("Whatever"); //$NON-NLS-1$

	}

	@Override
	public void addPages() {
		addPage(this.facetSetWizard);
		addPage(this.propertyWizard);
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
		boolean result = false;

		if (this.propertyWizard.isPageComplete()) {
			try {
				// Remember the file.
				final IFile modelFile = getModelFile();

				// Do the work within an operation.
				final WorkspaceModifyOperation operation = createOperation(modelFile);

				getContainer().run(false, false, operation);

				if (this.openFacetSet) {
					// Select the new file resource in the current view.
					final IWorkbenchWindow workbenchWindow = selectWorkbenchWindow();
					final IWorkbenchPage page = WorkbenchUtils.selectNewFile(
							modelFile,
							workbenchWindow);

					WorkbenchUtils.openNewFile(modelFile, this.workbench,
							workbenchWindow,
							page);
				}

				result = true;
			} catch (final Exception exception) {
				Logger.logError(exception, Activator.getDefault());
			}
		}

		return result;
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
					final FacetSet facetSet = createInitialFacet();
					IFacetActions.INSTANCE.saveFacetSet(facetSet, modelFile);
				} catch (final Exception exception) {
					Logger.logError(exception, Activator.getDefault());
				} finally {
					progressMonitor.done();
				}
			}
		};
		return operation;
	}



	@Override
	public boolean canFinish() {
		return (getContainer().getCurrentPage() == this.propertyWizard)
				&& this.propertyWizard.isPageComplete();
	}

	public void init(final IWorkbench newWorkbench,
			final IStructuredSelection newSelection) {
		this.workbench = newWorkbench;
		this.selection = newSelection;
	}

	protected FacetSet createInitialFacet() {
		final FacetSet facetSet = EFacetPackage.eINSTANCE.getEFacetFactory()
				.createFacetSet();
		final String modelFacetSetName = getModelFile().getName().replaceAll(
				".efacet", ""); //$NON-NLS-1$ //$NON-NLS-2$
		facetSet.setName(modelFacetSetName);
		facetSet.setNsURI(this.propertyWizard.getNsUri());
		facetSet.setNsPrefix(this.propertyWizard.getPrefix());
		return facetSet;
	}

	public IFile getModelFile() {
		return this.facetSetWizard.getModelFile();
	}

	public IFacetSetPropertyWizardPage getPropertyWizard() {
		return this.propertyWizard;
	}

	public IWizardPage next() {
		final IWizardPage nextPage = getNextPage(getContainer()
				.getCurrentPage());
		this.dialog.showPage(nextPage);
		return getSynchronizedPage(nextPage);

	}

	public IWizardPage previous() {
		final IWizardPage previousPage = getPreviousPage(getContainer()
				.getCurrentPage());
		this.dialog.showPage(previousPage);
		return getSynchronizedPage(previousPage);
	}

	public boolean finish() {
		final boolean result = performFinish();
		dispose();
		setContainer(null);
		getDialog().close();
		return result;
	}

	public ICreateFacetSetWizardPage getFacetSetWizard() {
		return this.facetSetWizard;
	}

	public WizardDialog getDialog() {
		return this.dialog;
	}

	public IWizardPage getCurrentPage() {
		return getSynchronizedPage(getContainer().getCurrentPage());
	}

	private static IWizardPage getSynchronizedPage(final IWizardPage page) {
		IWizardPage result = null;
		if (page instanceof ICreateFacetSetWizardPage) {
			result = new SynchronizedCreateFacetSetWizardPage(
					(ICreateFacetSetWizardPage) page, Display.getDefault());
		} else if (page instanceof IFacetSetPropertyWizardPage) {
			result = new SynchronizedFacetSetPropertyWizardPage(
					(IFacetSetPropertyWizardPage) page, Display.getDefault());
		}
		return result;
	}
}
