/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Gregoire Dupe (Mia-Software)
 *		Nicolas Bros (Mia-Software)
 *		Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.query.java.core.internal.exceptions.ClassAlreadyExistsException;
import org.eclipse.papyrus.emf.facet.query.java.core.internal.exceptions.ResourceURIExpectedException;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page.CreateQueryClassWizardPage;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page.SelectJavaClassWizardPage;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page.SelectOrCreateJavaClassWizardPage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

// Copied from org.eclipse.papyrus.emf.facet.query.java.ui.internal.wizard.SelectOrCreateJavaClassWizard
public class SelectOrCreateJavaClassWizard extends Wizard implements
		IExtendedWizard {


	private final WizardDialog dialog;
	private CreateQueryClassWizardPage createClassPage;
	private SelectOrCreateJavaClassWizardPage firstPage;

	private final IDialogCallback<String> callBack;
	private SelectJavaClassWizardPage selectClassPage;
	private final IQueryContext queryContext;

	public SelectOrCreateJavaClassWizard(final IQueryContext queryContext,
			final IDialogCallback<String> callBack)
			throws ClassAlreadyExistsException, ResourceURIExpectedException,
			JavaModelException {
		super();
		this.queryContext = queryContext;
		this.callBack = callBack;
		this.dialog = new WizardDialog(getShell(), this);
		setWindowTitle(Messages.Choose_an_operation);

		// check that the resource is from a platform URI
		final Resource resource = queryContext.getResource();
		final URI uri = resource.getURI();
		if (!uri.isPlatformResource()) {
			throw new ResourceURIExpectedException();
		}
		// check that the class doesn't already exist
		final String projectName = uri.segment(1);
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProject project = workspace.getRoot().getProject(projectName);
		final IJavaProject javaProject = JavaCore.create(project);
		final StringBuffer implClassName = new StringBuffer(
				this.queryContext.getDerivedTypedElementName());
		final EObject intermediate = this.queryContext.getIntermediateEObject();
		if (intermediate instanceof ETypedElementCase) {
			final ETypedElementCase eTECase = (ETypedElementCase) intermediate;
			if (eTECase.getCase() != null) {
				implClassName.append(eTECase.getCase().getName());
			}
		}
		implClassName.append("Query"); //$NON-NLS-1$
		if (javaProject.findType(implClassName.toString()) != null) {
			throw new ClassAlreadyExistsException();
		}
	}

	@Override
	public void addPages() {
		this.firstPage = new SelectOrCreateJavaClassWizardPage();
		addPage(this.firstPage);
		this.createClassPage = new CreateQueryClassWizardPage(
				this.queryContext);
		addPage(this.createClassPage);
		this.selectClassPage = new SelectJavaClassWizardPage();
		addPage(this.selectClassPage);
	}

	private String createJavaClass() {
		return this.createClassPage.apply(this.queryContext.getReturnType(),
				this.queryContext.getUpperBound() > 1,
				this.queryContext.getExtendedEClass());
	}

	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage().isPageComplete();
	}

	@Override
	public boolean performFinish() {
		return finish();
	}

	public int open() {
		return this.dialog.open();
	}

	public IWizardPage getCurrentPage() {
		return getContainer().getCurrentPage();
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
		boolean result = true;
		try {
			if (getContainer().getCurrentPage() == this.createClassPage) {
				final String classQName = createJavaClass();
				this.callBack.committed(classQName);
			} else if (getContainer().getCurrentPage() == this.selectClassPage) {
				this.callBack.committed(this.selectClassPage.getResult()
						.toString());
			}
		} catch (final Exception e) {
			Logger.logError(e, Activator.getDefault());
			result = false;
		}
		return result;
	}

	@Override
	public boolean performCancel() {
		return true;
	}

	@Override
	public IWizardPage getNextPage(final IWizardPage page) {
		IWizardPage result = null;
		if (page == this.firstPage) {
			if (this.firstPage.isSelect()) {
				result = this.selectClassPage;
			} else {
				result = this.createClassPage;
			}
		}
		return result;

	}
}
