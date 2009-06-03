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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class DataTypeValueTreeObject extends ValueTreeObject {

	public DataTypeValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value, TransactionalEditingDomain domain) {
		super(parent, value, domain);
		this.value = value;
	}

	@Override
	public void editMe() {
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) getParent();
		Property property = pTO.getProperty();
		Type type = property.getType();

		// Creates a dialog box to enter value
		// InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(new Shell(), property, getValue());

		// VSLLabelEditorDialog valueDialog = new VSLLabelEditorDialog(new Shell(), getValue().toString(), 0, (DataType)type);

		// int val = valueDialog.open();

		// Treat Cancel case first
		// if (val == InputDialogPrimitiveType.CANCEL) {
		// Close dialog box
		// valueDialog.close();
		// And quit
		return;
	}
	// New object as string (user input)
	// String dialogValue = valueDialog.getValue();
	// Treat dialogValue
	// Object newValue = Util.getValueObjectFromString(dialogValue, type);

	// updateValue(newValue);

	// Close dialog box and refresh table
	// valueDialog.close();
}

// }

