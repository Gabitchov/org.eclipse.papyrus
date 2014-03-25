/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 421411
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.papyrus.commands.util.NonDirtyingUtils;

/**
 * This DiagramCommandStack uses CheckedOperationHistory instead of the default one.
 * 
 * @author vhemery
 */
public class CheckedDiagramCommandStack extends DiagramCommandStack {
	
	protected IOperationHistory operationHistory;

	public CheckedDiagramCommandStack(IDiagramEditDomain editDomain) {
		super(editDomain);
		operationHistory = CheckedOperationHistory.getInstance();
	}

	@Override
	protected IOperationHistory getOperationHistory() {
		return operationHistory;
	}

	public void execute(Command command, IProgressMonitor progressMonitor) {
        if ((command != null) && command.canExecute()) {
        	execute(wrap(command), progressMonitor);
        }
	}

	private ICommand wrap(Command command) {
		if(command instanceof CompoundCommand) {
			CompositeCommand composite = new CompositeCommand(command.getLabel());
			Object[] subCommands = ((CompoundCommand)command).getChildren();

			for(int i = 0; i < subCommands.length; i++) {
				composite.compose(wrap((Command)subCommands[i]));
			}
			return composite.reduce();
		}

		if(command instanceof ICommandProxy) {
			return getICommand(((ICommandProxy)command).getICommand());
		}

		if(null != command) {
			// Handle possible non-dirtying command
			return NonDirtyingUtils.wrap(command);
		} else {
			return null;
		}
	}
}
