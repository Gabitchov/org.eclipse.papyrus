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
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;


// TODO: Auto-generated Javadoc
/**
 * The Class InputDialogEnumeration.
 */
public class InputDialogEnumeration {
	
	/**
	 * The Constant OK.
	 */
	public static final int OK     = ComboSelectionDialog.OK;
	
	/**
	 * The Constant CANCEL.
	 */
	public static final int CANCEL = ComboSelectionDialog.CANCEL;

	/**
	 * The i dialog.
	 */
	private ComboSelectionDialog iDialog;
	//private final String TITLE = "Property value editing";
	/**
	 * The LABEL.
	 */
	private final String LABEL = "Value:";
	
	/**
	 * The literals.
	 */
	private String[] literals;
	
	/**
	 * The Constructor.
	 * 
	 * @param index the index
	 * @param value the value
	 * @param property the property
	 * @param shell the shell
	 */
	public InputDialogEnumeration(Shell shell, Property property, Object value, int index) {		
		// Create literals list
		createLiterals(property);

		// Create Combo
		if (literals != null) {
			if (value == null) {
				iDialog = new ComboSelectionDialog(shell, LABEL, literals, literals[0]);
				
			} else {
				String initialValue = literals[0];
				EnumerationLiteral eLiteral = null;
				
				// Search current value or default
				if (value instanceof List) {
					value  = ((List) value).get(index);
				}
				
				// Prepare Item data
				if (value instanceof EnumerationLiteral) {
					eLiteral = (EnumerationLiteral) value;
				
				} else if (value instanceof EEnumLiteral) {
					EEnumLiteral eEnumLiteral = (EEnumLiteral) value;
					Object tmp = Util.getValueObjectFromString(eEnumLiteral.getName(), property.getType());
					eLiteral = ((EnumerationLiteral) tmp);
					
				} else if (value instanceof String) {
					String literalString = (String) value;
					Object tmp = Util.getValueObjectFromString(literalString, property.getType());
					eLiteral = ((EnumerationLiteral) tmp);
					
				} else { // Error
					String err = "Value "+value.toString()+" of Property "+property.getName()+" is not an EnumerationLiteral.";
					Message.error(err);
				}
				
				if ((eLiteral != null) && (eLiteral.isSetName())) {
					initialValue = eLiteral.getQualifiedName();
				}
				
				// Create Combo
				iDialog = new ComboSelectionDialog(shell, LABEL, literals, initialValue);
			}
		}
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param value the value
	 * @param property the property
	 * @param shell the shell
	 */
	public InputDialogEnumeration(Shell shell, Property property, Object value) {		
		// Create literals list
		createLiterals(property);

		// Create Combo
		if (literals != null) {

			String initialValue = literals[0];
			EnumerationLiteral eLiteral = null;

			// Prepare Item data
			if (value instanceof EnumerationLiteral) {
				eLiteral = (EnumerationLiteral) value;

			} else if (value instanceof EEnumLiteral) {
				EEnumLiteral eEnumLiteral = (EEnumLiteral) value;
				Object tmp = Util.getValueObjectFromString(eEnumLiteral.getName(), property.getType());
				eLiteral = ((EnumerationLiteral) tmp);

			} else if (value instanceof Enumerator) { // Enumeration in static profile
				String literalString = ((Enumerator) value).getLiteral();
				Object tmp = Util.getValueObjectFromString(literalString, property.getType());
				eLiteral = ((EnumerationLiteral) tmp);
				
			} else { // Error
				String err = "Value "+value.toString()+" of Property "+property.getName()+" is not an EnumerationLiteral.";
				Message.error(err);
			}

			if ((eLiteral != null) && (eLiteral.isSetName())) {
				initialValue = eLiteral.getQualifiedName();
			}

			// Create Combo
			iDialog = new ComboSelectionDialog(shell, LABEL, literals, initialValue);

		}
	}
	
	/**
	 * Open.
	 * 
	 * @return the int
	 */
	public int open() {
		if (iDialog != null) {
			return iDialog.open();
		}
		
		return (ComboSelectionDialog.CANCEL);
	}
	
	/**
	 * Close.
	 */
	public void close() {
		if (iDialog != null) {
			iDialog.close();
		}
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {		
		if (iDialog != null) {
			return iDialog.getValue();
		}
		return null;
	}
	
	/**
	 * Gets the selection index.
	 * 
	 * @return the selection index
	 */
	public int getSelectionIndex() {
		if (iDialog != null) {
			return iDialog.indexOfSelection;
		} else {
			return -1;
		}
	}
	
	/**
	 * Creates the literals.
	 * 
	 * @param property the property
	 */
	private void createLiterals(Property property) {
		// combo dialog construction
		List tmp = ((Enumeration) property.getType()).getOwnedLiterals();
		String[] enumLiteralNames = Util.getStringArrayFromList(tmp);
		// if no possible selection : abort
		if (enumLiteralNames == null) {
			Message.warning("No literal was found for Enumeration in the model.");
			return;
		}
		literals = enumLiteralNames;
	}
}
