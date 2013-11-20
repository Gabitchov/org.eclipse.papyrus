/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;


/**
 * 
 * @author vl222926
 *         Adapted code from generated code for UML Diagram
 *         The name of the methods are not java compliant, but it is done to be consistent with the generated classes which use the id of the elements
 */
public class SysMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getSemanticChildren(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getSemanticChildren(View view) {
			return SysMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getContainedLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getContainedLinks(View view) {
			return SysMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getIncomingLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getIncomingLinks(View view) {
			return SysMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getOutgoingLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return SysMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

	public static List<UpdaterLinkDescriptor> getContainedLinks(final View view) {
		throw new UnsupportedOperationException("Not yet implemented"); //$NON-NLS-1$
	}

	public static List<UpdaterLinkDescriptor> getSemanticChildren(final View view) {
		throw new UnsupportedOperationException("Not yet implemented"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the list of the incoming links for this view
	 */
	public static List<UpdaterLinkDescriptor> getIncomingLinks(final View view) {
		final String id = view.getType();
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID)) {
			return getBlock_shape_sysml_block_as_classifier_IncomingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID)) {
			return getAssociation_link_sysml_association_IncomingLink(view);
		}
		if(id.equals(Integer.toString(PackageEditPart.VISUAL_ID)) || id.equals(Integer.toString(PackageEditPartCN.VISUAL_ID))) {
			return getPackage_2007IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID)) {
			return getActor_shape_uml_actor_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID)) {
			return getSignal_shape_uml_signal_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID)) {
			return getProperty_shape_uml_property_as_label_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID)) {
			return getPart_shape_sysml_part_as_label_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID)) {
			return getReference_shape_sysml_reference_as_label_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID)) {
			return getValue_shape_sysml_value_as_label_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID)) {
			return getOperation_shape_uml_operation_as_label_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID)) {
			return getReception_shape_uml_reception_as_label_IncomingLinks(view);
		}
		if(id.equals(Integer.toString(InstanceSpecificationEditPart.VISUAL_ID)) || id.equals(Integer.toString(InstanceSpecificationEditPartCN.VISUAL_ID))) {
			return getInstanceSpecification_2001IncomingLinks(view);
		}
		if(id.equals(Integer.toString(SlotEditPart.VISUAL_ID))) {
			return getSlot_2001IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID)) {
			return getDependency_link_uml_dependency_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID)) {
			return getGeneralization_link_uml_generalization_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID)) {
			return getPort_shape_uml_port_as_label_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID)) {
			return getFlowPort_shape_sysml_flowport_as_label_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID)) {
			return getPort_shape_uml_port_as_affixed_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID)) {
			return getFlowPort_shape_sysml_flowport_as_affixed_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID)) {
			return getFlowSpecification_shape_sysml_flowspecification_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID)) {
			return getInterface_shape_uml_interface_as_classifier_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID)) {
			return getFlowProperty_shape_sysml_flowproperty_as_label_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID)) {
			return getInterfaceRealization_link_uml_interfacerealization_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_USAGE_ID)) {
			return getUsage_link_uml_usage_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID)) {
			return getDataType_shape_uml_data_type_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID)) {
			return getEnumeration_shape_uml_enumeration_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID)) {
			return getEnumerationLiteral_shape_uml_enumerationliteral_as_classifier_IncomingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID)) {
			return getPrimitiveType_shape_uml_primitivetype_as_classifier_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID)) {
			return getDimension_shape_sysml_dimension_as_classifier_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID)) {
			return getUnit_shape_sysml_unit_as_classifier_IncomingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID)) {
			return getValueType_shape_sysml_valuetype_as_classifier_IncommingLinks(view);
		}
		return Collections.emptyList();
	}


	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the list of the outgoing links for this view
	 */
	public static List<UpdaterLinkDescriptor> getOutgoingLinks(final View view) {
		final String id = view.getType();
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID)) {
			return getBlock_shape_sysml_block_as_classifier_OutgoingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID)) {
			return getAssociation_link_sysml_association_OutgoingLink(view);
		}
		if(id.equals(Integer.toString(PackageEditPart.VISUAL_ID)) || id.equals(Integer.toString(PackageEditPartCN.VISUAL_ID))) {
			return getPackage_2007OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID)) {
			return getActor_shape_uml_actor_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID)) {
			return getSignal_shape_uml_signal_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID)) {
			return getProperty_shape_uml_property_as_label_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID)) {
			return getPart_shape_sysml_part_as_label_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID)) {
			return getReference_shape_sysml_reference_as_label_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID)) {
			return getValue_shape_sysml_value_as_label_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID)) {
			return getOperation_shape_uml_operation_as_label_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID)) {
			return getReception_shape_uml_reception_as_label_OutgoingLinks(view);
		}
		if(id.equals(Integer.toString(InstanceSpecificationEditPart.VISUAL_ID)) || id.equals(Integer.toString(InstanceSpecificationEditPartCN.VISUAL_ID))) {
			return getInstanceSpecification_2001OutgoingLinks(view);
		}
		if(id.equals(Integer.toString(SlotEditPart.VISUAL_ID))) {
			return getSlot_2001OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID)) {
			return getDependency_link_uml_dependency_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID)) {
			return getGeneralization_link_uml_generalization_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID)) {
			return getPort_shape_uml_port_as_label_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID)) {
			return getFlowPort_shape_sysml_flowport_as_label_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID)) {
			return getPort_shape_uml_port_as_affixed_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID)) {
			return getFlowPort_shape_sysml_flowport_as_affixed_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID)) {
			return getFlowSpecification_shape_sysml_flowspecification_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID)) {
			return getInterface_shape_uml_interface_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID)) {
			return getFlowProperty_shape_sysml_flowproperty_as_label_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID)) {
			return getInterfaceRealization_link_uml_interfacerealization_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_USAGE_ID)) {
			return getUsage_link_uml_usage_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID)) {
			return getDataType_shape_uml_data_type_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID)) {
			return getEnumeration_shape_uml_enumeration_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID)) {
			return getEnumerationLiteral_shape_uml_enumerationliteral_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID)) {
			return getPrimitiveType_shape_uml_primitivetype_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID)) {
			return getDimension_shape_sysml_dimension_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID)) {
			return getUnit_shape_sysml_unit_as_classifier_OutgoingLinks(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID)) {
			return getValueType_shape_sysml_valuetype_as_classifier_OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	private static List<UpdaterLinkDescriptor> getValueType_shape_sysml_valuetype_as_classifier_IncommingLinks(View view) {
		return getDataType_shape_uml_data_type_as_classifier_IncomingLinks(view);
	}


	private static List<UpdaterLinkDescriptor> getValueType_shape_sysml_valuetype_as_classifier_OutgoingLinks(View view) {
		return getDataType_shape_uml_data_type_as_classifier_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getDimension_shape_sysml_dimension_as_classifier_OutgoingLinks(View view) {
		return getInstanceSpecification_2001IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getDimension_shape_sysml_dimension_as_classifier_IncomingLinks(View view) {
		return getInstanceSpecification_2001OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getUnit_shape_sysml_unit_as_classifier_OutgoingLinks(View view) {
		return getInstanceSpecification_2001IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getUnit_shape_sysml_unit_as_classifier_IncomingLinks(View view) {
		return getInstanceSpecification_2001OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPrimitiveType_shape_uml_primitivetype_as_classifier_IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getPrimitiveType_shape_uml_primitivetype_as_classifier_OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		return result;
	}



	private static List<UpdaterLinkDescriptor> getEnumerationLiteral_shape_uml_enumerationliteral_as_classifier_IncomingLinks(View view) {
		EnumerationLiteral modelElement = (EnumerationLiteral)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getEnumerationLiteral_shape_uml_enumerationliteral_as_classifier_OutgoingLinks(View view) {
		EnumerationLiteral modelElement = (EnumerationLiteral)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getEnumeration_shape_uml_enumeration_as_classifier_IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getEnumeration_shape_uml_enumeration_as_classifier_OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getDataType_shape_uml_data_type_as_classifier_IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getDataType_shape_uml_data_type_as_classifier_OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getUsage_link_uml_usage_IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getUsage_link_uml_usage_OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getInterfaceRealization_link_uml_interfacerealization_IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getInterfaceRealization_link_uml_interfacerealization_OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getFlowProperty_shape_sysml_flowproperty_as_label_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowProperty_shape_sysml_flowproperty_as_label_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getInterface_shape_uml_interface_as_classifier_IncomingLinks(View view) {
		return getInterface_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getInterface_shape_uml_interface_as_classifier_OutgoingLinks(View view) {
		return getInterface_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowSpecification_shape_sysml_flowspecification_as_classifier_IncomingLinks(View view) {
		return getInterface_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowSpecification_shape_sysml_flowspecification_as_classifier_OutgoingLinks(View view) {
		return getInterface_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getInterface_IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4003(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getInterface_OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_affixed_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_affixed_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_affixed_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_affixed_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_label_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_label_OutgoingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_label_IncomingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_label_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getDependency_link_uml_dependency_IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getDependency_link_uml_dependency_OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getGeneralization_link_uml_generalization_IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getGeneralization_link_uml_generalization_OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	private static List<UpdaterLinkDescriptor> getSlot_2001IncomingLinks(View view) {
		Slot modelElement = (Slot)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getSlot_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	private static List<UpdaterLinkDescriptor> getInstanceSpecification_2001IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getInstanceSpecification_2001OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getReception_shape_uml_reception_as_label_IncomingLinks(View view) {
		Reception modelElement = (Reception)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getReception_shape_uml_reception_as_label_OutgoingLinks(View view) {
		Reception modelElement = (Reception)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getOperation_shape_uml_operation_as_label_IncomingLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getOperation_shape_uml_operation_as_label_OutgoingLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}


	private static List<UpdaterLinkDescriptor> getValue_shape_sysml_value_as_label_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getValue_shape_sysml_value_as_label_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getReference_shape_sysml_reference_as_label_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getReference_shape_sysml_reference_as_label_OutgoingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPart_shape_sysml_part_as_label_IncomingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getPart_shape_sysml_part_as_label_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getProperty_shape_uml_property_as_label_IncomingLinks(View view) {
		return getProperty_IncomingLinks(view);
	}

	private static List<UpdaterLinkDescriptor> getProperty_shape_uml_property_as_label_OutgoingLinks(View view) {
		return getProperty_OutgoingLinks(view);
	}

	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4003(Interface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInterfaceRealization_Contract() || false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)setting.getEObject();
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof BehavioredClassifier) {
				continue;
			}
			BehavioredClassifier container = (BehavioredClassifier)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.InterfaceRealization_4003, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	private static List<UpdaterLinkDescriptor> getProperty_IncomingLinks(View view) {
		Property modelElement = (Property)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getProperty_OutgoingLinks(View view) {
		Property modelElement = (Property)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}


	private static List<UpdaterLinkDescriptor> getSignal_shape_uml_signal_as_classifier_IncomingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getSignal_shape_uml_signal_as_classifier_OutgoingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		return result;

	}

	private static List<UpdaterLinkDescriptor> getActor_shape_uml_actor_as_classifier_IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getActor_shape_uml_actor_as_classifier_OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_link_uml_interfacerealization(modelElement));
		return result;
	}

	public static List<UpdaterLinkDescriptor> getPackage_2007IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	public static List<UpdaterLinkDescriptor> getPackage_2007OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}


	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_classifier_IncomingLink(View view) {
		final Class modelElement = (Class)view.getElement();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_classifier_OutgoingLink(final View view) {
		final Class modelElement = (Class)view.getElement();
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_link_uml_interfacerealization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getAssociation_link_sysml_association_IncomingLink(final View view) {
		final Association modelElement = (Association)view.getElement();
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getAssociation_link_sysml_association_OutgoingLink(final View view) {
		final Association modelElement = (Association)view.getElement();
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4008, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_link_uml_interfacerealization(BehavioredClassifier container) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<InterfaceRealization> links = container.getInterfaceRealizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			Interface dst = link.getContract();
			result.add(new UpdaterLinkDescriptor(container, dst, link, UMLElementTypes.InterfaceRealization_4003, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_link_uml_usage(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_USAGE_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UpdaterLinkDescriptor(src, target, link, UMLElementTypes.Usage_4007, -1));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Comment source) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UpdaterLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Constraint source) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UpdaterLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UpdaterLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UpdaterLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}


	private static Collection<UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_USAGE_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(linkObject))) {
				continue;
			}
			List<NamedElement> targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4007, -1));
		}
		return result;
	}




	private static Collection<UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<NamedElement> targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UpdaterLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(Classifier container) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<Generalization> links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			Classifier dst = link.getGeneral();
			result.add(new UpdaterLinkDescriptor(container, dst, link, UMLElementTypes.Generalization_4002, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			if(false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier)link.eContainer();
			result.add(new UpdaterLinkDescriptor(container, target, link, UMLElementTypes.Generalization_4002, -1));
		}
		return result;
	}


	private static Collection<? extends UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Association_link_sysml_association(Type target, Map<EObject, Collection<Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(!SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<Type> sources = link.getEndTypes();
			//Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			Object theSource = sources.size() >= 2 ? sources.get(1) : null;//source and target ar einverted in BDD
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, SysMLElementTypes.ASSOCIATION, -1));
		}
		return result;
	}

	private static Collection<? extends UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_link_sysml_association(final Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(!SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			//Papyrus GenCode 
			List<Type> targets = link.getEndTypes();
			//			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			Object theTarget = targets.size() >= 1 ? targets.get(0) : null;//source and target are inverted in BDD
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List<Type> sources = link.getEndTypes();
			//			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			Object theSource = sources.size() >= 2 ? sources.get(1) : null;//source and target are inverted in BDD
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			//TODO, FIXME : warning to the several link uml association?
			result.add(new UMLLinkDescriptor(src, dst, link, SysMLElementTypes.ASSOCIATION, -1));
		}
		return result;
	}


}
