/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfoRegistry;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Interaction2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartment2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.sequence/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3001_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3002_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3003_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3004_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3005_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_3006_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}

		if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Interaction) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)
				&& !"UMLSequence".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case LifelineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification()
					.isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		case InteractionInteractionCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(
					domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)
				&& !"UMLSequence".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case InteractionEditPart.VISUAL_ID:
			if (InteractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InteractionInteractionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Interaction2EditPart.VISUAL_ID:
			if (InteractionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InteractionInteractionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if (LifelineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BehaviorExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentEditPart.VISUAL_ID:
			if (CombinedFragmentInteractionOperatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if (Interaction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionInteractionCompartment2EditPart.VISUAL_ID:
			if (Interaction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (InteractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageEditPart.VISUAL_ID:
			if (MessageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message2EditPart.VISUAL_ID:
			if (MessageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message3EditPart.VISUAL_ID:
			if (MessageName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message4EditPart.VISUAL_ID:
			if (MessageName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message5EditPart.VISUAL_ID:
			if (MessageName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message6EditPart.VISUAL_ID:
			if (MessageName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3001((Message) domainElement)) {
			return MessageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3002((Message) domainElement)) {
			return Message2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3003((Message) domainElement)) {
			return Message3EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3004((Message) domainElement)) {
			return Message4EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3005((Message) domainElement)) {
			return Message5EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(
				domainElement.eClass())
				&& isMessage_3006((Message) domainElement)) {
			return Message6EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isDiagram(Interaction element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3001(Message domainElement) {
		if (Message_3001_Constraint == null) { // lazy initialization
			Message_3001_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::synchCall", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3002(Message domainElement) {
		if (Message_3002_Constraint == null) { // lazy initialization
			Message_3002_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::asynchCall", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3002_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3003(Message domainElement) {
		if (Message_3003_Constraint == null) { // lazy initialization
			Message_3003_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::reply", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3004(Message domainElement) {
		if (Message_3004_Constraint == null) { // lazy initialization
			Message_3004_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::asynchSignal", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3005(Message domainElement) {
		if (Message_3005_Constraint == null) { // lazy initialization
			Message_3005_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::createMessage", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3005_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_3006(Message domainElement) {
		if (Message_3006_Constraint == null) { // lazy initialization
			Message_3006_Constraint = UMLOCLFactory
					.getExpression(
							"self.messageSort=MessageSort::deleteMessage", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_3006_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView,
			EObject domainElement, int visualId) {
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement())
					&& getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getChildDescriptorVisualID(UMLNodeDescriptor container,
			EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case InteractionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		case Interaction2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification()
					.isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(
					domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(
					domainElement.eClass())) {
				return Interaction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(
					domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(
					domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;

	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = ViewInfoRegistry.getInstance()
					.getHeadViewInfoForEditor(UMLDiagramEditor.ID);
		}
		return diagramViewInfo;
	}

}
