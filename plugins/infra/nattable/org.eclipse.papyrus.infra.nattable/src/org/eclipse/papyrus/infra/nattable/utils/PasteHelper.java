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
package org.eclipse.papyrus.infra.nattable.utils;

/**
 * 
 * This class provides utils method to split a string to do a paste in the table
 * 
 */
public class PasteHelper {

	/**
	 * the default separator used for row
	 */
	public static final String DEFAULT_ROW_SEPARATOR = "\n"; //$NON-NLS-1"

	/**
	 * the default separator used for columns
	 */
	public static final String DEFAULT_COLUMN_SEPARATOR = "\t";//$NON-NLS-1"

	/**
	 * the default separator used for multivalue
	 */
	public static final String DEFAULT_MULTI_VALUE_SEPARATOR = ","; //$NON-NLS-1$


	private final String rowSeparator;

	private final String columnSeparator;

	private final String multiValueSeparator;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PasteHelper() {
		this(DEFAULT_COLUMN_SEPARATOR, DEFAULT_ROW_SEPARATOR, DEFAULT_MULTI_VALUE_SEPARATOR);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param columnSeparator
	 *        the column separator to use
	 * @param rowSeparator
	 *        the row separator to use
	 * @param multiValueSeparator
	 *        the multi value separator to use
	 */
	public PasteHelper(final String columnSeparator, final String rowSeparator, final String multiValueSeparator) {
		this.columnSeparator = columnSeparator;
		this.rowSeparator = rowSeparator;
		this.multiValueSeparator = multiValueSeparator;
	}

	/**
	 * 
	 * @param axisAsString
	 *        an full axis represented by a String
	 * 
	 * 
	 * @return
	 *         the cells using the specified cell separator
	 */

	public String[] getCellsAsStringFromAxis(final String axisAsString) {
		return axisAsString.split(this.columnSeparator);
	}

	/**
	 * 
	 * @param fullContents
	 *        the string to split
	 * 
	 * @return
	 *         the rows
	 */
	public final String[] getRows(final String fullContents) {
		final String[] rows = fullContents.split(this.rowSeparator);
		return rows;
	}

	/**
	 * 
	 * @param fullContents
	 * @param rowSeparator
	 * @param columnSeparator
	 * @return
	 *         an array of the pasted columns
	 */
	//TODO refactor me the paste in column should be the same as the paste in row!
	public final String[] getColumns(final String fullContents) {
		final String[] rows = fullContents.split(rowSeparator);
		if(rows.length > 0) {
			int nbColumn = rows[0].split(columnSeparator).length;
			String[] columns = new String[nbColumn];
			for(int columnIndex = 0; columnIndex < nbColumn; columnIndex++) {
				columns[columnIndex] = "";
			}

			for(int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
				String row = rows[rowIndex];
				String[] currentColumns = row.split(columnSeparator);
				for(int columnIndex = 0; columnIndex < nbColumn; columnIndex++) {
					if(currentColumns.length != 0) {
						columns[columnIndex] += currentColumns[columnIndex];
					} else {
						columns[columnIndex] += ""; //$NON-NLS-1$
					}
					if(rowIndex < rows.length + 1) {
						columns[columnIndex] += columnSeparator;
					} else {
						columns[columnIndex] += rowSeparator;
					}
				}
			}
			return columns;

		}
		return null;
	}


	public String getRowSeparator() {
		return rowSeparator;
	}


	public String getColumnSeparator() {
		return columnSeparator;
	}


	public String getMultiValueSeparator() {
		return multiValueSeparator;
	}


}
