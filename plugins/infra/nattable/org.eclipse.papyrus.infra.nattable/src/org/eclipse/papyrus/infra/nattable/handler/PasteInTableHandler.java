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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.manager.PasteAxisInNattableManager;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;

/**
 * Paste Handler
 * 
 * @author VL222926
 * 
 */
public class PasteInTableHandler extends AbstractTableHandler {

	/**
	 * this field is used to determine if we want open a dialog to prevent the user that the command creation and the command execution can take a
	 * long time
	 */
	private boolean useProgressMonitorDialog = true;


	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CSVPasteHelper pasteHelper = new CSVPasteHelper();
		PasteAxisInNattableManager pasteManager = new PasteAxisInNattableManager(getCurrentNattableModelManager(), pasteHelper, useProgressMonitorDialog, TableClipboardUtils.getClipboardContentsAsString());
		pasteManager.doPaste();
		return null;
	}

	/**
	 * @Override
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getCurrentNattableModelManager() != null);
	}


}
