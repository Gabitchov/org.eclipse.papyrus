/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.BehaviorLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.figures.StateMachineCompositeFigure;
import org.eclipse.papyrus.uml.diagram.composite.custom.locators.PortPositionLocator;
import org.eclipse.papyrus.uml.diagram.composite.edit.policies.StateMachineCompositeItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class StateMachineCompositeEditPart extends NamedElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2063;

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
	public StateMachineCompositeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new PapyrusCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new StateMachineCompositeItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BehaviorLayoutEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AffixedNodeAlignmentEditPolicy());
		installEditPolicy("REMOVE_ORPHAN_VIEW", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
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
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case PortEditPart.VISUAL_ID:
				case ParameterEditPart.VISUAL_ID:
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
		return primaryShape = new StateMachineCompositeFigure();
	}

	/**
	 * @generated
	 */
	public StateMachineCompositeFigure getPrimaryShape() {
		return (StateMachineCompositeFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateMachineCompositeNameEditPart) {
			((StateMachineCompositeNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof StateMachineCompositeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompositeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateMachineCompositeCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		//Papyrus Gencode :Affixed Port locator
		if(childEditPart instanceof PortEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PortEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		//Papyrus Gencode :Affixed Port locator
		if(childEditPart instanceof ParameterEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ParameterEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateMachineCompositeNameEditPart) {
			return true;
		}
		if(childEditPart instanceof StateMachineCompositeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompositeCompartmentFigure();
			pane.remove(((StateMachineCompositeCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof PortEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PortEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ParameterEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ParameterEditPart)childEditPart).getFigure());
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
		if(editPart instanceof StateMachineCompositeCompartmentEditPart) {
			return getPrimaryShape().getCompositeCompartmentFigure();
		}
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "StateMachine";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.HEIGHT);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateMachineCompositeNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(12);
		types.add(UMLElementTypes.ComponentRealization_4004);
		types.add(UMLElementTypes.InterfaceRealization_4005);
		types.add(UMLElementTypes.Substitution_4011);
		types.add(UMLElementTypes.Realization_4006);
		types.add(UMLElementTypes.Manifestation_4012);
		types.add(UMLElementTypes.Abstraction_4007);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Deployment_4009);
		types.add(UMLElementTypes.Dependency_4017);
		types.add(UMLElementTypes.Dependency_4010);
		types.add(UMLElementTypes.Generalization_4015);
		types.add(UMLElementTypes.InformationFlow_4021);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4004);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4005);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Substitution_4011);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4006);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4012);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4007);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4009);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
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
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
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
		if(targetEditPart instanceof ActivityCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InteractionCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ComponentCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DeviceCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof NodeCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ClassCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof SignalEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof CallEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof AnyReceiveEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ChangeEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeEventEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof LiteralBooleanEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof LiteralIntegerEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof LiteralNullEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof LiteralStringEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof LiteralUnlimitedNaturalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof StringExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof OpaqueExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ExpressionEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DurationEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeIntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DurationIntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof IntervalEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InstanceValueEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof IntervalConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InteractionConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof PropertyPartEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof CollaborationRoleEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof CollaborationUseEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ActivityCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InteractionCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ProtocolStateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof StateMachineCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof FunctionBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof OpaqueBehaviorCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ComponentCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DeviceCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ExecutionEnvironmentCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof NodeCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ClassCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof CollaborationCompositeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ActorEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DeploymentSpecificationEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof UseCaseEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof TimeConstraintEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof IntervalConstraintEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof InteractionConstraintEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.InformationFlow_4021);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.ComponentRealization_4004) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.InterfaceRealization_4005) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Substitution_4011) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Realization_4006) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Manifestation_4012) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Abstraction_4007) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Deployment_4009) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Dependency_4017) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
		} else if(relationshipType == UMLElementTypes.InformationFlow_4021) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(17);
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		types.add(UMLElementTypes.ComponentRealization_4004);
		types.add(UMLElementTypes.InterfaceRealization_4005);
		types.add(UMLElementTypes.Substitution_4011);
		types.add(UMLElementTypes.Realization_4006);
		types.add(UMLElementTypes.Manifestation_4012);
		types.add(UMLElementTypes.Abstraction_4007);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Deployment_4009);
		types.add(UMLElementTypes.Dependency_4017);
		types.add(UMLElementTypes.Dependency_4010);
		types.add(UMLElementTypes.Generalization_4015);
		types.add(UMLElementTypes.TimeObservationEvent_4018);
		types.add(UMLElementTypes.DurationObservationEvent_4019);
		types.add(UMLElementTypes.InformationItemRepresented_4020);
		types.add(UMLElementTypes.InformationFlow_4021);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4002) {
			types.add(UMLElementTypes.Comment_2109);
			types.add(UMLElementTypes.Comment_3097);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.ComponentRealization_4004) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.InterfaceRealization_4005) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Substitution_4011) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Realization_4006) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Manifestation_4012) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Abstraction_4007) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Deployment_4009) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Dependency_4017) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		} else if(relationshipType == UMLElementTypes.Generalization_4015) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
		} else if(relationshipType == UMLElementTypes.TimeObservationEvent_4018) {
			types.add(UMLElementTypes.TimeObservation_2094);
		} else if(relationshipType == UMLElementTypes.DurationObservationEvent_4019) {
			types.add(UMLElementTypes.DurationObservation_2093);
		} else if(relationshipType == UMLElementTypes.InformationItemRepresented_4020) {
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.InformationItem_3094);
		} else if(relationshipType == UMLElementTypes.InformationFlow_4021) {
			types.add(UMLElementTypes.Activity_2060);
			types.add(UMLElementTypes.Interaction_2061);
			types.add(UMLElementTypes.ProtocolStateMachine_2062);
			types.add(UMLElementTypes.StateMachine_2063);
			types.add(UMLElementTypes.FunctionBehavior_2064);
			types.add(UMLElementTypes.OpaqueBehavior_2065);
			types.add(UMLElementTypes.Component_2069);
			types.add(UMLElementTypes.Device_2070);
			types.add(UMLElementTypes.ExecutionEnvironment_2071);
			types.add(UMLElementTypes.Node_2072);
			types.add(UMLElementTypes.Class_2073);
			types.add(UMLElementTypes.Collaboration_2075);
			types.add(UMLElementTypes.Interface_2076);
			types.add(UMLElementTypes.PrimitiveType_2066);
			types.add(UMLElementTypes.Enumeration_2067);
			types.add(UMLElementTypes.DataType_2068);
			types.add(UMLElementTypes.Actor_2077);
			types.add(UMLElementTypes.DeploymentSpecification_2078);
			types.add(UMLElementTypes.Artifact_2079);
			types.add(UMLElementTypes.InformationItem_2080);
			types.add(UMLElementTypes.Signal_2081);
			types.add(UMLElementTypes.UseCase_2082);
			types.add(UMLElementTypes.SignalEvent_2083);
			types.add(UMLElementTypes.CallEvent_2084);
			types.add(UMLElementTypes.AnyReceiveEvent_2085);
			types.add(UMLElementTypes.ChangeEvent_2088);
			types.add(UMLElementTypes.TimeEvent_2089);
			types.add(UMLElementTypes.DurationObservation_2093);
			types.add(UMLElementTypes.TimeObservation_2094);
			types.add(UMLElementTypes.LiteralBoolean_2095);
			types.add(UMLElementTypes.LiteralInteger_2096);
			types.add(UMLElementTypes.LiteralNull_2097);
			types.add(UMLElementTypes.LiteralString_2098);
			types.add(UMLElementTypes.LiteralUnlimitedNatural_2099);
			types.add(UMLElementTypes.StringExpression_2100);
			types.add(UMLElementTypes.OpaqueExpression_2101);
			types.add(UMLElementTypes.TimeExpression_2102);
			types.add(UMLElementTypes.Expression_2103);
			types.add(UMLElementTypes.Duration_2104);
			types.add(UMLElementTypes.TimeInterval_2105);
			types.add(UMLElementTypes.DurationInterval_2106);
			types.add(UMLElementTypes.Interval_2107);
			types.add(UMLElementTypes.InstanceValue_2108);
			types.add(UMLElementTypes.DurationConstraint_2110);
			types.add(UMLElementTypes.TimeConstraint_2111);
			types.add(UMLElementTypes.IntervalConstraint_2112);
			types.add(UMLElementTypes.InteractionConstraint_2113);
			types.add(UMLElementTypes.Constraint_2114);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Parameter_3088);
			types.add(UMLElementTypes.Property_3070);
			types.add(UMLElementTypes.ConnectableElement_3115);
			types.add(UMLElementTypes.CollaborationUse_3071);
			types.add(UMLElementTypes.Activity_3072);
			types.add(UMLElementTypes.Interaction_3073);
			types.add(UMLElementTypes.ProtocolStateMachine_3074);
			types.add(UMLElementTypes.StateMachine_3075);
			types.add(UMLElementTypes.FunctionBehavior_3076);
			types.add(UMLElementTypes.OpaqueBehavior_3077);
			types.add(UMLElementTypes.Component_3081);
			types.add(UMLElementTypes.Device_3082);
			types.add(UMLElementTypes.ExecutionEnvironment_3083);
			types.add(UMLElementTypes.Node_3084);
			types.add(UMLElementTypes.Class_3085);
			types.add(UMLElementTypes.Collaboration_3086);
			types.add(UMLElementTypes.Interface_3087);
			types.add(UMLElementTypes.PrimitiveType_3078);
			types.add(UMLElementTypes.Enumeration_3079);
			types.add(UMLElementTypes.DataType_3080);
			types.add(UMLElementTypes.Actor_3091);
			types.add(UMLElementTypes.DeploymentSpecification_3092);
			types.add(UMLElementTypes.Artifact_3093);
			types.add(UMLElementTypes.InformationItem_3094);
			types.add(UMLElementTypes.Signal_3095);
			types.add(UMLElementTypes.UseCase_3096);
			types.add(UMLElementTypes.DurationConstraint_3116);
			types.add(UMLElementTypes.TimeConstraint_3117);
			types.add(UMLElementTypes.IntervalConstraint_3118);
			types.add(UMLElementTypes.InteractionConstraint_3119);
			types.add(UMLElementTypes.Constraint_3120);
		}
		return types;
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
				prefColor = PreferencesConstantsHelper.getElementConstant("StateMachine", PreferencesConstantsHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("StateMachine", PreferencesConstantsHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("StateMachine", PreferencesConstantsHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferencesConstantsHelper.getElementConstant("StateMachine", PreferencesConstantsHelper.COLOR_GRADIENT);
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
