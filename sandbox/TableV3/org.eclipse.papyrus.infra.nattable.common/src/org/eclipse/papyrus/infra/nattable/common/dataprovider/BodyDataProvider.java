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
package org.eclipse.papyrus.infra.nattable.common.dataprovider;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;

/**
 * 
 * @author vl222926
 * 
 */
public class BodyDataProvider extends AbstractDataProvider {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableModelManager
	 *        the table manager
	 */
	public BodyDataProvider(final INattableModelManager tableModelManager) {
		super(tableModelManager);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.IDataProvider#getDataValue(int, int)
	 * 
	 * @param columnIndex
	 * @param rowIndex
	 * @return
	 */
	public Object getDataValue(int columnIndex, int rowIndex) {
		IDataProvider provider = this.manager.getBodyDataProvider();
		return provider.getDataValue(columnIndex, rowIndex);
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		// TODO Auto-generated method stub
	}
}
