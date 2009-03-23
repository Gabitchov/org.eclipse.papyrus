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
package com.cea.papyrus.profile.tree.objects;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.cea.papyrus.profile.Message;
import com.cea.papyrus.profile.tree.ProfileElementLabelProvider;
import com.cea.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import com.cea.papyrus.profile.utils.Util;


// TODO: Auto-generated Javadoc
/**
 * The Class MetaclassValueTreeObject.
 */
public class MetaclassValueTreeObject extends ValueTreeObject {
	
	/**
	 * The Constructor.
	 * 
	 * @param value the value
	 * @param parent the parent
	 */
	public MetaclassValueTreeObject(PropertyTreeObject parent, Object value) {
		super(parent, value);
		this.value = value;
	}
	
	/**
	 * Edits the me.
	 */
	@Override
	public void editMe() {
		PropertyTreeObject pTO = (PropertyTreeObject) getParent();
		Element elt = ((RootElementTreeObject) getParent().getParent().getParent()).getElement();
		Property property = pTO.getProperty();
		Type type = property.getType();
		
		// Try to retrieve type of the metaclass
		Class metaType  = null;
		try {
			metaType = Class.forName("org.eclipse.uml2.uml." + type.getName());							
		} catch (Exception e) {
			Message.error("No class found with this name : org.eclipse.uml2.uml."+type.getName());
			return;
		}

		// Fetching all instances in the model applicable to this property value
		final ArrayList filteredElements = Util.getInstancesFilteredByType(elt, metaType, null);
		// No element : error !!!
		if (filteredElements.size() <= 0) {
			Message.warning(
					"No element of type "
					+type.getName()
					+" found in the model.");
			return;
		}
		
		// Removed already added elements from selection list
		// Except current selection which is default one !!!
		if (property.isMultivalued()) {
			List values = (List) pTO.getValue();
			if (values != null) {
				filteredElements.removeAll(values);					
			}
			filteredElements.add(value);
		}

		String[] elementsNames = Util.getStringArrayFromList(filteredElements);
		
		
		// if no possible selection : abort
		if (elementsNames == null) {
			Message.warning(
					"No element of type "
					+type.getName()
					+" found in the model.");
			return;
		}
		
		ProfileElementLabelProvider labelProvider = new ProfileElementLabelProvider();
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(new Shell(), "New value:", elementsNames, labelProvider.getText(this));
		int val = valueDialog.open();
		if ((val == ComboSelectionDialog.OK) && (valueDialog.indexOfSelection != -1)) {
			Object newValue = filteredElements.get(valueDialog.indexOfSelection);
			updateValue(newValue);
		}
		
		// Close dialog box and refresh table
		valueDialog.close();
	}
}
