/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.compositesformodel;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.tree.objects.ValueTreeObject;
import org.eclipse.papyrus.profile.ui.section.AppliedStereotypePropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * The goal of this composite is make properties of applied stereotype editable see class AppliedStereotypeEditor
 */
public class PropertyComposite extends DecoratedTreeComposite {

	public TransactionalEditingDomain getDomain() {
		return domain;
	}

	public void setDomain(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	protected TransactionalEditingDomain domain;

	/**
	 * Creates a new PropertyComposite.
	 * 
	 * @param parent
	 *        the composite parent
	 */
	public PropertyComposite(Composite parent) {
		super(parent, SWT.NONE, "Property values", false);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.composites.DecoratedTableComposite#createContent(org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory)
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
	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {

		if(treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.refresh();

			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)treeViewer.getInput();
			if(pTO == null) {
				this.setVisible(false);
			} else if((pTO.getProperty() != null) && pTO.getProperty().isReadOnly()) {
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
				if((pTO.getChildren() != null) && (pTO.getChildren().length > 1)) {
					upButton.setEnabled(true);
					downButton.setEnabled(true);
				} else {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				}

				if((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getLower())) {
					removeButton.setEnabled(false);
				} else {
					removeButton.setEnabled(true);
				}

				if((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getUpper())) {
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
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)treeViewer.getInput();
		Property property = pTO.getProperty();
		Stereotype selectedSt = ((AppliedStereotypeTreeObject)pTO.getParent()).getStereotype();
		Element selectedElt = ((StereotypedElementTreeObject)pTO.getParent().getParent()).getElement();

		if((property == null) || (selectedSt == null) || (selectedElt == null)) {
			// Nothing selected
			return;
		}

		// Retrieve property related info
		int lower = property.getLower();
		int upper = property.getUpper();
		Type type = property.getType();
		String typeName = type.getName();

		// if lower multiplicity is equal to upper multiplicity : cannot add
		if(lower == upper && selectedElt.getValue(selectedSt, property.getName()) != null) {
			if(selectedElt.getValue(selectedSt, property.getName()) instanceof EList) {
				if(((EList)selectedElt.getValue(selectedSt, property.getName())).size() >= upper) {
					Message.warning("Multiplicity of this property is " + property.getLower() + ".." + property.getUpper() + "\n" + "Impossible to add a new value.");
					return;
				}
			} else {
				Message.warning("Multiplicity of this property is " + property.getLower() + ".." + property.getUpper() + "\n" + "Impossible to add a new value.");
				return;
			}
		}

		// Retrieve current value
		ArrayList currentPropertyValues = new ArrayList();
		Object currentValue = null;
		if(selectedElt.hasValue(selectedSt, property.getName())) {
			currentValue = selectedElt.getValue(selectedSt, property.getName());

			if(upper == 1) {
				currentPropertyValues.add(currentValue);

			} else { // if (upper != 1) {
				EList currentValues = (EList)currentValue;
				for(int i = 0; i < currentValues.size(); i++) {
					currentPropertyValues.add(currentValues.get(i));
				}
			}
		}

		if(property.isMultivalued() || (currentPropertyValues.size() < upper)) {
			Object newValue = null;

			// get a new value for the property
			newValue = AppliedStereotypePropertyEditor.getNewValueForProperty(this.getShell(), property, selectedElt, type, currentPropertyValues);
			// new value entered ?
			if(newValue == null) {
				// quit
				return;
			}

			// Update property value(s)
			if(property.isMultivalued()) {
				// If newValue was entered, add to tempValues (future values list)
				if (!currentPropertyValues.contains(newValue)) {
					currentPropertyValues.add(newValue);
					// Update tree && Refresh
					pTO.addChild(ValueTreeObject.createInstance(pTO, newValue, getDomain()));
				}
				setPropertiesValue(selectedElt, selectedSt, property, currentPropertyValues);
			}
			else {
				// otherwise ([0..1] case)
				setPropertiesValue(selectedElt, selectedSt, property, newValue);
				pTO.addChild(ValueTreeObject.createInstance(pTO, newValue, getDomain()));
			}
		}
		else {
			Message.warning("Upper multiplicity of " + property.getName() + " is " + property.getUpper());
		}
	}

	/**
	 * Action triggered when the remove button is pressed.
	 */
	@Override
	public void removeButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection == 0) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		for(int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject)items[i].getData();
			// vTO.removeMe();
			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)treeViewer.getInput();
			Property property = pTO.getProperty();
			Stereotype stereotype = ((AppliedStereotypeTreeObject)pTO.getParent()).getStereotype();
			Element selectedElt = ((StereotypedElementTreeObject)pTO.getParent().getParent()).getElement();

			int lower = property.getLower();
			int upper = property.getUpper();

			// if lower multiplicity is equal to upper multiplicity
			if(lower == upper) {
				Message.warning("Multiplicity of this property is" + lower + ".." + upper + "\n" + "Impossible to remove a value.");
				return;
			}

			Object currentVal = pTO.getValue();
			ArrayList tempValues = new ArrayList();

			if(((lower == 0) && (upper == 1))) {
				if(currentVal != null) {
					tempValues.add(currentVal);
				}

			} else if(upper != 1) {
				EList currentValues = (EList)currentVal;

				for(int j = 0; j < currentValues.size(); j++) {
					tempValues.add(currentValues.get(j));
				}
			}

			if((lower == 0) || (tempValues.size() > lower)) {
				tempValues.remove(vTO.getValue());

				if(property.isMultivalued()) {
					setPropertiesValue(selectedElt, stereotype, property, tempValues);
				} else {
					setPropertiesValue(selectedElt, stereotype, property, null);
				}

				// Force model change
				// Util.touchModel(element);

			} else {
				Message.warning("Lower multiplicity of " + property.getName() + " is " + lower);
			}
			pTO.removeChild(vTO);
		}
	}

	/**
	 * Action triggered when the up button is pressed.
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if(indexFirst == 0) {
			// do nothing
			return;
		}

		for(int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject)items[i].getData();
			int index = getTree().indexOf(items[i]);
			vTO.moveMeUp(index);
		}
	}

	/**
	 * Action triggered when the down button is pressed.
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if(nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		// Get last value index
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)treeViewer.getInput();
		int indexLastValue = -1;
		if(pTO.getChildren() != null) {
			indexLastValue = pTO.getChildren().length - 1;
		}
		// Get last selection index
		int indexLastSelection = getTree().indexOf(items[nbrOfSelection - 1]);
		if((indexLastValue == -1) || (indexLastSelection == indexLastValue)) {
			// do nothing
			return;
		}

		for(int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject)items[nbrOfSelection - 1 - i].getData();
			int index = getTree().indexOf(items[nbrOfSelection - 1 - i]);
			vTO.moveMeDown(index);
		}
	}

	/**
	 * Sets the input.
	 * 
	 * @param element
	 *        the element
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

	protected void setPropertiesValue(final Element element, final Stereotype stereotype, final Property property, final Object newValue) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			history.execute ( new AbstractTransactionalCommand (getDomain (), "Apply stereotype property", Collections.EMPTY_LIST) {
				public CommandResult doExecuteWithResult (IProgressMonitor dummy, IAdaptable info) {
					element.setValue(stereotype, property.getName(), newValue);
	                return CommandResult.newOKCommandResult();
				}
			}, null, null);
		}
		catch (ExecutionException e) {
			e.printStackTrace ();
		}
	}

}
