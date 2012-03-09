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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientConnectorSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.AbstractLinkPrepareTest;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.eclipse.uml2.uml.Property;
import org.junit.Test;

/**
 * JUnit abstract tests for Connector re-orient.
 */
public class AbstractLinkReorientSourceConnectorTest extends AbstractLinkPrepareTest {

	public static View relationshipView;

	public static Map<View, List<Property>> expectedNestedPath = new HashMap<View, List<Property>>();

	@Test
	public void reorientLinkTargetToDiagram() throws Exception {
		View newSourceView = EditorUtils.getDiagramView();
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToBlock() throws Exception {
		View newSourceView = blockSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToActorPart() throws Exception {
		View newSourceView = actorPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedActorPart() throws Exception {
		View newSourceView = nestedActorPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnBlock() throws Exception {
		View newSourceView = portOnBlockSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnPart() throws Exception {
		View newSourceView = portOnPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnNestedPart() throws Exception {
		View newSourceView = portOnNestedPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnBlock() throws Exception {
		View newSourceView = flowportOnBlockSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnPart() throws Exception {
		View newSourceView = flowportOnPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnNestedPart() throws Exception {
		View newSourceView = flowportOnNestedPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPart() throws Exception {
		View newSourceView = partSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedPart() throws Exception {
		View newSourceView = nestedPartSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToProperty() throws Exception {
		View newSourceView = propertySourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedProperty() throws Exception {
		View newSourceView = nestedPropertySourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToReference() throws Exception {
		View newSourceView = referenceSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedReference() throws Exception {
		View newSourceView = nestedReferenceSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToValue() throws Exception {
		View newSourceView = valueSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToNestedValue() throws Exception {
		View newSourceView = nestedValueSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToComment() throws Exception {
		View newSourceView = commentSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToCommentCN() throws Exception {
		View newSourceView = commentCNSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToConstraint() throws Exception {
		View newSourceView = constraintSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToConstraintCN() throws Exception {
		View newSourceView = constraintCNSourceView;
		reorientConnectorSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView), expectedNestedPath.get(newSourceView));
	}

}
