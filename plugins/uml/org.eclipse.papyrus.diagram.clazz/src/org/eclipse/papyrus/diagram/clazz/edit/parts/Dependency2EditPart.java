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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Dependency2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class Dependency2EditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2014;

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
	public Dependency2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Dependency2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
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
		DependencyNodeDescriptor figure = new DependencyNodeDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DependencyNodeDescriptor getPrimaryShape() {
		return (DependencyNodeDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(10, 10);

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
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Realization_4005);
		types.add(UMLElementTypes.Abstraction_4006);
		types.add(UMLElementTypes.Usage_4007);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Realization_4005);
		types.add(UMLElementTypes.Abstraction_4006);
		types.add(UMLElementTypes.Usage_4007);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		types.add(UMLElementTypes.TemplateBinding_4015);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4013) {
			types.add(UMLElementTypes.Comment_2012);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4013) {
			types.add(UMLElementTypes.Comment_3028);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.DataType_3027);
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
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(10)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(10)));
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

}
