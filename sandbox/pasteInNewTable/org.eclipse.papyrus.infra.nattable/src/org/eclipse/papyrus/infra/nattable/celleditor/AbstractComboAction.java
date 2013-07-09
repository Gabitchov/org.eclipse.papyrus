/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.celleditor;

import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.widget.NatCombo;

/**
 * 
 * This abstract class is used to declare addition action for a button located near a NatCombo
 * 
 */
public abstract class AbstractComboAction {

	/**
	 * The NatCombo
	 */
	protected NatCombo combo;

	/**
	 * the column index of the edited cell
	 */
	protected int columnIndex;

	/**
	 * the row index of the edited cell
	 */
	protected int rowIndex;

	/**
	 * The combo box data provider
	 */
	protected IComboBoxDataProvider dataProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 *        the data provider used for the combo
	 */
	public AbstractComboAction(final IComboBoxDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/**
	 * 
	 * @param combo
	 *        the NatCombo
	 */
	public void setNatCombo(final NatCombo combo) {
		this.combo = combo;
	}

	/**
	 * This method is called when the button is pressed
	 */
	public abstract void run();


	/**
	 * Setter for the edited cell location
	 * 
	 * @param columnIndex
	 *        the column index of the edited cell
	 * @param rowIndex
	 *        the row index of the edited cell
	 */
	public final void setCellLocation(int columnIndex, int rowIndex) {
		this.columnIndex = columnIndex;
		this.rowIndex = rowIndex;
	}
}
