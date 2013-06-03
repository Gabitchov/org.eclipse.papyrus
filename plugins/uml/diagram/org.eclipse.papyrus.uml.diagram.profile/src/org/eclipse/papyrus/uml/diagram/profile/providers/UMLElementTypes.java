/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassPropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Profile_1000 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Profile_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_2014 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Dependency_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_2015 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Association_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Stereotype_1026 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Stereotype_1026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_1031 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Metaclass_1031"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_1002 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Comment_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_1014 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Constraint_1014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_2005 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Model_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Profile_1030 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Profile_1030"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2007 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Package_1004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_2006 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Enumeration_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_2009 = getElementType("org.eclipse.papyrus.uml.diagram.profile.PrimitiveType_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_2010 = getElementType("org.eclipse.papyrus.uml.diagram.profile.DataType_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Diagram_2016 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Diagram_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_3026 = getElementType("org.eclipse.papyrus.uml.diagram.profile.PrimitiveType_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3019 = getElementType("org.eclipse.papyrus.uml.diagram.profile.DataTypeOperation_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnumerationLiteral_1037 = getElementType("org.eclipse.papyrus.uml.diagram.profile.EnumerationLiteral_1037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3018 = getElementType("org.eclipse.papyrus.uml.diagram.profile.DataTypeProperty_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3002 = getElementType("org.eclipse.papyrus.uml.diagram.profile.ClassProperty_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operation_3020 = getElementType("org.eclipse.papyrus.uml.diagram.profile.ClassOperation_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Stereotype_1023 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Stereotype_1023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_3028 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Metaclass_3028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_1007 = getElementType("org.eclipse.papyrus.uml.diagram.profile.CommentCN_1007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_1027 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Model_1027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Profile_1024 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Profile_1024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_1012 = getElementType("org.eclipse.papyrus.uml.diagram.profile.PackageCN_1012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_1028 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Constraint_1028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Enumeration_3025 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Enumeration_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataType_3027 = getElementType("org.eclipse.papyrus.uml.diagram.profile.DataType_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Extension_1013 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Extension_1013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4001 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Association_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProfileApplication_1045 = getElementType("org.eclipse.papyrus.uml.diagram.profile.ProfileApplication_1045"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4019 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Association_4019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4002 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Generalization_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4008 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Dependency_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4018 = getElementType("org.eclipse.papyrus.uml.diagram.profile.Dependency_4018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ElementImport_1064 = getElementType("org.eclipse.papyrus.uml.diagram.profile.ElementImport_1064"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageImport_1065 = getElementType("org.eclipse.papyrus.uml.diagram.profile.PackageImport_1065"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_1022 = getElementType("org.eclipse.papyrus.uml.diagram.profile.CommentAnnotatedElement_1022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4014 = getElementType("org.eclipse.papyrus.uml.diagram.profile.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

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
			elements.put(Profile_1000, UMLPackage.eINSTANCE.getProfile());
			elements.put(Dependency_2014, UMLPackage.eINSTANCE.getDependency());
			elements.put(Association_2015, UMLPackage.eINSTANCE.getAssociation());
			elements.put(Stereotype_1026, UMLPackage.eINSTANCE.getStereotype());
			elements.put(Class_1031, UMLPackage.eINSTANCE.getClass_());
			elements.put(Comment_1002, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_1014, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Model_2005, UMLPackage.eINSTANCE.getModel());
			elements.put(Profile_1030, UMLPackage.eINSTANCE.getProfile());
			elements.put(Package_2007, UMLPackage.eINSTANCE.getPackage());
			elements.put(Enumeration_2006, UMLPackage.eINSTANCE.getEnumeration());
			elements.put(PrimitiveType_2009, UMLPackage.eINSTANCE.getPrimitiveType());
			elements.put(DataType_2010, UMLPackage.eINSTANCE.getDataType());
			elements.put(Diagram_2016, NotationPackage.eINSTANCE.getDiagram());
			elements.put(PrimitiveType_3026, UMLPackage.eINSTANCE.getPrimitiveType());
			elements.put(Operation_3019, UMLPackage.eINSTANCE.getOperation());
			elements.put(EnumerationLiteral_1037, UMLPackage.eINSTANCE.getEnumerationLiteral());
			elements.put(Property_3018, UMLPackage.eINSTANCE.getProperty());
			elements.put(Property_3002, UMLPackage.eINSTANCE.getProperty());
			elements.put(Operation_3020, UMLPackage.eINSTANCE.getOperation());
			elements.put(Stereotype_1023, UMLPackage.eINSTANCE.getStereotype());
			elements.put(Class_3028, UMLPackage.eINSTANCE.getClass_());
			elements.put(Comment_1007, UMLPackage.eINSTANCE.getComment());
			elements.put(Model_1027, UMLPackage.eINSTANCE.getModel());
			elements.put(Profile_1024, UMLPackage.eINSTANCE.getProfile());
			elements.put(Package_1012, UMLPackage.eINSTANCE.getPackage());
			elements.put(Constraint_1028, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Enumeration_3025, UMLPackage.eINSTANCE.getEnumeration());
			elements.put(DataType_3027, UMLPackage.eINSTANCE.getDataType());
			elements.put(Extension_1013, UMLPackage.eINSTANCE.getExtension());
			elements.put(Association_4001, UMLPackage.eINSTANCE.getAssociation());
			elements.put(ProfileApplication_1045, UMLPackage.eINSTANCE.getProfileApplication());
			elements.put(Association_4019, UMLPackage.eINSTANCE.getAssociation());
			elements.put(Generalization_4002, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(Dependency_4008, UMLPackage.eINSTANCE.getDependency());
			elements.put(Dependency_4018, UMLPackage.eINSTANCE.getDependency());
			elements.put(ElementImport_1064, UMLPackage.eINSTANCE.getElementImport());
			elements.put(PackageImport_1065, UMLPackage.eINSTANCE.getPackageImport());
			elements.put(CommentAnnotatedElement_1022, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4014, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
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
			KNOWN_ELEMENT_TYPES.add(Profile_1000);
			KNOWN_ELEMENT_TYPES.add(Dependency_2014);
			KNOWN_ELEMENT_TYPES.add(Association_2015);
			KNOWN_ELEMENT_TYPES.add(Stereotype_1026);
			KNOWN_ELEMENT_TYPES.add(Class_1031);
			KNOWN_ELEMENT_TYPES.add(Comment_1002);
			KNOWN_ELEMENT_TYPES.add(Constraint_1014);
			KNOWN_ELEMENT_TYPES.add(Model_2005);
			KNOWN_ELEMENT_TYPES.add(Profile_1030);
			KNOWN_ELEMENT_TYPES.add(Package_2007);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2006);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_2009);
			KNOWN_ELEMENT_TYPES.add(DataType_2010);
			KNOWN_ELEMENT_TYPES.add(Diagram_2016);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_3026);
			KNOWN_ELEMENT_TYPES.add(Operation_3019);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_1037);
			KNOWN_ELEMENT_TYPES.add(Property_3018);
			KNOWN_ELEMENT_TYPES.add(Property_3002);
			KNOWN_ELEMENT_TYPES.add(Operation_3020);
			KNOWN_ELEMENT_TYPES.add(Stereotype_1023);
			KNOWN_ELEMENT_TYPES.add(Class_3028);
			KNOWN_ELEMENT_TYPES.add(Comment_1007);
			KNOWN_ELEMENT_TYPES.add(Model_1027);
			KNOWN_ELEMENT_TYPES.add(Profile_1024);
			KNOWN_ELEMENT_TYPES.add(Package_1012);
			KNOWN_ELEMENT_TYPES.add(Constraint_1028);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3025);
			KNOWN_ELEMENT_TYPES.add(DataType_3027);
			KNOWN_ELEMENT_TYPES.add(Extension_1013);
			KNOWN_ELEMENT_TYPES.add(Association_4001);
			KNOWN_ELEMENT_TYPES.add(ProfileApplication_1045);
			KNOWN_ELEMENT_TYPES.add(Association_4019);
			KNOWN_ELEMENT_TYPES.add(Generalization_4002);
			KNOWN_ELEMENT_TYPES.add(Dependency_4008);
			KNOWN_ELEMENT_TYPES.add(Dependency_4018);
			KNOWN_ELEMENT_TYPES.add(ElementImport_1064);
			KNOWN_ELEMENT_TYPES.add(PackageImport_1065);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_1022);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4014);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ProfileDiagramEditPart.VISUAL_ID:
			return Profile_1000;
		case DependencyNodeEditPart.VISUAL_ID:
			return Dependency_2014;
		case AssociationNodeEditPart.VISUAL_ID:
			return Association_2015;
		case StereotypeEditPart.VISUAL_ID:
			return Stereotype_1026;
		case MetaclassEditPart.VISUAL_ID:
			return Class_1031;
		case CommentEditPart.VISUAL_ID:
			return Comment_1002;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_1014;
		case ModelEditPartTN.VISUAL_ID:
			return Model_2005;
		case ProfileEditPartTN.VISUAL_ID:
			return Profile_1030;
		case PackageEditPart.VISUAL_ID:
			return Package_2007;
		case EnumerationEditPart.VISUAL_ID:
			return Enumeration_2006;
		case PrimitiveTypeEditPart.VISUAL_ID:
			return PrimitiveType_2009;
		case DataTypeEditPart.VISUAL_ID:
			return DataType_2010;
		case ShortCutDiagramEditPart.VISUAL_ID:
			return Diagram_2016;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return PrimitiveType_3026;
		case DataTypeOperationEditPart.VISUAL_ID:
			return Operation_3019;
		case EnumerationLiteralEditPart.VISUAL_ID:
			return EnumerationLiteral_1037;
		case DataTypePropertyEditPart.VISUAL_ID:
			return Property_3018;
		case ClassPropertyEditPart.VISUAL_ID:
			return Property_3002;
		case ClassOperationEditPart.VISUAL_ID:
			return Operation_3020;
		case StereotypeEditPartCN.VISUAL_ID:
			return Stereotype_1023;
		case MetaclassEditPartCN.VISUAL_ID:
			return Class_3028;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_1007;
		case ModelEditPartCN.VISUAL_ID:
			return Model_1027;
		case ProfileEditPartCN.VISUAL_ID:
			return Profile_1024;
		case PackageEditPartCN.VISUAL_ID:
			return Package_1012;
		case ConstraintEditPartCN.VISUAL_ID:
			return Constraint_1028;
		case EnumerationEditPartCN.VISUAL_ID:
			return Enumeration_3025;
		case DataTypeEditPartCN.VISUAL_ID:
			return DataType_3027;
		case ExtensionEditPart.VISUAL_ID:
			return Extension_1013;
		case AssociationEditPart.VISUAL_ID:
			return Association_4001;
		case ProfileApplicationEditPart.VISUAL_ID:
			return ProfileApplication_1045;
		case AssociationBranchEditPart.VISUAL_ID:
			return Association_4019;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4002;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4008;
		case DependencyBranchEditPart.VISUAL_ID:
			return Dependency_4018;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_1064;
		case PackageImportEditPart.VISUAL_ID:
			return PackageImport_1065;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_1022;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4014;
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
			return org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
