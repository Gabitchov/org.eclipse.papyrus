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
package org.eclipse.papyrus.profile.ui.compositesformodel;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.profile.tree.objects.ValueTreeObject;
import org.eclipse.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import org.eclipse.papyrus.profile.ui.dialogs.InputDialogEnumeration;
import org.eclipse.papyrus.profile.ui.dialogs.InputDialogPrimitiveType;
import org.eclipse.papyrus.profile.ui.listeners.DoubleClickListener;
import org.eclipse.papyrus.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyComposite.
 */
public class PropertyComposite extends DecoratedTreeComposite {

	/**
	 * The parent panel.
	 */
	protected AppliedStereotypePanel parentPanel;

	/**
	 * Creates a new PropertyComposite.
	 * 
	 * @param parent
	 *            the parent StereotypePanel
	 */
	public PropertyComposite(AppliedStereotypePanel parent) {
		super(parent, SWT.NONE, "Property values", false);

		parentPanel = parent;
	}

	/**
	 * Creates a new PropertyComposite.
	 * 
	 * @param parent
	 *            the composite parent
	 */
	public PropertyComposite(Composite parent) {
		super(parent, SWT.NONE, "Property values", false);
	}

	protected AppliedStereotypePanel getParentPanel() {
		return parentPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.composites.DecoratedTableComposite#createContent(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory)
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createPropTree();

		return this;
	}

	/**
	 * Creates the prop tree.
	 */
	protected void createPropTree() {

		// List of applied profiles
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());

		if (parentPanel != null)
			getTree().addListener(SWT.MouseDoubleClick, new DoubleClickListener(parentPanel, treeViewer));
	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {

		if (treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.refresh();

			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
			if (pTO == null) {
				this.setVisible(false);
			} else if ((pTO.getProperty() != null) && pTO.getProperty().isReadOnly()) {
				upButton.setEnabled(false);
				downButton.setEnabled(false);
				removeButton.setEnabled(false);
				addButton.setEnabled(false);
			} else {
				upButton.setEnabled(true);
				downButton.setEnabled(true);
				removeButton.setEnabled(true);
				addButton.setEnabled(true);

				// If the property is Multivalued show Up - Down
				if ((pTO.getChildren() != null) && (pTO.getChildren().length > 1)) {
					upButton.setEnabled(true);
					downButton.setEnabled(true);
				} else {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				}

				if ((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getLower())) {
					removeButton.setEnabled(false);
				} else {
					removeButton.setEnabled(true);
				}

				if ((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getUpper())) {
					addButton.setEnabled(false);
				} else {
					addButton.setEnabled(true);
				}

				this.setVisible(true);
			}
		}

	}

	/**
	 * Action triggered when the add button is pressed.
	 */
	@Override
	public void addButtonPressed() {

		// Retrieve selections
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		Property selectedProp = pTO.getProperty();
		Stereotype selectedSt = ((AppliedStereotypeTreeObject) pTO.getParent()).getStereotype();
		Element selectedElt = ((StereotypedElementTreeObject) pTO.getParent().getParent()).getElement();

		if ((selectedProp == null) || (selectedSt == null) || (selectedElt == null)) {
			// Nothing selected
			return;
		}

		// Retrieve property related info
		int lower = selectedProp.getLower();
		int upper = selectedProp.getUpper();
		Type type = selectedProp.getType();
		String typeName = type.getName();

		// if lower multiplicity is equal to upper multiplicity : cannot add
		if (lower == upper && selectedElt.getValue(selectedSt, selectedProp.getName()) != null) {
			if (selectedElt.getValue(selectedSt, selectedProp.getName()) instanceof EList) {
				if (((EList) selectedElt.getValue(selectedSt, selectedProp.getName())).size() >= upper) {
					Message.warning("Multiplicity of this property is " + selectedProp.getLower() + ".." + selectedProp.getUpper() + "\n" + "Impossible to add a new value.");
					return;
				}
			} else {
				Message.warning("Multiplicity of this property is " + selectedProp.getLower() + ".." + selectedProp.getUpper() + "\n" + "Impossible to add a new value.");
				return;
			}
		}

		// Retrieve current value
		ArrayList tempValues = new ArrayList();
		Object currentValue = null;
		if (selectedElt.hasValue(selectedSt, selectedProp.getName())) {
			currentValue = selectedElt.getValue(selectedSt, selectedProp.getName());

			if (upper == 1) {
				tempValues.add(currentValue);

			} else { // if (upper != 1) {
				EList currentValues = (EList) currentValue;
				for (int i = 0; i < currentValues.size(); i++) {
					tempValues.add(currentValues.get(i));
				}
			}
		}

		if (selectedProp.isMultivalued() || (tempValues.size() < upper)) {

			Object newValue = null;

			/** primitive type **/
			if (type instanceof PrimitiveType) {

				// Create dialog box for value to add
				InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(this.getShell(), selectedProp, null, -1);
				int val = valueDialog.open();

				// Treat Cancel case first
				if (val == InputDialogPrimitiveType.CANCEL) {
					// Close dialog box
					valueDialog.close();
					// And quit
					return;
				}

				// New object as string (user input)
				String dialogValue = valueDialog.getValue();
				// Treat dialogValue
				newValue = Util.getValueObjectFromString(dialogValue, type);
				valueDialog.close();

			}
			/** DataType **/
			else if ((type instanceof DataType && !(type instanceof Enumeration))) {
				// VSLLabelEditorDialog valueDialog = new VSLLabelEditorDialog(this.getShell(), "", 0, (DataType)type);
				// int val = valueDialog.open();

				// Treat Cancel case first
				// if (val == InputDialogPrimitiveType.CANCEL) {
				// Close dialog box
				// valueDialog.close();
				// And quit
				return;
				// }

				// New object as string (user input)
				// String dialogValue = valueDialog.getValue();
				// Treat dialogValue
				// newValue = Util.getValueObjectFromString(dialogValue, type);
				// valueDialog.close();
			}

			/** Composite **/
			else if ((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && selectedProp.isComposite()) {

				// Profile profile = selectedSt.getProfile();
				// Type uml2Type = profile.getOwnedType(typeName);
				//				
				// // Create new value
				// newValue = profile.create((Classifier) uml2Type);
				// ToDo
				return;

				/** Enumeration **/
			} else if (type instanceof Enumeration) {

				// Create and Open combo box
				InputDialogEnumeration valueDialog = new InputDialogEnumeration(this.getShell(), selectedProp, null, -1);
				int val = valueDialog.open();

				if ((val == InputDialogEnumeration.OK) && (valueDialog.getSelectionIndex() != -1)) {
					int index = valueDialog.getSelectionIndex();
					newValue = ((Enumeration) type).getOwnedLiterals().get(index);
				}
				valueDialog.close();

				/** Stereotype **/
			} else if (type instanceof Stereotype) {
				final ArrayList filteredElements = Util.getInstancesFilteredByType(selectedElt, null, (Stereotype) type);

				// Prepare possible selection for dialog box
				String[] elementsNames = Util.getStringArrayFromList(filteredElements);
				// if no possible selection : abort
				if (elementsNames == null) {
					Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
					return;
				}

				// Retrieve initial value...
				String initialValue = "";
				if (elementsNames.length > 0) {
					initialValue = elementsNames[0];
				}

				// Creates and open selection dialog
				ComboSelectionDialog valueDialog = new ComboSelectionDialog(this.getShell(), "New value:", elementsNames, initialValue);
				int val = valueDialog.open();
				if (val == ComboSelectionDialog.OK) {
					int index = valueDialog.indexOfSelection;
					Element dialogSelectedElt = (Element) filteredElements.get(index);
					newValue = dialogSelectedElt.getStereotypeApplication((Stereotype) type);
					if (newValue == null) {
						EList subStereotypes = dialogSelectedElt.getAppliedSubstereotypes((Stereotype) type);
						if (!subStereotypes.isEmpty()) {
							newValue = dialogSelectedElt.getStereotypeApplication((Stereotype) subStereotypes.get(0));
						}
					}
				}
				valueDialog.close();

				/** Metaclass **/
			} else if (Util.isMetaclass(type)) {

				// Retrieve type of the metaclass
				Class metaType = null;
				try {
					metaType = Class.forName("org.eclipse.uml2.uml." + typeName);
				} catch (Exception ex) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getLocalizedMessage()));
					ex.printStackTrace();
					// and quit
					return;
				}

				// Retrieve all instances applicable to this property value
				final ArrayList filteredElements = Util.getInstancesFilteredByType(selectedElt, metaType, null);
				// If multivalued remove already applied elements from list
				// Removed already added elements from selection list
				if (tempValues != null) {
					filteredElements.removeAll(tempValues);
				}

				// Prepare possible selection for dialog box
				String[] elementsNames = Util.getStringArrayFromList(filteredElements);
				// if no possible selection : abort
				if (elementsNames == null) {
					Message.warning("No element typed <<" + type.getName() + ">> was found in the model.");
					return;
				}

				// Retrieve initial value...
				String initialValue = "";
				if (elementsNames.length > 0) {
					initialValue = elementsNames[0];
				}

				// Create and open combo
				ComboSelectionDialog valueDialog = new ComboSelectionDialog(this.getShell(), "New value:", elementsNames, initialValue);
				int val = valueDialog.open();
				if (val == ComboSelectionDialog.OK) {
					newValue = filteredElements.get(valueDialog.indexOfSelection);
					valueDialog.close();
				}
			}

			// new value entered ?
			if (newValue == null) {
				// Refresh && quit
				if (parentPanel != null)
					parentPanel.refresh();
				return;
			}

			// Update property value(s)
			if (selectedProp.isMultivalued()) {
				// If newValue was enter, add to tempValues (future values list)
				tempValues.add(newValue);
				selectedElt.setValue(selectedSt, selectedProp.getName(), tempValues);
				// otherwise
			} else {
				selectedElt.setValue(selectedSt, selectedProp.getName(), newValue);
			}

			// Update tree && Refresh
			pTO.addChild(ValueTreeObject.createInstance(pTO, newValue));
			if (parentPanel != null)
				parentPanel.refresh();
			// Force model change
			if (parentPanel != null)
				Util.touchModel(selectedElt);

		} else {
			Message.warning("Upper multiplicity of " + selectedProp.getName() + " is " + selectedProp.getUpper());
		}
	}

	/**
	 * Action triggered when the remove button is pressed.
	 */
	@Override
	public void removeButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection == 0) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[i].getData();
			vTO.removeMe();
		}
		if (parentPanel != null)
			parentPanel.refresh();
	}

	/**
	 * Action triggered when the up button is pressed.
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if (indexFirst == 0) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[i].getData();
			int index = getTree().indexOf(items[i]);
			vTO.moveMeUp(index);
		}
		if (parentPanel != null)
			parentPanel.refresh();
	}

	/**
	 * Action triggered when the down button is pressed.
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		// Get last value index
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		int indexLastValue = -1;
		if (pTO.getChildren() != null) {
			indexLastValue = pTO.getChildren().length - 1;
		}
		// Get last selection index
		int indexLastSelection = getTree().indexOf(items[nbrOfSelection - 1]);
		if ((indexLastValue == -1) || (indexLastSelection == indexLastValue)) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[nbrOfSelection - 1 - i].getData();
			int index = getTree().indexOf(items[nbrOfSelection - 1 - i]);
			vTO.moveMeDown(index);
		}

		if (parentPanel != null)
			parentPanel.refresh();
	}

	/**
	 * Sets the input.
	 * 
	 * @param element
	 *            the element
	 */
	public void setInput(AppliedStereotypePropertyTreeObject element) {
		treeViewer.setInput(element);
		refresh();
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
	 * 
	 * 
	 * @param item
	 */
	@Override
	public void editItem(TreeItem item) {
		// do nothing
	}

}
