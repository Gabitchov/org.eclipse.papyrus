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

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientConnectorSourceAndTestDelegate;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.AbstractLinkPrepareTest;
import org.eclipse.uml2.uml.ConnectableElement;
import org.junit.Test;

/**
 * JUnit abstract tests for Connector re-orient and delegation test.
 */
public class AbstractLinkReorientSourceConnectorTest extends AbstractLinkPrepareTest {

	public static View relationshipView;

	public static Map<View, ConnectableElement> expectedSourcePartWithPort;

	public static Map<View, ConnectableElement> expectedTargetPartWithPort;

	@Test
	public void reorientLinkSourceToActorPart() throws Exception {
		View newSourceView = actorPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedActorPart() throws Exception {
		View newSourceView = nestedActorPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnBlock() throws Exception {
		View newSourceView = portOnBlockSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnPart() throws Exception {
		View newSourceView = portOnPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnNestedPart() throws Exception {
		View newSourceView = portOnNestedPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnBlock() throws Exception {
		View newSourceView = flowportOnBlockSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnPart() throws Exception {
		View newSourceView = flowportOnPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnNestedPart() throws Exception {
		View newSourceView = flowportOnNestedPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPart() throws Exception {
		View newSourceView = partSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedPart() throws Exception {
		View newSourceView = nestedPartSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToProperty() throws Exception {
		View newSourceView = propertySourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedProperty() throws Exception {
		View newSourceView = nestedPropertySourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToReference() throws Exception {
		View newSourceView = referenceSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedReference() throws Exception {
		View newSourceView = nestedReferenceSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToValue() throws Exception {
		View newSourceView = valueSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedValue() throws Exception {
		View newSourceView = nestedValueSourceView;
		reorientConnectorSourceAndTestDelegate(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedSourcePartWithPort.get(newSourceView), expectedTargetPartWithPort.get(newSourceView));
	}

}
