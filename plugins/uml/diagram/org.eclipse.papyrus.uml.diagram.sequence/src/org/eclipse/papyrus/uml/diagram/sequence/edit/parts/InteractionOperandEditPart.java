/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.WrapTextCellEditor;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CombinedFragmentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandComponentEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.InteractionOperandFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.ContinuationLocator;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @generated
 */
public class InteractionOperandEditPart extends

AbstractBorderedShapeEditPart implements ITextAwareEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * True if this Edit Part is the first Operand of his CombinedFragment's parent
	 */
	private boolean firstOperand = false;

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifierHelper = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * @generated
	 */
	public InteractionOperandEditPart(View view) {
		super(view);
	}

	/**
	 * Remove EditPolicyRoles.DRAG_DROP_ROLE and EditPolicy.PRIMARY_DRAG_ROLE :
	 * - adding elements to an interactionOperand doesn't anymore resize the enclosing CF
	 * - interactionOperand are no longer dNd
	 * 
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CombinedFragmentCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InteractionOperandItemSemanticEditPolicy());
		//installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InteractionOperandLayoutEditPolicy());
		//		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new InteractionOperandDragDropEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new InteractionOperandComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SequenceGraphicalNodeEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		
		// Fixed bug id=364701 (https://bugs.eclipse.org/bugs/show_bug.cgi?id=364701)
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new InteractionOperandDragDropEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new GuardConditionDirectEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		XYLayoutEditPolicy lep = new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case ContinuationEditPart.VISUAL_ID:

					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = super.createChildEditPolicy(child);
				if(result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new CustomInteractionOperandFigure() {

			protected boolean useLocalCoordinates() {
				return true;
			}
		};
	}

	/**
	 * @generated
	 */
	public CustomInteractionOperandFigure getPrimaryShape() {
		return (CustomInteractionOperandFigure)primaryShape;
	}

	/**
	 * Overrides to return the contentPane instead of the main figure in case the editPart is not a IBorderItemEditPart.
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getContentPaneFor(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		} else {
			return getContentPane();
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "InteractionOperand";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));

		return result;
	}

	/**
	 * @generated
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if(result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy)result;
			ep.setResizeDirections(PositionConstants.SOUTH);
		}
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
	@Override
	protected NodeFigure createMainFigure() {
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
			nodeShape.setLayoutManager(new FreeformLayout() {

				public Object getConstraint(IFigure figure) {
					Object result = constraints.get(figure);
					if(result == null) {
						result = new Rectangle(0, 0, -1, -1);
					}
					return result;
				}
			});
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * Overrides to add a specific locator on the ContinuationEditPart
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#addBorderItem(org.eclipse.draw2d.IFigure,
	 *      org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart)
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof ContinuationEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new ContinuationLocator(getMainFigure(), getContinuationPosition(borderItemEditPart)));
			return;
		}
		super.addBorderItem(borderItemContainer, borderItemEditPart);
	}

	/**
	 * Get the initial position of the continuation
	 * 
	 * @param borderItemEditPart
	 *        the borderItemEditPart
	 * @return the initial position. ContinuationLocator.BOTTOM if none found
	 */
	private int getContinuationPosition(IBorderItemEditPart borderItemEditPart) {
		Object model = borderItemEditPart.getModel();
		if(model instanceof org.eclipse.gmf.runtime.notation.Shape) {
			org.eclipse.gmf.runtime.notation.Shape shape = (org.eclipse.gmf.runtime.notation.Shape)model;
			EObject eObject = shape.getElement();
			if(eObject instanceof Continuation) {
				return ((Continuation)eObject).isSetting() ? PositionConstants.SOUTH : PositionConstants.NORTH;
			}
		}
		return PositionConstants.NORTH;
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof NodeFigure){
			((NodeFigure)primaryShape).setLineWidth(width);
		}else if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public class CustomInteractionOperandFigure extends InteractionOperandFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fInteractionConstraintLabel;

		/**
		 * @generated
		 */
		public CustomInteractionOperandFigure() {
			// this.setLayoutManager(new XYLayout());
			// Fixed bug id=364701 (https://bugs.eclipse.org/bugs/show_bug.cgi?id=364701)
			// by using StackLayout instead of XYLayout
			this.setLayoutManager(new XYLayout());

			this.setLineStyle(Graphics.LINE_DASH);

			this.setBorder(null);

			this.setLineSeparator(!firstOperand);
			this.setLineWidth(2);
			createContents();
		}
		
		protected void paintBackground(Graphics graphics, Rectangle rectangle) {
			graphics.pushState();
			super.paintBackground(graphics, rectangle);
			graphics.popState();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {
			fInteractionConstraintLabel = new WrappingLabel();
			fInteractionConstraintLabel.setText("");
			updateConstraintLabel();

			this.add(fInteractionConstraintLabel, new Rectangle(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10), getMapMode().DPtoLP(200), getMapMode().DPtoLP(20)));

		}

		/**
		 * Update the interaction constraint value
		 * 
		 * @param interactionOperand
		 *        The UML Interaction Operand
		 */
		protected void updateConstraintLabel() {
			String text = "";
			EObject parserElement = getParserElement();
			if(parserElement != null && getParser() != null) {
				text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
			}
			fInteractionConstraintLabel.setText(text);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getInteractionConstraintLabel() {
			return fInteractionConstraintLabel;
		}

	}

	static String getGuardLabelText(InteractionOperand interactionOperand , boolean edit ){
		CombinedFragment enclosingCF = (CombinedFragment)interactionOperand.getOwner();
		InteractionOperatorKind cfOperator = enclosingCF.getInteractionOperator();

		InteractionConstraint guard = interactionOperand.getGuard();

		String specValue = null;

		if(guard != null) {
			ValueSpecification specification = guard.getSpecification();

			if(specification != null) {
				try {
					specValue = specification.stringValue();
				} catch (Exception e) {
				}
			}
		}

		StringBuilder sb = new StringBuilder("");

		if(InteractionOperatorKind.LOOP_LITERAL.equals(cfOperator)) {
			Integer minValue = null;
			Integer maxValue = null;
			if(guard != null) {
				ValueSpecification maxint = guard.getMaxint();
				try {
					maxValue = maxint.integerValue();
				} catch (Exception e) {
				}
				ValueSpecification minint = guard.getMinint();
				try {
					minValue = minint.integerValue();
				} catch (Exception e) {
				}
			}

//			if(minValue == null && maxValue == null) {
//				minValue = 0;
//				maxValue = -1;
//			} else if(minValue == null) {
//				minValue = 0;
//			} else if(maxValue == null) {
//				maxValue = minValue;
//			}

			if(minValue != null && maxValue != null) {
				sb.append('[');
				sb.append(minValue);
				if(minValue != maxValue) {
					sb.append(',');
					if(maxValue == -1) {
						sb.append('*');
					} else {
						sb.append(maxValue);
					}
				}
				sb.append(']');
	
				if(specValue != null && specValue.length() > 0) {
					sb.append(' ');
				}
			}
		}

		if(specValue == null) {
			EList<InteractionOperand> operands = enclosingCF.getOperands();
			if(InteractionOperatorKind.ALT_LITERAL.equals(cfOperator) && interactionOperand.equals(operands.get(operands.size() - 1))) {
				specValue = "else";
			}
		}

		if(specValue != null) {
			if(!edit) sb.append('[');
			sb.append(specValue);
			if(!edit) sb.append(']');
		}
		String text = sb.toString();
		return text;
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
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("InteractionOperand", PreferenceConstantHelper.COLOR_GRADIENT);
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(9);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.DurationConstraint_3023);
		}
		return types;
	}

	/**
	 * Handle guard modification and update label.
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		Object newValue = notification.getNewValue();
		if(UMLPackage.eINSTANCE.getInteractionOperand_Guard().equals(feature)) {
			// Case of add, change or delete guard
			if(notification.getOldValue() instanceof InteractionConstraint) {
				InteractionConstraint constraint = (InteractionConstraint)notification.getOldValue();
				notifierHelper.unlistenObject(constraint);
				notifierHelper.unlistenObject(constraint.getSpecification());
				notifierHelper.unlistenObject(constraint.getMaxint());
				notifierHelper.unlistenObject(constraint.getMinint());
			}
			if(newValue instanceof InteractionConstraint) {
				InteractionConstraint constraint = (InteractionConstraint)newValue;
				notifierHelper.listenObject(constraint);
				notifierHelper.listenObject(constraint.getSpecification());
				notifierHelper.listenObject(constraint.getMaxint());
				notifierHelper.listenObject(constraint.getMinint());
			}
		} else if(UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature)) {
			// Case of add, change or delete Specification
			if(notification.getOldValue() instanceof ValueSpecification) {
				notifierHelper.unlistenObject((ValueSpecification)notification.getOldValue());
			}
			if(newValue instanceof ValueSpecification) {
				ValueSpecification newStringValue = (ValueSpecification)newValue;
				notifierHelper.listenObject(newStringValue);
			}
		} else if(UMLPackage.eINSTANCE.getInteractionConstraint_Minint().equals(feature)) {
			// Case of add, change or delete Minint
			if(notification.getOldValue() instanceof LiteralInteger) {
				notifierHelper.unlistenObject((LiteralInteger)notification.getOldValue());
			}
			if(newValue instanceof LiteralInteger) {
				LiteralInteger newIntegerValue = (LiteralInteger)newValue;
				notifierHelper.listenObject(newIntegerValue);
			}
		} else if(UMLPackage.eINSTANCE.getInteractionConstraint_Maxint().equals(feature)) {
			// Case of add, change or delete Maxint
			if(notification.getOldValue() instanceof LiteralInteger) {
				notifierHelper.unlistenObject((LiteralInteger)notification.getOldValue());
			}
			if(newValue instanceof LiteralInteger) {
				LiteralInteger newIntegerValue = (LiteralInteger)newValue;
				notifierHelper.listenObject(newIntegerValue);
			}
		}

		// handle modification of minint et maxint to match constraints min <= max and min >= 0
		if(notification.getNotifier() instanceof LiteralInteger && InteractionOperatorKind.LOOP_LITERAL.equals(getInteractionOperator())) {
			LiteralInteger literalIntNotifier = (LiteralInteger)notification.getNotifier();
			EStructuralFeature containingFeature = literalIntNotifier.eContainingFeature();
			if(UMLPackage.eINSTANCE.getInteractionConstraint_Minint().equals(containingFeature)) {
				InteractionConstraint constraint = (InteractionConstraint)literalIntNotifier.getOwner();
				if(newValue instanceof Integer) {
					Integer newMin = (Integer)newValue;
					if(newMin < 0) {
						literalIntNotifier.setValue(0);
					}
					if(constraint.getMaxint() instanceof LiteralInteger) {
						int max = ((LiteralInteger)constraint.getMaxint()).getValue();
						if(newMin > max) {
							literalIntNotifier.setValue(max);
						}
					}
				}
			} else if(UMLPackage.eINSTANCE.getInteractionConstraint_Maxint().equals(containingFeature)) {
				InteractionConstraint constraint = (InteractionConstraint)literalIntNotifier.getOwner();
				if(newValue instanceof Integer) {
					Integer newMax = (Integer)newValue;
					int min = 0;
					if(constraint.getMinint() instanceof LiteralInteger) {
						min = ((LiteralInteger)constraint.getMinint()).getValue();
						if(newMax < min) {
							literalIntNotifier.setValue(min);
						}
					}
				}
			}
		}
		getPrimaryShape().updateConstraintLabel();

		// Manage Continuation constraint on covered lifeline :
		// Continuations are always global in the enclosing InteractionFragment 
		//(e.g., it always covers all Lifelines covered by the enclosing InteractionFragment)
		if(UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)) {
			// In case we are in an alternative combined fragment, this interaction operand may have continuation which need to be updated.
			if(InteractionOperatorKind.ALT_LITERAL.equals(getInteractionOperator())) {
				InteractionOperand interactionOperand = (InteractionOperand)notification.getNotifier();
				EList<Lifeline> currentlyCoveredLifeline = interactionOperand.getCovereds();
				for(InteractionFragment interactionFragment : interactionOperand.getFragments()) {
					if(interactionFragment instanceof Continuation) {
						EList<Lifeline> continuationCoveredLifelines = interactionFragment.getCovereds();
						if(!continuationCoveredLifelines.equals(currentlyCoveredLifeline)) {
							// Add new covered lifelines (not already covered)
							List<Lifeline> coveredLifelinesToAdd = new ArrayList<Lifeline>(currentlyCoveredLifeline);
							coveredLifelinesToAdd.removeAll(continuationCoveredLifelines);
							if(!coveredLifelinesToAdd.isEmpty()) {
								CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToAdd),true);
							}

							// Delete old covered lifelines (not covered anymore)
							List<Lifeline> coveredLifelinesToRemove = new ArrayList<Lifeline>(continuationCoveredLifelines);
							coveredLifelinesToRemove.removeAll(currentlyCoveredLifeline);
							if(!coveredLifelinesToRemove.isEmpty()) {
								CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToRemove),true);
							}
						}
					}
				}
			}
		}
		super.handleNotificationEvent(notification);
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} 
		}
	}
	
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
        if ( style != null ) {
        	if ((style.getGradient() == null || !supportsGradient())) {	        	        	
            	if(16777215 == style.getFillColor()){  // default color
            		getPrimaryShape().setTransparency(100);
            		getPrimaryShape().setIsUsingGradient(true);
            		getPrimaryShape().setGradientData(style.getFillColor(), style.getFillColor(), 0);
            	}else{
            		refreshTransparency();
            		setBackgroundColor(DiagramColorRegistry.getInstance().getColor(Integer.valueOf(style.getFillColor())));
            	}
        	} else {
        		refreshTransparency();
        		setGradient(style.getGradient());
        	}        	
        }
    }
	
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}
	
	/**
	 * Override to set the gradient data to the correct figure
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		IPapyrusNodeFigure fig = getPrimaryShape();
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(gradient != null) {
			setTransparency(0);
			fig.setIsUsingGradient(true);
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}
	
	public boolean supportsGradient() {
		return true;
	}
	
	protected void setBackgroundColor(Color c) {
		PapyrusNodeFigure fig = getPrimaryShape();
		fig.setBackgroundColor(c);
		fig.setIsUsingGradient(false);
		fig.setGradientData(-1, -1, 0);
	}


	/**
	 * Get the InteractionOperator of the CombinedFragment.
	 * 
	 * @return The InteractionOperator
	 */
	private InteractionOperatorKind getInteractionOperator() {
		InteractionOperatorKind interactionOperatorKind = null;

		EditPart parent = getParent();
		if(parent instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			parent = parent.getParent();
			if(parent instanceof CombinedFragmentEditPart) {
				EObject element = ((CombinedFragmentEditPart)parent).resolveSemanticElement();
				if(element instanceof CombinedFragment) {
					interactionOperatorKind = ((CombinedFragment)element).getInteractionOperator();
				}
			}
		}

		return interactionOperatorKind;
	}

	/**
	 * Set if this Edit Part is the first Operand of his CombinedFragment's parent.
	 */
	public void setFirstOperand(boolean firstOperand) {
		this.firstOperand = firstOperand;
		if(primaryShape != null) {
			getPrimaryShape().setLineSeparator(!firstOperand);
		}
	}

	/**
	 * Activate listeners for InteractionOperand to handle notification in the guard
	 */
	@Override
	public void activate() {
		addListeners();
		super.activate();
	}

	/**
	 * Desactivate listeners for InteractionOperand to handle notification in the guard
	 */
	@Override
	public void deactivate() {
		notifierHelper.unlistenAll();
		super.deactivate();
	}

	/**
	 * Remove listeners for InteractionOperand to handle notification in the guard
	 */
	@Override
	public void removeNotify() {
		notifierHelper.unlistenAll();
		super.removeNotify();
	}

	/**
	 * Add listeners for InteractionOperand to handle notification in the guard
	 */
	private void addListeners() {
		EObject eObject = resolveSemanticElement();
		if(eObject instanceof InteractionOperand) {
			InteractionOperand interactionOperand = (InteractionOperand)eObject;
			InteractionConstraint guard = interactionOperand.getGuard();
			if(guard != null) {
				notifierHelper.listenObject(guard);
				notifierHelper.listenObject(guard.getSpecification());
				notifierHelper.listenObject(guard.getMaxint());
				notifierHelper.listenObject(guard.getMinint());
			}
		}
	}
	
	

	private DirectEditManager manager;
	private IParser parser;
	
	protected DirectEditManager getManager() {
		if(manager == null) {
			WrappingLabel label = this.getPrimaryShape().getInteractionConstraintLabel();
			manager = new TextDirectEditManager(this, WrapTextCellEditor.class, new UMLEditPartFactory.TextCellEditorLocator(label)); 
		}
		return manager;
	}

	protected void performDirectEditRequest(Request request) {
		if(request instanceof DirectEditRequest){
			WrappingLabel label = getPrimaryShape().getInteractionConstraintLabel();
			Point location = ((DirectEditRequest)request).getLocation().getCopy();			
			label.translateToRelative(location); // convert request location to relative			
			if(label.containsPoint(location))  // check if mouse click on label
				getManager().show();
		}
	}
	
	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	public IParser getParser() {
		if(parser == null) {
			parser = new GuardConditionParser(); 
		}
		return parser;		
	}

	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	public IContentAssistProcessor getCompletionProcessor() {
		if(getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
	}

	public String getEditText() {
		if(getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
	}
	
	public void setLabelText(String text) {
		WrappingLabel label = this.getPrimaryShape().getInteractionConstraintLabel();
		label.setText(text);
	}

	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {
			public String isValid(final Object value) {
				if(value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					if(element != null && parser != null){
						try {
							IParserEditStatus valid = (IParserEditStatus)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {
								public void run() {
									setResult(parser.isValidEditString(new EObjectAdapter(element), (String)value));
								}
							});
							return valid.getCode() == ParserEditStatus.EDITABLE ? null : valid.getMessage();
						} catch (InterruptedException ie) {
						}
					}
				}
				return null;
			}
		};
	}

	class GuardConditionDirectEditPolicy extends DirectEditPolicy{

		@Override
		protected Command getDirectEditCommand(DirectEditRequest edit) {
			String labelText = (String) edit.getCellEditor().getValue();
			
			//for CellEditor, null is always returned for invalid values
			if (labelText == null) {
				return null;
			}
			
			ITextAwareEditPart compartment = (ITextAwareEditPart) getHost();
			EObject model = (EObject)compartment.getModel();
			EObjectAdapter elementAdapter = null ;
			if (model instanceof View) {
	            View view = (View)model;
				elementAdapter = new EObjectAdapterEx(ViewUtil.resolveSemanticElement(view),
					view);
	        }
			else
				elementAdapter = new EObjectAdapterEx(model, null);
			
			String prevText = compartment.getParser().getEditString(elementAdapter,
				compartment.getParserOptions().intValue());
			// check to make sure an edit has occurred before returning a command.
			if (!prevText.equals(labelText)) {
				ICommand iCommand = 
					compartment.getParser().getParseCommand(elementAdapter, labelText, 0);
				return new ICommandProxy(iCommand);
			}		
			
			// refresh label again 
			getPrimaryShape().updateConstraintLabel();
			return null;
		}

		@Override
		protected void showCurrentEditValue(DirectEditRequest request) {
			String value = (String) request.getCellEditor().getValue();
			WrappingLabel label = getPrimaryShape().getInteractionConstraintLabel();
			label.setText(value);
		}
	}
	
	static class UpdateGuardConditionCommand extends AbstractTransactionalCommand {
		
		private InteractionConstraint guard;
		private String text;
		private InteractionOperand interactionOperand;

		public UpdateGuardConditionCommand(TransactionalEditingDomain domain,InteractionOperand interactionOperand, InteractionConstraint guard, String text) {
			super(domain, null, null);
			this.interactionOperand = interactionOperand;
			this.guard = guard;
			this.text = text;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CombinedFragment enclosingCF = (CombinedFragment)interactionOperand.getOwner();
			InteractionOperatorKind cfOperator = enclosingCF.getInteractionOperator();
			if(InteractionOperatorKind.LOOP_LITERAL.equals(cfOperator)){
				if(text.contains("]") && text.contains("[") ){
					String[] parts = text.split("]");
					String[] nums = parts[0].replaceAll("\\[", "").split(",");
					int min = 0, max = -1;
					min = parseInt(nums[0], 0);
					max = nums.length > 1 ? parseInt(nums[1], -1) : min;
					
					if(guard.getMinint() != null)
						setIntValue( guard.getMinint() ,min);
					else
						guard.setMinint(createLiteralInteger(min));					
					if(guard.getMaxint() != null)
						setIntValue( guard.getMaxint() ,max);
					else
						guard.setMaxint(createLiteralInteger(max));
					
					if(parts.length > 1)
						text = parts[1] == null? "" : parts[1].trim();
					else
						text = "";
				}else{
					guard.setMinint(null);
					guard.setMaxint(null);
				}
			}
			if(guard.getSpecification() != null || text.length() > 0){
				LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
				literalString.setValue(text);
				guard.setSpecification(literalString);
			}
			return CommandResult.newOKCommandResult();
		}
		
		private LiteralInteger createLiteralInteger(int val){
			LiteralInteger li = UMLFactory.eINSTANCE.createLiteralInteger();
			li.setValue(val);
			return li;
		}

		private void setIntValue(ValueSpecification spec, int val) {
			if(spec instanceof LiteralInteger){
				((LiteralInteger)spec).setValue(val);
			}
		}

		private int parseInt(String string, int defaultInt) {
			try {
				return Integer.parseInt(string);
			} catch (NumberFormatException e) {
			}
			return defaultInt;
		}
	}
	
	
	static class GuardConditionParser extends MessageFormatParser implements ISemanticParser {
		public GuardConditionParser() {
			super(new EAttribute[]{ UMLPackage.eINSTANCE.getLiteralInteger_Value(),	UMLPackage.eINSTANCE.getLiteralString_Value()  });
		}

		public List getSemanticElementsBeingParsed(EObject element) {
			List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
			if(element instanceof InteractionOperand) {
				InteractionOperand op = (InteractionOperand)element;
				semanticElementsBeingParsed.add(op);
				semanticElementsBeingParsed.add(op.getGuard() );
			}
			return semanticElementsBeingParsed;
		}

		public boolean areSemanticElementsAffected(EObject listener, Object notification) {
			EStructuralFeature feature = getEStructuralFeature(notification);
			return isValidFeature(feature);
		}
		
		public boolean isAffectingEvent(Object event, int flags) {
			EStructuralFeature feature = getEStructuralFeature(event);
			return isValidFeature(feature);
		}
		
		public String getPrintString(IAdaptable element, int flags) {
			Object adapter = element.getAdapter(EObject.class);
			if(adapter instanceof InteractionOperand) {
				InteractionOperand interactionOperand = (InteractionOperand)adapter;
				return getGuardLabelText(interactionOperand, false);
			}
			return "";
		}
		
		@Override
		public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
			return ParserEditStatus.EDITABLE_STATUS;
		}
		
		@Override
		public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
			EObject element = (EObject)adapter.getAdapter(EObject.class);
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
			if(editingDomain == null || !(element instanceof InteractionOperand )) {
				return UnexecutableCommand.INSTANCE;
			}
			
			InteractionOperand interactionOperand = (InteractionOperand)element;
			InteractionConstraint guard = interactionOperand.getGuard();
			CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
			command.compose(new UpdateGuardConditionCommand(editingDomain, interactionOperand, guard, newString ));
			return command;
		}
		
		@Override
		public String getEditString(IAdaptable element, int flags) {
			Object adapter = element.getAdapter(EObject.class);
			if(adapter instanceof InteractionOperand) {
				InteractionOperand interactionOperand = (InteractionOperand)adapter;
				return getGuardLabelText(interactionOperand, true);
			}
			return "";
		}
 
		protected EStructuralFeature getEStructuralFeature(Object notification) {
			EStructuralFeature featureImpl = null;
			if(notification instanceof Notification) {
				Object feature = ((Notification)notification).getFeature();
				if(feature instanceof EStructuralFeature) {
					featureImpl = (EStructuralFeature)feature;
				}
			}
			return featureImpl;
		}

		private boolean isValidFeature(EStructuralFeature feature) {
			return UMLPackage.eINSTANCE.getInteractionConstraint_Maxint().equals(feature) || UMLPackage.eINSTANCE.getInteractionConstraint_Minint().equals(feature) || UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature);
		}
	}
	
	static class EObjectAdapterEx	extends EObjectAdapter {
		private View view = null;
	
		/**
		 * constructor
		 * @param element	element to be wrapped
		 * @param view	view to be wrapped
		 */
		public EObjectAdapterEx(EObject element, View view) {
			super(element);
			this.view = view;
		}
	
		public Object getAdapter(Class adapter) {
			Object o = super.getAdapter(adapter);
			if (o != null)
				return o;
			if (adapter.equals(View.class)) {
				return view;
			}
			return null;
		}
	}
 
}
