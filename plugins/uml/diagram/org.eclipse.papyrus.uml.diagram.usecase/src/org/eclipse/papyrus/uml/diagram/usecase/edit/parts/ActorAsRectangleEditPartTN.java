/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
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
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ChangeStereotypedShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.usecase.edit.policies.ActorAsRectangleItemSemanticEditPolicyTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.usecase.edit.policies.UseCaseChangeStereotypedShapeEditpolicy;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ActorAsRectangleEditPartTN extends ShapeNodeEditPart {

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
	public ActorAsRectangleEditPartTN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActorAsRectangleItemSemanticEditPolicyTN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(ChangeStereotypedShapeEditPolicy.CHANGE_SHAPE_POLICY, new UseCaseChangeStereotypedShapeEditpolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if(child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if(child instanceof ITextAwareEditPart) {
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
		return primaryShape = new ActorAsRectangleFigure();
	}

	/**
	 * @generated
	 */
	public ActorAsRectangleFigure getPrimaryShape() {
		return (ActorAsRectangleFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActorAsRectangleNameEditPartTN) {
			((ActorAsRectangleNameEditPartTN)childEditPart).setLabel(getPrimaryShape().getActorAsRectangleFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActorAsRectangleNameEditPartTN) {
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
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "Actor";
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActorAsRectangleNameEditPartTN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
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
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ActorEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.PackageImport_4019);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4019);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
		} else if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
		} else if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.PackageImport_4019) {
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Package_3014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(8);
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
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
		} else if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Constraint_3010);
		} else if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_2018);
			types.add(UMLElementTypes.Comment_3015);
		} else if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
		} else if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
			types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Classifier_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
			types.add(UMLElementTypes.NamedElement_2023);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
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
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;
		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Actor", PreferenceConstantHelper.COLOR_GRADIENT);
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
