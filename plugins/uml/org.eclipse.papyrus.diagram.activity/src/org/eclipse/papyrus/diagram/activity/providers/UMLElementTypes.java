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
package org.eclipse.papyrus.diagram.activity.providers;

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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.activity.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_2001 = getElementType("org.eclipse.papyrus.diagram.activity.Activity_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_3001 = getElementType("org.eclipse.papyrus.diagram.activity.Parameter_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3002 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3003 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InitialNode_3004 = getElementType("org.eclipse.papyrus.diagram.activity.InitialNode_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityFinalNode_3005 = getElementType("org.eclipse.papyrus.diagram.activity.ActivityFinalNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FlowFinalNode_3006 = getElementType("org.eclipse.papyrus.diagram.activity.FlowFinalNode_3006"); //$NON-NLS-1$

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
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());


			elements.put(Activity_2001, UMLPackage.eINSTANCE.getActivity());


			elements.put(Parameter_3001, UMLPackage.eINSTANCE.getParameter());


			elements.put(Constraint_3002, UMLPackage.eINSTANCE.getConstraint());


			elements.put(Constraint_3003, UMLPackage.eINSTANCE.getConstraint());


			elements.put(InitialNode_3004, UMLPackage.eINSTANCE.getInitialNode());


			elements.put(ActivityFinalNode_3005, UMLPackage.eINSTANCE.getActivityFinalNode());


			elements.put(FlowFinalNode_3006, UMLPackage.eINSTANCE.getFlowFinalNode());
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
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Activity_2001);
			KNOWN_ELEMENT_TYPES.add(Parameter_3001);
			KNOWN_ELEMENT_TYPES.add(Constraint_3002);
			KNOWN_ELEMENT_TYPES.add(Constraint_3003);
			KNOWN_ELEMENT_TYPES.add(InitialNode_3004);
			KNOWN_ELEMENT_TYPES.add(ActivityFinalNode_3005);
			KNOWN_ELEMENT_TYPES.add(FlowFinalNode_3006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case ActivityEditPart.VISUAL_ID:
			return Activity_2001;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_3001;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_3002;
		case Constraint2EditPart.VISUAL_ID:
			return Constraint_3003;
		case InitialNodeEditPart.VISUAL_ID:
			return InitialNode_3004;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return ActivityFinalNode_3005;
		case FlowFinalNodeEditPart.VISUAL_ID:
			return FlowFinalNode_3006;
		}
		return null;
	}

}
