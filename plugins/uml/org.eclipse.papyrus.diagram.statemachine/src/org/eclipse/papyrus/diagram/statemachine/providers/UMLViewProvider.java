package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate11EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate12EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate13EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate14EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.view.factories.CommentAnnotatedElementViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.CommentBodyViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.CommentViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.ConnectionPointReference2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.ConnectionPointReferenceName2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.ConnectionPointReferenceNameViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.ConnectionPointReferenceViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.ElementOwnedCommentViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.FinalStateViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate10ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate11ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate12ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate13ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate14ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate3ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate4ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate5ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate6ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate7ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate8ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Pseudostate9ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName3ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName4ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName5ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName6ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateName7ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateNameViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.PseudostateViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.Region2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.RegionSubvertices2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.RegionSubverticesViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.RegionViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.State2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.State3ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.State4ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateMachine2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateMachineName2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateMachineNameViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateMachineViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName3ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName4ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName5ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName6ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName7ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateName8ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateNameViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.StateViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.TransitionName2ViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.TransitionNameViewFactory;
import org.eclipse.papyrus.diagram.statemachine.view.factories.TransitionViewFactory;
import org.eclipse.uml2.uml.State;


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
		if(StateMachineEditPart.MODEL_ID.equals(diagramKind)
				&& UMLVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return StateMachineViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if(containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if(semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if(elementType != null || domainElement == null) {
				return null;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
			if(elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if(!UMLElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType)elementType)
						.getSemanticHint();
				if(!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}

				//modified to create correctly CompositeStates
				if(domainElement != null
						&& domainElement instanceof State
						&& ((State)domainElement).getRegions().size() >= 1
						&& ((State)domainElement).getSubmachine() == null
						&& (visualID == State2EditPart.VISUAL_ID || visualID == State4EditPart.VISUAL_ID))
					return getNodeViewClass(containerView, visualID);
				//end

				if(domainElement != null
						&& visualID != UMLVisualIDRegistry.getNodeVisualID(
						containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present.
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if(!StateMachineEditPart.MODEL_ID.equals(UMLVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch(visualID) {
				//lets to change from composite composed to composite decomposed and viceversa
				case State2EditPart.VISUAL_ID:
				case State4EditPart.VISUAL_ID:
					if(domainElement == null) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				//end

				case StateMachine2EditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case RegionEditPart.VISUAL_ID:
				case StateEditPart.VISUAL_ID:
				case Region2EditPart.VISUAL_ID:
				case State3EditPart.VISUAL_ID:
				case ConnectionPointReferenceEditPart.VISUAL_ID:
				case ConnectionPointReference2EditPart.VISUAL_ID:
				case FinalStateEditPart.VISUAL_ID:
				case PseudostateEditPart.VISUAL_ID:
				case Pseudostate2EditPart.VISUAL_ID:
				case Pseudostate3EditPart.VISUAL_ID:
				case Pseudostate4EditPart.VISUAL_ID:
				case Pseudostate5EditPart.VISUAL_ID:
				case Pseudostate6EditPart.VISUAL_ID:
				case Pseudostate7EditPart.VISUAL_ID:
				case Pseudostate8EditPart.VISUAL_ID:
				case Pseudostate9EditPart.VISUAL_ID:
				case Pseudostate10EditPart.VISUAL_ID:
				case Pseudostate11EditPart.VISUAL_ID:
				case Pseudostate12EditPart.VISUAL_ID:
				case Pseudostate13EditPart.VISUAL_ID:
				case Pseudostate14EditPart.VISUAL_ID:
					if(domainElement == null
							|| visualID != UMLVisualIDRegistry.getNodeVisualID(
							containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case StateMachineNameEditPart.VISUAL_ID:
				case StateMachineName2EditPart.VISUAL_ID:
					if(StateMachine2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CommentBodyEditPart.VISUAL_ID:
					if(CommentEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RegionSubverticesEditPart.VISUAL_ID:
					if(RegionEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateNameEditPart.VISUAL_ID:
				case StateName2EditPart.VISUAL_ID:
					if(StateEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateName3EditPart.VISUAL_ID:
				case StateName4EditPart.VISUAL_ID:
					if(State2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RegionSubvertices2EditPart.VISUAL_ID:
					if(Region2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateName5EditPart.VISUAL_ID:
				case StateName6EditPart.VISUAL_ID:
					if(State3EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ConnectionPointReferenceNameEditPart.VISUAL_ID:
					if(ConnectionPointReferenceEditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ConnectionPointReferenceName2EditPart.VISUAL_ID:
					if(ConnectionPointReference2EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName7EditPart.VISUAL_ID:
					if(Pseudostate7EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateName7EditPart.VISUAL_ID:
				case StateName8EditPart.VISUAL_ID:
					if(State4EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateNameEditPart.VISUAL_ID:
					if(Pseudostate9EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName2EditPart.VISUAL_ID:
					if(Pseudostate10EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName3EditPart.VISUAL_ID:
					if(Pseudostate11EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName4EditPart.VISUAL_ID:
					if(Pseudostate12EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName5EditPart.VISUAL_ID:
					if(Pseudostate13EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PseudostateName6EditPart.VISUAL_ID:
					if(Pseudostate14EditPart.VISUAL_ID != UMLVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case TransitionNameEditPart.VISUAL_ID:
				case TransitionName2EditPart.VISUAL_ID:
					if(TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry
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
		if(containerView == null
				|| !UMLVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch(visualID) {
		case StateMachine2EditPart.VISUAL_ID:
			return StateMachine2ViewFactory.class;
		case StateMachineNameEditPart.VISUAL_ID:
			return StateMachineNameViewFactory.class;
		case StateMachineName2EditPart.VISUAL_ID:
			return StateMachineName2ViewFactory.class;
		case CommentEditPart.VISUAL_ID:
			return CommentViewFactory.class;
		case CommentBodyEditPart.VISUAL_ID:
			return CommentBodyViewFactory.class;
		case RegionEditPart.VISUAL_ID:
			return RegionViewFactory.class;
		case StateEditPart.VISUAL_ID:
			return StateViewFactory.class;
		case StateNameEditPart.VISUAL_ID:
			return StateNameViewFactory.class;
		case StateName2EditPart.VISUAL_ID:
			return StateName2ViewFactory.class;
		case State2EditPart.VISUAL_ID:
			return State2ViewFactory.class;
		case StateName3EditPart.VISUAL_ID:
			return StateName3ViewFactory.class;
		case StateName4EditPart.VISUAL_ID:
			return StateName4ViewFactory.class;
		case Region2EditPart.VISUAL_ID:
			return Region2ViewFactory.class;
		case State3EditPart.VISUAL_ID:
			return State3ViewFactory.class;
		case StateName5EditPart.VISUAL_ID:
			return StateName5ViewFactory.class;
		case StateName6EditPart.VISUAL_ID:
			return StateName6ViewFactory.class;
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return ConnectionPointReferenceViewFactory.class;
		case ConnectionPointReferenceNameEditPart.VISUAL_ID:
			return ConnectionPointReferenceNameViewFactory.class;
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return ConnectionPointReference2ViewFactory.class;
		case ConnectionPointReferenceName2EditPart.VISUAL_ID:
			return ConnectionPointReferenceName2ViewFactory.class;
		case FinalStateEditPart.VISUAL_ID:
			return FinalStateViewFactory.class;
		case PseudostateEditPart.VISUAL_ID:
			return PseudostateViewFactory.class;
		case Pseudostate2EditPart.VISUAL_ID:
			return Pseudostate2ViewFactory.class;
		case Pseudostate3EditPart.VISUAL_ID:
			return Pseudostate3ViewFactory.class;
		case Pseudostate4EditPart.VISUAL_ID:
			return Pseudostate4ViewFactory.class;
		case Pseudostate5EditPart.VISUAL_ID:
			return Pseudostate5ViewFactory.class;
		case Pseudostate6EditPart.VISUAL_ID:
			return Pseudostate6ViewFactory.class;
		case Pseudostate7EditPart.VISUAL_ID:
			return Pseudostate7ViewFactory.class;
		case PseudostateName7EditPart.VISUAL_ID:
			return PseudostateName7ViewFactory.class;
		case Pseudostate8EditPart.VISUAL_ID:
			return Pseudostate8ViewFactory.class;
		case State4EditPart.VISUAL_ID:
			return State4ViewFactory.class;
		case StateName7EditPart.VISUAL_ID:
			return StateName7ViewFactory.class;
		case StateName8EditPart.VISUAL_ID:
			return StateName8ViewFactory.class;
		case Pseudostate9EditPart.VISUAL_ID:
			return Pseudostate9ViewFactory.class;
		case PseudostateNameEditPart.VISUAL_ID:
			return PseudostateNameViewFactory.class;
		case Pseudostate10EditPart.VISUAL_ID:
			return Pseudostate10ViewFactory.class;
		case PseudostateName2EditPart.VISUAL_ID:
			return PseudostateName2ViewFactory.class;
		case Pseudostate11EditPart.VISUAL_ID:
			return Pseudostate11ViewFactory.class;
		case PseudostateName3EditPart.VISUAL_ID:
			return PseudostateName3ViewFactory.class;
		case Pseudostate12EditPart.VISUAL_ID:
			return Pseudostate12ViewFactory.class;
		case PseudostateName4EditPart.VISUAL_ID:
			return PseudostateName4ViewFactory.class;
		case Pseudostate13EditPart.VISUAL_ID:
			return Pseudostate13ViewFactory.class;
		case PseudostateName5EditPart.VISUAL_ID:
			return PseudostateName5ViewFactory.class;
		case Pseudostate14EditPart.VISUAL_ID:
			return Pseudostate14ViewFactory.class;
		case PseudostateName6EditPart.VISUAL_ID:
			return PseudostateName6ViewFactory.class;
		case RegionSubverticesEditPart.VISUAL_ID:
			return RegionSubverticesViewFactory.class;
		case RegionSubvertices2EditPart.VISUAL_ID:
			return RegionSubvertices2ViewFactory.class;
		case TransitionNameEditPart.VISUAL_ID:
			return TransitionNameViewFactory.class;
		case TransitionName2EditPart.VISUAL_ID:
			return TransitionName2ViewFactory.class;
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
		if(!UMLElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		if(elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if(semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if(domainElement != null
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
		switch(visualID) {
		case TransitionEditPart.VISUAL_ID:
			return TransitionViewFactory.class;
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
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

}
