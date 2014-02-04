/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;

/**
 * JUnit tests for link creation test (via palette tools).
 */
public abstract class AbstractLinkPrepareTest extends AbstractTest {

	public static String toolID;
	
	// Custom nodes
	public static View blockSourceView, blockTargetView;

	// Custom child label nodes
	public static View actorPartSourceView, actorPartTargetView;
	public static View nestedActorPartSourceView, nestedActorPartTargetView;
	public static View portOnBlockSourceView, portOnBlockTargetView;
	public static View portOnPartSourceView, portOnPartTargetView;
	public static View portOnNestedPartSourceView, portOnNestedPartTargetView;
	public static View flowportOnBlockSourceView, flowportOnBlockTargetView;
	public static View flowportOnPartSourceView, flowportOnPartTargetView;
	public static View flowportOnNestedPartSourceView, flowportOnNestedPartTargetView;
	public static View partSourceView, partTargetView;
	public static View nestedPartSourceView, nestedPartTargetView;
	public static View propertySourceView, propertyTargetView;
	public static View nestedPropertySourceView, nestedPropertyTargetView;
	public static View referenceSourceView, referenceTargetView;
	public static View nestedReferenceSourceView, nestedReferenceTargetView;
	public static View valueSourceView, valueTargetView;
	public static View nestedValueSourceView, nestedValueTargetView;
		
	// Inherited nodes
	public static View commentSourceView, commentTargetView, commentCNSourceView, commentCNTargetView;
	public static View constraintSourceView, constraintTargetView, constraintCNSourceView, constraintCNTargetView;

	public static View partContainer1; // Its type block may be set encapsulated for testing purpose.
	public static View partContainer2; // Its type block may be set encapsulated for testing purpose.

	public static Map<View, Boolean> isCreationAllowed = new HashMap<View, Boolean>();

	public static View subNestedActorPartContainer1_1_1SourceView;

	public static View subNestedActorPartContainer1_1_1TargetView;

	public static View portOnSubNestedPartSourceView;

	public static View portOnSubNestedPartTargetView;

	public static View flowportOnSubNestedPartSourceView;

	public static View flowportOnSubNestedPartTargetView;

	public static View portOnSubNestedPartContainer1_1_1SourceView;

	public static View portOnSubNestedPartContainer2_1_1TargetView;
	
	public static View portOnSubNestedPartContainer1_1_2TargetView;

	public static View flowportOnSubNestedPartContainer1_1_1SourceView;

	public static View flowportOnSubNestedPartContainer2_1_1TargetView;

	public static View portOnSubNestedPartContainer2SourceView;

	public static View portOnSubNestedPartContainer1_2_1TargetView;

	public static View flowportOnSubNestedPartContainer1_2_1TargetView;

	public static View flowportOnSubNestedPartContainer1_1_2TargetView;

	public static View subNestedPartContainer1_1_1SourceView;

	public static View subNestedPartContainer1_2_1TargetView;

	public static View subNestedPartContainer1_1_1TargetView;

	public static View subNestedPartContainer1_1_2TargetView;

	public static View subNestedPropertyContainer1_1_1SourceView;

	public static View subNestedPropertyContainer1_1_1TargetView;

	public static View subNestedPropertyContainer1_2_1TargetView;

	public static View subNestedPropertyContainer1_1_2TargetView;

	public static View subNestedReferenceContainer1_1_1SourceView;

	public static View subNestedReferenceContainer1_1_1TargetView;

	public static View subNestedReferenceContainer1_2_1TargetView;

	public static View subNestedReferenceContainer1_1_2TargetView;

	public static View subNestedValueContainer1_1_1SourceView;

	public static View subNestedValueContainer1_1_1TargetView, subNestedValueContainer1_2_1TargetView, subNestedValueContainer1_1_2TargetView;

	public static View subNestedActorPartContainer1_2_1TargetView;

	public static View subNestedActorPartContainer1_1_2TargetView;

	public static View nestedPartContainer1_1;

	public static View nestedPartContainer2_1;

	public static View nestedPartContainer1_2;
	
	@BeforeClass
	public static void prepareInheritedNodes() throws Exception {
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View containerCpt = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		
		// Prepare elements for link creation tests		
		commentSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentCNSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
		commentCNTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
	
		constraintSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintCNSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
		constraintCNTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
	}
	
	@BeforeClass
	public static void prepareCustomNodes() throws Exception {
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View blockStructureView = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		// part in block (level = 1)
		partContainer1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View partContainer1StructureView = ViewUtil.getChildBySemanticHint(partContainer1, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		partContainer2 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View partContainer2StructureView = ViewUtil.getChildBySemanticHint(partContainer2, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		
		
		nestedPartContainer1_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		View nestedPartContainer1_1StructureView = ViewUtil.getChildBySemanticHint(nestedPartContainer1_1, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		nestedPartContainer2_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		View nestedPartContainer2_1StructureView = ViewUtil.getChildBySemanticHint(nestedPartContainer2_1, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		nestedPartContainer1_2 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer2StructureView);
		View nestedPartContainer1_2StructureView = ViewUtil.getChildBySemanticHint(nestedPartContainer1_2, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		
		// nested container in nested part (level = 3)	
		View subNestedPartContainer1_1_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1StructureView);
		View subNestedPartContainer2_1_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1StructureView);
		
		// nested container in nestedPartContainer2_1  (level = 3)	
		View subNestedPartContainer1_2_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1StructureView);
		
		// nested container in nestedPartContainer1_2StructureView  (level = 3)	
		View subNestedPartContainer1_1_2 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2StructureView);
		
	
		// Prepare elements for link creation tests		

		blockSourceView = container;
		blockTargetView = container;
	
		// Prepare child nodes
		
		partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPartSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedPartTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedPartContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPartContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPartContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedPartContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);

		// Port & FlowPorts no distinction made on FlowPorts kind...
		portOnBlockSourceView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, container);
		portOnBlockTargetView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, container);
		portOnPartSourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)partContainer1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, partContainer1);
		portOnPartTargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)partContainer2.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, partContainer2);
		portOnNestedPartSourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer1_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, nestedPartContainer1_1);
		portOnNestedPartTargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, nestedPartContainer2_1);
		portOnSubNestedPartContainer1_1_1SourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer1_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, subNestedPartContainer1_1_1SourceView);
		portOnSubNestedPartContainer2_1_1TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, subNestedPartContainer2_1_1);
		portOnSubNestedPartContainer1_2_1TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, subNestedPartContainer1_2_1);
		portOnSubNestedPartContainer1_1_2TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, subNestedPartContainer1_1_2);
		
		flowportOnBlockSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, container);
		flowportOnBlockTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, container);
		flowportOnPartSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)partContainer1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, partContainer1);
		flowportOnPartTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)partContainer2.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, partContainer2);
		flowportOnNestedPartSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer1_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, nestedPartContainer1_1);
		flowportOnNestedPartTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, nestedPartContainer2_1);
		flowportOnSubNestedPartContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer1_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, subNestedPartContainer1_1_1SourceView);
		flowportOnSubNestedPartContainer2_1_1TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, subNestedPartContainer2_1_1);
		flowportOnSubNestedPartContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer1_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, subNestedPartContainer1_2_1);
		flowportOnSubNestedPartContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer2_1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, subNestedPartContainer1_1_2);
		
		propertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		propertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPropertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedPropertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedPropertyContainer1_1_1SourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPropertyContainer1_1_1TargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPropertyContainer1_2_1TargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedPropertyContainer1_1_2TargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
		
		referenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		referenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedReferenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedReferenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedReferenceContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedReferenceContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedReferenceContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedReferenceContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
		
		
		valueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		valueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedValueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedValueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedValueContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedValueContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedValueContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedValueContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
		
		actorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		actorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedActorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedActorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedActorPartContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedActorPartContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedActorPartContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedActorPartContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
	}
}
