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
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view.papyrus;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;


public class TransactionalUncheckedCommandProxy extends AbstractTransactionalCommand {
	
    /** The wrapped command */
    private Command command;

	public TransactionalUncheckedCommandProxy(TransactionalEditingDomain editingDomain, Command command) {
		super(editingDomain, (command.getLabel() == null) ? StringStatics.BLANK : command.getLabel(), null);
		Assert.isNotNull(command);
		this.command = command;
		addContext(new EditingDomainUndoContext(editingDomain));
	}

    protected CommandResult doExecuteWithResult(
            IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {

        command.execute();
        return CommandResult.newOKCommandResult();
    }

    protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {

        command.undo();
        setResult(CommandResult.newOKCommandResult());

        return Status.OK_STATUS;
    }

    protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {

        command.redo();
        setResult(CommandResult.newOKCommandResult());

        return Status.OK_STATUS;
    }

    /**
     * Returns the wrapped command.
     * 
     * @return Command
     */
    public Command getCommand() {
        return command;
    }

    public boolean canUndo() {
        return command.canUndo();
    }

    public boolean canExecute() {
        return command.canExecute();
    }

    public boolean canRedo() {
        return canExecute() && canUndo();
    }

    public void dispose() {
        super.dispose();
        command.dispose();
    }
}
