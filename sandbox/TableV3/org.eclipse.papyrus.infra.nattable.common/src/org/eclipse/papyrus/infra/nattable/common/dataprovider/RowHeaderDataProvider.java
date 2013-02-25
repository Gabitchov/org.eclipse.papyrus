/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.dataprovider;

import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;

/**
 * 
 * this manager allows to manage the rows of the table. It provides
 * a row header in 2 columns : number on first columns and call the row manager to display a text in the second column
 * 
 */
public class RowHeaderDataProvider extends AbstractDataProvider {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the table manager
	 */
	public RowHeaderDataProvider(final INattableModelManager manager) {
		super(manager);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.IDataProvider#getColumnCount()
	 * 
	 * @return
	 *         2
	 */
	@Override
	public int getColumnCount() {
		return 2;
	}

	public Object getDataValue(final int columnIndex, final int rowIndex) {
		if(columnIndex == 0) {
			return rowIndex;
		} else {
			return this.manager.getRowElement(rowIndex);
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.IDataProvider#setDataValue(int, int, java.lang.Object)
	 * 
	 * @param columnIndex
	 * @param rowIndex
	 * @param newValue
	 */
	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		throw new UnsupportedOperationException();
	}
}
