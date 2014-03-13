/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;


public class ImportAxisInNattableManager extends AbstractPasteImportInNattableManager {

	/**
	 * the file to import
	 */
	private File file;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 * @param pasteHelper
	 * @param fileToImport
	 * @param useProgressMonitorDialog
	 */
	public ImportAxisInNattableManager(INattableModelManager tableManager, CSVPasteHelper pasteHelper, final File fileToImport, boolean useProgressMonitorDialog) {
		super(tableManager, pasteHelper, useProgressMonitorDialog);
		this.file = fileToImport;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractPasteImportInNattableManager#createReader()
	 * 
	 * @return
	 */
	@Override
	protected Reader createReader() {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		}
		return reader;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractPasteImportInNattableManager#getDataSize()
	 * 
	 * @return
	 */
	@Override
	protected long getDataSize() {
		return this.file.length();
	}

}
