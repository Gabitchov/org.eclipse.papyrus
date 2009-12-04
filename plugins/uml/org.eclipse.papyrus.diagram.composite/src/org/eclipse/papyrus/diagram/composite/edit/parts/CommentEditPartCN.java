/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.figure.node.CornerBentFigure;
import org.eclipse.papyrus.diagram.composite.edit.policies.CommentItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class CommentEditPartCN extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3097;

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
	public CommentEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CommentItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children
		// add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

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
		CornerBentDescriptor figure = new CornerBentDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CornerBentDescriptor getPrimaryShape() {
		return (CornerBentDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CommentBodyEditPartCN) {
			((CommentBodyEditPartCN)childEditPart).setLabel(getPrimaryShape().getCornerBentContentLabel());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CommentBodyEditPartCN) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CommentBodyEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.Generalization_4015);
		types.add(UMLElementTypes.InformationFlow_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ClassClassifierEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof SendSignalEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof SendOperationEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CreationEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ExecutionEventEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.composite.edit.parts.CommentEditPartCN) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ClassClassifierEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof SendSignalEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof SendOperationEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CreationEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ExecutionEventEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.composite.edit.parts.CommentEditPartCN) {
			types.add(UMLElementTypes.Generalization_4015);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ClassClassifierEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof SendSignalEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof SendOperationEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CreationEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DestructionEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ExecutionEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.composite.edit.parts.CommentEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4016);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Activity_2060);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Interaction_2061);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.StateMachine_2063);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.FunctionBehavior_2064);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.OpaqueBehavior_2065);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Component_2069);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Device_2070);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Node_2072);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Class_2073);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Class_2074);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Collaboration_2075);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Interface_2076);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.PrimitiveType_2066);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Enumeration_2067);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DataType_2068);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Actor_2077);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_2078);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Artifact_2079);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.InformationItem_2080);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Signal_2081);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.UseCase_2082);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.SignalEvent_2083);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.CallEvent_2084);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.SendSignalEvent_2086);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.SendOperationEvent_2087);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ChangeEvent_2088);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.TimeEvent_2089);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.CreationEvent_2090);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DestructionEvent_2091);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ExecutionEvent_2092);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DurationObservation_2093);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.TimeObservation_2094);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.LiteralBoolean_2095);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.LiteralInteger_2096);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.LiteralNull_2097);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.LiteralString_2098);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.StringExpression_2100);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.OpaqueExpression_2101);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.TimeExpression_2102);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Expression_2103);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Duration_2104);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.TimeInterval_2105);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DurationInterval_2106);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Interval_2107);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.InstanceValue_2108);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Port_3069);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Property_3070);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ConnectableElement_3115);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.CollaborationUse_3071);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Activity_3072);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Interaction_3073);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.StateMachine_3075);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.FunctionBehavior_3076);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.OpaqueBehavior_3077);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Component_3081);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Device_3082);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Node_3084);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Class_3085);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Collaboration_3086);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Interface_3087);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.PrimitiveType_3078);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Enumeration_3079);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DataType_3080);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Actor_3091);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_3092);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Artifact_3093);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.InformationItem_3094);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Signal_3095);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.UseCase_3096);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Comment_3097);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_2060);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interaction_2061);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StateMachine_2063);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.FunctionBehavior_2064);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueBehavior_2065);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Component_2069);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Device_2070);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Node_2072);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_2073);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_2074);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Collaboration_2075);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interface_2076);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.PrimitiveType_2066);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Enumeration_2067);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DataType_2068);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Actor_2077);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DeploymentSpecification_2078);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Artifact_2079);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InformationItem_2080);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Signal_2081);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.UseCase_2082);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SignalEvent_2083);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CallEvent_2084);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SendSignalEvent_2086);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SendOperationEvent_2087);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ChangeEvent_2088);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeEvent_2089);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CreationEvent_2090);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DestructionEvent_2091);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEvent_2092);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationObservation_2093);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeObservation_2094);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralBoolean_2095);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralInteger_2096);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralNull_2097);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralString_2098);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StringExpression_2100);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueExpression_2101);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeExpression_2102);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Expression_2103);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Duration_2104);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeInterval_2105);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationInterval_2106);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interval_2107);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InstanceValue_2108);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Port_3069);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Property_3070);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ConnectableElement_3115);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CollaborationUse_3071);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_3072);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interaction_3073);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StateMachine_3075);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.FunctionBehavior_3076);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueBehavior_3077);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Component_3081);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Device_3082);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Node_3084);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_3085);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Collaboration_3086);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interface_3087);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.PrimitiveType_3078);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Enumeration_3079);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DataType_3080);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Actor_3091);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DeploymentSpecification_3092);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Artifact_3093);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InformationItem_3094);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Signal_3095);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.UseCase_3096);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Comment_3097);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Activity_2060);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interaction_2061);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StateMachine_2063);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.FunctionBehavior_2064);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueBehavior_2065);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Component_2069);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Device_2070);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Node_2072);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_2073);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_2074);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Collaboration_2075);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interface_2076);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.PrimitiveType_2066);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Enumeration_2067);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DataType_2068);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Actor_2077);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DeploymentSpecification_2078);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Artifact_2079);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InformationItem_2080);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Signal_2081);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.UseCase_2082);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SignalEvent_2083);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CallEvent_2084);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SendSignalEvent_2086);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SendOperationEvent_2087);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ChangeEvent_2088);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeEvent_2089);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CreationEvent_2090);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DestructionEvent_2091);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEvent_2092);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationObservation_2093);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeObservation_2094);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralBoolean_2095);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralInteger_2096);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralNull_2097);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralString_2098);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StringExpression_2100);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueExpression_2101);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeExpression_2102);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Expression_2103);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Duration_2104);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeInterval_2105);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationInterval_2106);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interval_2107);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InstanceValue_2108);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Port_3069);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Property_3070);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ConnectableElement_3115);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CollaborationUse_3071);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Activity_3072);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interaction_3073);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StateMachine_3075);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.FunctionBehavior_3076);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueBehavior_3077);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Component_3081);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Device_3082);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Node_3084);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_3085);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Collaboration_3086);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interface_3087);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.PrimitiveType_3078);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Enumeration_3079);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DataType_3080);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Actor_3091);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DeploymentSpecification_3092);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Artifact_3093);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InformationItem_3094);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Signal_3095);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.UseCase_3096);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Comment_3097);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		types.add(UMLElementTypes.Generalization_4015);
		types.add(UMLElementTypes.InformationFlow_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Comment_3097);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_2060);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interaction_2061);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StateMachine_2063);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.FunctionBehavior_2064);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueBehavior_2065);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Component_2069);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Device_2070);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Node_2072);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_2073);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_2074);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Collaboration_2075);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interface_2076);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.PrimitiveType_2066);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Enumeration_2067);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DataType_2068);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Actor_2077);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DeploymentSpecification_2078);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Artifact_2079);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InformationItem_2080);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Signal_2081);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.UseCase_2082);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SignalEvent_2083);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CallEvent_2084);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SendSignalEvent_2086);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.SendOperationEvent_2087);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ChangeEvent_2088);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeEvent_2089);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CreationEvent_2090);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DestructionEvent_2091);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEvent_2092);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationObservation_2093);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeObservation_2094);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralBoolean_2095);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralInteger_2096);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralNull_2097);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralString_2098);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StringExpression_2100);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueExpression_2101);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeExpression_2102);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Expression_2103);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Duration_2104);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeInterval_2105);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationInterval_2106);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interval_2107);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InstanceValue_2108);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Port_3069);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Property_3070);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ConnectableElement_3115);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.CollaborationUse_3071);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_3072);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interaction_3073);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.StateMachine_3075);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.FunctionBehavior_3076);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.OpaqueBehavior_3077);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Component_3081);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Device_3082);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Node_3084);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Class_3085);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Collaboration_3086);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Interface_3087);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.PrimitiveType_3078);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Enumeration_3079);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DataType_3080);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Actor_3091);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.DeploymentSpecification_3092);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Artifact_3093);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.InformationItem_3094);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Signal_3095);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.UseCase_3096);
		}
		if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Comment_3097);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Activity_2060);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interaction_2061);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StateMachine_2063);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.FunctionBehavior_2064);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueBehavior_2065);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Component_2069);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Device_2070);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Node_2072);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_2073);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_2074);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Collaboration_2075);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interface_2076);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.PrimitiveType_2066);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Enumeration_2067);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DataType_2068);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Actor_2077);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DeploymentSpecification_2078);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Artifact_2079);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InformationItem_2080);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Signal_2081);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.UseCase_2082);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SignalEvent_2083);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CallEvent_2084);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SendSignalEvent_2086);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.SendOperationEvent_2087);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ChangeEvent_2088);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeEvent_2089);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CreationEvent_2090);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DestructionEvent_2091);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEvent_2092);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationObservation_2093);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeObservation_2094);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralBoolean_2095);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralInteger_2096);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralNull_2097);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralString_2098);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StringExpression_2100);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueExpression_2101);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeExpression_2102);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Expression_2103);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Duration_2104);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeInterval_2105);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationInterval_2106);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interval_2107);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InstanceValue_2108);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Comment_2109);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DurationConstraint_2110);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.TimeConstraint_2111);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.IntervalConstraint_2112);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InteractionConstraint_2113);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Constraint_2114);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Port_3069);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Property_3070);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ConnectableElement_3115);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.CollaborationUse_3071);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Activity_3072);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interaction_3073);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.StateMachine_3075);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.FunctionBehavior_3076);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.OpaqueBehavior_3077);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Component_3081);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Device_3082);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Node_3084);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Class_3085);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Collaboration_3086);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Interface_3087);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.PrimitiveType_3078);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Enumeration_3079);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DataType_3080);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Actor_3091);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.DeploymentSpecification_3092);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Artifact_3093);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.InformationItem_3094);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Signal_3095);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.UseCase_3096);
		}
		if(relationshipType == UMLElementTypes.InformationFlow_4016) {
			types.add(UMLElementTypes.Comment_3097);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class CornerBentDescriptor extends CornerBentFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fCornerBentContentLabel;

		/**
		 * @generated
		 */
		public CornerBentDescriptor() {

			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fCornerBentContentLabel = new WrappingLabel();
			fCornerBentContentLabel.setText("");

			fCornerBentContentLabel.setFont(FCORNERBENTCONTENTLABEL_FONT);

			this.add(fCornerBentContentLabel);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getCornerBentContentLabel() {
			return fCornerBentContentLabel;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 248, 249, 214);

	/**
	 * @generated
	 */
	static final Font FCORNERBENTCONTENTLABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()
				|| feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore,
					prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Comment",
					PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore
					.getString(prefGradient));
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
