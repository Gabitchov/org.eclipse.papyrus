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
package org.eclipse.papyrus.infra.nattable.dataprovider;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;

/**
 * 
 * This manager is used to manage the column header.
 * 
 * 
 */
public class ColumnHeaderDataProvider extends AbstractHeaderDataProvider {

	private int rowCount;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the manager used to manage the table
	 */
	public ColumnHeaderDataProvider(final INattableModelManager manager) {
		super(manager);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.dataprovider.AbstractDataProvider#getRowCount()
	 * 
	 * @return
	 */
	@Override
	public int getRowCount() {
		return this.rowCount;
	}


	/**
	 * This class does not support multiple rows in the column header layer.
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		switch(this.rowCount) {
		case 0:
			return null;
		case 1:
			if(this.displayFilter) {
				return null;//TODO not tested
			} else if(this.displayIndex) {
				return getAxisIndex(columnIndex);
			} else if(this.displayLabel) {
				return this.manager.getColumnElement(columnIndex);
			}
		case 2:
			if(!this.displayFilter) {
				if(rowIndex == 0) {
					return getAxisIndex(columnIndex);
				}
				if(rowIndex == 1) {
					return this.manager.getColumnElement(columnIndex);
				}
			} else {
				//TODO not tested
			}
			break;
		case 3:
			if(!this.displayFilter) {
				if(rowIndex == 0) {
					return getAxisIndex(columnIndex);
				}
				if(rowIndex == 1) {
					return this.manager.getColumnElement(columnIndex);
				}
				if(rowIndex == 2) {
					//TODO not tested
				}
			}
			break;
		}
		return null;
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		//TODO
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.dataprovider.AbstractHeaderDataProvider#getAxisConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected AbstractHeaderAxisConfiguration getAxisConfiguration() {
		return HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(this.manager.getTable());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.dataprovider.AbstractHeaderDataProvider#updateAxisCount()
	 * 
	 */
	@Override
	protected void updateAxisCount() {
		int newAxisCOunt = 0;
		if(this.displayFilter) {
			newAxisCOunt++;
		}
		if(this.displayIndex) {
			newAxisCOunt++;
		}
		if(this.displayLabel) {
			newAxisCOunt++;
		}
		this.rowCount = newAxisCOunt;
	}

}
