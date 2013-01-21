package org.eclipse.papyrus.infra.nattable.common.dataprovider;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;

public class ColumnHeaderDataProvider implements IDataProvider {


	private final INattableModelManager manager;


	public ColumnHeaderDataProvider(final INattableModelManager manager) {
		this.manager = manager;
	}

	public int getColumnCount() {
		return this.manager.getColumnCount();
	}

	public int getRowCount() {
		return 1;
	}


	/**
	 * This class does not support multiple rows in the column header layer.
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		return this.manager.getColumnDataProvider().getHeaderDataValue(columnIndex, rowIndex);
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		//do nothing
	}

}
