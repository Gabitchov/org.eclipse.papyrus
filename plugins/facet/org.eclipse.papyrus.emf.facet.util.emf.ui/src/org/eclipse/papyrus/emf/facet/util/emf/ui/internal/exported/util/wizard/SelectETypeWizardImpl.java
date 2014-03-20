/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SelectEClassifierWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SelectEPackageWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SynchronizedSelectEClassifierWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SynchronizedSelectEPackageWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEClassifierWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEPackageWizardPage;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @since 0.3
 */
public class SelectETypeWizardImpl<T extends EClassifier> extends Wizard
		implements ISelectETypeWizard<T> {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
			.getDefault());
	private final WizardDialog dialog;
	private final ISelectEPackageWizardPage ePackageWP;
	private final ISelectEClassifierWizardPage<T> eClassifierWP;
	private T eClassifier;

	public SelectETypeWizardImpl(final Class<? extends T> eTypeOption,
			final EPackage ePackage) {
		super();
		this.dialog = new WizardDialog(new Shell(Display.getDefault()),
				this);
		this.ePackageWP = new SelectEPackageWizardPage();
		this.eClassifierWP = new SelectEClassifierWizardPage<T>(eTypeOption,
				ePackage);
		if (eTypeOption == EClass.class) {
			setWindowTitle(Messages.Select_EClass);
		} else if (eTypeOption == EDataType.class) {
			setWindowTitle(Messages.Select_EDataType);
		} else if (eTypeOption == EClassifier.class) {
			setWindowTitle(Messages.Select_EClassifier);
		} else if (eTypeOption == ETypedElement.class) {
			setWindowTitle(Messages.Select_ETypedElement);
		}
	}

	@Override
	public void addPages() {
		addPage(this.ePackageWP);
		addPage(this.eClassifierWP);
	}

	public int open() {
		int result = Window.CANCEL;

		if (this.dialog != null) {
			result = this.dialog.open();
		}
		return result;
	}

	@Override
	public boolean performFinish() {
		this.eClassifier = this.eClassifierWP.getSelectedEClassifier();
		return true;
	}

	public T getSelectedEClassifier() {
		return this.eClassifier;
	}

	public ISelectEClassifierWizardPage<T> getSelectEClassifierWizardPage() {
		return this.eClassifierWP;
	}

	public ISelectEPackageWizardPage getSelectEPackageWizardPage() {
		return this.ePackageWP;
	}

	public boolean finish() {
		final boolean result = performFinish();
		dispose();
		setContainer(null);
		this.dialog.close();
		return result;
	}

	public IWizardPage getCurrentPage() {
		return getSynchronizedPage(getContainer().getCurrentPage());
	}

	public IWizardPage next() {
		DebugUtils.debug(SelectETypeWizardImpl.DEBUG);
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

	private static IWizardPage getSynchronizedPage(final IWizardPage page) {
		IWizardPage result = null;
		if (page instanceof ISelectEClassifierWizardPage) {
			result = new SynchronizedSelectEClassifierWizardPage(
					(ISelectEClassifierWizardPage<?>) page,
					Display.getDefault());
		} else if (page instanceof ISelectEPackageWizardPage) {
			result = new SynchronizedSelectEPackageWizardPage(
					(ISelectEPackageWizardPage) page, Display.getDefault());
		}
		return result;
	}

	public void selectPackage(final String packageName) {
		getSelectEPackageWizardPage().selectPackage(packageName);
	}

	public void selectEClassifier(final String eClassifierName) {
		getSelectEClassifierWizardPage().selectEClassifier(eClassifierName);
	}

}
