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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.delegation;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Property;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector re-orient.
 */
public class TestLinkReorientTargetConnector extends AbstractLinkReorientTargetConnectorTest {
	
	@Before
	public void initRelationship() throws Exception {
		
		// Prepare source and target
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);

		// Prepare relationship
		relationshipView = TestPrepareUtils.createGraphicalLink(
			UMLElementTypes.CONNECTOR, 
			UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, 
			container, 
			EditorUtils.getEditPart(portOnPartSourceView), 
			EditorUtils.getEditPart(portOnNestedPartTargetView));
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		Property part = (Property) partContainer1.getElement();
		List<Property> nestedPath = new ArrayList<Property>();
		nestedPath.add(part);
				
		// Initialize source creation results
		isReorientAllowed = new HashMap<View, Boolean>();
			
		isReorientAllowed.put(actorPartTargetView, true);
		isReorientAllowed.put(nestedActorPartTargetView, true);
		
		isReorientAllowed.put(portOnBlockTargetView, true);
		isReorientAllowed.put(portOnPartTargetView, true);
		isReorientAllowed.put(portOnNestedPartTargetView, true);
		
		isReorientAllowed.put(flowportOnBlockTargetView, true);
		isReorientAllowed.put(flowportOnPartTargetView, true);
		isReorientAllowed.put(flowportOnNestedPartTargetView, true);
		
		isReorientAllowed.put(partTargetView, true);
		isReorientAllowed.put(nestedPartTargetView, true);
		isReorientAllowed.put(partTargetView, true);
		isReorientAllowed.put(subNestedPartContainer1TargetView, true);
		isReorientAllowed.put(subNestedPartContainer2TargetView, true);
		
		isReorientAllowed.put(propertyTargetView, true);
		isReorientAllowed.put(nestedPropertyTargetView, true);
		
		isReorientAllowed.put(referenceTargetView, true);
		isReorientAllowed.put(nestedReferenceTargetView, true);
		
		isReorientAllowed.put(valueTargetView, true);
		isReorientAllowed.put(nestedValueTargetView, true);

		// Initialize partWithPort for tests
		Property sourcepart = (Property)partContainer1.getElement();
		Property targetpart = (Property)partContainer2.getElement();

		Property targetNestedpart = (Property)nestedPartContainer2.getElement();
		
		Property targetsubNestedPartContainer1 = (Property)subNestedPartContainer1TargetView.getElement();
		Property targetsubNestedPartContainer2 = (Property)subNestedPartContainer2TargetView.getElement();

		expectedSourcePartWithPort = new HashMap<View, ConnectableElement>();
		expectedTargetPartWithPort = new HashMap<View, ConnectableElement>();

		for (View view : isReorientAllowed.keySet()) {
			expectedSourcePartWithPort.put(view, sourcepart);
		}
	
		expectedSourcePartWithPort.remove(nestedActorPartTargetView);
		expectedSourcePartWithPort.remove(nestedPartTargetView);
		expectedSourcePartWithPort.remove(nestedPropertyTargetView);
		expectedSourcePartWithPort.remove(nestedReferenceTargetView);
		expectedSourcePartWithPort.remove(nestedValueTargetView);
		expectedSourcePartWithPort.remove(portOnNestedPartTargetView);
		expectedSourcePartWithPort.remove(flowportOnNestedPartTargetView);
		expectedSourcePartWithPort.remove(subNestedPartContainer1TargetView);
		expectedSourcePartWithPort.remove(subNestedPartContainer2TargetView);
		
		expectedTargetPartWithPort.put(portOnPartTargetView, targetpart);
		expectedTargetPartWithPort.put(flowportOnPartTargetView, targetpart);
		
		expectedTargetPartWithPort.put(portOnNestedPartTargetView, targetNestedpart);
		expectedTargetPartWithPort.put(flowportOnNestedPartTargetView, targetNestedpart);
		
		//expectedTargetPartWithPort.put(subNestedPartContainer1TargetView, targetsubNestedPartContainer1);
		//expectedTargetPartWithPort.put(subNestedPartContainer2TargetView, targetsubNestedPartContainer2);

	}
}
