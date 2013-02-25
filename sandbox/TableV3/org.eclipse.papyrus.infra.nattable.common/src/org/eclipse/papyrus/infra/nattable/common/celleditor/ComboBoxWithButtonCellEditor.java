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
package org.eclipse.papyrus.infra.nattable.common.celleditor;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.widget.EditModeEnum;
import org.eclipse.nebula.widgets.nattable.widget.NatCombo;
import org.eclipse.papyrus.infra.nattable.common.widget.NatComboButton;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author vl222926
 * 
 */
public class ComboBoxWithButtonCellEditor extends ComboBoxCellEditor {

	/**
	 * the action done by the button
	 */
	private ButtonConfiguration buttonConfiguration;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param multiselect
	 * @param buttonConfig
	 *        the action done by the button
	 */
	public ComboBoxWithButtonCellEditor(IComboBoxDataProvider dataProvider, int maxVisibleItems, boolean freeEdit, boolean multiselect, ButtonConfiguration buttonConfig) {
		super(dataProvider, maxVisibleItems, freeEdit, multiselect);
		this.buttonConfiguration = buttonConfig;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(IComboBoxDataProvider dataProvider, int maxVisibleItems, boolean freeEdit, ButtonConfiguration action) {
		super(dataProvider, maxVisibleItems, freeEdit);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 * @param maxVisibleItems
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(IComboBoxDataProvider dataProvider, int maxVisibleItems, ButtonConfiguration action) {
		super(dataProvider, maxVisibleItems);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(IComboBoxDataProvider dataProvider, ButtonConfiguration action) {
		super(dataProvider);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param canonicalValues
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param multiselect
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(List<?> canonicalValues, int maxVisibleItems, boolean freeEdit, boolean multiselect, ButtonConfiguration action) {
		super(canonicalValues, maxVisibleItems, freeEdit, multiselect);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param canonicalValues
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(List<?> canonicalValues, int maxVisibleItems, boolean freeEdit, ButtonConfiguration action) {
		super(canonicalValues, maxVisibleItems, freeEdit);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param canonicalValues
	 * @param maxVisibleItems
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(List<?> canonicalValues, int maxVisibleItems, ButtonConfiguration action) {
		super(canonicalValues, maxVisibleItems);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param canonicalValues
	 * @param action
	 */
	public ComboBoxWithButtonCellEditor(List<?> canonicalValues, ButtonConfiguration action) {
		super(canonicalValues);
		this.buttonConfiguration = action;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor#createEditorControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	public NatCombo createEditorControl(Composite parent) {
		int style = this.editMode == EditModeEnum.INLINE ? SWT.NONE : SWT.BORDER;
		final NatCombo combo = this.iconImage == null ? new NatComboButton(parent, this.cellStyle, this.maxVisibleItems, this.freeEdit, this.multiselect, style, buttonConfiguration) : new NatComboButton(parent, this.cellStyle, this.maxVisibleItems, this.freeEdit, this.multiselect, style, this.iconImage, buttonConfiguration);

		combo.setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_IBEAM));

		if(multiselect) {
			combo.setMultiselectValueSeparator(this.multiselectValueSeparator);
			combo.setMultiselectTextBracket(this.multiselectTextPrefix, this.multiselectTextSuffix);
		}

		addNatComboListener(combo);
		//configure the action done by the button
		buttonConfiguration.getAction().setCellLocation(layerCell.getColumnIndex(), layerCell.getRowIndex());
		buttonConfiguration.getAction().setNatCombo(combo);
		return combo;
	}


}
