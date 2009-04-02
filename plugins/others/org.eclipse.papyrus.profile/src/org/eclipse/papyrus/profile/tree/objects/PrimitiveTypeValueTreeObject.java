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
package org.eclipse.papyrus.profile.tree.objects;

import org.eclipse.papyrus.profile.ui.dialogs.InputDialogPrimitiveType;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;


// TODO: Auto-generated Javadoc
/**
 * The Class PrimitiveTypeValueTreeObject.
 */
public abstract class PrimitiveTypeValueTreeObject extends ValueTreeObject {
	
	/**
	 * The Constructor.
	 * 
	 * @param value the value
	 * @param parent the parent
	 */
	protected PrimitiveTypeValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value) {
		super(parent, value);
	}
		
	/**
	 * Creates the instance.
	 * 
	 * @param newValue the new value
	 * @param parent the parent
	 * 
	 * @return the primitive type value tree object
	 */
	public static PrimitiveTypeValueTreeObject createInstance(AppliedStereotypePropertyTreeObject parent, Object newValue) {
		
		Property property = parent.getProperty();
		Type type = property.getType();
		PrimitiveTypeValueTreeObject newVTO = null;
		
		/** primitive type **/
		if (type instanceof PrimitiveType) {
			String typeName = type.getQualifiedName();
			if (typeName.equals("UMLPrimitiveTypes::Boolean")) {
				newVTO = new BooleanValueTreeObject(parent, newValue);
			} else if (typeName.equals("UMLPrimitiveTypes::String")) {
				newVTO = new StringValueTreeObject(parent, newValue);
			} else if (typeName.equals("UMLPrimitiveTypes::Integer")) {
				newVTO = new IntegerValueTreeObject(parent, newValue);
			} else if (typeName.equals("UMLPrimitiveTypes::UnlimitedNatural")) {
				newVTO = new UnlimitedNaturalValueTreeObject(parent, newValue);
			} else {
				newVTO = new UserPrimitiveTypeValueTreeObject(parent, newValue); 			
			}
		}
		
		return newVTO;
	}
	
	/**
	 * Edits the me.
	 */
	@Override
	public void editMe() {
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) getParent();
		Property property = pTO.getProperty();
		Type type = property.getType();

		// Creates a dialog box to enter value
		InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(new Shell(), property, getValue());
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
		Object newValue = Util.getValueObjectFromString(dialogValue, type);
		
		updateValue(newValue);
		
		// Close dialog box and refresh table
		valueDialog.close();
	}
}
