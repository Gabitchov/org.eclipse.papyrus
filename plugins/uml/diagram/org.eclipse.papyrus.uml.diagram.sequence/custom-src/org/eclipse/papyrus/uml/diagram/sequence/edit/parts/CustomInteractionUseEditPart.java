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
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionUseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.InteractionUseRectangleFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.InteractionUseUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionUseEditPart extends InteractionUseEditPart {

	/**
	 * Title for dialog of no actual gate's manual creation
	 */
	private static final String NO_ACTUAL_GATE_MANUAL_CREATION_DLG_TITLE = "No manual creation of actual gate"; //$NON-NLS-1$

	/**
	 * Message for dialog of no actual gate's manual creation
	 */
	private static final String NO_ACTUAL_GATE_MANUAL_CREATION_DLG_MSG = "It's forbidden to create actual gate"; //$NON-NLS-1$

	/**
	 * Title for dialog of no actual gate's manual deletion
	 */
	private static final String NO_ACTUAL_GATE_MANUAL_DELETION_DLG_TITLE = "No manual deletion of actual gate"; //$NON-NLS-1$

	/**
	 * Message for dialog of no actual gate's manual deletion
	 */
	private static final String NO_ACTUAL_GATE_MANUAL_DELETION_DLG_MSG = "It's forbidden to delete actual gate"; //$NON-NLS-1$

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = null;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionUseEditPart(View view) {
		super(view);
	}

	/**
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifier() {
		if(notifier == null) {
			try {
				Field f = InteractionUseEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifier = (NotificationHelper)f.get(this);
			} catch (Exception e) {
				notifier = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifier;
	}

	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
		super.setLineWidth(width);
	}

	protected IFigure createNodeShape() {
		primaryShape = new InteractionUseRectangleFigure();
		getPrimaryShape().setShadow(false);
		return primaryShape;
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionUseItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SequenceGraphicalNodeEditPolicy());
	}

	protected void refreshShadow() {
		getPrimaryShape().setShadow(AppearanceHelper.showShadow((View)getModel()));
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *        the new value of the back ground color
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
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

	/**
	 * Handle for gates operator and covered lifelines
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifier = getNotifier();
		Object feature = notification.getFeature();
		if(UMLPackage.eINSTANCE.getInteractionUse_RefersTo().equals(feature)) {
			if(notification.getOldValue() instanceof Interaction) {
				notifier.unlistenAll();
				// notifier.unlistenObject((Interaction) notification.getOldValue());
			}
			InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), interactionUse, UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), interactionUse.getActualGates()), true);
			if(notification.getNewValue() instanceof Interaction) {
				Interaction interaction = (Interaction)notification.getNewValue();
				notifier.listenObject(interaction);
				interactionUse.getActualGates();
				List<Gate> formalGates = interaction.getFormalGates();
				for(Gate formalGate : formalGates) {
					Gate newActualGate = (Gate)EcoreUtil.create(UMLPackage.Literals.GATE);
					newActualGate.setName(formalGate.getName());
					CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), resolveSemanticElement(), UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), newActualGate), true);
					notifier.listenObject(formalGate);
					notifier.listenObject(newActualGate);
				}
			}
		} else if(UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)) {
			activate();
			resizeInteractionFragmentFigure();
		} else if(UMLPackage.eINSTANCE.getInteraction_FormalGate().equals(feature)) {
			// Handle formal gate
			InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof Gate) {
				notifier.unlistenObject((Gate)oldValue);
				List<Gate> actualGates = interactionUse.getActualGates();
				for(int i = actualGates.size() - 1; i >= 0; i--) {
					Gate element = actualGates.get(i);
					if(((Gate)oldValue).getName().equals(element.getName())) {
						notifier.unlistenObject(element);
						CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), interactionUse, UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), element), true);
					}
				}
			}
			Object newValue = notification.getNewValue();
			if(newValue instanceof Gate) {
				Gate actualGate = interactionUse.createActualGate(((Gate)newValue).getName());
				notifier.listenObject((Gate)newValue);
				notifier.listenObject(actualGate);
			}
		} else if(UMLPackage.eINSTANCE.getInteractionUse_ActualGate().equals(feature)) {
			if(notification.getEventType() == Notification.ADD) {
				// Block manual creation of actual gate
				if(notification.getNewValue() instanceof Gate) {
					Gate newActualGate = (Gate)notification.getNewValue();
					if(!checkActualGateExistence(newActualGate)) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), NO_ACTUAL_GATE_MANUAL_CREATION_DLG_TITLE, NO_ACTUAL_GATE_MANUAL_CREATION_DLG_MSG);
						CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), resolveSemanticElement(), UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), newActualGate), true);
					}
				}
			} else if(notification.getEventType() == Notification.REMOVE) {
				// Block manual deletion of actual gate
				if(notification.getOldValue() instanceof Gate) {
					Gate oldActualGate = (Gate)notification.getOldValue();
					//There are some issues in redo progress, check if there is other one with same time firstly.
					InteractionUse interactionUse = (InteractionUse)notification.getNotifier();
					Gate otherOne = interactionUse.getActualGate(oldActualGate.getName());
					if(otherOne == null && checkActualGateExistence(oldActualGate)) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), NO_ACTUAL_GATE_MANUAL_DELETION_DLG_TITLE, NO_ACTUAL_GATE_MANUAL_DELETION_DLG_MSG);
						CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), resolveSemanticElement(), UMLPackage.eINSTANCE.getInteractionUse_ActualGate(), oldActualGate), true);
					}
				}
			}
		} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) && notification.getNotifier() instanceof Gate) {
			Gate gate = (Gate)notification.getNotifier();
			if(gate.eContainer() instanceof Interaction) {
				// Handle modification of formal gate's name
				InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
				List<Gate> actualGates = interactionUse.getActualGates();
				String oldValue = notification.getOldStringValue();
				String newValue = notification.getNewStringValue();
				for(Gate actualGate : actualGates) {
					if(oldValue == null && actualGate.getName() == null || oldValue != null && oldValue.equals(actualGate.getName())) {
						notifier.unlistenObject(actualGate); // Delete listener on gate
						actualGate.setName(newValue);
						notifier.listenObject(actualGate); // Add listener on gate
					}
				}
			} else if(gate.eContainer() instanceof InteractionUse) {
				// Block modification of actual gate's name
				notifier.unlistenObject(gate); // Delete listener on gate
				gate.setName(notification.getOldStringValue());
				notifier.listenObject(gate); // Add listener on gate
			}
		}
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		}
		refreshShadow();
		super.handleNotificationEvent(notification);
	}

	/**
	 * Check if actual gate is attached to a formal gate
	 * 
	 * @return true if there is a formal gate corresponding to the actual gate
	 */
	private boolean checkActualGateExistence(Gate actualGate) {
		InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
		Interaction interaction = interactionUse.getRefersTo();
		if(interaction != null) {
			// Find if the corresponding formal gate exists
			for(Gate formalGate : interaction.getFormalGates()) {
				if(formalGate.getName().equals(actualGate.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 */
	@Override
	public void activate() {
		super.activate();
		final NotificationHelper notifier = getNotifier();
		if(resolveSemanticElement() instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
			Interaction interaction = interactionUse.getRefersTo();
			if(interaction != null) {
				// activate the listener on the referred interaction
				notifier.listenObject(interaction);
				for(Gate formalGate : interaction.getFormalGates()) {
					notifier.listenObject(formalGate);
				}
			}
			for(Gate actualGate : interactionUse.getActualGates()) {
				notifier.listenObject(actualGate);
			}
		}
	}

	/**
	 * Deactivate a listener for the interactionUse to handle notification in the refered
	 * Interaction
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		if(notifier != null) {
			notifier.unlistenAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeNotify() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
	}

	@Override
	public void performRequest(Request request) {
		if(request.getType().equals(REQ_OPEN)) {
			InteractionUse interactionUse = (InteractionUse)resolveSemanticElement();
			Interaction interaction = interactionUse.getRefersTo();
			if(interaction == null) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Warning", "There is no referenced interaction!");
				return;
			}
			Diagram diagram = InteractionUseUtil.findDiagram(getNotationView(), interaction);
			if(diagram == null) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Warning", "Cannot find diagram of the referenced interaction!");
			} else {
				InteractionUseUtil.openDiagram(diagram);
			}
			return;
		}
		super.performRequest(request);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
	}
}
