/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
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
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomAssociationNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.edit.policies.AssociationNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class AssociationNodeEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2015;

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
	public AssociationNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationNodeItemSemanticEditPolicy());
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
		return primaryShape = new AssociationNodeDescriptor();
	}

	/**
	 * @generated
	 */
	public AssociationNodeDescriptor getPrimaryShape() {
		return (AssociationNodeDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "AssociationNode";
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_1064);
		types.add(UMLElementTypes.PackageImport_1065);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(8);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_1064);
		types.add(UMLElementTypes.CommentAnnotatedElement_1022);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Constraint_1028);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Stereotype_1026);
			types.add(UMLElementTypes.Class_1031);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Profile_1030);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.Stereotype_1023);
			types.add(UMLElementTypes.Class_3028);
			types.add(UMLElementTypes.Model_1027);
			types.add(UMLElementTypes.Profile_1024);
			types.add(UMLElementTypes.Package_1012);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_1022) {
			types.add(UMLElementTypes.Comment_1002);
			types.add(UMLElementTypes.Comment_1007);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_1014);
			types.add(UMLElementTypes.Constraint_1028);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class AssociationNodeDescriptor extends Shape {

		/**
		 * @generated
		 */
		public AssociationNodeDescriptor() {
			this.addPoint(new Point(getMapMode().DPtoLP(5), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(10), getMapMode().DPtoLP(5)));
			this.addPoint(new Point(getMapMode().DPtoLP(5), getMapMode().DPtoLP(10)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));
			this.setFill(true);
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.white);
		}

		/**
		 * @generated
		 */
		private final PointList myTemplate = new PointList();

		/**
		 * @generated
		 */
		private Rectangle myTemplateBounds;

		/**
		 * @generated
		 */
		public void addPoint(Point point) {
			myTemplate.addPoint(point);
			myTemplateBounds = null;
		}

		/**
		 * @generated
		 */
		protected void fillShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.fillPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated
		 */
		protected void outlineShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.drawPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated
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
			return myTemplateBounds;
		}

		/**
		 * @generated
		 */
		private int[] scalePointList() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();
			float xScale = ((float)actualBounds.width) / pointsBounds.width;
			float yScale = ((float)actualBounds.height) / pointsBounds.height;
			if(xScale == 1 && yScale == 1) {
				return myTemplate.toIntArray();
			}
			int[] scaled = (int[])myTemplate.toIntArray().clone();
			for(int i = 0; i < scaled.length; i += 2) {
				scaled[i] = (int)Math.floor(scaled[i] * xScale);
				scaled[i + 1] = (int)Math.floor(scaled[i + 1] * yScale);
			}
			return scaled;
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
				prefColor = PreferenceConstantHelper.getElementConstant("AssociationNode", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("AssociationNode", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("AssociationNode", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("AssociationNode", PreferenceConstantHelper.COLOR_GRADIENT);
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
