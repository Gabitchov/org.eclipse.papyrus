/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.edit.parts;

/**
 * @generated
 */
public class ConstraintEditPartCN extends


org.eclipse.papyrus.uml.diagram.common.editparts.AbstractConstraintEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 56;

	/**
	 * @generated
	 */
	protected org.eclipse.draw2d.IFigure contentPane;

	/**
	 * @generated
	 */
	protected org.eclipse.draw2d.IFigure primaryShape;

	/**
	 * @generated
	 */
	public ConstraintEditPartCN(org.eclipse.gmf.runtime.notation.View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.uml.diagram.deployment.edit.policies.ConstraintItemSemanticEditPolicyCN());
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.CustomDiagramDragDropEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.CustomGraphicalNodeEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}




	/**
	 * Papyrus codeGen
	 * 
	 * @generated
	 **/
	protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
		super.handleNotificationEvent(event);

	}





	/**
	 * @generated
	 */
	protected org.eclipse.gef.editpolicies.LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();
				}
				return result;
			}

			protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {
				return null;
			}

			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected org.eclipse.draw2d.IFigure createNodeShape() {
		return primaryShape = new org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure();
	}

	/**
	 * @generated
	 */
	public org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure getPrimaryShape() {
		return (org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {
		if(childEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN) {
			((org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN) {
			((org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN)childEditPart).setLabel(getPrimaryShape().getConstraintFigure());
			return true;
		}


		return false;
	}


	/**
	 * @generated
	 */
	protected boolean removeFixedChild(org.eclipse.gef.EditPart childEditPart) {
		if(childEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN) {
			return true;
		}
		if(childEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(org.eclipse.gef.EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(org.eclipse.gef.EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected org.eclipse.draw2d.IFigure getContentPaneFor(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart editPart) {
		return getContentPane();
	}


	/**
	 * @generated
	 */
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
		String prefElementId = "Constraint";
		org.eclipse.jface.preference.IPreferenceStore store = org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.HEIGHT);
		org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure result = new org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));

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
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodeFigure() {
		org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new org.eclipse.draw2d.StackLayout());
		org.eclipse.draw2d.IFigure shape = createNodeShape();
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
	protected org.eclipse.draw2d.IFigure setupContentPane(org.eclipse.draw2d.IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout layout = new org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public org.eclipse.draw2d.IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(org.eclipse.swt.graphics.Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof org.eclipse.draw2d.Shape) {
			((org.eclipse.draw2d.Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof org.eclipse.draw2d.Shape) {
			((org.eclipse.draw2d.Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public org.eclipse.gef.EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSource() {
		java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(5);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSourceAndTarget(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart targetEditPart) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForTarget(org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Comment_2001);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Comment_54);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnTarget() {
		java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(6);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.CommentAnnotatedElement_4008);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004);
		types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForSource(org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.CommentAnnotatedElement_4008) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Comment_2001);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Comment_54);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Deployment_4001) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Manifestation_4002) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4004) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_4010) {
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Dependency_2011);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_2010);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_2009);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_2005);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_2002);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_2003);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_2006);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_2008);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.NamedElement_2012);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Model_49);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Package_36);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_16);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Device_44);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_21);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.ExecutionEnvironment_46);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_23);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Node_42);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_25);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_28);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Artifact_40);
			types.add(org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.Constraint_56);
		}
		return types;
	}





	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(org.eclipse.emf.ecore.EStructuralFeature feature) {
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = (org.eclipse.jface.preference.IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("Constraint", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_LINE);
			} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("Constraint", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FONT);
			} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("Constraint", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FILL);
			}
			result = org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(org.eclipse.jface.preference.PreferenceConverter.getColor((org.eclipse.jface.preference.IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("Constraint", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_GRADIENT);
			org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
