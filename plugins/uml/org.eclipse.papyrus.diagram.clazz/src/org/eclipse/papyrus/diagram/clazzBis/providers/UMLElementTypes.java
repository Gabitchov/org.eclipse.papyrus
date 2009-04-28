package org.eclipse.papyrus.diagram.clazzBis.providers;

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
	public static final IElementType Package_79 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_1001 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssociationClass_1002 = getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_1003 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_1003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InstanceSpecification_1004 = getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_1004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_1005 = getElementType("org.eclipse.papyrus.diagram.clazz.Component_1005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signal_1006 = getElementType("org.eclipse.papyrus.diagram.clazz.Signal_1006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_1007 = getElementType("org.eclipse.papyrus.diagram.clazz.Interface_1007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_1008 = getElementType("org.eclipse.papyrus.diagram.clazz.Model_1008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_1009 = getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_1009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_1010 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_1010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_1011 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_1011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_1012 = getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_1012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_1013 = getElementType("org.eclipse.papyrus.diagram.clazz.DataType_1013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_1014 = getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_1014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_1015 = getElementType("org.eclipse.papyrus.diagram.clazz.Comment_1015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2001 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Slot_2002 = getElementType("org.eclipse.papyrus.diagram.clazz.Slot_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_2003 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_2004 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RedefinableTemplateSignature_2005 = getElementType("org.eclipse.papyrus.diagram.clazz.RedefinableTemplateSignature_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateParameter_2006 = getElementType("org.eclipse.papyrus.diagram.clazz.TemplateParameter_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2007 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2008 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_2009 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_2010 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InstanceSpecification_2011 = getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_2012 = getElementType("org.eclipse.papyrus.diagram.clazz.Component_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Signal_2013 = getElementType("org.eclipse.papyrus.diagram.clazz.Signal_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interface_2014 = getElementType("org.eclipse.papyrus.diagram.clazz.Interface_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_2015 = getElementType("org.eclipse.papyrus.diagram.clazz.Model_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_2016 = getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnumerationLiteral_2017 = getElementType("org.eclipse.papyrus.diagram.clazz.EnumerationLiteral_2017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2018 = getElementType("org.eclipse.papyrus.diagram.clazz.Package_2018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_2019 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_2019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Reception_2020 = getElementType("org.eclipse.papyrus.diagram.clazz.Reception_2020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2021 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_2021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_2022 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_2022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_2023 = getElementType("org.eclipse.papyrus.diagram.clazz.Class_2023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_2024 = getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_2024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_2025 = getElementType("org.eclipse.papyrus.diagram.clazz.DataType_2025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2026 = getElementType("org.eclipse.papyrus.diagram.clazz.Property_2026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_2027 = getElementType("org.eclipse.papyrus.diagram.clazz.Operation_2027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2028 = getElementType("org.eclipse.papyrus.diagram.clazz.Comment_2028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2029 = getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_2029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_3001 = getElementType("org.eclipse.papyrus.diagram.clazz.Link_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AssociationClass_3002 = getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3003 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3004 = getElementType("org.eclipse.papyrus.diagram.clazz.Association_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_3005 = getElementType("org.eclipse.papyrus.diagram.clazz.Generalization_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterfaceRealization_3006 = getElementType("org.eclipse.papyrus.diagram.clazz.InterfaceRealization_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Substitution_3007 = getElementType("org.eclipse.papyrus.diagram.clazz.Substitution_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Realization_3008 = getElementType("org.eclipse.papyrus.diagram.clazz.Realization_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Abstraction_3009 = getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Usage_3010 = getElementType("org.eclipse.papyrus.diagram.clazz.Usage_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_3011 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_3012 = getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ElementImport_3013 = getElementType("org.eclipse.papyrus.diagram.clazz.ElementImport_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageImport_3014 = getElementType("org.eclipse.papyrus.diagram.clazz.PackageImport_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageMerge_3015 = getElementType("org.eclipse.papyrus.diagram.clazz.PackageMerge_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProfileApplication_3016 = getElementType("org.eclipse.papyrus.diagram.clazz.ProfileApplication_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_3017 = getElementType("org.eclipse.papyrus.diagram.clazz.CommentAnnotatedElement_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_3018 = getElementType("org.eclipse.papyrus.diagram.clazz.ConstraintConstrainedElement_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateBinding_3019 = getElementType("org.eclipse.papyrus.diagram.clazz.TemplateBinding_3019"); //$NON-NLS-1$

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
				return org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
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

			elements.put(Dependency_1001, UMLPackage.eINSTANCE.getDependency());

			elements.put(AssociationClass_1002, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Association_1003, UMLPackage.eINSTANCE.getAssociation());

			elements.put(InstanceSpecification_1004, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Component_1005, UMLPackage.eINSTANCE.getComponent());

			elements.put(Signal_1006, UMLPackage.eINSTANCE.getSignal());

			elements.put(Interface_1007, UMLPackage.eINSTANCE.getInterface());

			elements.put(Model_1008, UMLPackage.eINSTANCE.getModel());

			elements.put(Enumeration_1009, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(Package_1010, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_1011, UMLPackage.eINSTANCE.getClass_());

			elements.put(PrimitiveType_1012, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(DataType_1013, UMLPackage.eINSTANCE.getDataType());

			elements.put(Constraint_1014, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_1015, UMLPackage.eINSTANCE.getComment());

			elements.put(Property_2001, UMLPackage.eINSTANCE.getProperty());

			elements.put(Slot_2002, UMLPackage.eINSTANCE.getSlot());

			elements.put(Operation_2003, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_2004, UMLPackage.eINSTANCE.getClass_());

			elements.put(RedefinableTemplateSignature_2005, UMLPackage.eINSTANCE.getRedefinableTemplateSignature());

			elements.put(TemplateParameter_2006, UMLPackage.eINSTANCE.getTemplateParameter());

			elements.put(Property_2007, UMLPackage.eINSTANCE.getProperty());

			elements.put(Property_2008, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_2009, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_2010, UMLPackage.eINSTANCE.getClass_());

			elements.put(InstanceSpecification_2011, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Component_2012, UMLPackage.eINSTANCE.getComponent());

			elements.put(Signal_2013, UMLPackage.eINSTANCE.getSignal());

			elements.put(Interface_2014, UMLPackage.eINSTANCE.getInterface());

			elements.put(Model_2015, UMLPackage.eINSTANCE.getModel());

			elements.put(Enumeration_2016, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(EnumerationLiteral_2017, UMLPackage.eINSTANCE.getEnumerationLiteral());

			elements.put(Package_2018, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_2019, UMLPackage.eINSTANCE.getClass_());

			elements.put(Reception_2020, UMLPackage.eINSTANCE.getReception());

			elements.put(Property_2021, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_2022, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_2023, UMLPackage.eINSTANCE.getClass_());

			elements.put(PrimitiveType_2024, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(DataType_2025, UMLPackage.eINSTANCE.getDataType());

			elements.put(Property_2026, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_2027, UMLPackage.eINSTANCE.getOperation());

			elements.put(Comment_2028, UMLPackage.eINSTANCE.getComment());

			elements.put(Constraint_2029, UMLPackage.eINSTANCE.getConstraint());

			elements.put(AssociationClass_3002, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Association_3003, UMLPackage.eINSTANCE.getAssociation());

			elements.put(Association_3004, UMLPackage.eINSTANCE.getAssociation());

			elements.put(Generalization_3005, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(InterfaceRealization_3006, UMLPackage.eINSTANCE.getInterfaceRealization());

			elements.put(Substitution_3007, UMLPackage.eINSTANCE.getSubstitution());

			elements.put(Realization_3008, UMLPackage.eINSTANCE.getRealization());

			elements.put(Abstraction_3009, UMLPackage.eINSTANCE.getAbstraction());

			elements.put(Usage_3010, UMLPackage.eINSTANCE.getUsage());

			elements.put(Dependency_3011, UMLPackage.eINSTANCE.getDependency());

			elements.put(Dependency_3012, UMLPackage.eINSTANCE.getDependency());

			elements.put(ElementImport_3013, UMLPackage.eINSTANCE.getElementImport());

			elements.put(PackageImport_3014, UMLPackage.eINSTANCE.getPackageImport());

			elements.put(PackageMerge_3015, UMLPackage.eINSTANCE.getPackageMerge());

			elements.put(ProfileApplication_3016, UMLPackage.eINSTANCE.getProfileApplication());

			elements.put(CommentAnnotatedElement_3017, UMLPackage.eINSTANCE.getComment_AnnotatedElement());

			elements.put(ConstraintConstrainedElement_3018, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(TemplateBinding_3019, UMLPackage.eINSTANCE.getTemplateBinding());
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
			KNOWN_ELEMENT_TYPES.add(Dependency_1001);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_1002);
			KNOWN_ELEMENT_TYPES.add(Association_1003);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_1004);
			KNOWN_ELEMENT_TYPES.add(Component_1005);
			KNOWN_ELEMENT_TYPES.add(Signal_1006);
			KNOWN_ELEMENT_TYPES.add(Interface_1007);
			KNOWN_ELEMENT_TYPES.add(Model_1008);
			KNOWN_ELEMENT_TYPES.add(Enumeration_1009);
			KNOWN_ELEMENT_TYPES.add(Package_1010);
			KNOWN_ELEMENT_TYPES.add(Class_1011);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_1012);
			KNOWN_ELEMENT_TYPES.add(DataType_1013);
			KNOWN_ELEMENT_TYPES.add(Constraint_1014);
			KNOWN_ELEMENT_TYPES.add(Comment_1015);
			KNOWN_ELEMENT_TYPES.add(Property_2001);
			KNOWN_ELEMENT_TYPES.add(Slot_2002);
			KNOWN_ELEMENT_TYPES.add(Operation_2003);
			KNOWN_ELEMENT_TYPES.add(Class_2004);
			KNOWN_ELEMENT_TYPES.add(RedefinableTemplateSignature_2005);
			KNOWN_ELEMENT_TYPES.add(TemplateParameter_2006);
			KNOWN_ELEMENT_TYPES.add(Property_2007);
			KNOWN_ELEMENT_TYPES.add(Property_2008);
			KNOWN_ELEMENT_TYPES.add(Operation_2009);
			KNOWN_ELEMENT_TYPES.add(Class_2010);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_2011);
			KNOWN_ELEMENT_TYPES.add(Component_2012);
			KNOWN_ELEMENT_TYPES.add(Signal_2013);
			KNOWN_ELEMENT_TYPES.add(Interface_2014);
			KNOWN_ELEMENT_TYPES.add(Model_2015);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2016);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_2017);
			KNOWN_ELEMENT_TYPES.add(Package_2018);
			KNOWN_ELEMENT_TYPES.add(Class_2019);
			KNOWN_ELEMENT_TYPES.add(Reception_2020);
			KNOWN_ELEMENT_TYPES.add(Property_2021);
			KNOWN_ELEMENT_TYPES.add(Operation_2022);
			KNOWN_ELEMENT_TYPES.add(Class_2023);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_2024);
			KNOWN_ELEMENT_TYPES.add(DataType_2025);
			KNOWN_ELEMENT_TYPES.add(Property_2026);
			KNOWN_ELEMENT_TYPES.add(Operation_2027);
			KNOWN_ELEMENT_TYPES.add(Comment_2028);
			KNOWN_ELEMENT_TYPES.add(Constraint_2029);
			KNOWN_ELEMENT_TYPES.add(Link_3001);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_3002);
			KNOWN_ELEMENT_TYPES.add(Association_3003);
			KNOWN_ELEMENT_TYPES.add(Association_3004);
			KNOWN_ELEMENT_TYPES.add(Generalization_3005);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_3006);
			KNOWN_ELEMENT_TYPES.add(Substitution_3007);
			KNOWN_ELEMENT_TYPES.add(Realization_3008);
			KNOWN_ELEMENT_TYPES.add(Abstraction_3009);
			KNOWN_ELEMENT_TYPES.add(Usage_3010);
			KNOWN_ELEMENT_TYPES.add(Dependency_3011);
			KNOWN_ELEMENT_TYPES.add(Dependency_3012);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3013);
			KNOWN_ELEMENT_TYPES.add(PackageImport_3014);
			KNOWN_ELEMENT_TYPES.add(PackageMerge_3015);
			KNOWN_ELEMENT_TYPES.add(ProfileApplication_3016);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_3017);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_3018);
			KNOWN_ELEMENT_TYPES.add(TemplateBinding_3019);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			return Package_79;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return Dependency_1001;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return AssociationClass_1002;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return Association_1003;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecification_1004;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return Component_1005;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return Signal_1006;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return Interface_1007;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return Model_1008;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return Enumeration_1009;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return Package_1010;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return Class_1011;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return PrimitiveType_1012;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return DataType_1013;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return Constraint_1014;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return Comment_1015;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return Property_2001;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return Slot_2002;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return Operation_2003;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return Class_2004;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return RedefinableTemplateSignature_2005;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return TemplateParameter_2006;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return Property_2007;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return Property_2008;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return Operation_2009;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return Class_2010;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return InstanceSpecification_2011;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return Component_2012;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return Signal_2013;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return Interface_2014;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return Model_2015;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return Enumeration_2016;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return EnumerationLiteral_2017;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return Package_2018;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return Class_2019;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return Reception_2020;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return Property_2021;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return Operation_2022;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return Class_2023;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return PrimitiveType_2024;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return DataType_2025;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return Property_2026;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return Operation_2027;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return Comment_2028;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return Constraint_2029;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID:
			return Link_3001;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return AssociationClass_3002;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return Association_3003;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return Association_3004;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return Generalization_3005;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_3006;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return Substitution_3007;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return Realization_3008;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return Abstraction_3009;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return Usage_3010;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return Dependency_3011;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return Dependency_3012;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return ElementImport_3013;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return PackageImport_3014;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return PackageMerge_3015;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return ProfileApplication_3016;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_3017;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_3018;
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return TemplateBinding_3019;
		}
		return null;
	}

}
