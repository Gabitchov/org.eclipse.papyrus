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
import java.util.Collections;
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
public class TestTypeDropOnTypedElementCompartment extends AbstractTest {

	public static EObject containerPackage;
	
	public static EObject droppedDataType;
	public static EObject droppedActor;
	public static EObject droppedBlock;

	public static View actorPartCptView;
	public static View partCptView;
	public static View propertyCptView;
	public static View referenceCptView;
	public static View valueCptView;
	
	public static View nestedActorPartCptView;
	public static View nestedPartCptView;
	public static View nestedPropertyCptView;
	public static View nestedReferenceCptView;
	public static View nestedValueCptView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// prepare container
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			
			View actorPartView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			actorPartCptView = ViewUtil.getChildBySemanticHint(actorPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			partCptView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View propertyView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			propertyCptView = ViewUtil.getChildBySemanticHint(propertyView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View referenceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			referenceCptView = ViewUtil.getChildBySemanticHint(referenceView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View valueView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			valueCptView = ViewUtil.getChildBySemanticHint(valueView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			
			if ((actorPartCptView == null) || (partCptView == null) || (propertyCptView == null) || (referenceCptView == null) || (valueCptView == null)) {
				throw new Exception("Unable to prepare container for test.");
			}
			
			View nestedActorPartView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partCptView);
			nestedActorPartCptView = ViewUtil.getChildBySemanticHint(nestedActorPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View nestedPartView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partCptView);
			nestedPartCptView = ViewUtil.getChildBySemanticHint(nestedPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View nestedPropertyView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partCptView);
			nestedPropertyCptView = ViewUtil.getChildBySemanticHint(nestedPropertyView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View nestedReferenceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partCptView);
			nestedReferenceCptView = ViewUtil.getChildBySemanticHint(nestedReferenceView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			View nestedValueView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partCptView);
			nestedValueCptView = ViewUtil.getChildBySemanticHint(nestedValueView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			
			if ((nestedActorPartCptView == null) || (nestedPartCptView == null) || (nestedPropertyCptView == null) || (nestedReferenceCptView == null) || (nestedValueCptView == null)) {
				throw new Exception("Unable to prepare nested container for test.");
			}

			// prepare container package (getDiagramView references the shown Block).
			containerPackage = EMFCoreUtil.getContainer(getDiagramView().getElement(), UMLPackage.eINSTANCE.getPackage());
			// prepare dropped element
			droppedDataType = createElement(UMLElementTypes.DATA_TYPE, containerPackage);
			droppedActor = createElement(UMLElementTypes.ACTOR, containerPackage);
			droppedBlock = createElement(SysMLElementTypes.BLOCK, containerPackage);

		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testDropTypeOnActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, actorPartCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropTypeOnPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Value"});
		altDropFromModelExplorer(droppedDataType, partCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, propertyCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropTypeOnReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Value"});
		altDropFromModelExplorer(droppedDataType, referenceCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropTypeOnValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, valueCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropActorOnActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, actorPartCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropActorOnPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new ActorPart"});
		altDropFromModelExplorer(droppedActor, partCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, propertyCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropActorOnReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new ActorPart"});
		altDropFromModelExplorer(droppedActor, referenceCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropActorOnValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, valueCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropBlockOnActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, actorPartCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropBlockOnPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Part", "Create a new Reference"});
		altDropFromModelExplorer(droppedBlock, partCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, propertyCptView, expectedDropNames, false);
	}
	
	@Test
	public void testDropBlockOnReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Part", "Create a new Reference"});
		altDropFromModelExplorer(droppedBlock, referenceCptView, expectedDropNames, true);
	}
	
	@Test
	public void testDropBlockOnValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, valueCptView, expectedDropNames, false);
	}

	@Test
	public void testDropActorOnNestedActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, actorPartCptView, expectedDropNames, false);
	}

	@Test
	public void testDropActorOnNestedPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new ActorPart"});
		altDropFromModelExplorer(droppedActor, partCptView, expectedDropNames, true);
	}

	@Test
	public void testDropActorOnNestedPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, propertyCptView, expectedDropNames, false);
	}

	@Test
	public void testDropActorOnNestedReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new ActorPart"});
		altDropFromModelExplorer(droppedActor, referenceCptView, expectedDropNames, true);
	}

	@Test
	public void testDropActorOnNestedValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedActor, valueCptView, expectedDropNames, false);
	}

	@Test
	public void testDropBlockOnNestedActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, actorPartCptView, expectedDropNames, false);
	}

	@Test
	public void testDropBlockOnNestedPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Part", "Create a new Reference"});
		altDropFromModelExplorer(droppedBlock, partCptView, expectedDropNames, true);
	}

	@Test
	public void testDropBlockOnNestedPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, propertyCptView, expectedDropNames, false);
	}

	@Test
	public void testDropBlockOnNestedReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Part", "Create a new Reference"});
		altDropFromModelExplorer(droppedBlock, referenceCptView, expectedDropNames, true);
	}

	@Test
	public void testDropBlockOnNestedValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedBlock, valueCptView, expectedDropNames, false);
	}

	@Test
	public void testDropTypeOnNestedActorPartCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, actorPartCptView, expectedDropNames, false);
	}

	@Test
	public void testDropTypeOnNestedPartCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Value"});
		altDropFromModelExplorer(droppedDataType, partCptView, expectedDropNames, true);
	}

	@Test
	public void testDropTypeOnNestedPropertyCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, propertyCptView, expectedDropNames, false);
	}

	@Test
	public void testDropTypeOnNestedReferenceCpt() throws Exception {
		List<String> expectedDropNames = Arrays.asList(new String[]{"Create a new Value"});
		altDropFromModelExplorer(droppedDataType, referenceCptView, expectedDropNames, true);
	}

	@Test
	public void testDropTypeOnNestedValueCpt() throws Exception {
		List<String> expectedDropNames = Collections.emptyList();
		altDropFromModelExplorer(droppedDataType, valueCptView, expectedDropNames, false);
	}
}
