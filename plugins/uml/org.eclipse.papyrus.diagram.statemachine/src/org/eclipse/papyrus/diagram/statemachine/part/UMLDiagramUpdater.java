package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPartEditPart;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case RegionCompartmentEditPart.VISUAL_ID:
			return getRegionRegionCompartment_3002SemanticChildren(view);
		case StateMachineCompartmentEditPart.VISUAL_ID:
			return getStateMachineStateMachineCompartment_2002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getStateMachineStateMachineCompartment_2002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		StateMachine modelElement = (StateMachine) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateMachineEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getRegionRegionCompartment_3002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Region modelElement = (Region) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator it = modelElement.getSubvertices().iterator(); it
				.hasNext();) {
			Vertex childElement = (Vertex) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PseudoStateNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FinalStateNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StateNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2000ContainedLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_3000ContainedLinks(view);
		case PseudoStateNodeEditPart.VISUAL_ID:
			return getPseudostate_3004ContainedLinks(view);
		case FinalStateNodeEditPart.VISUAL_ID:
			return getFinalState_3005ContainedLinks(view);
		case StateNodeEditPart.VISUAL_ID:
			return getState_3006ContainedLinks(view);
		case TransitionEditPartEditPart.VISUAL_ID:
			return getTransition_5000ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2000IncomingLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_3000IncomingLinks(view);
		case PseudoStateNodeEditPart.VISUAL_ID:
			return getPseudostate_3004IncomingLinks(view);
		case FinalStateNodeEditPart.VISUAL_ID:
			return getFinalState_3005IncomingLinks(view);
		case StateNodeEditPart.VISUAL_ID:
			return getState_3006IncomingLinks(view);
		case TransitionEditPartEditPart.VISUAL_ID:
			return getTransition_5000IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2000OutgoingLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_3000OutgoingLinks(view);
		case PseudoStateNodeEditPart.VISUAL_ID:
			return getPseudostate_3004OutgoingLinks(view);
		case FinalStateNodeEditPart.VISUAL_ID:
			return getFinalState_3005OutgoingLinks(view);
		case StateNodeEditPart.VISUAL_ID:
			return getState_3006OutgoingLinks(view);
		case TransitionEditPartEditPart.VISUAL_ID:
			return getTransition_5000OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRegion_3000ContainedLinks(View view) {
		Region modelElement = (Region) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_5000(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPseudostate_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFinalState_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getState_3006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTransition_5000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2000IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRegion_3000IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPseudostate_3004IncomingLinks(
			View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_5000(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFinalState_3005IncomingLinks(
			View view) {
		FinalState modelElement = (FinalState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_5000(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getState_3006IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_5000(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTransition_5000IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2000OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRegion_3000OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPseudostate_3004OutgoingLinks(
			View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_5000(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFinalState_3005OutgoingLinks(
			View view) {
		FinalState modelElement = (FinalState) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_5000(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getState_3006OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_5000(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTransition_5000OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Transition_5000(
			Region container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPartEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Transition_5000,
					TransitionEditPartEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_5000(
			Vertex target, Map crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPartEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex src = link.getSource();
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Transition_5000,
					TransitionEditPartEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_5000(
			Vertex source) {
		Region container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Region) {
				container = (Region) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPartEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Transition_5000,
					TransitionEditPartEditPart.VISUAL_ID));

		}
		return result;
	}

}
