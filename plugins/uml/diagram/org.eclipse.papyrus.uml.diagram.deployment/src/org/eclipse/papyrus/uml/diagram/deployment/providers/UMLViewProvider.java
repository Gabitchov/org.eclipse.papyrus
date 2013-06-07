/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if(operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation)operation);
		}
		assert operation instanceof CreateViewOperation;
		if(operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation)operation);
		} else if(operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation)operation);
		} else if(operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation)operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 * if (op.getViewKind() == Node.class)
		 * return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 * if (op.getViewKind() == Edge.class)
		 * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */

		// check Diagram Type should be the class diagram
		String modelID = UMLVisualIDRegistry.getModelID(op.getContainerView());
		if(!getDiagramProvidedId().equals(modelID)) {
			return false;
		}

		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if(Node.class.isAssignableFrom(op.getViewKind())) {
			return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
		}

		return true;
	}

	/**
	 * @generated
	 */
	protected String getDiagramProvidedId() {
		/*
		 * Indicates for which diagram this provider works for.
		 * <p>
		 * This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>
		 * </p>
		 * 
		 * @return the unique identifier of the diagram for which views are provided.
		 */
		return DeploymentDiagramEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return DeploymentDiagramEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if(op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if(op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if(elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if(elementType != null) {
				if(elementType instanceof IExtendedHintedElementType) {
					IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
					if(!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
						return false; // foreign element type.
					}
				} else {
					if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
						return false; // foreign element type
					}
				}
				String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
				if(!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if(domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if(!DeploymentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case DependencyNodeEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ExecutionEnvironmentEditPart.VISUAL_ID:
				case DeviceEditPart.VISUAL_ID:
				case ArtifactEditPart.VISUAL_ID:
				case NodeEditPart.VISUAL_ID:
				case DefaultNamedElementEditPart.VISUAL_ID:
				case CommentEditPartCN.VISUAL_ID:
				case ConstraintEditPartCN.VISUAL_ID:
				case ModelEditPart.VISUAL_ID:
				case PackageEditPart.VISUAL_ID:
				case ModelEditPartCN.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
				case DeviceEditPartCN.VISUAL_ID:
				case NestedDeviceEditPartCN.VISUAL_ID:
				case ExecutionEnvironmentEditPartCN.VISUAL_ID:
				case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
				case NodeEditPartCN.VISUAL_ID:
				case NestedNodeEditPartCN.VISUAL_ID:
				case ArtifactEditPartCN.VISUAL_ID:
				case ArtifactEditPartACN.VISUAL_ID:
				case NestedArtifactNodeEditPartCN.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return DependencyNodeEditPart.VISUAL_ID == visualID || ModelEditPart.VISUAL_ID == visualID || PackageEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID || ExecutionEnvironmentEditPart.VISUAL_ID == visualID || DeviceEditPart.VISUAL_ID == visualID || ArtifactEditPart.VISUAL_ID == visualID || NodeEditPart.VISUAL_ID == visualID || DefaultNamedElementEditPart.VISUAL_ID == visualID || ModelEditPartCN.VISUAL_ID == visualID || PackageEditPartCN.VISUAL_ID == visualID || DeviceEditPartCN.VISUAL_ID == visualID || NestedDeviceEditPartCN.VISUAL_ID == visualID || ExecutionEnvironmentEditPartCN.VISUAL_ID == visualID || NestedExecutionEnvironmentEditPartCN.VISUAL_ID == visualID || NodeEditPartCN.VISUAL_ID == visualID || NestedNodeEditPartCN.VISUAL_ID == visualID || ArtifactEditPartCN.VISUAL_ID == visualID || ArtifactEditPartACN.VISUAL_ID == visualID || NestedArtifactNodeEditPartCN.VISUAL_ID == visualID || CommentEditPartCN.VISUAL_ID == visualID || ConstraintEditPartCN.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		//RS: add code for extended types creation
		if(elementType instanceof IExtendedHintedElementType) {
			IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
			if(!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
				return false; // foreign element type.
			}
		} else {
			if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
				return false; // foreign element type
			}
		}
		//if (!org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
		//	return false; // foreign element type
		//}
		// END R.S.
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		if(elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if(domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(DeploymentDiagramEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
		case DependencyNodeEditPart.VISUAL_ID:
			return createDependency_2011(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPart.VISUAL_ID:
			return createModel_2010(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPart.VISUAL_ID:
			return createPackage_2009(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2005(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2001(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return createExecutionEnvironment_2002(domainElement, containerView, index, persisted, preferencesHint);
		case DeviceEditPart.VISUAL_ID:
			return createDevice_2003(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPart.VISUAL_ID:
			return createArtifact_2006(domainElement, containerView, index, persisted, preferencesHint);
		case NodeEditPart.VISUAL_ID:
			return createNode_2008(domainElement, containerView, index, persisted, preferencesHint);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2012(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartCN.VISUAL_ID:
			return createModel_49(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_36(domainElement, containerView, index, persisted, preferencesHint);
		case DeviceEditPartCN.VISUAL_ID:
			return createDevice_16(domainElement, containerView, index, persisted, preferencesHint);
		case NestedDeviceEditPartCN.VISUAL_ID:
			return createDevice_44(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return createExecutionEnvironment_21(domainElement, containerView, index, persisted, preferencesHint);
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			return createExecutionEnvironment_46(domainElement, containerView, index, persisted, preferencesHint);
		case NodeEditPartCN.VISUAL_ID:
			return createNode_23(domainElement, containerView, index, persisted, preferencesHint);
		case NestedNodeEditPartCN.VISUAL_ID:
			return createNode_42(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPartCN.VISUAL_ID:
			return createArtifact_25(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPartACN.VISUAL_ID:
			return createArtifact_28(domainElement, containerView, index, persisted, preferencesHint);
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			return createArtifact_40(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartCN.VISUAL_ID:
			return createComment_54(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartCN.VISUAL_ID:
			return createConstraint_56(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		switch(UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case LinkDescriptorEditPart.VISUAL_ID:
			return createLink_4005(containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4008(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4009(containerView, index, persisted, preferencesHint);
		case DeploymentEditPart.VISUAL_ID:
			return createDeployment_4001(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ManifestationEditPart.VISUAL_ID:
			return createManifestation_4002(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyBranchEditPart.VISUAL_ID:
			return createDependency_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createDependency_2011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DependencyNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DependencyNode");

		Node label7 = createLabel(node, UMLVisualIDRegistry.getType(MultiDependencyLabelEditPart.VISUAL_ID));
		label7.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location7 = (Location)label7.getLayoutConstraint();
		location7.setX(0);
		location7.setY(5);

		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_2010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Model");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Model");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Model");

		Node label48 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPart.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");

		Node label35 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");

		Node label1 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");

		Node label2 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label3 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExecutionEnvironment");

		Node label5 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ExecutionEnvironment");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeviceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Device");

		Node label6 = createLabel(node, UMLVisualIDRegistry.getType(DeviceNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DeviceCompositeCompartmentEditPart.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Device");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");

		Node label8 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ArtifactCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Artifact");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Node");

		Node label9 = createLabel(node, UMLVisualIDRegistry.getType(NodeNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(NodeCompositeCompartmentEditPart.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Node");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DefaultNamedElementEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DefaultNamedElement");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DefaultNamedElement");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DefaultNamedElement");

		Node label53 = createLabel(node, UMLVisualIDRegistry.getType(DefaultNamedElementNameEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_49(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Model");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Model");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Model");

		Node label50 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_36(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");

		Node label37 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_23(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NodeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Node");

		Node label24 = createLabel(node, UMLVisualIDRegistry.getType(NodeNameEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_42(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NestedNodeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Node");

		Node label43 = createLabel(node, UMLVisualIDRegistry.getType(NestedNodeNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(NodeCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Node");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_16(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeviceEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Device");

		Node label20 = createLabel(node, UMLVisualIDRegistry.getType(DeviceNameEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_44(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NestedDeviceEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Device");

		Node label45 = createLabel(node, UMLVisualIDRegistry.getType(NestedDeviceNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DeviceCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Device");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_21(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironmentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExecutionEnvironment");

		Node label22 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentNameEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_46(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NestedExecutionEnvironmentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExecutionEnvironment");

		Node label47 = createLabel(node, UMLVisualIDRegistry.getType(NestedExecutionEnvironmentNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ExecutionEnvironment");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_25(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");

		Node label27 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactNameEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_28(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPartACN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");

		Node label29 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactNameEditPartACN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ArtifactCompositeCompartmentEditPartACN.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Artifact");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_40(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NestedArtifactNodeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");

		Node label41 = createLabel(node, UMLVisualIDRegistry.getType(NestedArtifactNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ArtifactCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Artifact");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_54(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");

		Node label55 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_56(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");

		Node label57 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartCN.VISUAL_ID));
		Node label58 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPartCN.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4005(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(LinkDescriptorEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Undefined");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Undefined");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Undefined");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4008(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "CommentAnnotatedElement");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "CommentAnnotatedElement");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "CommentAnnotatedElement");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4009(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ConstraintConstrainedElement");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ConstraintConstrainedElement");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ConstraintConstrainedElement");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDeployment_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DeploymentEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Deployment");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Deployment");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Deployment");

		Node label13 = createLabel(edge, UMLVisualIDRegistry.getType(DeploymentNameEditPart.VISUAL_ID));
		label13.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location13 = (Location)label13.getLayoutConstraint();
		location13.setX(0);
		location13.setY(60);
		Node label14 = createLabel(edge, UMLVisualIDRegistry.getType(DeploymentAppliedStereotypeEditPart.VISUAL_ID));
		label14.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location14 = (Location)label14.getLayoutConstraint();
		location14.setX(0);
		location14.setY(60);

		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Deployment");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createManifestation_4002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ManifestationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Manifestation");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Manifestation");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Manifestation");

		Node label10 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationNameEditPart.VISUAL_ID));
		label10.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location10 = (Location)label10.getLayoutConstraint();
		location10.setX(0);
		location10.setY(60);
		Node label11 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationAppliedStereotypeEditPart.VISUAL_ID));
		label11.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location11 = (Location)label11.getLayoutConstraint();
		location11.setX(0);
		location11.setY(30);

		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Manifestation");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Generalization");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Generalization");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Generalization");

		Node label4 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationAppliedStereotypeEditPart.VISUAL_ID));
		label4.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4 = (Location)label4.getLayoutConstraint();
		location4.setX(0);
		location4.setY(60);

		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Generalization");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "DependencyLink");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "DependencyLink");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "DependencyLink");

		Node label12 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label12.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location12 = (Location)label12.getLayoutConstraint();
		location12.setX(0);
		location12.setY(40);
		Node label15 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyAppliedStereotypeEditPart.VISUAL_ID));
		label15.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location15 = (Location)label15.getLayoutConstraint();
		location15.setX(0);
		location15.setY(60);

		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "DependencyLink");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyBranchEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "DependencyBranchLink");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "DependencyBranchLink");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "DependencyBranchLink");

		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!DeploymentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", DeploymentDiagramEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	protected Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	protected Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if(canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

		if(hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if(canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if(canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.FONT);
		String fontColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FONT);

		FontStyle viewFontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(viewFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);

			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(store, fontColorConstant);
			viewFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * @generated
	 */
	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.GRADIENT_POLICY);

		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}

}
