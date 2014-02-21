/**
 * Copyright (c) 2012 CEA-LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *  Gregoire Dupe (Mia-Software) - Bug 357621 - Improve the label displayed for Customization and Facets
 *  Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *  Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.preferences.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.FilteredTree;

public class ETypedElementSelectionControlManager implements
		IETypedElementSelectionControlManager {

	// this map does the link between the tabItem and the filtered trees
	private final Map<TabItem, IETypedElementTabSelectionWidgetInternal> trees;
	private TabFolder tabFolder;
	private final Composite parentComposite;
	private final int selectionMaxSize;

	/**
	 * true if empty selection is allowed
	 */
	private final boolean emptySelection;
	private final ICustomizationManager customManager;
	private Collection<? extends ETypedElement> availableElements;
	private final Collection<? extends EObject> knownEPackage;

	public ETypedElementSelectionControlManager(
			final Composite parentComposite, final int selectionMaxSize,
			final boolean emptySelection,
			final ICustomizationManager customManager,
			final Collection<? extends EObject> knownEPackage) {

		this.trees = new HashMap<TabItem, IETypedElementTabSelectionWidgetInternal>();
		this.parentComposite = parentComposite;
		this.selectionMaxSize = selectionMaxSize;
		this.emptySelection = emptySelection;
		this.customManager = customManager;
		this.knownEPackage = knownEPackage;
	}

	private static Composite createComposite(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		return composite;
	}

	private void init() {
		this.tabFolder = new TabFolder(this.parentComposite, SWT.TOP);
		this.tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));

		// we create the flat tree
		final TabItem flatItem = new TabItem(this.tabFolder, SWT.NONE);

		final Composite flatComposite = createComposite(this.tabFolder);
		IETypedElementTabSelectionWidgetInternal filteredTree = new ETypedElementSelectionControl(
				flatComposite, this.selectionMaxSize, this.emptySelection,
				this.customManager, this.knownEPackage);
		flatItem.setText(filteredTree.getTitle());
		flatItem.setToolTipText(filteredTree.getToolTipText());
		flatItem.setImage(filteredTree.getImage());
		this.trees.put(flatItem, filteredTree);
		flatItem.setControl(flatComposite);
		// we create the sortedTabItem
		final TabItem sortedItem = new TabItem(this.tabFolder, SWT.NONE);
		final Composite sortedComposite = createComposite(this.tabFolder);
		filteredTree = new ETypedElementSelectionSortedControl(sortedComposite,
				this.selectionMaxSize, this.emptySelection, this.customManager,
				this.knownEPackage);
		sortedItem.setText(filteredTree.getTitle());
		sortedItem.setToolTipText(filteredTree.getToolTipText());
		sortedItem.setImage(filteredTree.getImage());
		sortedItem.setControl(sortedComposite);
		this.trees.put(sortedItem, filteredTree);
		initSelectedTabItem();
	}

	private IETypedElementTabSelectionWidgetInternal getActiveTree() {
		// selectionIndex: Index of the selected tab
		final int selectionIndex = this.tabFolder.getSelectionIndex();
		final TabItem currentTabItem = this.tabFolder
				.getItem(selectionIndex);
		return this.trees.get(currentTabItem);
	}

	public void addOpenListener(final IOpenListener openListener) {
		for (IETypedElementSelectionWidgetInternal tree : this.trees.values()) {
			tree.addOpenListener(openListener);
		}
	}

	public void addSelectionChangedListener(
			final ISelectionChangedListener listener) {
		for (IETypedElementSelectionWidgetInternal tree : this.trees.values()) {
			tree.addSelectionChangedListener(listener);
		}
	}

	/**
	 * Set the focus on the last selected TabItem
	 */
	private void initSelectedTabItem() {
		final IPreferenceStore store = Activator.getDefault()
				.getPreferenceStore();
		final String value = store
				.getString(PreferenceConstants.TE_SELECTION_TAB);
		for (TabItem item : this.tabFolder.getItems()) {
			if (item.getText().equals(value)) {
				this.tabFolder.setSelection(item);
				return;
			}
		}
	}

	public IStatus getValidationStatus() {
		return getActiveTree().getValidationStatus();
	}

	public void setAvailableETypedElements(
			final Collection<? extends ETypedElement> availableTE) {
		this.availableElements = availableTE;
		for (IETypedElementSelectionWidgetInternal current : this.trees
				.values()) {
			current.setAvailableETypedElements(availableTE);
		}
	}

	public List<ETypedElement> getSelectedETypedElements() {
		return getActiveTree().getSelectedETypedElements();
	}

	private void updatePreferenceValue() {
		final IPreferenceStore store = Activator.getDefault()
				.getPreferenceStore();
		final String value = getActiveTree().getTitle();
		store.setValue(
				PreferenceConstants.TE_SELECTION_TAB,
				value);
	}

	public void setSelectedETypedElements(
			final Collection<? extends ETypedElement> newSelection) {
		if (newSelection == null) {
			throw new IllegalArgumentException();
		}
		// only select elements that match the filter
		final List<ETypedElement> filteredSelection = new ArrayList<ETypedElement>();
		for (ETypedElement typedElement : newSelection) {
				if (this.availableElements.contains(typedElement)) {
					filteredSelection.add(typedElement);
			}
		}
		setSelection(new StructuredSelection(filteredSelection));
	}

	public void setSelection(final IStructuredSelection selection) {
		for (IETypedElementSelectionWidgetInternal filteredTree : this.trees
				.values()) {
			filteredTree.setSelection(selection);
		}
	}

	public List<ETypedElement> computeResult() {
		// we save the last visible item :
		updatePreferenceValue();
		return getActiveTree().getSelectedETypedElements();
	}

	public boolean isDisposed() {
		return this.tabFolder == null || this.tabFolder.isDisposed() || getActiveTree().isDisposed();
	}

	public FilteredTree getFilteredTree() {
		return getActiveTree().getFilteredTree();
	}

	public void createContents() {
		init();
		for (IETypedElementSelectionWidgetInternal current : this.trees
				.values()) {
			current.createContents();
		}
	}

}