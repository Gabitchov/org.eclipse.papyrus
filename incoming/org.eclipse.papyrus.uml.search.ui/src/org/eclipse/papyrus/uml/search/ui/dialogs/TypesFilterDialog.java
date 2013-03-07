/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.CheckBoxFilteredTree;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.filters.TypesMatchFilter;
import org.eclipse.papyrus.uml.search.ui.providers.FilterTypeContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.FilterTypeLabelProvider;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PatternFilter;

import com.swtdesigner.ResourceManager;

/**
 * 
 * A dialog that let user select the types of the elements that must be filtered
 * 
 */
public class TypesFilterDialog extends Dialog {

	private CheckBoxFilteredTree filterTypesTree;

	private AbstractTextSearchViewPage fPage;

	private CheckboxTreeViewer filterTypesTreeViewer;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        the parent shell, or <code>null</code> to create a top-level
	 *        shell
	 * @param page
	 *        the result page whose results while be filtered
	 */
	public TypesFilterDialog(Shell parentShell, AbstractTextSearchViewPage page) {
		super(parentShell);
		this.fPage = page;

	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.TypesFilterDialog_0);
		shell.setImage(ResourceManager.getPluginImage(Activator.PLUGIN_ID, "icons/filter.png")); //$NON-NLS-1$)
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setLayout(new GridLayout());

		filterTypesTree = new CheckBoxFilteredTree(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL, new PatternFilter(), true);
		filterTypesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));

		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));

		filterTypesTreeViewer = (CheckboxTreeViewer)filterTypesTree.getViewer();

		filterTypesTreeViewer.setContentProvider(new FilterTypeContentProvider());
		filterTypesTreeViewer.setLabelProvider(new FilterTypeLabelProvider());

		filterTypesTreeViewer.setInput(fPage.getInput());

		filterTypesTreeViewer.setAllChecked(true);

		return parent;
	}

	@Override
	protected void okPressed() {

		MatchFilter typeFilter = new TypesMatchFilter(filterTypesTreeViewer.getCheckedElements());
		MatchFilter[] filters = new MatchFilter[1];
		filters[0] = typeFilter;
		AbstractTextSearchResult input = fPage.getInput();
		if(input instanceof PapyrusSearchResult) {
			input.setActiveMatchFilters(filters);
			((PapyrusSearchResult)input).setPossibleMatchFilter(filters);
		}

		super.okPressed();
	}

}
