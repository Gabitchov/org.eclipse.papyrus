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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommandHandler;
import org.eclipse.nebula.widgets.nattable.command.VisualRefreshCommand;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.swt.widgets.Display;


/**
 * A base layer command handler that executes commands on a {@link TransactionalEditingDomain}'s command-stack.
 * This ensures atomic undo/redo of all model changes performed by the command.
 */
public abstract class TransactionalCommandHandler<T extends ILayerCommand> implements ILayerCommandHandler<T> {

	private final TransactionalEditingDomain domain;

	private String label;

	public TransactionalCommandHandler(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	public TransactionalCommandHandler(TransactionalEditingDomain domain, String label) {
		this.domain = domain;

		this.label = label;
	}

	public String getLabel() {
		return (label != null) ? label : "Table Command";
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public final boolean doCommand(final ILayer targetLayer, final T command) {
		final boolean[] result = { false };

		if(command.convertToTargetLayer(targetLayer)) {
			domain.getCommandStack().execute(new RecordingCommand(domain, getLabel()) {

				@Override
				protected void doExecute() {
					ExecutionStatusKind status = doCommand(command);

					result[0] = status.isOK();

					if(status.isRollback()) {
						// Refresh the visual presentation of the layer because stereotype applications
						// may have updated some cells
						Display.getCurrent().asyncExec(new Runnable() {

							@Override
							public void run() {
								targetLayer.doCommand(new VisualRefreshCommand());
							}
						});

						// Roll back any changes that we made along the way
						throw new OperationCanceledException();
					}
				}
			});
		}

		return result[0];
	}

	protected abstract ExecutionStatusKind doCommand(T command);

	//
	// Nested types
	//

	protected enum ExecutionStatusKind {
		/** Command failed and should be rolled back so that it will not appear on the stack. */
		FAIL_ROLLBACK(false, true),
		/** Command succeeded and should appear on the stack. */
		OK_COMPLETE(true, false),
		/** Command succeeded but should be rolled back so that it will not appear on the stack. */
		OK_ROLLBACK(true, true);

		private final boolean ok;

		private final boolean rollback;

		private ExecutionStatusKind(boolean ok, boolean rollback) {
			this.ok = ok;
			this.rollback = rollback;
		}

		public boolean isOK() {
			return ok;
		}

		public boolean isRollback() {
			return rollback;
		}
	}
}
