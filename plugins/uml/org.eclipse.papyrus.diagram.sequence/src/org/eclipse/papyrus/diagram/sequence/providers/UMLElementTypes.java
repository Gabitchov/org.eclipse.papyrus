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
package org.eclipse.papyrus.diagram.sequence.providers;

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
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.sequence.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interaction_2001 = getElementType("org.eclipse.papyrus.diagram.sequence.Interaction_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_3001 = getElementType("org.eclipse.papyrus.diagram.sequence.Lifeline_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BehaviorExecutionSpecification_3003 = getElementType("org.eclipse.papyrus.diagram.sequence.BehaviorExecutionSpecification_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionExecutionSpecification_3006 = getElementType("org.eclipse.papyrus.diagram.sequence.ActionExecutionSpecification_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InteractionUse_3002 = getElementType("org.eclipse.papyrus.diagram.sequence.InteractionUse_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CombinedFragment_3004 = getElementType("org.eclipse.papyrus.diagram.sequence.CombinedFragment_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InteractionOperand_3005 = getElementType("org.eclipse.papyrus.diagram.sequence.InteractionOperand_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4003 = getElementType("org.eclipse.papyrus.diagram.sequence.Message_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4004 = getElementType("org.eclipse.papyrus.diagram.sequence.Message_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
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
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(
						eClass.getEPackage().getEFactoryInstance().create(eClass));
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
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
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
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
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
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
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
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());

			elements.put(Interaction_2001, UMLPackage.eINSTANCE.getInteraction());

			elements.put(Lifeline_3001, UMLPackage.eINSTANCE.getLifeline());

			elements.put(ActionExecutionSpecification_3006, UMLPackage.eINSTANCE.getActionExecutionSpecification());

			elements.put(BehaviorExecutionSpecification_3003, UMLPackage.eINSTANCE.getBehaviorExecutionSpecification());

			elements.put(InteractionUse_3002, UMLPackage.eINSTANCE.getInteractionUse());

			elements.put(CombinedFragment_3004, UMLPackage.eINSTANCE.getCombinedFragment());

			elements.put(InteractionOperand_3005, UMLPackage.eINSTANCE.getInteractionOperand());

			elements.put(Message_4003, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_4004, UMLPackage.eINSTANCE.getMessage());
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
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Interaction_2001);
			KNOWN_ELEMENT_TYPES.add(Lifeline_3001);
			KNOWN_ELEMENT_TYPES.add(ActionExecutionSpecification_3006);
			KNOWN_ELEMENT_TYPES.add(BehaviorExecutionSpecification_3003);
			KNOWN_ELEMENT_TYPES.add(InteractionUse_3002);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_3004);
			KNOWN_ELEMENT_TYPES.add(InteractionOperand_3005);
			KNOWN_ELEMENT_TYPES.add(Message_4003);
			KNOWN_ELEMENT_TYPES.add(Message_4004);
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
		case InteractionEditPart.VISUAL_ID:
			return Interaction_2001;
		case LifelineEditPart.VISUAL_ID:
			return Lifeline_3001;
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return ActionExecutionSpecification_3006;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return BehaviorExecutionSpecification_3003;
		case InteractionUseEditPart.VISUAL_ID:
			return InteractionUse_3002;
		case CombinedFragmentEditPart.VISUAL_ID:
			return CombinedFragment_3004;
		case InteractionOperandEditPart.VISUAL_ID:
			return InteractionOperand_3005;
		case MessageEditPart.VISUAL_ID:
			return Message_4003;
		case Message2EditPart.VISUAL_ID:
			return Message_4004;
		}
		return null;
	}

}
