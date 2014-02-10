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

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createEdgeConnectorAndTestDelegateFromPalette;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ConnectableElement;
import org.junit.Test;

/**
 * JUnit abstract tests for Link creation test (via palette tools).
 */
public abstract class AbstractConnectorCreationAndTestDelegateFromElementTest extends AbstractConnectorCreationAndTestDelegatePrepareTest {

	public static String toolID;

	public static View sourceView;

	public static Map<View, ConnectableElement> expectedSourcePartWithPort;

	public static Map<View, ConnectableElement> expectedTargetPartWithPort;

	// FIXME : wrong name in all methods => replace Source by Target
	// BMA : ne passe pas là
	@Test
	public void createLinkWithSourceBlock() throws Exception {
		View targetView = blockTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceActorPart() throws Exception {
		View targetView = actorPart2_BlockTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedActorPart() throws Exception {
		View targetView = actorPart2_p1TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourcePortOnBlock() throws Exception {
		View targetView = portOnBlockTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}	
	
	// BMA : ne passe pas là
	@Test
	public void createLinkWithTargetPort2OnPart1() throws Exception {
		View targetView = port2_Part1TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}	

	// BMA : ne passe pas là
	@Test
	public void createLinkWithTargetPort1OnPart1() throws Exception {
		View targetView = port1_Part1SourceView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}		
	
	@Test
	public void createLinkWithSourcePortOnPart() throws Exception {
		View targetView = port1_Part2TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}
	
	@Test
	public void createLinkWithSourcePortOnNestedPart() throws Exception {
		View targetView = port2OnNestedPart2_Part1TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnBlock() throws Exception {
		View targetView = flowportOnBlockTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnPart() throws Exception {
		View targetView = flowport1_Part2TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnNestedPart() throws Exception {
		View targetView = flowport1_NestedPart2_Part1TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourcePart() throws Exception {
		View targetView = partTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedPart() throws Exception {
		View targetView = nestedPart2_Part1TargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceProperty() throws Exception {
		View targetView = propertyTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedProperty() throws Exception {
		View targetView = nestedPropertyTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceReference() throws Exception {
		View targetView = referenceTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedReference() throws Exception {
		View targetView = nestedReferenceTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceValue() throws Exception {
		View targetView = valueTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedValue() throws Exception {
		View targetView = nestedValueTargetView;
		createEdgeConnectorAndTestDelegateFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourcePartWithPort.get(targetView), expectedTargetPartWithPort.get(targetView));
	}

}
