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
 *   Atos Origin - Initial API and implementation
 *   Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.edit.policies;

import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.communication.custom.util.CommunicationRequestConstant;
import org.eclipse.papyrus.diagram.communication.custom.util.CommunicationUtil;
import org.eclipse.papyrus.diagram.communication.custom.util.MessageHelper;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;

// TODO: Auto-generated Javadoc
/**
 * A specific policy to handle the message : - Message feedback on creation is
 * always drawn in black (to avoid invisible feedback).
 */

@SuppressWarnings("restriction")
public class CommunicationGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * Overrides to disable uphill message.
	 * 
	 * @param request
	 *        the request
	 * @return the connection complete command
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command command = super.getConnectionCompleteCommand(request);
		if(command == null) {
			return UnexecutableCommand.INSTANCE;
		}
		ICommandProxy proxy = (ICommandProxy)request.getStartCommand();
		CompositeCommand cc = (CompositeCommand)proxy.getICommand();
		Iterator<?> commandItr = cc.iterator();
		while(commandItr.hasNext()) {
			Object obj = commandItr.next();
			if(obj instanceof SetConnectionBendpointsCommand) {
				SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand)obj;
				final PointList pointList = sbbCommand.getNewPointList();

				request.getExtendedData().put(CommunicationRequestConstant.SOURCE_MODEL_CONTAINER, CommunicationUtil.findInteractionFragmentAt(pointList.getFirstPoint(), getHost()));
				request.getExtendedData().put(CommunicationRequestConstant.TARGET_MODEL_CONTAINER, CommunicationUtil.findInteractionFragmentAt(pointList.getLastPoint(), getHost()));

			}
		}

		return command;
	}

	/**
	 * used to obtain the transactional edit domain.
	 * 
	 * @return the current transactional edit domain
	 */
	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * Gets the command.
	 * 
	 * @param request
	 *        the request
	 * @return the command {@inheritDoc}
	 */
	public Command getCommand(Request request) {
		if(REQ_CONNECTION_END.equals(request.getType())) {
			if(request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest)request);

				// case of Message
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest)request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);
				if(org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes.Message_8009.equals(createElementRequest.getElementType())) {
					EditPart sourceEditPart = ((CreateConnectionViewAndElementRequest)request).getSourceEditPart();
					EditPart targetEditPart = ((CreateConnectionViewAndElementRequest)request).getTargetEditPart();

					MessageHelper messageHelper = new MessageHelper(getEditingDomain());

					//test if source and target are already connected

					if((sourceEditPart instanceof LifelineEditPartCN) && (targetEditPart instanceof LifelineEditPartCN)) {

						if(CommunicationUtil.verifyIfLifelinesEPConnected(sourceEditPart, targetEditPart) != null) {
							ConnectionEditPart link = CommunicationUtil.verifyIfLifelinesEPConnected(sourceEditPart, targetEditPart);

							return messageHelper.getCommand((CreateConnectionViewAndElementRequest)request, c, link);
						}


					}
				}
			}
		}

		return super.getCommand(request);


	}

	/**
	 * Overrides to set the color of the dummyConnection to color black. This
	 * allow to see the feedback of the connection when it is created. By
	 * default, the color was the foreground color of the lifeline, which is
	 * always blank leading to an invisible feedback.
	 * 
	 * @param req
	 *        the req
	 * @return the connection
	 */
	@Override
	protected Connection createDummyConnection(Request req) {
		Connection conn = super.createDummyConnection(req);
		conn.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		return conn;
	}


}
