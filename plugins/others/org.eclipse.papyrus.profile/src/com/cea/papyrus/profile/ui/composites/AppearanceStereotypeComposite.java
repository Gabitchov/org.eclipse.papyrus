/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile.ui.composites;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import com.cea.papyrus.profile.Activator;
import com.cea.papyrus.profile.preference.ProfilePreferenceConstants;
import com.cea.papyrus.profile.tree.ProfileElementContentProvider;
import com.cea.papyrus.profile.tree.ProfileElementLabelProvider;
import com.cea.papyrus.profile.tree.ProfileElementTreeViewerFilter;
import com.cea.papyrus.profile.tree.objects.PropertyTreeObject;
import com.cea.papyrus.profile.tree.objects.RootElementTreeObject;
import com.cea.papyrus.profile.ui.panels.StereotypePanel;

/**
 * The Class StereotypeComposite.
 */
public class AppearanceStereotypeComposite extends AppearanceDecoratedTreeComposite implements ISelectionChangedListener {

	// the parent panel instance
	/**
	 * The parent panel.
	 */
	private StereotypePanel parentPanel;

	// GUI related declarations
	/**
	 * The label.
	 */
	protected CLabel label;

	/**
	 * The default constructor.
	 * 
	 * @param style the style of this panel
	 * @param parent the parent Composite for this panel
	 */
	public AppearanceStereotypeComposite(StereotypePanel parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);

		parentPanel = parent;
	}

	/**
	 * 
	 * 
	 * @param parent 
	 */
	public AppearanceStereotypeComposite(Composite parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);
	}


	/**
	 * 
	 * 
	 * @param factory 
	 * @param parent 
	 * 
	 * @return 
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createStereotypesTree();

		return this;
	}

	/**
	 * Gets the selected.
	 * 
	 * @return Returns the selected element.
	 */
	public Element getSelected() {
		return parentPanel.getSelected();
	}

	/**
	 * Gets the tree.
	 * 
	 * @return the tree
	 */
	public Tree getTree() {
		return treeViewer.getTree();
	}

	/**
	 * Sets the input.
	 * 
	 * @param element the element
	 */
	public void setInput(RootElementTreeObject element) {
		treeViewer.setInput(element);
		//boolean toto = Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STERETOYPES_TREE);
		if(Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STEREOTYPES_TREE)) {
			treeViewer.expandAll();
		}
	}

	/**
	 * Refresh the content of applied the applied stereotype tree.
	 */
	@Override
	public void refresh() {

		if(treeViewer.getTree()!= null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.refresh();
		}
	}


	/**
	 * Creates the stereotypes tree.
	 * 
	 * @return the tree of applied stereotypes and properties
	 */
	private void createStereotypesTree() {
		// Tree viewer shows applied stereotypes
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());
		treeViewer.addFilter(new ProfileElementTreeViewerFilter());
		treeViewer.addSelectionChangedListener(this);
	}


	/**
	 * stereotypes display handling *.
	 * 
	 * @param st 
	 */
	protected void addStereotypeDisplay(Stereotype st) {
		//do nothing
	}

	/**
	 * 
	 * 
	 * @param appliedStereotypes 
	 */
	protected void buildStereotypeDisplay(EList<?> appliedStereotypes) {
		//do nothing
	}

	/**
	 * 
	 * 
	 * @param st 
	 */
	protected void removeStereotypeDisplay(Stereotype st){
		//do nothing
	}

	/**
	 * 
	 * 
	 * @param st 
	 * 
	 * @return 
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		return false;
	}

	/**
	 * 
	 * 
	 * @param stereotype 
	 */
	protected void removeStereotypePropertiesDisplay(Stereotype stereotype){
		//do nothing
	}

	/**
	 * 
	 * 
	 * @param event 
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if(parentPanel != null){
			if (event == null) {
				parentPanel.setSelectedProperty(null);
				return;
			}

			IStructuredSelection structSelection = (IStructuredSelection) event.getSelection();
			Object selection = structSelection.getFirstElement();
			if (selection instanceof PropertyTreeObject) {
				parentPanel.setSelectedProperty((PropertyTreeObject) selection);
			} else {
				parentPanel.setSelectedProperty(null);
			}
		}
	}
}
