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
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.providers.BaseModelTypeProvider;
import org.eclipse.papyrus.diagram.common.providers.ModelTypesProviderFactory;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;

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
	public static final IHintedType Package_79 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Package_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interaction_1001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Interaction_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Interaction_2001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Interaction_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Lifeline_2002 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Lifeline_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType BehaviorExecutionSpecification_2003 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.BehaviorExecutionSpecification_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType CombinedFragment_2004 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.CombinedFragment_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2005 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Comment_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Message_3001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Message_3002 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Message_3003 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Message_3004 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Message_3005 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IHintedType Message_3006 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.Message_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementOwnedComment_3007 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.ElementOwnedComment_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_3008 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.sequence.CommentAnnotatedElement_3008"); //$NON-NLS-1$

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

			elements.put(Package_79, UMLPackage.eINSTANCE.getPackage());

			elements.put(Interaction_1001, UMLPackage.eINSTANCE
					.getInteraction());

			elements.put(Comment_2005, UMLPackage.eINSTANCE.getComment());

			elements.put(Interaction_2001, UMLPackage.eINSTANCE
					.getInteraction());

			elements.put(Lifeline_2002, UMLPackage.eINSTANCE.getLifeline());

			elements.put(BehaviorExecutionSpecification_2003,
					UMLPackage.eINSTANCE.getBehaviorExecutionSpecification());

			elements.put(CombinedFragment_2004, UMLPackage.eINSTANCE
					.getCombinedFragment());

			elements.put(Message_3001, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_3002, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_3003, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_3004, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_3005, UMLPackage.eINSTANCE.getMessage());

			elements.put(Message_3006, UMLPackage.eINSTANCE.getMessage());

			elements.put(ElementOwnedComment_3007, UMLPackage.eINSTANCE
					.getElement_OwnedComment());

			elements.put(CommentAnnotatedElement_3008, UMLPackage.eINSTANCE
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
			KNOWN_ELEMENT_TYPES.add(Package_79);
			KNOWN_ELEMENT_TYPES.add(Interaction_1001);
			KNOWN_ELEMENT_TYPES.add(Comment_2005);
			KNOWN_ELEMENT_TYPES.add(Interaction_2001);
			KNOWN_ELEMENT_TYPES.add(Lifeline_2002);
			KNOWN_ELEMENT_TYPES.add(BehaviorExecutionSpecification_2003);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_2004);
			KNOWN_ELEMENT_TYPES.add(Message_3001);
			KNOWN_ELEMENT_TYPES.add(Message_3002);
			KNOWN_ELEMENT_TYPES.add(Message_3003);
			KNOWN_ELEMENT_TYPES.add(Message_3004);
			KNOWN_ELEMENT_TYPES.add(Message_3005);
			KNOWN_ELEMENT_TYPES.add(Message_3006);
			KNOWN_ELEMENT_TYPES.add(ElementOwnedComment_3007);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_3008);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static void refreshImageRegistry() {
		if (imageRegistry != null) {
			imageRegistry.dispose();
			imageRegistry = null;
		}
		imageRegistry = new ImageRegistry();
	}

	/**
	 * @generated
	 */
	static {
		ModelTypesProviderFactory.registerModelTypesProvider(
				UMLDiagramEditor.ID, new BaseModelTypeProvider() {
					@Override
					public Image getImageHelper(IAdaptable hint) {
						return getImage(hint);
					}
				});
	}

}
