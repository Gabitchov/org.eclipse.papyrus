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
package org.eclipse.papyrus.uml.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.activity.draw2d.CenteredColumnConstraint;
import org.eclipse.papyrus.uml.diagram.activity.draw2d.CenteredColumnLayout;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.AcceptEventActionCanonicalEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.AcceptEventActionItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CreateActionLocalConditionEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.DeleteActionViewEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.ObjectFlowWithPinsCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * @generated NOT implements IPapyrusEditPart
 */
public class AcceptEventActionEditPart extends AbstractBorderedShapeEditPart implements IPapyrusEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3063;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * the external stereotype label edit part for Accept Time Event Action
	 * 
	 * @generated NOT
	 */
	private IBorderItemEditPart extStereotypePart = null;

	/**
	 * @generated
	 */
	public AcceptEventActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new PapyrusCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AcceptEventActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.activity.edit.policies.AcceptEventActionCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ObjectFlowWithPinsCreationEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new AcceptEventActionCanonicalEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * Papyrus codeGen
	 * 
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		/*
		 * when a node have external node labels, the methods refreshChildren() remove the EditPart corresponding to the Label from the EditPart
		 * Registry. After that, we can't reset the visibility to true (using the Show/Hide Label Action)!
		 */
		if(NotationPackage.eINSTANCE.getView_Visible().equals(event.getFeature())) {
			Object notifier = event.getNotifier();
			List<?> modelChildren = ((View)getModel()).getChildren();
			if(!(notifier instanceof Edge)) {
				if(modelChildren.contains(event.getNotifier())) {
					return;
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case AcceptTimeEventActionLabelEditPart.VISUAL_ID:
				case AcceptTimeEventActionAppliedStereotypeEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
					return new BorderItemResizableEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new AcceptEventActionFigure();
	}

	/**
	 * @generated
	 */
	public AcceptEventActionFigure getPrimaryShape() {
		return (AcceptEventActionFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof AcceptEventActionLabelEditPart) {
			((AcceptEventActionLabelEditPart)childEditPart).setLabel(getPrimaryShape().getAcceptEventActionLabel());
			return true;
		}
		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((OutputPinInAcceptEventActionEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof AcceptEventActionLabelEditPart) {
			return true;
		}
		if(childEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutputPinInAcceptEventActionEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	protected void restoreExternalStereotypeLabel() {
		if(extStereotypePart != null) {
			addBorderItem(getMainFigure(), extStereotypePart);
		}
	}

	protected void removeExternalStereotypeLabel() {
		if(extStereotypePart != null) {
			getMainFigure().remove(extStereotypePart.getFigure());
		}
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof AcceptTimeEventActionLabelEditPart || borderItemEditPart instanceof AcceptTimeEventActionAppliedStereotypeEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "AcceptEventAction";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(AcceptEventActionLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsBodyOutputEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsLoopVariableEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsResultEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInLoopNodeAsVariableEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ReadSelfActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ReadSelfActionOutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCreateObjectActionAsResultEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ReadStructuralFeatureActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInReadStructuralFeatureAsObjectEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInReadStructuralFeatureAsResultEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DestroyObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInDestroyObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ReadVariableActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInReadVariableActionAsResultEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof AddVariableValueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsInsertAtEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof BroadcastSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInBroadcastSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsBodyOutputEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsLoopVariableEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsResultEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInLoopNodeAsVariableEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ReadSelfActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ReadSelfActionOutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCreateObjectActionAsResultEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ReadStructuralFeatureActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInReadStructuralFeatureAsObjectEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInReadStructuralFeatureAsResultEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DestroyObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInDestroyObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ReadVariableActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInReadVariableActionAsResultEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof AddVariableValueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsInsertAtEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof BroadcastSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInBroadcastSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsBodyOutputEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsLoopVariableEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInLoopNodeAsResultEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInLoopNodeAsVariableEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ReadSelfActionOutputPinEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInCreateObjectActionAsResultEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInReadStructuralFeatureAsObjectEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInReadStructuralFeatureAsResultEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInDestroyObjectActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInReadVariableActionAsResultEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsInsertAtEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInAddVariableValueActionAsValueEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof InputPinInBroadcastSignalActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.DurationConstraint_3034);
			types.add(UMLElementTypes.DurationConstraint_3035);
			types.add(UMLElementTypes.TimeConstraint_3036);
			types.add(UMLElementTypes.TimeConstraint_3037);
			types.add(UMLElementTypes.IntervalConstraint_3032);
			types.add(UMLElementTypes.IntervalConstraint_3033);
			types.add(UMLElementTypes.Constraint_3011);
			types.add(UMLElementTypes.Constraint_3012);
			types.add(UMLElementTypes.Constraint_3112);
		} else if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.DurationConstraint_3034);
			types.add(UMLElementTypes.DurationConstraint_3035);
			types.add(UMLElementTypes.TimeConstraint_3036);
			types.add(UMLElementTypes.TimeConstraint_3037);
			types.add(UMLElementTypes.IntervalConstraint_3032);
			types.add(UMLElementTypes.IntervalConstraint_3033);
			types.add(UMLElementTypes.Constraint_3011);
			types.add(UMLElementTypes.Constraint_3012);
			types.add(UMLElementTypes.Constraint_3112);
		} else if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
			types.add(UMLElementTypes.ActivityFinalNode_3005);
			types.add(UMLElementTypes.FlowFinalNode_3006);
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			types.add(UMLElementTypes.CallOperationAction_3010);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			types.add(UMLElementTypes.DecisionNode_3038);
			types.add(UMLElementTypes.MergeNode_3039);
			types.add(UMLElementTypes.ForkNode_3040);
			types.add(UMLElementTypes.JoinNode_3041);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			types.add(UMLElementTypes.OutputPin_3064);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.OutputPin_3109);
			types.add(UMLElementTypes.OutputPin_3110);
			types.add(UMLElementTypes.OutputPin_3111);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InputPin_3105);
			types.add(UMLElementTypes.ReadSelfAction_3081);
			types.add(UMLElementTypes.OutputPin_3084);
			types.add(UMLElementTypes.CreateObjectAction_3086);
			types.add(UMLElementTypes.OutputPin_3087);
			types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
			types.add(UMLElementTypes.InputPin_3089);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
			types.add(UMLElementTypes.InputPin_3092);
			types.add(UMLElementTypes.InputPin_3093);
			types.add(UMLElementTypes.OutputPin_3094);
			types.add(UMLElementTypes.DestroyObjectAction_3095);
			types.add(UMLElementTypes.InputPin_3096);
			types.add(UMLElementTypes.ReadVariableAction_3097);
			types.add(UMLElementTypes.OutputPin_3098);
			types.add(UMLElementTypes.AddVariableValueAction_3099);
			types.add(UMLElementTypes.InputPin_3100);
			types.add(UMLElementTypes.InputPin_3101);
			types.add(UMLElementTypes.BroadcastSignalAction_3102);
			types.add(UMLElementTypes.InputPin_3103);
			types.add(UMLElementTypes.CentralBufferNode_3104);
		} else if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
			types.add(UMLElementTypes.ActivityFinalNode_3005);
			types.add(UMLElementTypes.FlowFinalNode_3006);
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			types.add(UMLElementTypes.CallOperationAction_3010);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			types.add(UMLElementTypes.DecisionNode_3038);
			types.add(UMLElementTypes.MergeNode_3039);
			types.add(UMLElementTypes.ForkNode_3040);
			types.add(UMLElementTypes.JoinNode_3041);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			types.add(UMLElementTypes.OutputPin_3064);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.OutputPin_3109);
			types.add(UMLElementTypes.OutputPin_3110);
			types.add(UMLElementTypes.OutputPin_3111);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InputPin_3105);
			types.add(UMLElementTypes.ReadSelfAction_3081);
			types.add(UMLElementTypes.OutputPin_3084);
			types.add(UMLElementTypes.CreateObjectAction_3086);
			types.add(UMLElementTypes.OutputPin_3087);
			types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
			types.add(UMLElementTypes.InputPin_3089);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
			types.add(UMLElementTypes.InputPin_3092);
			types.add(UMLElementTypes.InputPin_3093);
			types.add(UMLElementTypes.OutputPin_3094);
			types.add(UMLElementTypes.DestroyObjectAction_3095);
			types.add(UMLElementTypes.InputPin_3096);
			types.add(UMLElementTypes.ReadVariableAction_3097);
			types.add(UMLElementTypes.OutputPin_3098);
			types.add(UMLElementTypes.AddVariableValueAction_3099);
			types.add(UMLElementTypes.InputPin_3100);
			types.add(UMLElementTypes.InputPin_3101);
			types.add(UMLElementTypes.BroadcastSignalAction_3102);
			types.add(UMLElementTypes.InputPin_3103);
			types.add(UMLElementTypes.CentralBufferNode_3104);
		} else if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.OutputPin_3064);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.OutputPin_3109);
			types.add(UMLElementTypes.OutputPin_3110);
			types.add(UMLElementTypes.OutputPin_3111);
			types.add(UMLElementTypes.InputPin_3105);
			types.add(UMLElementTypes.OutputPin_3084);
			types.add(UMLElementTypes.OutputPin_3087);
			types.add(UMLElementTypes.InputPin_3089);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.InputPin_3092);
			types.add(UMLElementTypes.InputPin_3093);
			types.add(UMLElementTypes.OutputPin_3094);
			types.add(UMLElementTypes.InputPin_3096);
			types.add(UMLElementTypes.OutputPin_3098);
			types.add(UMLElementTypes.InputPin_3100);
			types.add(UMLElementTypes.InputPin_3101);
			types.add(UMLElementTypes.InputPin_3103);
			types.add(UMLElementTypes.CentralBufferNode_3104);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4007);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
			types.add(UMLElementTypes.ActivityFinalNode_3005);
			types.add(UMLElementTypes.FlowFinalNode_3006);
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			types.add(UMLElementTypes.CallOperationAction_3010);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			types.add(UMLElementTypes.DecisionNode_3038);
			types.add(UMLElementTypes.MergeNode_3039);
			types.add(UMLElementTypes.ForkNode_3040);
			types.add(UMLElementTypes.JoinNode_3041);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			types.add(UMLElementTypes.OutputPin_3064);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.OutputPin_3109);
			types.add(UMLElementTypes.OutputPin_3110);
			types.add(UMLElementTypes.OutputPin_3111);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InputPin_3105);
			types.add(UMLElementTypes.ReadSelfAction_3081);
			types.add(UMLElementTypes.OutputPin_3084);
			types.add(UMLElementTypes.CreateObjectAction_3086);
			types.add(UMLElementTypes.OutputPin_3087);
			types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
			types.add(UMLElementTypes.InputPin_3089);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
			types.add(UMLElementTypes.InputPin_3092);
			types.add(UMLElementTypes.InputPin_3093);
			types.add(UMLElementTypes.OutputPin_3094);
			types.add(UMLElementTypes.DestroyObjectAction_3095);
			types.add(UMLElementTypes.InputPin_3096);
			types.add(UMLElementTypes.ReadVariableAction_3097);
			types.add(UMLElementTypes.OutputPin_3098);
			types.add(UMLElementTypes.AddVariableValueAction_3099);
			types.add(UMLElementTypes.InputPin_3100);
			types.add(UMLElementTypes.InputPin_3101);
			types.add(UMLElementTypes.BroadcastSignalAction_3102);
			types.add(UMLElementTypes.InputPin_3103);
			types.add(UMLElementTypes.CentralBufferNode_3104);
		} else if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
			types.add(UMLElementTypes.ActivityFinalNode_3005);
			types.add(UMLElementTypes.FlowFinalNode_3006);
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.ValuePin_3015);
			types.add(UMLElementTypes.ActionInputPin_3016);
			types.add(UMLElementTypes.InputPin_3013);
			types.add(UMLElementTypes.OutputPin_3014);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.ValuePin_3017);
			types.add(UMLElementTypes.ActionInputPin_3018);
			types.add(UMLElementTypes.InputPin_3019);
			types.add(UMLElementTypes.OutputPin_3020);
			types.add(UMLElementTypes.CallOperationAction_3010);
			types.add(UMLElementTypes.ActionInputPin_3021);
			types.add(UMLElementTypes.ValuePin_3022);
			types.add(UMLElementTypes.InputPin_3023);
			types.add(UMLElementTypes.OutputPin_3024);
			types.add(UMLElementTypes.ValuePin_3025);
			types.add(UMLElementTypes.ActionInputPin_3026);
			types.add(UMLElementTypes.InputPin_3027);
			types.add(UMLElementTypes.DecisionNode_3038);
			types.add(UMLElementTypes.MergeNode_3039);
			types.add(UMLElementTypes.ForkNode_3040);
			types.add(UMLElementTypes.JoinNode_3041);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.ValuePin_3046);
			types.add(UMLElementTypes.ActionInputPin_3047);
			types.add(UMLElementTypes.InputPin_3048);
			types.add(UMLElementTypes.ValuePin_3049);
			types.add(UMLElementTypes.ActionInputPin_3050);
			types.add(UMLElementTypes.InputPin_3051);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.ActionInputPin_3053);
			types.add(UMLElementTypes.ValuePin_3054);
			types.add(UMLElementTypes.InputPin_3055);
			types.add(UMLElementTypes.ValuePin_3060);
			types.add(UMLElementTypes.ActionInputPin_3061);
			types.add(UMLElementTypes.InputPin_3062);
			types.add(UMLElementTypes.ActivityParameterNode_3059);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			types.add(UMLElementTypes.OutputPin_3064);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.OutputPin_3109);
			types.add(UMLElementTypes.OutputPin_3110);
			types.add(UMLElementTypes.OutputPin_3111);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InputPin_3105);
			types.add(UMLElementTypes.ReadSelfAction_3081);
			types.add(UMLElementTypes.OutputPin_3084);
			types.add(UMLElementTypes.CreateObjectAction_3086);
			types.add(UMLElementTypes.OutputPin_3087);
			types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
			types.add(UMLElementTypes.InputPin_3089);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
			types.add(UMLElementTypes.InputPin_3092);
			types.add(UMLElementTypes.InputPin_3093);
			types.add(UMLElementTypes.OutputPin_3094);
			types.add(UMLElementTypes.DestroyObjectAction_3095);
			types.add(UMLElementTypes.InputPin_3096);
			types.add(UMLElementTypes.ReadVariableAction_3097);
			types.add(UMLElementTypes.OutputPin_3098);
			types.add(UMLElementTypes.AddVariableValueAction_3099);
			types.add(UMLElementTypes.InputPin_3100);
			types.add(UMLElementTypes.InputPin_3101);
			types.add(UMLElementTypes.BroadcastSignalAction_3102);
			types.add(UMLElementTypes.InputPin_3103);
			types.add(UMLElementTypes.CentralBufferNode_3104);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4006) {
			types.add(UMLElementTypes.Comment_3080);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4007) {
			types.add(UMLElementTypes.DurationConstraint_3034);
			types.add(UMLElementTypes.DurationConstraint_3035);
			types.add(UMLElementTypes.TimeConstraint_3036);
			types.add(UMLElementTypes.TimeConstraint_3037);
			types.add(UMLElementTypes.IntervalConstraint_3032);
			types.add(UMLElementTypes.IntervalConstraint_3033);
			types.add(UMLElementTypes.Constraint_3011);
			types.add(UMLElementTypes.Constraint_3012);
			types.add(UMLElementTypes.Constraint_3112);
		}
		return types;
	}

	/**
	 * @generated NOT implements IPapyrusNodeUMLElementFigure
	 */
	public class AcceptEventActionFigure extends ScalablePolygonShape implements IPapyrusNodeUMLElementFigure {

		/**
		 * @generated
		 */
		private CenteredWrappedLabel fAcceptEventActionLabel;

		/**
		 * @generated NOT
		 */
		private final Insets marginTemplate;

		/** The helper which handles stereotype aspects */
		private StereotypeFigureHelper stereotypeHelper;

		/**
		 * @generated NOT add time template, make margin border relative, use StereotypeFigureHelper
		 */
		public AcceptEventActionFigure() {
			CenteredColumnLayout layoutThis = new CenteredColumnLayout();
			this.setLayoutManager(layoutThis);
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(200), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(200), getMapMode().DPtoLP(50)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(50)));
			this.addPoint(new Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(25)));
			// add time template
			this.addTimePoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			this.addTimePoint(new Point(getMapMode().DPtoLP(100), getMapMode().DPtoLP(0)));
			this.addTimePoint(new Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(25)));
			this.addTimePoint(new Point(getMapMode().DPtoLP(100), getMapMode().DPtoLP(50)));
			this.addTimePoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(50)));
			this.addTimePoint(new Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(25)));
			this.setFill(true);
			this.setLineWidth(1);
			// make margin border relative
			marginTemplate = new Insets(getMapMode().DPtoLP(0), getMapMode().DPtoLP(50), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			this.setBorder(new MarginBorder(marginTemplate));
			createContents();
			// use StereotypeFigureHelper
			stereotypeHelper = new StereotypeFigureHelper(this) {

				@Override
				public IMapMode getMapMode() {
					return AcceptEventActionEditPart.this.getMapMode();
				}

				@Override
				public Object getStereotypeRectangleConstraint() {
					CenteredColumnConstraint constraintStereotypeRect0 = new CenteredColumnConstraint(false);
					return constraintStereotypeRect0;
				}
			};
		}

		/**
		 * @generated NOT use CenteredColumnConstraint
		 */
		private void createContents() {
			RectangleFigure labelRect0 = new RectangleFigure();
			labelRect0.setFill(false);
			labelRect0.setOutline(false);
			labelRect0.setLineWidth(1);
			// use CenteredColumnConstraint
			CenteredColumnConstraint constraintLabelRect0 = new CenteredColumnConstraint(true);
			this.add(labelRect0, constraintLabelRect0);
			CenterLayout layoutLabelRect0 = new CenterLayout();
			labelRect0.setLayoutManager(layoutLabelRect0);
			fAcceptEventActionLabel = new CenteredWrappedLabel();
			fAcceptEventActionLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));
			labelRect0.add(fAcceptEventActionLabel);
		}

		/**
		 * @generated NOT
		 */
		private final PointList myTemplate = new PointList();

		/**
		 * @generated NOT
		 */
		private Rectangle myTemplateBounds;

		/**
		 * @generated NOT
		 */
		public void addPoint(Point point) {
			myTemplate.addPoint(point);
			myTemplateBounds = null;
		}

		/**
		 * Refresh the layout of the figure
		 */
		protected void refreshLayout() {
		}

		/** The value to display as stereotype display when available */
		String stereotypeDisplayText = null;

		/** The value to display as stereotype display when available */
		Image stereotypeDisplayImg = null;

		/**
		 * Sets the stereotypes for this figure.
		 * 
		 * @param stereotypes
		 *        the string representing the stereotypes to be displayed
		 * @param image
		 *        the image representing the stereotypes to be displayed
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
		 *      org.eclipse.swt.graphics.Image)
		 */
		public void setStereotypeDisplay(String stereotypes, Image image) {
			if(!isTemplateForAcceptTimeEventActionUsed()) {
				stereotypeHelper.setStereotypeDisplay(stereotypes, image);
				refreshLayout();
			}
			// record values in case figure changes
			stereotypeDisplayText = stereotypes;
			stereotypeDisplayImg = image;
		}

		/** The value to display as stereotype in brace when available */
		String stereotypePropertiesInBrace = null;

		/**
		 * Sets the stereotypes properties for this figure.
		 * 
		 * @param stereotypeProperties
		 *        the string representing the stereotype properties to be displayed
		 */
		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			if(!isTemplateForAcceptTimeEventActionUsed()) {
				stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
				refreshLayout();
			}
			// record values in case figure changes
			stereotypePropertiesInBrace = stereotypeProperties;
		}

		/** The value to display as stereotype in brace when available */
		String stereotypePropertiesInCompartment = null;

		/**
		 * displays the new string corresponding to the list of stereotypes.
		 * 
		 * @param stereotypeProperties
		 *        the string to be displayed.
		 */
		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
			if(!isTemplateForAcceptTimeEventActionUsed()) {
				stereotypeHelper.setStereotypePropertiesInCompartment(stereotypeProperties);
				refreshLayout();
			}
			// record values in case figure changes
			stereotypePropertiesInCompartment = stereotypeProperties;
		}

		/**
		 * Gets the stereotype label.
		 * 
		 * @return the stereotype label
		 * @unused
		 * @deprecated
		 */
		public Label getStereotypesLabel() {
			return null;//fActionStereotypeLabel;
		}

		/**
		 * @generated NOT
		 */
		private final PointList myTemplateTime = new PointList();

		/**
		 * @generated NOT
		 */
		private boolean useTemplateTime = false;

		/**
		 * Set whether the figure must use the classic concave pentagon template for AcceptEventAction or the hourglass template for
		 * AcceptTimeEventAction
		 * 
		 * @param useAcceptTimeEventActionTemplate
		 *        true if the hourglass template must be used, false for default template
		 * @generated NOT
		 */
		public void useTemplateForAcceptTimeEventAction(boolean useAcceptTimeEventActionTemplate) {
			if(useAcceptTimeEventActionTemplate) {
				// erase stereotypes representation in block
				stereotypeHelper.setStereotypeDisplay(null, null);
				stereotypeHelper.setStereotypePropertiesInBrace(null);
				stereotypeHelper.setStereotypePropertiesInCompartment(null);
				// restore external label
				AcceptEventActionEditPart.this.restoreExternalStereotypeLabel();
			} else {
				// restore stereotypes representation in block
				stereotypeHelper.setStereotypeDisplay(stereotypeDisplayText, stereotypeDisplayImg);
				stereotypeHelper.setStereotypePropertiesInBrace(stereotypePropertiesInBrace);
				stereotypeHelper.setStereotypePropertiesInCompartment(stereotypePropertiesInCompartment);
				// erase external label
				AcceptEventActionEditPart.this.removeExternalStereotypeLabel();
			}
			useTemplateTime = useAcceptTimeEventActionTemplate;
		}

		/**
		 * Ask whether the figure uses the classic concave pentagon template for AcceptEventAction or the hourglass template for
		 * AcceptTimeEventAction
		 * 
		 * @return true if the hourglass template is used, false for default template
		 * @generated NOT
		 */
		public boolean isTemplateForAcceptTimeEventActionUsed() {
			return useTemplateTime;
		}

		/**
		 * @generated NOT
		 */
		private Rectangle myTemplateTimeBounds;

		/**
		 * @generated NOT
		 */
		public void addTimePoint(Point point) {
			myTemplateTime.addPoint(point);
			myTemplateTimeBounds = null;
		}

		/**
		 * @generated NOT refresh relative margin
		 */
		protected void fillShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.fillPolygon(scalePointList());
			graphics.popState();
			// refresh relative margin
			this.setBorder(new MarginBorder(scaleMargin()));
		}

		/**
		 * @generated NOT
		 */
		protected void outlineShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.drawPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated NOT
		 */
		private Insets scaleMargin() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();
			float xScale = ((float)actualBounds.width) / pointsBounds.width;
			float yScale = ((float)actualBounds.height) / pointsBounds.height;
			if(xScale == 1 && yScale == 1) {
				return marginTemplate;
			}
			Insets scaled = new Insets(marginTemplate);
			scaled.top = (int)Math.floor(scaled.top * yScale);
			scaled.left = (int)Math.floor(scaled.left * xScale);
			scaled.bottom = (int)Math.floor(scaled.bottom * yScale);
			scaled.right = (int)Math.floor(scaled.right * xScale);
			return scaled;
		}

		/**
		 * @generated NOT switch between the two templates
		 */
		private Rectangle getTemplateBounds() {
			if(myTemplateBounds == null) {
				myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
				//just safety -- we are going to use this as divider 
				if(myTemplateBounds.width < 1) {
					myTemplateBounds.width = 1;
				}
				if(myTemplateBounds.height < 1) {
					myTemplateBounds.height = 1;
				}
			}
			// switch between the two templates : create the second template bounds
			if(myTemplateTimeBounds == null) {
				myTemplateTimeBounds = myTemplateTime.getBounds().getCopy().union(0, 0);
				//just safety -- we are going to use this as divider 
				if(myTemplateTimeBounds.width < 1) {
					myTemplateTimeBounds.width = 1;
				}
				if(myTemplateTimeBounds.height < 1) {
					myTemplateTimeBounds.height = 1;
				}
			}
			// switch between the two templates : choose appropriate one
			if(useTemplateTime) {
				return myTemplateTimeBounds;
			} else {
				return myTemplateBounds;
			}
		}

		/**
		 * @generated NOT switch between the two templates
		 */
		private int[] scalePointList() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();
			float xScale = ((float)actualBounds.width) / pointsBounds.width;
			float yScale = ((float)actualBounds.height) / pointsBounds.height;
			if(xScale == 1 && yScale == 1) {
				// switch between the two templates
				if(useTemplateTime) {
					return myTemplateTime.toIntArray();
				} else {
					return myTemplate.toIntArray();
				}
			}
			// switch between the two templates
			int[] scaled;
			if(useTemplateTime) {
				scaled = (int[])myTemplateTime.toIntArray().clone();
			} else {
				scaled = (int[])myTemplate.toIntArray().clone();
			}
			for(int i = 0; i < scaled.length; i += 2) {
				scaled[i] = (int)Math.floor(scaled[i] * xScale);
				scaled[i + 1] = (int)Math.floor(scaled[i + 1] * yScale);
			}
			return scaled;
		}

		/**
		 * @generated
		 */
		public CenteredWrappedLabel getAcceptEventActionLabel() {
			return fAcceptEventActionLabel;
		}
	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;
		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("AcceptEventAction", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("AcceptEventAction", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("AcceptEventAction", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("AcceptEventAction", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}
		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
