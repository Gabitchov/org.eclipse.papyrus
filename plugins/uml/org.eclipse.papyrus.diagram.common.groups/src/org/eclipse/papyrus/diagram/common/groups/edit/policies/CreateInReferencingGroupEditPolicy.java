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
package org.eclipse.papyrus.diagram.common.groups.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
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
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.commands.ChooseParentNotificationCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.SetUpReferencesCommand;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;


/**
 * This Edit Policy applies on the compartment of a group which owns its elements by reference. It enables to recover the correct model container in
 * order to create the element at the right place in the model, before linking it to the referencing group.
 * 
 * In order to do so, the semantic creation command, inheriting {@link EditElementCommand}, must recover the
 * {@link GroupRequestConstants#MODEL_CONTAINER} parameter from the request to know the model container of the created element and assign it itself.
 * 
 * @author vhemery and adaussy
 */
public class CreateInReferencingGroupEditPolicy extends CreationEditPolicy {

	//List of the IGraphicalEditPart of the graphical parents available
	private List<IGraphicalEditPart> graphicalParents;

	//List of the IGraphicalEditPart of the model parents available
	private List<IGraphicalEditPart> modelParents;

	/**
	 * Get the command to create a group referenced child and create it in the appropriate place.
	 * 
	 * TODO list
	 * 1 - Change the relative coordinate in graphical creation request to absolute coordinate
	 * 2 - Create the notification command
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
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		// get the semantic request
		CreateElementRequest createElementRequest = (CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class);

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


		if(getHost() instanceof IGraphicalEditPart) {
			DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(getHost());
			//Find the edit part which can be model and graphical parent of the new element
			graphicalParents = new ArrayList<IGraphicalEditPart>();
			modelParents = new ArrayList<IGraphicalEditPart>();
			String nameObject = view.getDiagram().getType() + "_" + createElementRequest.getElementType().getDisplayName();
			Utils.createComputedListsOfParents(graphicalParents, modelParents, request, diagramPart, createElementRequest.getElementType().getEClass(), nameObject);
			EObject modelContainer = null;
			if(!modelParents.isEmpty()) {
				modelContainer = modelParents.get(0).resolveSemanticElement();
			} else {
				//If there is no model found for this element we use the default element
				modelContainer = getDefaultModelParent(createElementRequest);
			}
			if(!modelParents.isEmpty()) {
				createElementRequest.setParameter(GroupRequestConstants.MODEL_CONTAINERS, modelParents);
			}
			if(!graphicalParents.isEmpty()) {
				request.getExtendedData().put(GroupRequestConstants.GRAPHICAL_CONTAINERS, graphicalParents);
			}
			createElementRequest.setContainer(modelContainer);

		}

		// request
		Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));

		if(createElementCommand == null || !createElementCommand.canExecute()) {
			return UnexecutableCommand.INSTANCE;
		}
		// create the semantic create wrapper command
		SemanticCreateCommand semanticContainerParentCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		Command viewCommand = getCreateCommand(request);
		Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List<?>)request.getNewObject())));
		// create the semantic global command
		CompositeCommand semanticCommand = new CompositeCommand(semanticContainerParentCommand.getLabel());
		semanticCommand.compose(semanticContainerParentCommand);
		//Create a command to update references
		TransactionalEditingDomain editingDomain = ((GraphicalEditPart)getHost()).getEditingDomain();
		SetUpReferencesCommand setUpReferences = new SetUpReferencesCommand(editingDomain, semanticContainerParentCommand.getLabel(), requestAdapter, createElementRequest);
		semanticCommand.compose(setUpReferences);
		//ChooseParentNotificationCommand
		CompositeCommand choiceCommand = null;
		if(graphicalParents != null && modelParents != null) {
			String chooseCommandLabel = "Print choice notifications";//$NON-NLS-1$
			choiceCommand = new CompositeCommand(chooseCommandLabel);
			if(graphicalParents.size() > 1) {
				ChooseParentNotificationCommand graphicalNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Graphical ", graphicalParents, request);
				choiceCommand.compose(graphicalNotificationCommand);
			}
			if(modelParents.size() > 1) {
				ChooseParentNotificationCommand modelNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Model ", modelParents, request);
				modelNotificationCommand.setMode(ChooseParentNotificationCommand.MODEL_MODE);
				choiceCommand.compose(modelNotificationCommand);
			}

		}
		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticContainerParentCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		if(choiceCommand != null) {
			cc.compose(choiceCommand);
		}
		if(refreshConnectionCommand != null) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}

		return new ICommandProxy(cc);
	}

	/**
	 * Create a request in order to handle graphic creation
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest)
	 * 
	 * @param request
	 * @return
	 */
	protected Command getCreateCommand(CreateViewRequest request) {
		// get default graphical parent
		IGraphicalEditPart newParentPart = (IGraphicalEditPart)getHost();
		Object graphicalParents = request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CONTAINERS);
		if(graphicalParents instanceof List<?> && !((List<?>)graphicalParents).isEmpty()) {
			Object parentPart = ((List<?>)graphicalParents).get(0);
			if(parentPart instanceof IGraphicalEditPart) {
				newParentPart = (IGraphicalEditPart)parentPart;
			}
		}
		View parent = (View)newParentPart.getModel();
		// compute locations delta to translate the request location for new parent
		Rectangle hostBounds = Utils.getAbsoluteBounds((IGraphicalEditPart)getHost());
		Rectangle parentBounds = Utils.getAbsoluteBounds(newParentPart);
		Dimension delta = hostBounds.getLocation().getDifference(parentBounds.getLocation());
		request.getLocation().translate(delta);
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

	/**
	 * This method is called if no model parent is found and then the diagram edit par is sent back.
	 * Get the eobject to use as container for creation in this edit part. This method is intended to be overridden by diagrams which need to.
	 * 
	 * @param createElementRequest
	 *        the creation request
	 * @return the model container to use
	 */
	private EObject getDefaultModelParent(CreateElementRequest createElementRequest) {
		if(getHost() instanceof IGraphicalEditPart) {
			EClass typeToCreate = createElementRequest.getElementType().getEClass();
			IGraphicalEditPart hostParent = (IGraphicalEditPart)getHost();
			boolean found = false;
			while(!found && hostParent != null) {
				EObject hostParentElement = hostParent.resolveSemanticElement();
				for(EReference containmentRelation : hostParentElement.eClass().getEAllContainments()) {
					if(containmentRelation.getEReferenceType().isSuperTypeOf(typeToCreate)) {
						found = true;
					}
				}
				hostParent = (IGraphicalEditPart)hostParent.getParent();
			}
			return (hostParent.resolveSemanticElement());
		} else {
			return null;
		}
	}

	/**
	 * Select the best models containers among the list of possible parents
	 * 
	 * @param parents
	 *        group parents
	 * @return the best model container (deepest one) or null if none
	 */
	protected IGraphicalEditPart selectBestModelContainer(List<IGraphicalEditPart> parents) {
		IGraphicalEditPart container = null;
		int containerDepth = 0;
		//For all elements in parents
		for(IGraphicalEditPart parent : parents) {
			// select model containers only
			if(GroupContainmentRegistry.isContainerModel(parent)) {
				// select part the deepest in the diagram
				int depth = getDepth(parent);
				if(depth > containerDepth) {
					container = parent;
				}
			}
		}
		return container;
	}

	/**
	 * Get the depth at which the edit part is in the diagram
	 * 
	 * @param part
	 *        the edit part to test depth
	 * @return number of parents + 1
	 */
	protected int getDepth(IGraphicalEditPart part) {
		int depth = 0;
		EditPart parentPart = part;
		while(parentPart != null) {
			parentPart = parentPart.getParent();
			depth++;
		}
		return depth;
	}
}
