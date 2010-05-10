package org.eclipse.papyrus.diagram.communication.part;

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
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionCompartmentEditPart.VISUAL_ID:
			return getInteractionInteractionCompartment_7001SemanticChildren(view);
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionInteractionCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interaction modelElement = (Interaction)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getLifelines().iterator(); it.hasNext();) {
			Lifeline childElement = (Lifeline)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == LifelineEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNearestPackage().getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == TimeObservationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationObservationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InteractionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001ContainedLinks(view);
		case LifelineEditPartCN.VISUAL_ID:
			return getLifeline_3001ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097ContainedLinks(view);
		case TimeObservationEditPartCN.VISUAL_ID:
			return getTimeObservation_3004ContainedLinks(view);
		case DurationObservationEditPartCN.VISUAL_ID:
			return getDurationObservation_3005ContainedLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001IncomingLinks(view);
		case LifelineEditPartCN.VISUAL_ID:
			return getLifeline_3001IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097IncomingLinks(view);
		case TimeObservationEditPartCN.VISUAL_ID:
			return getTimeObservation_3004IncomingLinks(view);
		case DurationObservationEditPartCN.VISUAL_ID:
			return getDurationObservation_3005IncomingLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001OutgoingLinks(view);
		case LifelineEditPartCN.VISUAL_ID:
			return getLifeline_3001OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097OutgoingLinks(view);
		case TimeObservationEditPartCN.VISUAL_ID:
			return getTimeObservation_3004OutgoingLinks(view);
		case DurationObservationEditPartCN.VISUAL_ID:
			return getDurationObservation_3005OutgoingLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001ContainedLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Message_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3097ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3004ContainedLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationObservation_3005ContainedLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001IncomingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001IncomingLinks(View view) {
		Lifeline modelElement = (Lifeline)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3097IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3004IncomingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationObservation_3005IncomingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001OutgoingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001OutgoingLinks(View view) {
		Lifeline modelElement = (Lifeline)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3097OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3004OutgoingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationObservation_3005OutgoingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4006(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4006, MessageEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4006(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4006, MessageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4010, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4011, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_DurationObservation_Event_4012(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getDurationObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.DurationObservationEvent_4012, ConnectorDurationObservationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_TimeObservation_Event_4013(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getTimeObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.TimeObservationEvent_4013, ConnectorTimeObservationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4006(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4006, MessageEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(Comment source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4010, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(Constraint source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4011, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4012(DurationObservation source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getEvents().iterator(); destinations.hasNext();) {
			NamedElement destination = (NamedElement)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.DurationObservationEvent_4012, ConnectorDurationObservationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4013(TimeObservation source) {
		Collection result = new LinkedList();
		NamedElement destination = source.getEvent();
		if(destination == null) {
			return result;
		}
		result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.TimeObservationEvent_4013, ConnectorTimeObservationEditPart.VISUAL_ID));
		return result;
	}

}
