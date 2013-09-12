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

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.eclipse.papyrus.infra.nattable.Activator;



/**
 * Util class to manage the clipboard
 * 
 * @author VL222926
 * 
 */
public class TableClipboardUtils {

	/**
	 * row separator in the clipboard contents
	 */
	public static final String AXIS_SEPARATOR = "\n"; //$NON-NLS-1$

	/**
	 * column separator in the clipboard contents
	 */
	public static final String CELL_SEPARATOR = "\t"; //$NON-NLS-1$

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
		final String[] rows = fullContents.split(AXIS_SEPARATOR);
		return rows;
	}

	/**
	 * 
	 * @return
	 *         the rows as string extractzed from the clipboad
	 */
	public static final String[] getRowsFromClipboard() {
		final String clipboardContent = getClipboardContents();
		if(clipboardContent != null && !clipboardContent.isEmpty()) {
			return getRows(clipboardContent);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the columns as string extractzed from the clipboad
	 */
	public static final String[] getColumnsFromClipboard() {
		final String clipboardContent = getClipboardContents();
		if(clipboardContent != null && !clipboardContent.isEmpty()) {
			return getColumns(clipboardContent);
		}
		return null;
	}


	/**
	 * 
	 * @return
	 *         the clipboard contents used to build the command
	 */
	private static final String getClipboardContents() {
		// examine system clipboard
		String bufferSystem = null;


		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				bufferSystem = clipboard.getData(DataFlavor.stringFlavor).toString();
			} catch (UnsupportedFlavorException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}

		//using SWT
		//		final Display display = Display.getCurrent();
		//		final Clipboard cb = new Clipboard(display);
		//		//we use the text transfert
		//		final TextTransfer transfer = TextTransfer.getInstance();
		//
		//		final Clipboard cb = new Clipboard(clipboard);
		//		final String contents = (String)cb.getContents(transfer);

		return bufferSystem;
	}

	/**
	 * 
	 * @param row
	 *        a row represented by a String
	 * @return the cells for this row
	 */
	public static final String[] getCells(final String row) {
		return row.split(CELL_SEPARATOR);
	}


	public static final String[] getColumns(final String fullContents) {
		final String[] rows = fullContents.split(AXIS_SEPARATOR);
		if(rows.length > 0) {
			int nbColumn = rows[0].split(CELL_SEPARATOR).length;
			String[] columns = new String[nbColumn];
			for(int columnIndex = 0; columnIndex < nbColumn; columnIndex++) {
				columns[columnIndex] = "";
			}

			for(int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
				String row = rows[rowIndex];
				String[] currentColumns = row.split(CELL_SEPARATOR);
				for(int columnIndex = 0; columnIndex < nbColumn; columnIndex++) {
					if(currentColumns.length != 0) {
						columns[columnIndex] += currentColumns[columnIndex];
					} else {
						columns[columnIndex] += "";
					}
					if(rowIndex < rows.length + 1) {
						columns[columnIndex] += CELL_SEPARATOR;
					} else {
						columns[columnIndex] += AXIS_SEPARATOR;
					}
				}
			}
			return columns;

		}
		return null;
	}

}
