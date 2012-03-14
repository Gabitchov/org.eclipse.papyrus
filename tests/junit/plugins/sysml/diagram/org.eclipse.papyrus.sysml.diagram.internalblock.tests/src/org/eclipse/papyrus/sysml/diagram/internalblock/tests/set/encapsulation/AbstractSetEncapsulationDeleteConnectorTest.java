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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.setEncapsulationDeleteConnectorTest;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.AbstractLinkPrepareTest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit abstract tests for encapsulation modification effect on Connector test (via palette tools).
 */
public class AbstractSetEncapsulationDeleteConnectorTest extends AbstractLinkPrepareTest {

	public static View sourceView;
	
	public static Map<View, Boolean> isConnectorDestroyed;

	public Element block;
	
	@Before
	public void initBlock() {
		block = (Element)(partContainer1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
	}
	
	@Test
	public void setEncapsulationDeleteConnectorWithTargetActorPart() throws Exception {
		View targetView = actorPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetNestedActorPart() throws Exception {
		View targetView = nestedActorPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetPortOnBlock() throws Exception {
		View targetView = portOnBlockTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetPortOnPart() throws Exception {
		View targetView = portOnPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetPortOnNestedPart() throws Exception {
		View targetView = portOnNestedPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetFlowPortOnBlock() throws Exception {
		View targetView = flowportOnBlockTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetFlowPortOnPart() throws Exception {
		View targetView = flowportOnPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetFlowPortOnNestedPart() throws Exception {
		View targetView = flowportOnNestedPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetPart() throws Exception {
		View targetView = partTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetNestedPart() throws Exception {
		View targetView = nestedPartTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetProperty() throws Exception {
		View targetView = propertyTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetNestedProperty() throws Exception {
		View targetView = nestedPropertyTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetReference() throws Exception {
		View targetView = referenceTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetNestedReference() throws Exception {
		View targetView = nestedReferenceTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetValue() throws Exception {
		View targetView = valueTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

	@Test
	public void setEncapsulationDeleteConnectorWithTargetNestedValue() throws Exception {
		View targetView = nestedValueTargetView;
		setEncapsulationDeleteConnectorTest(block, sourceView, targetView, isCreationAllowed.get(targetView), isConnectorDestroyed.get(targetView));
	}

}
