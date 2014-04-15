/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.DoActivityStateBehaviorStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.EntryStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ExitStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateForkEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateInitialEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJoinEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;
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
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;
	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Package_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateMachine_2000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.StateMachine_2000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Region_3000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Region_3000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FinalState_5000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.FinalState_5000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_6000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.State_6000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_8000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_8000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_9000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_9000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_10000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_10000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_11000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_11000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_12000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_12000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_13000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_13000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_14000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_14000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_15000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_15000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_16000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_16000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_17000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Pseudostate_17000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConnectionPointReference_18000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.ConnectionPointReference_18000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Comment_666 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.StateMachineComment"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Constraint_668 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Constraint_668"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_680 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.InternalTransition_680"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Behavior_690 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.EntryStateBehavior_690"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Behavior_691 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.DoActivityStateBehavior_691"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Behavior_692 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.ExitStateBehavior_692"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_7000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Transition_7000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Generalization_19000 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.Generalization_19000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_667 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.CommentAnnotatedElement_667"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_670 = getElementType("org.eclipse.papyrus.uml.diagram.statemachine.ConstraintConstrainedElement_670"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static synchronized ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(StateMachine_2000, UMLPackage.eINSTANCE.getStateMachine());
			elements.put(Region_3000, UMLPackage.eINSTANCE.getRegion());
			elements.put(FinalState_5000, UMLPackage.eINSTANCE.getFinalState());
			elements.put(State_6000, UMLPackage.eINSTANCE.getState());
			elements.put(Pseudostate_8000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_9000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_10000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_11000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_12000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_13000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_14000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_15000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_16000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(Pseudostate_17000, UMLPackage.eINSTANCE.getPseudostate());
			elements.put(ConnectionPointReference_18000, UMLPackage.eINSTANCE.getConnectionPointReference());
			elements.put(Comment_666, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_668, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Transition_680, UMLPackage.eINSTANCE.getTransition());
			elements.put(Behavior_690, UMLPackage.eINSTANCE.getBehavior());
			elements.put(Behavior_691, UMLPackage.eINSTANCE.getBehavior());
			elements.put(Behavior_692, UMLPackage.eINSTANCE.getBehavior());
			elements.put(Transition_7000, UMLPackage.eINSTANCE.getTransition());
			elements.put(Generalization_19000, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(CommentAnnotatedElement_667, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_670, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
		}
		return (ENamedElement) elements.get(type);
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
	public static synchronized boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(StateMachine_2000);
			KNOWN_ELEMENT_TYPES.add(Region_3000);
			KNOWN_ELEMENT_TYPES.add(FinalState_5000);
			KNOWN_ELEMENT_TYPES.add(State_6000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_8000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_9000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_10000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_11000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_12000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_13000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_14000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_15000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_16000);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_17000);
			KNOWN_ELEMENT_TYPES.add(ConnectionPointReference_18000);
			KNOWN_ELEMENT_TYPES.add(Comment_666);
			KNOWN_ELEMENT_TYPES.add(Constraint_668);
			KNOWN_ELEMENT_TYPES.add(Transition_680);
			KNOWN_ELEMENT_TYPES.add(Behavior_690);
			KNOWN_ELEMENT_TYPES.add(Behavior_691);
			KNOWN_ELEMENT_TYPES.add(Behavior_692);
			KNOWN_ELEMENT_TYPES.add(Transition_7000);
			KNOWN_ELEMENT_TYPES.add(Generalization_19000);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_667);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_670);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PackageEditPart.VISUAL_ID:
			return Package_1000;
		case StateMachineEditPart.VISUAL_ID:
			return StateMachine_2000;
		case RegionEditPart.VISUAL_ID:
			return Region_3000;
		case FinalStateEditPart.VISUAL_ID:
			return FinalState_5000;
		case StateEditPart.VISUAL_ID:
			return State_6000;
		case PseudostateInitialEditPart.VISUAL_ID:
			return Pseudostate_8000;
		case PseudostateJoinEditPart.VISUAL_ID:
			return Pseudostate_9000;
		case PseudostateForkEditPart.VISUAL_ID:
			return Pseudostate_10000;
		case PseudostateChoiceEditPart.VISUAL_ID:
			return Pseudostate_11000;
		case PseudostateJunctionEditPart.VISUAL_ID:
			return Pseudostate_12000;
		case PseudostateShallowHistoryEditPart.VISUAL_ID:
			return Pseudostate_13000;
		case PseudostateDeepHistoryEditPart.VISUAL_ID:
			return Pseudostate_14000;
		case PseudostateTerminateEditPart.VISUAL_ID:
			return Pseudostate_15000;
		case PseudostateEntryPointEditPart.VISUAL_ID:
			return Pseudostate_16000;
		case PseudostateExitPointEditPart.VISUAL_ID:
			return Pseudostate_17000;
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return ConnectionPointReference_18000;
		case CommentEditPart.VISUAL_ID:
			return Comment_666;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_668;
		case InternalTransitionEditPart.VISUAL_ID:
			return Transition_680;
		case EntryStateBehaviorEditPart.VISUAL_ID:
			return Behavior_690;
		case DoActivityStateBehaviorStateEditPart.VISUAL_ID:
			return Behavior_691;
		case ExitStateBehaviorEditPart.VISUAL_ID:
			return Behavior_692;
		case TransitionEditPart.VISUAL_ID:
			return Transition_7000;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_19000;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_667;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_670;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {
		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
