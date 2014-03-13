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
package org.eclipse.papyrus.infra.nattable.manager;

import java.io.Reader;
import java.io.StringReader;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;

/**
 * 
 * This class allows to paste axis from string
 * 
 */
public class PasteAxisInNattableManager extends AbstractPasteImportInNattableManager {

	/**
	 * the text to paste
	 */
	private final String pastedText;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 * @param pasteHelper
	 * @param useProgressMonitorDialog
	 * @param pastedText
	 */
	public PasteAxisInNattableManager(final INattableModelManager tableManager, final CSVPasteHelper pasteHelper, final boolean useProgressMonitorDialog, final String pastedText) {
		super(tableManager, pasteHelper, useProgressMonitorDialog);
		this.pastedText = pastedText;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractPasteImportInNattableManager#createReader()
	 * 
	 * @return
	 */
	@Override
	protected Reader createReader() {
		return new StringReader(this.pastedText);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractPasteImportInNattableManager#getDataSize()
	 * 
	 * @return
	 */
	@Override
	protected long getDataSize() {
		return this.pastedText.length();
	}

}
