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
package org.eclipse.papyrus.uml.diagram.sequence.part;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.uml.diagram.sequence/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while(view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if(annotation != null) {
				return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View)view.eContainer();
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
			if(Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package)domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * Generated not for add lifelines on lifeline
	 * 
	 * @generated NOT (update at each gmf change) lifeline, handle duration constraint/observation on message
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case PackageEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
			}
			break;
		case InteractionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass())) {
				return DurationConstraintInMessageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())) {
				return DurationObservationEditPart.VISUAL_ID;
			}
			break;
		case InteractionOperandEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return InteractionUseEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConsiderIgnoreFragment().isSuperTypeOf(domainElement.eClass())) {
				return ConsiderIgnoreFragmentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getContinuation().isSuperTypeOf(domainElement.eClass())) {
				return ContinuationEditPart.VISUAL_ID;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActionExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return ActionExecutionSpecificationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateInvariant().isSuperTypeOf(domainElement.eClass())) {
				return StateInvariantEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragment2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass())) {
				return TimeConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeObservation().isSuperTypeOf(domainElement.eClass())) {
				return TimeObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass())) {
				// handle duration constraint/observation on message
				List<Element> occurrences = ((DurationConstraint)domainElement).getConstrainedElements();
				if(occurrences.size() >= 2 && occurrences.get(0) instanceof OccurrenceSpecification && occurrences.get(1) instanceof OccurrenceSpecification) {
					if(DurationConstraintHelper.endsOfSameMessage((OccurrenceSpecification)occurrences.get(0), (OccurrenceSpecification)occurrences.get(1))) {
						return DurationConstraintInMessageEditPart.VISUAL_ID;
					}
				}
				return DurationConstraintEditPart.VISUAL_ID;
			}
			// handle duration constraint/observation on message
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())) {
				List<NamedElement> occurrences = ((DurationObservation)domainElement).getEvents();
				if(occurrences.size() >= 2 && occurrences.get(0) instanceof OccurrenceSpecification && occurrences.get(1) instanceof OccurrenceSpecification) {
					if(DurationObservationHelper.endsOfSameMessage((OccurrenceSpecification)occurrences.get(0), (OccurrenceSpecification)occurrences.get(1))) {
						return DurationObservationEditPart.VISUAL_ID;
					}
				}
			}
			if(UMLPackage.eINSTANCE.getDestructionOccurrenceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return DestructionOccurrenceSpecificationEditPart.VISUAL_ID;
			}
			// lifeline : add lifelines on lifeline
			if(UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConsiderIgnoreFragment().isSuperTypeOf(domainElement.eClass())) {
				return ConsiderIgnoreFragmentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return InteractionOperandEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return InteractionUseEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeObservation().isSuperTypeOf(domainElement.eClass())) {
				return TimeObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())) {
				return DurationObservationEditPart.VISUAL_ID;
			}
			break;
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return InteractionOperandEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getContinuation().isSuperTypeOf(domainElement.eClass())) {
				return ContinuationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentEditPart.VISUAL_ID;
			}
			break;
		// handle duration constraint/observation on message
		case MessageEditPart.VISUAL_ID:
		case Message2EditPart.VISUAL_ID:
		case Message3EditPart.VISUAL_ID:
		case Message4EditPart.VISUAL_ID:
		case Message5EditPart.VISUAL_ID:
		case Message6EditPart.VISUAL_ID:
		case Message7EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass())) {
				return DurationConstraintInMessageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())) {
				return DurationObservationEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated NOT
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case PackageEditPart.VISUAL_ID:
			if(InteractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionEditPart.VISUAL_ID:
			if(InteractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionInteractionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintInMessageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentEditPart.VISUAL_ID:
			if(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionOperandEditPart.VISUAL_ID:
			if(InteractionUseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConsiderIgnoreFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ContinuationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionUseEditPart.VISUAL_ID:
			if(InteractionUseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionUseName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContinuationEditPart.VISUAL_ID:
			if(ContinuationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if(LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LifelineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BehaviorExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CombinedFragment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestructionOccurrenceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateInvariantEditPart.VISUAL_ID:
			if(StateInvariantNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintEditPart.VISUAL_ID:
			if(TimeConstraintLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeObservationEditPart.VISUAL_ID:
			if(TimeObservationLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintEditPart.VISUAL_ID:
			if(DurationConstraintLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			if(DurationConstraintInMessageLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationObservationEditPart.VISUAL_ID:
			if(DurationObservationLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			if(ConsiderIgnoreFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionUseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			if(InteractionOperandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageEditPart.VISUAL_ID:
			if(MessageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageSyncAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message2EditPart.VISUAL_ID:
			if(MessageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageAsyncAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message3EditPart.VISUAL_ID:
			if(MessageName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageReplyAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message4EditPart.VISUAL_ID:
			if(MessageName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageCreateAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message5EditPart.VISUAL_ID:
			if(MessageName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageDeleteAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message6EditPart.VISUAL_ID:
			if(MessageName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageLostAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Message7EditPart.VISUAL_ID:
			if(MessageName7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MessageFoundAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralOrderingEditPart.VISUAL_ID:
			if(GeneralOrderingAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4003((Message)domainElement)) {
			return MessageEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4004((Message)domainElement)) {
			return Message2EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4005((Message)domainElement)) {
			return Message3EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4006((Message)domainElement)) {
			return Message4EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4007((Message)domainElement)) {
			return Message5EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4008((Message)domainElement)) {
			return Message6EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass()) && isMessage_4009((Message)domainElement)) {
			return Message7EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralOrdering().isSuperTypeOf(domainElement.eClass())) {
			return GeneralOrderingEditPart.VISUAL_ID;
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
		Object result = UMLOCLFactory.getExpression(1, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4004(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(4, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4005(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4006(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(10, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4007(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(13, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4008(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(16, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isMessage_4009(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(19, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if(candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch(visualID) {
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch(visualID) {
		case PackageEditPart.VISUAL_ID:
			return false;
		case InteractionUseEditPart.VISUAL_ID:
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case ContinuationEditPart.VISUAL_ID:
		case StateInvariantEditPart.VISUAL_ID:
		case CombinedFragment2EditPart.VISUAL_ID:
		case TimeConstraintEditPart.VISUAL_ID:
		case TimeObservationEditPart.VISUAL_ID:
		case DurationConstraintEditPart.VISUAL_ID:
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
		case DurationConstraintInMessageEditPart.VISUAL_ID:
		case DurationObservationEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {

		/**
		 * @generated
		 */
		public int getVisualID(View view) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public String getModelID(View view) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};
}
