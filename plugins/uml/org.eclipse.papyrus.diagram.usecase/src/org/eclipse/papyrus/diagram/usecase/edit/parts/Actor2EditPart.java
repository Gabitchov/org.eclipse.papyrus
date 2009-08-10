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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
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
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.usecase.edit.policies.Actor2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class Actor2EditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2012;

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
	public Actor2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Actor2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children
		// add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new UMLTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ActorAsRectangleFigure figure = new ActorAsRectangleFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActorAsRectangleFigure getPrimaryShape() {
		return (ActorAsRectangleFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ActorName2EditPart) {
			((ActorName2EditPart) childEditPart).setLabel(getPrimaryShape().getActorAsRectangleFigure_name());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ActorName2EditPart) {
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
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 60);
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActorName2EditPart.VISUAL_ID));
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
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
	public class ActorAsRectangleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fActorAsRectangleFigure_name;

		/**
		 * @generated
		 */
		public ActorAsRectangleFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel actorAsRectangleFigure_fixed_actor0 = new WrappingLabel();
			actorAsRectangleFigure_fixed_actor0.setText("\u00ABactor\u00BB");

			this.add(actorAsRectangleFigure_fixed_actor0);

			RectangleFigure actorAsRectangleFigure_NameContainer0 = new RectangleFigure();
			actorAsRectangleFigure_NameContainer0.setFill(false);
			actorAsRectangleFigure_NameContainer0.setOutline(false);
			actorAsRectangleFigure_NameContainer0.setLineWidth(1);

			this.add(actorAsRectangleFigure_NameContainer0);

			CenterLayout layoutActorAsRectangleFigure_NameContainer0 = new CenterLayout();

			actorAsRectangleFigure_NameContainer0.setLayoutManager(layoutActorAsRectangleFigure_NameContainer0);

			fActorAsRectangleFigure_name = new WrappingLabel();
			fActorAsRectangleFigure_name.setText("");

			actorAsRectangleFigure_NameContainer0.add(fActorAsRectangleFigure_name);

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
		public WrappingLabel getActorAsRectangleFigure_name() {
			return fActorAsRectangleFigure_name;
		}

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
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Actor",
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
