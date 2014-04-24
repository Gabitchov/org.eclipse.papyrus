/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.requirements.tests;

import static org.junit.Assert.fail;

import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsFactory;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Test Case</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies() <em>Verifies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseTest extends AbstractPapyrusTest {

	protected org.eclipse.papyrus.sysml.requirements.TestCase fixture = null;

	// ////////////////////////////////////////////////////////////////////
	protected Model model = null;

	protected Requirement verified1_req = null;

	protected Requirement verified2_req = null;

	protected org.eclipse.papyrus.sysml.requirements.TestCase testCase0 = null;

	protected org.eclipse.papyrus.sysml.requirements.TestCase testCase1 = null;

	protected org.eclipse.papyrus.sysml.requirements.TestCase testCase2 = null;

	// ////////////////////////////////////////////////////////////////////

	/**
	 * Returns the fixture for this Test Case test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected org.eclipse.papyrus.sysml.requirements.TestCase getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Test Case test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(org.eclipse.papyrus.sysml.requirements.TestCase fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Before
	public void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createTestCase());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// ////////////////////////////////////////////////////////////////////
		// Prepare getVerifies test elements
		// ////////////////////////////////////////////////////////////////////

		Class verified1 = model.createOwnedClass("verified1", false);
		verified1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(verified1, RequirementsPackage.eINSTANCE.getRequirement());

		Class verified2 = model.createOwnedClass("verified2", false);
		verified2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(verified2, RequirementsPackage.eINSTANCE.getRequirement());

		Class testClass = model.createOwnedClass("testClass", false);
		Operation op0 = testClass.createOwnedOperation("op0", null, null, null);
		Operation op1 = testClass.createOwnedOperation("op1", null, null, null);
		Operation op2 = testClass.createOwnedOperation("op2", null, null, null);

		testCase0 = (org.eclipse.papyrus.sysml.requirements.TestCase)StereotypeApplicationHelper.INSTANCE.applyStereotype(op0, RequirementsPackage.eINSTANCE.getTestCase());
		testCase1 = (org.eclipse.papyrus.sysml.requirements.TestCase)StereotypeApplicationHelper.INSTANCE.applyStereotype(op1, RequirementsPackage.eINSTANCE.getTestCase());
		testCase2 = (org.eclipse.papyrus.sysml.requirements.TestCase)StereotypeApplicationHelper.INSTANCE.applyStereotype(op2, RequirementsPackage.eINSTANCE.getTestCase());

		// Add "Verify" (Abstraction)
		// testCase1, testCase2 -> verified1
		// testCase2 -> verified2
		Abstraction t1_v1 = UMLFactory.eINSTANCE.createAbstraction();
		t1_v1.getClients().add(op1);
		t1_v1.getSuppliers().add(verified1);
		model.getPackagedElements().add(t1_v1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t1_v1, RequirementsPackage.eINSTANCE.getVerify());

		Abstraction t1_v2 = UMLFactory.eINSTANCE.createAbstraction();
		t1_v2.getClients().add(op1);
		t1_v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(t1_v2);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t1_v2, RequirementsPackage.eINSTANCE.getVerify());

		Abstraction t2_v2 = UMLFactory.eINSTANCE.createAbstraction();
		t2_v2.getClients().add(op2);
		t2_v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(t2_v2);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t2_v2, RequirementsPackage.eINSTANCE.getVerify());

		// ////////////////////////////////////////////////////////////////////
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@After
	public void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies()
	 * <em>Verifies</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies()
	 * @generated NOT
	 */
	@Test
	public void testGetVerifies() {

		// testCase0 -> []
		if(!testCase0.getVerifies().isEmpty()) {
			fail();
		}

		// testCase1 -> [verified1_req, verified2_req]
		if(!testCase1.getVerifies().contains(verified1_req)) {
			fail();
		}
		if(!testCase1.getVerifies().contains(verified2_req)) {
			fail();
		}

		// testCase2 -> [verified2_req]
		if(!testCase2.getVerifies().contains(verified2_req)) {
			fail();
		}

	}

} // TestCaseTest
