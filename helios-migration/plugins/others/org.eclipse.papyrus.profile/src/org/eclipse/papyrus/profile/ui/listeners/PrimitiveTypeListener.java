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

import org.eclipse.papyrus.profile.ui.dialogs.InputDialogPrimitiveType;
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
 * The Class PrimitiveTypeListener.
 */
public class PrimitiveTypeListener extends PropertyListener {

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
	public PrimitiveTypeListener(AbstractPanel parent, Table table, Property property, Stereotype stereotype, Element element) throws Exception {
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
		itemDClicked();
	}

	/**
	 * When doubleclicked : opens a dialog to allow edition of a new PrimitiveType.
	 * 
	 * @param selectedElt
	 *        the element that owns the stereotype
	 * @param value
	 *        the current value or list of values of the property if isMultivalued
	 * @param isMultivalued
	 *        is the property multivalued or not
	 * @param selectedProp
	 *        the selected property
	 * @param currentStereotype
	 *        the stereotype associated to selectedProp
	 */
	private void itemDClicked() {

		int index = table.getSelectionIndex();
		Type type = property.getType();

		// Creates a dialog box to enter value
		InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(table.getShell(), property, value, index);
		int val = valueDialog.open();

		// Treat Cancel case first
		if(val == InputDialogPrimitiveType.CANCEL) {
			// Close dialog box
			valueDialog.close();
			// And quit
			return;
		}

		// New object as string (user input)
		String dialogValue = valueDialog.getValue();
		// Treat dialogValue
		Object newValue = Util.getValueObjectFromString(dialogValue, type);
		if(newValue != null) {
			// Affect newValue
			if(isMultivalued) {
				// Set newValue in value list
				values.set(index, newValue);
				element.setValue(stereotype, property.getName(), values);
			} else {
				element.setValue(stereotype, property.getName(), newValue);
			}
			// Force model change
			Util.touchModel(element);
		}

		// Close dialog box and refresh table
		valueDialog.close();
		parent.refresh();
	}
}
