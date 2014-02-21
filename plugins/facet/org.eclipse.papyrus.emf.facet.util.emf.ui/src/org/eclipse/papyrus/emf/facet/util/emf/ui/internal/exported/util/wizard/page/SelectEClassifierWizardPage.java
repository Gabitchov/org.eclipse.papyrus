/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *    Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.util.core.DebugUtils;
import org.eclipse.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.composite.EClassifierSelectionControl;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page.exception.SelectedEClassifierRuntimeException;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEClassifierWizardPage;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEPackageWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * @since 0.3
 */
public class SelectEClassifierWizardPage<T extends EClassifier> extends
		WizardPage implements ISelectEClassifierWizardPage<T> {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
			.getDefault());
	private EClassifierSelectionControl<T> eClassSelection;
	private final Class<? extends T> eTypeOption;
	private String metamodelNsUri;

	public SelectEClassifierWizardPage(final Class<? extends T> eTypeOption,
			final EPackage ePackage) {
		super("Whatever"); //$NON-NLS-1$
		if (eTypeOption == EClass.class) {
			setTitle(Messages.Select_EClass);
		} else if (eTypeOption == EDataType.class) {
			setTitle(Messages.Select_EDataType);
		} else if (eTypeOption == EClassifier.class) {
			setTitle(Messages.Select_EClassifier);
		} else if (eTypeOption == ETypedElement.class) {
			setTitle(Messages.Select_ETypedElement);
		}
		if (ePackage != null) {
			this.metamodelNsUri = ePackage.getNsURI();
		}
		this.eTypeOption = eTypeOption;
	}

	@Override
	public boolean isPageComplete() {
		return this.eClassSelection.getSelectedEClassifier() != null;
	}

	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		if (getPreviousPage() instanceof SelectEPackageWizardPage) {
			final ISelectEPackageWizardPage selectEPackage = (ISelectEPackageWizardPage) getPreviousPage();
			this.metamodelNsUri = selectEPackage.getSelectedEPackage()
					.getNsURI();
			if (this.metamodelNsUri != null) {
				setDescription(selectEPackage.getSelectedEPackage()
						.getNsURI());
			}
		}
		this.eClassSelection.updateList(this.metamodelNsUri);
	}

	public void createControl(final Composite parent) {
		this.eClassSelection = new EClassifierSelectionControl<T>(parent,
				this.metamodelNsUri, this.eTypeOption);
		final FilteredList filteredList = this.eClassSelection
				.getFilteredList();

		filteredList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(final SelectionEvent event) {
				if (event.item != null) {
					updateButton();
					// setPageComplete(filteredList.getSelection().length == 1);
				}
			}

			public void widgetDefaultSelected(final SelectionEvent event) {
				if (getWizard().canFinish()) {
					getWizard().performFinish();
				}
				if (getNextPage() != null) {
					goToNextPage();
				}
			}
		});

		this.eClassSelection.getFilterText().addModifyListener(
				new ModifyListener() {

					public void modifyText(final ModifyEvent event) {
						updateButton();
					}
				});

		// avoid the page being "complete" when still on a previous page
		filteredList.setSelection(new int[0]);
		setPageComplete(false);

		setControl(this.eClassSelection);
	}

	protected void goToNextPage() {
		getContainer().showPage(getNextPage());
	}

	protected void updateButton() {
		if ((getContainer() != null) && (getContainer().getCurrentPage() != null)) {
			getContainer().updateButtons();
		}
	}

	public T getSelectedEClassifier() {
		return this.eClassSelection.getSelectedEClassifier();
	}

	/**
	 * Select the <code>eclassifierName</code> into the list.
	 * 
	 * @param eclassifierName
	 *            the name of the classifier to select.
	 */
	public void selectEClassifier(final String eclassifierName) {
		DebugUtils.debug(DEBUG);
		boolean doItNow = true;
		// We get all the jobs
		for (final Job job : Job.getJobManager().find(null)) {
			// We check if the job of 'FilteredList' is ended. If not, we
			// recursively call this method to check again without interfering
			// with the 'FilteredList' job (doing an asynchrony call).
			if (job.getClass().getName()
					.startsWith(FilteredList.class.getName())) {
				asyncSelectionClassifier(eclassifierName);
				DebugUtils.debug(DEBUG, "Selection defered."); //$NON-NLS-1$
				doItNow = false;
				break;
			}
		}

		// If the job 'FilteredList' is done, we can do the selection.
		if (doItNow) {
			internalSelectEClassifier(eclassifierName);
		}
	}

	private void asyncSelectionClassifier(final String eclassifierName) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				selectEClassifier(eclassifierName);
			}
		});
	}

	private void internalSelectEClassifier(final String packageName) {
		final FilteredList filteredList = this.eClassSelection
				.getFilteredList();
		filteredList.setSelection(new String[] { packageName });
		if (getSelectedEClassifier() == null) {
			throw new SelectedEClassifierRuntimeException();
		}
		DebugUtils.debug(DEBUG, "Selection setting finished."); //$NON-NLS-1$
		DebugUtils.debug(DEBUG,
				"selectedEClassifier=" + getSelectedEClassifier()); //$NON-NLS-1$
	}
}