/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createEdgeFromPalette;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.Test;

/**
 * JUnit tests for Dependency creation test (via palette tools).
 */
public class AbstractLinkCreationForSourcesTest extends AbstractLinkPrepareTest {

	public static String toolID;
		
	@Test
	public void createLinkWithSourceActor() throws Exception {
		View sourceView = actorSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceActorPart() throws Exception {
		View sourceView = actorPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceBlock() throws Exception {
		View sourceView = blockSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraintBlock() throws Exception {
		View sourceView = constraintBlockSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceDataType() throws Exception {
		View sourceView = dataTypeSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceDimension() throws Exception {
		View sourceView = dimensionSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceEnumeration() throws Exception {
		View sourceView = enumerationSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceFlowSpecification() throws Exception {
		View sourceView = flowSpecificationSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceInterface() throws Exception {
		View sourceView = interfaceSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePrimitiveType() throws Exception {
		View sourceView = primitiveTypeSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceSignal() throws Exception {
		View sourceView = signalSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceUnit() throws Exception {
		View sourceView = unitSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceValueType() throws Exception {
		View sourceView = valueTypeSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
		
	@Test
	public void createLinkWithSourceComment() throws Exception {
		View sourceView = commentSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
		
	@Test
	public void createLinkWithSourceCommentCN() throws Exception {
		View sourceView = commentCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
		
	@Test
	public void createLinkWithSourceConstraint() throws Exception {
		View sourceView = constraintSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraintCN() throws Exception {
		View sourceView = constraintCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
		
	@Test
	public void createLinkWithSourceInstanceSpec() throws Exception {
		View sourceView = instanceSpecSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
		
	@Test
	public void createLinkWithSourceInstanceSpecCN() throws Exception {
		View sourceView = instanceSpecCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceModel() throws Exception {
		View sourceView = modelSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceModelCN() throws Exception {
		View sourceView = modelCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePackage() throws Exception {
		View sourceView = packageSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePackageCN() throws Exception {
		View sourceView = packageCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	// Test child label nodes
	
	@Test
	public void createLinkWithSourceSlot() throws Exception {
		View sourceView = slotSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceProperty() throws Exception {
		View sourceView = propertySourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePort() throws Exception {
		View sourceView = portSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceFlowPort() throws Exception {
		View sourceView = flowportSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePart() throws Exception {
		View sourceView = partSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceReference() throws Exception {
		View sourceView = referenceSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceValue() throws Exception {
		View sourceView = valueSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceOperation() throws Exception {
		View sourceView = operationSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceReception() throws Exception {
		View sourceView = receptionSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraintCLN() throws Exception {
		View sourceView = constraintCLNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraintProperty() throws Exception {
		View sourceView = constraintPropertySourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceAssociation() throws Exception {
		View sourceView = associationSourceView;
		boolean isAllowed = isCreationAllowed.get(sourceView);
		createEdgeFromPalette(toolID, sourceView, null, isAllowed);
	}

	
	@Test
	public void createLinkWithSourceEnumerationLiteral() throws Exception {
		View sourceView = enumerationLiteralSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
		System.out.println("THIS TEST IS FINISHED");
	}
	
	@Test
	public void createLinkWithSourceFlowProperty() throws Exception {
		View sourceView = flowPropertySourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	
}
