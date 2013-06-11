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
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.parts;

/**
 * @generated
 */
public class DependencyNodeEditPart extends

org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3203;

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
	public DependencyNodeEditPart(org.eclipse.gmf.runtime.notation.View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.uml.diagram.component.edit.policies.DependencyNodeItemSemanticEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.CustomGraphicalNodeEditPolicy());
		installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideLabelEditPolicy.SHOW_HIDE_LABEL_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideLabelEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected org.eclipse.gef.editpolicies.LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				org.eclipse.gmf.runtime.notation.View childView = (org.eclipse.gmf.runtime.notation.View)child.getModel();
				switch(org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getVisualID(childView)) {
				case org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart.VISUAL_ID:
					return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy() {

						protected java.util.List createSelectionHandles() {
							org.eclipse.gef.handles.MoveHandle mh = new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart)getHost());
							mh.setBorder(null);
							return java.util.Collections.singletonList(mh);
						}
					};
				}
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
		return primaryShape = new DependencyNodeDescriptor();
	}

	/**
	 * @generated
	 */
	public DependencyNodeDescriptor getPrimaryShape() {
		return (DependencyNodeDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(org.eclipse.draw2d.IFigure borderItemContainer, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart) {
			org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator locator = new org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
		String prefElementId = "DependencyNode";
		org.eclipse.jface.preference.IPreferenceStore store = org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.HEIGHT);
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
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createMainFigure() {
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
		return getChildBySemanticHint(org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSource() {
		java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(8);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.InterfaceRealization_4006);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSourceAndTarget(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart targetEditPart) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.InterfaceRealization_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.InterfaceRealization_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForTarget(org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.InterfaceRealization_4006) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnTarget() {
		java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(9);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.CommentAnnotatedElement_4015);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ConstraintConstrainedElement_4009);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010);
		types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForSource(org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
		java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.LinkedList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Usage_4001) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Substitution_4012) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Manifestation_4014) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ComponentRealization_4007) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Abstraction_4013) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.CommentAnnotatedElement_4015) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Comment_3201);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Comment_3074);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4010) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		} else if(relationshipType == org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_4017) {
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Dependency_3203);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_2002);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3202);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3200);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_2003);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3199);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.NamedElement_3204);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Model_3077);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Package_3076);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3070);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Component_3071);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Interface_3072);
			types.add(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Constraint_3075);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DependencyNodeDescriptor extends org.eclipse.draw2d.Ellipse {

		/**
		 * @generated
		 */
		public DependencyNodeDescriptor() {
			this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.black);
			this.setMaximumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10)));
			this.setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10)));
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
				prefColor = org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant("DependencyNode", org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant("DependencyNode", org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant("DependencyNode", org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_FILL);
			}
			result = org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(org.eclipse.jface.preference.PreferenceConverter.getColor((org.eclipse.jface.preference.IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant("DependencyNode", org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_GRADIENT);
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
