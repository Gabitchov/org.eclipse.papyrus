/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.helper;

import org.eclipse.core.commands.operations.IOperationApprover2;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.internal.service.ResourceStatus;

/**
 * This class must be used to open a dialog during a validation. Its usage avoids side effects with the Properties view, which would throw an
 * {@link IllegalStateException}. The parameterizing class can be used to return a result from the dialog (use {@link Void} if no result is expected).
 */
public abstract class SafeDialogOpenerDuringValidation<ReturnType> {


	/**
	 * This approver is used to disable any operation during opening of a popup to avoid side
	 * effects
	 */
	private static IOperationApprover2 operationDisapprover = new IOperationApprover2() {

		public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}

		public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}

		public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}
	};

	/**
	 * Subclasses must implement this method with the dialog opening. If no result is expected, return null.
	 */
	protected abstract ReturnType openDialog();

	/**
	 * Run the dialog opening with necessary precautions.
	 */
	public final ReturnType execute() {
		/*
		 * We are currently validating an ongoing operation. Opening a popup here may have
		 * side-effects such as re-launching the same operation. (the editor may have not been
		 * deactivated yet, and its loss of focus will open a new operation) For this reason, we
		 * temporarily disable all operations on the history, just enough time for opening the
		 * popup.
		 */
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		history.addOperationApprover(operationDisapprover);
		ReturnType result = openDialog();
		history.removeOperationApprover(operationDisapprover);
		return result;
	}
}
