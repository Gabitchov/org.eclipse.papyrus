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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.providers;

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
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointInRectangleEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_2011 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Actor_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_2012 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Actor_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_2013 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.UseCase_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_2014 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.UseCase_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Classifier_2015 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Classifier_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2016 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Package_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2017 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Constraint_2017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2018 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Comment_2018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Diagram_2019 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Diagram_2019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_2022 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.DefaultNamedElement_2022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_2023 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.NamedElement_2023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtensionPoint_3007 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.ExtensionPoint_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtensionPoint_3008 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.ExtensionPoint_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_3009 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.UseCase_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_3016 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Component_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3015 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Comment_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3017 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Constraint_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_3018 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Actor_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3010 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Constraint_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Actor_3011 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Actor_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCase_3012 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.UseCase_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Component_3013 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Component_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_3014 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Package_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Include_4008 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Include_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Extend_4009 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Extend_4009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4010 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Generalization_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_4011 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Association_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4012 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.ConstraintConstrainedElement_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4013 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Dependency_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4014 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.CommentAnnotatedElement_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Abstraction_4015 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Abstraction_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Usage_4016 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Usage_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Realization_4017 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.Realization_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageMerge_4018 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.PackageMerge_4018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PackageImport_4019 = getElementType("org.eclipse.papyrus.uml.diagram.usecase.PackageImport_4019"); //$NON-NLS-1$

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
			elements.put(Actor_2011, UMLPackage.eINSTANCE.getActor());
			elements.put(Actor_2012, UMLPackage.eINSTANCE.getActor());
			elements.put(UseCase_2013, UMLPackage.eINSTANCE.getUseCase());
			elements.put(UseCase_2014, UMLPackage.eINSTANCE.getUseCase());
			elements.put(Classifier_2015, UMLPackage.eINSTANCE.getClassifier());
			elements.put(Package_2016, UMLPackage.eINSTANCE.getPackage());
			elements.put(Constraint_2017, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Comment_2018, UMLPackage.eINSTANCE.getComment());
			elements.put(NamedElement_2022, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(NamedElement_2023, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(Diagram_2019, NotationPackage.eINSTANCE.getDiagram());
			elements.put(ExtensionPoint_3007, UMLPackage.eINSTANCE.getExtensionPoint());
			elements.put(ExtensionPoint_3008, UMLPackage.eINSTANCE.getExtensionPoint());
			elements.put(UseCase_3009, UMLPackage.eINSTANCE.getUseCase());
			elements.put(Component_3016, UMLPackage.eINSTANCE.getComponent());
			elements.put(Comment_3015, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_3017, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Actor_3018, UMLPackage.eINSTANCE.getActor());
			elements.put(Constraint_3010, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Actor_3011, UMLPackage.eINSTANCE.getActor());
			elements.put(UseCase_3012, UMLPackage.eINSTANCE.getUseCase());
			elements.put(Component_3013, UMLPackage.eINSTANCE.getComponent());
			elements.put(Package_3014, UMLPackage.eINSTANCE.getPackage());
			elements.put(Include_4008, UMLPackage.eINSTANCE.getInclude());
			elements.put(Extend_4009, UMLPackage.eINSTANCE.getExtend());
			elements.put(Generalization_4010, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(Association_4011, UMLPackage.eINSTANCE.getAssociation());
			elements.put(ConstraintConstrainedElement_4012, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
			elements.put(Dependency_4013, UMLPackage.eINSTANCE.getDependency());
			elements.put(CommentAnnotatedElement_4014, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(Abstraction_4015, UMLPackage.eINSTANCE.getAbstraction());
			elements.put(Usage_4016, UMLPackage.eINSTANCE.getUsage());
			elements.put(Realization_4017, UMLPackage.eINSTANCE.getRealization());
			elements.put(PackageMerge_4018, UMLPackage.eINSTANCE.getPackageMerge());
			elements.put(PackageImport_4019, UMLPackage.eINSTANCE.getPackageImport());
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
			KNOWN_ELEMENT_TYPES.add(Actor_2011);
			KNOWN_ELEMENT_TYPES.add(Actor_2012);
			KNOWN_ELEMENT_TYPES.add(UseCase_2013);
			KNOWN_ELEMENT_TYPES.add(UseCase_2014);
			KNOWN_ELEMENT_TYPES.add(Classifier_2015);
			KNOWN_ELEMENT_TYPES.add(Package_2016);
			KNOWN_ELEMENT_TYPES.add(Constraint_2017);
			KNOWN_ELEMENT_TYPES.add(Comment_2018);
			KNOWN_ELEMENT_TYPES.add(NamedElement_2022);
			KNOWN_ELEMENT_TYPES.add(NamedElement_2023);
			KNOWN_ELEMENT_TYPES.add(Diagram_2019);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3007);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3008);
			KNOWN_ELEMENT_TYPES.add(UseCase_3009);
			KNOWN_ELEMENT_TYPES.add(Component_3016);
			KNOWN_ELEMENT_TYPES.add(Comment_3015);
			KNOWN_ELEMENT_TYPES.add(Constraint_3017);
			KNOWN_ELEMENT_TYPES.add(Actor_3018);
			KNOWN_ELEMENT_TYPES.add(Constraint_3010);
			KNOWN_ELEMENT_TYPES.add(Actor_3011);
			KNOWN_ELEMENT_TYPES.add(UseCase_3012);
			KNOWN_ELEMENT_TYPES.add(Component_3013);
			KNOWN_ELEMENT_TYPES.add(Package_3014);
			KNOWN_ELEMENT_TYPES.add(Include_4008);
			KNOWN_ELEMENT_TYPES.add(Extend_4009);
			KNOWN_ELEMENT_TYPES.add(Generalization_4010);
			KNOWN_ELEMENT_TYPES.add(Association_4011);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4012);
			KNOWN_ELEMENT_TYPES.add(Dependency_4013);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4014);
			KNOWN_ELEMENT_TYPES.add(Abstraction_4015);
			KNOWN_ELEMENT_TYPES.add(Usage_4016);
			KNOWN_ELEMENT_TYPES.add(Realization_4017);
			KNOWN_ELEMENT_TYPES.add(PackageMerge_4018);
			KNOWN_ELEMENT_TYPES.add(PackageImport_4019);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case ActorEditPartTN.VISUAL_ID:
			return Actor_2011;
		case ActorAsRectangleEditPartTN.VISUAL_ID:
			return Actor_2012;
		case UseCaseEditPartTN.VISUAL_ID:
			return UseCase_2013;
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
			return UseCase_2014;
		case SubjectClassifierEditPartTN.VISUAL_ID:
			return Classifier_2015;
		case PackageEditPartTN.VISUAL_ID:
			return Package_2016;
		case ConstraintEditPartTN.VISUAL_ID:
			return Constraint_2017;
		case CommentEditPartTN.VISUAL_ID:
			return Comment_2018;
		case DefaultNamedElementEditPartTN.VISUAL_ID:
			return NamedElement_2022;
		case ShapeNamedElementEditPart.VISUAL_ID:
			return NamedElement_2023;
		case ShortCutDiagramEditPart.VISUAL_ID:
			return Diagram_2019;
		case ExtensionPointEditPart.VISUAL_ID:
			return ExtensionPoint_3007;
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return ExtensionPoint_3008;
		case UseCaseInComponentEditPart.VISUAL_ID:
			return UseCase_3009;
		case ComponentInComponentEditPart.VISUAL_ID:
			return Component_3016;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_3015;
		case ConstraintInComponentEditPart.VISUAL_ID:
			return Constraint_3017;
		case ActorInComponentEditPart.VISUAL_ID:
			return Actor_3018;
		case ConstraintInPackageEditPart.VISUAL_ID:
			return Constraint_3010;
		case ActorInPackageEditPart.VISUAL_ID:
			return Actor_3011;
		case UseCaseInPackageEditPart.VISUAL_ID:
			return UseCase_3012;
		case ComponentInPackageEditPart.VISUAL_ID:
			return Component_3013;
		case PackageEditPartCN.VISUAL_ID:
			return Package_3014;
		case IncludeEditPart.VISUAL_ID:
			return Include_4008;
		case ExtendEditPart.VISUAL_ID:
			return Extend_4009;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4010;
		case AssociationEditPart.VISUAL_ID:
			return Association_4011;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4012;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4013;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4014;
		case AbstractionEditPart.VISUAL_ID:
			return Abstraction_4015;
		case UsageEditPart.VISUAL_ID:
			return Usage_4016;
		case RealizationEditPart.VISUAL_ID:
			return Realization_4017;
		case PackageMergeEditPart.VISUAL_ID:
			return PackageMerge_4018;
		case PackageImportEditPart.VISUAL_ID:
			return PackageImport_4019;
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
			return org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
