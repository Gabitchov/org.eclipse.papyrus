/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.nattable.exception.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * Interface for paste in table command provider
 * 
 */
public interface IPasteInTableCommandProvider {

	/**
	 * 
	 * @param table
	 *        the table where the clipboard contents is pasted
	 * @param commandCreationCancelProvider
	 *        a progress monitor enabled to provide a cancel during the command creation (can be <code>null</code>)
	 * @param commandExecutionProgressMonitor
	 *        the progress monitor used during the command execution (can be <code>null</code>)
	 * @param clipboardContents
	 *        the clipboard contents
	 * 
	 * @return
	 *         the command to create the paste in the table command
	 * @throws ErrorInPastePreparationException
	 */
	//FIXME : update documentation
	public ICommand getPasteFromFromStringCommand(final TransactionalEditingDomain editingDomain,final Table table, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents, final INattableModelManager tableManager) throws ErrorInPastePreparationException;

	/**
	 * 
	 * @param papyrusTable
	 *        the paste table where the paste is done
	 * @param clipboardContents
	 *        the clipboard contents
	 * @param iTableWidget
	 *        the nattable widget
	 * @return
	 *         <code>true</code> if the paste is allowed in the table
	 */
	//FIXME : update documentation
//	public boolean isPasteEnabled(final Table papyrusTable, final String clipboardContents);

	/**
	 * 
	 * @return
	 *         a string represented an error message. This message will be displayed to the user
	 */
//	public String getPasteErrorMessage();


}
