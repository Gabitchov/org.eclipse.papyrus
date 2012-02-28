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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.altdrop;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.altDropFromModelExplorer;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) on ActorPart.
 */
public class TestTypeDropOnTypedElement extends AbstractTest {

	public static EObject containerPackage;
	
	public static EObject droppedDataType;
	public static EObject droppedFlowSpec;
	public static EObject droppedActor;
	public static EObject droppedBlock;

	public static View actorPartView;
	public static View partView;
	public static View propertyView;
	public static View referenceView;
	public static View valueView;
	public static View nestedActorPartView;
	public static View nestedPartView;
	public static View nestedPropertyView;
	public static View nestedReferenceView;
	public static View nestedValueView;
	public static View portView;
	public static View flowportView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// prepare container
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			
			actorPartView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			propertyView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			referenceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			valueView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			
			View partViewContainer = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			View partStructureViewContainer = ViewUtil.getChildBySemanticHint(partViewContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);

			nestedActorPartView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureViewContainer);
			nestedPartView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureViewContainer);
			nestedPropertyView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureViewContainer);
			nestedReferenceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureViewContainer);
			nestedValueView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureViewContainer);
			
			portView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, blockView);
			flowportView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, blockView);

			if ((actorPartView == null) || (partView == null) || (propertyView == null) || (referenceView == null) || (valueView == null)
				|| (nestedActorPartView == null) || (nestedPartView == null) || (nestedPropertyView == null) || (nestedReferenceView == null) || (nestedValueView == null)
				|| (portView == null) || (flowportView == null)) {
				throw new Exception("Unable to prepare container for test.");
			}

			// prepare container package (getDiagramView references the shown Block).
			containerPackage = EMFCoreUtil.getContainer(getDiagramView().getElement(), UMLPackage.eINSTANCE.getPackage());
			// prepare dropped element
			droppedDataType = createElement(UMLElementTypes.DATA_TYPE, containerPackage);
			droppedFlowSpec = createElement(SysMLElementTypes.FLOW_SPECIFICATION, containerPackage);
			droppedActor = createElement(UMLElementTypes.ACTOR, containerPackage);
			droppedBlock = createElement(SysMLElementTypes.BLOCK, containerPackage);

		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testDropTypeOnActorPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, actorPartView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedDataType, partView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnProperty() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, propertyView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedDataType, referenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnValue() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, valueView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnNestedActorPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, nestedActorPartView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnNestedPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedDataType, nestedPartView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnNestedProperty() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, nestedPropertyView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnNestedReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedDataType, nestedReferenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnNestedValue() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, nestedValueView, expectedDropNames, true);
	}
		
	@Test
	public void testDropFlowSpecOnPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)"});
		altDropFromModelExplorer(droppedFlowSpec, partView, expectedDropNames, true);
	}
	
	@Test
	public void testDropFlowSpecOnReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)"});
		altDropFromModelExplorer(droppedFlowSpec, referenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropFlowSpecOnNestedPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)"});
		altDropFromModelExplorer(droppedFlowSpec, nestedPartView, expectedDropNames, true);
	}
	
	@Test
	public void testDropFlowSpecOnNestedReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)"});
		altDropFromModelExplorer(droppedFlowSpec, nestedReferenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port"});
		altDropFromModelExplorer(droppedActor, partView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port"});
		altDropFromModelExplorer(droppedActor, referenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnNestedPart() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port"});
		altDropFromModelExplorer(droppedActor, nestedPartView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnNestedReference() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Set a new Type", 
			"Create a new Port"});
		altDropFromModelExplorer(droppedActor, nestedReferenceView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnProperty() throws Exception {
		// Specific test for Block drop because it is supposed to create the related Association
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedBlock, propertyView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnNestedProperty() throws Exception {
		// Specific test for Block drop because it is supposed to create the related Association
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedBlock, nestedPropertyView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnPort() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, portView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnFlowPort() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Set a new Type"});
		altDropFromModelExplorer(droppedDataType, flowportView, expectedDropNames, true);
	}
}
