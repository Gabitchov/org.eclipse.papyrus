package org.eclipse.papyrus.infra.nattable.common.dataprovider;

import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.tools.util.IntegerAndSpreadsheetNumberConverter;

/**
 *
 * This manager is used to manage the column header.
 * It allows to use the standard tabular editor numerotation for the column (A, B, ...Z, AA, AB, ...)
 *
 */
public class ColumnHeaderDataProvider extends AbstractDataProvider {

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
	 * @see org.eclipse.papyrus.infra.nattable.common.dataprovider.AbstractDataProvider#getRowCount()
	 *
	 * @return
	 */
	@Override
	public int getRowCount() {
		return 2;
	}


	/**
	 * This class does not support multiple rows in the column header layer.
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		if(rowIndex == 0) {
			return IntegerAndSpreadsheetNumberConverter.toString(columnIndex + 1);
		} else {
			return this.manager.getColumnDataProvider().getAllExistingAxis().get(columnIndex);
		}
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		//TODO
	}
}
