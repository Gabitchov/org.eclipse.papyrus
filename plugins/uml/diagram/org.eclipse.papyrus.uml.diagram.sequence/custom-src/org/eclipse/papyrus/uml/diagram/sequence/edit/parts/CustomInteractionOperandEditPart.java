/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.ReconnectRequest;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.WrapTextCellEditor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart.DummyCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandGuardEditPart.GuardFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CombinedFragmentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandAppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionOperandItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.ContinuationLocator;
import org.eclipse.papyrus.uml.diagram.sequence.locator.TextCellEditorLocator;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.InteractionOperandModelElementFactory;
import org.eclipse.papyrus.uml.diagram.sequence.util.LoopOperatorUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
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
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionOperandEditPart extends InteractionOperandEditPart implements ITextAwareEditPart, IPapyrusEditPart {

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifierHelper = null;

	private DirectEditManager manager;

	private IParser parser;

	private boolean firstOperand;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionOperandEditPart(View view) {
		super(view);
	}

	/**
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifierHelper() {
		if(notifierHelper == null) {
			try {
				Field f = InteractionOperandEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifierHelper = (NotificationHelper)f.get(this);
			} catch (Exception e) {
				notifierHelper = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifierHelper;
	}

	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof NodeFigure) {
			((NodeFigure)primaryShape).setLineWidth(width);
		}
		super.setLineWidth(width);
	}

	/**
	 * Remove EditPolicyRoles.DRAG_DROP_ROLE and EditPolicy.PRIMARY_DRAG_ROLE :
	 * - adding elements to an interactionOperand doesn't anymore resize the enclosing CF
	 * - interactionOperand are no longer dNd
	 * 
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CombinedFragmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionOperandItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new GuardConditionDirectEditPolicy());
		removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
		// display stereotype
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new InteractionOperandAppliedStereotypeLabelDisplayEditPolicy());
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

	static String getGuardLabelText(InteractionOperand interactionOperand, boolean edit) {
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
			String condition = LoopOperatorUtil.getLoopCondition(guard);
			if(condition != null) {
				sb.append(condition);
			}
		}
		if(specValue == null) {
			EList<InteractionOperand> operands = enclosingCF.getOperands();
			if(InteractionOperatorKind.ALT_LITERAL.equals(cfOperator) && interactionOperand.equals(operands.get(operands.size() - 1))) {
				specValue = "else";
			}
		}
		if(specValue != null) {
			if(!edit) {
				sb.append('[');
			}
			sb.append(specValue);
			if(!edit) {
				sb.append(']');
			}
		}
		String text = sb.toString();
		return text;
	}

	/**
	 * Handle guard modification and update label.
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifierHelper = getNotifierHelper();
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
						if(max != -1 && newMin > max) {
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
						if(newMax != -1 && newMax < min) {
							literalIntNotifier.setValue(min);
						}
					}
				}
			}
		}
		updateConstraintLabel();
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
								CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToAdd), true);
							}
							// Delete old covered lifelines (not covered anymore)
							List<Lifeline> coveredLifelinesToRemove = new ArrayList<Lifeline>(continuationCoveredLifelines);
							coveredLifelinesToRemove.removeAll(currentlyCoveredLifeline);
							if(!coveredLifelinesToRemove.isEmpty()) {
								CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToRemove), true);
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
		if(ElementIconUtil.isIconNotification(notification)) {
			refreshLabelIcon();
		}
		if(InteractionOperandModelElementFactory.isGuardVisibilityChanged(notification)) {
			refreshChildren();
			refreshGuard();
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getModelChildren()
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List getModelChildren() {
		List modelChildren = new ArrayList(super.getModelChildren());
		if(!isGuardVisible()) {
			List result = new ArrayList();
			for(Object object : modelChildren) {
				if(object instanceof View && InteractionOperandGuardEditPart.GUARD_TYPE.equals(((View)object).getType())) {
					continue;
				}
				result.add(object);
			}
			return result;
		} else {
			boolean hasGuardChild = false;
			for(Object object : modelChildren) {
				if(object instanceof View && InteractionOperandGuardEditPart.GUARD_TYPE.equals(((View)object).getType())) {
					hasGuardChild = true;
					break;
				}
			}
			if(!hasGuardChild) {
				final View view = getNotationView();
				final DecorationNode guardNode = NotationFactory.eINSTANCE.createDecorationNode();
				Bounds b = NotationFactory.eINSTANCE.createBounds();
				b.setX(5);
				b.setY(5);
				guardNode.setLayoutConstraint(b);
				guardNode.setType(InteractionOperandGuardEditPart.GUARD_TYPE);
				if(view.getElement() instanceof InteractionOperand) {
					guardNode.setElement(((InteractionOperand)view.getElement()).getGuard());
				}
				CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {

					@Override
					public void execute() {
						ViewUtil.insertChildView(view, guardNode, ViewUtil.APPEND, true);
					}
				}, true);
				modelChildren.add(guardNode);
			}
		}
		return modelChildren;
	}

	/**
	 * //Show or Hide Guard:
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402966
	 */
	public boolean isGuardVisible() {
		return InteractionOperandModelElementFactory.isGuardVisible(getPrimaryView());
	}

	protected void refreshLabelIcon() {
		Image image = ElementIconUtil.getLabelIcon(this);
		getInteractionConstraintLabel().setIcon(image);
	}

	/**
	 * @return Guard label
	 */
	public WrappingLabel getInteractionConstraintLabel() {
		IGraphicalEditPart child = getChildBySemanticHint(InteractionOperandGuardEditPart.GUARD_TYPE);
		if(child instanceof InteractionOperandGuardEditPart) {
			IFigure figure = ((InteractionOperandGuardEditPart)child).getFigure();
			if(figure instanceof WrappingLabel) {
				return ((WrappingLabel)figure);
			} else if(figure instanceof GuardFigure) {
				return ((GuardFigure)figure).getPrimaryLabel();
			}
		}
		return getPrimaryShape().getInteractionConstraintLabel();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabelIcon();
		refreshTransparency();
		refreshGuard();
	}

	/**
	 * refresh guard label.
	 */
	protected void refreshGuard() {
		IGraphicalEditPart guard = getChildBySemanticHint(InteractionOperandGuardEditPart.GUARD_TYPE);
		if(!(guard instanceof InteractionOperandGuardEditPart)) {
			return;
		}
		((InteractionOperandGuardEditPart)guard).refreshLabel();
		// Refresh Stereotypes.
		EditPolicy editPolicy = getEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
		if(editPolicy instanceof AppliedStereotypeLabelDisplayEditPolicy) {
			((AppliedStereotypeLabelDisplayEditPolicy)editPolicy).refreshDisplay();
		}
	}

	@Override
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style != null) {
			if((style.getGradient() == null || !supportsGradient())) {
				if(16777215 == style.getFillColor()) { // default color
					getPrimaryShape().setTransparency(100);
					getPrimaryShape().setIsUsingGradient(true);
					getPrimaryShape().setGradientData(style.getFillColor(), style.getFillColor(), 0);
				} else {
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

	@Override
	public boolean supportsGradient() {
		return true;
	}

	@Override
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
		if(notifierHelper != null) {
			notifierHelper.unlistenAll();
		}
		super.deactivate();
	}

	/**
	 * Remove listeners for InteractionOperand to handle notification in the guard
	 */
	@Override
	public void removeNotify() {
		if(notifierHelper != null) {
			notifierHelper.unlistenAll();
		}
		super.removeNotify();
	}

	/**
	 * Add listeners for InteractionOperand to handle notification in the guard
	 */
	private void addListeners() {
		final NotificationHelper notifierHelper = getNotifierHelper();
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

	protected DirectEditManager getManager() {
		if(manager == null) {
			WrappingLabel label = getInteractionConstraintLabel();
			manager = new TextDirectEditManager(this, WrapTextCellEditor.class, new TextCellEditorLocator(label));
		}
		return manager;
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		if(request instanceof DirectEditRequest) {
			//Show or Hide Guard: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402966
			if(!isGuardVisible()) {
				return;
			}
			WrappingLabel label = getPrimaryShape().getInteractionConstraintLabel();
			Point location = ((DirectEditRequest)request).getLocation().getCopy();
			label.translateToRelative(location); // convert request location to relative			
			if(label.containsPoint(location)) {
				getManager().show();
			}
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
					if(element != null && parser != null) {
						try {
							IParserEditStatus valid = (IParserEditStatus)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

								public void run() {
									setResult(parser.isValidEditString(new EObjectAdapter(element), (String)value));
								}
							});
							return valid.getCode() == IParserEditStatus.EDITABLE ? null : valid.getMessage();
						} catch (InterruptedException ie) {
						}
					}
				}
				return null;
			}
		};
	}

	public boolean ignoreRequest(Request request) {
		if(request instanceof ChangeBoundsRequest && (request.getType().equals(org.eclipse.gef.RequestConstants.REQ_ADD) || request.getType().equals(RequestConstants.REQ_DROP))) {
			List parts = ((ChangeBoundsRequest)request).getEditParts();
			if(parts != null) {
				for(Object obj : parts) {
					if(obj instanceof CommentEditPart || obj instanceof ConstraintEditPart || obj instanceof TimeObservationEditPart) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void showTargetFeedback(Request request) {
		if(ignoreRequest(request)) {
			return;
		}
		super.showTargetFeedback(request);
	}

	@Override
	public Command getCommand(Request request) {
		if(ignoreRequest(request)) {
			return null;
		}
		if(request instanceof ReconnectRequest) {
			if(REQ_RECONNECT_SOURCE.equals(request.getType()) && ((ReconnectRequest)request).getConnectionEditPart().getSource() instanceof GateEditPart) {
				return getParent().getParent().getCommand(request);
			} else if(REQ_RECONNECT_TARGET.equals(request.getType()) && ((ReconnectRequest)request).getConnectionEditPart().getTarget() instanceof GateEditPart) {
				return getParent().getParent().getCommand(request);
			}
		}
		return super.getCommand(request);
	}

	@Override
	protected void refreshTransparency() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style != null) {
			setTransparency(style.getTransparency());
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomCustomInteractionOperandFigure();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public CustomCustomInteractionOperandFigure getPrimaryShape() {
		return (CustomCustomInteractionOperandFigure)primaryShape;
	}

	/**
	 * Update guard.
	 */
	public void updateConstraintLabel() {
		IGraphicalEditPart child = getChildBySemanticHint(InteractionOperandGuardEditPart.GUARD_TYPE);
		if(child instanceof InteractionOperandGuardEditPart) {
			child.refresh();
		}
	}

	public class CustomCustomInteractionOperandFigure extends CustomInteractionOperandFigure {

		/**
		 * Constructor.
		 * 
		 */
		public CustomCustomInteractionOperandFigure() {
			super();
			this.setLineWidth(2);
			setLineSeparator(!firstOperand);
			//Make the label as a child now, see InteractionOperandGuardEditPart.
			getInteractionConstraintLabel().setVisible(false);
		}

		/**
		 * @see org.eclipse.draw2d.Figure#useLocalCoordinates()
		 * 
		 * @return
		 */
		@Override
		protected boolean useLocalCoordinates() {
			return true;
		}

		protected void paintBackground(Graphics graphics, Rectangle rectangle) {
			graphics.pushState();
			super.paintBackground(graphics, rectangle);
			graphics.popState();
		}

		/**
		 * Update the interaction constraint value
		 * 
		 * @param interactionOperand
		 *        The UML Interaction Operand
		 */
		protected void updateConstraintLabel() {
			//Show or Hide Guard: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402966
			if(!isGuardVisible()) {
				getInteractionConstraintLabel().setText("");
			} else {
				String text = "";
				EObject parserElement = getParserElement();
				if(parserElement != null && getParser() != null) {
					text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
				}
				getInteractionConstraintLabel().setText(text);
			}
		}
	}

	class GuardConditionDirectEditPolicy extends DirectEditPolicy {

		@Override
		protected Command getDirectEditCommand(DirectEditRequest edit) {
			String labelText = (String)edit.getCellEditor().getValue();
			//for CellEditor, null is always returned for invalid values
			if(labelText == null) {
				return null;
			}
			ITextAwareEditPart compartment = (ITextAwareEditPart)getHost();
			EObject model = (EObject)compartment.getModel();
			EObjectAdapter elementAdapter = null;
			if(model instanceof View) {
				View view = (View)model;
				elementAdapter = new EObjectAdapterEx(ViewUtil.resolveSemanticElement(view), view);
			} else
				elementAdapter = new EObjectAdapterEx(model, null);
			String prevText = compartment.getParser().getEditString(elementAdapter, compartment.getParserOptions().intValue());
			// check to make sure an edit has occurred before returning a command.
			if(!prevText.equals(labelText)) {
				ICommand iCommand = compartment.getParser().getParseCommand(elementAdapter, labelText, 0);
				return new ICommandProxy(iCommand);
			}
			// refresh label again 
			getPrimaryShape().updateConstraintLabel();
			return null;
		}

		@Override
		protected void showCurrentEditValue(DirectEditRequest request) {
			String value = (String)request.getCellEditor().getValue();
			WrappingLabel label = getPrimaryShape().getInteractionConstraintLabel();
			label.setText(value);
		}
	}

	private static class UpdateGuardConditionCommand extends AbstractTransactionalCommand {

		private InteractionConstraint guard;

		private String text;

		private InteractionOperand interactionOperand;

		public UpdateGuardConditionCommand(TransactionalEditingDomain domain, InteractionOperand interactionOperand, InteractionConstraint guard, String text) {
			super(domain, null, null);
			this.interactionOperand = interactionOperand;
			this.guard = guard;
			this.text = text;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CombinedFragment enclosingCF = (CombinedFragment)interactionOperand.getOwner();
			InteractionOperatorKind cfOperator = enclosingCF.getInteractionOperator();
			if(InteractionOperatorKind.LOOP_LITERAL.equals(cfOperator)) {
				if(text.contains("]") && text.contains("[")) {
					String[] parts = text.split("]");
					String[] nums = parts[0].replaceAll("\\[", "").split(",");
					int min = 0, max = -1;
					min = parseInt(nums[0], 0);
					max = nums.length > 1 ? parseInt(nums[1], -1) : min;
					if(guard.getMinint() != null)
						setIntValue(guard.getMinint(), min);
					else
						guard.setMinint(createLiteralInteger(min));
					if(guard.getMaxint() != null)
						setIntValue(guard.getMaxint(), max);
					else
						guard.setMaxint(createLiteralInteger(max));
					if(parts.length > 1)
						text = parts[1] == null ? "" : parts[1].trim();
					else
						text = "";
				} else {
					guard.setMinint(null);
					guard.setMaxint(null);
				}
			}
			if(guard.getSpecification() != null || text.length() > 0) {
				LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
				literalString.setValue(text);
				guard.setSpecification(literalString);
			}
			return CommandResult.newOKCommandResult();
		}

		private LiteralInteger createLiteralInteger(int val) {
			LiteralInteger li = UMLFactory.eINSTANCE.createLiteralInteger();
			li.setValue(val);
			return li;
		}

		private void setIntValue(ValueSpecification spec, int val) {
			if(spec instanceof LiteralInteger) {
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

	private static class GuardConditionParser extends MessageFormatParser implements ISemanticParser {

		public GuardConditionParser() {
			super(new EAttribute[]{ UMLPackage.eINSTANCE.getLiteralInteger_Value(), UMLPackage.eINSTANCE.getLiteralString_Value() });
		}

		public List getSemanticElementsBeingParsed(EObject element) {
			List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
			if(element instanceof InteractionOperand) {
				InteractionOperand op = (InteractionOperand)element;
				semanticElementsBeingParsed.add(op);
				semanticElementsBeingParsed.add(op.getGuard());
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
			if(editingDomain == null || !(element instanceof InteractionOperand)) {
				return UnexecutableCommand.INSTANCE;
			}
			InteractionOperand interactionOperand = (InteractionOperand)element;
			InteractionConstraint guard = interactionOperand.getGuard();
			CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
			command.compose(new UpdateGuardConditionCommand(editingDomain, interactionOperand, guard, newString));
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

	private static class EObjectAdapterEx extends EObjectAdapter {

		private View view = null;

		/**
		 * constructor
		 * 
		 * @param element
		 *        element to be wrapped
		 * @param view
		 *        view to be wrapped
		 */
		public EObjectAdapterEx(EObject element, View view) {
			super(element);
			this.view = view;
		}

		public Object getAdapter(Class adapter) {
			Object o = super.getAdapter(adapter);
			if(o != null)
				return o;
			if(adapter.equals(View.class)) {
				return view;
			}
			return null;
		}
	}
}
