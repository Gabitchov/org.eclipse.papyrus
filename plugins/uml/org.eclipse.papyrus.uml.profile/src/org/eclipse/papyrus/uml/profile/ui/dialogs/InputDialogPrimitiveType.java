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
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Property;


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
	public static final int OK = InputDialog.OK;

	/**
	 * The Constant CANCEL.
	 */
	public static final int CANCEL = InputDialog.CANCEL;

	/**
	 * The Constructor.
	 *
	 * @param index
	 *        the index
	 * @param property
	 *        the property
	 * @param shell
	 *        the shell
	 * @param initialValue
	 *        the initial value
	 */
	public InputDialogPrimitiveType(Shell shell, Property property, Object initialValue) {

		if(initialValue != null) {
			// Call dialog constructor
			iDialog = new InputDialog(shell, TITLE, LABEL, initialValue.toString(), null);

		} else if(property.getDefaultValue() != null) {
			iDialog = new InputDialog(shell, TITLE, LABEL, property.getDefault(), null);

		} else if(property.getType().getName().equals("Boolean")) {
			iDialog = new InputDialog(shell, TITLE, LABEL, "true", null);

		} else {
			iDialog = new InputDialog(shell, TITLE, LABEL, null, null);
		}
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
