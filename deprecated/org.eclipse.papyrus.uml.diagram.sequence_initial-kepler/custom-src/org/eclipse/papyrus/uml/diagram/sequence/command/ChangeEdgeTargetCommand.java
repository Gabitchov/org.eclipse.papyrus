/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;


/**
 * Command used to change the target of an edge.
 * It create an IdentityAnchor to attach the edge.
 * 
 * @author Mathieu Velten
 * 
 */
public class ChangeEdgeTargetCommand extends AbstractTransactionalCommand {

	protected CreateElementAndNodeCommand createElementAndNodeCommand;

	protected ConnectionViewDescriptor descriptor;

	protected String anchorId;

	/**
	 * 
	 * @param editingDomain
	 *        the editing domain.
	 * @param createElementAndNodeCommand
	 *        used to retrieve the target new node of the edge.
	 * @param descriptor
	 *        used to retrieve the edge.
	 * @param anchorId
	 *        the identity of the anchor which will be created to attach the edge.
	 */
	public ChangeEdgeTargetCommand(TransactionalEditingDomain editingDomain, CreateElementAndNodeCommand createElementAndNodeCommand, ConnectionViewDescriptor descriptor, String anchorId) {
		super(editingDomain, "Change message graphical target", null);
		this.createElementAndNodeCommand = createElementAndNodeCommand;
		this.descriptor = descriptor;
		this.anchorId = anchorId;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// retrieve the edge from the descriptor
		Object obj = descriptor.getAdapter(Edge.class);

		if(obj instanceof Edge) {
			Edge edge = (Edge)obj;
			edge.setTarget(createElementAndNodeCommand.getCreatedView());

			IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			anchor.setId(anchorId);

			edge.setTargetAnchor(anchor);
		}
		return null;
	}

}
