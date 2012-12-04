package org.eclipse.papyrus.uml.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
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
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.figures.StateFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.locators.CustomEntryExitPointPositionLocator;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.policies.CustomStateCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.policies.CustomStateItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.policies.CustomStateLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.policies.CustomStateMachineDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.policies.StateItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class StateEditPart extends NamedElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 6000;

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
	public StateEditPart(View view) {
		super(view);
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
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof StateCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getStateCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		//Papyrus Gencode :Affixed EntryExitPoints ConnectionPointReferences Locator
		if(childEditPart instanceof PseudostateEntryPointEditPart) {
			IBorderItemLocator locator = new CustomEntryExitPointPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PseudostateEntryPointEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		//Papyrus Gencode :Affixed EntryExitPoints ConnectionPointReferences Locator
		if(childEditPart instanceof PseudostateExitPointEditPart) {
			IBorderItemLocator locator = new CustomEntryExitPointPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PseudostateExitPointEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		//Papyrus Gencode :Affixed EntryExitPoints ConnectionPointReferences Locator
		if(childEditPart instanceof ConnectionPointReferenceEditPart) {
			IBorderItemLocator locator = new CustomEntryExitPointPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ConnectionPointReferenceEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new PapyrusCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new StateItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.statemachine.edit.policies.StateCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CustomStateLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomStateMachineDiagramDragDropEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CustomStateCreationEditPolicy());
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AffixedNodeAlignmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStateItemSemanticEditPolicy());
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
				case PseudostateEntryPointEditPart.VISUAL_ID:
				case PseudostateExitPointEditPart.VISUAL_ID:
				case ConnectionPointReferenceEditPart.VISUAL_ID:
					return new BorderItemResizableEditPolicy();
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
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "State";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new StateFigure();
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
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof StateCompartmentEditPart) {
			return getPrimaryShape().getStateCompartmentFigure();
		}
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_7000);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof FinalStateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateInitialEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateJoinEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateForkEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateChoiceEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateJunctionEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateShallowHistoryEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateDeepHistoryEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateTerminateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateEntryPointEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof PseudostateExitPointEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if(targetEditPart instanceof ConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Transition_7000);
		types.add(UMLElementTypes.CommentAnnotatedElement_667);
		types.add(UMLElementTypes.ConstraintConstrainedElement_670);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Transition_7000) {
			types.add(UMLElementTypes.FinalState_5000);
			types.add(UMLElementTypes.State_6000);
			types.add(UMLElementTypes.Pseudostate_8000);
			types.add(UMLElementTypes.Pseudostate_9000);
			types.add(UMLElementTypes.Pseudostate_10000);
			types.add(UMLElementTypes.Pseudostate_11000);
			types.add(UMLElementTypes.Pseudostate_12000);
			types.add(UMLElementTypes.Pseudostate_13000);
			types.add(UMLElementTypes.Pseudostate_14000);
			types.add(UMLElementTypes.Pseudostate_15000);
			types.add(UMLElementTypes.Pseudostate_16000);
			types.add(UMLElementTypes.Pseudostate_17000);
			types.add(UMLElementTypes.ConnectionPointReference_18000);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_667) {
			types.add(UMLElementTypes.Comment_666);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_670) {
			types.add(UMLElementTypes.Constraint_668);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Transition_7000) {
			types.add(UMLElementTypes.FinalState_5000);
			types.add(UMLElementTypes.State_6000);
			types.add(UMLElementTypes.Pseudostate_8000);
			types.add(UMLElementTypes.Pseudostate_9000);
			types.add(UMLElementTypes.Pseudostate_10000);
			types.add(UMLElementTypes.Pseudostate_11000);
			types.add(UMLElementTypes.Pseudostate_12000);
			types.add(UMLElementTypes.Pseudostate_13000);
			types.add(UMLElementTypes.Pseudostate_14000);
			types.add(UMLElementTypes.Pseudostate_15000);
			types.add(UMLElementTypes.Pseudostate_16000);
			types.add(UMLElementTypes.Pseudostate_17000);
			types.add(UMLElementTypes.ConnectionPointReference_18000);
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
				prefColor = PreferenceConstantHelper.getElementConstant("State", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("State", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("State", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("State", PreferenceConstantHelper.COLOR_GRADIENT);
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

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public StateFigure getPrimaryShape() {
		return (StateFigure)primaryShape;
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
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateNameEditPart) {
			return true;
		}
		if(childEditPart instanceof StateCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getStateCompartmentFigure();
			pane.remove(((StateCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof PseudostateEntryPointEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PseudostateEntryPointEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof PseudostateExitPointEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PseudostateExitPointEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ConnectionPointReferenceEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ConnectionPointReferenceEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
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
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
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
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
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
}
