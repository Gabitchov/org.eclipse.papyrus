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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

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
			View newTarget = createElementAndNodeCommand.getCreatedView();
			edge.setTarget(newTarget);
			IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			anchor.setId(anchorId);
			edge.setTargetAnchor(anchor);
			//reset bendpoints to target
			Bendpoints bendpoints = edge.getBendpoints();
			if(bendpoints instanceof RelativeBendpoints) {
				List points = ((RelativeBendpoints)bendpoints).getPoints();
				if(!points.isEmpty()) {
					List<RelativeBendpoint> newPoints = new ArrayList<RelativeBendpoint>();
					RelativeBendpoint first = (RelativeBendpoint)points.get(0);
					RelativeBendpoint last = (RelativeBendpoint)points.get(1);
					RelativeBendpoint rb1 = new RelativeBendpoint(first.getSourceX(), first.getSourceY(), first.getTargetX() - 8, first.getTargetY());
					RelativeBendpoint rb2 = new RelativeBendpoint(last.getSourceX() + 8, last.getSourceY(), last.getTargetX(), 0);
					newPoints.add(rb1);
					for(int i = 1; i < points.size() - 1; i++) {
						newPoints.add((RelativeBendpoint)points.get(i));
					}
					newPoints.add(rb2);
					((RelativeBendpoints)bendpoints).setPoints(newPoints);
				}
			}
		}
		return null;
	}
}
