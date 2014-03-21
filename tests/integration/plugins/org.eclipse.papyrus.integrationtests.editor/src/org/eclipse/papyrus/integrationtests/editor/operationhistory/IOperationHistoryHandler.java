package org.eclipse.papyrus.integrationtests.editor.operationhistory;

import org.eclipse.papyrus.integrationtests.editor.ExecutionException;




public interface IOperationHistoryHandler {

	/**
	 * 
	 * @return
	 */
	public boolean canRedo();

	/**
	 * Redo the last operation in the history.
	 * @throws ExecutionException 
	 */
	public void redo() throws ExecutionException;

	/**
	 * 
	 * @return
	 */
	public boolean canUndo();
	
	/**
	 * Redo the last operation in the history.
	 * @throws ExecutionException 
	 */
	public void undo() throws ExecutionException;

}
