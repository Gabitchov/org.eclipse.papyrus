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
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.util.core.DebugUtils;
import org.eclipse.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.widget.component.metaclass.MetamodelSelectionControl;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page.exception.SelectedEPackageRuntimeException;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEPackageWizardPage;
import org.eclipse.emf.facet.util.emf.ui.util.EditingUtil;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * @since 0.3
 */
public class SelectEPackageWizardPage extends WizardPage implements
		ISelectEPackageWizardPage {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
			.getDefault());

	private MetamodelSelectionControl mmSelectionCtl;

	public SelectEPackageWizardPage() {
		super("Whatever"); //$NON-NLS-1$
		setTitle(Messages.Select_EPackage);
	}

	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		if (visible) {
			this.mmSelectionCtl.getFilterText().setFocus();
			setPageComplete(true);
		}
	}

	public void createControl(final Composite parent) {
		this.mmSelectionCtl = new MetamodelSelectionControl(parent);
		this.mmSelectionCtl.setLayoutData(new GridData(
				GridData.FILL_BOTH));
		final FilteredList filteredList = this.mmSelectionCtl
				.getFilteredList();

		filteredList.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent event) {
				if (event.item != null) {
					setPageComplete(filteredList.getSelection().length == 1);
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

		// prevent the page from being "complete" when still on a previous page
		filteredList.setSelection(new int[0]);
		setPageComplete(false);
		setControl(this.mmSelectionCtl);
	}

	protected void goToNextPage() {
		getContainer().showPage(getNextPage());
	}

	public EPackage getSelectedEPackage() {
		EPackage ePackage = null;
		// Only one result
		if (this.mmSelectionCtl.getSelectedElements() != null) {
			final Object result = this.mmSelectionCtl
					.getSelectedElements()[0];
			if (EPackage.Registry.INSTANCE.containsKey(result.toString())) {
				ePackage = EPackage.Registry.INSTANCE
						.getEPackage(result.toString());
			}
		}
		return ePackage;
	}

	public void loadSelectedMetamodel() {
		final Object[] results = this.mmSelectionCtl
				.getSelectedElements();
		// if user cancel the selection of meta models, results = null
		if (results != null) {
			final ResourceSet resourceSet = EditingUtil.getEditingDomain()
					.getResourceSet();
			for (final Object result : results) {
				final URI uri = URI.createURI(result.toString());
				final Resource resource = resourceSet.getResource(uri, true);
				if (!resourceSet.getResources().contains(resource)) {
					final Registry packageRegistry = resourceSet
							.getPackageRegistry();
					packageRegistry.putAll(putResourceContents(resource,
							packageRegistry));
					resourceSet.getResources().add(resource);
				}
			}
		}
	}

	private static Registry putResourceContents(final Resource resource,
			final Registry packageRegistry) {
		final Registry result = packageRegistry;
		for (final EObject eObject : resource.getContents()) {
			if (eObject instanceof EPackage) {
				final EPackage ePackage = (EPackage) eObject;
				result.put(ePackage.getNsURI(), ePackage);
			}
		}
		return result;
	}

	/**
	 * Select the <code>packageName</code> into the list.
	 * 
	 * @param packageName
	 *            the name of the package to select.
	 */
	public void selectPackage(final String packageName) {
		DebugUtils.debug(DEBUG);
		boolean doItNow = true;
		// We get all the jobs
		for (final Job job : Job.getJobManager().find(null)) {
			// We check if the job of 'FilteredList' is ended. If not, we
			// recursively call this method to check again without interfering
			// with the 'FilteredList' job (with an asynchrony call).
			if (job.getClass().getName()
					.startsWith(FilteredList.class.getName())) {
				asyncSelectionPackage(packageName);
				DebugUtils.debug(DEBUG, "Selection defered."); //$NON-NLS-1$
				doItNow = false;
				break;
			}
		}

		// If the job 'FilteredList' is done, we can do the selection.
		if (doItNow) {
			internalSelectPackage(packageName);
		}
	}

	private void asyncSelectionPackage(final String packageName) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				selectPackage(packageName);
			}
		});
	}

	private void internalSelectPackage(final String packageName) {
		final FilteredList filteredList = this.mmSelectionCtl
				.getFilteredList();
		filteredList.setSelection(new String[] { packageName });
		if (getSelectedEPackage() == null) {
			throw new SelectedEPackageRuntimeException();
		}
		DebugUtils.debug(DEBUG, "Selection setting finished."); //$NON-NLS-1$
		DebugUtils.debug(DEBUG, "selectedEPackage=" + getSelectedEPackage()); //$NON-NLS-1$
	}
}
