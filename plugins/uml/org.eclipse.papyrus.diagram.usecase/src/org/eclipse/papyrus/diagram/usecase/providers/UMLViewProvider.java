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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.view.factories.Actor2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.Actor3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ActorName2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ActorName3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ActorNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ActorViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.AssociationName2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.AssociationNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.AssociationViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.CommentAnnotatedElementViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.CommentBodyViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.CommentViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ComponentNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ComponentUsecasesViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ComponentViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ConstraintConstrainedElementViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ConstraintNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ConstraintViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.DependencyNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.DependencyViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ExtendViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ExtendsLink_fixedViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ExtensionPoint2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.ExtensionPointViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.GeneralizationViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.IncludeLink_fixedViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.IncludeViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.Package3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.PackageName2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.PackagePackageableElementCompartmentViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.PackageViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCase2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCase3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCase4ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseExtensionpointsViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseName2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseName3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseName4ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseNameViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCasePoints2ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCasePoints3ViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCasePointsViewFactory;
import org.eclipse.papyrus.diagram.usecase.view.factories.UseCaseViewFactory;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (PackageEditPart.MODEL_ID.equals(diagramKind)
				&& UMLVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return PackageViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!UMLElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != UMLVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ActorEditPart.VISUAL_ID:
				case UseCaseEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ExtensionPointEditPart.VISUAL_ID:
				case Actor2EditPart.VISUAL_ID:
				case UseCase2EditPart.VISUAL_ID:
				case Package3EditPart.VISUAL_ID:
				case ExtensionPoint2EditPart.VISUAL_ID:
				case UseCase3EditPart.VISUAL_ID:
				case Actor3EditPart.VISUAL_ID:
				case UseCase4EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != UMLVisualIDRegistry.getNodeVisualID(
									containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ActorNameEditPart.VISUAL_ID:
					if (ActorEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActorName2EditPart.VISUAL_ID:
					if (Actor2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UseCaseNameEditPart.VISUAL_ID:
				case UseCasePointsEditPart.VISUAL_ID:
					if (UseCaseEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UseCaseName2EditPart.VISUAL_ID:
				case UseCaseExtensionpointsEditPart.VISUAL_ID:
					if (UseCase2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ComponentNameEditPart.VISUAL_ID:
				case ComponentUsecasesEditPart.VISUAL_ID:
					if (ComponentEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PackageName2EditPart.VISUAL_ID:
				case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
					if (Package3EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ConstraintNameEditPart.VISUAL_ID:
					if (ConstraintEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CommentBodyEditPart.VISUAL_ID:
					if (CommentEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UseCaseName3EditPart.VISUAL_ID:
				case UseCasePoints2EditPart.VISUAL_ID:
					if (UseCase3EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActorName3EditPart.VISUAL_ID:
					if (Actor3EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UseCaseName4EditPart.VISUAL_ID:
				case UseCasePoints3EditPart.VISUAL_ID:
					if (UseCase4EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case IncludeLink_fixedEditPart.VISUAL_ID:
					if (IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ExtendsLink_fixedEditPart.VISUAL_ID:
					if (ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AssociationNameEditPart.VISUAL_ID:
				case AssociationName2EditPart.VISUAL_ID:
					if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DependencyNameEditPart.VISUAL_ID:
					if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !UMLVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case ActorEditPart.VISUAL_ID:
			return ActorViewFactory.class;
		case ActorNameEditPart.VISUAL_ID:
			return ActorNameViewFactory.class;
		case Actor2EditPart.VISUAL_ID:
			return Actor2ViewFactory.class;
		case ActorName2EditPart.VISUAL_ID:
			return ActorName2ViewFactory.class;
		case UseCaseEditPart.VISUAL_ID:
			return UseCaseViewFactory.class;
		case UseCaseNameEditPart.VISUAL_ID:
			return UseCaseNameViewFactory.class;
		case UseCase2EditPart.VISUAL_ID:
			return UseCase2ViewFactory.class;
		case UseCaseName2EditPart.VISUAL_ID:
			return UseCaseName2ViewFactory.class;
		case ComponentEditPart.VISUAL_ID:
			return ComponentViewFactory.class;
		case ComponentNameEditPart.VISUAL_ID:
			return ComponentNameViewFactory.class;
		case Package3EditPart.VISUAL_ID:
			return Package3ViewFactory.class;
		case PackageName2EditPart.VISUAL_ID:
			return PackageName2ViewFactory.class;
		case ConstraintEditPart.VISUAL_ID:
			return ConstraintViewFactory.class;
		case ConstraintNameEditPart.VISUAL_ID:
			return ConstraintNameViewFactory.class;
		case CommentEditPart.VISUAL_ID:
			return CommentViewFactory.class;
		case CommentBodyEditPart.VISUAL_ID:
			return CommentBodyViewFactory.class;
		case ExtensionPointEditPart.VISUAL_ID:
			return ExtensionPointViewFactory.class;
		case ExtensionPoint2EditPart.VISUAL_ID:
			return ExtensionPoint2ViewFactory.class;
		case UseCase3EditPart.VISUAL_ID:
			return UseCase3ViewFactory.class;
		case UseCaseName3EditPart.VISUAL_ID:
			return UseCaseName3ViewFactory.class;
		case Actor3EditPart.VISUAL_ID:
			return Actor3ViewFactory.class;
		case ActorName3EditPart.VISUAL_ID:
			return ActorName3ViewFactory.class;
		case UseCase4EditPart.VISUAL_ID:
			return UseCase4ViewFactory.class;
		case UseCaseName4EditPart.VISUAL_ID:
			return UseCaseName4ViewFactory.class;
		case UseCasePointsEditPart.VISUAL_ID:
			return UseCasePointsViewFactory.class;
		case UseCaseExtensionpointsEditPart.VISUAL_ID:
			return UseCaseExtensionpointsViewFactory.class;
		case ComponentUsecasesEditPart.VISUAL_ID:
			return ComponentUsecasesViewFactory.class;
		case UseCasePoints2EditPart.VISUAL_ID:
			return UseCasePoints2ViewFactory.class;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return PackagePackageableElementCompartmentViewFactory.class;
		case UseCasePoints3EditPart.VISUAL_ID:
			return UseCasePoints3ViewFactory.class;
		case IncludeLink_fixedEditPart.VISUAL_ID:
			return IncludeLink_fixedViewFactory.class;
		case ExtendsLink_fixedEditPart.VISUAL_ID:
			return ExtendsLink_fixedViewFactory.class;
		case AssociationNameEditPart.VISUAL_ID:
			return AssociationNameViewFactory.class;
		case AssociationName2EditPart.VISUAL_ID:
			return AssociationName2ViewFactory.class;
		case DependencyNameEditPart.VISUAL_ID:
			return DependencyNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!UMLElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != UMLVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case IncludeEditPart.VISUAL_ID:
			return IncludeViewFactory.class;
		case ExtendEditPart.VISUAL_ID:
			return ExtendViewFactory.class;
		case GeneralizationEditPart.VISUAL_ID:
			return GeneralizationViewFactory.class;
		case AssociationEditPart.VISUAL_ID:
			return AssociationViewFactory.class;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElementViewFactory.class;
		case DependencyEditPart.VISUAL_ID:
			return DependencyViewFactory.class;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElementViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
