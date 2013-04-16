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
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - use commands instead of running code in post commit
 *  Philippe ROLAND (Atos) philippe.roland@atos.net - Implemented PreActions
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPostAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPreAction;
import org.w3c.dom.NodeList;

/**
 * Creation tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeCreationTool extends UnspecifiedTypeCreationTool {

	/**
	 * List of element types of which one will be created (of type <code>IElementType</code>).
	 */
	protected List<IElementType> elementTypes;

	/** post action list */
	protected List<IPostAction> postActions = new ArrayList<IPostAction>();

	/** preaction list */
	protected List<IPreAction> preActions = new ArrayList<IPreAction>();

	private static String ID_ASPECT_ACTION = "palette_aspect_actions" ;

	/**
	 * Creates an AspectUnspecifiedTypeCreationTool
	 * 
	 * @param elementTypes
	 *        List of element types of which one will be created (of type <code>IElementType</code>).
	 */
	public AspectUnspecifiedTypeCreationTool(List<IElementType> elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performCreation(int button) {
		antiScroll = true;
		boolean requiresPostCommitRun = requiresPostCommitRun();
		// EObject to listen
		View eObject = (View)getTargetEditPart().getAdapter(View.class);
		DiagramEventBroker eventBroker = null;
		NotificationListener listener = null;
		final EditPartViewer currentViewer = getCurrentViewer();

		if(requiresPostCommitRun) {
			// register a listener to have information about element creation
			// retrieves editing domain
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eObject);
			eventBroker = DiagramEventBroker.getInstance(domain);

			listener = new NotificationListener() {

				public void notifyChanged(Notification notification) {
					Object newValue = notification.getNewValue();
					if(currentViewer != null) {
						EditPart editPart = (EditPart)currentViewer.getEditPartRegistry().get(newValue);

						for(IPostAction action : postActions) {
							action.runInPostCommit(editPart);
						}
					}
				}
			};

			if(eventBroker != null) {
				eventBroker.addNotificationListener(eObject, listener);
			}
		}

		Command command = getCurrentCommand();

		if(command != null) {
			Command completeCommand = getCompleteCommand(command);

			setCurrentCommand(completeCommand);

			executeCurrentCommand();
		}

		if(requiresPostCommitRun && eventBroker != null) {
			eventBroker.removeNotificationListener(eObject, listener);
		}

		selectAddedObject(currentViewer, DiagramCommandStack.getReturnValues(command));

		antiScroll = false;
	}

	protected Command getCompleteCommand(Command createCommand) {
		CompoundCommand compositeCmd = new CompoundCommand("Create Element");

		for(IPreAction preAction : preActions) {
			Object context = getTargetEditPart().getModel();
			if(context instanceof View) {
				ICommand cmd = preAction.getNodePreCommand((View)context);
				if(cmd != null) {
					compositeCmd.add(new ICommandProxy(cmd));
				}
			}
		}

		compositeCmd.add(createCommand);

		CreateUnspecifiedAdapter viewAdapter = new CreateUnspecifiedAdapter();
		viewAdapter.add(getCreateRequest());

		for(IPostAction action : postActions) {
			ICommand cmd = action.getPostCommand(viewAdapter);
			if(cmd != null) {
				compositeCmd.add(new ICommandProxy(cmd));
			}
		}

		return compositeCmd;
	}

	/**
	 * checks if this tool needs a post commit run
	 * 
	 * @return <code>true</code> if post actions need a post commit run
	 */
	protected boolean requiresPostCommitRun() {
		for(IPostAction action : postActions) {
			if(action.needsPostCommitRun()) {
				return true;
			}
		}
		return false;
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
				PaletteUtil.initAspectActions((NodeList)value, postActions, preActions);
			}
		} else {
			super.applyProperty(key, value);
		}
	}

	/**
	 * Returns the list of element types
	 * 
	 * @return the list of element types
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Request createTargetRequest() {
		CreateAspectUnspecifiedTypeRequest request = new CreateAspectUnspecifiedTypeRequest(getElementTypes(), getPreferencesHint());
		request.getExtendedData().put(ID_ASPECT_ACTION, postActions);
		return request ;
	}

	@SuppressWarnings("unchecked")
	public static List<IAspectAction> getAspectActions(Request request)
	{
		return (List<IAspectAction>) (request == null ? Collections.emptyList() :  getAspectActions(request.getExtendedData()));
	}

	@SuppressWarnings("unchecked")
	public static List<IAspectAction> getAspectActions(Map map)
	{
		return (List<IAspectAction>) (map == null ? Collections.emptyList() : map.get(ID_ASPECT_ACTION));
	}

	public class CreateAspectUnspecifiedTypeRequest extends CreateUnspecifiedTypeRequest {

		/**
		 * Constructor.
		 * 
		 * @param elementTypes
		 * @param preferencesHint
		 */
		public CreateAspectUnspecifiedTypeRequest(List<IElementType> elementTypes, PreferencesHint preferencesHint) {
			super(elementTypes, preferencesHint);
		}

		/**
		 * Creates a <code>CreateViewRequest</code> or <code>CreateViewAndElementRequest</code> for each creation hint and
		 * adds it to the map of requests.
		 */
		@Override
		protected void createRequests() {
			for(IElementType elementType : (List<IElementType>)getElementTypes()) {
				Request request = null;
				if(elementType instanceof INotationType) {
					ViewDescriptor viewDescriptor = new ViewDescriptor(null, Node.class, ((INotationType)elementType).getSemanticHint(), getPreferencesHint());
					request = new CreateViewRequest(viewDescriptor);
				} else if(elementType instanceof IHintedType) {
					ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(new CreateElementRequestAdapter(new CreateElementRequest(elementType)), Node.class, getGraphicalHint((IHintedType)elementType), getPreferencesHint());
					request = new CreateViewAndElementRequest(viewDescriptor);
					request.setExtendedData(getExtendedData());
				} else {
					ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(new CreateElementRequestAdapter(new CreateElementRequest(elementType)), Node.class, getPreferencesHint());
					request = new CreateViewAndElementRequest(viewDescriptor);
					request.setExtendedData(getExtendedData());
				}

				request.setType(getType());
				requests.put(elementType, request);
			}
		}

		/**
		 * Returns the semantic hint for the given type. In case of extended
		 * type, it returns the hint of the super type
		 * 
		 * @param elementType
		 *        the hinted element type from which hint is retrieved
		 * @return
		 */
		protected String getGraphicalHint(IHintedType elementType) {
			String hint = elementType.getSemanticHint();
			return hint;
		}

	}

}
