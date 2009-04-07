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

import org.eclipse.emf.ecore.EObject;
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
 * The Class StereotypeListener.
 */
public class StereotypeListener extends PropertyListener {

	/**
	 * The Constructor.
	 * 
	 * @param table the table
	 * @param element the element
	 * @param stereotype the stereotype
	 * @param property the property
	 * @param parent the parent
	 * 
	 * @throws Exception the exception
	 */
	public StereotypeListener(AbstractPanel parent, Table table, Property property, Stereotype stereotype, Element element) throws Exception {
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
	 * @param event the event
	 */
	@Override
	public void handleEvent(Event event) {
		final ArrayList filteredElements = Util.getInstancesFilteredByType(element, null, (Stereotype) property.getType());
		// No element : error !!!
		if (filteredElements.size() <= 0) {
			Message.warning(
					"No element stereotyped "
					+((Stereotype) property.getType()).getName()
					+" found in the model.");
			return;
		}

		itemDClicked(filteredElements);
	}

	/**
	 * When doubleclicked : opens a dialog to allow edition of a new Stereotype typed property.
	 * 
	 * @param selectedElt the element that owns the stereotype
	 * @param value an Object or List of Object if isMultivalued
	 * @param isMultivalued is the property multivalued or not
	 * @param selectedProp the selected property
	 * @param currentStereotype the stereotype associated to selectedProp
	 * @param filteredElts list of instances in the model that are possible values for this property
	 */
	private void itemDClicked(ArrayList filteredElts) {
		Type type = property.getType();

		// Selected value index
		int index = table.getSelectionIndex();
		
		// Prepare possible selection for dialog box
		String[] elementsNames = Util.getStringArrayFromList(filteredElts);
		// if no possible selection : abort
		if (elementsNames == null) {
			Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
			return;
		}

		// Retrieve initial value...
		String initialValue = "";
		if (index != -1) {
			initialValue = table.getItem(index).getText();		
		} else if (elementsNames.length > 0) {
			initialValue = elementsNames[0];
		}
		
		// Create and open combo box
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(parent.getShell(), "New value:", elementsNames, initialValue);
		int val = valueDialog.open();

		if ((val == InputDialog.OK) && (valueDialog.indexOfSelection != -1)) {
			Element dialogSelectedElement = (Element) filteredElts.get(valueDialog.indexOfSelection);
			EObject eObject = dialogSelectedElement.getStereotypeApplication((Stereotype) type);
			if (isMultivalued) {
				values.set(index, eObject);
				element.setValue(stereotype, property.getName(), values);
				
			} else {
				element.setValue(stereotype, property.getName(), eObject);
			}
			// Force model change
			Util.touchModel(element);
		}

		// Close dialog box and refresh table
		valueDialog.close();
		parent.refresh();
	}	
}