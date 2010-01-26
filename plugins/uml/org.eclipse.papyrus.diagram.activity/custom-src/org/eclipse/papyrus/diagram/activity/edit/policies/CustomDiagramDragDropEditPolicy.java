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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.helper.ActivityLinkMappingHelper;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ObjectFlow;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** The specific drop node. */
	public int[] secificDropNode = { ConstraintAsLocalPrecondEditPart.VISUAL_ID, ConstraintAsLocalPostcondEditPart.VISUAL_ID, ActivityAsSelectionEditPart.VISUAL_ID, ActivityAsTransformationEditPart.VISUAL_ID, ObjectFlowEditPart.VISUAL_ID, ControlFlowEditPart.VISUAL_ID };

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
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return dropActionLocalCondition(dropRequest, semanticElement, nodeVISUALID);
		case ActivityAsSelectionEditPart.VISUAL_ID:
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return dropObjectFlowBehavior(dropRequest, semanticElement, nodeVISUALID);
		}
		switch(linkVISUALID) {
		case ObjectFlowEditPart.VISUAL_ID:
		case ControlFlowEditPart.VISUAL_ID:
			return dropActivityEdge(dropRequest, semanticElement, linkVISUALID);
		}
		return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
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

				if(ConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVISUALID) {
					return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Local Precondition link"), linkSource, linkTarget, ActionLocalPreconditionEditPart.VISUAL_ID, location, semanticElement));
				} else if(ConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVISUALID) {
					return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Local Postcondition link"), linkSource, linkTarget, ActionLocalPostconditionEditPart.VISUAL_ID, location, semanticElement));
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Specific drop action for an object flow's transformation or selection behavior
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command for behavior
	 */
	protected Command dropObjectFlowBehavior(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {
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
				CompoundCommand globalCmd = new CompoundCommand();
				// inspect the activity for Object Flows specified by the semanticLink behavior
				for(ActivityEdge edge : ((Activity)graphicalParent).getEdges()) {
					if(edge instanceof ObjectFlow) {
						ObjectFlow objectFlow = (ObjectFlow)edge;
						if(semanticElement.equals(objectFlow.getSelection())) {
							// drop the selection behavior and its link to the object flow
							ObjectFlow linkSource = objectFlow;
							Behavior linkTarget = (Behavior)semanticElement;
							// there is no way to distinguish VISUAL_ID of a selection from a transformation, since the element can be both at the same time
							if(ActivityAsSelectionEditPart.VISUAL_ID == nodeVISUALID || ActivityAsTransformationEditPart.VISUAL_ID == nodeVISUALID) {
								ICommandProxy localCmd = new ICommandProxy(dropObjectFlowSpecification(new CompositeCommand("drop Selection link"), linkSource, linkTarget, ObjectFlowSelectionEditPart.VISUAL_ID, ActivityAsSelectionEditPart.VISUAL_ID, location, semanticElement));
								globalCmd.add(localCmd);
							}
						}
						if(semanticElement.equals(objectFlow.getTransformation())) {
							// drop the transformation behavior and its link to the object flow
							ObjectFlow linkSource = objectFlow;
							Behavior linkTarget = (Behavior)semanticElement;
							// there is no way to distinguish VISUAL_ID of a selection from a transformation, since the element can be both at the same time
							if(ActivityAsSelectionEditPart.VISUAL_ID == nodeVISUALID || ActivityAsTransformationEditPart.VISUAL_ID == nodeVISUALID) {
								ICommandProxy localCmd = new ICommandProxy(dropObjectFlowSpecification(new CompositeCommand("drop Transformation link"), linkSource, linkTarget, ObjectFlowTransformationEditPart.VISUAL_ID, ActivityAsTransformationEditPart.VISUAL_ID, location, semanticElement));
								globalCmd.add(localCmd);
							}
						}
					}
				}
				return globalCmd;
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
}
