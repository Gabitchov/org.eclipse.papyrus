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
package org.eclipse.papyrus.uml.diagram.common.groups.edit.policies;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeGraphicalParentCommand.Mode;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeModelParentCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.SetUpReferencesCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.UpdateReferencesCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.utlis.CommandsUtils;
import org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.DefaultModelParent;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;

/**
 * This edit policy is used to handle node positioning inside a group after creation or after a {@link ChangeBoundsRequest} You can find example of
 * uses of this policy in {@link org.eclipse.papyrus.uml.diagram.activity.edit.policies.CompartmentXYLayoutEditPolicy} or in
 * {@link org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart}
 * 
 * @author arthur daussy
 */
public class XYLayoutEditGroupPolicy extends XYLayoutEditPolicy {


	/**
	 * graphical parent of the edit part after moving
	 */
	private ArrayList<IGraphicalEditPart> graphicalParents;

	/**
	 * Model parent of the edit part after moving
	 */
	private ArrayList<IGraphicalEditPart> modelParents;

	/**
	 * Graphical parent of the edit part before moving
	 */
	private ArrayList<IGraphicalEditPart> oldGraphicalParents;

	/**
	 * Model parent of the edit part before moving
	 */
	private ArrayList<IGraphicalEditPart> oldModelParents;

	/**
	 * override this method in order to take into account the difference between graphical parent and model parent.
	 * If there are different there is a delta to compute and the figure has to be translated.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.CreateRequest)
	 * @param request
	 * @return
	 */
	@Override
	protected Object getConstraintFor(CreateRequest request) {
		if(request.getExtendedData().containsKey(CommandsUtils.GRAPHICAL_PARENT) && request.getExtendedData().containsKey(CommandsUtils.NEW_PARENT_HOST)) {
			IGraphicalEditPart graphicalParent = (IGraphicalEditPart)request.getExtendedData().get(CommandsUtils.GRAPHICAL_PARENT);
			IGraphicalEditPart newHost = (IGraphicalEditPart)request.getExtendedData().get(CommandsUtils.NEW_PARENT_HOST);
			Dimension delta = Utils.computeDeltaToChangeParent(newHost, graphicalParent);
			Rectangle rectangle = (Rectangle)super.getConstraintFor(request);
			rectangle.translate(delta.width, delta.height);
			return (Object)rectangle;
		}
		return super.getConstraintFor(request);
	}

	/**
	 * Override the super method in order to disable the command if the command has already been created on another edit part
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 *        Global Request
	 * @return Command
	 */
	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			return super.getCommand(request);
		}
		return null;
	}

	/**
	 * Return the resize command chained with the group-related commands if needed
	 * 
	 * @param request
	 *        the change bounds request
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		Command superCommand = super.getResizeChildrenCommand(request);
		if(superCommand != null) {
			String label = superCommand.getLabel();
			CompositeCommand commandWrapper = new CompositeCommand(label);
			/*
			 * If there is several edit part affected by the request multiplex the request
			 */
			Command multiplexor = CommandsUtils.requestEditPartMultiplexor(request, label, (IGraphicalEditPart)getHost());
			if(multiplexor != null) {
				return multiplexor;
			}

			String labelHandleChildren = "XYLayout : Handle children";
			//Thanks to requestEditPartMultiplexor its sure we only have only one editPart
			Object _movingEditPart = request.getEditParts().get(0);
			if(_movingEditPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart movingEditPart = (IGraphicalEditPart)_movingEditPart;
				IGraphicalEditPart movingCompartmentEditPart = (IGraphicalEditPart)Utils.getCompartementEditPartFromMainEditPart(((IGraphicalEditPart)getHost()).getViewer().getEditPartRegistry(), movingEditPart);
				if(movingCompartmentEditPart == null) {
					movingCompartmentEditPart = movingEditPart;
				}
				/*
				 * Find the moving compartment editPart
				 */
				TransactionalEditingDomain editingDomain = ((GraphicalEditPart)getHost()).getEditingDomain();

				/*
				 * Only handle element which are concerned by the framework else return the super method
				 */
				boolean isNodeConcernedByGroupFramework = GroupContainmentRegistry.isNodeConcerned(movingCompartmentEditPart);
				boolean isGroupConcernedByGroupFramework = GroupContainmentRegistry.isContainerConcerned(movingCompartmentEditPart);
				if(isNodeConcernedByGroupFramework || isGroupConcernedByGroupFramework) {
					/*
					 * Handling parents
					 */
					DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(movingEditPart);
					graphicalParents = new ArrayList<IGraphicalEditPart>();
					modelParents = new ArrayList<IGraphicalEditPart>();
					Utils.createComputedListsOfParents(graphicalParents, modelParents, movingEditPart, request, true);
					oldGraphicalParents = new ArrayList<IGraphicalEditPart>();
					oldModelParents = new ArrayList<IGraphicalEditPart>();
					Utils.createComputedListsOfParents(oldGraphicalParents, oldModelParents, movingEditPart, request, false);


					IGraphicalEditPart graphicalParent = CommandsUtils.setRequestParentsParameters(request, graphicalParents, modelParents, getHost());
					/*
					 * The the original position of the element
					 */
					setOriginalAbsolutePositionPosition(request, movingEditPart);
					//If the system has found model parent 
					Command relocateCommand = CommandsUtils.sendRequestSuitableHost(request, (IGraphicalEditPart)getHost(), modelParents, movingEditPart);
					if(relocateCommand != null) {
						return relocateCommand;
					}
					/*
					 * Execute the change bound request
					 */
					commandWrapper.compose(new CommandProxy(superCommand));
					/*
					 * Update model
					 */
					updateModel(commandWrapper, movingEditPart, editingDomain);
					/*
					 * Update the references
					 * 1 - Set up new references
					 * 2 - Withdraw old references
					 */
					updateMovingElementReferences(label, commandWrapper, movingEditPart, editingDomain);

					/*
					 * Then change the graphical parent
					 */
					CommandsUtils.getChangeGraphicalParentCommand(label, commandWrapper, movingEditPart, editingDomain, graphicalParent, (IGraphicalEditPart)getHost(), request);

					/*
					 * If the change bounds element is a group
					 */
					if(isGroupConcernedByGroupFramework) {
						Command handleChildren = getHandleChildren(request, labelHandleChildren, movingEditPart, diagramPart, movingCompartmentEditPart, editingDomain);
						if(handleChildren != null) {
							commandWrapper.compose(new CommandProxy(handleChildren));
						}
					}
					/*
					 * ChooseParentNotificationCommand
					 */
					CompositeCommand choiceCommand = CommandsUtils.getChooseParentNotification(editingDomain, request, graphicalParents, modelParents, (IGraphicalEditPart)getHost());
					if(choiceCommand != null) {
						commandWrapper.compose(choiceCommand);
					}

					return new ICommandProxy(commandWrapper);
				} else {
					return superCommand;
				}
			}

		}
		return superCommand;
	}

	/**
	 * Update the references of the movingElement
	 * 
	 * @param label
	 *        Label of the command
	 * @param commandWrapper
	 *        {@link CompositeCommand} in which all the command will be composed ( warning should be initialised before)
	 * @param labelHandleChildren
	 * @param movingEditPart
	 * @param editingDomain
	 */
	private void updateMovingElementReferences(String label, CompositeCommand commandWrapper, IGraphicalEditPart movingEditPart, TransactionalEditingDomain editingDomain) {
		SetUpReferencesCommand setUpReferences = new SetUpReferencesCommand(editingDomain, label + ": set up references", movingEditPart, graphicalParents);
		if(setUpReferences != null) {
			commandWrapper.compose(setUpReferences);
		}
		for(IGraphicalEditPart oldParent : oldGraphicalParents) {
			if(!graphicalParents.contains(oldParent)) {
				IGraphicalEditPart oldParentCompartmentEditPart = (IGraphicalEditPart)Utils.getCompartementEditPartFromMainEditPart(oldParent.getViewer().getEditPartRegistry(), oldParent);
				AbstractContainerNodeDescriptor descriptor = GroupContainmentRegistry.getContainerDescriptor(oldParentCompartmentEditPart);
				UpdateReferencesCommand withDrawReference = new UpdateReferencesCommand(editingDomain, label + ": withdraw old references", Collections.singletonList(movingEditPart), descriptor, oldParent, UpdateReferencesCommand.UNSET_MODE);
				if(withDrawReference != null) {
					commandWrapper.compose(withDrawReference);
				}
			}
		}
	}

	/**
	 * This model update the model parent of the moving node
	 * 
	 * @param commandWrapper
	 *        Resulting command in wich the new command should be composed (should not be null)
	 * @param movingEditPart
	 *        {@link IGraphicalEditPart} of the moving element
	 * @param editingDomain
	 *        {@link EditingDomain}
	 */
	private void updateModel(CompositeCommand commandWrapper, IGraphicalEditPart movingEditPart, TransactionalEditingDomain editingDomain) {
		EditPart host = getHost();
		//CHANGE
		if(!movingEditPart.getParent().equals(host)) {
			if(host != null) {
				EditPart compartmentEditPartHost = Utils.getCompartementEditPartFromMainEditPart(movingEditPart.getViewer().getEditPartRegistry(), host);
				if(compartmentEditPartHost instanceof IGraphicalEditPart) {
					AbstractContainerNodeDescriptor group = GroupContainmentRegistry.getContainerDescriptor((IGraphicalEditPart)compartmentEditPartHost);
					EReference ref = null;
					Map<EObject, EReference> child = null;
					EObject childEObject = movingEditPart.resolveSemanticElement();
					if(group != null) {
						EObject movingEObject = childEObject;
						if(movingEObject != null) {
							if(group.canIBeModelParentOf(movingEObject.eClass())) {
								ref = group.getContainmentReferenceFor(movingEObject.eClass());
								child = Collections.singletonMap(movingEObject, ref);
							}
						}
					} else {
						DefaultModelParent defaultModelContainer = Utils.getDefaultModelParent(childEObject.eClass(), (IGraphicalEditPart)getHost());
						ref = defaultModelContainer.geteReference();
						child = Collections.singletonMap(childEObject, defaultModelContainer.geteReference());
					}
					if(ref != null && child != null) {
						ChangeModelParentCommand changeModelParent = new ChangeModelParentCommand(editingDomain, compartmentEditPartHost, child, movingEditPart);
						if(changeModelParent != null) {
							commandWrapper.compose(changeModelParent);
						}
					}
				}
			}
		}
	}

	/**
	 * Set in the request the absolute coordinate of the moving element
	 * 
	 * @param request
	 * @param movingEditPart
	 */
	@SuppressWarnings("unchecked")
	private void setOriginalAbsolutePositionPosition(ChangeBoundsRequest request, IGraphicalEditPart movingEditPart) {
		//if(!request.getExtendedData().containsKey(GroupRequestConstants.CONSTRAINT_AFTER_MOVING) && movingEditPart instanceof IGraphicalEditPart) {
		if(movingEditPart instanceof IGraphicalEditPart) {
			Rectangle bounds = ((Rectangle)getConstraintFor(request, movingEditPart)).getCopy();
			translateFromLayoutRelativeToAbsolute(bounds);
			request.getExtendedData().put(GroupRequestConstants.CONSTRAINT_AFTER_MOVING, bounds);
		}
	}


	/**
	 * Command to handle all children of the moving element
	 * 
	 * @param request
	 *        The {@link ChangeBoundsRequest}
	 * @param label
	 *        A label fro the request
	 * @param movingEditPart
	 *        The {@link IGraphicalEditPart} of the moving element
	 * @param diagramPart
	 *        {@link IGraphicalEditPart} of the diagram
	 * @param movingCompartmentEditPart
	 *        The compartment {@link IGraphicalEditPart} of the moving node
	 * @param editingDomain
	 *        {@link EditingDomain}
	 * @param compartmentMovingEditPart
	 * @return the resulting command or null if nothing to do
	 */
	private Command getHandleChildren(ChangeBoundsRequest request, String label, IGraphicalEditPart movingEditPart, DiagramEditPart diagramPart, IGraphicalEditPart movingCompartmentEditPart, TransactionalEditingDomain editingDomain) {

		CompositeCommand result = new CompositeCommand(label);

		if(movingCompartmentEditPart != null && GroupContainmentRegistry.isContainerConcerned(movingCompartmentEditPart)) {

			CompositeCommand handleChildren = null;
			/*
			 * handling sons if the creation is a group
			 */
			Set<AbstractContainerNodeDescriptor> descriptors = GroupContainmentRegistry.getDescriptorsWithContainerEClass(movingEditPart.resolveSemanticElement().eClass());
			handleChildren = CommandsUtils.getHandleChildrenCommand(descriptors, request, diagramPart, editingDomain, movingEditPart, modelParents, (IGraphicalEditPart)getHost());
			if(handleChildren != null) {
				result.compose(handleChildren);
			}
			/*
			 * Change the the graphical parent of the GroupRequestConstants.GRAPHICAL_CHILDREN) set in the getHandleChildrenCommand
			 */
			if(request.getExtendedData().containsKey(GroupRequestConstants.GRAPHICAL_CHILDREN)) {
				List<IGraphicalEditPart> automaticChildren = (List<IGraphicalEditPart>)request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CHILDREN);
				for(IGraphicalEditPart child : automaticChildren) {
					if(child instanceof IGraphicalEditPart) {
						ChangeGraphicalParentCommand cmd = new ChangeGraphicalParentCommand(editingDomain, label, movingEditPart, child, (IGraphicalEditPart)getHost(), request);
						if(cmd != null) {
							cmd.setMode(Mode.MOVE_PARENT);
							result.compose(cmd);
						}
					}
				}
			}
			result.reduce();
			if(!result.isEmpty()) {
				return new ICommandProxy(result);
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Override to be able to prevent several execution of the CreateCommand
	 * The Create command will only be used if the new host parent is in the request
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param req
	 *        Global request
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request req) {
		return canHandleCreateRequestOnlyIfNewParent(req, (IGraphicalEditPart)getHost());
	}

	/**
	 * Return true except if the request is a create request in which {@link CreateInGroupEditPolicy#OLD_PARENT} and
	 * {@link CommandsUtils#NEW_PARENT_HOST} are set and are different
	 * 
	 * @param req
	 *        The global request
	 * @param getHost
	 *        The host on the edit policy
	 * @return True if can execute
	 */
	public static boolean canHandleCreateRequestOnlyIfNewParent(Request req, IGraphicalEditPart getHost) {
		//If there is a NEW_PARENT_HOST data then its means than the command has been asked to another edit part before
		//	If this host is the new host then it executes the create command
		//	Else do nothing
		//Else the command will not be asked to another EditPart so I have to execute it
		if(req.getExtendedData().containsKey(CommandsUtils.NEW_PARENT_HOST)) {
			IGraphicalEditPart newParent = (IGraphicalEditPart)req.getExtendedData().get(CommandsUtils.NEW_PARENT_HOST);
			if(((getHost).equals(newParent))) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the command to response of CreateRequest request.
	 * Override in order to set the graphical children of the created element
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if(request.getExtendedData().containsKey(GroupRequestConstants.GRAPHICAL_CHILDREN)) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			Command superCreateCommand = super.getCreateCommand(request);
			CompositeCommand compositeCreateCmd = new CompositeCommand(superCreateCommand.getLabel());
			compositeCreateCmd.compose(new CommandProxy(superCreateCommand));
			List<IGraphicalEditPart> automaticChildren = (List<IGraphicalEditPart>)request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CHILDREN);
			for(IGraphicalEditPart child : automaticChildren) {
				if(child instanceof IGraphicalEditPart) {
					String label = superCreateCommand + ": Change child graphical parent";
					ChangeGraphicalParentCommand cmd = new ChangeGraphicalParentCommand(editingDomain, label, request, child, (IGraphicalEditPart)getHost());
					if(cmd != null) {
						cmd.setMode(Mode.CREATION_CHILD);
						compositeCreateCmd.compose(cmd);
					}
				}
			}
			return new ICommandProxy(compositeCreateCmd);
		}
		return super.getCreateCommand(request);
	}





}
