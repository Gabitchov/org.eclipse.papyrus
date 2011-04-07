package org.eclipse.papyrus.diagram.deployment.providers;

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
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Model_1000 = getElementType("org.eclipse.papyrus.diagram.deployment.Model_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2001 = getElementType("org.eclipse.papyrus.diagram.deployment.Comment_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2005 = getElementType("org.eclipse.papyrus.diagram.deployment.Constraint_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_2002 = getElementType("org.eclipse.papyrus.diagram.deployment.ExecutionEnvironment_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Device_2003 = getElementType("org.eclipse.papyrus.diagram.deployment.Device_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_2006 = getElementType("org.eclipse.papyrus.diagram.deployment.Artifact_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_2008 = getElementType("org.eclipse.papyrus.diagram.deployment.Node_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_23 = getElementType("org.eclipse.papyrus.diagram.deployment.Node_23"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Device_16 = getElementType("org.eclipse.papyrus.diagram.deployment.Device_16"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_21 = getElementType("org.eclipse.papyrus.diagram.deployment.ExecutionEnvironment_21"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_25 = getElementType("org.eclipse.papyrus.diagram.deployment.Artifact_25"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_28 = getElementType("org.eclipse.papyrus.diagram.deployment.Artifact_28"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4005 = getElementType("org.eclipse.papyrus.diagram.deployment.Link_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4008 = getElementType("org.eclipse.papyrus.diagram.deployment.CommentAnnotatedElement_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4009 = getElementType("org.eclipse.papyrus.diagram.deployment.ConstraintConstrainedElement_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Deployment_4001 = getElementType("org.eclipse.papyrus.diagram.deployment.Deployment_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Manifestation_4002 = getElementType("org.eclipse.papyrus.diagram.deployment.Manifestation_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4003 = getElementType("org.eclipse.papyrus.diagram.deployment.Generalization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4004 = getElementType("org.eclipse.papyrus.diagram.deployment.Dependency_4004"); //$NON-NLS-1$

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

			elements.put(Model_1000, UMLPackage.eINSTANCE.getModel());


			elements.put(Comment_2001, UMLPackage.eINSTANCE.getComment());


			elements.put(Constraint_2005, UMLPackage.eINSTANCE.getConstraint());


			elements.put(ExecutionEnvironment_2002, UMLPackage.eINSTANCE.getExecutionEnvironment());


			elements.put(Device_2003, UMLPackage.eINSTANCE.getDevice());


			elements.put(Artifact_2006, UMLPackage.eINSTANCE.getArtifact());


			elements.put(Node_2008, UMLPackage.eINSTANCE.getNode());


			elements.put(Node_23, UMLPackage.eINSTANCE.getNode());


			elements.put(Device_16, UMLPackage.eINSTANCE.getDevice());


			elements.put(ExecutionEnvironment_21, UMLPackage.eINSTANCE.getExecutionEnvironment());


			elements.put(Artifact_25, UMLPackage.eINSTANCE.getArtifact());


			elements.put(Artifact_28, UMLPackage.eINSTANCE.getArtifact());

			elements.put(CommentAnnotatedElement_4008, UMLPackage.eINSTANCE.getComment_AnnotatedElement());

			elements.put(ConstraintConstrainedElement_4009, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());


			elements.put(Deployment_4001, UMLPackage.eINSTANCE.getDeployment());


			elements.put(Manifestation_4002, UMLPackage.eINSTANCE.getManifestation());


			elements.put(Generalization_4003, UMLPackage.eINSTANCE.getGeneralization());


			elements.put(Dependency_4004, UMLPackage.eINSTANCE.getDependency());
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
			KNOWN_ELEMENT_TYPES.add(Model_1000);
			KNOWN_ELEMENT_TYPES.add(Comment_2001);
			KNOWN_ELEMENT_TYPES.add(Constraint_2005);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_2002);
			KNOWN_ELEMENT_TYPES.add(Device_2003);
			KNOWN_ELEMENT_TYPES.add(Artifact_2006);
			KNOWN_ELEMENT_TYPES.add(Node_2008);
			KNOWN_ELEMENT_TYPES.add(Node_23);
			KNOWN_ELEMENT_TYPES.add(Device_16);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_21);
			KNOWN_ELEMENT_TYPES.add(Artifact_25);
			KNOWN_ELEMENT_TYPES.add(Artifact_28);
			KNOWN_ELEMENT_TYPES.add(Link_4005);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4008);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4009);
			KNOWN_ELEMENT_TYPES.add(Deployment_4001);
			KNOWN_ELEMENT_TYPES.add(Manifestation_4002);
			KNOWN_ELEMENT_TYPES.add(Generalization_4003);
			KNOWN_ELEMENT_TYPES.add(Dependency_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			return Model_1000;
		case CommentEditPart.VISUAL_ID:
			return Comment_2001;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2005;
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return ExecutionEnvironment_2002;
		case DeviceEditPart.VISUAL_ID:
			return Device_2003;
		case ArtifactEditPart.VISUAL_ID:
			return Artifact_2006;
		case NodeEditPart.VISUAL_ID:
			return Node_2008;
		case NodeEditPartCN.VISUAL_ID:
			return Node_23;
		case DeviceEditPartCN.VISUAL_ID:
			return Device_16;
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return ExecutionEnvironment_21;
		case ArtifactEditPartCN.VISUAL_ID:
			return Artifact_25;
		case ArtifactEditPartACN.VISUAL_ID:
			return Artifact_28;
		case LinkDescriptorEditPart.VISUAL_ID:
			return Link_4005;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4008;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4009;
		case DeploymentEditPart.VISUAL_ID:
			return Deployment_4001;
		case ManifestationEditPart.VISUAL_ID:
			return Manifestation_4002;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4003;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4004;
		}
		return null;
	}

}
