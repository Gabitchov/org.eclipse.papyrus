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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.LayerManager;
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
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeModelParentCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.ChooseChildrenNotificationCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.ChooseParentNotificationCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.SetUpReferencesCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.UpdateReferencesCommand;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;


/**
 * This Edit Policy applies on the compartment of a group (which hold elements by reference or containment). It enables to recover the correct model
 * container in order to create the element at the right place in the model, before linking it to the referencing group.
 * 
 * In order to do so, the semantic creation command, inheriting {@link EditElementCommand}, must recover the
 * {@link GroupRequestConstants#MODEL_CONTAINER} parameter from the request to know the model container of the created element and assign it itself.
 * 
 * @author vhemery and adaussy
 */
public class CreateInGroupEditPolicy extends CreationEditPolicy {

	public static final String NEW_PARENT_HOST = "New_parent_host";

	public static final String GRAPHICAL_PARENT = "Graphical_parent";

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
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		// get the semantic request
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


		if(getHost() instanceof IGraphicalEditPart) {
			/*
			 * Handling parents
			 */
			DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(getHost());

			/*
			 * Find the edit part which can be model and graphical parent of the new element
			 */
			Object _graphicalParents = request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CONTAINERS);
			Object _modelParents = request.getExtendedData().get(GroupRequestConstants.MODEL_CONTAINERS);
			String nameObject = view.getDiagram().getType() + "_" + createElementRequest.getElementType().getDisplayName();
			if(_graphicalParents instanceof List<?> && _modelParents instanceof List<?>) {
				graphicalParents = (List<IGraphicalEditPart>)_graphicalParents;
				modelParents = (List<IGraphicalEditPart>)_modelParents;
			} else {
				graphicalParents = new ArrayList<IGraphicalEditPart>();
				modelParents = new ArrayList<IGraphicalEditPart>();
				Utils.createComputedListsOfParents(graphicalParents, modelParents, request, diagramPart, createElementRequest.getElementType().getEClass(), nameObject);
				/*
				 * Set the graphical parent
				 */
				if(!graphicalParents.isEmpty()) {
					request.getExtendedData().put(GRAPHICAL_PARENT, graphicalParents.get(0));
				}

				EObject modelContainer = null;
				//If the system has found model parent 
				if(!modelParents.isEmpty()) {
					IGraphicalEditPart defaultGraphicalEditPart = modelParents.get(0);
					//If the current host is different the first element on the modelParent list the system send the request to its edit part
					if(!((IGraphicalEditPart)getHost()).equals(defaultGraphicalEditPart)) {
						request.getExtendedData().put(NEW_PARENT_HOST, defaultGraphicalEditPart);
						return defaultGraphicalEditPart.getCommand(request);
					}
					//FIXME See if necessary : Check if by default the container is the getHost ??
					modelContainer = modelParents.get(0).resolveSemanticElement();
					createElementRequest.setContainer(modelContainer);
				} else {
					/*
					 * If there is no model found for this element we use the default element
					 */
					Command cmd = getCommandFromDefaultModelParent(request, createElementRequest);
					if(cmd != null) {
						return cmd;
					}
				}
				if(modelParents != null) {
					createElementRequest.setParameter(GroupRequestConstants.MODEL_CONTAINERS, modelParents);
				}
				if(graphicalParents != null) {
					request.getExtendedData().put(GroupRequestConstants.GRAPHICAL_CONTAINERS, graphicalParents);
				}
			}
			/*
			 * handling sons if the creation is a group
			 */
			Set<AbstractContainerNodeDescriptor> descriptors = GroupContainmentRegistry.getDescriptorsWithContainerEClass(createElementRequest.getElementType().getEClass());
			handleChildren = getHandleChildrenCommand(descriptors, request, nameObject, diagramPart, editingDomain, requestAdapter);
		}

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
		// create the semantic global command
		/*
		 * create the semantic global command
		 */
		CompositeCommand semanticCommand = getSemanticCommand(requestAdapter, editingDomain, createElementRequest, createElementCommand);
		/*
		 * ChooseParentNotificationCommand
		 */
		CompositeCommand choiceCommand = getChooseParentNotification(editingDomain, request);
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

	/**
	 * Get the semantic command to create a new element.
	 * This will set ups all references needed and create the semantic Container Parent Command
	 * 
	 * @param requestAdapter
	 *        Request adapter of the global request
	 * @param createElementCommand
	 *        Create Element Request
	 * @param editingDomain
	 *        TransactionalEditingDomain needed to create transactionnal command
	 * @param createElementRequest
	 *        The request to create a new element
	 * @param createElementCommand
	 *        The command to create the element just after its creation
	 * @return
	 */
	protected CompositeCommand getSemanticCommand(CreateElementRequestAdapter requestAdapter, TransactionalEditingDomain editingDomain, CreateElementRequest createElementRequest, Command createElementCommand) {
		CompositeCommand semanticCommand;
		/*
		 * create the semantic create wrapper command
		 */
		SemanticCreateCommand semanticContainerParentCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		/*
		 * Create a command to update references
		 */
		SetUpReferencesCommand setUpReferences = new SetUpReferencesCommand(editingDomain, semanticContainerParentCommand.getLabel(), requestAdapter);
		/*
		 * create the semantic global command
		 */
		semanticCommand = new CompositeCommand(semanticContainerParentCommand.getLabel());
		semanticCommand.compose(semanticContainerParentCommand);
		semanticCommand.compose(setUpReferences);
		return semanticCommand;
	}

	/**
	 * Return the command which create the notification to asked to the user to choose the graphical parent of undetermined element (elements which
	 * have at least 2 possible graphical parent)
	 * FIXME change the composite command to a normal command (composite command is not needed anymore)
	 * 
	 * @param editingDomain
	 *        TransactionalEditingDomain in order to create the command
	 * @param request
	 *        General request
	 * @return the composite command. This command is in two parts. The first represent the Notification to choose the model parent and if needed the
	 *         command to chose the graphical parent.
	 */
	protected CompositeCommand getChooseParentNotification(TransactionalEditingDomain editingDomain, CreateViewAndElementRequest request) {
		/*
		 * ChooseParentNotificationCommand
		 * 1 - Check if there is any choice to make
		 * 1.1 - Check that All list are initialized
		 * 1.2 - Check there are There at least 2 elements in one of the two least
		 * 2 - Create a composite command :
		 * 2.1 - Create the Graphical Choice command
		 * 2.2 - create the Model Choice command (TODO)
		 */
		CompositeCommand choiceCommand = null;
		if(graphicalParents != null && modelParents != null && (modelParents.size() > 1 || graphicalParents.size() > 1)) {
			String chooseCommandLabel = "Print choice notifications";//$NON-NLS-1$
			choiceCommand = new CompositeCommand(chooseCommandLabel);
			if(modelParents.size() > 1) {
				ChooseParentNotificationCommand modelNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Model ", modelParents, request, ChooseParentNotificationCommand.MODEL_MODE);
				choiceCommand.compose(modelNotificationCommand);
			} else {
				if(graphicalParents.size() > 1) {
					ChooseParentNotificationCommand graphicalNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Graphical ", graphicalParents, request, ChooseParentNotificationCommand.GRAPHICAL_MODE);
					choiceCommand.compose(graphicalNotificationCommand);
				}
			}

		}
		return choiceCommand;
	}

	/**
	 * Give back the command to handle visually contained elements inside a new group in creation
	 * 0 - Check if the there is any descriptor (its means if the element in creation belong to the Group Framework
	 * 1 - Compute possible children elements (graphical and model)
	 * 2 - Update References
	 * 3 - Update Model (if needed)
	 * 4 - Reassign automatic graphical parent
	 * 5 - Create a notification command to choose the graphical parent if needed
	 * 
	 * @param descriptors
	 *        Descriptor of the group in creation
	 * @param request
	 *        General request
	 * @param nameObject
	 *        Name of the object (to find default size FIXME)
	 * @param diagramPart
	 *        EditPart of the diagram
	 * @param editingDomain
	 *        TransctionnalEditingDomain in order to create transactionnal command
	 * @param requestAdapter
	 *        Request adapter of the general command (Use to get the EObject back after creation
	 * @return the composite command of all this steps
	 */
	protected CompositeCommand getHandleChildrenCommand(Set<AbstractContainerNodeDescriptor> descriptors, CreateViewAndElementRequest request, String nameObject, IGraphicalEditPart diagramPart, TransactionalEditingDomain editingDomain, CreateElementRequestAdapter requestAdapter) {
		CompositeCommand cc = null;
		//Do the following only if the created element is a group 
		if(!descriptors.isEmpty()) {
			//Command label
			String handleChildrenLabel = "Handle Children command ";//$NON-NLS-1$
			for(AbstractContainerNodeDescriptor descriptor : descriptors) {
				//Child visually contained in the new group which can be graphical children of this new group
				List<IGraphicalEditPart> directChildsToComplete = new ArrayList<IGraphicalEditPart>();
				Utils.createComputedListsOfVisualYRelatedElements(directChildsToComplete, request, diagramPart, descriptor, nameObject);
				/*
				 * 1 - For each elements compute the number of available parents
				 * if there is less then 2
				 * Add this element to the collection new graphical children : newGraphicalChildren
				 * if the more than two
				 * The element keep its old graphical parent and this elements is added the the list of choiceParentForPossibleChildren
				 * 2 - Command update references of children
				 * 3 - Command update model is there needs of children
				 * 4 - Create a command to change the graphical parent of all the elements from newGraphicalChildren
				 * 5 - If choiceParentForPossibleChildren is not empty
				 * Create a choiceCommande
				 */
				if(!directChildsToComplete.isEmpty()) {
					cc = new CompositeCommand(handleChildrenLabel);
					/*
					 * List of elements atomically chosen as graphical child
					 */
					List<IGraphicalEditPart> newGraphicalChildren;
					/*
					 * List of elements on which the user should be asked to choose the graphical parent
					 */
					List<IGraphicalEditPart> choiceToMakeChildren;
					newGraphicalChildren = new ArrayList<IGraphicalEditPart>();
					choiceToMakeChildren = new ArrayList<IGraphicalEditPart>();
					for(IGraphicalEditPart part : directChildsToComplete) {
						if(alreadyHaveGroupGraphicalParent(part)) {
							choiceToMakeChildren.add(part);
						} else {
							newGraphicalChildren.add(part);
						}
					}
					/*
					 * Command to update model
					 */
					ChangeModelParentCommand updateChildrenModel = getUpdateChildrenModel(directChildsToComplete, descriptor, editingDomain, requestAdapter, directChildsToComplete.get(0));
					if(updateChildrenModel != null) {
						cc.compose(updateChildrenModel);
					}

					/*
					 * Command to update references
					 */
					String updateCommandeLabel = "Update children references";//$NON-NLS-1$
					UpdateReferencesCommand updateRefCommand = new UpdateReferencesCommand(editingDomain, handleChildrenLabel + ":" + updateCommandeLabel, directChildsToComplete, descriptor, requestAdapter);
					if(updateRefCommand != null) {
						cc.compose(updateRefCommand);
					}
					/*
					 * Command to update graphicalChildren
					 */
					updateGraphicalChildren(newGraphicalChildren, request);
					/*
					 * Command to create the graphical notification
					 */
					String chooseGraphicalChildrenLabel = "Notification for choosing graphical children";//$NON-NLS-1$
					CompositeCommand chooseGraphicalChildrenCommand = getChooseGraphicalChildrenNotificationCommand(directChildsToComplete, newGraphicalChildren, request, editingDomain, chooseGraphicalChildrenLabel);
					if(chooseGraphicalChildrenCommand != null) {
						cc.compose(chooseGraphicalChildrenCommand);
					}
				}
			}

		}
		return cc;
	}

	/**
	 * FIXME do the javadoc
	 * 
	 * @param allChildren
	 * @param automaticChildren
	 * @param request
	 * @param domain
	 * @param label
	 * @return
	 */
	protected CompositeCommand getChooseGraphicalChildrenNotificationCommand(List<IGraphicalEditPart> allChildren, List<IGraphicalEditPart> automaticChildren, CreateViewAndElementRequest request, TransactionalEditingDomain domain, String label) {
		if(allChildren.size() > automaticChildren.size()) {
			Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = request.getViewDescriptors().iterator();
			CompositeCommand compositeCommand = new CompositeCommand(label);
			while(descriptors.hasNext()) {
				CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
				ChooseChildrenNotificationCommand cmd = new ChooseChildrenNotificationCommand(domain, label, allChildren, automaticChildren, descriptor);
				if(cmd != null) {
					compositeCommand.compose(cmd);
				}
			}
			return compositeCommand;
		}
		return null;
	}

	/**
	 * set the {@see GroupRequestConstants#GRAPHICAL_CHILDREN} parameter of the request in order to make the list of children available in the
	 * LayoutEditPolicy
	 * 
	 * @param automaticChildren
	 *        All the {@link IGraphicalEditPart} you want to add as graphical children
	 * @param request
	 *        request on which you want to add the parameter
	 */
	protected void updateGraphicalChildren(List<IGraphicalEditPart> automaticChildren, CreateViewAndElementRequest request) {
		if(!automaticChildren.isEmpty()) {
			request.getExtendedData().put(GroupRequestConstants.GRAPHICAL_CHILDREN, automaticChildren);
		}
	}

	/**
	 * Update model for all new direct child.
	 * 
	 * @param directChildsToComplete
	 *        List of all direct child
	 * @param descriptor
	 *        descriptor of the group
	 * @param editingDomain
	 *        Editing domain to create command
	 * @param parent
	 *        RequestAdapter of the parent creation
	 * @param anyPart
	 *        Igraphical editPart to get back EditPartRegistery
	 * @return CompositeCommand of all command updating model for each child
	 */
	protected ChangeModelParentCommand getUpdateChildrenModel(List<IGraphicalEditPart> directChildsToComplete, AbstractContainerNodeDescriptor descriptor, TransactionalEditingDomain editingDomain, CreateElementRequestAdapter parent, IGraphicalEditPart anyPart) {
		ChangeModelParentCommand cmd = null;
		Map<EObject, EReference> elementToMove = new HashMap<EObject, EReference>();
		if(!directChildsToComplete.isEmpty()) {
			for(IGraphicalEditPart child : directChildsToComplete) {
				EObject childEObject = child.resolveSemanticElement();
				EClass childEClass = childEObject.eClass();
				if(descriptor.canIBeModelParentOf(childEClass)) {
					elementToMove.put(childEObject, descriptor.getContainmentReferenceFor(childEClass));
				}
			}
		}
		if(!elementToMove.isEmpty()) {
			cmd = new ChangeModelParentCommand(editingDomain, parent, elementToMove, anyPart);
		}
		return cmd;
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

	/**
	 * This method is called if no model parent is found and then the diagram edit par is sent back.
	 * Get the eobject to use as container for creation in this edit part. This method is intended to be overridden by diagrams which need to.
	 * 
	 * + * @param request
	 * + * original request
	 * 
	 * @param createElementRequest
	 *        the creation request
	 * @return the model container to use
	 *         + *
	 *         + * FIXME correct this with activity and
	 */
	protected Command getCommandFromDefaultModelParent(CreateViewAndElementRequest request, CreateElementRequest createElementRequest) {
		//If no model parent was found
		//The system will look in the ancestor of the current host to find a element which can contain the new element and which is not a group
		if(getHost() instanceof IGraphicalEditPart) {
			EClass typeToCreate = createElementRequest.getElementType().getEClass();
			IGraphicalEditPart hostParent = (IGraphicalEditPart)getHost();

			while(hostParent != null) {
				EObject hostParentElement = hostParent.resolveSemanticElement();
				if(GroupContainmentRegistry.getDescriptorsWithContainerEClass(hostParentElement.eClass()).isEmpty()) {
					for(EReference containmentRelation : hostParentElement.eClass().getEAllContainments()) {
						if(containmentRelation.getEReferenceType().isSuperTypeOf(typeToCreate)) {
							if(getHost().equals(hostParent)) {
								createElementRequest.setContainer(hostParentElement);
								return null;
							} else {
								//This edit part can not handle the creation. It send it to the new hostParent
								request.getExtendedData().put(NEW_PARENT_HOST, hostParent);
								Command cc = hostParent.getCommand(request);
								return cc;
							}
						}
					}
				}
				hostParent = (IGraphicalEditPart)hostParent.getParent();
			}
		}
		return null;
	}

	protected IFigure getFeedbackLayer() {
		return getLayer(LayerConstants.FEEDBACK_LAYER);
	}

	protected IFigure getLayer(Object layer) {
		return LayerManager.Helper.find(getHost()).getLayer(layer);
	}

	protected void removeFeedback(IFigure figure) {
		getFeedbackLayer().remove(figure);
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

	/**
	 * Check if the child already have a graphical parent and if its graphical parent is not a model parent on the new element in creation
	 * 
	 * @param element
	 *        Child we want to test
	 * @return true there a other group parent (which is not a parent of the new created element)
	 */
	public boolean alreadyHaveGroupGraphicalParent(IGraphicalEditPart element) {
		IGraphicalEditPart parent = (IGraphicalEditPart)element.getParent();
		return GroupContainmentRegistry.isContainerConcerned(parent) && !modelParents.contains(parent);
	}
}
