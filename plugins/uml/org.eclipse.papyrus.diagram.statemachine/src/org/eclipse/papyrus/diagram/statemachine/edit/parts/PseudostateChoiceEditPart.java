package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.editparts.UMLNodeEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.PseudostateChoiceFigure;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.PseudostateChoiceItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class PseudostateChoiceEditPart extends

UMLNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 11000;

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
	public PseudostateChoiceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof PseudostateChoiceNameEditPart) {
			IBorderItemLocator locator = new ExternalLabelPositionLocator(
					getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else if (borderItemEditPart instanceof PseudostateChoiceStereotypeEditPart) {
			IBorderItemLocator locator = new ExternalLabelPositionLocator(
					getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PseudostateChoiceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY,
				new QualifiedNameDisplayEditPolicy());
		installEditPolicy(
				AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY,
				new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case PseudostateChoiceNameEditPart.VISUAL_ID:
				case PseudostateChoiceStereotypeEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle(
									(GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		String prefElementId = "Pseudostate";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper
				.getpreferenceKey(getNotationView(), prefElementId,
						PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper
				.getpreferenceKey(getNotationView(), prefElementId,
						PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(
				store.getInt(preferenceConstantWitdh),
				store.getInt(preferenceConstantHeight));

		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new PseudostateChoiceFigure();
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_7000);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof FinalStateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateInitialEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateJoinEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateForkEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateJunctionEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateShallowHistoryEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateDeepHistoryEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateTerminateEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateEntryPointEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof PseudostateExitPointEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		if (targetEditPart instanceof ConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_7000);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_7000);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Transition_7000) {
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
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Transition_7000) {
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
		IPreferenceStore preferenceStore = (IPreferenceStore) getDiagramPreferencesHint()
				.getPreferenceStore();
		Object result = null;

		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()
				|| feature == NotationPackage.eINSTANCE
						.getFontStyle_FontColor()
				|| feature == NotationPackage.eINSTANCE
						.getFillStyle_FillColor()) {
			String prefColor = null;
			if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant(
						"Pseudostate", PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE
					.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant(
						"Pseudostate", PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE
					.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant(
						"Pseudostate", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor(
					(IPreferenceStore) preferenceStore, prefColor));
		} else if (feature == NotationPackage.eINSTANCE
				.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant(
					"Pseudostate", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
					preferenceStore.getString(prefGradient));
			if (feature == NotationPackage.eINSTANCE
					.getFillStyle_Transparency()) {
				result = new Integer(
						gradientPreferenceConverter.getTransparency());
			} else if (feature == NotationPackage.eINSTANCE
					.getFillStyle_Gradient()) {
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(PseudostateChoiceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public PseudostateChoiceFigure getPrimaryShape() {
		return (PseudostateChoiceFigure) primaryShape;
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
}
