/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.integrationtests.editor.operationhistory;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.integrationtests.editor.ExecutionException;
import org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor;


/**
 * A handler allowing to perform undo and redo through the {@link IOperationHistory}
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class OperationHistoryHandler implements IOperationHistoryHandler {

	/** The papyrus editor. */
	protected IMultiDiagramEditor papyrusEditor;

	protected IOperationHistory history;

	private IUndoContext papyrusContext;
	
	/**
	 * Constructor.
	 *
	 * @param papyrusEditor
	 * @throws ServiceException 
	 */
	public OperationHistoryHandler(ProgramaticPapyrusEditor handler) throws ServiceException {
		this.papyrusEditor = handler.getEditor();
		history = papyrusEditor.getSite().getWorkbenchWindow().getWorkbench().getOperationSupport().getOperationHistory();
		papyrusContext = handler.getServiceRegistry().getService(IUndoContext.class);
	}

	public IOperationHistory getIOperationHistory() {
		return history;
	}

	/**
	 * 
	 * @return
	 */
	public boolean canRedo() {
		return history.canRedo(papyrusContext);
	}
	/**
	 * @see org.eclipse.papyrus.integrationtests.editor.operationhistory.IOperationHistoryHandler#redo()
	 *
	 * @throws ExecutionException
	 */
	public void redo() throws ExecutionException {
		try {
			history.redo(papyrusContext, null, null);
		} catch (org.eclipse.core.commands.ExecutionException e) {
			throw new ExecutionException(e);
		}	
	}

	/**
	 * 
	 * @return
	 */
	public boolean canUndo() {
		return history.canUndo(papyrusContext);
	}

	/**
	 * @see org.eclipse.papyrus.integrationtests.editor.operationhistory.IOperationHistoryHandler#undo()
	 *
	 * @throws ExecutionException
	 */
	public void undo() throws ExecutionException  {
		try {
			history.undo(papyrusContext, null, null);
		} catch (org.eclipse.core.commands.ExecutionException e) {
			throw new ExecutionException(e);
		}	
	}

}
