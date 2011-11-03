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
package org.eclipse.papyrus.profile.tree.objects;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class MetaclassValueTreeObject.
 */
public class MetaclassValueTreeObject extends ValueTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param value
	 *        the value
	 * @param parent
	 *        the parent
	 */
	public MetaclassValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value) {
		super(parent, value);
		this.value = value;
	}

	/**
	 * Edits the me.
	 */
	@Override
	public void editMe() {
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) getParent();
		Element elt = ((StereotypedElementTreeObject) pTO.getParent().getParent()).getElement();
		Property property = pTO.getProperty();
		Type type = property.getType();

		// Try to retrieve type of the metaclass
		@SuppressWarnings("rawtypes")
		Class metaType = null;
		try {
			metaType = Class.forName("org.eclipse.uml2.uml." + type.getName());
		} catch (Exception e) {
			Message.error("No class found with this name : org.eclipse.uml2.uml." + type.getName());
			return;
		}

		// Fetching all instances in the model applicable to this property value
		final ArrayList<Element> filteredElements = Util.getInstancesFilteredByType(elt, metaType, null);
		// No element : error !!!
		if(filteredElements.size() <= 0) {
			Message.warning("No element of type " + type.getName() + " found in the model.");
			return;
		}

		pTO.removeSelected (filteredElements, (Element) value);

		String[] elementNames = Util.getStringArrayFromList(filteredElements);

		// if no possible selection : abort
		if (elementNames == null) {
			Message.warning("No element of type " + type.getName() + " found in the model.");
			return;
		}

		ProfileElementLabelProvider labelProvider = new ProfileElementLabelProvider();
		String initialValue = (value != null ? labelProvider.getText(this) : elementNames[0]);
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(new Shell(), "New value:", elementNames, initialValue);
		int val = valueDialog.open();
		if((val == ComboSelectionDialog.OK) && (valueDialog.indexOfSelection != -1)) {
			Object newValue = filteredElements.get(valueDialog.indexOfSelection);
			pTO.updateValue(pTO.appendMV(newValue));
		}

		// Close dialog box and refresh table
		valueDialog.close();
	}
}
