/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.providers;

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
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimingRulerEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantVerticalLineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LinearTimingRulerEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
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
	public static final IElementType Package_1 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Package_1"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interaction_2 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Interaction_2"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_19 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Lifeline_19"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_20 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Lifeline_20"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StateInvariant_11 = getElementType("org.eclipse.papyrus.uml.diagram.timing.FullStateInvariant_11"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StateInvariant_28 = getElementType("org.eclipse.papyrus.uml.diagram.timing.CompactStateInvariant_28"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OccurrenceSpecification_12 = getElementType("org.eclipse.papyrus.uml.diagram.timing.OccurrenceSpecification_12"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageOccurrenceSpecification_13 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageOccurrenceSpecification_13"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_9 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Node_9"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_39 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Node_39"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_15 = getElementType("org.eclipse.papyrus.uml.diagram.timing.TimeConstraint_15"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeObservation_16 = getElementType("org.eclipse.papyrus.uml.diagram.timing.TimeObservation_16"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_18 = getElementType("org.eclipse.papyrus.uml.diagram.timing.DurationConstraint_18"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationObservation_17 = getElementType("org.eclipse.papyrus.uml.diagram.timing.DurationObservation_17"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType GeneralOrdering_67 = getElementType("org.eclipse.papyrus.uml.diagram.timing.GeneralOrdering_67"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_24 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Node_24"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_25 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Node_25"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_26 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Node_26"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DestructionOccurrenceSpecification_27 = getElementType("org.eclipse.papyrus.uml.diagram.timing.DestructionOccurrenceSpecification_27"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_40 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Lifeline_40"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Gate_69 = getElementType("org.eclipse.papyrus.uml.diagram.timing.Gate_69"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_3 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageSync_3"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageAsync_4"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_41 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageReply_41"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_44 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageCreate_44"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_47 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageDelete_47"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_50 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageLost_50"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_53 = getElementType("org.eclipse.papyrus.uml.diagram.timing.MessageFound_53"); //$NON-NLS-1$

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
	private static String getImageRegistryKey(final ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			final EStructuralFeature feature = ((EStructuralFeature)element);
			final EClass eContainingClass = feature.getEContainingClass();
			final EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			final EClass eClass = (EClass)element;
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
	public static ImageDescriptor getImageDescriptor(final ENamedElement element) {
		final String key = getImageRegistryKey(element);
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
	public static Image getImage(final ENamedElement element) {
		final String key = getImageRegistryKey(element);
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
	public static ImageDescriptor getImageDescriptor(final IAdaptable hint) {
		final ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(final IAdaptable hint) {
		final ENamedElement element = getElement(hint);
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
	public static ENamedElement getElement(final IAdaptable hint) {
		final Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Package_1, UMLPackage.eINSTANCE.getPackage());

			elements.put(Interaction_2, UMLPackage.eINSTANCE.getInteraction());

			elements.put(Lifeline_19, UMLPackage.eINSTANCE.getLifeline());

			elements.put(Lifeline_20, UMLPackage.eINSTANCE.getLifeline());

			elements.put(StateInvariant_11, UMLPackage.eINSTANCE.getStateInvariant());

			elements.put(StateInvariant_28, UMLPackage.eINSTANCE.getStateInvariant());

			elements.put(OccurrenceSpecification_12, UMLPackage.eINSTANCE.getOccurrenceSpecification());

			elements.put(MessageOccurrenceSpecification_13, UMLPackage.eINSTANCE.getMessageOccurrenceSpecification());

			elements.put(TimeConstraint_15, UMLPackage.eINSTANCE.getTimeConstraint());

			elements.put(TimeObservation_16, UMLPackage.eINSTANCE.getTimeObservation());

			elements.put(DurationConstraint_18, UMLPackage.eINSTANCE.getDurationConstraint());

			elements.put(DurationObservation_17, UMLPackage.eINSTANCE.getDurationObservation());

			elements.put(GeneralOrdering_67, UMLPackage.eINSTANCE.getGeneralOrdering());

			elements.put(DestructionOccurrenceSpecification_27, UMLPackage.eINSTANCE.getDestructionOccurrenceSpecification());

			elements.put(Lifeline_40, UMLPackage.eINSTANCE.getLifeline());

			elements.put(Gate_69, UMLPackage.eINSTANCE.getGate());

			elements.put(Message_3, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_4, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_41, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_44, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_47, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_50, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_53, UMLPackage.eINSTANCE.getMessage());
		}
		return elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(final String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(final IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1);
			KNOWN_ELEMENT_TYPES.add(Interaction_2);
			KNOWN_ELEMENT_TYPES.add(Lifeline_19);
			KNOWN_ELEMENT_TYPES.add(Lifeline_20);
			KNOWN_ELEMENT_TYPES.add(StateInvariant_11);
			KNOWN_ELEMENT_TYPES.add(StateInvariant_28);
			KNOWN_ELEMENT_TYPES.add(OccurrenceSpecification_12);
			KNOWN_ELEMENT_TYPES.add(MessageOccurrenceSpecification_13);
			KNOWN_ELEMENT_TYPES.add(Node_9);
			KNOWN_ELEMENT_TYPES.add(Node_39);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_15);
			KNOWN_ELEMENT_TYPES.add(TimeObservation_16);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_18);
			KNOWN_ELEMENT_TYPES.add(DurationObservation_17);
			KNOWN_ELEMENT_TYPES.add(GeneralOrdering_67);
			KNOWN_ELEMENT_TYPES.add(Node_24);
			KNOWN_ELEMENT_TYPES.add(Node_25);
			KNOWN_ELEMENT_TYPES.add(Node_26);
			KNOWN_ELEMENT_TYPES.add(DestructionOccurrenceSpecification_27);
			KNOWN_ELEMENT_TYPES.add(Lifeline_40);
			KNOWN_ELEMENT_TYPES.add(Gate_69);
			KNOWN_ELEMENT_TYPES.add(Message_3);
			KNOWN_ELEMENT_TYPES.add(Message_4);
			KNOWN_ELEMENT_TYPES.add(Message_41);
			KNOWN_ELEMENT_TYPES.add(Message_44);
			KNOWN_ELEMENT_TYPES.add(Message_47);
			KNOWN_ELEMENT_TYPES.add(Message_50);
			KNOWN_ELEMENT_TYPES.add(Message_53);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(final int visualID) {
		switch(visualID) {
		case TimingDiagramEditPart.VISUAL_ID:
			return Package_1;
		case InteractionEditPartTN.VISUAL_ID:
			return Interaction_2;
		case FullLifelineEditPartCN.VISUAL_ID:
			return Lifeline_19;
		case CompactLifelineEditPartCN.VISUAL_ID:
			return Lifeline_20;
		case FullStateInvariantEditPartCN.VISUAL_ID:
			return StateInvariant_11;
		case CompactStateInvariantEditPartCN.VISUAL_ID:
			return StateInvariant_28;
		case OccurrenceSpecificationEditPartCN.VISUAL_ID:
			return OccurrenceSpecification_12;
		case MessageOccurrenceSpecificationEditPartCN.VISUAL_ID:
			return MessageOccurrenceSpecification_13;
		case StateDefinitionEditPart.VISUAL_ID:
			return Node_9;
		case FullStateInvariantVerticalLineEditPart.VISUAL_ID:
			return Node_39;
		case TimeConstraintEditPart.VISUAL_ID:
			return TimeConstraint_15;
		case TimeObservationEditPart.VISUAL_ID:
			return TimeObservation_16;
		case DurationConstraintEditPartCN.VISUAL_ID:
			return DurationConstraint_18;
		case DurationObservationEditPartCN.VISUAL_ID:
			return DurationObservation_17;
		case GeneralOrderingEditPart.VISUAL_ID:
			return GeneralOrdering_67;
		case FreeTimingRulerEditPartCN.VISUAL_ID:
			return Node_24;
		case LinearTimingRulerEditPartCN.VISUAL_ID:
			return Node_25;
		case TickEditPart.VISUAL_ID:
			return Node_26;
		case DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID:
			return DestructionOccurrenceSpecification_27;
		case LifelineEditPart.VISUAL_ID:
			return Lifeline_40;
		case GateEditPart.VISUAL_ID:
			return Gate_69;
		case MessageSyncEditPart.VISUAL_ID:
			return Message_3;
		case MessageAsyncEditPart.VISUAL_ID:
			return Message_4;
		case MessageReplyEditPart.VISUAL_ID:
			return Message_41;
		case MessageCreateEditPart.VISUAL_ID:
			return Message_44;
		case MessageDeleteEditPart.VISUAL_ID:
			return Message_47;
		case MessageLostEditPart.VISUAL_ID:
			return Message_50;
		case MessageFoundEditPart.VISUAL_ID:
			return Message_53;
		}
		return null;
	}

}
