/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.helper.ActivityLinkMappingHelper;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ObjectFlow;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** DropActionLocalConditionsAfterActionCommand label */
	private static final String LABEL = "DropLocalConditions";

	/** Point to translate successive local conditions to avoid overlapping */
	private static final Point LOCAL_CONDITIONS_TRANSLATION_POINT = new Point(160, 0);

	/** The specific drop node. */
	public int[] secificDropNode = { OpaqueActionEditPart.VISUAL_ID, CallBehaviorActionEditPart.VISUAL_ID, CallOperationActionEditPart.VISUAL_ID, TimeConstraintAsLocalPrecondEditPart.VISUAL_ID, TimeConstraintAsLocalPostcondEditPart.VISUAL_ID, DurationConstraintAsLocalPrecondEditPart.VISUAL_ID, DurationConstraintAsLocalPostcondEditPart.VISUAL_ID, IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID, IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID, InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID, InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID, ConstraintAsLocalPrecondEditPart.VISUAL_ID, ConstraintAsLocalPostcondEditPart.VISUAL_ID, ObjectFlowEditPart.VISUAL_ID, ControlFlowEditPart.VISUAL_ID };

	/**
	 * Instantiates a new custom diagram drag drop edit policy with the right link mapping helper
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(ActivityLinkMappingHelper.getInstance());
		init(secificDropNode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {
		switch(nodeVISUALID) {
		case OpaqueActionEditPart.VISUAL_ID:
		case CallBehaviorActionEditPart.VISUAL_ID:
		case CallOperationActionEditPart.VISUAL_ID:
			return dropAction(dropRequest, semanticElement, nodeVISUALID);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return dropActionLocalCondition(dropRequest, semanticElement, nodeVISUALID);
		}
		switch(linkVISUALID) {
		case ObjectFlowEditPart.VISUAL_ID:
		case ControlFlowEditPart.VISUAL_ID:
			return dropActivityEdge(dropRequest, semanticElement, linkVISUALID);
		}
		return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
	}

	/**
	 * Specific drop action for an action (with its local conditions)
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command for action
	 */
	protected Command dropAction(final DropObjectsRequest dropRequest, final Element semanticElement, int nodeVISUALID) {
		CompoundCommand globalCmd = new CompoundCommand();
		if(globalCmd.isEmpty()) {
			CompositeCommand cmd = getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticElement);
			globalCmd.add(new ICommandProxy(cmd));
		}
		// also drop local conditions
		DropActionLocalConditionsAfterActionCommand cmd = new DropActionLocalConditionsAfterActionCommand(dropRequest, semanticElement);
		globalCmd.add(cmd);
		return globalCmd;
	}

	/**
	 * Specific drop action for an action's local condition
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command for local condition
	 */
	protected Command dropActionLocalCondition(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {
		if(getHost() instanceof GraphicalEditPart) {
			// Adapt the location
			Point location = dropRequest.getLocation().getCopy();
			((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
			((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
			location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
			location.y += 100;
			// Retrieve expected graphical parent
			EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();
			// verification of container differs from usually, condition is graphically contained by the activity
			if(graphicalParent instanceof Activity) {
				// drop the constraint and its link to the action
				Element linkSource = semanticElement.getOwner();
				Element linkTarget = semanticElement;
				// check for existing link part
				for(Object targetView : DiagramEditPartsUtil.getEObjectViews(linkTarget)) {
					if(targetView instanceof View) {
						EditPart targetEditpart = DiagramEditPartsUtil.getEditPartFromView((View)targetView, getHost());
						if(targetEditpart instanceof ActionLocalPreconditionEditPart || targetEditpart instanceof ActionLocalPostconditionEditPart) {
							// condition link is already drawn.
							return UnexecutableCommand.INSTANCE;
						}
					}
				}

				if(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID || DurationConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID || IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID || InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID || ConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID) {
					return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Local Precondition link"), linkSource, linkTarget, ActionLocalPreconditionEditPart.VISUAL_ID, location, semanticElement));
				} else if(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID || DurationConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID || IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID || InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID || ConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID) {
					return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Local Postcondition link"), linkSource, linkTarget, ActionLocalPostconditionEditPart.VISUAL_ID, location, semanticElement));
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * the method provides command to create the binary link into the diagram. If the source and the
	 * target views do not exist, these views will be created.
	 * 
	 * @param cc
	 *        the composite command that will contain the set of command to create the binary
	 *        link
	 * @param source
	 *        the source the element source of the link
	 * @param target
	 *        the target the element target of the link
	 * @param linkVISUALID
	 *        the link VISUALID used to create the view
	 * @param location
	 *        the location the location where the view will be be created
	 * @param semanticLink
	 *        the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	public CompositeCommand dropObjectFlowSpecification(CompositeCommand cc, ObjectFlow source, Behavior target, int linkVISUALID, int specificationVISUALID, Point location, Element semanticLink) {
		// look for editpart
		ObjectFlowEditPart sourceEditPart = lookForEdgePart(source);
		// look for editpart linked with the object flow
		GraphicalEditPart targetEditPart = null;
		if(sourceEditPart != null) {
			//TODO check that there is not already a representation linked to the source object flow
		}

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Edge.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y + 100));
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			// creation of the node
			String nodeSemanticHint = ((IHintedType)getUMLElementType(specificationVISUALID)).getSemanticHint();
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, nodeSemanticHint, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100));
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		aLinkCommand.setElement(semanticLink);
		cc.compose(aLinkCommand);
		return cc;

	}

	/**
	 * Look for editPart from its semantic.
	 * 
	 * @param semantic
	 *        the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	private ObjectFlowEditPart lookForEdgePart(EObject semantic) {
		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		ObjectFlowEditPart existedEditPart = null;
		while(editPartIterator.hasNext() && existedEditPart == null) {
			EditPart currentEditPart = editPartIterator.next();
			if(currentEditPart instanceof ObjectFlowEditPart && semantic.equals(((ObjectFlowEditPart)currentEditPart).resolveSemanticElement())) {
				existedEditPart = (ObjectFlowEditPart)currentEditPart;
			}
		}
		return existedEditPart;
	}

	/**
	 * Specific drop action for an activity edge
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param linkVISUALID
	 *        the link visual id
	 * 
	 * @return the command for association
	 */
	protected Command dropActivityEdge(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = ActivityLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = ActivityLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(sources.size() == 1 && targets.size() == 1) {
			ActivityNode source = (ActivityNode)sources.toArray()[0];
			ActivityNode target = (ActivityNode)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Activity Edge"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Avoid selection of label edit parts
	 * 
	 * @see org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#isEditPartTypeSuitableForEClass(java.lang.Class,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	@Override
	protected boolean isEditPartTypeSuitableForEClass(Class<? extends GraphicalEditPart> editPartClass, EClass eClass) {
		// avoid selecting a label instead of the activity node
		return !LabelEditPart.class.isAssignableFrom(editPartClass);
	}

	/**
	 * This action enables to drop an action's local conditions when an action is dropped.
	 * Check of the existing action view is run at execution time to avoid duplication of the action's view.
	 * This action is an intern class since it is narrowly linked with this edit policy properties and operations
	 */
	private class DropActionLocalConditionsAfterActionCommand extends Command {

		/** The drop request */
		private DropObjectsRequest request;

		/** The dropped action */
		private Element droppedAction;

		/** The command which have been executed (known at execution time) */
		private List<Command> executedCommands = new LinkedList<Command>();

		/**
		 * Constructor.
		 * 
		 * @param dropRequest
		 *        the initial request to drop elements
		 * @param action
		 *        the dropped action (whose local conditions must follow)
		 */
		public DropActionLocalConditionsAfterActionCommand(DropObjectsRequest dropRequest, Element action) {
			super(LABEL);
			request = dropRequest;
			droppedAction = action;
		}

		/**
		 * This command can always execute, though it may have no effect
		 * 
		 * @see org.eclipse.gef.commands.Command#canExecute()
		 * @return true
		 */
		@Override
		public boolean canExecute() {
			return true;
		}

		/**
		 * Execute the command and drop each local condition view
		 * 
		 * @see org.eclipse.gef.commands.Command#execute()
		 */
		@Override
		public void execute() {
			// update request to unset the position, so that position is automatically recomputed each time (to avoid superposition).
			Object hostView = getHost().getModel();
			if(hostView instanceof View) {
				if(droppedAction instanceof Action) {
					Point initialLocation = request.getLocation().getCopy();
					for(Constraint pre : ((Action)droppedAction).getLocalPreconditions()) {
						int visual = UMLVisualIDRegistry.getNodeVisualID((View)hostView, pre);
						Command localCmd = dropActionLocalCondition(request, pre, visual);
						if(localCmd != null && localCmd.canExecute()) {
							localCmd.execute();
							executedCommands.add(localCmd);
							// update the request's position to avoid conditions superposition
							request.getLocation().translate(LOCAL_CONDITIONS_TRANSLATION_POINT);
						}
					}
					for(Constraint post : ((Action)droppedAction).getLocalPostconditions()) {
						int visual = UMLVisualIDRegistry.getNodeVisualID((View)hostView, post);
						Command localCmd = dropActionLocalCondition(request, post, visual);
						if(localCmd != null && localCmd.canExecute()) {
							localCmd.execute();
							executedCommands.add(localCmd);
							// update the request's position to avoid conditions superposition
							request.getLocation().translate(LOCAL_CONDITIONS_TRANSLATION_POINT);
						}
					}
					//restore initial location
					request.getLocation().setLocation(initialLocation);
				}
			}
		}

		/**
		 * Undo executed commands
		 * 
		 * @see org.eclipse.gef.commands.Command#undo()
		 */
		@Override
		public void undo() {
			// undo commands in the inverse order
			for(int i = executedCommands.size() - 1; i >= 0; i--) {
				Command cmd = executedCommands.get(i);
				cmd.undo();
			}
			executedCommands.clear();
		}
	}
}
