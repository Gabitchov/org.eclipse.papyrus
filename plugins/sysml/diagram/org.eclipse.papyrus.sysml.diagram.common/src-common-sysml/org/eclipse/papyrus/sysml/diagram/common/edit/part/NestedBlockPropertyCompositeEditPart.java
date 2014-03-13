/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.figure.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.NestedBlockPropertyCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.figure.NestedBlockPropertyCompositeFigure;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PropertyNodeLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.policy.EncapsulatedClassifierResizableShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.policy.StructuredClassifierCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Edit part for nested Block property shown as composite.
 */
@Deprecated
public class NestedBlockPropertyCompositeEditPart extends AbstractElementEditPart {

	public NestedBlockPropertyCompositeEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new NestedBlockPropertyCompositeSemanticEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideRelatedContentsEditPolicy.SHOW_HIDE_RELATED_CONTENTS_POLICY, new ShowHideRelatedContentsEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AffixedNodeAlignmentEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new StructuredClassifierCreationEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new EncapsulatedClassifierResizableShapeEditPolicy());
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				if(child instanceof IBorderItemEditPart) {
					return new BorderItemResizableEditPolicy();
				}

				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	@Override
	protected boolean addFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof PropertyNodeLabelEditPart) {
			((PropertyNodeLabelEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}

		if(childEditPart instanceof FlowPortAffixedNodeEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((FlowPortAffixedNodeEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		if(childEditPart instanceof PortAffixedNodeEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PortAffixedNodeEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof PropertyNodeLabelEditPart) {
			return true;
		}

		if(childEditPart instanceof FlowPortAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((FlowPortAffixedNodeEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof PortAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PortAffixedNodeEditPart)childEditPart).getFigure());
			return true;
		}

		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}

		return getContentPane();
	}

	//	public EditPart getTargetEditPart(Request request) {
	//		if(request instanceof CreateViewAndElementRequest) {
	//			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
	//			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
	//			if(type == CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN) {
	//				return getChildBySemanticHint(CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT);
	//			}
	//		}
	//		return super.getTargetEditPart(request);
	//	}

	@Override
	protected NodeFigure createNodeFigure() {
		return new SelectableBorderedNodeFigure(createMainFigure());
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new NestedBlockPropertyCompositeFigure();
	}

	@Override
	public NestedBlockPropertyCompositeFigure getPrimaryShape() {
		return (NestedBlockPropertyCompositeFigure)primaryShape;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID);
	}

	/**
	 * <pre>
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		// A visual refresh may also be needed when the following properties are changing : aggregation, type, or the related association.
		if(resolveSemanticElement() != null) {
			EObject element = resolveSemanticElement();

			if((element != null) && (element.equals(event.getNotifier())) && (element instanceof Property)) {

				if(UMLPackage.eINSTANCE.getProperty_Aggregation().equals(event.getFeature())) {
					refreshVisuals();
				}

				if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(event.getFeature())) {
					refreshVisuals();
				}

				if(UMLPackage.eINSTANCE.getProperty_Association().equals(event.getFeature())) {
					refreshVisuals();
				}
			}
		}

		super.handleNotificationEvent(event);
	}

	/**
	 * <pre>
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		String tag = "property";
		int lineStyle = Graphics.LINE_SOLID;

		if(resolveSemanticElement() != null) {
			EObject eObject = resolveSemanticElement();
			if(((ISpecializationType)SysMLElementTypes.PART_PROPERTY).getMatcher().matches(eObject)) {
				tag = "part";

			} else if(((ISpecializationType)SysMLElementTypes.REFERENCE_PROPERTY).getMatcher().matches(eObject)) {
				tag = "reference";
				lineStyle = Graphics.LINE_CUSTOM;

			} else if(((ISpecializationType)SysMLElementTypes.ACTOR_PART_PROPERTY).getMatcher().matches(eObject)) {
				tag = "actor part";

			} else if(((ISpecializationType)SysMLElementTypes.VALUE_PROPERTY).getMatcher().matches(eObject)) {
				tag = "value";

			} else {
				// Consider the element is a Property...
			}
		}

		getPrimaryShape().setFigureTag(tag);
		getPrimaryShape().setLineStyle(lineStyle);
	}
}
