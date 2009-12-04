/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.providers;

import java.util.HashMap;
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
import org.eclipse.papyrus.diagram.common.providers.BaseModelTypeProvider;
import org.eclipse.papyrus.diagram.common.providers.ModelTypesProviderFactory;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
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
	 * @generated NOT
	 */
	private static Map<IElementType, ImageDescriptor> pseudostateDescriptors;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

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
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass
					&& !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
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
	 * @generated NOT
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		IElementType type = (IElementType)hint.getAdapter(IElementType.class);
		if(type != null) {
			ImageDescriptor imageDescriptor = getPseudostateImageDescriptor(type);
			if(imageDescriptor != null) {
				return imageDescriptor;
			}
		}
		return getImageDescriptorGen(hint);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptorGen(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated NOT
	 */
	public static Image getImage(IAdaptable hint) {
		IElementType type = (IElementType)hint.getAdapter(IElementType.class);
		//if (type != null && getPseudostateImageDescriptors().containsKey(type)) {
		if(type != null && getPseudostateImageDescriptors().containsKey(type)) {
			String key = type.getId();
			Image image = getImageRegistry().get(key);
			if(image == null) {
				ImageDescriptor imageDescriptor = getPseudostateImageDescriptor(type);
				if(imageDescriptor != null) {
					getImageRegistry().put(key, imageDescriptor);
					image = getImageRegistry().get(key);
				}
			}
			return image;
		}
		return getImageGen(hint);
	}

	/**
	 * @generated
	 */
	public static Image getImageGen(IAdaptable hint) {
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

			elements.put(Package_79, UMLPackage.eINSTANCE.getPackage());

			elements.put(StateMachine_1001, UMLPackage.eINSTANCE
					.getStateMachine());

			elements.put(Comment_2024, UMLPackage.eINSTANCE.getComment());

			elements.put(Region_2001, UMLPackage.eINSTANCE.getRegion());

			elements.put(State_2002, UMLPackage.eINSTANCE.getState());

			elements.put(State_2003, UMLPackage.eINSTANCE.getState());

			elements.put(Region_2004, UMLPackage.eINSTANCE.getRegion());

			elements.put(State_2005, UMLPackage.eINSTANCE.getState());

			elements.put(ConnectionPointReference_2006, UMLPackage.eINSTANCE
					.getConnectionPointReference());

			elements.put(ConnectionPointReference_2007, UMLPackage.eINSTANCE
					.getConnectionPointReference());

			elements.put(FinalState_2008, UMLPackage.eINSTANCE.getFinalState());

			elements.put(Pseudostate_2009, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2010, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2011, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2012, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2013, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2014, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2015, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2016, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(State_2017, UMLPackage.eINSTANCE.getState());

			elements.put(Pseudostate_2018, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2019, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2020, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2021, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2022, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_2023, UMLPackage.eINSTANCE
					.getPseudostate());

			elements.put(Transition_3001, UMLPackage.eINSTANCE.getTransition());

			elements.put(ElementOwnedComment_3002, UMLPackage.eINSTANCE
					.getElement_OwnedComment());

			elements.put(CommentAnnotatedElement_3003, UMLPackage.eINSTANCE
					.getComment_AnnotatedElement());
		}
		return (ENamedElement)elements.get(type);
	}

	/**
	 * @generated NOT
	 */
	private static Map<IElementType, ImageDescriptor> getPseudostateImageDescriptors() {
		if(pseudostateDescriptors == null) {
			pseudostateDescriptors = new HashMap<IElementType, ImageDescriptor>();
			pseudostateDescriptors
					.put(
					Pseudostate_2009,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_initial.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2010,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_shallowHistory.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2011,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_deepHistory.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2012,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_fork.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2013,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_join.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2014,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_junction.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2015,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_choice.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2016,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_terminate.gif")); //$NON-NLS-1$

			pseudostateDescriptors
					.put(
					Pseudostate_2018,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
			pseudostateDescriptors
					.put(
					Pseudostate_2019,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$

			pseudostateDescriptors
					.put(
					Pseudostate_2020,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$

			pseudostateDescriptors
					.put(
					Pseudostate_2021,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$

			pseudostateDescriptors
					.put(
					Pseudostate_2022,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$

			pseudostateDescriptors
					.put(
					Pseudostate_2023,
					UMLDiagramEditorPlugin
					.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		}
		return pseudostateDescriptors;
	}

	/**
	 * @NOT generated
	 */
	private static ImageDescriptor getPseudostateImageDescriptor(
			IElementType hint) {
		return getPseudostateImageDescriptors().get(hint);
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
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IHintedType Package_79 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Package_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType StateMachine_1001 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.StateMachine_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2024 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Comment_2024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Region_2001 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Region_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_2002 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.State_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_2003 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.State_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Region_2004 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Region_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_2005 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.State_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConnectionPointReference_2006 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.ConnectionPointReference_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConnectionPointReference_2007 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.ConnectionPointReference_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType FinalState_2008 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.FinalState_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2009 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2010 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2011 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2012 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2013 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2014 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2015 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2016 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_2017 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.State_2017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2018 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2019 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2020 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2021 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2022 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_2023 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Pseudostate_2023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Transition_3001 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.Transition_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementOwnedComment_3002 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.ElementOwnedComment_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_3003 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.statemachine.CommentAnnotatedElement_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_79);
			KNOWN_ELEMENT_TYPES.add(StateMachine_1001);
			KNOWN_ELEMENT_TYPES.add(Comment_2024);
			KNOWN_ELEMENT_TYPES.add(Region_2001);
			KNOWN_ELEMENT_TYPES.add(State_2002);
			KNOWN_ELEMENT_TYPES.add(State_2003);
			KNOWN_ELEMENT_TYPES.add(Region_2004);
			KNOWN_ELEMENT_TYPES.add(State_2005);
			KNOWN_ELEMENT_TYPES.add(ConnectionPointReference_2006);
			KNOWN_ELEMENT_TYPES.add(ConnectionPointReference_2007);
			KNOWN_ELEMENT_TYPES.add(FinalState_2008);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2009);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2010);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2011);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2012);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2013);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2014);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2015);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2016);
			KNOWN_ELEMENT_TYPES.add(State_2017);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2018);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2019);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2020);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2021);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2022);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_2023);
			KNOWN_ELEMENT_TYPES.add(Transition_3001);
			KNOWN_ELEMENT_TYPES.add(ElementOwnedComment_3002);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_3003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static void refreshImageRegistry() {
		if(imageRegistry != null) {
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
