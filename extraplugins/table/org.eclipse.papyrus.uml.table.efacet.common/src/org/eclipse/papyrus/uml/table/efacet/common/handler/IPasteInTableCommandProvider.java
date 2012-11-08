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
package org.eclipse.papyrus.uml.table.efacet.common.handler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * Interface for paste in table command provider
 * 
 */
public interface IPasteInTableCommandProvider {

	/**
	 * row separator in the clipboard contents
	 */
	public static final String ROW_SEPARATOR = "\n";

	/**
	 * column separator in the clipboard contents
	 */
	public static final String COLUMN_SEPARATOR = "\t";

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
	 * @param visibleColumns TODO
	 * @return
	 *         the command to create the paste in the table command
	 */
	public Command getPasteFromFromStringCommand(final PapyrusTable table, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents,  ITableWidget iTableWidget);

	/**
	 * 
	 * @param papyrusTable
	 *        the paste table where the paste is done
	 * @param clipboardContents
	 *        the clipboard contents
	 * @param iTableWidget TODO
	 * @return
	 *         <code>true</code> if the paste is allowed in the table
	 */
	public boolean isPasteEnabled(final PapyrusTable papyrusTable, final String clipboardContents, ITableWidget iTableWidget);

	/**
	 * 
	 * @return
	 *         a string represented an error message. This message will be displayed to the user
	 */
	public String getPasteErrorMessage();


}
