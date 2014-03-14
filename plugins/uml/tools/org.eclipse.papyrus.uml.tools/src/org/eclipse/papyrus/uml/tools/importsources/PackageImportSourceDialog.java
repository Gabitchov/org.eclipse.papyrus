/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Package;

/**
 * This is the PackageImportSourceDialog type. Enjoy.
 */
public class PackageImportSourceDialog extends MultipleValueSelectorDialog {

	private IPackageImportSource source;

	private ResourceSet resourceSet;

	private List<Package> selectedPackages;

	/**
	 * Initializes me.
	 *
	 * @param parentShell
	 *        the shell to use as parent of the dialog
	 * @param title
	 *        the dialog title
	 */
	public PackageImportSourceDialog(Shell parentShell, String title) {
		super(parentShell, new MyReferenceSelector(), title, true, true);

		setTitle(title);
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, IStructuredSelection selection) {

		return open(parentShell, title, selection.toList());
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, Collection<?> selection) {
		return open(parentShell, title, selection, null);
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, Collection<?> selection, Map<String, String> extensionFilters) {

		PackageImportSourceDialog dlg = new PackageImportSourceDialog(parentShell, title);
		dlg.setExtensionFilters(extensionFilters);
		dlg.initialize(selection);
		dlg.open();

		return dlg.getSelectedPackages();
	}

	protected Map<String, String> extensionFilters;

	protected void setExtensionFilters(Map<String, String> extensionFilters) {
		this.extensionFilters = extensionFilters;
	}

	public void initialize(Collection<?> selection) {
		IEvaluationService evaluationService = (IEvaluationService)PlatformUI.getWorkbench().getService(IEvaluationService.class);
		source = new PackageImportSourceRegistry(evaluationService).createImportSourceFor(selection);
		source.initialize(selection);

		MyReferenceSelector selector = (MyReferenceSelector)this.selector;
		ILabelProvider labelProvider = source.getModelHierarchyLabelProvider();
		selector.setLabelProvider(labelProvider);
		selector.setContentProvider(source.getModelHierarchyContentProvider(extensionFilters));
		selector.setImportSource(source);

		setLabelProvider(labelProvider);

		resourceSet = Util.createTemporaryResourceSet();
	}

	/**
	 * Queries the packages selected by the user, if not cancelled.
	 *
	 * @return the selected packages, or {@code null} if the user cancelled
	 */
	public Collection<Package> getSelectedPackages() {
		return selectedPackages;
	}

	@Override
	public boolean close() {
		boolean result = super.close();

		if(result) {
			computePackages();

			dispose();
		}

		return result;
	}

	public void dispose() {
		if(source != null) {
			source.dispose();
			source = null;
		}
	}

	private void computePackages() {
		Object[] dlgResult = getResult();
		if(dlgResult != null) {
			selectedPackages = new java.util.ArrayList<Package>(dlgResult.length);

			for(Object selectedElement : dlgResult) {
				try {
					selectedPackages.addAll(source.getPackages(resourceSet, selectedElement));
				} catch (CoreException e) {
					StatusAdapter adapter = new StatusAdapter(e.getStatus());
					adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Invalid Model(s) Selected");
					adapter.setProperty(IStatusAdapterConstants.EXPLANATION_PROPERTY, "One or more of the models selected could not provide packages to import.");
					StatusManager.getManager().handle(adapter, StatusManager.SHOW);
				}
			}
		}
	}

	//
	// Nested types
	//

	private static class MyReferenceSelector extends ReferenceSelector {

		private IPackageImportSource source;

		void setImportSource(IPackageImportSource source) {
			this.source = source;
		}

		@Override
		public void createControls(Composite parent) {
			super.createControls(parent);

			if(source instanceof CompositePackageImportSource) {
				// expand to the second level to show projects in the workspace
				// and whatever is contributed by other sources
				treeViewer.expandToLevel(2);
			}

		}
	}
}
