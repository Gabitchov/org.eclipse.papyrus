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
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;

/**
 * 
 * @author vl222926
 *
 */
public class CornerDataProvider extends DefaultCornerDataProvider {

	public CornerDataProvider(IDataProvider columnHeaderDataProvider, IDataProvider rowHeaderDataProvider) {
		super(columnHeaderDataProvider, rowHeaderDataProvider);
	}

	@Override
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		return Messages.CornerDataProvider_InvertAxis;
	}

	@Override
	public int getColumnCount() {
		return super.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return super.getColumnCount();
	}

}
