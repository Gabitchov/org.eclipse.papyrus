package org.eclipse.papyrus.diagram.communication.providers;

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
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.communication.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Interaction_2001 = getElementType("org.eclipse.papyrus.diagram.communication.Interaction_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Lifeline_3001 = getElementType("org.eclipse.papyrus.diagram.communication.Lifeline_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3029 = getElementType("org.eclipse.papyrus.diagram.communication.Constraint_3029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3097 = getElementType("org.eclipse.papyrus.diagram.communication.Comment_3097"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeObservation_3004 = getElementType("org.eclipse.papyrus.diagram.communication.TimeObservation_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationObservation_3005 = getElementType("org.eclipse.papyrus.diagram.communication.DurationObservation_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Message_4006 = getElementType("org.eclipse.papyrus.diagram.communication.Message_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4010 = getElementType("org.eclipse.papyrus.diagram.communication.CommentAnnotatedElement_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4011 = getElementType("org.eclipse.papyrus.diagram.communication.ConstraintConstrainedElement_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationObservationEvent_4012 = getElementType("org.eclipse.papyrus.diagram.communication.DurationObservationEvent_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeObservationEvent_4013 = getElementType("org.eclipse.papyrus.diagram.communication.TimeObservationEvent_4013"); //$NON-NLS-1$

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
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());


			elements.put(Interaction_2001, UMLPackage.eINSTANCE.getInteraction());


			elements.put(Lifeline_3001, UMLPackage.eINSTANCE.getLifeline());


			elements.put(Constraint_3029, UMLPackage.eINSTANCE.getConstraint());


			elements.put(Comment_3097, UMLPackage.eINSTANCE.getComment());


			elements.put(TimeObservation_3004, UMLPackage.eINSTANCE.getTimeObservation());


			elements.put(DurationObservation_3005, UMLPackage.eINSTANCE.getDurationObservation());


			elements.put(Message_4006, UMLPackage.eINSTANCE.getMessage());

			elements.put(CommentAnnotatedElement_4010, UMLPackage.eINSTANCE.getComment_AnnotatedElement());

			elements.put(ConstraintConstrainedElement_4011, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(DurationObservationEvent_4012, UMLPackage.eINSTANCE.getDurationObservation_Event());

			elements.put(TimeObservationEvent_4013, UMLPackage.eINSTANCE.getTimeObservation_Event());
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
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Interaction_2001);
			KNOWN_ELEMENT_TYPES.add(Lifeline_3001);
			KNOWN_ELEMENT_TYPES.add(Constraint_3029);
			KNOWN_ELEMENT_TYPES.add(Comment_3097);
			KNOWN_ELEMENT_TYPES.add(TimeObservation_3004);
			KNOWN_ELEMENT_TYPES.add(DurationObservation_3005);
			KNOWN_ELEMENT_TYPES.add(Message_4006);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4010);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4011);
			KNOWN_ELEMENT_TYPES.add(DurationObservationEvent_4012);
			KNOWN_ELEMENT_TYPES.add(TimeObservationEvent_4013);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ModelEditPart.VISUAL_ID:
			return Package_1000;
		case InteractionEditPart.VISUAL_ID:
			return Interaction_2001;
		case LifelineEditPartCN.VISUAL_ID:
			return Lifeline_3001;
		case ConstraintEditPartCN.VISUAL_ID:
			return Constraint_3029;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_3097;
		case TimeObservationEditPartCN.VISUAL_ID:
			return TimeObservation_3004;
		case DurationObservationEditPartCN.VISUAL_ID:
			return DurationObservation_3005;
		case MessageEditPart.VISUAL_ID:
			return Message_4006;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4010;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4011;
		case ConnectorDurationObservationEditPart.VISUAL_ID:
			return DurationObservationEvent_4012;
		case ConnectorTimeObservationEditPart.VISUAL_ID:
			return TimeObservationEvent_4013;
		}
		return null;
	}

}
