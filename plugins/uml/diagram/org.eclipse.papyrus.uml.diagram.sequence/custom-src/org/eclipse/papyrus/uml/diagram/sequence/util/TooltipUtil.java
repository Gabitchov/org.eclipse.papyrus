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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Display type name as tooltip of each node element
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402964
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TooltipUtil {

	public static final String TOOLTIP_ROLE = "tooltip Edit Policy";

	private static final List<EClass> ELEMENT_SUPPORT_TOOLTIPS = new ArrayList<EClass>();
	static {
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.LIFELINE);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.ACTION_EXECUTION_SPECIFICATION);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.BEHAVIOR_EXECUTION_SPECIFICATION);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.COMBINED_FRAGMENT);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.INTERACTION_OPERAND);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.MESSAGE);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.MESSAGE_END);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.EXECUTION_OCCURRENCE_SPECIFICATION);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.INTERACTION_USE);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.STATE_INVARIANT);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.DESTRUCTION_OCCURRENCE_SPECIFICATION);
		ELEMENT_SUPPORT_TOOLTIPS.add(UMLPackage.Literals.GENERAL_ORDERING);
	}

	public static void manageTooltipEditPolicy(EditPart editPart) {
		if(editPart == null || !(editPart instanceof GraphicalEditPart)) {
			return;
		}
		IFigure figure = ((GraphicalEditPart)editPart).getFigure();
		EClass semanticElementType = getSemanticElementType(editPart);
		if(supportTooltips(semanticElementType)) {
			editPart.installEditPolicy(TOOLTIP_ROLE, new TooltipEditPolicy(new EditPartTooltipUpdater((GraphicalEditPart)editPart)));
		} else {
			editPart.removeEditPolicy(TOOLTIP_ROLE);
			figure.setToolTip(null);
		}
	}

	private static boolean supportTooltips(EClass semanticType) {
		if(semanticType == null) {
			return false;
		}
		if(ELEMENT_SUPPORT_TOOLTIPS.contains(semanticType)) {
			return true;
		}
		for(EClass type : ELEMENT_SUPPORT_TOOLTIPS) {
			if(type.isSuperTypeOf(semanticType)) {
				return true;
			}
		}
		return false;
	}

	private static EClass getSemanticElementType(EditPart editPart) {
		EObject element = getSemanticElement(editPart);
		return element == null ? null : element.eClass();
	}

	private static EObject getSemanticElement(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		Object model = editPart.getModel();
		if(model instanceof View) {
			return ViewUtil.resolveSemanticElement((View)model);
		}
		return null;
	}

	public static View getTopNodeView(Object model, EObject semanticElement) {
		if(model == null || !(model instanceof View)) {
			return null;
		}
		View view = (View)model;
		EObject elt = ViewUtil.resolveSemanticElement(view);
		if(elt == null || elt != semanticElement) {
			return null;
		}
		View containerView = ViewUtil.getContainerView(view);
		if(containerView != null) {
			EObject containerElement = ViewUtil.resolveSemanticElement(containerView);
			if(containerElement == null || containerElement != semanticElement) {
				return view;
			}
		}
		return getTopNodeView(containerView, semanticElement);
	}

	public static class TooltipEditPolicy extends GraphicalEditPolicy {

		private TooltipUpdater updater;

		private MouseMotionListener updateListener;

		private Adapter modelListener;

		/**
		 * Constructor.
		 *
		 */
		public TooltipEditPolicy(TooltipUpdater updater) {
			this.updater = updater;
		}

		@Override
		public void activate() {
			super.activate();
			IFigure hostFigure = getHostFigure();
			final TooltipFigure tooltipFigure = new TooltipFigure(updater);
			hostFigure.setToolTip(tooltipFigure);
			hostFigure.addMouseMotionListener(updateListener = new MouseMotionListener.Stub() {

				@Override
				public void mouseEntered(MouseEvent me) {
					tooltipFigure.update();
				}
			});
			if(getHost() instanceof LifelineEditPart) {
				((LifelineEditPart)getHost()).getPrimaryView().eAdapters().add(modelListener = new AdapterImpl() {

					@Override
					public void notifyChanged(Notification msg) {
						if(msg.isTouch()) {
							return;
						}
						tooltipFigure.update();
					}
				});
			}
		}

		@Override
		public void deactivate() {
			super.deactivate();
			getHostFigure().removeMouseMotionListener(updateListener);
			if(getHost() instanceof LifelineEditPart) {
				((LifelineEditPart)getHost()).getPrimaryView().eAdapters().remove(modelListener);
			}
		}
	}

	public static class TooltipFigure extends Figure {

		private static final Border TOOLTIP_BORDER = new MarginBorder(0, 5, 1, 5);

		private TextFlow nameFigure;

		private TextFlow descriptionFigure;

		private TooltipUpdater updater;

		/**
		 * Constructor.
		 *
		 * @param updater
		 *
		 */
		public TooltipFigure(TooltipUpdater updater) {
			this.updater = updater;
			setLayoutManager(new ToolbarLayout(false));
			setBorder(TOOLTIP_BORDER);
			FlowPage namePage = new FlowPage();
			namePage.setOpaque(true);
			namePage.add(nameFigure = new TextFlow());
			add(namePage);
			namePage.setFont(JFaceResources.getBannerFont());
			//description
			FlowPage descPage = new FlowPage();
			descPage.setOpaque(true);
			descPage.add(descriptionFigure = new TextFlow());
			add(descPage);
			update();
		}

		/**
		 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
		 *
		 * @param wHint
		 * @param hHint
		 * @return
		 */
		@Override
		public Dimension getPreferredSize(int wHint, int hHint) {
			Dimension d = super.getPreferredSize(-1, -1);
			//			if(d.width > 150)
			//				d = super.getPreferredSize(150, -1);
			return d;
		}

		public void setName(String name) {
			nameFigure.setText(name);
		}

		public String getName() {
			return nameFigure.getText();
		}

		public TextFlow getNameFigure() {
			return nameFigure;
		}

		public void setDescription(String description) {
			descriptionFigure.setText(description);
		}

		public String getDescription() {
			return descriptionFigure.getText();
		}

		public TextFlow getDescriptionFigure() {
			return descriptionFigure;
		}

		public void update() {
			if(updater == null) {
				return;
			}
			setName(updater.getTooltipName());
			setDescription(updater.getTooltipDescription());
		}
	}

	public static interface TooltipUpdater {

		String getTooltipName();

		String getTooltipDescription();
	}

	public static class EditPartTooltipUpdater implements TooltipUpdater {

		private GraphicalEditPart editPart;

		/**
		 * Constructor.
		 *
		 */
		public EditPartTooltipUpdater(GraphicalEditPart editPart) {
			Assert.isNotNull(editPart);
			this.editPart = editPart;
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.sequence.util.TooltipUtil.TooltipUpdater#getTooltipName()
		 *
		 * @return
		 */
		@Override
		public String getTooltipName() {
			if(editPart instanceof CombinedFragment2EditPart) {
				return "Co Region";
			}
			EObject semanticElement = getSemanticElement(editPart);
			if(semanticElement instanceof Message) {
				Message message = (Message)semanticElement;
				MessageSort messageSort = message.getMessageSort();
				switch(messageSort) {
				case ASYNCH_CALL_LITERAL:
					return "Asynchronous Message";
				case ASYNCH_SIGNAL_LITERAL:
				{
					if(message.getSendEvent() == null) {
						return "Found Message";
					} else if(message.getReceiveEvent() == null) {
						return "Lost Message";
					}
				}
				case CREATE_MESSAGE_LITERAL:
					return "Create Message";
				case DELETE_MESSAGE_LITERAL:
					return "Delete Message";
				case REPLY_LITERAL:
					return "Reply Message";
				case SYNCH_CALL_LITERAL:
					return "Synchronous Message";
				}
			} else if(semanticElement instanceof DestructionOccurrenceSpecification) {
				return "Destruction Event";
			}
			if(semanticElement != null) {
				return getDisplayName(semanticElement.eClass().getName());
			}
			return null;
		}

		private String getDisplayName(String name) {
			StringBuffer displayName = new StringBuffer();
			char[] charArray = name.toCharArray();
			for(int i = 0; i < charArray.length; i++) {
				if(Character.isUpperCase(charArray[i])) {
					displayName.append(" ");
				}
				displayName.append(charArray[i]);
			}
			return new String(displayName).trim();
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.sequence.util.TooltipUtil.TooltipUpdater#getTooltipDescription()
		 *
		 * @return
		 */
		@Override
		public String getTooltipDescription() {
			//CoRegion
			//			if(editPart instanceof CombinedFragment2EditPart) {
			//				return null;
			//			}
			EObject semanticElement = getSemanticElement(editPart);
			if(semanticElement instanceof StateInvariant || semanticElement instanceof DestructionOccurrenceSpecification || semanticElement instanceof GeneralOrdering) {
				return null;
			}
			StringBuffer descBuf = new StringBuffer();
			//			if(semanticElement instanceof Lifeline) {
			//				descBuf.append("label: ");
			//			} else {
			descBuf.append("name: ");
			//			}
			UMLNavigatorLabelProvider labelProvider = new UMLNavigatorLabelProvider();
			Object model = editPart.getModel();
			String label = null;
			View topNodeView = getTopNodeView(model, semanticElement);
			if(topNodeView != null) {
				label = labelProvider.getText(topNodeView);
				if(label.startsWith("<UnknownElement")) {
					label = null;
				}
			}
			//Try to use the real name of InteractionUse.
			if(semanticElement instanceof InteractionUse) {
				label = ((InteractionUse)semanticElement).getLabel();
			} else if(semanticElement instanceof Lifeline) {
				label = ((Lifeline)semanticElement).getLabel();
			}
			if((label == null) && semanticElement instanceof NamedElement) {
				label = ((NamedElement)semanticElement).getLabel();
			}
			descBuf.append(label);
			descBuf.append("\n");
			if(semanticElement instanceof CombinedFragment && !(editPart instanceof CombinedFragment2EditPart)) {
				descBuf.append("operator: ");
				InteractionOperatorKind operator = ((CombinedFragment)semanticElement).getInteractionOperator();
				if(operator != null) {
					descBuf.append(operator.getName());
				}
				descBuf.append("\n");
			} else if(semanticElement instanceof InteractionOperand) {
				descBuf.append("parent:name: ");
				InteractionOperand interactionOperand = (InteractionOperand)semanticElement;
				Element owner = interactionOperand.getOwner();
				while(owner != null && !(owner instanceof CombinedFragment)) {
					owner = owner.getOwner();
				}
				CombinedFragment parent = (CombinedFragment)owner;
				if(parent != null) {
					descBuf.append(parent.getLabel());
				}
				descBuf.append("\n");
				descBuf.append("parent:operator: ");
				if(parent != null) {
					InteractionOperatorKind operator = parent.getInteractionOperator();
					if(operator != null) {
						descBuf.append(operator.getName());
					}
				}
				descBuf.append("\n");
			} else if(semanticElement instanceof InteractionUse) {
				Interaction refersTo = ((InteractionUse)semanticElement).getRefersTo();
				if(refersTo != null) {
					descBuf.append("ref: ");
					descBuf.append(refersTo.getLabel());
					descBuf.append("\n");
				}
			}
			if(semanticElement instanceof Lifeline) {
				//Bug 417396
				//FIXME: Refactored the displayValue as-is (int -> Collection<String>), although it is not used anymore to configure the tooltip. Remove?
				Collection<String> displayValue = LifelineLabelHelper.DEFAULT_LABEL_DISPLAY;
				IMaskManagedLabelEditPolicy policy = null;
				if(editPart instanceof LifelineEditPart) {
					policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
				} else if(editPart instanceof LifelineNameEditPart) {
					policy = (IMaskManagedLabelEditPolicy)editPart.getParent().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
				}
				if(policy != null) {
					displayValue = policy.getCurrentDisplayValue();
				}
				Lifeline lifeline = (Lifeline)semanticElement;
				ConnectableElement represents = lifeline.getRepresents();
				if(represents != null) {
					descBuf.append("represent: ");
					descBuf.append(represents.getLabel());
					descBuf.append("\n");
					Type type = represents.getType();
					if(type != null) {
						descBuf.append("represent type: ");
						descBuf.append(type.getLabel());
						descBuf.append("\n");
					}
				}
			}
			return new String(descBuf).trim();
		}
	}
}
