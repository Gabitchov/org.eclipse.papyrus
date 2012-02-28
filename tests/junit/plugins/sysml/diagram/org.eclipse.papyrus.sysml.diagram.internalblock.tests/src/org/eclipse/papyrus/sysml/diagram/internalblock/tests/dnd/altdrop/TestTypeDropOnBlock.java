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
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) on ActorPart.
 */
public class TestTypeDropOnBlock extends AbstractTest {

	public static EObject containerPackage;
	
	public static EObject droppedDataType;
	public static EObject droppedFlowSpec;
	public static EObject droppedActor;
	public static EObject droppedBlock;

	public static View blockView;
	public static View blockStructureView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// prepare container
			blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);

			if ((blockView == null) || (blockStructureView == null)) {
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
	public void testDropActorOnBlock() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Port"});
		altDropFromModelExplorer(droppedActor, blockView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnBlockCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new ActorPart"});
		altDropFromModelExplorer(droppedActor, blockStructureView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnBlock() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedBlock, blockView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnBlockCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Part", "Create a new Reference"});
		altDropFromModelExplorer(droppedBlock, blockStructureView, expectedDropNames, true);
	}
	
	@Test
	public void testDropDataTypeOnBlock() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)", 
			"Create a new FlowPort (SysML::FlowPort_In)", 
			"Create a new FlowPort (SysML::FlowPort_Out)"});
		altDropFromModelExplorer(droppedDataType, blockView, expectedDropNames, true);
	}
	
	@Test
	public void testDropDataTypeOnBlockCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Value"});
		altDropFromModelExplorer(droppedDataType, blockStructureView, expectedDropNames, true);
	}
	
	@Test
	public void testDropFlowSpecOnBlock() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{
			"Create a new Port", 
			"Create a new FlowPort (SysML::FlowPort)"});
		altDropFromModelExplorer(droppedFlowSpec, blockView, expectedDropNames, true);
	}
	
	@Test
	public void testDropFlowSpecOnBlockCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Property"});
		altDropFromModelExplorer(droppedFlowSpec, blockStructureView, expectedDropNames, true);
	}
}
