/******************************************************************************
 * Copyright (c) 2002, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.papyrus.diagram.clazz.custom.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.AttachInstanceSpecifcationCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationLinkEditPart;

/**
 * the graphical node edit policy for instance specification link use explicitely to attach
 * InstanceSpecification under link representation
 */
public class InstanceSpecificationGraphicalNodeEditPolicy extends CustomGraphicalNodeEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if(!(request instanceof CreateConnectionViewRequest))
			return null;
		AttachInstanceSpecifcationCommand instanceSpecifcationCommand = null;
		CreateConnectionViewRequest req = (CreateConnectionViewRequest)request;
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		Diagram diagramView = ((View)getHost().getModel()).getDiagram();
		TransactionalEditingDomain editingDomain = getEditingDomain();
		CreateCommand createCommand = new CreateCommand(editingDomain, req.getConnectionViewDescriptor(), diagramView
				.getDiagram());

		if(req.getConnectionViewDescriptor().getSemanticHint()
				.equals("" + InstanceSpecificationLinkEditPart.VISUAL_ID)) {
			instanceSpecifcationCommand = new AttachInstanceSpecifcationCommand(getEditingDomain(),
					((IAdaptable)createCommand.getCommandResult().getReturnValue()), getViewer());
		}
		setViewAdapter((IAdaptable)createCommand.getCommandResult().getReturnValue());

		SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(getViewAdapter());
		sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
		ConnectionAnchor sourceAnchor = getConnectableEditPart().getSourceConnectionAnchor(request);
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
		scaCommand.setEdgeAdaptor(getViewAdapter());
		scaCommand.setNewSourceTerminal(getConnectableEditPart().mapConnectionAnchorToTerminal(sourceAnchor));
		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(getViewAdapter());
		cc.compose(createCommand);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		cc.compose(sbbCommand);
		if(instanceSpecifcationCommand != null) {
			cc.compose(instanceSpecifcationCommand);
		}
		Command c = new ICommandProxy(cc);
		request.setStartCommand(c);
		return c;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return the viewer
	 */
	protected EditPartViewer getViewer() {
		return ((IGraphicalEditPart)getHost()).getViewer();
	}
}
