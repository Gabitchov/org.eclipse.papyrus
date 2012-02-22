package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;

/**
 * JUnit tests for Dependency creation test (via palette tools).
 */
public class AbstractLinkPrepareTest extends AbstractTest {

	public static String toolID;
	
	// Custom nodes
	public static View actorSourceView, actorTargetView;
	public static View blockSourceView, blockTargetView;
	public static View constraintBlockSourceView, constraintBlockTargetView;
	public static View dataTypeSourceView, dataTypeTargetView;
	public static View dimensionSourceView, dimensionTargetView;
	public static View enumerationSourceView, enumerationTargetView;
	public static View flowSpecificationSourceView, flowSpecificationTargetView;
	public static View interfaceSourceView, interfaceTargetView;
	public static View primitiveTypeSourceView, primitiveTypeTargetView;
	public static View signalSourceView, signalTargetView;
	public static View unitSourceView, unitTargetView;
	public static View valueTypeSourceView, valueTypeTargetView;

	// Custom child label nodes
	public static View actorPartSourceView, actorPartTargetView;
	public static View propertySourceView, propertyTargetView;
	public static View portSourceView, portTargetView;
	public static View flowportSourceView, flowportTargetView;
	public static View partSourceView, partTargetView;
	public static View referenceSourceView, referenceTargetView;
	public static View valueSourceView, valueTargetView;
	public static View operationSourceView, operationTargetView;
	public static View receptionSourceView, receptionTargetView;
	public static View constraintCLNSourceView, constraintCLNTargetView;
	public static View constraintPropertySourceView, constraintPropertyTargetView;
	public static View flowPropertySourceView, flowPropertyTargetView;
	public static View enumerationLiteralSourceView, enumerationLiteralTargetView;
		
	// Inherited nodes
	public static View commentSourceView, commentTargetView, commentCNSourceView, commentCNTargetView;
	public static View constraintSourceView, constraintTargetView, constraintCNSourceView, constraintCNTargetView;
	public static View instanceSpecSourceView, instanceSpecTargetView, instanceSpecCNSourceView, instanceSpecCNTargetView;
	public static View modelSourceView, modelTargetView, modelCNSourceView, modelCNTargetView;
	public static View packageSourceView, packageTargetView, packageCNSourceView, packageCNTargetView;
	
	// Inherited child label nodes
	public static View slotSourceView, slotTargetView;
	
	public static Map<View, Boolean> isCreationAllowed = new HashMap<View, Boolean>();
	
	@BeforeClass
	public static void prepareInheritedNodes() throws Exception {
		View container = createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.PACKAGE.getSemanticHint(), getDiagramView());
		View containerCpt = ViewUtil.getChildBySemanticHint(container, ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT);
		
		// Prepare elements for link creation tests		
		commentSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentCNSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
		commentCNTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
	
		constraintSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintCNSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
		constraintCNTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
		
		instanceSpecSourceView = createGraphicalNode(UMLElementTypes.INSTANCE_SPECIFICATION, ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint(), getDiagramView());
		instanceSpecTargetView = createGraphicalNode(UMLElementTypes.INSTANCE_SPECIFICATION, ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint(), getDiagramView());
		instanceSpecCNSourceView = createGraphicalNode(UMLElementTypes.INSTANCE_SPECIFICATION, ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint(), containerCpt);
		instanceSpecCNTargetView = createGraphicalNode(UMLElementTypes.INSTANCE_SPECIFICATION, ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint(), containerCpt);
		
		modelSourceView = createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL.getSemanticHint(), getDiagramView());
		modelTargetView = createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL.getSemanticHint(), getDiagramView());
		modelCNSourceView = createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL_CN.getSemanticHint(), containerCpt);
		modelCNTargetView = createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL_CN.getSemanticHint(), containerCpt);
		
		packageSourceView = createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.PACKAGE.getSemanticHint(), getDiagramView());
		packageTargetView = createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.PACKAGE.getSemanticHint(), getDiagramView());
		packageCNSourceView = createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.PACKAGE_CN.getSemanticHint(), containerCpt);
		packageCNTargetView = createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.PACKAGE_CN.getSemanticHint(), containerCpt);
		
		// Prepare child nodes
		View slotSourceCpt = ViewUtil.getChildBySemanticHint(instanceSpecSourceView, ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT);
		View slotTargetCpt = ViewUtil.getChildBySemanticHint(instanceSpecTargetView, ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT);

		slotSourceView = createGraphicalNode(UMLElementTypes.SLOT, ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint(), slotSourceCpt);
		slotTargetView = createGraphicalNode(UMLElementTypes.SLOT, ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint(), slotTargetCpt);
	}
	
	@BeforeClass
	public static void prepareCustomNodes() throws Exception {
		// Prepare elements for link creation tests		
		actorSourceView = createGraphicalNode(UMLElementTypes.ACTOR, UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID, getDiagramView());
		actorTargetView = createGraphicalNode(UMLElementTypes.ACTOR, UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID, getDiagramView());
		blockSourceView = createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView());
		blockTargetView = createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView());
		constraintBlockSourceView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID, getDiagramView());
		constraintBlockTargetView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID, getDiagramView());
		dataTypeSourceView = createGraphicalNode(UMLElementTypes.DATA_TYPE, UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID, getDiagramView());
		dataTypeTargetView = createGraphicalNode(UMLElementTypes.DATA_TYPE, UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID, getDiagramView());
		dimensionSourceView = createGraphicalNode(SysMLElementTypes.DIMENSION, SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID, getDiagramView());
		dimensionTargetView = createGraphicalNode(SysMLElementTypes.DIMENSION, SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID, getDiagramView());
		enumerationSourceView = createGraphicalNode(UMLElementTypes.ENUMERATION, UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID, getDiagramView());
		enumerationTargetView = createGraphicalNode(UMLElementTypes.ENUMERATION, UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID, getDiagramView());
		flowSpecificationSourceView = createGraphicalNode(SysMLElementTypes.FLOW_SPECIFICATION, SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID, getDiagramView());
		flowSpecificationTargetView = createGraphicalNode(SysMLElementTypes.FLOW_SPECIFICATION, SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID, getDiagramView());
		interfaceSourceView = createGraphicalNode(UMLElementTypes.INTERFACE, UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID, getDiagramView());
		interfaceTargetView = createGraphicalNode(UMLElementTypes.INTERFACE, UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID, getDiagramView());
		primitiveTypeSourceView = createGraphicalNode(UMLElementTypes.PRIMITIVE_TYPE, UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID, getDiagramView());
		primitiveTypeTargetView = createGraphicalNode(UMLElementTypes.PRIMITIVE_TYPE, UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID, getDiagramView());
		signalSourceView = createGraphicalNode(UMLElementTypes.SIGNAL, UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID, getDiagramView());
		signalTargetView = createGraphicalNode(UMLElementTypes.SIGNAL, UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID, getDiagramView());
		unitSourceView = createGraphicalNode(SysMLElementTypes.UNIT, SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID, getDiagramView());
		unitTargetView = createGraphicalNode(SysMLElementTypes.UNIT, SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID, getDiagramView());
		valueTypeSourceView = createGraphicalNode(SysMLElementTypes.VALUE_TYPE, SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID, getDiagramView());
		valueTypeTargetView = createGraphicalNode(SysMLElementTypes.VALUE_TYPE, SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID, getDiagramView());
		
		// Prepare child nodes
		
		// TODO : Add Port / FlowPort as AffixedNode
		
		View propertySourceCpt = ViewUtil.getChildBySemanticHint(blockSourceView, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View propertyTargetCpt = ViewUtil.getChildBySemanticHint(blockTargetView, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);

		actorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, propertySourceCpt);
		actorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, propertyTargetCpt);
		propertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, propertySourceCpt);
		propertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, propertyTargetCpt);	
		portSourceView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID, propertySourceCpt);
		portTargetView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID, propertyTargetCpt);	
		flowportSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID, propertySourceCpt);
		flowportTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID, propertyTargetCpt);	
		partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID, propertySourceCpt);
		partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID, propertyTargetCpt);	
		referenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID, propertySourceCpt);
		referenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID, propertyTargetCpt);
		valueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID, propertySourceCpt);
		valueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID, propertyTargetCpt);
		
		View operationSourceCpt = ViewUtil.getChildBySemanticHint(blockSourceView, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		View operationTargetCpt = ViewUtil.getChildBySemanticHint(blockTargetView, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		
		operationSourceView = createGraphicalNode(UMLElementTypes.OPERATION, UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID, operationSourceCpt);
		operationTargetView = createGraphicalNode(UMLElementTypes.OPERATION, UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID, operationTargetCpt);	
		receptionSourceView = createGraphicalNode(UMLElementTypes.RECEPTION, UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID, operationSourceCpt);
		receptionTargetView = createGraphicalNode(UMLElementTypes.RECEPTION, UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID, operationTargetCpt);
		
		View constraintSourceCpt = ViewUtil.getChildBySemanticHint(blockSourceView, SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID);
		View constraintTargetCpt = ViewUtil.getChildBySemanticHint(blockTargetView, SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID);
		
		constraintCLNSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, constraintSourceCpt);
		constraintCLNTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, constraintTargetCpt);	
		constraintPropertySourceView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID, constraintSourceCpt);
		constraintPropertyTargetView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID, constraintTargetCpt);
	
		View flowPropertySourceCpt = ViewUtil.getChildBySemanticHint(flowSpecificationSourceView, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID);
		View flowPropertyTargetCpt = ViewUtil.getChildBySemanticHint(flowSpecificationTargetView, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID);
		
		flowPropertySourceView = createGraphicalNode(SysMLElementTypes.FLOW_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID, flowPropertySourceCpt);
		flowPropertyTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID, flowPropertyTargetCpt);	
		
		View enumLiteralSourceCpt = ViewUtil.getChildBySemanticHint(enumerationSourceView, UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID);
		View enumLiteralTargetCpt = ViewUtil.getChildBySemanticHint(enumerationTargetView, UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID);
		
		enumerationLiteralSourceView = createGraphicalNode(UMLElementTypes.ENUMERATION_LITERAL, UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID, enumLiteralSourceCpt);
		enumerationLiteralTargetView = createGraphicalNode(UMLElementTypes.ENUMERATION_LITERAL, UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID, enumLiteralTargetCpt);	
	}
}
