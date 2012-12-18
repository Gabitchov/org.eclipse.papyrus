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
 *  Vincent Lorenzo (CEA LIST)
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.ConnectionToolPreferences;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AspectToolService;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Connection tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeConnectionTool extends UnspecifiedTypeConnectionTool {

	private static final int STATE_CONNECTION_WAITING_END = STATE_CONNECTION_STARTED + 1;

	/**
	 * List of element types of which one will be created (of type <code>IElementType</code>).
	 */
	// protected List elementTypes;

	/** post action list */
	protected List<IAspectAction> postActions = new ArrayList<IAspectAction>();

	/** List of elements to create */
	private final List<IElementType> elementTypes;

	/**
	 * Creates an AspectUnspecifiedTypeCreationTool
	 * 
	 * @param elementTypes
	 *        List of element types of which one will be created (of type <code>IElementType</code>).
	 */
	public AspectUnspecifiedTypeConnectionTool(List<IElementType> elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;
	}

	/**
	 * @return the elementDescriptors
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}

	protected boolean handleButtonUpOneClick(int button) {
		return super.handleButtonUp(button);
	}

	protected boolean handleButtonUpTwoClicks(int button) {
		setCtrlKeyDown(getCurrentInput().isControlKeyDown());

		if(isInState(STATE_CONNECTION_STARTED)) {
			setState(STATE_CONNECTION_WAITING_END);
			return false;
		} else if(isInState(STATE_CONNECTION_WAITING_END)) {
			handleCreateConnection();
		}

		setState(STATE_TERMINAL);

		if(isInState(STATE_TERMINAL | STATE_INVALID)) {
			handleFinished();
		}

		return true;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#handleButtonUp(int)
	 */
	@Override
	protected boolean handleButtonUp(int button) {
		if(ConnectionToolPreferences.instance.isInSingleClickMode()) {
			return handleButtonUpOneClick(button);
		} else {
			return handleButtonUpTwoClicks(button);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createConnection() {
		List<?> selectedEditParts = getCurrentViewer().getSelectedEditParts();
		List<EObject> eobjects = new ArrayList<EObject>();
		List<NotificationListener> listeners = new ArrayList<NotificationListener>();
		CompoundCommand cmd = new CompoundCommand("Create Links");
		DiagramEventBroker eventBroker = null;
		final EditPartViewer viewer = getCurrentViewer();
		// only attempt to create connection if there are two shapes selected
		if(!selectedEditParts.isEmpty()) {
			IGraphicalEditPart targetEditPart = (IGraphicalEditPart)selectedEditParts.get(selectedEditParts.size() - 1);

			// allow add the listener only one time the target
			boolean done = false;
			for(int i = 0; i < selectedEditParts.size(); i++) {
				IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)selectedEditParts.get(i);
				if(i != 0) {
					if(sourceEditPart == targetEditPart) {
						break;
					}
				}

				CreateConnectionRequest connectionRequest = createTargetRequest();
				// get the anchors locations
				Point[] newLocation = LayoutUtils.getLinkAnchor(sourceEditPart, targetEditPart);
				connectionRequest.setTargetEditPart(sourceEditPart);
				connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
				connectionRequest.setLocation(newLocation[0]);

				// only if the connection is supported will we get a non null
				// command from the sourceEditPart

				if(sourceEditPart.getCommand(connectionRequest) != null) {

					connectionRequest.setSourceEditPart(sourceEditPart);
					connectionRequest.setTargetEditPart(targetEditPart);
					connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);

					connectionRequest.setLocation(newLocation[1]);

					// inits the listener
					View eObject = (View)targetEditPart.getAdapter(View.class);

					NotificationListener listener = null;
					boolean requiresPostAction = requiresPostAction();

					// adds the listener
					if(requiresPostAction) {
						// register a listener to have information about element
						// creation
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

									Map<?, ?> map = viewer.getEditPartRegistry();
									EditPart editPart = (EditPart)map.get(newValue);
									for(IAspectAction action : postActions) {
										action.run(editPart);
									}
								}
							};

							// we need to add only one time the listener of the
							// target (eobject)
							if(!done) {
								listeners.add(listener);
								eobjects.add(eObject);
								eventBroker.addNotificationListener(eObject, listener);
								done = true;
							}
						} catch (ServiceException e) {
							Activator.log.error(e);
						}
					}

					Command command = targetEditPart.getCommand(connectionRequest);
					cmd.add(command);
				}
			}

			setCurrentCommand(cmd);

			executeCurrentCommand();

			if(requiresPostAction()) {
				if(eventBroker != null) {
					for(int ii = 0; ii < eobjects.size(); ii++) {
						eventBroker.removeNotificationListener(eobjects.get(ii), listeners.get(ii));
					}
				}
			}

			selectAddedObject(viewer, DiagramCommandStack.getReturnValues(cmd));

			setAvoidDeactivation(false);
			eraseSourceFeedback();
			deactivate();

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
						Object newValue = notification.getNewValue();
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
						// node is a post action => retrieve the id of the
						// provider in charge of this configuration
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
	 * {@inheritDoc}
	 */
	@Override
	protected CreateConnectionRequest createTargetRequest() {
		return new CreateAspectUnspecifiedTypeConnectionRequest(getElementTypes(), false, getPreferencesHint());
	}

	/**
	 * Copy of the class {@link CreateUnspecifiedTypeConnectionRequest} to use
	 * the Papyrus request factory instead of the gmf one.
	 */
	public class CreateAspectUnspecifiedTypeConnectionRequest extends CreateUnspecifiedTypeConnectionRequest {

		/**
		 * List of relationship types of which one will be created (of type <code>IElementType</code>).
		 */
		// private List relationshipTypes;

		/**
		 * A map containing the <code>CreateConnectionRequest</code> for each
		 * element type.
		 */
		private Map requests = new HashMap();

		/**
		 * A flag to indicate if the Modeling Assistant Service should be used
		 * to find the types when the other end of the connection is known.
		 */
		private boolean useModelingAssistantService;

		/**
		 * A flag to indicate if this request is to create a connection from
		 * target to source.
		 */
		private boolean directionReversed = false;

		/**
		 * The hint used to find the appropriate preference store from which
		 * general diagramming preference values for properties of shapes,
		 * connections, and diagrams can be retrieved. This hint is mapped to a
		 * preference store in the {@link DiagramPreferencesRegistry}.
		 */
		private PreferencesHint preferencesHint;

		/**
		 * Creates a new <code>CreateUnspecifiedTypeConnectionRequest</code>.
		 * 
		 * @param relationshipTypes
		 *        List of relationship types of which one will be created
		 *        (of type <code>IElementType</code>).
		 * @param useModelingAssistantService
		 *        True if the Modeling Assistant Service should be used to
		 *        find the types when the other end of the connection is
		 *        known.
		 * @param preferencesHint
		 *        The preference hint that is to be used to find the
		 *        appropriate preference store from which to retrieve
		 *        diagram preference values. The preference hint is mapped
		 *        to a preference store in the preference registry <@link
		 *        DiagramPreferencesRegistry>.
		 */
		public CreateAspectUnspecifiedTypeConnectionRequest(List<IElementType> relationshipTypes, boolean useModelingAssistantService, PreferencesHint preferencesHint) {
			super(relationshipTypes, useModelingAssistantService, preferencesHint);
			this.useModelingAssistantService = useModelingAssistantService;
			this.preferencesHint = preferencesHint;
			createRequests();
		}

		/**
		 * Creates a <code>CreateConnectionRequest</code> for each relationship
		 * type and adds it to the map of requests.
		 */
		protected void createRequests() {
			for(Iterator<IElementType> iter = getElementTypes().iterator(); iter.hasNext();) {
				IElementType elementType = iter.next();
				Request request = PapyrusCreateViewRequestFactory.getCreateConnectionRequest(elementType, getPreferencesHint());
				request.setType(getType());
				requests.put(elementType, request);
			}
		}

		/**
		 * Returns the <code>CreateRequest</code> for the relationship type
		 * passed in.
		 * 
		 * @param relationshipType
		 * @return the <code>CreateRequest</code>
		 */
		@Override
		public CreateRequest getRequestForType(IElementType relationshipType) {
			if(requests != null) {
				return (CreateConnectionRequest)requests.get(relationshipType);
			}
			return null;
		}

		@Override
		public void addRequest(IElementType relationshipType, Request request) {
			if(requests != null) {
				requests.put(relationshipType, request);
			}
		}

		/**
		 * Returns a list of all the requests.
		 * 
		 * @return the requests
		 */
		@Override
		public List getAllRequests() {
			if(requests != null) {
				return new ArrayList(requests.values());
			}
			return Collections.EMPTY_LIST;
		}

		// /**
		// * Returns the list of element types.
		// *
		// * @return Returns the list of element types.
		// */
		// public List getElementTypes() {
		// return relationshipTypes;
		// }

		/**
		 * @see org.eclipse.gef.requests.CreateConnectionRequest#setSourceEditPart(org.eclipse.gef.EditPart)
		 */
		@Override
		public void setSourceEditPart(EditPart part) {
			if(requests != null) {
				for(Iterator iter = requests.values().iterator(); iter.hasNext();) {
					CreateConnectionRequest request = (CreateConnectionRequest)iter.next();
					request.setSourceEditPart(part);
				}
			}
			super.setSourceEditPart(part);
		}

		/**
		 * @see org.eclipse.gef.requests.TargetRequest#setTargetEditPart(org.eclipse.gef.EditPart)
		 */
		@Override
		public void setTargetEditPart(EditPart part) {
			if(requests != null) {
				for(Iterator iter = requests.values().iterator(); iter.hasNext();) {
					CreateConnectionRequest request = (CreateConnectionRequest)iter.next();
					request.setTargetEditPart(part);
				}
			}
			super.setTargetEditPart(part);
		}

		/**
		 * @see org.eclipse.gef.requests.CreateRequest#setLocation(org.eclipse.draw2d.geometry.Point)
		 */
		@Override
		public void setLocation(Point location) {
			if(requests != null) {
				for(Iterator iter = requests.values().iterator(); iter.hasNext();) {
					CreateConnectionRequest request = (CreateConnectionRequest)iter.next();
					request.setLocation(location);
				}
			}
			super.setLocation(location);
		}

		/**
		 * @see org.eclipse.gef.Request#setType(java.lang.Object)
		 */
		@Override
		public void setType(Object type) {
			if(requests != null) {
				for(Iterator iter = requests.values().iterator(); iter.hasNext();) {
					CreateConnectionRequest request = (CreateConnectionRequest)iter.next();
					request.setType(type);
				}
			}
			super.setType(type);
		}

		/**
		 * Returns true if this request is to create a connection from target to
		 * source.
		 * 
		 * @return Returns the directionReversed.
		 */
		@Override
		public boolean isDirectionReversed() {
			return directionReversed;
		}

		/**
		 * Sets the directionReversed flag.
		 * 
		 * @param directionReversed
		 *        The directionReversed to set.
		 */
		@Override
		public void setDirectionReversed(boolean directionReversed) {
			this.directionReversed = directionReversed;
		}

		/**
		 * Should the Modeling Assistant Service be used?
		 * 
		 * @return Returns true if the Modeling Assistant Service should be used
		 *         to find the types when the other end of the connection is
		 *         known.
		 */
		@Override
		public boolean useModelingAssistantService() {
			return useModelingAssistantService;
		}

		/**
		 * Gets the preferences hint that is to be used to find the appropriate
		 * preference store from which to retrieve diagram preference values.
		 * The preference hint is mapped to a preference store in the preference
		 * registry <@link DiagramPreferencesRegistry>.
		 * 
		 * @return the preferences hint
		 */
		@Override
		protected PreferencesHint getPreferencesHint() {
			return preferencesHint;
		}
	}

	public static class PapyrusCreateViewRequestFactory {

		/**
		 * Creates a new <code>CreateViewRequest</code> or <code>CreateViewAndElementRequest</code> based on the <code>IElementType</code> passed in.
		 * 
		 * @param type
		 *        the <code>IElementType</code>
		 * @param preferencesHint
		 *        The preference hint that is to be used to find the
		 *        appropriate preference store from which to retrieve
		 *        diagram preference values. The preference hint is mapped
		 *        to a preference store in the preference registry <@link
		 *        DiagramPreferencesRegistry>.
		 * @return the new request
		 */
		public static CreateViewRequest getCreateShapeRequest(IElementType type, PreferencesHint preferencesHint) {
			if(type instanceof INotationType) {
				ViewDescriptor viewDescriptor = new ViewDescriptor(null, Node.class, ((INotationType)type).getSemanticHint(), preferencesHint);
				return new CreateViewRequest(viewDescriptor);
			} else if(type instanceof IHintedType) {
				ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(new CreateElementRequestAdapter(new CreateElementRequest(type)), Node.class, ((IHintedType)type).getSemanticHint(), preferencesHint);
				return new CreateViewAndElementRequest(viewDescriptor);
			} else {
				return new CreateViewAndElementRequest(type, preferencesHint);
			}
		}

		/**
		 * Creates a new <code>CreateConnectionViewRequest</code> or <code>CreateConnectionViewAndElementRequest</code> based on the
		 * <code>IElementType</code> passed in.
		 * 
		 * @param type
		 *        the <code>IElementType</code>
		 * @param preferencesHint
		 *        The preference hint that is to be used to find the
		 *        appropriate preference store from which to retrieve
		 *        diagram preference values. The preference hint is mapped
		 *        to a preference store in the preference registry <@link
		 *        DiagramPreferencesRegistry>.
		 * @return the new request
		 */
		public static CreateConnectionViewRequest getCreateConnectionRequest(IElementType type, PreferencesHint preferencesHint) {
			if(type instanceof INotationType) {
				// Pass in the type as the element adapter so that it can be
				// retrieved in the cases where a popup menu is to appear with a
				// list of types.
				ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(type, ((IHintedType)type).getSemanticHint(), preferencesHint);
				return new CreateConnectionViewRequest(viewDescriptor);
			} else if(type instanceof IHintedType) {
				return new CreateConnectionViewAndElementRequest(type, ((IHintedType)type).getSemanticHint(), preferencesHint);
			} else {
				return new CreateConnectionViewAndElementRequest(type, preferencesHint);
			}
		}

		/**
		 * Creates a new <code>CreateConnectionViewRequest</code> or <code>CreateConnectionViewAndElementRequest</code> based on the
		 * <code>IElementType</code> passed in.
		 * 
		 * @param type
		 *        the <code>IElementType</code>
		 * @param graphicalHint
		 *        graphical hint for the view to create
		 * @param preferencesHint
		 *        The preference hint that is to be used to find the
		 *        appropriate preference store from which to retrieve
		 *        diagram preference values. The preference hint is mapped
		 *        to a preference store in the preference registry <@link
		 *        DiagramPreferencesRegistry>.
		 * @return the new request
		 */
		public static CreateConnectionViewRequest getCreateConnectionRequest(IElementType type, String graphicalHint, PreferencesHint preferencesHint) {
			if(type instanceof INotationType) {
				// Pass in the type as the element adapter so that it can be
				// retrieved in the cases where a popup menu is to appear with a
				// list of types.
				ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(type, graphicalHint, preferencesHint);
				return new CreateConnectionViewRequest(viewDescriptor);
			} else if(type instanceof IHintedType) {
				// force the graphical hint instead of the hint of the hinted
				// element
				return new CreateConnectionViewAndElementRequest(type, graphicalHint, preferencesHint);
			} else {
				return new CreateConnectionViewAndElementRequest(type, preferencesHint);
			}
		}
	}

}
