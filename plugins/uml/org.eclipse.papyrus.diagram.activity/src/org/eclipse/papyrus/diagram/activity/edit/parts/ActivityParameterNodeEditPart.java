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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityParameterNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.common.editparts.IPapyrusEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * @generated NOT implements IPapyrusEditPart
 */
public class ActivityParameterNodeEditPart extends

AbstractBorderItemEditPart implements IPapyrusEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3059;

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
	public ActivityParameterNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityParameterNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
		return primaryShape = new ActivityParameterNodeDescriptor();
	}

	/**
	 * @generated
	 */
	public ActivityParameterNodeDescriptor getPrimaryShape() {
		return (ActivityParameterNodeDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CenteredWrappedLabelEditPart) {
			((CenteredWrappedLabelEditPart)childEditPart).setLabel(getPrimaryShape().getActivityParameterNodeLabel());
			return true;
		}


		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CenteredWrappedLabelEditPart) {
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
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "ActivityParameterNode";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));


		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
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
	protected NodeFigure createNodeFigure() {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CenteredWrappedLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart) {
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart) {
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
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
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
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		types.add(UMLElementTypes.ExceptionHandler_4005);
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
		} else if(relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3007);
			types.add(UMLElementTypes.CallBehaviorAction_3008);
			types.add(UMLElementTypes.CallOperationAction_3010);
			types.add(UMLElementTypes.SendObjectAction_3042);
			types.add(UMLElementTypes.SendSignalAction_3052);
			types.add(UMLElementTypes.AcceptEventAction_3063);
			types.add(UMLElementTypes.ConditionalNode_3069);
			types.add(UMLElementTypes.ExpansionRegion_3070);
			types.add(UMLElementTypes.LoopNode_3071);
			types.add(UMLElementTypes.SequenceNode_3073);
			types.add(UMLElementTypes.StructuredActivityNode_3065);
			types.add(UMLElementTypes.OpaqueAction_3082);
			types.add(UMLElementTypes.CallBehaviorAction_3083);
			types.add(UMLElementTypes.CallOperationAction_3084);
			types.add(UMLElementTypes.SendObjectAction_3085);
			types.add(UMLElementTypes.SendSignalAction_3086);
			types.add(UMLElementTypes.AcceptEventAction_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3076);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		return types;
	}

	/**
	 * @generated NOT implements IPapyrusNodeUMLElementFigure
	 */
	public class ActivityParameterNodeDescriptor extends RectangleFigure implements IPapyrusNodeUMLElementFigure {

		/**
		 * @generated
		 */
		private CenteredWrappedLabel fActivityParameterNodeLabel;

		/** The helper which handles stereotype aspects */
		private StereotypeFigureHelper stereotypeHelper;

		/**
		 * @generated NOT use StereotypeFigureHelper
		 */
		public ActivityParameterNodeDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(50)));
			createContents();
			// use StereotypeFigureHelper
			stereotypeHelper = new StereotypeFigureHelper(this) {

				@Override
				public IMapMode getMapMode() {
					return ActivityParameterNodeEditPart.this.getMapMode();
				}

				@Override
				public Object getStereotypeRectangleConstraint() {
					GridData constraintStereotypeRect0 = new GridData();
					constraintStereotypeRect0.verticalAlignment = GridData.BEGINNING;
					constraintStereotypeRect0.horizontalAlignment = GridData.FILL;
					constraintStereotypeRect0.horizontalIndent = 0;
					constraintStereotypeRect0.horizontalSpan = 1;
					constraintStereotypeRect0.verticalSpan = 1;
					constraintStereotypeRect0.grabExcessHorizontalSpace = false;
					constraintStereotypeRect0.grabExcessVerticalSpace = false;
					return constraintStereotypeRect0;
				}
			};
		}

		/**
		 * @generated
		 */
		private void createContents() {


			RectangleFigure labelRect0 = new RectangleFigure();
			labelRect0.setFill(false);
			labelRect0.setOutline(false);


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



			fActivityParameterNodeLabel = new CenteredWrappedLabel();



			fActivityParameterNodeLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			labelRect0.add(fActivityParameterNodeLabel);



		}

		/**
		 * Refresh the layout of the figure
		 */
		protected void refreshLayout() {
		}

		/**
		 * Sets the stereotypes for this figure.
		 * 
		 * @param stereotypes
		 *        the string representing the stereotypes to be displayed
		 * @param image
		 *        the image representing the stereotypes to be displayed
		 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
		 *      org.eclipse.swt.graphics.Image)
		 */
		public void setStereotypeDisplay(String stereotypes, Image image) {
			stereotypeHelper.setStereotypeDisplay(stereotypes, image);
			refreshLayout();
		}

		/**
		 * Sets the stereotypes properties for this figure.
		 * 
		 * @param stereotypeProperties
		 *        the string representing the stereotype properties to be displayed
		 */
		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
			refreshLayout();
		}

		/**
		 * displays the new string corresponding to the list of stereotypes.
		 * 
		 * @param stereotypeProperties
		 *        the string to be displayed.
		 */
		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
			stereotypeHelper.setStereotypePropertiesInCompartment(stereotypeProperties);
			refreshLayout();
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
		 * @generated
		 */
		public CenteredWrappedLabel getActivityParameterNodeLabel() {
			return fActivityParameterNodeLabel;
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
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityParameterNode", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityParameterNode", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityParameterNode", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("ActivityParameterNode", PreferenceConstantHelper.COLOR_GRADIENT);
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
