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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Shape;
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
 * Creation tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeCreationTool extends UnspecifiedTypeCreationTool {

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
	public AspectUnspecifiedTypeCreationTool(List elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performCreation(int button) {
		antiScroll = true;
		boolean requiresPostAction = requiresPostAction();
		// EObject to listen
		View eObject = (View)getTargetEditPart().getAdapter(View.class);
		DiagramEventBroker eventBroker = null;
		NotificationListener listener = null;
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
						Shape newValue = (Shape)notification.getNewValue();
						EditPartViewer viewer = getCurrentViewer();
						if(viewer == null) {
							viewer = (getTargetEditPart() != null) ? getTargetEditPart().getViewer() : null;
						}
						if(viewer != null) {
							EditPart editPart = (EditPart)getCurrentViewer().getEditPartRegistry().get(newValue);

							for(IAspectAction action : postActions) {
								action.run(editPart);
							}
						} else {
							Activator.log.error("Impossible to find the current viewer", null);
						}
					}
				};

				eventBroker.addNotificationListener(eObject, listener);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}

		EditPartViewer viewer = getCurrentViewer();
		Command c = getCurrentCommand();
		executeCurrentCommand();

		if(requiresPostAction) {
			if(eventBroker != null) {
				eventBroker.removeNotificationListener(eObject, listener);
			}
		}

		selectAddedObject(viewer, DiagramCommandStack.getReturnValues(c));

		antiScroll = false;
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
						// node is a post action => retrieve the id of the factory in charge of this configuration
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
	 * Returns the list of element types
	 * 
	 * @return the list of element types
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}

}
