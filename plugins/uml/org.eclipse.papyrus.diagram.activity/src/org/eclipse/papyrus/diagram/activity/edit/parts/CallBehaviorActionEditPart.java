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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.CallBehaviorActionCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.CallBehaviorActionItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.CreateActionLocalConditionEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.DeleteActionViewEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.figures.AbstractActionFigure;
import org.eclipse.papyrus.diagram.activity.helper.ActivityFigureDrawer;
import org.eclipse.papyrus.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.common.editparts.IPapyrusEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT implements IPapyrusEditPart
 */
public class CallBehaviorActionEditPart extends

AbstractBorderedShapeEditPart implements IPapyrusEditPart {


	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3008;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public CallBehaviorActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CallBehaviorActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());


		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.activity.edit.policies.CallBehaviorActionCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CallBehaviorActionCanonicalEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * Papyrus codeGen
	 * 
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		//Add/Remove the RakeFigure when an Activity is selected as behavior or deselected
		if(resolveSemanticElement() != null) {
			if(resolveSemanticElement() instanceof CallBehaviorAction && resolveSemanticElement().equals(event.getNotifier()) && event.getFeature().equals(UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior())) {
				CallBehaviorAction action = (CallBehaviorAction)resolveSemanticElement();
				AbstractPointListShape rake = getPrimaryShape().getOptionalRakeFigure();
				if(action.getBehavior() instanceof Activity) {
					Dimension size = ActivityFigureDrawer.getNodeSize(this, null);
					ActivityFigureDrawer.redrawRake(rake, getMapMode(), size);
				} else {
					ActivityFigureDrawer.undrawFigure(rake);
				};
				refreshVisuals();
			}
		}

		//Refresh the RakeFigure if an Activity is selected as behavior when figure is resized
		if(resolveSemanticElement() != null) {
			if(event.getNotifier() instanceof Bounds && resolveSemanticElement() instanceof CallBehaviorAction) {
				CallBehaviorAction action = (CallBehaviorAction)resolveSemanticElement();
				AbstractPointListShape rake = getPrimaryShape().getOptionalRakeFigure();
				if(action.getBehavior() instanceof Activity) {
					Dimension size = ActivityFigureDrawer.getNodeSize(this, event);
					ActivityFigureDrawer.redrawRake(rake, getMapMode(), size);
				};
				refreshVisuals();
			}
		}
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case ValuePinInCallBeActEditPart.VISUAL_ID:
				case ActionInputPinInCallBeActEditPart.VISUAL_ID:
				case InputPinInCallBeActEditPart.VISUAL_ID:
				case OutputPinInCallBeActEditPart.VISUAL_ID:

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
		return primaryShape = new ActionFigureDescriptor();
	}

	/**
	 * @generated
	 */
	public ActionFigureDescriptor getPrimaryShape() {
		return (ActionFigureDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CallBehaviorActionNameEditPart) {
			((CallBehaviorActionNameEditPart)childEditPart).setLabel(getPrimaryShape().getActionLabel());
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ValuePinInCallBeActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInCallBeActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ActionInputPinInCallBeActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ActionInputPinInCallBeActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof InputPinInCallBeActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInCallBeActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof OutputPinInCallBeActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((OutputPinInCallBeActEditPart)childEditPart).getFigure(), locator);
			return true;
		}




		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CallBehaviorActionNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ValuePinInCallBeActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInCallBeActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActionInputPinInCallBeActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionInputPinInCallBeActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof InputPinInCallBeActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInCallBeActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof OutputPinInCallBeActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutputPinInCallBeActEditPart)childEditPart).getFigure());
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

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "CallBehaviorAction";
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
	 * Refresh the children parts, including the rake if necessary
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshChildren()
	 * @generated NOT
	 */
	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		// add the rake if behavior is an activity
		if(resolveSemanticElement() instanceof CallBehaviorAction) {
			CallBehaviorAction action = (CallBehaviorAction)resolveSemanticElement();
			AbstractPointListShape rake = getPrimaryShape().getOptionalRakeFigure();
			if(action.getBehavior() instanceof Activity) {
				Dimension size = ActivityFigureDrawer.getNodeSize(this, null);
				ActivityFigureDrawer.redrawRake(rake, getMapMode(), size);
			};
		}
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
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
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
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
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart) {
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
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
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
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InitialNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityFinalNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof FlowFinalNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OpaqueActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallBehaviorActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallOperationActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendObjectActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof SendSignalActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof AcceptEventActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValueSpecificationActionInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DecisionNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof MergeNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ForkNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof JoinNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DataStoreNodeInIAREditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart) {
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
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
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
		if(targetEditPart instanceof SequenceNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InitialNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityFinalNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof FlowFinalNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OpaqueActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallBehaviorActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallOperationActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendObjectActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof SendSignalActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof AcceptEventActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValueSpecificationActionInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DecisionNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof MergeNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ForkNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof JoinNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DataStoreNodeInIAREditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
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
		if(targetEditPart instanceof ExpansionNodeAsInEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof ExpansionNodeAsOutEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof OutputPinInValSpecActEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof DataStoreNodeInIAREditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if(targetEditPart instanceof DataStoreNodeEditPart) {
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
			types.add(UMLElementTypes.InteractionConstraint_3030);
			types.add(UMLElementTypes.InteractionConstraint_3031);
			types.add(UMLElementTypes.IntervalConstraint_3032);
			types.add(UMLElementTypes.IntervalConstraint_3033);
			types.add(UMLElementTypes.Constraint_3011);
			types.add(UMLElementTypes.Constraint_3012);
		} else if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.DurationConstraint_3034);
			types.add(UMLElementTypes.DurationConstraint_3035);
			types.add(UMLElementTypes.TimeConstraint_3036);
			types.add(UMLElementTypes.TimeConstraint_3037);
			types.add(UMLElementTypes.InteractionConstraint_3030);
			types.add(UMLElementTypes.InteractionConstraint_3031);
			types.add(UMLElementTypes.IntervalConstraint_3032);
			types.add(UMLElementTypes.IntervalConstraint_3033);
			types.add(UMLElementTypes.Constraint_3011);
			types.add(UMLElementTypes.Constraint_3012);
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
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InitialNode_3079);
			types.add(UMLElementTypes.ActivityFinalNode_3080);
			types.add(UMLElementTypes.FlowFinalNode_3081);
			types.add(UMLElementTypes.OpaqueAction_3082);
			types.add(UMLElementTypes.CallBehaviorAction_3083);
			types.add(UMLElementTypes.CallOperationAction_3084);
			types.add(UMLElementTypes.SendObjectAction_3085);
			types.add(UMLElementTypes.SendSignalAction_3086);
			types.add(UMLElementTypes.AcceptEventAction_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.DecisionNode_3089);
			types.add(UMLElementTypes.MergeNode_3090);
			types.add(UMLElementTypes.ForkNode_3091);
			types.add(UMLElementTypes.JoinNode_3092);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
			types.add(UMLElementTypes.DataStoreNode_3093);
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
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InitialNode_3079);
			types.add(UMLElementTypes.ActivityFinalNode_3080);
			types.add(UMLElementTypes.FlowFinalNode_3081);
			types.add(UMLElementTypes.OpaqueAction_3082);
			types.add(UMLElementTypes.CallBehaviorAction_3083);
			types.add(UMLElementTypes.CallOperationAction_3084);
			types.add(UMLElementTypes.SendObjectAction_3085);
			types.add(UMLElementTypes.SendSignalAction_3086);
			types.add(UMLElementTypes.AcceptEventAction_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.DecisionNode_3089);
			types.add(UMLElementTypes.MergeNode_3090);
			types.add(UMLElementTypes.ForkNode_3091);
			types.add(UMLElementTypes.JoinNode_3092);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
			types.add(UMLElementTypes.DataStoreNode_3093);
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
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.DataStoreNode_3093);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
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
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InitialNode_3079);
			types.add(UMLElementTypes.ActivityFinalNode_3080);
			types.add(UMLElementTypes.FlowFinalNode_3081);
			types.add(UMLElementTypes.OpaqueAction_3082);
			types.add(UMLElementTypes.CallBehaviorAction_3083);
			types.add(UMLElementTypes.CallOperationAction_3084);
			types.add(UMLElementTypes.SendObjectAction_3085);
			types.add(UMLElementTypes.SendSignalAction_3086);
			types.add(UMLElementTypes.AcceptEventAction_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.DecisionNode_3089);
			types.add(UMLElementTypes.MergeNode_3090);
			types.add(UMLElementTypes.ForkNode_3091);
			types.add(UMLElementTypes.JoinNode_3092);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
			types.add(UMLElementTypes.DataStoreNode_3093);
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
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.ExpansionNode_3074);
			types.add(UMLElementTypes.ExpansionNode_3075);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.InitialNode_3079);
			types.add(UMLElementTypes.ActivityFinalNode_3080);
			types.add(UMLElementTypes.FlowFinalNode_3081);
			types.add(UMLElementTypes.OpaqueAction_3082);
			types.add(UMLElementTypes.CallBehaviorAction_3083);
			types.add(UMLElementTypes.CallOperationAction_3084);
			types.add(UMLElementTypes.SendObjectAction_3085);
			types.add(UMLElementTypes.SendSignalAction_3086);
			types.add(UMLElementTypes.AcceptEventAction_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.OutputPin_3077);
			types.add(UMLElementTypes.DecisionNode_3089);
			types.add(UMLElementTypes.MergeNode_3090);
			types.add(UMLElementTypes.ForkNode_3091);
			types.add(UMLElementTypes.JoinNode_3092);
			types.add(UMLElementTypes.DataStoreNode_3078);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
			types.add(UMLElementTypes.DataStoreNode_3093);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ActionFigureDescriptor extends AbstractActionFigure {


		/**
		 * @generated
		 */
		private CenteredWrappedLabel fActionLabel;

		/**
		 * @generated
		 */
		private PolylineShape fOptionalRakeFigure;


		/**
		 * @generated NOT call super
		 */
		public ActionFigureDescriptor() {
			super();

			createContents();
		}

		/**
		 * @generated NOT refresh rake if stereotype displayed
		 */
		@Override
		protected void refreshLayout() {
			super.refreshLayout();
			Dimension size = ActivityFigureDrawer.getNodeSize(CallBehaviorActionEditPart.this, null);
			ActivityFigureDrawer.redrawRake(getOptionalRakeFigure(), getMapMode(), size);
		}

		/**
		 * @generated NOT add constraint on label rectangle
		 */
		private void createContents() {


			fOptionalRakeFigure = new PolylineShape();
			fOptionalRakeFigure.setFill(false);
			fOptionalRakeFigure.setLineWidth(2);

			this.add(fOptionalRakeFigure);



			RectangleFigure labelRect0 = new RectangleFigure();
			labelRect0.setFill(false);
			labelRect0.setOutline(false);
			labelRect0.setLineWidth(1);

			// add constraint on label rectangle
			GridData constraintLabelRect0 = new GridData();
			constraintLabelRect0.verticalAlignment = GridData.FILL;
			constraintLabelRect0.horizontalAlignment = GridData.FILL;
			constraintLabelRect0.horizontalIndent = 0;
			constraintLabelRect0.horizontalSpan = 1;
			constraintLabelRect0.verticalSpan = 1;
			constraintLabelRect0.grabExcessHorizontalSpace = true;
			constraintLabelRect0.grabExcessVerticalSpace = true;
			this.add(labelRect0, constraintLabelRect0);

			CenterLayout layoutLabelRect0 = new CenterLayout();


			labelRect0.setLayoutManager(layoutLabelRect0);



			fActionLabel = new CenteredWrappedLabel();



			fActionLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			labelRect0.add(fActionLabel);



		}




		/**
		 * @generated
		 */
		public CenteredWrappedLabel getActionLabel() {
			return fActionLabel;
		}

		/**
		 * @generated
		 */
		public PolylineShape getOptionalRakeFigure() {
			return fOptionalRakeFigure;
		}

		/**
		 * @generated NOT ask the edit part
		 */
		@Override
		public IMapMode getMapMode() {
			//ask the edit part
			return CallBehaviorActionEditPart.this.getMapMode();
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
				prefColor = PreferenceConstantHelper.getElementConstant("CallBehaviorAction", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("CallBehaviorAction", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("CallBehaviorAction", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("CallBehaviorAction", PreferenceConstantHelper.COLOR_GRADIENT);
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
