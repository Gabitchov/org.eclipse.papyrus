/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_2014 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InstanceSpecification_2001 = getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_2002 = getElementType("org.eclipse.papyrus.diagram.clazz.Component_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signal_2003 = getElementType("org.eclipse.papyrus.diagram.clazz.Signal_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_2004 = getElementType("org.eclipse.papyrus.diagram.clazz.Interface_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_2005 = getElementType("org.eclipse.papyrus.diagram.clazz.Model_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_2006 = getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2007 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_2008 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_2009 = getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_2010 = getElementType("org.eclipse.papyrus.diagram.clazz.DataType_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2011 = getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2012 = getElementType("org.eclipse.papyrus.diagram.clazz.Comment_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssociationClass_2013 = getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_2015 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Slot_3001 = getElementType("org.eclipse.papyrus.diagram.clazz.Slot_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3002 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3003 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_3004 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3005 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3006 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3007 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_3008 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_3009 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InstanceSpecification_3020 = getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_3021 = getElementType("org.eclipse.papyrus.diagram.clazz.Component_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signal_3022 = getElementType("org.eclipse.papyrus.diagram.clazz.Signal_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_3023 = getElementType("org.eclipse.papyrus.diagram.clazz.Interface_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_3024 = getElementType("org.eclipse.papyrus.diagram.clazz.Model_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_3010 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Reception_3011 = getElementType("org.eclipse.papyrus.diagram.clazz.Reception_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3012 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3013 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_3014 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RedefinableTemplateSignature_3015 = getElementType("org.eclipse.papyrus.diagram.clazz.RedefinableTemplateSignature_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateParameter_3016 = getElementType("org.eclipse.papyrus.diagram.clazz.TemplateParameter_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_3025 = getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnumerationLiteral_3017 = getElementType("org.eclipse.papyrus.diagram.clazz.EnumerationLiteral_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_3026 = getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_3027 = getElementType("org.eclipse.papyrus.diagram.clazz.DataType_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3018 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3019 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3028 = getElementType("org.eclipse.papyrus.diagram.clazz.Comment_3028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3029 = getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_3029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4016 = getElementType("org.eclipse.papyrus.diagram.clazz.Link_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssociationClass_4017 = getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4001 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4019 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_4019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4002 = getElementType("org.eclipse.papyrus.diagram.clazz.Generalization_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterfaceRealization_4003 = getElementType("org.eclipse.papyrus.diagram.clazz.InterfaceRealization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Substitution_4004 = getElementType("org.eclipse.papyrus.diagram.clazz.Substitution_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Realization_4005 = getElementType("org.eclipse.papyrus.diagram.clazz.Realization_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Abstraction_4006 = getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Usage_4007 = getElementType("org.eclipse.papyrus.diagram.clazz.Usage_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4008 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4018 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_4018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ElementImport_4009 = getElementType("org.eclipse.papyrus.diagram.clazz.ElementImport_4009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageImport_4010 = getElementType("org.eclipse.papyrus.diagram.clazz.PackageImport_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageMerge_4011 = getElementType("org.eclipse.papyrus.diagram.clazz.PackageMerge_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProfileApplication_4012 = getElementType("org.eclipse.papyrus.diagram.clazz.ProfileApplication_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4013 = getElementType("org.eclipse.papyrus.diagram.clazz.CommentAnnotatedElement_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4014 = getElementType("org.eclipse.papyrus.diagram.clazz.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateBinding_4015 = getElementType("org.eclipse.papyrus.diagram.clazz.TemplateBinding_4015"); //$NON-NLS-1$

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

			elements.put(Dependency_2014, UMLPackage.eINSTANCE.getDependency());

			elements.put(AssociationClass_2013, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Association_2015, UMLPackage.eINSTANCE.getAssociation());

			elements.put(InstanceSpecification_2001, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Component_2002, UMLPackage.eINSTANCE.getComponent());

			elements.put(Signal_2003, UMLPackage.eINSTANCE.getSignal());

			elements.put(Interface_2004, UMLPackage.eINSTANCE.getInterface());

			elements.put(Model_2005, UMLPackage.eINSTANCE.getModel());

			elements.put(Enumeration_2006, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(Package_2007, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_2008, UMLPackage.eINSTANCE.getClass_());

			elements.put(PrimitiveType_2009, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(DataType_2010, UMLPackage.eINSTANCE.getDataType());

			elements.put(Constraint_2011, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_2012, UMLPackage.eINSTANCE.getComment());

			elements.put(Property_3002, UMLPackage.eINSTANCE.getProperty());

			elements.put(Slot_3001, UMLPackage.eINSTANCE.getSlot());

			elements.put(Operation_3003, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3004, UMLPackage.eINSTANCE.getClass_());

			elements.put(RedefinableTemplateSignature_3015, UMLPackage.eINSTANCE.getRedefinableTemplateSignature());

			elements.put(TemplateParameter_3016, UMLPackage.eINSTANCE.getTemplateParameter());

			elements.put(Property_3005, UMLPackage.eINSTANCE.getProperty());

			elements.put(Property_3006, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3007, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3008, UMLPackage.eINSTANCE.getClass_());

			elements.put(InstanceSpecification_3020, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Component_3021, UMLPackage.eINSTANCE.getComponent());

			elements.put(Signal_3022, UMLPackage.eINSTANCE.getSignal());

			elements.put(Interface_3023, UMLPackage.eINSTANCE.getInterface());

			elements.put(Model_3024, UMLPackage.eINSTANCE.getModel());

			elements.put(Enumeration_3025, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(EnumerationLiteral_3017, UMLPackage.eINSTANCE.getEnumerationLiteral());

			elements.put(Package_3009, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_3010, UMLPackage.eINSTANCE.getClass_());

			elements.put(Reception_3011, UMLPackage.eINSTANCE.getReception());

			elements.put(Property_3012, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3013, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3014, UMLPackage.eINSTANCE.getClass_());

			elements.put(PrimitiveType_3026, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(DataType_3027, UMLPackage.eINSTANCE.getDataType());

			elements.put(Property_3018, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3019, UMLPackage.eINSTANCE.getOperation());

			elements.put(Comment_3028, UMLPackage.eINSTANCE.getComment());

			elements.put(Constraint_3029, UMLPackage.eINSTANCE.getConstraint());

			elements.put(AssociationClass_4017, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Association_4001, UMLPackage.eINSTANCE.getAssociation());

			elements.put(Association_4019, UMLPackage.eINSTANCE.getAssociation());

			elements.put(Generalization_4002, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(InterfaceRealization_4003, UMLPackage.eINSTANCE.getInterfaceRealization());

			elements.put(Substitution_4004, UMLPackage.eINSTANCE.getSubstitution());

			elements.put(Realization_4005, UMLPackage.eINSTANCE.getRealization());

			elements.put(Abstraction_4006, UMLPackage.eINSTANCE.getAbstraction());

			elements.put(Usage_4007, UMLPackage.eINSTANCE.getUsage());

			elements.put(Dependency_4008, UMLPackage.eINSTANCE.getDependency());

			elements.put(Dependency_4018, UMLPackage.eINSTANCE.getDependency());

			elements.put(ElementImport_4009, UMLPackage.eINSTANCE.getElementImport());

			elements.put(PackageImport_4010, UMLPackage.eINSTANCE.getPackageImport());

			elements.put(PackageMerge_4011, UMLPackage.eINSTANCE.getPackageMerge());

			elements.put(ProfileApplication_4012, UMLPackage.eINSTANCE.getProfileApplication());

			elements.put(CommentAnnotatedElement_4013, UMLPackage.eINSTANCE.getComment_AnnotatedElement());

			elements.put(ConstraintConstrainedElement_4014, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(TemplateBinding_4015, UMLPackage.eINSTANCE.getTemplateBinding());
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
			KNOWN_ELEMENT_TYPES.add(Dependency_2014);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_2013);
			KNOWN_ELEMENT_TYPES.add(Association_2015);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_2001);
			KNOWN_ELEMENT_TYPES.add(Component_2002);
			KNOWN_ELEMENT_TYPES.add(Signal_2003);
			KNOWN_ELEMENT_TYPES.add(Interface_2004);
			KNOWN_ELEMENT_TYPES.add(Model_2005);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2006);
			KNOWN_ELEMENT_TYPES.add(Package_2007);
			KNOWN_ELEMENT_TYPES.add(Class_2008);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_2009);
			KNOWN_ELEMENT_TYPES.add(DataType_2010);
			KNOWN_ELEMENT_TYPES.add(Constraint_2011);
			KNOWN_ELEMENT_TYPES.add(Comment_2012);
			KNOWN_ELEMENT_TYPES.add(Property_3002);
			KNOWN_ELEMENT_TYPES.add(Slot_3001);
			KNOWN_ELEMENT_TYPES.add(Operation_3003);
			KNOWN_ELEMENT_TYPES.add(Class_3004);
			KNOWN_ELEMENT_TYPES.add(RedefinableTemplateSignature_3015);
			KNOWN_ELEMENT_TYPES.add(TemplateParameter_3016);
			KNOWN_ELEMENT_TYPES.add(Property_3005);
			KNOWN_ELEMENT_TYPES.add(Property_3006);
			KNOWN_ELEMENT_TYPES.add(Operation_3007);
			KNOWN_ELEMENT_TYPES.add(Class_3008);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_3020);
			KNOWN_ELEMENT_TYPES.add(Component_3021);
			KNOWN_ELEMENT_TYPES.add(Signal_3022);
			KNOWN_ELEMENT_TYPES.add(Interface_3023);
			KNOWN_ELEMENT_TYPES.add(Model_3024);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3025);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_3017);
			KNOWN_ELEMENT_TYPES.add(Package_3009);
			KNOWN_ELEMENT_TYPES.add(Class_3010);
			KNOWN_ELEMENT_TYPES.add(Reception_3011);
			KNOWN_ELEMENT_TYPES.add(Property_3012);
			KNOWN_ELEMENT_TYPES.add(Operation_3013);
			KNOWN_ELEMENT_TYPES.add(Class_3014);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_3026);
			KNOWN_ELEMENT_TYPES.add(DataType_3027);
			KNOWN_ELEMENT_TYPES.add(Property_3018);
			KNOWN_ELEMENT_TYPES.add(Operation_3019);
			KNOWN_ELEMENT_TYPES.add(Comment_3028);
			KNOWN_ELEMENT_TYPES.add(Constraint_3029);
			KNOWN_ELEMENT_TYPES.add(Link_4016);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_4017);
			KNOWN_ELEMENT_TYPES.add(Association_4001);
			KNOWN_ELEMENT_TYPES.add(Association_4019);
			KNOWN_ELEMENT_TYPES.add(Generalization_4002);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4003);
			KNOWN_ELEMENT_TYPES.add(Substitution_4004);
			KNOWN_ELEMENT_TYPES.add(Realization_4005);
			KNOWN_ELEMENT_TYPES.add(Abstraction_4006);
			KNOWN_ELEMENT_TYPES.add(Usage_4007);
			KNOWN_ELEMENT_TYPES.add(Dependency_4008);
			KNOWN_ELEMENT_TYPES.add(Dependency_4018);
			KNOWN_ELEMENT_TYPES.add(ElementImport_4009);
			KNOWN_ELEMENT_TYPES.add(PackageImport_4010);
			KNOWN_ELEMENT_TYPES.add(PackageMerge_4011);
			KNOWN_ELEMENT_TYPES.add(ProfileApplication_4012);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4013);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4014);
			KNOWN_ELEMENT_TYPES.add(TemplateBinding_4015);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
