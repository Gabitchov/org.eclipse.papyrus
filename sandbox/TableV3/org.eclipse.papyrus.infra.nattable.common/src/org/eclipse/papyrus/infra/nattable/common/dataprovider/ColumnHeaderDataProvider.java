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
		return 2;
	}


	/**
	 * This class does not support multiple rows in the column header layer.
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		if(rowIndex == 0) {
			return ExcelColumnHelper.ToExcelColumn(columnIndex + 1);
			//			final String val = Integer.toString((columnIndex + 10), Character.MAX_RADIX).toUpperCase();
			//			return val;
			//			return columnIndex;
		} else {
			return this.manager.getColumnDataProvider().getAllExistingAxis().get(columnIndex);
			//			return this.manager.getColumnDataProvider().getHeaderDataValue(columnIndex, rowIndex);
		}

	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		//do nothing
	}

	//adapted code from http://www.developpez.net/forums/d1197058/dotnet/general-dotnet/contribuez/extensions-types-int-string-conversion-format-colonne-excel/
	public static class ExcelColumnHelper {

		public static String ToExcelColumn(final int columnNumber) {
			if(columnNumber <= 0) {
				//	            throw new ArgumentOutOfRangeException("columnNumber");
				throw new NumberFormatException();
				//				return "error";
			}
			int tmp = columnNumber;
			String excelColumn = "";
			while(tmp > 0) {
				final int r = (tmp - 1) % 26;
				excelColumn = (char)('A' + r) + excelColumn;
				tmp = (tmp - r) / 26;
			}

			return excelColumn;
		}

		public static int FromExcelColumn(String excelColumn) {
			if(excelColumn != null || excelColumn.length() == 0) {
				//	            throw new ArgumentException("Excel column cannot be null or empty", "excelColumn");
				throw new NumberFormatException();
			}
			excelColumn = excelColumn.toUpperCase();
			int multiplier = 1;
			int columnNumber = 0;
			for(int i = excelColumn.length() - 1; i >= 0; i--) {
				final char c = excelColumn.charAt(i);
				if(c < 'A' || c > 'Z') {
					//	                throw new ArgumentException("Excel column must only contain letters between A and Z", "excelColumn");

					throw new NumberFormatException();
				}
				final int value = (c - 'A' + 1) * multiplier;
				columnNumber += value;
				multiplier *= 26;
			}
			return columnNumber;
		}
	}
}
