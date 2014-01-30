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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;

/**
 * JUnit tests for link creation test (via palette tools).
 */
public abstract class AbstractConnectorCreationAndTestDelegatePrepareTest extends AbstractTest {

	public static String toolID;
	
	// Custom nodes
	public static View blockSourceView, blockTargetView;

	// Custom child label nodes
	public static View actorPart1_BlockSourceView, actorPart2_BlockTargetView;
	public static View actorPart1_p1_SourceView, actorPart2_p1TargetView, actorPart1_p2TargetView, actorPart1_p1_p1SourceView, actorPart2_p1_p1TargetView, actorPart1_p2_p1TargetView, actorPart1_p1_p2TargetView;
	public static View portOnBlockSourceView, portOnBlockTargetView;
	public static View port1_Part1SourceView, port2_Part1TargetView, port1_Part2TargetView, port2_Part2TargetView;
	public static View port1OnNestedPart1_Part1SourceView, port2OnNestedPart2_Part1TargetView, port1OnNestedPart1_Part2TargetView;
	public static View flowportOnBlockSourceView, flowportOnBlockTargetView;
	public static View flowport1_Part1SourceView, flowport1_Part2TargetView;
	public static View flowport1_NestedPart1_Part1SourceView, flowport1_NestedPart2_Part1TargetView, flowport1_NestedPart1_Part2TargetView;
	public static View partSourceView, partTargetView;
	public static View nestedPart1_Part1SourceView, nestedPart2_Part1TargetView, nestedPart1_Part2TargetView;
	public static View propertySourceView, propertyTargetView;
	public static View nestedPropertySourceView, nestedPropertyTargetView;
	public static View referenceSourceView, referenceTargetView;
	public static View nestedReferenceSourceView, nestedReferenceTargetView;
	public static View valueSourceView, valueTargetView;
	public static View nestedValueSourceView, nestedValueTargetView;
	
	public static View p1View; // Its type block may be set encapsulated for testing purpose.
	public static View p2View; // Its type block may be set encapsulated for testing purpose.
	public static View p1_p1View, p2_p1View;
	public static View p1_p1StructureView, p2_p1StructureView;
	public static View p1_p2View;
	public static View p1_p2StructureView;
	
	
	public static Map<View, Boolean> isCreationAllowed = new HashMap<View, Boolean>();
		
	@BeforeClass
	public static void prepareCustomNodes() throws Exception {
		View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		p1View = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View p1StructureView = ViewUtil.getChildBySemanticHint(p1View, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		p2View = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View p2StructureView = ViewUtil.getChildBySemanticHint(p2View, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		
		// nested part to contain elements to be tested on level 2
		p1_p1View = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		p1_p1StructureView = ViewUtil.getChildBySemanticHint(p1View, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		p2_p1View = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		p2_p1StructureView = ViewUtil.getChildBySemanticHint(p1View, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		p1_p2View = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p2StructureView);
		p1_p2StructureView = ViewUtil.getChildBySemanticHint(p2View, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);

		// Prepare elements for link creation tests		

		blockSourceView = blockView;
		blockTargetView = blockView;
	
		// Prepare child nodes
		actorPart1_BlockSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		actorPart2_BlockTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		actorPart1_p1_SourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		actorPart2_p1TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		actorPart1_p2TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p2StructureView);
		actorPart1_p1_p1SourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1_p1StructureView);
		actorPart2_p1_p1TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1_p1StructureView);
		actorPart1_p2_p1TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p2_p1StructureView);
		actorPart1_p1_p2TargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1_p2StructureView);
		

		// Port & FlowPorts no distinction made on FlowPorts kind...
		portOnBlockSourceView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, blockView);
		portOnBlockTargetView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, blockView);
		port1_Part1SourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p1View);
		port2_Part1TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p1View);	
		port1_Part2TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p2View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p2View);
		
		// BMA temp
		port2_Part2TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p2View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p2View);
		
		// ?? kesako ? 
		port1OnNestedPart1_Part1SourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p1_p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p1_p1View);
		port2OnNestedPart2_Part1TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p2_p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p2_p1View);
		port1OnNestedPart1_Part2TargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)p1_p2View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, p1_p2View);
		
		flowportOnBlockSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, blockView);
		flowportOnBlockTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, blockView);
		flowport1_Part1SourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, p1View);
		flowport1_Part2TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)p2View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, p2View);
		flowport1_NestedPart1_Part1SourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)p1_p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, p1_p1View);
		flowport1_NestedPart2_Part1TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)p2_p1View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, p2_p1View);
		flowport1_NestedPart1_Part2TargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)p1_p2View.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, p1_p2View);
		
		partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPart1_Part1SourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		nestedPart2_Part1TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		nestedPart1_Part2TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p2StructureView);
		
		propertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		propertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPropertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		nestedPropertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		
		referenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		referenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedReferenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		nestedReferenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		
		valueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		valueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedValueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		nestedValueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, p1StructureView);
		
	}
}
