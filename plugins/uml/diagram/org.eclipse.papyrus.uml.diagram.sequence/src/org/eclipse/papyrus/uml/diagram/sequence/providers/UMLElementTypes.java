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
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interaction_2001 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Interaction_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_3001 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Lifeline_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BehaviorExecutionSpecification_3003 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.BehaviorExecutionSpecification_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StateInvariant_3017 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.StateInvariant_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CombinedFragment_3018 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.CombinedFragment_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3019 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.TimeConstraint_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeObservation_3020 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.TimeObservation_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3021 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.DurationConstraint_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DestructionOccurrenceSpecification_3022 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.DestructionOccurrenceSpecification_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionExecutionSpecification_3006 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.ActionExecutionSpecification_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InteractionUse_3002 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.InteractionUse_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CombinedFragment_3004 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.CombinedFragment_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InteractionOperand_3005 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.InteractionOperand_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Continuation_3016 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Continuation_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3008 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Constraint_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3009 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Comment_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3023 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.DurationConstraint_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationObservation_3024 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.DurationObservation_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConsiderIgnoreFragment_3007 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.ConsiderIgnoreFragment_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4003 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4004 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4005 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4006 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4007 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4008 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4009 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.Message_4009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4010 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.CommentAnnotatedElement_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4011 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.ConstraintConstrainedElement_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType GeneralOrdering_4012 = getElementType("org.eclipse.papyrus.uml.diagram.sequence.GeneralOrdering_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if(imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if(imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if(image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(Interaction_2001, UMLPackage.eINSTANCE.getInteraction());
			elements.put(ConsiderIgnoreFragment_3007, UMLPackage.eINSTANCE.getConsiderIgnoreFragment());
			elements.put(CombinedFragment_3004, UMLPackage.eINSTANCE.getCombinedFragment());
			elements.put(InteractionOperand_3005, UMLPackage.eINSTANCE.getInteractionOperand());
			elements.put(InteractionUse_3002, UMLPackage.eINSTANCE.getInteractionUse());
			elements.put(Continuation_3016, UMLPackage.eINSTANCE.getContinuation());
			elements.put(Lifeline_3001, UMLPackage.eINSTANCE.getLifeline());
			elements.put(ActionExecutionSpecification_3006, UMLPackage.eINSTANCE.getActionExecutionSpecification());
			elements.put(BehaviorExecutionSpecification_3003, UMLPackage.eINSTANCE.getBehaviorExecutionSpecification());
			elements.put(StateInvariant_3017, UMLPackage.eINSTANCE.getStateInvariant());
			elements.put(CombinedFragment_3018, UMLPackage.eINSTANCE.getCombinedFragment());
			elements.put(TimeConstraint_3019, UMLPackage.eINSTANCE.getTimeConstraint());
			elements.put(TimeObservation_3020, UMLPackage.eINSTANCE.getTimeObservation());
			elements.put(DurationConstraint_3021, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(DestructionOccurrenceSpecification_3022, UMLPackage.eINSTANCE.getDestructionOccurrenceSpecification());
			elements.put(Constraint_3008, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Comment_3009, UMLPackage.eINSTANCE.getComment());
			elements.put(DurationConstraint_3023, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(DurationObservation_3024, UMLPackage.eINSTANCE.getDurationObservation());
			elements.put(Message_4003, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4004, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4005, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4006, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4007, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4008, UMLPackage.eINSTANCE.getMessage());
			elements.put(Message_4009, UMLPackage.eINSTANCE.getMessage());
			elements.put(CommentAnnotatedElement_4010, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4011, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
			elements.put(GeneralOrdering_4012, UMLPackage.eINSTANCE.getGeneralOrdering());
		}
		return (ENamedElement)elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Interaction_2001);
			KNOWN_ELEMENT_TYPES.add(ConsiderIgnoreFragment_3007);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_3004);
			KNOWN_ELEMENT_TYPES.add(InteractionOperand_3005);
			KNOWN_ELEMENT_TYPES.add(InteractionUse_3002);
			KNOWN_ELEMENT_TYPES.add(Continuation_3016);
			KNOWN_ELEMENT_TYPES.add(Lifeline_3001);
			KNOWN_ELEMENT_TYPES.add(ActionExecutionSpecification_3006);
			KNOWN_ELEMENT_TYPES.add(BehaviorExecutionSpecification_3003);
			KNOWN_ELEMENT_TYPES.add(StateInvariant_3017);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_3018);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_3019);
			KNOWN_ELEMENT_TYPES.add(TimeObservation_3020);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_3021);
			KNOWN_ELEMENT_TYPES.add(DestructionOccurrenceSpecification_3022);
			KNOWN_ELEMENT_TYPES.add(Constraint_3008);
			KNOWN_ELEMENT_TYPES.add(Comment_3009);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_3023);
			KNOWN_ELEMENT_TYPES.add(DurationObservation_3024);
			KNOWN_ELEMENT_TYPES.add(Message_4003);
			KNOWN_ELEMENT_TYPES.add(Message_4004);
			KNOWN_ELEMENT_TYPES.add(Message_4005);
			KNOWN_ELEMENT_TYPES.add(Message_4006);
			KNOWN_ELEMENT_TYPES.add(Message_4007);
			KNOWN_ELEMENT_TYPES.add(Message_4008);
			KNOWN_ELEMENT_TYPES.add(Message_4009);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4010);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4011);
			KNOWN_ELEMENT_TYPES.add(GeneralOrdering_4012);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case PackageEditPart.VISUAL_ID:
			return Package_1000;
		case InteractionEditPart.VISUAL_ID:
			return Interaction_2001;
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return ConsiderIgnoreFragment_3007;
		case CombinedFragmentEditPart.VISUAL_ID:
			return CombinedFragment_3004;
		case InteractionOperandEditPart.VISUAL_ID:
			return InteractionOperand_3005;
		case InteractionUseEditPart.VISUAL_ID:
			return InteractionUse_3002;
		case ContinuationEditPart.VISUAL_ID:
			return Continuation_3016;
		case LifelineEditPart.VISUAL_ID:
			return Lifeline_3001;
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return ActionExecutionSpecification_3006;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return BehaviorExecutionSpecification_3003;
		case StateInvariantEditPart.VISUAL_ID:
			return StateInvariant_3017;
		case CombinedFragment2EditPart.VISUAL_ID:
			return CombinedFragment_3018;
		case TimeConstraintEditPart.VISUAL_ID:
			return TimeConstraint_3019;
		case TimeObservationEditPart.VISUAL_ID:
			return TimeObservation_3020;
		case DurationConstraintEditPart.VISUAL_ID:
			return DurationConstraint_3021;
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return DestructionOccurrenceSpecification_3022;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_3008;
		case CommentEditPart.VISUAL_ID:
			return Comment_3009;
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return DurationConstraint_3023;
		case DurationObservationEditPart.VISUAL_ID:
			return DurationObservation_3024;
		case MessageEditPart.VISUAL_ID:
			return Message_4003;
		case Message2EditPart.VISUAL_ID:
			return Message_4004;
		case Message3EditPart.VISUAL_ID:
			return Message_4005;
		case Message4EditPart.VISUAL_ID:
			return Message_4006;
		case Message5EditPart.VISUAL_ID:
			return Message_4007;
		case Message6EditPart.VISUAL_ID:
			return Message_4008;
		case Message7EditPart.VISUAL_ID:
			return Message_4009;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4010;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4011;
		case GeneralOrderingEditPart.VISUAL_ID:
			return GeneralOrdering_4012;
		}
		return null;
	}
}
