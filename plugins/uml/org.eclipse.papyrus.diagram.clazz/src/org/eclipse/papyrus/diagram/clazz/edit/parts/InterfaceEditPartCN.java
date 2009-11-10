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
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.clazz.custom.policies.InstanceSpecificationGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic.CustomInterfaceItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.clazz.edit.policies.InterfaceItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editparts.ClassifierEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.InterfaceFigure;
import org.eclipse.papyrus.diagram.common.locator.TemplateClassifierBorderItemLocator;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class InterfaceEditPartCN extends

ClassifierEditPart

{

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3023;

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
	public InterfaceEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InterfaceNameEditPartCN) {
			((InterfaceNameEditPartCN) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}

		if (childEditPart instanceof InterfaceAttributeCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.add(((InterfaceAttributeCompartment2EditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof InterfaceOperationCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.add(((InterfaceOperationCompartment2EditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof InterfaceNestedClassifierCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.add(((InterfaceNestedClassifierCompartment2EditPart) childEditPart).getFigure());
			return true;
		}

		// Papyrus Gencode :precise the locator for a template signature
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			BorderItemLocator locator = new TemplateClassifierBorderItemLocator(getMainFigure(),
					PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(
					((RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InterfaceItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE,
		// new org.eclipse.papyrus.diagram.clazz.edit.policies.InterfaceCanonicalEditPolicyCN());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new InstanceSpecificationGraphicalNodeEditPolicy());
		installEditPolicy("RESIZE_BORDER_ITEMS", new ConstrainedItemBorderLayoutEditPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInterfaceItemSemanticEditPolicyCN());
		// XXX need an SCR to runtime to have another abstract superclass that would let children
		// add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 *Papyrus codeGen
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
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:

					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
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
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 100);
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new InterfaceFigure();
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
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof InterfaceAttributeCompartment2EditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		if (editPart instanceof InterfaceOperationCompartment2EditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if (editPart instanceof InterfaceNestedClassifierCompartment2EditPart) {
			return getPrimaryShape().getNestedClassifierFigure();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
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
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.AssociationClass_4017);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Substitution_4004);
		types.add(UMLElementTypes.Realization_4005);
		types.add(UMLElementTypes.Abstraction_4006);
		types.add(UMLElementTypes.Usage_4007);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_4009);
		types.add(UMLElementTypes.PackageImport_4010);
		types.add(UMLElementTypes.TemplateBinding_4015);
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
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if (targetEditPart instanceof Dependency2EditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
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
		if (targetEditPart instanceof Dependency2EditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
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
		if (targetEditPart instanceof Dependency2EditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
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
		if (targetEditPart instanceof Dependency2EditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
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
		if (targetEditPart instanceof Dependency2EditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
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
		if (targetEditPart instanceof Dependency2EditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if (targetEditPart instanceof Dependency2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof ClassEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof Comment2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
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
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.AssociationClass_4017);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		types.add(UMLElementTypes.Substitution_4004);
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.DataType_3027);
		}
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Component_2002);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Signal_2003);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Interface_2004);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Class_2008);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.PrimitiveType_2009);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Component_3021);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Signal_3022);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Interface_3023);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.PrimitiveType_3026);
		}
		if (relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.DataType_3027);
		}
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
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
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
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
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
		if (relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4010) {
			types.add(UMLElementTypes.Model_2005);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4010) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4010) {
			types.add(UMLElementTypes.Model_3024);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4010) {
			types.add(UMLElementTypes.Package_3009);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.AssociationClass_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Association_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2001);
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
			types.add(UMLElementTypes.Constraint_2011);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Comment_2012);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.InstanceSpecification_3020);
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
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Comment_3028);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.Constraint_3029);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public InterfaceFigure getPrimaryShape() {
		return (InterfaceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.Property_3006) {
				return getChildBySemanticHint(UMLVisualIDRegistry
						.getType(InterfaceAttributeCompartment2EditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Operation_3007) {
				return getChildBySemanticHint(UMLVisualIDRegistry
						.getType(InterfaceOperationCompartment2EditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Class_3008) {
				return getChildBySemanticHint(UMLVisualIDRegistry
						.getType(InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore) getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()
				|| feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface",
						PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface",
						PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface",
						PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Interface",
					PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore
					.getString(prefGradient));
			if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if (result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InterfaceNameEditPartCN) {
			return true;
		}
		if (childEditPart instanceof InterfaceAttributeCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.remove(((InterfaceAttributeCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceOperationCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.remove(((InterfaceOperationCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceNestedClassifierCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.remove(((InterfaceNestedClassifierCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((RedefinableTemplateSignatureEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
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
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

}
