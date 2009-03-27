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
package org.eclipse.papyrus.profile.ui.composites;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.profile.preference.ProfilePreferenceConstants;
import org.eclipse.papyrus.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.profile.tree.objects.PropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.RootElementTreeObject;
import org.eclipse.papyrus.profile.tree.objects.StereotypeTreeObject;
import org.eclipse.papyrus.profile.ui.dialogs.ChooseSetStereotypeDialog;
import org.eclipse.papyrus.profile.ui.panels.StereotypePanel;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


/**
 * The Class StereotypeComposite.
 */
public class StereotypeComposite extends DecoratedTreeComposite implements ISelectionChangedListener {

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
	public StereotypeComposite(StereotypePanel parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);

		parentPanel = parent;
	}

	/**
	 * 
	 * 
	 * @param parent 
	 */
	public StereotypeComposite(Composite parent) {
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

			RootElementTreeObject rTO = (RootElementTreeObject) treeViewer.getInput();
			if (rTO == null) {
				return;
			}

			// If the property is Multivalued show Up - Down
			if ((rTO.getChildren() != null) && (rTO.getChildren().length > 1)) {
				upButton.setEnabled(true);
				downButton.setEnabled(true);
			} else {
				upButton.setEnabled(false);
				downButton.setEnabled(false);
			}

			if ((rTO.getChildren() != null) && (rTO.getChildren().length == 0)) {
				removeButton.setEnabled(false);
			} else {
				removeButton.setEnabled(true);
			}
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
	 * Button action :
	 * open a selection dialog box that allow the user to choose stereotypes to apply (or unapply).
	 */
	@Override
	public void addButtonPressed() {

		// Open stereotype selection (may add or remove)
		ChooseSetStereotypeDialog dialog = new ChooseSetStereotypeDialog(this.getShell(), getSelected());
		int result = dialog.open();

		if(result == ChooseSetStereotypeDialog.OK) {
			// Retrieve selected element
			Element element = getSelected();

			// compare the 2 lists (present list and future list
			EList<Stereotype> oldStereotypeList = element.getAppliedStereotypes();
			ArrayList<Stereotype> newStereotypeList = dialog.getSelectedElements();

			// Keep newStereotype order (will be used at the end of the method)
			EList<Stereotype> newOrderList = new BasicEList<Stereotype>();
			newOrderList.addAll(newStereotypeList);

			// If the 2 lists differ, apply the new list of stereotypes
			if(!(newStereotypeList.equals(oldStereotypeList))) {

				// Parse old list :
				// if stereotype is in the new list : it is already applied
				// --> don't unapply it
				// --> remove it from new list
				Iterator<Stereotype> it = oldStereotypeList.iterator();
				while(it.hasNext()) {
					Stereotype currentStOld = (Stereotype) it.next();
					if (newStereotypeList.contains(currentStOld)) {
						newStereotypeList.remove(currentStOld);
					} else {
						// stereotype display handling: do nothing in this class. This aspect is handled in specializations
						removeStereotypePropertiesDisplay(currentStOld);
						removeStereotypeDisplay(currentStOld);

						element.unapplyStereotype(currentStOld);
					}
				}

				// Already applied stereotype should have been removed
				// apply others
				Iterator<Stereotype> newApplyStereotypes = newStereotypeList.iterator();
				while(newApplyStereotypes.hasNext()) {
					Stereotype currentStereotype = (Stereotype) newApplyStereotypes.next();
					element.applyStereotype(currentStereotype);

					// stereotype display handling: do nothing in this class. This aspect is handled in specializations
					addStereotypeDisplay(currentStereotype);
				}

				// Update Stereotype order
				Util.reorderStereotypeApplications(element, newOrderList);

				// build stereotype display
				buildStereotypeDisplay(element.getAppliedStereotypes());

				// Rebuild the whole tree - with no selection
				treeViewer.setInput(new RootElementTreeObject(element));
				//checkSelection(null);
				selectionChanged(null);

				if(parentPanel!=null) {
					parentPanel.refresh();
				} else {
					refresh();
				}
				
				// Force model change
				if (parentPanel != null) {
					Util.touchModel(getSelected());
				}
			}
		}
	}


	/**
	 * Button action :
	 * unaply the stereotypes selected by the user in the stereotype tree.
	 */
	@Override
	public void removeButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection == 0) {
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item  = getTree().getSelection()[i];
			if (item.getData() instanceof StereotypeTreeObject) {
				StereotypeTreeObject sTO = (StereotypeTreeObject) item.getData();

				// stereotype display handling
				removeStereotypePropertiesDisplay(sTO.getStereotype());
				removeStereotypeDisplay(sTO.getStereotype());
				sTO.removeMe();
			}
		}
		if(parentPanel!=null)
			parentPanel.refresh();
		else
			refresh();
	}

	/**
	 * Button action :
	 * modify display order of stereotypes (selected elements are pushed up in the list).
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items  = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if (indexFirst == 0) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item  = items[i];
			if (item.getData() instanceof StereotypeTreeObject) {
				StereotypeTreeObject sTO = (StereotypeTreeObject) item.getData();
				sTO.moveMeUp();
				if(isInStereotypeDisplay(sTO.getStereotype())) {
					buildStereotypeDisplay(getElement().getAppliedStereotypes());
				}
			}
		}
		if(parentPanel!=null)
			parentPanel.refresh();
		else
			refresh();
	}

	/**
	 * Button action :
	 * modify display order of stereotypes (selected elements are pushed down in the list).
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items  = getTree().getSelection();
		int indexLast = getTree().indexOf(items[items.length-1]);
		if (indexLast + 1 >= getSelected().getAppliedStereotypes().size()) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item  = items[nbrOfSelection-1 -i];
			if (item.getData() instanceof StereotypeTreeObject) {
				StereotypeTreeObject sTO = (StereotypeTreeObject) item.getData();
				sTO.moveMeDown();
				if(isInStereotypeDisplay(sTO.getStereotype())) {
					buildStereotypeDisplay(getElement().getAppliedStereotypes());
				}
			}
		}
		if(parentPanel!=null)
			parentPanel.refresh();
		else
			refresh();
	}


	/**
	 * 
	 * 
	 * @param item 
	 */
	@Override
	public void editItem(TreeItem item){
		// do nothing
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
	protected void buildStereotypeDisplay(EList<Stereotype> appliedStereotypes) {
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
