/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.uml.diagram.activity.request.InterruptibleEdgeRequest;
import org.eclipse.uml2.uml.ActivityEdge;

/**
 * Command to set an Activity Edge as an Interruptible Edge.
 * This common is deferred this mean that the command will be created and executed in the doExecuteCommand.
 * This can prevent undo however this way drag and drop works
 * In order to make this command to work the target EditPart has to implement {@link InterruptibleEdge}
 * 
 * @author adaussy
 * 
 */
public class DeferredInterruptibleEdgeCommand extends AbstractTransactionalCommand {

	/**
	 * {@link IGraphicalEditPart} of the {@link ActivityEdge} which implements {@link InterruptibleEdge}
	 */
	private EditPart hostEditPart;

	/**
	 * {@link ConnectionViewDescriptor} from creation mechanism
	 */
	private ConnectionViewDescriptor descriptor;

	/**
	 * Constructor {@link DeferredInterruptibleEdgeCommand#descriptor} and {@link DeferredInterruptibleEdgeCommand#hostEditPart}
	 */
	public DeferredInterruptibleEdgeCommand(TransactionalEditingDomain domain, String label, List affectedFiles, EditPart hostEditPart, ConnectionViewDescriptor descriptor) {
		super(domain, label, affectedFiles);
		this.hostEditPart = hostEditPart;
		this.descriptor = descriptor;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Object connectionEditPart = hostEditPart.getViewer().getEditPartRegistry().get(descriptor.getAdapter(View.class));
		if(connectionEditPart instanceof IGraphicalEditPart && connectionEditPart instanceof InterruptibleEdge) {
			InterruptibleEdgeRequest request = new InterruptibleEdgeRequest();
			request.setType(InterruptibleEdgeRequest.SET_INTERRUPTIBLE_EDGE);
			Command cmd = ((IGraphicalEditPart)connectionEditPart).getCommand(request);
			if(cmd != null && cmd.canExecute()) {
				cmd.execute();
			} else {
				return CommandResult.newErrorCommandResult("Unable to the the target Editpart as Interruptible Edge");////$NON-NLS-0$
			}
		}
		return CommandResult.newOKCommandResult();
	}
}
