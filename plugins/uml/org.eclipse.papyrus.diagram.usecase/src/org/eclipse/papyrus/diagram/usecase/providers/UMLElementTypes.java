/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

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
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.usecase.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_2002 = getElementType("org.eclipse.papyrus.diagram.usecase.Actor_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_2003 = getElementType("org.eclipse.papyrus.diagram.usecase.Actor_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_2004 = getElementType("org.eclipse.papyrus.diagram.usecase.UseCase_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_2005 = getElementType("org.eclipse.papyrus.diagram.usecase.UseCase_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_2006 = getElementType("org.eclipse.papyrus.diagram.usecase.Component_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2009 = getElementType("org.eclipse.papyrus.diagram.usecase.Package_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2008 = getElementType("org.eclipse.papyrus.diagram.usecase.Constraint_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2010 = getElementType("org.eclipse.papyrus.diagram.usecase.Comment_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtensionPoint_3002 = getElementType("org.eclipse.papyrus.diagram.usecase.ExtensionPoint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtensionPoint_3003 = getElementType("org.eclipse.papyrus.diagram.usecase.ExtensionPoint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_3004 = getElementType("org.eclipse.papyrus.diagram.usecase.UseCase_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_3005 = getElementType("org.eclipse.papyrus.diagram.usecase.Actor_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_3006 = getElementType("org.eclipse.papyrus.diagram.usecase.UseCase_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Include_4001 = getElementType("org.eclipse.papyrus.diagram.usecase.Include_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Extend_4002 = getElementType("org.eclipse.papyrus.diagram.usecase.Extend_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4003 = getElementType("org.eclipse.papyrus.diagram.usecase.Generalization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4004 = getElementType("org.eclipse.papyrus.diagram.usecase.Association_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4005 = getElementType("org.eclipse.papyrus.diagram.usecase.ConstraintConstrainedElement_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4006 = getElementType("org.eclipse.papyrus.diagram.usecase.Dependency_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4007 = getElementType("org.eclipse.papyrus.diagram.usecase.CommentAnnotatedElement_4007"); //$NON-NLS-1$

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
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
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

			elements.put(Actor_2002, UMLPackage.eINSTANCE.getActor());

			elements.put(Actor_2003, UMLPackage.eINSTANCE.getActor());

			elements.put(UseCase_2004, UMLPackage.eINSTANCE.getUseCase());

			elements.put(UseCase_2005, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Component_2006, UMLPackage.eINSTANCE.getComponent());

			elements.put(Package_2009, UMLPackage.eINSTANCE.getPackage());

			elements.put(Constraint_2008, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_2010, UMLPackage.eINSTANCE.getComment());

			elements.put(ExtensionPoint_3002, UMLPackage.eINSTANCE
					.getExtensionPoint());

			elements.put(ExtensionPoint_3003, UMLPackage.eINSTANCE
					.getExtensionPoint());

			elements.put(UseCase_3004, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Actor_3005, UMLPackage.eINSTANCE.getActor());

			elements.put(UseCase_3006, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Include_4001, UMLPackage.eINSTANCE.getInclude());

			elements.put(Extend_4002, UMLPackage.eINSTANCE.getExtend());

			elements.put(Generalization_4003, UMLPackage.eINSTANCE
					.getGeneralization());

			elements.put(Association_4004, UMLPackage.eINSTANCE
					.getAssociation());

			elements.put(ConstraintConstrainedElement_4005,
					UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(Dependency_4006, UMLPackage.eINSTANCE.getDependency());

			elements.put(CommentAnnotatedElement_4007, UMLPackage.eINSTANCE
					.getComment_AnnotatedElement());
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
			KNOWN_ELEMENT_TYPES.add(Actor_2002);
			KNOWN_ELEMENT_TYPES.add(Actor_2003);
			KNOWN_ELEMENT_TYPES.add(UseCase_2004);
			KNOWN_ELEMENT_TYPES.add(UseCase_2005);
			KNOWN_ELEMENT_TYPES.add(Component_2006);
			KNOWN_ELEMENT_TYPES.add(Package_2009);
			KNOWN_ELEMENT_TYPES.add(Constraint_2008);
			KNOWN_ELEMENT_TYPES.add(Comment_2010);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3002);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3003);
			KNOWN_ELEMENT_TYPES.add(UseCase_3004);
			KNOWN_ELEMENT_TYPES.add(Actor_3005);
			KNOWN_ELEMENT_TYPES.add(UseCase_3006);
			KNOWN_ELEMENT_TYPES.add(Include_4001);
			KNOWN_ELEMENT_TYPES.add(Extend_4002);
			KNOWN_ELEMENT_TYPES.add(Generalization_4003);
			KNOWN_ELEMENT_TYPES.add(Association_4004);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4005);
			KNOWN_ELEMENT_TYPES.add(Dependency_4006);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4007);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
