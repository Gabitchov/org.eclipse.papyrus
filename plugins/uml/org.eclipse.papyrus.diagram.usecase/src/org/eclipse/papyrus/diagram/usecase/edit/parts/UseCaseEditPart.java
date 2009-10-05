/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.draw2d.OneLineDashedBorder;
import org.eclipse.papyrus.diagram.common.draw2d.SplitEllipseLayout;
import org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UseCaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.figure.UseCaseNodeFigure;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class UseCaseEditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2013;

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
	public UseCaseEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new UseCaseItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
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
		UseCaseFigure figure = new UseCaseFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public UseCaseFigure getPrimaryShape() {
		return (UseCaseFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof UseCaseNameEditPart) {
			((UseCaseNameEditPart) childEditPart).setLabel(getPrimaryShape().getUseCaseFigure_name());
			return true;
		}

		if (childEditPart instanceof UseCasePointsEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.add(((UseCasePointsEditPart) childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof UseCaseNameEditPart) {
			return true;
		}
		if (childEditPart instanceof UseCasePointsEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
									// own way
			pane.remove(((UseCasePointsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
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
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof UseCasePointsEditPart) {
			return getPrimaryShape().getUseCaseFigure_contents();
		}
		return getContentPane();
	}

	/**
	 * Use custom figure to return EllipseAnchors
	 * 
	 * @generated NOT
	 * 
	 */
	protected NodeFigure createNodePlate() {
		UseCaseNodeFigure ucFigure = new UseCaseNodeFigure(getMapMode().DPtoLP(140), getMapMode().DPtoLP(60));
		return ucFigure;
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(UseCaseNameEditPart.VISUAL_ID));
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
		types.add(UMLElementTypes.Include_4008);
		types.add(UMLElementTypes.Extend_4009);
		types.add(UMLElementTypes.Generalization_4010);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.Dependency_4013);
		types.add(UMLElementTypes.Abstraction_4015);
		types.add(UMLElementTypes.Usage_4016);
		types.add(UMLElementTypes.Realization_4017);
		types.add(UMLElementTypes.PackageImport_4019);
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Include_4008);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Include_4008);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Include_4008);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Include_4008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Extend_4009);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Extend_4009);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Extend_4009);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Extend_4009);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.PackageImport_4019);
		}
		if (targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4019);
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
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4019) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.PackageImport_4019) {
			types.add(UMLElementTypes.Package_3014);
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
		types.add(UMLElementTypes.Include_4008);
		types.add(UMLElementTypes.Extend_4009);
		types.add(UMLElementTypes.Generalization_4010);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		types.add(UMLElementTypes.Dependency_4013);
		types.add(UMLElementTypes.CommentAnnotatedElement_4014);
		types.add(UMLElementTypes.Abstraction_4015);
		types.add(UMLElementTypes.Usage_4016);
		types.add(UMLElementTypes.Realization_4017);
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
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Include_4008) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Extend_4009) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_2018);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_3015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_3014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.ExtensionPoint_3007) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(UseCasePointsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class UseCaseFigure extends Ellipse {

		/**
		 * @generated
		 */
		private WrappingLabel fUseCaseFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fUseCaseFigure_contents;

		/**
		 * @generated
		 */
		public UseCaseFigure() {

			SplitEllipseLayout layoutThis = new SplitEllipseLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fUseCaseFigure_name = new WrappingLabel();
			fUseCaseFigure_name.setText("");

			fUseCaseFigure_name.setFont(FUSECASEFIGURE_NAME_FONT);

			this.add(fUseCaseFigure_name, BorderLayout.TOP);

			fUseCaseFigure_contents = new RectangleFigure();
			fUseCaseFigure_contents.setFill(false);
			fUseCaseFigure_contents.setOutline(false);
			fUseCaseFigure_contents.setLineWidth(1);
			fUseCaseFigure_contents.setBorder(createBorder0());

			this.add(fUseCaseFigure_contents, BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			OneLineDashedBorder result = new OneLineDashedBorder();

			return result;
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
		public WrappingLabel getUseCaseFigure_name() {
			return fUseCaseFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getUseCaseFigure_contents() {
			return fUseCaseFigure_contents;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 177, 207, 229);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 235, 248, 255);

	/**
	 * @generated
	 */
	static final Font FUSECASEFIGURE_NAME_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

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
				prefColor = PreferenceConstantHelper.getElementConstant("UseCase", PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("UseCase", PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("UseCase", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("UseCase",
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

}
