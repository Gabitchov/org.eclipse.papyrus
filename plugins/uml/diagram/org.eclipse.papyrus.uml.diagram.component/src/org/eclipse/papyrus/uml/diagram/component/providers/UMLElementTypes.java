/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.providers;

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
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfacePortLinkEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.OperationForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ReceptionInInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.component.Model_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_3203 = getElementType("org.eclipse.papyrus.uml.diagram.component.DependencyNode_3203"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_2002 = getElementType("org.eclipse.papyrus.uml.diagram.component.Component_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_3202 = getElementType("org.eclipse.papyrus.uml.diagram.component.Model_3202"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_3200 = getElementType("org.eclipse.papyrus.uml.diagram.component.Package_3200"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3201 = getElementType("org.eclipse.papyrus.uml.diagram.component.Comment_3201"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3199 = getElementType("org.eclipse.papyrus.uml.diagram.component.Comment_3199"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_3205 = getElementType("org.eclipse.papyrus.uml.diagram.component.Interface_3205"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_3204 = getElementType("org.eclipse.papyrus.uml.diagram.component.DefaultNamedElement_3204"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_2003 = getElementType("org.eclipse.papyrus.uml.diagram.component.Interface_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Port_3069 = getElementType("org.eclipse.papyrus.uml.diagram.component.Port_3069"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_3077 = getElementType("org.eclipse.papyrus.uml.diagram.component.Model_3077"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_3076 = getElementType("org.eclipse.papyrus.uml.diagram.component.Package_3076"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_3078 = getElementType("org.eclipse.papyrus.uml.diagram.component.Interface_3078"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_3070 = getElementType("org.eclipse.papyrus.uml.diagram.component.Component_3070"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_3071 = getElementType("org.eclipse.papyrus.uml.diagram.component.Component_3071"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_3072 = getElementType("org.eclipse.papyrus.uml.diagram.component.Interface_3072"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3074 = getElementType("org.eclipse.papyrus.uml.diagram.component.Comment_3074"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3075 = getElementType("org.eclipse.papyrus.uml.diagram.component.Constraint_3075"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_1 = getElementType("org.eclipse.papyrus.uml.diagram.component.Property_1"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_5 = getElementType("org.eclipse.papyrus.uml.diagram.component.Operation_5"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Reception_6 = getElementType("org.eclipse.papyrus.uml.diagram.component.Reception_6"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Usage_4001 = getElementType("org.eclipse.papyrus.uml.diagram.component.Usage_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterfaceRealization_4006 = getElementType("org.eclipse.papyrus.uml.diagram.component.InterfaceRealization_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4003 = getElementType("org.eclipse.papyrus.uml.diagram.component.Generalization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Substitution_4012 = getElementType("org.eclipse.papyrus.uml.diagram.component.Substitution_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Manifestation_4014 = getElementType("org.eclipse.papyrus.uml.diagram.component.Manifestation_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ComponentRealization_4007 = getElementType("org.eclipse.papyrus.uml.diagram.component.ComponentRealization_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Abstraction_4013 = getElementType("org.eclipse.papyrus.uml.diagram.component.Abstraction_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4016 = getElementType("org.eclipse.papyrus.uml.diagram.component.Link_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4015 = getElementType("org.eclipse.papyrus.uml.diagram.component.CommentAnnotatedElement_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4009 = getElementType("org.eclipse.papyrus.uml.diagram.component.ConstraintConstrainedElement_4009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4010 = getElementType("org.eclipse.papyrus.uml.diagram.component.Dependency_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4017 = getElementType("org.eclipse.papyrus.uml.diagram.component.Dependency_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4018 = getElementType("org.eclipse.papyrus.uml.diagram.component.Link_4018"); //$NON-NLS-1$

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
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(Dependency_3203, UMLPackage.eINSTANCE.getDependency());
			elements.put(Component_2002, UMLPackage.eINSTANCE.getComponent());
			elements.put(Model_3202, UMLPackage.eINSTANCE.getModel());
			elements.put(Package_3200, UMLPackage.eINSTANCE.getPackage());
			elements.put(Interface_3205, UMLPackage.eINSTANCE.getInterface());
			elements.put(Comment_3201, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_3199, UMLPackage.eINSTANCE.getConstraint());
			elements.put(NamedElement_3204, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(NamedElement_2003, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(Port_3069, UMLPackage.eINSTANCE.getPort());
			elements.put(Model_3077, UMLPackage.eINSTANCE.getModel());
			elements.put(Package_3076, UMLPackage.eINSTANCE.getPackage());
			elements.put(Interface_3078, UMLPackage.eINSTANCE.getInterface());
			elements.put(Component_3070, UMLPackage.eINSTANCE.getComponent());
			elements.put(Component_3071, UMLPackage.eINSTANCE.getComponent());
			elements.put(Comment_3074, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_3075, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Property_1, UMLPackage.eINSTANCE.getProperty());
			elements.put(Operation_5, UMLPackage.eINSTANCE.getOperation());
			elements.put(Reception_6, UMLPackage.eINSTANCE.getReception());
			elements.put(Interface_3072, UMLPackage.eINSTANCE.getInterface());
			elements.put(Usage_4001, UMLPackage.eINSTANCE.getUsage());
			elements.put(InterfaceRealization_4006, UMLPackage.eINSTANCE.getInterfaceRealization());
			elements.put(Generalization_4003, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(Substitution_4012, UMLPackage.eINSTANCE.getSubstitution());
			elements.put(Manifestation_4014, UMLPackage.eINSTANCE.getManifestation());
			elements.put(ComponentRealization_4007, UMLPackage.eINSTANCE.getComponentRealization());
			elements.put(Abstraction_4013, UMLPackage.eINSTANCE.getAbstraction());
			elements.put(CommentAnnotatedElement_4015, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4009, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
			elements.put(Dependency_4010, UMLPackage.eINSTANCE.getDependency());
			elements.put(Dependency_4017, UMLPackage.eINSTANCE.getDependency());
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
			KNOWN_ELEMENT_TYPES.add(Dependency_3203);
			KNOWN_ELEMENT_TYPES.add(Component_2002);
			KNOWN_ELEMENT_TYPES.add(Model_3202);
			KNOWN_ELEMENT_TYPES.add(Package_3200);
			KNOWN_ELEMENT_TYPES.add(Interface_3205);
			KNOWN_ELEMENT_TYPES.add(Comment_3201);
			KNOWN_ELEMENT_TYPES.add(Constraint_3199);
			KNOWN_ELEMENT_TYPES.add(NamedElement_3204);
			KNOWN_ELEMENT_TYPES.add(NamedElement_2003);
			KNOWN_ELEMENT_TYPES.add(Port_3069);
			KNOWN_ELEMENT_TYPES.add(Model_3077);
			KNOWN_ELEMENT_TYPES.add(Package_3076);
			KNOWN_ELEMENT_TYPES.add(Interface_3078);
			KNOWN_ELEMENT_TYPES.add(Component_3070);
			KNOWN_ELEMENT_TYPES.add(Component_3071);
			KNOWN_ELEMENT_TYPES.add(Comment_3074);
			KNOWN_ELEMENT_TYPES.add(Constraint_3075);
			KNOWN_ELEMENT_TYPES.add(Property_1);
			KNOWN_ELEMENT_TYPES.add(Operation_5);
			KNOWN_ELEMENT_TYPES.add(Reception_6);
			KNOWN_ELEMENT_TYPES.add(Interface_3072);
			KNOWN_ELEMENT_TYPES.add(Usage_4001);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4006);
			KNOWN_ELEMENT_TYPES.add(Generalization_4003);
			KNOWN_ELEMENT_TYPES.add(Substitution_4012);
			KNOWN_ELEMENT_TYPES.add(Manifestation_4014);
			KNOWN_ELEMENT_TYPES.add(ComponentRealization_4007);
			KNOWN_ELEMENT_TYPES.add(Abstraction_4013);
			KNOWN_ELEMENT_TYPES.add(Link_4016);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4015);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4009);
			KNOWN_ELEMENT_TYPES.add(Dependency_4010);
			KNOWN_ELEMENT_TYPES.add(Dependency_4017);
			KNOWN_ELEMENT_TYPES.add(Link_4018);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case DependencyNodeEditPart.VISUAL_ID:
			return Dependency_3203;
		case ComponentEditPart.VISUAL_ID:
			return Component_2002;
		case ModelEditPart.VISUAL_ID:
			return Model_3202;
		case PackageEditPart.VISUAL_ID:
			return Package_3200;
		case RectangleInterfaceEditPart.VISUAL_ID:
			return Interface_3205;
		case CommentEditPart.VISUAL_ID:
			return Comment_3201;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_3199;
		case DefaultNamedElementEditPart.VISUAL_ID:
			return NamedElement_3204;
		case InterfaceEditPart.VISUAL_ID:
			return NamedElement_2003;
		case PortEditPart.VISUAL_ID:
			return Port_3069;
		case ModelEditPartCN.VISUAL_ID:
			return Model_3077;
		case PackageEditPartCN.VISUAL_ID:
			return Package_3076;
		case RectangleInterfaceEditPartCN.VISUAL_ID:
			return Interface_3078;
		case ComponentEditPartCN.VISUAL_ID:
			return Component_3070;
		case ComponentEditPartPCN.VISUAL_ID:
			return Component_3071;
		case CommentEditPartPCN.VISUAL_ID:
			return Comment_3074;
		case ConstraintEditPartPCN.VISUAL_ID:
			return Constraint_3075;
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return Property_1;
		case OperationForInterfaceEditPart.VISUAL_ID:
			return Operation_5;
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return Reception_6;
		case InterfaceEditPartPCN.VISUAL_ID:
			return Interface_3072;
		case UsageEditPart.VISUAL_ID:
			return Usage_4001;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_4006;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4003;
		case SubstitutionEditPart.VISUAL_ID:
			return Substitution_4012;
		case ManifestationEditPart.VISUAL_ID:
			return Manifestation_4014;
		case ComponentRealizationEditPart.VISUAL_ID:
			return ComponentRealization_4007;
		case AbstractionEditPart.VISUAL_ID:
			return Abstraction_4013;
		case LinkDescriptorEditPart.VISUAL_ID:
			return Link_4016;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4015;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4009;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4010;
		case DependencyBranchEditPart.VISUAL_ID:
			return Dependency_4017;
		case InterfacePortLinkEditPart.VISUAL_ID:
			return Link_4018;
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
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
