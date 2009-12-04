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
package org.eclipse.papyrus.profile.ui.listeners;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import org.eclipse.papyrus.profile.ui.panels.AbstractPanel;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;


// TODO: Auto-generated Javadoc
/**
 * The Class MetaclassListener.
 */
public class MetaclassListener extends PropertyListener {

	/**
	 * The Constructor.
	 * 
	 * @param table
	 *        the table
	 * @param element
	 *        the element
	 * @param stereotype
	 *        the stereotype
	 * @param property
	 *        the property
	 * @param parent
	 *        the parent
	 * 
	 * @throws Exception
	 *         the exception
	 */
	public MetaclassListener(AbstractPanel parent, Table table, Property property, Stereotype stereotype, Element element) throws Exception {
		super(parent, table, property, stereotype, element);
		try {
			init();
		} catch (NoValueException e) {
			throw e;
		}
	}

	/**
	 * Handle event.
	 * 
	 * @param event
	 *        the event
	 */
	@Override
	public void handleEvent(Event event) {
		Type type = property.getType();
		// Try to retrieve type of the metaclass
		Class metaType = null;
		try {
			metaType = Class.forName("org.eclipse.uml2.uml." + type.getName());
		} catch (Exception e) {
			Message.error("No class found with this name : org.eclipse.uml2.uml." + type.getName());
			return;
		}

		// Fetching all instances in the model applicable to this property value
		final ArrayList filteredElements = Util.getInstancesFilteredByType(element, metaType, null);
		// No element : error !!!
		if(filteredElements.size() <= 0) {
			Message.warning(
					"No element stereotyped "
					+ ((Stereotype)type).getName()
					+ " found in the model.");
			return;
		}

		itemDClicked(filteredElements);
	}

	/**
	 * When doubleclicked : opens a dialog to allow edition of a new Metaclass
	 * for multivalued property.
	 * 
	 * @param selectedElt
	 *        the element that owns the stereotype
	 * @param value
	 *        the current value or list of values of the property if isMultivalued
	 * @param isMultivalued
	 *        is the property multivalued or not
	 * @param selectedProp
	 *        the selected property
	 * @param filteredElements
	 *        list of instances in the model that are possible values for this property
	 * @param currentStereotype
	 *        the stereotype associated to selectedProp
	 * @param filteredElts
	 *        the filtered elts
	 */
	private void itemDClicked(ArrayList filteredElts) {
		Type type = property.getType();

		// selected value index
		int index = table.getSelectionIndex();
		if(index == -1) {
			return;
		}
		// Removed already added elements from selection list
		// Except current selection which is default one !!!
		if(isMultivalued) {
			if(values != null) {
				filteredElts.removeAll(values);
			}
			filteredElts.add(table.getItem(index).getData());
		}

		String[] elementsNames = Util.getStringArrayFromList(filteredElts);
		// if no possible selection : abort
		if(elementsNames == null) {
			Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
			return;
		}

		// Retrieve initial value...
		String initialValue = "";
		initialValue = table.getItem(index).getText();
		if(initialValue.equals("") && (elementsNames.length > 0)) {
			initialValue = elementsNames[0];
		}

		ComboSelectionDialog valueDialog = new ComboSelectionDialog(parent.getShell(), "New value:", elementsNames, initialValue);

		int val = valueDialog.open();
		if((val == InputDialog.OK) && (valueDialog.indexOfSelection != -1)) {
			// Affect newValue
			if(isMultivalued) {
				// Set newValue in value list
				ArrayList newValues = new ArrayList();
				newValues.addAll(values);
				newValues.set(index, filteredElts.get(valueDialog.indexOfSelection));
				element.setValue(stereotype, property.getName(), newValues);
			} else {
				element.setValue(stereotype, property.getName(), filteredElts.get(valueDialog.indexOfSelection));
			}
			// Force model change
			Util.touchModel(element);
		}

		// Close dialog box and refresh table
		valueDialog.close();
		parent.refresh();
	}
}
