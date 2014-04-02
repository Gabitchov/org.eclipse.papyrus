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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.figure.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.BlockPropertyCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.figure.ConstraintBlockPropertyCompositeFigure;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintNodeLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintParameterAffixedNodeEditPart;
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
import org.eclipse.papyrus.uml.diagram.common.locator.FullInsidePortPositionLocator;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

public class ConstraintBlockPropertyCompositeEditPart extends AbstractElementEditPart {
	
	public static final String REPRESENTATION_MODE_STYLE = "representation_mode_style"; 
	public static final String ROUNDED_REPRESENTATION = "rounded_representation"; 
	public static final String SQUARE_REPRESENTATION_WITH_STRUCTURE = "square_representation_with_structure";

	public Map<EditPart, FullInsidePortPositionLocator> constraintParameter2FullInsidePortPositionLocator = new HashMap<EditPart, FullInsidePortPositionLocator>();
	
	public static String lastRepresentationKind;
	
	public ConstraintBlockPropertyCompositeEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockPropertyCompositeSemanticEditPolicy());
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
		if(childEditPart instanceof ConstraintNodeLabelEditPart) {
			((ConstraintNodeLabelEditPart)childEditPart).setLabel(((ConstraintBlockPropertyCompositeFigure)getPrimaryShape()).getConstraintLabel());
			return true;
		}

		if(childEditPart instanceof ConstraintParameterAffixedNodeEditPart) {
			FullInsidePortPositionLocator locator = new FullInsidePortPositionLocator(getMainFigure(), PositionConstants.NONE, ((ConstraintBlockPropertyCompositeFigure)getPrimaryShape()).getCorner());
			constraintParameter2FullInsidePortPositionLocator.put(childEditPart, locator); // register the locator in order to reset the corner when changing ConstraintProeprty representation 
			getBorderedFigure().getBorderItemContainer().add(((ConstraintParameterAffixedNodeEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof PropertyNodeLabelEditPart) {
			return true;
		}

		if(childEditPart instanceof ConstraintNodeLabelEditPart) {
			return true;
		}
		if(childEditPart instanceof ConstraintParameterAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ConstraintParameterAffixedNodeEditPart)childEditPart).getFigure());
			return true;
		}

		return false;
	}
	
	@Override
	protected void removeChild(EditPart child) {
		if (child instanceof ConstraintNodeLabelEditPart) {
			return; // When hiding constraint expression, we want to keep the edit part in order to re-show it 
		}
		super.removeChild(child);
	}
	
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}

		return getContentPane();
	}

	@Override
	protected NodeFigure createNodeFigure() {
		return new SelectableBorderedNodeFigure(createMainFigure());
	}

	@Override
	protected IFigure createNodeShape() {
		if (isSquareRepresentationWithStructure()) {
			primaryShape = new ConstraintBlockPropertyCompositeFigure(SQUARE_REPRESENTATION_WITH_STRUCTURE);
		}
		else if (isRoundedRepresentation()) {
			primaryShape = new ConstraintBlockPropertyCompositeFigure(ROUNDED_REPRESENTATION);
		}
		else {
			if (lastRepresentationIsSquareWithStructure()) {
				primaryShape = new ConstraintBlockPropertyCompositeFigure(SQUARE_REPRESENTATION_WITH_STRUCTURE);
			}
			else {
				// default
				if (this.getChildViewBySemanticHint(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID) != null) {
					// no style => if structure then square else rounded
					primaryShape = new ConstraintBlockPropertyCompositeFigure(SQUARE_REPRESENTATION_WITH_STRUCTURE);
				}
				else {
					primaryShape = new ConstraintBlockPropertyCompositeFigure(ROUNDED_REPRESENTATION);					
				}
			}
		}
		return primaryShape;
	}

	@Override
	public ConstraintBlockPropertyCompositeFigure getPrimaryShape() {
		return (ConstraintBlockPropertyCompositeFigure)primaryShape;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		List children = getChildren();
		for (Object editPart : children) {
			if (editPart instanceof EditPart) {
				((EditPart) editPart).refresh();
			}
		}
	}
	
	public boolean isSquareRepresentationWithStructure() {
		StringValueStyle style = (StringValueStyle)((View)this.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		if (style == null) {
			return false;
		}
		return SQUARE_REPRESENTATION_WITH_STRUCTURE.equals(style.getStringValue());
	}
	
	public boolean isRoundedRepresentation() {
		StringValueStyle style = (StringValueStyle)((View)this.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		if (style == null) {
			return false;
		}
		return ROUNDED_REPRESENTATION.equals(style.getStringValue());
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
		refresh();
	}

	public static boolean lastRepresentationIsSquareWithStructure() {
		return ConstraintBlockPropertyCompositeEditPart.SQUARE_REPRESENTATION_WITH_STRUCTURE.equals(ConstraintBlockPropertyCompositeEditPart.lastRepresentationKind);
	}

	public static void setLastRepresentation(String representationKind) {
		ConstraintBlockPropertyCompositeEditPart.lastRepresentationKind = representationKind;
	}
	
	public void setCornerLocators(int corner) {
		for (EditPart editPart : constraintParameter2FullInsidePortPositionLocator.keySet()) {
			FullInsidePortPositionLocator locator = constraintParameter2FullInsidePortPositionLocator.get(editPart);
			locator.setCorner(corner);
		}
	}

}
