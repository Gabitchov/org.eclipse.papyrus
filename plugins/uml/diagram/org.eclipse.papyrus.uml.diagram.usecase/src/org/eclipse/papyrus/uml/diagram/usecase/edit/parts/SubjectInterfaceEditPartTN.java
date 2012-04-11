package org.eclipse.papyrus.uml.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
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
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.usecase.edit.policies.SubjectInterfaceItemSemanticEditPolicyTN;
import org.eclipse.papyrus.uml.diagram.usecase.figure.SubjectFigure;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class SubjectInterfaceEditPartTN extends NamedElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2021;

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
	public SubjectInterfaceEditPartTN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SubjectInterfaceItemSemanticEditPolicyTN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * Papyrus codeGen
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
		return primaryShape = new SubjectFigure();
	}

	/**
	 * @generated
	 */
	public SubjectFigure getPrimaryShape() {
		return (SubjectFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof SubjectInterfaceNameEditPartTN) {
			((SubjectInterfaceNameEditPartTN)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof SubjectInterfaceUsecasesEditPart) {
			IFigure pane = getPrimaryShape().getUseCasesContainerFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((SubjectInterfaceUsecasesEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof SubjectInterfaceNameEditPartTN) {
			return true;
		}
		if(childEditPart instanceof SubjectInterfaceUsecasesEditPart) {
			IFigure pane = getPrimaryShape().getUseCasesContainerFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((SubjectInterfaceUsecasesEditPart)childEditPart).getFigure());
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
		if(editPart instanceof SubjectInterfaceUsecasesEditPart) {
			return getPrimaryShape().getUseCasesContainerFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "Interface";
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(SubjectInterfaceNameEditPartTN.VISUAL_ID));
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Generalization_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Association_4011);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4015);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Usage_4016);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof SubjectComponentEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof SubjectClassEditPartTN) {
			types.add(UMLElementTypes.Realization_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectInterfaceEditPartTN) {
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
			types.add(UMLElementTypes.Component_2015);
			types.add(UMLElementTypes.Class_2020);
			types.add(UMLElementTypes.Interface_2021);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.NamedElement_2022);
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
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;
		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_GRADIENT);
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
