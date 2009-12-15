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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsFactory;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;

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
public class TestCaseTest extends TestCase {

	/**
	 * The fixture for this Test Case test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static String VERIFY_ID = "SysML::Requirements::Verify";

	public static String TESTCASE_ID = "SysML::Requirements::TestCase";

	public static String REQUIREMENT_ID = "SysML::Requirements::Requirement";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TestCaseTest.class);
	}

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
	 * Constructs a new Test Case test case with the given name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public TestCaseTest(String name) {
		super(name);
	}

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
	@Override
	protected void setUp() throws Exception {
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
		verified1_req = (Requirement)verified1.applyStereotype(verified1.getApplicableStereotype(REQUIREMENT_ID));

		Class verified2 = model.createOwnedClass("verified2", false);
		verified2_req = (Requirement)verified2.applyStereotype(verified2.getApplicableStereotype(REQUIREMENT_ID));

		Class testClass = model.createOwnedClass("testClass", false);
		Operation op0 = testClass.createOwnedOperation("op0", null, null, null);
		Operation op1 = testClass.createOwnedOperation("op1", null, null, null);
		Operation op2 = testClass.createOwnedOperation("op2", null, null, null);

		testCase0 = (org.eclipse.papyrus.sysml.requirements.TestCase)op0.applyStereotype(op0.getApplicableStereotype(TESTCASE_ID));
		testCase1 = (org.eclipse.papyrus.sysml.requirements.TestCase)op1.applyStereotype(op1.getApplicableStereotype(TESTCASE_ID));
		testCase2 = (org.eclipse.papyrus.sysml.requirements.TestCase)op2.applyStereotype(op2.getApplicableStereotype(TESTCASE_ID));

		// Add "Verify" (Abstraction)
		// testCase1, testCase2 -> verified1
		// testCase2 -> verified2
		Abstraction t1_v1 = UMLFactory.eINSTANCE.createAbstraction();
		t1_v1.getClients().add(op1);
		t1_v1.getSuppliers().add(verified1);
		model.getPackagedElements().add(t1_v1);
		@SuppressWarnings("unused")
		Verify v_t1_v1 = (Verify)t1_v1.applyStereotype(t1_v1.getApplicableStereotype(VERIFY_ID));

		Abstraction t1_v2 = UMLFactory.eINSTANCE.createAbstraction();
		t1_v2.getClients().add(op1);
		t1_v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(t1_v2);
		@SuppressWarnings("unused")
		Verify v_t1_v2 = (Verify)t1_v2.applyStereotype(t1_v2.getApplicableStereotype(VERIFY_ID));

		Abstraction t2_v2 = UMLFactory.eINSTANCE.createAbstraction();
		t2_v2.getClients().add(op2);
		t2_v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(t2_v2);
		@SuppressWarnings("unused")
		Verify v_t2_v2 = (Verify)t2_v2.applyStereotype(t2_v2.getApplicableStereotype(VERIFY_ID));

		// ////////////////////////////////////////////////////////////////////
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies()
	 * <em>Verifies</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies()
	 * @generated NOT
	 */
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
