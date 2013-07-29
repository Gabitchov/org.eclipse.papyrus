/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * this class allows to have a list to choose one element!
 * 
 */
public class ComboInputDialog extends InputDialog {

	/**
	 * index of selection
	 */
	private int indexOfSelection = 0;

	/**
	 * The combo.
	 */
	protected Combo combo;

	/**
	 * The elements list.
	 */
	protected String[] elementsList = null;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 */
	protected ComboInputDialog(Shell parentShell, String title, String message, String initialValue, String[] elementsList) {
		super(parentShell, title, message, initialValue);
		this.elementsList = elementsList;
	}

	/**
	 * Ok pressed.
	 */
	@Override
	protected void okPressed() {
		setValue(elementsList[combo.getSelectionIndex()]);
		indexOfSelection = combo.getSelectionIndex();
		super.okPressed();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.ui.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite)super.createDialogArea(parent);
		combo = new Combo(comp, SWT.READ_ONLY);// with READ_ONLY, we can't edit
												// the selection!
		if(elementsList == null) {
			combo.setItems(new String[]{ "" }); //$NON-NLS-1$
		} else {
			combo.setItems(elementsList);
		}
		// the width of the list depends of the windows size and note of the
		// element from elementsList
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		combo.setLayoutData(data);
		return comp;
	}

	/**
	 * 
	 * @return indexOfSelection
	 */
	public int getIndexOfSelection() {
		return this.indexOfSelection;
	}

	/**
	 * 
	 * @return
	 */
	protected String[] getElementList() {
		return this.elementsList;
	}
}
