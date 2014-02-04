/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.widgets.creation;

import java.util.concurrent.Callable;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.papyrus.infra.widgets.Activator;


/**
 * An interface that ensures execution of model changes as an atomic unit that is potentially undoable and redoable, such as on a "command stack"
 * (whatever form it may take).
 */
public interface IAtomicOperationExecutor {

	IAtomicOperationExecutor DEFAULT = new Default();

	/**
	 * Execute a runnable (an operation returning no result).
	 * 
	 * @param operation
	 *        the operation to execute
	 * @param label
	 *        an optional label to associate with the operation for presentation in, for example, the Edit menu's Undo/Redo operations
	 */
	void execute(Runnable operation, String label);

	/**
	 * Execute a callable (an operation returning a result).
	 * 
	 * @param operation
	 *        the operation to execute
	 * @param label
	 *        an optional label to associate with the operation for presentation in, for example, the Edit menu's Undo/Redo operations
	 * @return the {@code operation}'s result
	 */
	<V> V execute(Callable<V> operation, String label);

	//
	// Nested types
	//

	class Default implements IAtomicOperationExecutor {

		public void execute(final Runnable operation, String label) {
			try {
				operation.run();
			} catch (OperationCanceledException e) {
				// We cannot really implement cancel because there is not command/transaction to roll back
			}
		}

		public <V> V execute(final Callable<V> operation, String label) {
			class CallableWrapper implements Runnable {

				V result;

				@Override
				public void run() {
					try {
						result = operation.call();
					} catch (OperationCanceledException e) {
						// Don't trap this one
						throw e;
					} catch (Exception e) {
						Activator.log.error("Callable operation failed.", e); //$NON-NLS-1$
						throw new OperationCanceledException(); // roll back
					}
				}
			}

			CallableWrapper wrapper = new CallableWrapper();

			execute(wrapper, label);

			return wrapper.result;
		}

	}
}
