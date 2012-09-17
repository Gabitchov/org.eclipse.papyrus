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

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientConnectorTargetAndTestDelegate;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.AbstractLinkPrepareTest;
import org.eclipse.uml2.uml.ConnectableElement;
import org.junit.Test;

/**
 * JUnit abstract tests for Connector re-orient and delegation test.
 */
public class AbstractLinkReorientTargetConnectorTest extends AbstractLinkPrepareTest {

	public static View relationshipView;

	public static Map<View, ConnectableElement> expectedSourcePartWithPort;

	public static Map<View, ConnectableElement> expectedTargetPartWithPort;
	
	@Test
	public void reorientLinkTargetToActorPart() throws Exception {
		View newTargetView = actorPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedActorPart() throws Exception {
		View newTargetView = nestedActorPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnBlock() throws Exception {
		View newTargetView = portOnBlockTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnPart() throws Exception {
		View newTargetView = portOnPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnNestedPart() throws Exception {
		View newTargetView = portOnNestedPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnBlock() throws Exception {
		View newTargetView = flowportOnBlockTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnPart() throws Exception {
		View newTargetView = flowportOnPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnNestedPart() throws Exception {
		View newTargetView = flowportOnNestedPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPart() throws Exception {
		View newTargetView = partTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedPart() throws Exception {
		View newTargetView = nestedPartTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToProperty() throws Exception {
		View newTargetView = propertyTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedProperty() throws Exception {
		View newTargetView = nestedPropertyTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToReference() throws Exception {
		View newTargetView = referenceTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedReference() throws Exception {
		View newTargetView = nestedReferenceTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToValue() throws Exception {
		View newTargetView = valueTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedValue() throws Exception {
		View newTargetView = nestedValueTargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedSourcePartWithPort.get(newTargetView), expectedTargetPartWithPort.get(newTargetView));
	}
	
	@Test
	public void reorientLinkSourceToDeepNestedPartContainer1() throws Exception {
		View newSourceView = subNestedPartContainer1TargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToDeepNestedPartContainer2() throws Exception {
		View newSourceView = subNestedPartContainer2TargetView;
		reorientConnectorTargetAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}
}
