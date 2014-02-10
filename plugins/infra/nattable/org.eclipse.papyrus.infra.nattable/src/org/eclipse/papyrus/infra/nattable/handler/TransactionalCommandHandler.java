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
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommandHandler;
import org.eclipse.nebula.widgets.nattable.command.VisualRefreshCommand;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.papyrus.infra.nattable.celleditor.AbstractCancelableDialogCellEditor;
import org.eclipse.swt.widgets.Display;


/**
 * A wrapper for layer command handlers that executes them on a {@link TransactionalEditingDomain}'s command stack.
 * This ensures atomic undo/redo of all model changes performed by the command.
 */
public class TransactionalCommandHandler<T extends ILayerCommand> implements ILayerCommandHandler<T> {

	private final ILayerCommandHandler<T> delegate;

	private final TransactionalEditingDomain domain;

	public TransactionalCommandHandler(ILayerCommandHandler<T> delegate, TransactionalEditingDomain domain) {
		this.delegate = delegate;
		this.domain = domain;
	}

	@Override
	public Class<T> getCommandClass() {
		return delegate.getCommandClass();
	}

	@Override
	public boolean doCommand(final ILayer layer, final T command) {
		final boolean[] result = { false };

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit Table Cell") {

			@Override
			protected void doExecute() {
				result[0] = delegate.doCommand(layer, command);
				if((AbstractCancelableDialogCellEditor.getAndResetExitCode() != Window.OK) || !result[0]) {
					// Refresh the visual presentation of the layer because stereotype applications
					// may have updated some cells
					Display.getCurrent().asyncExec(new Runnable() {
						
						@Override
						public void run() {
							layer.doCommand(new VisualRefreshCommand());
						}
					});
					
					// Roll back any changes that we made along the way
					throw new OperationCanceledException();
				}
			}
		});

		return result[0];
	}
}
