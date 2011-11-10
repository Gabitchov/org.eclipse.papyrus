/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.utlis.CommandsUtils;
import org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;


/**
 * This Edit Policy applies on the compartment of a group (which hold elements by reference or containment). It enables to recover the correct model
 * container in
 * order to create the element at the right place in the model, before linking it to the referencing group.
 * 
 * In order to do so, the semantic creation command, inheriting {@link EditElementCommand}, must recover the
 * {@link GroupRequestConstants#MODEL_CONTAINER} parameter from the request to know the model container of the created element and assign it itself.
 * 
 * @author vhemery and adaussy
 */
public class CreateInGroupEditPolicy extends CreationEditPolicy {

	/** List of the IGraphicalEditPart of the graphical parents available */
	private List<IGraphicalEditPart> graphicalParents;

	/** List of the IGraphicalEditPart of the model parents available */
	private List<IGraphicalEditPart> modelParents;

	/**
	 * Get the command to create a group referenced child and create it in the appropriate place.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 * 
	 * @param request
	 *        the creation request
	 * @return the creation command or null
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateElementRequest createElementRequest = (CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class);
		//Needed to create transactionnal command
		TransactionalEditingDomain editingDomain = ((GraphicalEditPart)getHost()).getEditingDomain();
		//Command in creation
		CompositeCommand handleChildren = null;


		View view = (View)getHost().getModel();
		EObject hostElement = ViewUtil.resolveSemanticElement(view);
		if(hostElement == null && view.getElement() == null) {
			hostElement = view;
		}
		// Returns null if host is unresolvable so that trying to create a
		// new element in an unresolved shape will not be allowed.
		if(hostElement == null) {
			return null;
		}
		EditPart currentEditPart = getHost();
		if(currentEditPart instanceof IGraphicalEditPart) {
			/*
			 * Handling parents
			 */
			DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(currentEditPart);
			/*
			 * Find the edit part which can be model and graphical parent of the new element
			 */
			graphicalParents = new ArrayList<IGraphicalEditPart>();
			modelParents = new ArrayList<IGraphicalEditPart>();
			Utils.createComputedListsOfParents(graphicalParents, modelParents, request, diagramPart, createElementRequest.getElementType().getEClass());

			CommandsUtils.setRequestParentsParameters(request, graphicalParents, modelParents, getHost());

			/*
			 * If the current host is not a model parent of the element in creation then the request is send to suitable one
			 */
			Command relocatedCommand = CommandsUtils.sendRequestSuitableHost(request, createElementRequest, (IGraphicalEditPart)getHost(), modelParents);
			if(relocatedCommand != null) {
				return relocatedCommand;
			}

			/*
			 * handling sons if the creation is a group
			 */
			Set<AbstractContainerNodeDescriptor> descriptors = GroupContainmentRegistry.getDescriptorsWithContainerEClass(createElementRequest.getElementType().getEClass());
			handleChildren = CommandsUtils.getHandleChildrenCommand(descriptors, request, diagramPart, editingDomain, requestAdapter, modelParents, (IGraphicalEditPart)getHost());

			/*
			 * Request Part Creation
			 * 1 - Create Semantic Request
			 * 2 - Create View Request
			 * 3 - Create Choice request (If there is any choice to make)
			 */
			Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));

			if(createElementCommand == null || !createElementCommand.canExecute()) {
				return UnexecutableCommand.INSTANCE;
			}
			/*
			 * Create View Command
			 */
			Command viewCommand = getCreateCommand(request);
			/*
			 * Refresh Connection command
			 */
			Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List<?>)request.getNewObject())));
			/*
			 * create the semantic global command
			 */
			CompositeCommand semanticCommand = CommandsUtils.getSemanticCommand(requestAdapter, editingDomain, createElementRequest, createElementCommand, graphicalParents);
			/*
			 * ChooseParentNotificationCommand
			 */
			CompositeCommand choiceCommand = CommandsUtils.getChooseParentNotification(editingDomain, request, graphicalParents, modelParents, (IGraphicalEditPart)getHost());
			/*
			 * form the compound command and return
			 */
			CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
			cc.compose(semanticCommand);
			cc.compose(new CommandProxy(viewCommand));
			if(choiceCommand != null) {
				cc.compose(choiceCommand);
			}
			if(handleChildren != null) {
				cc.compose(handleChildren);
			}
			if(refreshConnectionCommand != null) {
				cc.compose(new CommandProxy(refreshConnectionCommand));
			}

			return new ICommandProxy(cc);
		}
		return super.getCreateElementAndViewCommand(request);
	}

	/**
	 * Create a request in order to handle graphic creation
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest)
	 * 
	 * @param request
	 * @param getHost
	 * @return
	 */
	@Override
	public Command getCreateCommand(CreateViewRequest request) {
		/*
		 * Get default graphical parent
		 */
		IGraphicalEditPart newParentPart = (IGraphicalEditPart)getHost();
		Object graphicalParents = request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CONTAINERS);
		if(graphicalParents instanceof List<?> && !((List<?>)graphicalParents).isEmpty()) {
			Object parentPart = ((List<?>)graphicalParents).get(0);
			if(parentPart instanceof IGraphicalEditPart) {
				newParentPart = (IGraphicalEditPart)parentPart;
			}
		}
		request.getExtendedData().put(CommandsUtils.GRAPHICAL_PARENT, newParentPart);
		View parent = (View)newParentPart.getModel();
		// construct command as in super method (except parent)
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = request.getViewDescriptors().iterator();
		while(descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
			CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, parent);
			cc.compose(createCommand);
		}
		return new ICommandProxy(cc.reduce());
	}

}
