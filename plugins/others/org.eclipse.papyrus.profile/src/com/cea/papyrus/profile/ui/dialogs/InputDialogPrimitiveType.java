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
package com.cea.papyrus.profile.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Property;

import com.cea.papyrus.profile.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class InputDialogPrimitiveType.
 */
public class InputDialogPrimitiveType {

	/**
	 * The i dialog.
	 */
	private InputDialog iDialog;
	
	/**
	 * The TITLE.
	 */
	private final String TITLE = "Property value editing";
	
	/**
	 * The LABEL.
	 */
	private final String LABEL = "Value:";
	
	/**
	 * The Constant OK.
	 */
	public static final int OK     = InputDialog.OK;
	
	/**
	 * The Constant CANCEL.
	 */
	public static final int CANCEL = InputDialog.CANCEL;
	
	/**
	 * The Constructor.
	 * 
	 * @param index the index
	 * @param property the property
	 * @param shell the shell
	 * @param initialValue the initial value
	 */
	public InputDialogPrimitiveType(Shell shell, Property property, Object initialValue, int index) {

		if (initialValue != null) {
			Object value = initialValue;
			
			// Multivalue case
			if (initialValue instanceof List) {
				List values = (List) initialValue;
				value = values.get(index);		
			}
			// Call dialog constructor
			iDialog = new InputDialog(shell, TITLE, LABEL, value.toString(), null);
			
		} else if(property.isSetDefault()) {
			iDialog = new InputDialog(shell, TITLE, LABEL, property.getDefault(), null);
			
		} else if (property.getType().getName().equals("Boolean")) {
			iDialog = new InputDialog(shell, TITLE, LABEL, "true", null);
			
		} else {
			iDialog = new InputDialog(shell, TITLE, LABEL, null, null);
		}
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param property the property
	 * @param shell the shell
	 * @param initialValue the initial value
	 */
	public InputDialogPrimitiveType(Shell shell, Property property, Object initialValue) {

		if (initialValue == null) {
			Message.error("Method used for edition only, should have a non null initialValue");
			return;
		}
		
		iDialog = new InputDialog(shell, TITLE, LABEL, initialValue.toString(), null);
	}
	
	/**
	 * Open.
	 * 
	 * @return the int
	 */
	public int open() {
		return iDialog.open();
	}
	
	/**
	 * Close.
	 */
	public void close() {
		iDialog.close();
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return iDialog.getValue();
	}
}
