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
package org.eclipse.papyrus.infra.nattable.utils;


public class TableClipboardUtils {

	/**
	 * row separator in the clipboard contents
	 */
	public static final String ROW_SEPARATOR = "\n"; //$NON-NLS-1$

	/**
	 * column separator in the clipboard contents
	 */
	public static final String COLUMN_SEPARATOR = "\t"; //$NON-NLS-1$

	/**
	 * the separator used for multivalue
	 */
	public static final String MULTI_VALUE_SEPARATOR = ","; //$NON-NLS-1$

	private TableClipboardUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param fullContents
	 *        a table represented by a String
	 * @return the rows for this table
	 */
	public static final String[] getRows(final String fullContents) {
		final String[] rows = fullContents.split(ROW_SEPARATOR);
		return rows;
	}

	/**
	 * 
	 * @param row
	 *        a row represented by a String
	 * @return the cells for this row
	 */
	public static final String[] getCells(final String row) {
		return row.split(COLUMN_SEPARATOR);
	}


}
