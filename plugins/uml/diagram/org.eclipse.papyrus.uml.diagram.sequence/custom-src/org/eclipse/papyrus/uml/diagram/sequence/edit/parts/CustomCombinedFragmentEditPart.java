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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
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
import org.eclipse.gef.tools.DirectEditManager;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.ShadowFigureHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GateCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GatesHolderGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomCombinedFragmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.CombinedFragmentFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.locator.TextCellEditorLocator;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.InteractionOperatorKindCompatibleMapping;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineCoveredByUpdater;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragmentEditPart extends CombinedFragmentEditPart implements ITextAwareEditPart {

	/**
	 * Title for dialog of bloc operator modification error
	 */
	private static final String FORBIDDEN_ACTION = "Forbidden action"; //$NON-NLS-1$

	/**
	 * Message for dialog of block operator modification
	 */
	private static final String BLOCK_OPERATOR_MODIFICATION_MSG = "It's impossible to change the operator kind of the combined fragment\nbecause the combined fragment has more than one operand"; //$NON-NLS-1$

	/**
	 * Message for dialog of block forbidden operator modification
	 */
	private static final String FORBIDEN_OPERATOR_MODIFICATION_MSG = "It's impossible to configure combined fragment as consider or ignore.\nUse ConsiderIgnoreFragment instead"; //$NON-NLS-1$

	/**
	 * Message for dialog of block forbidden operand addition
	 */
	private static final String BLOCK_OPERAND_ADDITION_MSG = "It's impossible to add more than one operand on opt, loop, break, neg combined fragment"; //$NON-NLS-1$

	private DirectEditManager manager;

	private IParser parser;

	private IEclipsePreferences.IPreferenceChangeListener propertyListener;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomCombinedFragmentEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomCombinedFragmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new CombinedFragmentDirectEditPolicy());
		//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GatesHolderGraphicalNodeEditPolicy());
		installEditPolicy("Gate Creation Edit Policy", new GateCreationEditPolicy());
	}

	/**
	 * Generated not for handle operator kind
	 * 
	 * @Override
	 */
	@Override
	protected IFigure createNodeShape() {
		primaryShape = new CombinedFragmentFigure();
		updateHeaderLabel();
		return primaryShape;
	}

	/**
	 * Create a BorderedNodeFigure for holding Gates.
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		return new BorderedNodeFigure(super.createNodeFigure());
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	public final BorderedNodeFigure getBorderedFigure() {
		return (BorderedNodeFigure)getFigure();
	}

	@Override
	protected NodeFigure createNodePlate() {
		String prefElementId = "CombinedFragment";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new AnchorHelper.CombinedFragmentNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	/**
	 * @Override
	 */
	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof NodeFigure) {
			((NodeFigure)primaryShape).setLineWidth(width);
		} else {
			super.setLineWidth(width);
		}
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((CombinedFragmentCombinedFragmentCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof GateEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((GateEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart#addFixedChild(org.eclipse.gef.EditPart)
	 * 
	 * @param childEditPart
	 * @return
	 */
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof GateEditPart) {
			getBorderedFigure().getBorderItemContainer().add(((GateEditPart)childEditPart).getFigure(), new GateLocator(getFigure()));
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	public List<CustomInteractionOperandEditPart> getOperandChildrenEditParts() {
		List<CustomInteractionOperandEditPart> children = new LinkedList<CustomInteractionOperandEditPart>();
		IGraphicalEditPart compartment = getChildBySemanticHint(String.valueOf(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID));
		if(compartment instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			for(Object ep : compartment.getChildren()) {
				if(ep instanceof CustomInteractionOperandEditPart) {
					children.add((CustomInteractionOperandEditPart)ep);
				}
			}
		}
		return children;
	}

	/**
	 * Handle for interaction operator, operator kind and covered lifelines
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if(UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().equals(feature)) {
			CombinedFragment combinedFragment = (CombinedFragment)resolveSemanticElement();
			String newStringValue = notification.getNewStringValue();
			if(notification.getOldValue() instanceof InteractionOperatorKind && !isAllowedInteractionOperator(newStringValue)) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), FORBIDDEN_ACTION, FORBIDEN_OPERATOR_MODIFICATION_MSG);
				CommandHelper.executeCommandWithoutHistory(getEditingDomain(), SetCommand.create(getEditingDomain(), combinedFragment, feature, notification.getOldValue()), true);
				return;
			}
			EList<InteractionOperand> operands = combinedFragment.getOperands();
			if(operands == null || operands.size() <= 1) {
				// If CombinedFragment have no operand, we can change the
				// OperatorKind
				updateHeaderLabel();
			} else {
				if(notification.getOldValue() instanceof InteractionOperatorKind) {
					InteractionOperatorKind newValue = (InteractionOperatorKind)notification.getNewValue();
					if(!InteractionOperatorKindCompatibleMapping.supportMultiOperand(newValue)) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), FORBIDDEN_ACTION, BLOCK_OPERATOR_MODIFICATION_MSG);
						CommandHelper.executeCommandWithoutHistory(getEditingDomain(), SetCommand.create(getEditingDomain(), combinedFragment, feature, notification.getOldValue()), true);
					} else {
						updateHeaderLabel();
					}
				}
			}
			/*
			 * else if(notification.getOldValue() instanceof InteractionOperatorKind &&
			 * !newStringValue.equals(getPrimaryShape().getHeaderLabel().getText())) {
			 * MessageDialog.openError(Display.getCurrent().getActiveShell(), FORBIDDEN_ACTION, BLOCK_OPERATOR_MODIFICATION_MSG);
			 * CommandHelper.executeCommandWithoutHistory(getEditingDomain(), SetCommand.create(getEditingDomain(), combinedFragment, feature,
			 * notification.getOldValue()));
			 * return;
			 * }
			 */
			// update guards on enclosed operands
			for(CustomInteractionOperandEditPart ioep : getOperandChildrenEditParts()) {
				ioep.getPrimaryShape().updateConstraintLabel();
			}
		} else if(UMLPackage.eINSTANCE.getCombinedFragment_Operand().equals(feature)) {
			// Case only call by the model explorer
			CombinedFragment combinedFragment = (CombinedFragment)resolveSemanticElement();
			InteractionOperatorKind interactionOperator = combinedFragment.getInteractionOperator();
			Object newValue = notification.getNewValue();
			if(interactionOperator != null && newValue != null) {
				if(InteractionOperatorKind.OPT_LITERAL.equals(interactionOperator) || InteractionOperatorKind.LOOP_LITERAL.equals(interactionOperator) || InteractionOperatorKind.BREAK_LITERAL.equals(interactionOperator) || InteractionOperatorKind.NEG_LITERAL.equals(interactionOperator)) {
					EList<InteractionOperand> operands = combinedFragment.getOperands();
					if(operands != null && operands.size() > 1) {
						// Case of there is already an operand on opt, loop, break and neg
						// CombinedFragment type
						MessageDialog.openError(Display.getCurrent().getActiveShell(), FORBIDDEN_ACTION, BLOCK_OPERAND_ADDITION_MSG);
						CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), combinedFragment, feature, newValue), true);
						return;
					}
				}
			}
		} else if(UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)) {
			if(notification.getNotifier() instanceof CombinedFragment) {
				// Synchronize operands' covered lifelines with combined fragment's covered lifelines
				CombinedFragment combinedFragment = (CombinedFragment)notification.getNotifier();
				EList<Lifeline> combinedFragmentCoveredLifelines = combinedFragment.getCovereds();
				for(InteractionOperand operand : combinedFragment.getOperands()) {
					EList<Lifeline> operandCoveredLifelines = operand.getCovereds();
					if(!operandCoveredLifelines.equals(combinedFragmentCoveredLifelines)) {
						// Add new covered lifelines (not already covered)
						List<Lifeline> coveredLifelinesToAdd = new ArrayList<Lifeline>(combinedFragmentCoveredLifelines);
						coveredLifelinesToAdd.removeAll(operandCoveredLifelines);
						if(!coveredLifelinesToAdd.isEmpty()) {
							CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), operand, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToAdd), true);
						}
						// Delete old covered lifelines (not covered anymore)
						List<Lifeline> coveredLifelinesToRemove = new ArrayList<Lifeline>(operandCoveredLifelines);
						coveredLifelinesToRemove.removeAll(combinedFragmentCoveredLifelines);
						if(!coveredLifelinesToRemove.isEmpty()) {
							CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), operand, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToRemove), true);
						}
					}
				}
			}
		} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)) {
			if(notification.getNotifier() instanceof CombinedFragment) {
				refreshLabel();
			}
		}
		if(notification.getNewValue() instanceof EAnnotation && VisualInformationPapyrusConstants.QUALIFIED_NAME.equals(((EAnnotation)notification.getNewValue()).getSource())) {
			refreshLabel();
		}
		super.handleNotificationEvent(notification);
		//fixed bug (id=364711) when bounds changed update coveredBys with the figure's bounds.
		if(notification.getNotifier() instanceof Bounds) {
			if(notification.getNotifier() instanceof Bounds) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						LifelineCoveredByUpdater updater = new LifelineCoveredByUpdater();
						updater.update(CustomCombinedFragmentEditPart.this);
					}
				});
			}
		}
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		}
		if(resolveSemanticElement() != null) {
			refreshShadow();
		}
		if(ElementIconUtil.isIconNotification(notification)) {
			refreshLabelIcon();
		}
	}

	protected void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View)getModel()));
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
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
			fig.setIsUsingGradient(true);;
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
	 * Update header label
	 */
	protected void updateHeaderLabel() {
		Object element = resolveSemanticElement();
		if(element instanceof CombinedFragment) {
			CombinedFragment combinedFragment = (CombinedFragment)element;
			String operatorKind = combinedFragment.getInteractionOperator().getName();
			getPrimaryShape().getHeaderLabel().setText(operatorKind);
		}
	}

	/**
	 * Return true if the InteractionOperatorKind is allowed
	 * 
	 * @param interactionOperatorLiteral
	 *        The InteractionOperator to test
	 * @return true if allowed
	 */
	protected boolean isAllowedInteractionOperator(String interactionOperatorLiteral) {
		return !(InteractionOperatorKind.CONSIDER_LITERAL.getLiteral().equals(interactionOperatorLiteral) || InteractionOperatorKind.IGNORE_LITERAL.getLiteral().equals(interactionOperatorLiteral));
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		if(this.propertyListener == null) {
			this.propertyListener = new IEclipsePreferences.IPreferenceChangeListener() {

				public void preferenceChange(PreferenceChangeEvent event) {
					handlePreferenceChange(event);
				}
			};
			InstanceScope.INSTANCE.getNode("org.eclipse.papyrus.infra.gmfdiag.preferences").addPreferenceChangeListener(this.propertyListener);
		}
	}

	protected void handlePreferenceChange(PreferenceChangeEvent event) {
		if(getParent() == null) {
			return;
		}
		String key = event.getKey();
		if(key.equals(getTitlePreferenceKey())) {
			refreshLabel();
		}
	}

	public String getTitlePreferenceKey() {
		return "ELEMENT_PapyrusUMLSequenceDiagram_CombinedFragment_CombinedFragmentCompartment.compartment_name.visibility";
	}

	public WrappingLabel getTitleLabel() {
		return getPrimaryShape().getTitleLabel();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshLabelIcon();
	}

	protected void refreshLabelIcon() {
		Image image = ElementIconUtil.getLabelIcon(this);
		getPrimaryShape().getHeaderLabel().setIcon(image);
	}

	// update label visibility and text
	private void refreshLabel() {
		Object element = resolveSemanticElement();
		if(element instanceof CombinedFragment) {
			CombinedFragment combinedFragment = (CombinedFragment)element;
			String name = combinedFragment.getName();
			int depth = AppearanceHelper.getQualifiedNameDepth(this.getNotationView());
			if(depth == 0) { // full qualified
				name = combinedFragment.getQualifiedName();
			}
			WrappingLabel label = getPrimaryShape().getTitleLabel();
			label.setText(name);
			ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.papyrus.infra.gmfdiag.preferences");
			String visible = store.getString(getTitlePreferenceKey());
			label.setVisible("true".equals(visible));
		}
	}

	protected DirectEditManager getManager() {
		if(manager == null) {
			WrappingLabel label = this.getPrimaryShape().getTitleLabel();
			manager = new TextDirectEditManager(this, TextCellEditorEx.class, new TextCellEditorLocator(label) {

				@Override
				public void relocate(CellEditor celleditor) {
					Text text = (Text)celleditor.getControl();
					Rectangle rect = getWrapLabel().getBounds().getCopy();
					getWrapLabel().translateToAbsolute(rect);
					Point right = rect.getRight();
					if(!text.getFont().isDisposed()) {
						if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
							rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
						} else {
							int avr = org.eclipse.draw2d.FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
							rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
						}
						if(rect.getRight().x > right.x) { // should not exceed right border
							rect.translate(right.x - rect.getRight().x, 0);
						}
					}
					if(!rect.equals(new Rectangle(text.getBounds()))) {
						text.setBounds(rect.x, rect.y, rect.width, rect.height);
					}
				}
			});
		}
		return manager;
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		if(request instanceof DirectEditRequest) {
			WrappingLabel label = getPrimaryShape().getTitleLabel();
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
			parser = new CombinedFragmentTitleParser();
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
		WrappingLabel label = this.getPrimaryShape().getTitleLabel();
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

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy policy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		return policy != null ? policy : new ResizableShapeEditPolicyEx();
	}

	class CombinedFragmentDirectEditPolicy extends DirectEditPolicy {

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
			} else {
				elementAdapter = new EObjectAdapterEx(model, null);
			}
			String prevText = compartment.getParser().getEditString(elementAdapter, compartment.getParserOptions().intValue());
			// check to make sure an edit has occurred before returning a command.
			if(!prevText.equals(labelText)) {
				ICommand iCommand = compartment.getParser().getParseCommand(elementAdapter, labelText, 0);
				return new ICommandProxy(iCommand);
			}
			return null;
		}

		@Override
		protected void showCurrentEditValue(DirectEditRequest request) {
			String value = (String)request.getCellEditor().getValue();
			WrappingLabel label = getPrimaryShape().getTitleLabel();
			label.setText(value);
		}
	}

	static class CombinedFragmentTitleParser extends MessageFormatParser implements ISemanticParser {

		public CombinedFragmentTitleParser() {
			super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
		}

		public List getSemanticElementsBeingParsed(EObject element) {
			List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
			if(element instanceof CombinedFragment) {
				CombinedFragment cf = (CombinedFragment)element;
				semanticElementsBeingParsed.add(cf);
			}
			return semanticElementsBeingParsed;
		}

		public boolean areSemanticElementsAffected(EObject listener, Object notification) {
			EStructuralFeature feature = getEStructuralFeature(notification);
			return isValidFeature(feature);
		}

		@Override
		public boolean isAffectingEvent(Object event, int flags) {
			EStructuralFeature feature = getEStructuralFeature(event);
			return isValidFeature(feature);
		}

		@Override
		public String getPrintString(IAdaptable element, int flags) {
			Object adapter = element.getAdapter(EObject.class);
			if(adapter instanceof CombinedFragment) {
				CombinedFragment cf = (CombinedFragment)adapter;
				return cf.getName();
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
			if(editingDomain == null || !(element instanceof CombinedFragment)) {
				return UnexecutableCommand.INSTANCE;
			}
			SetRequest request = new SetRequest(element, UMLPackage.eINSTANCE.getNamedElement_Name(), newString);
			return new SetValueCommand(request);
		}

		@Override
		public String getEditString(IAdaptable element, int flags) {
			Object adapter = element.getAdapter(EObject.class);
			if(adapter instanceof CombinedFragment) {
				CombinedFragment cf = (CombinedFragment)adapter;
				return cf.getName();
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
			return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		}
	}

	static class EObjectAdapterEx extends EObjectAdapter {

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

		@Override
		public Object getAdapter(Class adapter) {
			Object o = super.getAdapter(adapter);
			if(o != null) {
				return o;
			}
			if(adapter.equals(View.class)) {
				return view;
			}
			return null;
		}
	}

	static class ResizableShapeEditPolicyEx extends ResizableShapeEditPolicy {

		@Override
		protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
			IFigure feedback = getDragSourceFeedbackFigure();
			PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
			getHostFigure().translateToAbsolute(rect);
			Rectangle old = rect.getCopy();
			rect.translate(request.getMoveDelta());
			rect.resize(request.getSizeDelta());
			IFigure f = getHostFigure();
			Dimension min = f.getMinimumSize().getCopy();
			Dimension max = f.getMaximumSize().getCopy();
			IMapMode mmode = MapModeUtil.getMapMode(f);
			min.height = mmode.LPtoDP(min.height);
			min.width = mmode.LPtoDP(min.width);
			max.height = mmode.LPtoDP(max.height);
			max.width = mmode.LPtoDP(max.width);
			if(min.width > rect.width) {
				rect.width = min.width;
				if(request.getMoveDelta().x > 0 && request.getSizeDelta().width < 0) { // shrinking from left
					rect.x = old.getRight().x - min.width;
					request.getMoveDelta().x = rect.x - old.getLeft().x;
				}
			} else if(max.width < rect.width) {
				rect.width = max.width;
			}
			if(min.height > rect.height) {
				rect.height = min.height;
				if(request.getMoveDelta().y > 0 && request.getSizeDelta().height < 0) { // shrinking from upper
					rect.y = old.getBottom().y - min.height;
					request.getMoveDelta().y = rect.y - old.getTop().y;
				}
			} else if(max.height < rect.height) {
				rect.height = max.height;
			}
			feedback.translateToRelative(rect);
			feedback.setBounds(rect);
		}
	}
}
