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

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;

public class RowHeaderDataProvider implements IDataProvider {

	private INattableModelManager manager;

	public RowHeaderDataProvider(final INattableModelManager manager) {
		this.manager = manager;
	}

	public int getColumnCount() {
		return 1;
	}

	public int getRowCount() {
		return manager.getRowCount();
	}

	public Object getDataValue(int columnIndex, int rowIndex) {
		//FIXME : it should different in case of inversion line column		
		return rowIndex;
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		throw new UnsupportedOperationException();
	}

}
