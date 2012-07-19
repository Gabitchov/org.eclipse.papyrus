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
public class TestLinkReorientSourceConnector extends AbstractLinkReorientSourceConnectorTest {
	
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
				
		isReorientAllowed.put(actorPartSourceView, true);
		isReorientAllowed.put(nestedActorPartSourceView, true);
		
		isReorientAllowed.put(portOnBlockSourceView, true);
		isReorientAllowed.put(portOnPartSourceView, true);
		isReorientAllowed.put(portOnNestedPartSourceView, true);
		
		isReorientAllowed.put(flowportOnBlockSourceView, true);
		isReorientAllowed.put(flowportOnPartSourceView, true);
		isReorientAllowed.put(flowportOnNestedPartSourceView, true);
		
		isReorientAllowed.put(partSourceView, true);
		isReorientAllowed.put(nestedPartSourceView, true);
		isReorientAllowed.put(subNestedPartContainer1SourceView, true);
		isReorientAllowed.put(subNestedPartContainer2SourceView, true);
		
		isReorientAllowed.put(propertySourceView, true);
		isReorientAllowed.put(nestedPropertySourceView, true);
		
		isReorientAllowed.put(referenceSourceView, true);
		isReorientAllowed.put(nestedReferenceSourceView, true);
		
		isReorientAllowed.put(valueSourceView, true);
		isReorientAllowed.put(nestedValueSourceView, true);

		// Initialize partWithPort for tests
		Property sourceNestedpart = (Property)nestedPartContainer1.getElement();
		
		Property targetNestedpart = (Property)nestedPartContainer2.getElement();

		expectedSourcePartWithPort = new HashMap<View, ConnectableElement>();
		expectedTargetPartWithPort = new HashMap<View, ConnectableElement>();

		for (View view : isReorientAllowed.keySet()) {
			expectedTargetPartWithPort.put(view, targetNestedpart);
		}
			
		expectedSourcePartWithPort.put(portOnNestedPartSourceView, sourceNestedpart);
		expectedSourcePartWithPort.put(flowportOnNestedPartSourceView, sourceNestedpart);
	}
}
