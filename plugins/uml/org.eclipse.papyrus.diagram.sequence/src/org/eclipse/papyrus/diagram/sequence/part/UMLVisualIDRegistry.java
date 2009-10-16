/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be created for the
 * corresponding Diagram, Node, ChildNode or Link represented by a domain model object.
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
	private static UMLAbstractExpression Message_4003_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Message_4004_Constraint;

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
		return org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
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
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Package) domainElement)) {
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
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
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
			if (UMLPackage.eINSTANCE.getActionExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return ActionExecutionSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return InteractionUseEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConsiderIgnoreFragment().isSuperTypeOf(domainElement.eClass())) {
				return ConsiderIgnoreFragmentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return InteractionOperandEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
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
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
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
		case LifelineEditPart.VISUAL_ID:
			if (LifelineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActionExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BehaviorExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			if (ActionExecutionSpecificationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionUseEditPart.VISUAL_ID:
			if (InteractionUseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InteractionUseName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentEditPart.VISUAL_ID:
			if (CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if (LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InteractionUseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConsiderIgnoreFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			if (InteractionOperandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (InteractionEditPart.VISUAL_ID == nodeVisualID) {
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
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass())
				&& isMessage_4003((Message) domainElement)) {
			return MessageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass())
				&& isMessage_4004((Message) domainElement)) {
			return Message2EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered
	 * by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4003(Message domainElement) {
		if (Message_4003_Constraint == null) { // lazy initialization
			Message_4003_Constraint = UMLOCLFactory.getExpression(
					"self.messageSort=MessageSort::synchCall", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_4003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4004(Message domainElement) {
		if (Message_4004_Constraint == null) { // lazy initialization
			Message_4004_Constraint = UMLOCLFactory.getExpression(
					"self.messageSort=MessageSort::asynchCall", UMLPackage.eINSTANCE.getMessage()); //$NON-NLS-1$
		}
		Object result = Message_4004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	// test

	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;

	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = getPackage_1000ViewInfo();
		}
		return diagramViewInfo;
	}

	/**
	 * @generated
	 */
	protected static ViewInfo getPackage_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "Interaction");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Lifeline");

		root.addNode(7001, viewInfo);

		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "ActionExecutionSpecification");

		root.addNode(3001, viewInfo);

		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "BehaviorExecutionSpecification");

		root.addNode(3001, viewInfo);

		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "InteractionUse");

		root.addNode(7001, viewInfo);

		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "ConsiderIgnoreFragment");

		root.addNode(7001, viewInfo);

		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "CombinedFragment");

		root.addNode(7001, viewInfo);

		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "InteractionOperand");

		root.addNode(7002, viewInfo);

		return root;
	}
}
