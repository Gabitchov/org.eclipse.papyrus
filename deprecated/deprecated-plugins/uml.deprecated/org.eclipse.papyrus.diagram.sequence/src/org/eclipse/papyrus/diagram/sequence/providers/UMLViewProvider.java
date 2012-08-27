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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Interaction2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartment2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.view.factories.BehaviorExecutionSpecificationViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.CombinedFragmentInteractionOperatorViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.CombinedFragmentViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.CommentAnnotatedElementViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.CommentBodyViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.CommentViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.ElementOwnedCommentViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Interaction2ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.InteractionInteractionCompartment2ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.InteractionInteractionCompartmentViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.InteractionName2ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.InteractionNameViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.InteractionViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.LifelineNameViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.LifelineViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Message2ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Message3ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Message4ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Message5ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.Message6ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageName2ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageName3ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageName4ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageName5ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageName6ViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageNameViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.MessageViewFactory;
import org.eclipse.papyrus.diagram.sequence.view.factories.PackageViewFactory;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractViewProvider {
	/**
	 * @generated
	 */
	@Override
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
	@Override
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
				// Element type is not specified. Domain element should be present.
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case InteractionEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case Interaction2EditPart.VISUAL_ID:
				case LifelineEditPart.VISUAL_ID:
				case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				case CombinedFragmentEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != UMLVisualIDRegistry.getNodeVisualID(
									containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case InteractionNameEditPart.VISUAL_ID:
				case InteractionInteractionCompartmentEditPart.VISUAL_ID:
					if (InteractionEditPart.VISUAL_ID != UMLVisualIDRegistry
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
				case InteractionName2EditPart.VISUAL_ID:
				case InteractionInteractionCompartment2EditPart.VISUAL_ID:
					if (Interaction2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case LifelineNameEditPart.VISUAL_ID:
					if (LifelineEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
					if (CombinedFragmentEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageNameEditPart.VISUAL_ID:
					if (MessageEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageName2EditPart.VISUAL_ID:
					if (Message2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageName3EditPart.VISUAL_ID:
					if (Message3EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageName4EditPart.VISUAL_ID:
					if (Message4EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageName5EditPart.VISUAL_ID:
					if (Message5EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageName6EditPart.VISUAL_ID:
					if (Message6EditPart.VISUAL_ID != UMLVisualIDRegistry
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
		case InteractionEditPart.VISUAL_ID:
			return InteractionViewFactory.class;
		case InteractionNameEditPart.VISUAL_ID:
			return InteractionNameViewFactory.class;
		case CommentEditPart.VISUAL_ID:
			return CommentViewFactory.class;
		case CommentBodyEditPart.VISUAL_ID:
			return CommentBodyViewFactory.class;
		case Interaction2EditPart.VISUAL_ID:
			return Interaction2ViewFactory.class;
		case InteractionName2EditPart.VISUAL_ID:
			return InteractionName2ViewFactory.class;
		case LifelineEditPart.VISUAL_ID:
			return LifelineViewFactory.class;
		case LifelineNameEditPart.VISUAL_ID:
			return LifelineNameViewFactory.class;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return BehaviorExecutionSpecificationViewFactory.class;
		case CombinedFragmentEditPart.VISUAL_ID:
			return CombinedFragmentViewFactory.class;
		case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
			return CombinedFragmentInteractionOperatorViewFactory.class;
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			return InteractionInteractionCompartmentViewFactory.class;
		case InteractionInteractionCompartment2EditPart.VISUAL_ID:
			return InteractionInteractionCompartment2ViewFactory.class;
		case MessageNameEditPart.VISUAL_ID:
			return MessageNameViewFactory.class;
		case MessageName2EditPart.VISUAL_ID:
			return MessageName2ViewFactory.class;
		case MessageName3EditPart.VISUAL_ID:
			return MessageName3ViewFactory.class;
		case MessageName4EditPart.VISUAL_ID:
			return MessageName4ViewFactory.class;
		case MessageName5EditPart.VISUAL_ID:
			return MessageName5ViewFactory.class;
		case MessageName6EditPart.VISUAL_ID:
			return MessageName6ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
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
		case MessageEditPart.VISUAL_ID:
			return MessageViewFactory.class;
		case Message2EditPart.VISUAL_ID:
			return Message2ViewFactory.class;
		case Message3EditPart.VISUAL_ID:
			return Message3ViewFactory.class;
		case Message4EditPart.VISUAL_ID:
			return Message4ViewFactory.class;
		case Message5EditPart.VISUAL_ID:
			return Message5ViewFactory.class;
		case Message6EditPart.VISUAL_ID:
			return Message6ViewFactory.class;
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return ElementOwnedCommentViewFactory.class;
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
