/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.service.palette.AspectToolService;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectActionProvider;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Connection tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeConnectionTool extends UnspecifiedTypeConnectionTool {

	/** List of element types of which one will be created (of type <code>IElementType</code>). */
	protected List elementTypes;

	/** post action list */
	protected List<IAspectAction> postActions = new ArrayList<IAspectAction>();

	/**
	 * Creates an AspectUnspecifiedTypeCreationTool
	 * 
	 * @param elementTypes
	 *        List of element types of which one will be created (of type <code>IElementType</code>).
	 */
	public AspectUnspecifiedTypeConnectionTool(List elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createConnection() {
		List<?> selectedEditParts = getCurrentViewer().getSelectedEditParts();

		// only attempt to create connection if there are two shapes selected
		if(!selectedEditParts.isEmpty()) {

			IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)selectedEditParts.get(0);

			IGraphicalEditPart targetEditPart = selectedEditParts.size() == 2 ? (IGraphicalEditPart)selectedEditParts.get(1) : sourceEditPart;

			CreateConnectionRequest connectionRequest = (CreateConnectionRequest)createTargetRequest();

			connectionRequest.setTargetEditPart(sourceEditPart);
			connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
			connectionRequest.setLocation(new Point(0, 0));

			// only if the connection is supported will we get a non null
			// command from the sourceEditPart
			if(sourceEditPart.getCommand(connectionRequest) != null) {

				connectionRequest.setSourceEditPart(sourceEditPart);
				connectionRequest.setTargetEditPart(targetEditPart);
				connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
				connectionRequest.setLocation(new Point(0, 0));

				// inits the listener
				View eObject = (View)targetEditPart.getAdapter(View.class);
				DiagramEventBroker eventBroker = null;
				NotificationListener listener = null;
				boolean requiresPostAction = requiresPostAction();

				// adds the listener
				if(requiresPostAction) {
					// register a listener to have information about element creation
					// retrieves editing domain
					TransactionalEditingDomain domain;
					try {
						domain = EditorUtils.getServiceRegistry().getService(TransactionalEditingDomain.class);
						eventBroker = DiagramEventBroker.getInstance(domain);

						if(eventBroker == null) {
							return;
						}
						listener = new NotificationListener() {

							public void notifyChanged(Notification notification) {
								Connector newValue = (Connector)notification.getNewValue();
								EditPart editPart = (EditPart)getCurrentViewer().getEditPartRegistry().get(newValue);
								for(IAspectAction action : postActions) {
									action.run(editPart);
								}
							}
						};

						eventBroker.addNotificationListener(eObject, listener);
					} catch (ServiceException e) {
						Activator.log.error(e);
					}
				}

				EditPartViewer viewer = getCurrentViewer();
				Command command = targetEditPart.getCommand(connectionRequest);
				setCurrentCommand(command);

				executeCurrentCommand();

				if(requiresPostAction) {
					if(eventBroker != null) {
						eventBroker.removeNotificationListener(eObject, listener);
					}
				}

				selectAddedObject(viewer, DiagramCommandStack.getReturnValues(command));

				setAvoidDeactivation(false);
				eraseSourceFeedback();
				deactivate();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean handleCreateConnection() {
		// When a connection is to be created, a dialog box may appear which
		// will cause this tool to be deactivated and the feedback to be
		// erased. This behavior is overridden by setting the avoid
		// deactivation flag.
		setAvoidDeactivation(true);


		if(getTargetEditPart() == null) {
			return false;
		}
		// inits the listener
		View eObject = (View)getTargetEditPart().getAdapter(View.class);
		DiagramEventBroker eventBroker = null;
		NotificationListener listener = null;
		boolean requiresPostAction = requiresPostAction();

		// adds the listener
		if(requiresPostAction) {
			// register a listener to have information about element creation
			// retrieves editing domain
			TransactionalEditingDomain domain;
			try {
				domain = EditorUtils.getServiceRegistry().getService(TransactionalEditingDomain.class);
				eventBroker = DiagramEventBroker.getInstance(domain);

				if(eventBroker == null) {
					return false;
				}
				listener = new NotificationListener() {

					public void notifyChanged(Notification notification) {
						Connector newValue = (Connector)notification.getNewValue();
						EditPart editPart = (EditPart)getCurrentViewer().getEditPartRegistry().get(newValue);
						for(IAspectAction action : postActions) {
							action.run(editPart);
						}
					}
				};

				eventBroker.addNotificationListener(eObject, listener);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}

		EditPartViewer viewer = getCurrentViewer();
		Command endCommand = getCommand();
		setCurrentCommand(endCommand);

		executeCurrentCommand();

		if(requiresPostAction) {
			if(eventBroker != null) {
				eventBroker.removeNotificationListener(eObject, listener);
			}
		}

		selectAddedObject(viewer, DiagramCommandStack.getReturnValues(endCommand));

		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();

		return true;
	}

	/**
	 * checks if this tool realizes post actions
	 * 
	 * @return <code>true</code> if post actions must be executed
	 */
	protected boolean requiresPostAction() {
		return postActions.size() > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void applyProperty(Object key, Object value) {
		if(IPapyrusPaletteConstant.ASPECT_ACTION_KEY.equals(key)) {
			// initialize the pre and post actions
			// the value should be a NodeList
			if(value instanceof NodeList) {
				NodeList nodeList = ((NodeList)value);
				for(int i = 0; i < nodeList.getLength(); i++) {
					Node childNode = nodeList.item(i);
					String childName = childNode.getNodeName();
					if(IPapyrusPaletteConstant.POST_ACTION.equals(childName)) {
						// node is a post action => retrieve the id of the provider in charge of this configuration
						IAspectActionProvider provider = AspectToolService.getInstance().getProvider(AspectToolService.getProviderId(childNode));
						if(provider != null) {
							IAspectAction action = provider.createAction(childNode);
							postActions.add(action);
						} else {
							Activator.log.error("impossible to find factory with id: " + AspectToolService.getProviderId(childNode), null);
						}
					} else if(IPapyrusPaletteConstant.PRE_ACTION.equals(childName)) {
						// no implementation yet
					}
				}
			}
			return;
		}
		super.applyProperty(key, value);
	}

	/**
	 * Returns the element types created by this tool
	 * 
	 * @return the element types created by this tool
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}
}
