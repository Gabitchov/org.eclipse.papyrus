/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST) Amine.Elkouhen@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
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
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.editparts.CompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.custom.figure.nodes.ArtifactFigure;
import org.eclipse.papyrus.uml.diagram.deployment.edit.policies.ArtifactItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ArtifactEditPartCN extends

CompositeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 25;

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
	public ArtifactEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ArtifactItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy("REMOVE_ORPHAN_VIEW", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
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
		super.handleNotificationEvent(event);

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
		return primaryShape = new ArtifactFigure();
	}

	/**
	 * @generated
	 */
	public ArtifactFigure getPrimaryShape() {
		return (ArtifactFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ArtifactNameEditPartCN) {
			((ArtifactNameEditPartCN)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}

		if(childEditPart instanceof ArtifactCompositeCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getCompositeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ArtifactCompositeCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ArtifactNameEditPartCN) {
			return true;
		}
		if(childEditPart instanceof ArtifactCompositeCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getCompositeCompartmentFigure();
			pane.remove(((ArtifactCompositeCompartmentEditPartCN)childEditPart).getFigure());
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
		if(editPart instanceof ArtifactCompositeCompartmentEditPartCN) {
			return getPrimaryShape().getCompositeCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "Artifact";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));

		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for
	 * generated figure.
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ArtifactNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Dependency_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Dependency_4004) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(6);
		types.add(UMLElementTypes.CommentAnnotatedElement_4008);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4009);
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Dependency_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4008) {
			types.add(UMLElementTypes.Comment_2001);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(UMLElementTypes.Constraint_2005);
		} else if(relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
		} else if(relationshipType == UMLElementTypes.Dependency_4004) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
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
				prefColor = PreferenceConstantHelper.getElementConstant("Artifact", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Artifact", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Artifact", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Artifact", PreferenceConstantHelper.COLOR_GRADIENT);
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
