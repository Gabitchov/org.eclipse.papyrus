/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.comparator;

import java.text.Collator;

import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.sort.SortDirectionEnum;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;

/**
 * Axis Comparator used to sort the rows according to the selected column
 * 
 * @author vl222926
 * 
 */
public class RowComparator extends AbstractAxisComparator {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedColumn
	 *        the selected column
	 * @param direction
	 *        the direction to do the sort
	 * @param tableManager
	 *        the table manager
	 */
	public RowComparator(final Object selectedColumn, final SortDirectionEnum direction, final INattableModelManager tableManager) {
		super(selectedColumn, direction, tableManager);
	}

	/**
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	@Override
	public int compare(final Object o1, final Object o2) {
		int index_01 = tableManager.getRowElementsList().indexOf(o1);
		int index_02 = tableManager.getRowElementsList().indexOf(o2);
		int columnIndex = tableManager.getColumnElementsList().indexOf(selectedColumn);
		if(columnIndex == -1) {
			return 0;
		}
		final ILayerCell cell_O1 = stack.getSelectionLayer().getCellByPosition(columnIndex, index_01);
		final ILayerCell cell_O2 = stack.getSelectionLayer().getCellByPosition(columnIndex, index_02);

		final LabelProviderCellContextElementWrapper wrapper1 = new LabelProviderCellContextElementWrapper(cell_O1, this.configRegistry);
		final LabelProviderCellContextElementWrapper wrapper2 = new LabelProviderCellContextElementWrapper(cell_O2, this.configRegistry);

		final String txt1 = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT).getText(wrapper1);
		final String txt2 = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT).getText(wrapper2);
		final int res;
		if(direction == SortDirectionEnum.DESC) {
			res = Collator.getInstance().compare(txt2, txt1);
		} else {
			res = Collator.getInstance().compare(txt1, txt2);
		}
		return res;
	}
}
