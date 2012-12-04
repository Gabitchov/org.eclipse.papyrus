package org.eclipse.papyrus.uml.diagram.component.providers;

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
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
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
	private static ImageRegistry imageRegistry;

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
	public static final IElementType Component_2002 = getElementType("org.eclipse.papyrus.uml.diagram.component.Component_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_2003 = getElementType("org.eclipse.papyrus.uml.diagram.component.Interface_2003"); //$NON-NLS-1$

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
	public static final IElementType Port_3069 = getElementType("org.eclipse.papyrus.uml.diagram.component.Port_3069"); //$NON-NLS-1$

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
			elements.put(Component_2002, UMLPackage.eINSTANCE.getComponent());
			elements.put(Interface_2003, UMLPackage.eINSTANCE.getInterface());
			elements.put(Package_3200, UMLPackage.eINSTANCE.getPackage());
			elements.put(Comment_3201, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_3199, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Port_3069, UMLPackage.eINSTANCE.getPort());
			elements.put(Component_3070, UMLPackage.eINSTANCE.getComponent());
			elements.put(Component_3071, UMLPackage.eINSTANCE.getComponent());
			elements.put(Interface_3072, UMLPackage.eINSTANCE.getInterface());
			elements.put(Comment_3074, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_3075, UMLPackage.eINSTANCE.getConstraint());
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
			KNOWN_ELEMENT_TYPES.add(Component_2002);
			KNOWN_ELEMENT_TYPES.add(Interface_2003);
			KNOWN_ELEMENT_TYPES.add(Package_3200);
			KNOWN_ELEMENT_TYPES.add(Comment_3201);
			KNOWN_ELEMENT_TYPES.add(Constraint_3199);
			KNOWN_ELEMENT_TYPES.add(Port_3069);
			KNOWN_ELEMENT_TYPES.add(Component_3070);
			KNOWN_ELEMENT_TYPES.add(Component_3071);
			KNOWN_ELEMENT_TYPES.add(Interface_3072);
			KNOWN_ELEMENT_TYPES.add(Comment_3074);
			KNOWN_ELEMENT_TYPES.add(Constraint_3075);
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
		case ComponentEditPart.VISUAL_ID:
			return Component_2002;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_2003;
		case PackageEditPart.VISUAL_ID:
			return Package_3200;
		case CommentEditPart.VISUAL_ID:
			return Comment_3201;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_3199;
		case PortEditPart.VISUAL_ID:
			return Port_3069;
		case ComponentEditPartCN.VISUAL_ID:
			return Component_3070;
		case ComponentEditPartPCN.VISUAL_ID:
			return Component_3071;
		case InterfaceEditPartPCN.VISUAL_ID:
			return Interface_3072;
		case CommentEditPartPCN.VISUAL_ID:
			return Comment_3074;
		case ConstraintEditPartPCN.VISUAL_ID:
			return Constraint_3075;
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
		}
		return null;
	}
}
