/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.editor;

import java.util.Map;

import org.eclipse.nebula.widgets.nattable.edit.EditTypeEnum;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;


/**
 * Wrapper for cell editor dialogs
 * see bug 426709: [Table 2][Stereotype] Papyrus Table must allows to edit stereotype properties even if the required stereotypes is not yet applied
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=426709
 */
public class StereotypeApplierDialogCellEditorWrapper extends StereotypeApplierCellEditorWrapper implements ICellEditDialog {

	/**
	 * Instantiates a new stereotyped element dialog cell editor wrapper.
	 * 
	 * @param wrappedCellEditor
	 *        the wrapped cell editor
	 * @param axisElement
	 *        the edited axis
	 * @param elementProvider
	 *        the axis element provider
	 */
	public StereotypeApplierDialogCellEditorWrapper(final AbstractDialogCellEditor wrappedCellEditor, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		super(wrappedCellEditor, axisElement, elementProvider);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog#getCommittedValue()
	 * 
	 * @return
	 */

	@Override
	public Object getCommittedValue() {
		return ((AbstractDialogCellEditor)this.wrappedCellEditor).getCommittedValue();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog#getEditType()
	 * 
	 * @return
	 */

	@Override
	public EditTypeEnum getEditType() {
		return ((AbstractDialogCellEditor)this.wrappedCellEditor).getEditType();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog#calculateValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param currentValue
	 * @param processValue
	 * @return
	 */

	@Override
	public Object calculateValue(Object currentValue, Object processValue) {
		return ((AbstractDialogCellEditor)this.wrappedCellEditor).calculateValue(currentValue, processValue);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog#open()
	 * 
	 * @return
	 */

	@Override
	public int open() {
		return ((AbstractDialogCellEditor)this.wrappedCellEditor).open();
	}

	/**
	 * Sets the dialog settings.
	 * 
	 * @param editDialogSettings
	 *        the edit dialog settings
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog#setDialogSettings(java.util.Map)
	 */

	@Override
	public void setDialogSettings(Map<String, Object> editDialogSettings) {
		((AbstractDialogCellEditor)this.wrappedCellEditor).setDialogSettings(editDialogSettings);
	}

}
