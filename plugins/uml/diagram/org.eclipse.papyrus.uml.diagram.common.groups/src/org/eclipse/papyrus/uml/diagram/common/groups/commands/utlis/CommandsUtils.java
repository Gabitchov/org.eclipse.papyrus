/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.common.groups.commands.utlis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.common.groups.Messages;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeGraphicalParentCommand.Mode;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeModelParentCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChooseChildrenNotificationCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChooseParentNotificationCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.SetUpReferencesCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.UpdateReferencesCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.DefaultModelParent;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GroupRequestConstants;

/**
 * Util class for command
 * 
 * @author arthur daussy
 * 
 */
public class CommandsUtils {

	/**
	 * Parameter in a request which define which host (IGrapicalEditPart) has to handle the request
	 */
	public static final String NEW_PARENT_HOST = "New_parent_host";

	/**
	 * Parameter in a request which define the graphical parent ((IGrapicalEditPart))
	 */
	public static final String GRAPHICAL_PARENT = "Graphical_parent";

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
	public static CompositeCommand getSemanticCommand(CreateElementRequestAdapter requestAdapter, TransactionalEditingDomain editingDomain, CreateElementRequest createElementRequest, Command createElementCommand, List<IGraphicalEditPart> graphicalParents) {
		CompositeCommand semanticCommand;
		/*
		 * create the semantic create wrapper command
		 */
		SemanticCreateCommand semanticContainerParentCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		/*
		 * Create a command to update references
		 */
		SetUpReferencesCommand setUpReferences = new SetUpReferencesCommand(editingDomain, semanticContainerParentCommand.getLabel(), requestAdapter, graphicalParents);
		/*
		 * create the semantic global command
		 */
		semanticCommand = new CompositeCommand(semanticContainerParentCommand.getLabel());
		if(semanticCommand != null) {
			semanticCommand.compose(semanticContainerParentCommand);
		}
		if(setUpReferences != null) {
			semanticCommand.compose(setUpReferences);
		}
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
	public static CompositeCommand getChooseParentNotification(TransactionalEditingDomain editingDomain, CreateViewAndElementRequest request, List<IGraphicalEditPart> graphicalParents, List<IGraphicalEditPart> modelParents, IGraphicalEditPart getHost) {
		/*
		 * ChooseParentNotificationCommand
		 * 1 - Check if there is any choice to make
		 * 1.1 - Check that All list are initialized
		 * 1.2 - Check there are There at least 2 elements in one of the two least
		 * 2 - Create a composite command :
		 * 2.1 - Create the Graphical Choice command
		 * 2.2 - create the Model Choice command
		 */
		CompositeCommand choiceCommand = null;
		if(graphicalParents != null && modelParents != null && (modelParents.size() > 1 || graphicalParents.size() > 1)) {
			String chooseCommandLabel = "Print choice notifications";//$NON-NLS-1$
			choiceCommand = new CompositeCommand(chooseCommandLabel);
			if(modelParents.size() > 1) {
				ChooseParentNotificationCommand modelNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Model ", modelParents, request, ChooseParentNotificationCommand.MODEL_MODE, getHost);
				choiceCommand.compose(modelNotificationCommand);
			} else {
				if(graphicalParents.size() > 1) {
					ChooseParentNotificationCommand graphicalNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Graphical ", graphicalParents, request, ChooseParentNotificationCommand.GRAPHICAL_MODE, getHost);
					choiceCommand.compose(graphicalNotificationCommand);
				}
			}

		}
		return choiceCommand;
	}

	/**
	 * Return the command which create the notification to asked to the user to choose the graphical parent of undetermined element (elements which
	 * have at least 2 possible graphical parent)
	 * FIXME change the composite command to a normal command (composite command is not needed anymore)
	 * 
	 * @param editingDomain
	 *        TransactionalEditingDomain in order to create the command
	 * @param childAdapter
	 *        {@link IAdaptable} to find the {@link IGraphicalEditPart} of the child
	 * @return the composite command. This command is in two parts. The first represent the Notification to choose the model parent and if needed the
	 *         command to chose the graphical parent.
	 */
	public static CompositeCommand getChooseParentNotification(TransactionalEditingDomain editingDomain, ChangeBoundsRequest request, List<IGraphicalEditPart> graphicalParents, List<IGraphicalEditPart> modelParents, IGraphicalEditPart getHost) {
		/*
		 * ChooseParentNotificationCommand
		 * 1 - Check if there is any choice to make
		 * 1.1 - Check that All list are initialized
		 * 1.2 - Check there are There at least 2 elements in one of the two least
		 * 2 - Create a composite command :
		 * 2.1 - Create the Graphical Choice command
		 * 2.2 - create the Model Choice command
		 */
		CompositeCommand choiceCommand = null;
		if(graphicalParents != null && modelParents != null && (modelParents.size() > 1 || graphicalParents.size() > 1)) {
			String chooseCommandLabel = "Print choice notifications";//$NON-NLS-1$
			choiceCommand = new CompositeCommand(chooseCommandLabel);
			if(modelParents.size() > 1) {
				ChooseParentNotificationCommand modelNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Model ", modelParents, request, ChooseParentNotificationCommand.MODEL_MODE, getHost);
				choiceCommand.compose(modelNotificationCommand);
			} else {
				if(graphicalParents.size() > 1) {
					ChooseParentNotificationCommand graphicalNotificationCommand = new ChooseParentNotificationCommand(editingDomain, chooseCommandLabel + " : Graphical ", graphicalParents, request, ChooseParentNotificationCommand.GRAPHICAL_MODE, getHost);
					choiceCommand.compose(graphicalNotificationCommand);
				}
			}

		}
		return choiceCommand;
	}

	/**
	 * Check if the child already have a graphical parent and if its graphical parent is not a model parent on the new element in creation
	 * 
	 * @param element
	 *        Child we want to test
	 * @return true there a other group parent (which is not a parent of the new created element)
	 */
	public static boolean alreadyHaveGroupGraphicalParent(IGraphicalEditPart element, List<IGraphicalEditPart> modelParents) {
		IGraphicalEditPart parent = (IGraphicalEditPart)element.getParent();
		//CHANGE
		return GroupContainmentRegistry.isContainerConcerned(parent) && !(element.getParent().getChildren().contains(parent));//!modelParents.contains(parent);
	}

	/**
	 * Get the depth at which the edit part is in the diagram
	 * 
	 * @param part
	 *        the edit part to test depth
	 * @return number of parents + 1
	 */
	public static int getDepth(IGraphicalEditPart part) {
		int depth = 0;
		EditPart parentPart = part;
		while(parentPart != null) {
			parentPart = parentPart.getParent();
			depth++;
		}
		return depth;
	}

	/**
	 * Select the best models containers among the list of possible parents
	 * 
	 * @param parents
	 *        group parents
	 * @return the best model container (deepest one) or null if none
	 */
	public static IGraphicalEditPart selectBestModelContainer(List<IGraphicalEditPart> parents) {
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
	 * This method is called if no model parent was found. It will return the command handled by a default container.
	 * 
	 * @param request
	 *        original request
	 * @param createElementRequest
	 *        the creation request
	 * @param getHost
	 *        Host of the {@link EditPolicy}
	 * @return the command as if handle by the default container. Return if the current container is the default container
	 * 
	 */
	public static Command getCommandFromDefaultModelParent(CreateViewAndElementRequest request, CreateElementRequest createElementRequest, IGraphicalEditPart getHost) {
		//If no model parent was found
		//The system will look in the ancestor of the current host to find a element which can contain the new element and which is not a group
		EClass typeToCreate = createElementRequest.getElementType().getEClass();
		IGraphicalEditPart hostParent = getHost;

		while(hostParent != null) {
			EObject hostParentElement = hostParent.resolveSemanticElement();
			if(GroupContainmentRegistry.getDescriptorsWithContainerEClass(hostParentElement.eClass()).isEmpty()) {
				for(EReference containmentRelation : hostParentElement.eClass().getEAllContainments()) {
					if(containmentRelation.getEReferenceType().isSuperTypeOf(typeToCreate)) {
						if(getHost.equals(hostParent)) {
							request.getExtendedData().put(NEW_PARENT_HOST, hostParent);
							createElementRequest.setContainer(hostParentElement);
							return null;
						} else {
							//This edit part can not handle the creation. It send it to the new hostParent
							request.getExtendedData().put(CommandsUtils.NEW_PARENT_HOST, hostParent);
							Command cmd = hostParent.getCommand(request);
							return cmd;
						}
					}
				}
			}
			hostParent = (IGraphicalEditPart)hostParent.getParent();
		}
		return null;
	}

	/**
	 * This method is called if no model parent was found. It will return the command handled by a default container. (For change bound request)
	 * 
	 * @param request
	 *        The change boudn request
	 * @param currentEditPart
	 *        The element being moved
	 * @param getHost
	 *        The host of the current {@link EditPolicy}
	 * @return the command as if handle by the default container. Return if the current container is the default container
	 */
	public static Command getCommandFromDefaultModelParent(ChangeBoundsRequest request, IGraphicalEditPart currentEditPart, IGraphicalEditPart getHost) {
		//If no model parent was found
		//The system will look in the ancestor of the current host to find a element which can contain the new element and which is not a group
		EClass typeToCreate = currentEditPart.resolveSemanticElement().eClass();
		IGraphicalEditPart hostParent = getHost;

		while(hostParent != null) {
			EObject hostParentElement = hostParent.resolveSemanticElement();
			if(GroupContainmentRegistry.getDescriptorsWithContainerEClass(hostParentElement.eClass()).isEmpty()) {
				for(EReference containmentRelation : hostParentElement.eClass().getEAllContainments()) {
					if(containmentRelation.getEReferenceType().isSuperTypeOf(typeToCreate)) {
						if(getHost.equals(hostParent)) {
							return null;
						} else {
							//This edit part can not handle the creation. It send it to the new hostParent
							request.getExtendedData().put(CommandsUtils.NEW_PARENT_HOST, hostParent);
							Command cmd = hostParent.getCommand(request);
							return cmd;
						}
					}
				}
			}
			hostParent = (IGraphicalEditPart)hostParent.getParent();
		}
		return null;
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
	public static ChangeModelParentCommand getUpdateChildrenModel(List<IGraphicalEditPart> directChildsToComplete, AbstractContainerNodeDescriptor descriptor, TransactionalEditingDomain editingDomain, IAdaptable parent, IGraphicalEditPart anyPart) {
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
	 * set the {@see GroupRequestConstants#GRAPHICAL_CHILDREN} parameter of the request in order to make the list of children available in the
	 * LayoutEditPolicy
	 * 
	 * @param automaticChildren
	 *        All the {@link IGraphicalEditPart} you want to add as graphical children
	 * @param request
	 *        request on which you want to add the parameter
	 */
	public static void updateGraphicalChildren(List<IGraphicalEditPart> automaticChildren, Request request) {
		if(!automaticChildren.isEmpty()) {
			request.getExtendedData().put(GroupRequestConstants.GRAPHICAL_CHILDREN, automaticChildren);
		}
	}

	/**
	 * Create a notification to choose the graphical children of element in creation (request)
	 * 
	 * @param allChildren
	 *        All possible children
	 * @param automaticChildren
	 *        All the children has been automatically graphical children
	 * @param request
	 *        Creation request
	 * @param domain
	 *        EditingDomain to create TransactionalCommand
	 * @param label
	 *        Label of the command
	 * @param diagramPart
	 * @return The command or null is not possible
	 */
	public static CompositeCommand getChooseGraphicalChildrenNotificationCommand(List<IGraphicalEditPart> allChildren, List<IGraphicalEditPart> automaticChildren, CreateViewAndElementRequest request, TransactionalEditingDomain domain, String label, IGraphicalEditPart getHost, DiagramEditPart diagramPart) {
		if(allChildren.size() > automaticChildren.size()) {
			Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = request.getViewDescriptors().iterator();
			CompositeCommand compositeCommand = new CompositeCommand(label);
			while(descriptors.hasNext()) {
				CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
				ChooseChildrenNotificationCommand cmd = new ChooseChildrenNotificationCommand(domain, label, allChildren, automaticChildren, descriptor, getHost, diagramPart);
				if(cmd != null) {
					compositeCommand.compose(cmd);
				}
			}
			return compositeCommand;
		}
		return null;
	}

	/**
	 * @see #getChooseGraphicalChildrenNotificationCommand(List, List, CreateViewAndElementRequest, TransactionalEditingDomain, String,
	 *      IGraphicalEditPart).
	 *      This time the we directly give the IAdaptable element of the view
	 * @param allChildren
	 * @see #getChooseGraphicalChildrenNotificationCommand
	 * @param automaticChildren
	 * @see #getChooseGraphicalChildrenNotificationCommand
	 * @param adapter
	 *        IAdaptable of the parent group (Used to get the view)
	 * @param domain
	 * @see #getChooseGraphicalChildrenNotificationCommand
	 * @param label
	 * @see #getChooseGraphicalChildrenNotificationCommand
	 * @param getHost
	 * @see #getChooseGraphicalChildrenNotificationCommand
	 * @return
	 */
	public static CompositeCommand getChooseGraphicalChildrenNotificationCommand(List<IGraphicalEditPart> allChildren, List<IGraphicalEditPart> automaticChildren, IAdaptable adapter, TransactionalEditingDomain domain, String label, IGraphicalEditPart getHost, DiagramEditPart diagramPart) {
		CompositeCommand result = null;
		ChooseChildrenNotificationCommand cmd = new ChooseChildrenNotificationCommand(domain, label, allChildren, automaticChildren, adapter, getHost, diagramPart);
		if(cmd != null) {
			result = new CompositeCommand(label);
			result.compose(cmd);
		}
		return result;
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
	 * @param parentAdapter
	 *        Parent adapter (Use to get the EObject back after creation and the {@link IGraphicalEditPart})
	 * @param modelParents
	 * @return the composite command of all this steps
	 */
	public static CompositeCommand getHandleChildrenCommand(Set<AbstractContainerNodeDescriptor> descriptors, Request request, DiagramEditPart diagramPart, TransactionalEditingDomain editingDomain, IAdaptable parentAdapter, List<IGraphicalEditPart> modelParents, IGraphicalEditPart getHost) {
		CompositeCommand cc = null;
		//Do the following only if the created element is a group 
		if(!descriptors.isEmpty()) {
			//Command label
			String handleChildrenLabel = "Handle Children command ";//$NON-NLS-1$
			for(AbstractContainerNodeDescriptor descriptor : descriptors) {
				/*
				 * Child visually contained in the new group which can be graphical children of this new group
				 */
				List<IGraphicalEditPart> directChildsToComplete = new ArrayList<IGraphicalEditPart>();
				/*
				 * Old child visually contained before the request ( used in changeBound request )
				 */
				List<IGraphicalEditPart> oldDirectChildsToComplete = null;
				/*
				 * Initialize the two list directChildsToComplete and oldDirectChildsToComplete
				 */
				oldDirectChildsToComplete = initDirectChildLists(request, diagramPart, parentAdapter, descriptor, directChildsToComplete, oldDirectChildsToComplete);

				if((directChildsToComplete != null && !directChildsToComplete.isEmpty()) || (oldDirectChildsToComplete != null && !oldDirectChildsToComplete.isEmpty())) {
					cc = new CompositeCommand(handleChildrenLabel);
					/*
					 * List of elements atomically chosen as graphical child
					 */
					List<IGraphicalEditPart> newGraphicalChildren = new ArrayList<IGraphicalEditPart>();;
					/*
					 * List of elements on which the user should be asked to choose the graphical parent
					 */
					List<IGraphicalEditPart> choiceToMakeChildren = new ArrayList<IGraphicalEditPart>();;
					for(IGraphicalEditPart part : directChildsToComplete) {
						if(alreadyHaveGroupGraphicalParent(part, modelParents)) {
							if(isNotAlreadyAGraphicalSon(part, request, parentAdapter)) {
								choiceToMakeChildren.add(part);
							}
						} else {
							newGraphicalChildren.add(part);
						}
					}
					/*
					 * Command to update model of directChild which can be contain by the moving group
					 */
					if(!directChildsToComplete.isEmpty()) {
						ChangeModelParentCommand updateChildrenModel = getUpdateChildrenModel(directChildsToComplete, descriptor, editingDomain, parentAdapter, directChildsToComplete.get(0));
						if(updateChildrenModel != null) {
							cc.compose(updateChildrenModel);
						}
					}
					/*
					 * Command to update visually contained element to set their graphical parent with the parent Adapter
					 */
					if(!newGraphicalChildren.isEmpty()) {
						updateGraphicalChildren(newGraphicalChildren, request);
					}
					String updateCommandeLabel = "Update children references";//$NON-NLS-1$
					/*
					 * Update all graphical children references and model
					 */
					updateReferencesAndModelOfGraphicalChildren(request, editingDomain, parentAdapter, cc, directChildsToComplete, oldDirectChildsToComplete, handleChildrenLabel + ":" + updateCommandeLabel + " -> " + "update reference graphical child", getHost, descriptor);
					/*
					 * Command to update references of new child
					 */
					UpdateReferencesCommand updateRefCommand = new UpdateReferencesCommand(editingDomain, handleChildrenLabel + ":" + updateCommandeLabel + " -> " + "update reference new child", directChildsToComplete, descriptor, parentAdapter);
					if(updateRefCommand != null) {
						cc.compose(updateRefCommand);
					}
					/*
					 * Withdraw old referenced child which are not anymore has to be referenced
					 */
					withdrawOldChildrenReferences(editingDomain, parentAdapter, cc, handleChildrenLabel + ":" + updateCommandeLabel + " -> " + "remove reference from of child", descriptor, directChildsToComplete, oldDirectChildsToComplete);

					/*
					 * Command to create the graphical notification
					 */
					String chooseGraphicalChildrenLabel = "Notification for choosing graphical children";//$NON-NLS-1$
					CompositeCommand chooseGraphicalChildrenCommand = null;
					if(request instanceof CreateViewAndElementRequest) {
						chooseGraphicalChildrenCommand = getChooseGraphicalChildrenNotificationCommand(directChildsToComplete, newGraphicalChildren, (CreateViewAndElementRequest)request, editingDomain, chooseGraphicalChildrenLabel, getHost, diagramPart);
					} else if(request instanceof ChangeBoundsRequest) {
						chooseGraphicalChildrenCommand = getChooseGraphicalChildrenNotificationCommand(directChildsToComplete, newGraphicalChildren, parentAdapter, editingDomain, chooseGraphicalChildrenLabel, getHost, diagramPart);
					}
					if(chooseGraphicalChildrenCommand != null) {
						cc.compose(chooseGraphicalChildrenCommand);
					}

					cc.reduce();
					if(cc.isEmpty()) {
						cc = null;
					}
				}

			}

		}

		return cc;
	}

	/**
	 * True if the request is just a movin request
	 * 
	 * @param request
	 * @return
	 */
	private static boolean isMovingRequest(ChangeBoundsRequest request) {
		return request.getSizeDelta() == null || request.getSizeDelta().equals(0, 0);
	}


	/***
	 * Update all the graphical children from a model point of view and a reference poitn of view
	 * note: It also update the the lists childlist and oldchildlist. It will withdraw the from those list all graphical children if the reques tis a
	 * simple move. If the request is a resize then all the grazphical children has to be taken into accoutn for next changes
	 * 
	 * @param request
	 *        {@link ChangeBoundsRequest}
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain}
	 * @param parentAdapter
	 *        Parent adapter used to get the {@link IGraphicalEditPart} of the parent
	 * @param cc
	 *        {@link CompositeCommand} use to compose new commands
	 * @param childList
	 *        List of all the visual child after transformation
	 * @param oldChildsList
	 *        List of all the visual child before transformation
	 * @param updateCommandeLabel
	 *        Label used to compose command
	 * @param getHost
	 *        Host of the request
	 */
	private static void updateReferencesAndModelOfGraphicalChildren(Request request, TransactionalEditingDomain editingDomain, IAdaptable parentAdapter, CompositeCommand cc, List<IGraphicalEditPart> childList, List<IGraphicalEditPart> oldChildsList, String updateCommandeLabel, IGraphicalEditPart getHost, AbstractContainerNodeDescriptor descriptor) {
		if(request instanceof ChangeBoundsRequest) {
			Object _movingPart = parentAdapter.getAdapter(EditPart.class);
			if(_movingPart instanceof IGraphicalEditPart) {
				List<IGraphicalEditPart> graphicalChilds = new ArrayList<IGraphicalEditPart>();
				IGraphicalEditPart movingEditPart = (IGraphicalEditPart)_movingPart;
				//Look for all graphical children
				graphicalChilds = getGraphicalChild(movingEditPart);
				/*
				 * For all graphical children
				 * if request = moving request
				 * -> Suppress old references
				 * -> change model parent if needed
				 * -> Add new references
				 * if request = resizing
				 * -> If the resizing is from west side
				 * - Translate the node to unmodify the GMF comportment of resizing by west = node moving
				 * -> If after resizing the node are no longer in the group
				 * - Unset references
				 * - Change graphical parent
				 */
				ChangeBoundsRequest changeBoundRequest = (ChangeBoundsRequest)request;
				for(IGraphicalEditPart graphicalChild : graphicalChilds) {
					/*
					 * All groups that contains the node before transforming ( transforming = moving or resizing )
					 */

					List<IGraphicalEditPart> oldGroupContainer = Utils.createComputeListsOfAllGroupContainerVisually(graphicalChild, changeBoundRequest, false, movingEditPart);
					/*
					 * All groups that contains the node after transforming
					 */
					List<IGraphicalEditPart> newGroupContainer = Utils.createComputeListsOfAllGroupContainerVisually(graphicalChild, changeBoundRequest, true, movingEditPart);
					IGraphicalEditPart compartmentEditPart = (IGraphicalEditPart)Utils.getCompartementEditPartFromMainEditPart(movingEditPart.getViewer().getEditPartRegistry(), movingEditPart);
					/*
					 * If is a moving request
					 * => Then the node should move with the group
					 */
					if(isMovingRequest(changeBoundRequest))
						handleMovingRequestForGraphicalChildren(editingDomain, cc, updateCommandeLabel, getHost, graphicalChild, oldGroupContainer, newGroupContainer, compartmentEditPart);
					else {
						cc = handleResizingRequestForGraphicalChildren(editingDomain, parentAdapter, cc, childList, getHost, descriptor, movingEditPart, graphicalChild, changeBoundRequest, newGroupContainer);
					}
				}
				/*
				 * Remove graphical children of the lists of node to handle
				 */
				childList.removeAll(graphicalChilds);
				oldChildsList.removeAll(graphicalChilds);
			}
		}

	}

	/**
	 * Handle resizing request for all graphical children
	 * - Erase the moving children after resize from WEST/NORT WHEST/WEST
	 * - Handle children going out after resizing
	 * 
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain}
	 * @param parentAdapter
	 *        {@link Adaptable} use to get the {@link IGraphicalEditPart} of the parent at runtime
	 * @param cc
	 *        {@link CompositeCommand} Use to add new Command
	 * @param childList
	 *        List of all the visual child after transformation
	 * @param getHost
	 *        Host of the request
	 * @param descriptor
	 *        Descriptor of the group
	 * @param movingEditPart
	 *        {@link IGraphicalEditPart} of the moving Edit Part (TODO Use the adapter to erase one argument)
	 * @param graphicalChild
	 *        {@link IGraphicalEditPart} of the graphical child you want to handle
	 * @param changeBoundRequest
	 *        {@link ChangeBoundsRequest}
	 * @param newGroupContainer
	 *        All group which can contain the node after transforming
	 * @return
	 */
	private static CompositeCommand handleResizingRequestForGraphicalChildren(TransactionalEditingDomain editingDomain, IAdaptable parentAdapter, CompositeCommand cc, List<IGraphicalEditPart> childList, IGraphicalEditPart getHost, AbstractContainerNodeDescriptor descriptor, IGraphicalEditPart movingEditPart, IGraphicalEditPart graphicalChild, ChangeBoundsRequest changeBoundRequest, List<IGraphicalEditPart> newGroupContainer) {
		/*
		 * If this is a resizing request.
		 * Node should not move => Only case possible = Graphical child which go out from the group
		 * -> Unmove node if resizing from west
		 * -> Handle no coming out
		 */

		int direction = changeBoundRequest.getResizeDirection();
		Point previousnLocation = graphicalChild.getFigure().getBounds().getLocation().getCopy();
		Point negatedMoeDelta = changeBoundRequest.getMoveDelta().getNegated().getCopy();
		boolean correctLocation = false;
		switch(direction) {
		case org.eclipse.draw2d.PositionConstants.WEST:
			previousnLocation.translate(negatedMoeDelta.x, 0);
			correctLocation = true;
			break;
		case org.eclipse.draw2d.PositionConstants.NORTH:
			previousnLocation.translate(0, negatedMoeDelta.y);
			correctLocation = true;
			break;
		case org.eclipse.draw2d.PositionConstants.NORTH_WEST:
			previousnLocation.translate(negatedMoeDelta);
			correctLocation = true;
			break;
		default:
			break;
		}

		if(!childList.contains(graphicalChild)) {
			if(correctLocation) {
				newGroupContainer.remove(movingEditPart);
				newGroupContainer.remove(Utils.getCompartementEditPartFromMainEditPart(movingEditPart.getViewer().getEditPartRegistry(), movingEditPart));
				correctLocation = false;
			}
			cc = handleGraphicalChildrenMovingOut(editingDomain, parentAdapter, cc, getHost, descriptor, movingEditPart, graphicalChild, newGroupContainer);
		}
		if(correctLocation) {
			SetBoundsCommand sbc = new SetBoundsCommand(editingDomain, "West or North resizing correcting relative coordiante", graphicalChild, previousnLocation);
			if(sbc != null) {
				cc.compose(sbc);
			}
		}
		return cc;
	}

	/**
	 * Handle all the graphical children of a group after a moving request
	 * 
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain}
	 * @param cc
	 *        {@link CommandProxy} to compose new commands
	 * @param updateCommandeLabel
	 *        Label Used for the command
	 * @param getHost
	 *        Host of the request
	 * @param graphicalChild
	 *        Graphical child to handle
	 * @param oldGroupContainer
	 *        All group that contained the node before transforming
	 * @param newGroupContainer
	 *        All group that contains the node after transforming
	 * @param compartmentEditPart
	 *        Compartment EditPart of the parent EditPart
	 */
	private static void handleMovingRequestForGraphicalChildren(TransactionalEditingDomain editingDomain, CompositeCommand cc, String updateCommandeLabel, IGraphicalEditPart getHost, IGraphicalEditPart graphicalChild, List<IGraphicalEditPart> oldGroupContainer, List<IGraphicalEditPart> newGroupContainer, IGraphicalEditPart compartmentEditPart) {
		{
			/*
			 * Suppress old reference
			 */
			for(IGraphicalEditPart parentGroup : oldGroupContainer) {
				if(!newGroupContainer.contains(parentGroup) && !parentGroup.equals(compartmentEditPart)) {
					/*
					 * Unset the reference
					 */
					UpdateReferencesCommand cmd1 = new UpdateReferencesCommand(editingDomain, updateCommandeLabel, Collections.singletonList(graphicalChild), GroupContainmentRegistry.getContainerDescriptor(parentGroup), parentGroup, UpdateReferencesCommand.UNSET_MODE);
					if(cmd1 != null) {
						cc.compose(cmd1);
					}
				}
			}
			//List of all model parent available (except the compartment edit part)
			List<IGraphicalEditPart> modelParents = new ArrayList<IGraphicalEditPart>();
			EObject childEObject = ((IGraphicalEditPart)graphicalChild).resolveSemanticElement();
			//Does the child have already a valid model parent
			boolean alreadyHaveValideModelParent = false;
			AbstractContainerNodeDescriptor containerDescriptor = GroupContainmentRegistry.getContainerDescriptor(compartmentEditPart);
			//If compartmentEditPart refer to a group which can be model parent then the child already have a model parent
			if(containerDescriptor != null) {
				alreadyHaveValideModelParent = containerDescriptor.canIBeModelParentOf(childEObject.eClass());
			}
			//Add new reference and update model
			for(IGraphicalEditPart newParentGroup : newGroupContainer) {
				//set Reference
				UpdateReferencesCommand cmd2 = new UpdateReferencesCommand(editingDomain, updateCommandeLabel, Collections.singletonList(graphicalChild), GroupContainmentRegistry.getContainerDescriptor(newParentGroup), newParentGroup, UpdateReferencesCommand.SET_MODE);
				if(cmd2 != null) {
					cc.compose(cmd2);
				}
				//Create a list of all model parent available. Set alreadyHaveValideModelParent to true if the child already have a model parent wich is on the new model parent
				AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(newParentGroup);
				if(desc != null) {
					if(desc.canIBeModelParentOf(childEObject.eClass())) {
						modelParents.add(newParentGroup);
					}
				}
			}
			/*
			 * Do not have mode parent change it
			 */
			if(!alreadyHaveValideModelParent) {
				Map<EObject, EReference> child = null;
				IGraphicalEditPart newModelParent = null;
				if(!modelParents.isEmpty()) {
					newModelParent = modelParents.get(0);
					AbstractContainerNodeDescriptor newDesc = GroupContainmentRegistry.getContainerDescriptor(newModelParent);
					if(newDesc != null && newModelParent != null) {
						EReference ref = newDesc.getContainmentReferenceFor(childEObject.eClass());
						child = Collections.singletonMap(childEObject, ref);
					}
				} else {
					DefaultModelParent parent = Utils.getDefaultModelParent(childEObject.eClass(), getHost);
					child = Collections.singletonMap(childEObject, parent.geteReference());
					newModelParent = parent.getiGraphicalEditPart();
				}
				if(child != null && newModelParent != null) {
					ChangeModelParentCommand changeModelParent = new ChangeModelParentCommand(editingDomain, newModelParent, child, newModelParent);
					if(changeModelParent != null) {
						cc.compose(changeModelParent);
					}
				}
			}
		}
	}

	/**
	 * Handle children movign out from a group after resizing
	 * 
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain}
	 * @param parentAdapter
	 *        Parent adapter to get the {@link IGraphicalEditPart} at runtime
	 * @param cc
	 *        {@link CompositeCommand} use to compose new commande
	 * @param getHost
	 *        Host of the request
	 * @param descriptor
	 *        AbstractContainerNodeDescriptor of the parent
	 * @param movingEditPart
	 *        {@link IGraphicalEditPart} of the parent
	 * @param graphicalChild
	 *        All graphical children of the group
	 * @param newGroupContainer
	 *        Group that containt the node after transforming
	 * @return
	 */
	private static CompositeCommand handleGraphicalChildrenMovingOut(TransactionalEditingDomain editingDomain, IAdaptable parentAdapter, CompositeCommand cc, IGraphicalEditPart getHost, AbstractContainerNodeDescriptor descriptor, IGraphicalEditPart movingEditPart, IGraphicalEditPart graphicalChild, List<IGraphicalEditPart> newGroupContainer) {
		String label = Messages.CommandsUtils_HandleGraphicalChildrenMovingOut_Label;
		if(cc == null) {
			cc = new CompositeCommand(label);
		}
		UpdateReferencesCommand updateRefCommand = new UpdateReferencesCommand(editingDomain, label, Collections.singletonList(graphicalChild), descriptor, parentAdapter, UpdateReferencesCommand.UNSET_MODE);
		if(updateRefCommand != null) {
			cc.compose(updateRefCommand);
		}
		IGraphicalEditPart newParent = null;
		if(!newGroupContainer.isEmpty()) {
			newParent = newGroupContainer.get(0);
		} else {
			newParent = (IGraphicalEditPart)movingEditPart.getParent(); //here add a default parent
		}
		/*
		 * FIXME
		 * Change
		 * Test is it is a containing feature
		 * Then change containing parent
		 */
		ChangeGraphicalParentCommand changeParentCmd = new ChangeGraphicalParentCommand(editingDomain, label + ": Changing graphical parent", newParent, graphicalChild, getHost);
		if(changeParentCmd != null) {
			cc.compose(changeParentCmd);
		}
		return cc;
	}


	/**
	 * Get all {@link IGraphicalEditPart} which are graphical children from a {@link IGraphicalEditPart} parent
	 * 
	 * @param parentEditPart
	 *        {@link IGraphicalEditPart} parent
	 * @return A {@link List} of {@link IGraphicalEditPart} of all the child and null parent part is not set properly
	 */
	private static List<IGraphicalEditPart> getGraphicalChild(IGraphicalEditPart parentEditPart) {
		EditPartViewer viewer = null;
		List<IGraphicalEditPart> result = null;
		if(parentEditPart != null) {
			viewer = parentEditPart.getViewer();
			if(viewer != null) {
				IGraphicalEditPart compartmentEditPart = (IGraphicalEditPart)Utils.getCompartementEditPartFromMainEditPart(viewer.getEditPartRegistry(), parentEditPart);
				result = new ArrayList<IGraphicalEditPart>();
				for(Object child : compartmentEditPart.getChildren()) {
					if(child instanceof IGraphicalEditPart && GroupContainmentRegistry.isNodeConcerned((IGraphicalEditPart)child)) {
						result.add((IGraphicalEditPart)child);
					}
				}
			}
		}
		return result;
	}


	/**
	 * Initialize the two list directChildsToComplete and oldDirectChildsToComplete in order to get back all the child visually contained after et
	 * before the request
	 * 
	 * @param request
	 *        {@link Request} send by the system (for now handle {@link CreateViewAndElementRequest} and {@link ChangeBoundsRequest})
	 * @param diagramPart
	 *        EditPart on the diagram
	 * @param parentAdapter
	 *        {@link IAdaptable} of the parent group (used to get the {@link IGraphicalEditPart} and {@link View})
	 * @param descriptor
	 *        {@link AbstractContainerNodeDescriptor} of the parent group
	 * @param directChildsToComplete
	 *        List of all elements which can be graphical child after the request
	 * @param oldDirectChildsToComplete
	 *        List of all elements which were graphical child before the request
	 * @return oldDirectChildsToComplete or null if not needed ( in case of {@link CreateViewAndElementRequest})
	 */
	private static List<IGraphicalEditPart> initDirectChildLists(Request request, IGraphicalEditPart diagramPart, IAdaptable parentAdapter, AbstractContainerNodeDescriptor descriptor, List<IGraphicalEditPart> directChildsToComplete, List<IGraphicalEditPart> oldDirectChildsToComplete) {
		if(request instanceof CreateViewAndElementRequest) {
			Utils.createComputedListsOfVisualYRelatedElements(directChildsToComplete, (CreateViewAndElementRequest)request, diagramPart, descriptor);
		} else if(request instanceof ChangeBoundsRequest) {
			Object _parentEditPart = parentAdapter.getAdapter(IGraphicalEditPart.class);
			if(_parentEditPart instanceof IGraphicalEditPart) {
				oldDirectChildsToComplete = new ArrayList<IGraphicalEditPart>();
				Utils.createComputedListsOfVisuallyRelatedElements(directChildsToComplete, (ChangeBoundsRequest)request, (IGraphicalEditPart)_parentEditPart, descriptor, true);
				Utils.createComputedListsOfVisuallyRelatedElements(oldDirectChildsToComplete, (ChangeBoundsRequest)request, (IGraphicalEditPart)_parentEditPart, descriptor, false);
			}
		}
		return oldDirectChildsToComplete;
	}

	/**
	 * Withdraw all references of element which are no longer contained in the group.
	 * With graphically all the children which are not visually contained in the group
	 * 
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain}
	 * @param parentAdapter
	 *        {@link IAdaptable} of the parent group
	 * @param cc
	 *        {@link CompositeCommand} to compose command the new command. (This command will be completed). If cc est nul then a new CompositeCommand
	 *        is created
	 * @param handleChildrenLabel
	 *        Label for the command
	 * @param descriptor
	 *        {@link AbstractContainerNodeDescriptor} of the parent group
	 * @param directChildsToComplete
	 *        List of all new element which are visually contained in the parent group
	 * @param oldDirectChildsToComplete
	 *        List of all element which were visually contained in the parent group
	 * @return return the composite command or null is no command is in cc
	 */
	private static CompositeCommand withdrawOldChildrenReferences(TransactionalEditingDomain editingDomain, IAdaptable parentAdapter, CompositeCommand cc, String handleChildrenLabel, AbstractContainerNodeDescriptor descriptor, List<IGraphicalEditPart> directChildsToComplete, List<IGraphicalEditPart> oldDirectChildsToComplete) {
		if(oldDirectChildsToComplete != null && !oldDirectChildsToComplete.isEmpty()) {
			List<IGraphicalEditPart> childToWithdraw = new ArrayList<IGraphicalEditPart>();
			for(IGraphicalEditPart child : oldDirectChildsToComplete) {
				if(!directChildsToComplete.contains(child)) {
					childToWithdraw.add(child);
				}
			}
			if(!childToWithdraw.isEmpty()) {
				String unreferencinComandLabel = "Unset Reference";
				if(cc == null) {
					cc = new CompositeCommand(handleChildrenLabel + ":" + unreferencinComandLabel);
				}
				UpdateReferencesCommand updateRefCommand = new UpdateReferencesCommand(editingDomain, handleChildrenLabel + ":" + unreferencinComandLabel, childToWithdraw, descriptor, parentAdapter, UpdateReferencesCommand.UNSET_MODE);
				if(updateRefCommand != null) {
					cc.compose(updateRefCommand);
				}

			}
			cc.reduce();
			if(cc.isEmpty()) {
				cc = null;
			}

		}
		return cc;
	}

	private static boolean isNotAlreadyAGraphicalSon(IGraphicalEditPart childPart, Request request, IAdaptable parentAdapter) {
		if(request instanceof ChangeBoundsRequest) {
			Object _editPart = parentAdapter.getAdapter(EditPart.class);
			if(_editPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart parentPart = (IGraphicalEditPart)_editPart;
				return !parentPart.getChildren().contains(childPart);
			}
		}

		return true;
	}


	/**
	 * Set in the reqest the current Graphical parent and the current Model Parent
	 * 
	 * @param request
	 *        request change want to set
	 * @param _graphicalParents
	 *        List of all graphical parent available
	 * @param _modelParents
	 *        List of all Model parent available
	 * @param getHost
	 *        host of the edit policy
	 * @return Return the default graphical parent
	 */
	public static IGraphicalEditPart setRequestParentsParameters(Request request, List<IGraphicalEditPart> _graphicalParents, List<IGraphicalEditPart> _modelParents, EditPart getHost) {
		/*
		 * Choose the default graphical parent
		 * 1 - If no graphical parent found then the host become the graphical parent
		 * else by default the the graphical parent of the list become the graphical parent
		 */
		IGraphicalEditPart graphicalParent = null;
		if(!_graphicalParents.isEmpty()) {
			graphicalParent = _graphicalParents.get(0);

			request.getExtendedData().put(GroupRequestConstants.GRAPHICAL_CONTAINERS, _graphicalParents);
		}
		if(_modelParents != null) {
			request.getExtendedData().put(GroupRequestConstants.MODEL_CONTAINERS, _modelParents);
		}



		return graphicalParent;
	}

	/**
	 * Send the request to a suitable host. A suitable host is a host which can be a model parent of the editing element. This implementation allow
	 * you to deal with creation request
	 * 
	 * @param request
	 *        CreateViewAndElementRequest of the element in creation
	 * @param createElementRequest
	 *        CreateElementRequest of the element in creation
	 * @param getHost
	 *        Host of the editPolicy
	 * @param _modelParents
	 *        All model parent available
	 * @return
	 */
	public static Command sendRequestSuitableHost(CreateViewAndElementRequest request, CreateElementRequest createElementRequest, IGraphicalEditPart getHost, List<IGraphicalEditPart> _modelParents) {
		EObject modelContainer = null;
		//If the system has found model parent 
		if(!_modelParents.isEmpty()) {
			IGraphicalEditPart defaultGraphicalEditPart = _modelParents.get(0);
			//If the current host is different the first element on the modelParent list the system send the request to its edit part
			if(!getHost.equals(defaultGraphicalEditPart)) {
				request.getExtendedData().put(NEW_PARENT_HOST, defaultGraphicalEditPart);
				return defaultGraphicalEditPart.getCommand(request);
			}
			modelContainer = getHost.resolveSemanticElement();
			createElementRequest.setContainer(modelContainer);
		} else {
			/*
			 * If there is no model found for this element we use the default element
			 */
			Command cmd = getCommandFromDefaultModelParent(request, createElementRequest, getHost);
			if(cmd != null) {
				return cmd;
			}
		}
		return null;
	}

	/**
	 * Send the request to a suitable host. A suitable host is a host which can be a model parent of the editing element. This implementation allow
	 * you to deal with {@link ChangeBoundsRequest}
	 * 
	 * @param request
	 *        {@link ChangeBoundsRequest}
	 * @param getHost
	 *        {@link EditPart} host of the {@link EditPolicy}
	 * @param _modelParents
	 *        List of all {@link IGraphicalEditPart} which can be model parent of the moving element
	 * @param movingEditPart
	 *        The {@link IGraphicalEditPart} of the moving {@link EditPart}
	 * @return
	 */
	public static Command sendRequestSuitableHost(ChangeBoundsRequest request, IGraphicalEditPart getHost, List<IGraphicalEditPart> _modelParents, IGraphicalEditPart movingEditPart) {
		//If the system has found model parent 
		if(!_modelParents.isEmpty()) {
			IGraphicalEditPart defaultModelParentEditPart;
			//TODO redo tests with this
			if(_modelParents.contains(movingEditPart.getParent())) {
				defaultModelParentEditPart = (IGraphicalEditPart)movingEditPart.getParent();
			} else {
				defaultModelParentEditPart = _modelParents.get(0);
			}
			//If the current host is different the first element on the modelParent list the system send the request to its edit part
			if(!getHost.equals(defaultModelParentEditPart)) {
				return defaultModelParentEditPart.getCommand(request);
			}

		} else {
			/*
			 * If there is no model found for this element we use the default element
			 * FIXME 1 - Check the safety of editParts.get(0) . Try to move several element in the same time
			 */

			Command cmd = getCommandFromDefaultModelParent(request, movingEditPart, getHost);
			if(cmd != null) {
				return cmd;
			}

		}
		return null;
	}

	/**
	 * This method handle request with multiple EditPart ( @see {@link ChangeBoundsRequest#getEditParts()} ).
	 * It will handle it by creating as many request as {@link EditPart} in {@link ChangeBoundsRequest#getEditParts()} and ask the host to handle it.
	 * 
	 * @param request
	 *        {@link ChangeBoundsRequest}
	 * @param label
	 *        label of the resulting command if any
	 * @param getHost
	 *        Host of the editPolicy
	 * @return Return the composite command if any. Null it the request has less than 2 edit part
	 */
	public static Command requestEditPartMultiplexor(ChangeBoundsRequest request, String label, IGraphicalEditPart getHost) {
		CompositeCommand result = new CompositeCommand(label);
		if(request.getEditParts().size() > 1) {
			for(Object part : request.getEditParts()) {
				ChangeBoundsRequest req = new ChangeBoundsRequest();
				req.setEditParts(Collections.singletonList(part));
				req.setMoveDelta(request.getMoveDelta());
				req.setSizeDelta(request.getSizeDelta());
				req.setLocation(request.getLocation());
				req.setResizeDirection(request.getResizeDirection());
				req.setCenteredResize(request.isCenteredResize());
				req.setConstrainedMove(request.isConstrainedMove());
				req.setConstrainedResize(request.isConstrainedResize());
				req.setSnapToEnabled(request.isSnapToEnabled());
				req.setType(RequestConstants.REQ_RESIZE_CHILDREN);
				HashMap extendedData = new HashMap(request.getExtendedData());
				req.setExtendedData(extendedData);
				//				Command cmd = getHost.getCommand(req);
				Command cmd = getHost.getEditPolicy(EditPolicy.LAYOUT_ROLE).getCommand(req);
				if(cmd != null) {
					result.compose(new CommandProxy(cmd));
				}
			}
			if(!result.isEmpty()) {
				return new ICommandProxy(result);
			}
		}
		return null;
	}

	/**
	 * Compose the command to change the graphical parent
	 * 
	 * @param label
	 *        Label of the command
	 * @param result
	 *        Resulting composite command
	 * @param movingEditPart
	 *        The {@link IGraphicalEditPart} which is moving
	 * @param editingDomain
	 *        {@link TransactionalEditingDomain} use to create Transactionnal Command
	 * @param graphicalParent
	 *        The new graphical parent
	 * @param request
	 */
	public static void getChangeGraphicalParentCommand(String label, CompositeCommand result, IGraphicalEditPart movingEditPart, TransactionalEditingDomain editingDomain, IGraphicalEditPart graphicalParent, IGraphicalEditPart getHost, ChangeBoundsRequest request) {
		if(graphicalParent != null) {
			ChangeGraphicalParentCommand changeGraphicalParent = new ChangeGraphicalParentCommand(editingDomain, label + ": change graphical parent", graphicalParent, movingEditPart, (IGraphicalEditPart)getHost, request);
			if(changeGraphicalParent != null) {
				changeGraphicalParent.setMode(Mode.MOVE_CHILD);
				result.compose(changeGraphicalParent);
			}
		} else {
			ChangeGraphicalParentCommand changeGraphicalParent = new ChangeGraphicalParentCommand(editingDomain, label + ": change graphical parent", (IGraphicalEditPart)getHost, movingEditPart, (IGraphicalEditPart)getHost, request);
			if(changeGraphicalParent != null) {
				changeGraphicalParent.setMode(Mode.MOVE_CHILD);
				result.compose(changeGraphicalParent);
			}
		}
	}


}
