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

import org.eclipse.emf.transaction.TransactionalEditingDomain;

// TODO: Auto-generated Javadoc
/**
 * The Class StereotypeValueTreeObject.
 */
public class CompositeValueTreeObject extends ValueTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param value
	 *        the value
	 * @param parent
	 *        the parent
	 */
	public CompositeValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value, TransactionalEditingDomain domain) {
		super(parent, value, domain);
		this.value = value;
	}

	/**
	 * Edits the me.
	 */
	@Override
	public void editMe() {

		// ToDo : Implementation
		// PropertyTreeObject pTO = (PropertyTreeObject) getParent();
		// Element elt = ((RootElementTreeObject) getParent().getParent().getParent()).getElement();
		// Property property = pTO.getProperty();
		// Type type = property.getType();
		//		
		// final ArrayList filteredElements = Util.getInstancesFilteredByType(elt.getModel(), null, (Stereotype) type);
		//		
		// String[] elementsNames = Util.getStringArrayFromList(filteredElements);
		// // if no possible selection : abort
		// if (elementsNames == null) {
		// Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
		// return;
		// }
		//		
		// ProfileElementLabelProvider labelProvider = new ProfileElementLabelProvider();
		// ComboSelectionDialog valueDialog = new ComboSelectionDialog(new Shell(), "New value:", elementsNames, labelProvider.getText(this));
		// int val = valueDialog.open();
		// if ((val == ComboSelectionDialog.OK) && (valueDialog.indexOfSelection != -1)) {
		// Element newElement = (Element) filteredElements.get(valueDialog.indexOfSelection);
		// EObject newValue = newElement.getStereotypeApplication((Stereotype) type);
		// updateValue(newValue);
		// }
		//		
		// // Close dialog box and refresh table
		// valueDialog.close();
	}
}
