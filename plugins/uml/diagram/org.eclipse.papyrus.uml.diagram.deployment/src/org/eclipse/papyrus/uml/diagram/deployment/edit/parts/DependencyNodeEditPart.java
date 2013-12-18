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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
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
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.edit.policies.DependencyNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class DependencyNodeEditPart extends

AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2011;

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
	public DependencyNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DependencyNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(ShowHideLabelEditPolicy.SHOW_HIDE_LABEL_ROLE, new ShowHideLabelEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case MultiDependencyLabelEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
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
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof MultiDependencyLabelEditPart) {
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
		String prefElementId = "DependencyNode";
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(MultiDependencyLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.Dependency_4004);
		types.add(UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ModelEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
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
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ModelEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
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
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ModelEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
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
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ModelEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Dependency_4004) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
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
		types.add(UMLElementTypes.Dependency_4004);
		types.add(UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4008) {
			types.add(UMLElementTypes.Comment_2001);
			types.add(UMLElementTypes.Comment_54);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Dependency_4004) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Artifact_28);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Constraint_56);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DependencyNodeDescriptor extends Ellipse {

		/**
		 * @generated
		 */
		public DependencyNodeDescriptor() {
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10)));
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
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DependencyNode", PreferencesConstantsHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DependencyNode", PreferencesConstantsHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferencesConstantsHelper.getElementConstant("DependencyNode", PreferencesConstantsHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferencesConstantsHelper.getElementConstant("DependencyNode", PreferencesConstantsHelper.COLOR_GRADIENT);
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
