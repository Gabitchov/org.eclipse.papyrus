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
package org.eclipse.papyrus.uml.table.common.provider;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.table.common.exceptions.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * 
 * Interface for paste in table command provider
 * 
 */
public interface IPasteInTableCommandProvider {

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
	public Command getPasteFromFromStringCommand(final PapyrusTableInstance table, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents, INatTableWidget iTableWidget) throws ErrorInPastePreparationException;

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
	public boolean isPasteEnabled(final PapyrusTableInstance papyrusTable, final String clipboardContents, final INatTableWidget iTableWidget);

	/**
	 * 
	 * @return
	 *         a string represented an error message. This message will be displayed to the user
	 */
	public String getPasteErrorMessage();


}
