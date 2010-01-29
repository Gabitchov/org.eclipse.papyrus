package org.eclipse.papyrus.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
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
import org.eclipse.papyrus.diagram.common.draw2d.PileLayout;
import org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.diagram.usecase.edit.policies.Component3ItemSemanticEditPolicy;
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
public class Component3EditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3013;

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
	public Component3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Component3ItemSemanticEditPolicy());
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
		UseCaseSubjectFigure figure = new UseCaseSubjectFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public UseCaseSubjectFigure getPrimaryShape() {
		return (UseCaseSubjectFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ComponentName3EditPart) {
			((ComponentName3EditPart)childEditPart).setLabel(getPrimaryShape().getUseCaseSubjectFigure_name());
			return true;
		}

		if(childEditPart instanceof ComponentUsecases3EditPart) {
			IFigure pane = getPrimaryShape().getUseCaseSubjectFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
			// own way
			pane.add(((ComponentUsecases3EditPart)childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ComponentName3EditPart) {
			return true;
		}
		if(childEditPart instanceof ComponentUsecases3EditPart) {
			IFigure pane = getPrimaryShape().getUseCaseSubjectFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
			// own way
			pane.remove(((ComponentUsecases3EditPart)childEditPart).getFigure());
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
		if(editPart instanceof ComponentUsecases3EditPart) {
			return getPrimaryShape().getUseCaseSubjectFigure_contents();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(200, 400);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ComponentName3EditPart.VISUAL_ID));
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
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
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart) {
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
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
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.PackageImport_4019) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.PackageImport_4019) {
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
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
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Generalization_4010) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_2018);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_3015);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Abstraction_4015) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Usage_4016) {
			types.add(UMLElementTypes.Package_3014);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_2015);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_2016);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3016);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Component_3013);
		}
		if(relationshipType == UMLElementTypes.Realization_4017) {
			types.add(UMLElementTypes.Package_3014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class UseCaseSubjectFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fUseCaseSubjectFigure_contents;

		/**
		 * @generated
		 */
		private WrappingLabel fUseCaseSubjectFigure_name;

		/**
		 * @generated
		 */
		public UseCaseSubjectFigure() {

			PileLayout layoutThis = new PileLayout();

			layoutThis.setStretchBottom(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure useCaseSubjectFigure_header0 = new RectangleFigure();
			useCaseSubjectFigure_header0.setLineWidth(1);

			this.add(useCaseSubjectFigure_header0);

			CenterLayout layoutUseCaseSubjectFigure_header0 = new CenterLayout();

			useCaseSubjectFigure_header0.setLayoutManager(layoutUseCaseSubjectFigure_header0);

			fUseCaseSubjectFigure_name = new WrappingLabel();
			fUseCaseSubjectFigure_name.setText("");

			fUseCaseSubjectFigure_name.setFont(FUSECASESUBJECTFIGURE_NAME_FONT);

			fUseCaseSubjectFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			useCaseSubjectFigure_header0.add(fUseCaseSubjectFigure_name);

			fUseCaseSubjectFigure_contents = new RectangleFigure();
			fUseCaseSubjectFigure_contents.setLineWidth(1);

			this.add(fUseCaseSubjectFigure_contents);
			fUseCaseSubjectFigure_contents.setLayoutManager(new StackLayout());

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
		public RectangleFigure getUseCaseSubjectFigure_contents() {
			return fUseCaseSubjectFigure_contents;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getUseCaseSubjectFigure_name() {
			return fUseCaseSubjectFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 245, 245, 245);

	/**
	 * @generated
	 */
	static final Font FUSECASESUBJECTFIGURE_NAME_FONT = new Font(Display.getCurrent(), Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

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
				prefColor = PreferenceConstantHelper.getElementConstant("Component", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Component", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Component", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Component", PreferenceConstantHelper.COLOR_GRADIENT);
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
