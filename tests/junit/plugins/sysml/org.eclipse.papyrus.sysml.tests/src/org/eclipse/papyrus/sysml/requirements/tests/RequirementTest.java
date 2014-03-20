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
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerived() <em>Derived</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom() <em>Derived From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy() <em>Satisfied By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy() <em>Refined By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo() <em>Traced To</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy() <em>Verified By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getMaster() <em>Master</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementTest extends TestCase {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RequirementTest.class);
	}

	/**
	 * The fixture for this Requirement test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected Requirement fixture = null;

	protected Class defaultClass = null;

	protected Requirement default_req = null;

	// ////////////////////////////////////////////////////////////////////
	protected Class copy = null;

	protected Class master = null;

	protected Requirement copy_req = null;

	protected Requirement master_req = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Class derive1 = null;

	protected Class derive2 = null;

	protected Class derived1 = null;

	protected Class derived2 = null;

	protected Requirement derive1_req = null;

	protected Requirement derive2_req = null;

	protected Requirement derived1_req = null;

	protected Requirement derived2_req = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Class satisfied = null;

	protected Class satisfyingNE1 = null;

	protected Class satisfyingNE2 = null;

	protected Requirement satisfied_req = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Class refined = null;

	protected Class refiningNE1 = null;

	protected Class refiningNE2 = null;

	protected Requirement refined_req = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Class traced1 = null;

	protected Class traced2 = null;

	protected Class trace = null;

	protected Requirement traced1_req = null;

	protected Requirement traced2_req = null;

	protected Requirement trace_req = null;

	// ////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////
	protected Requirement verified_req = null;

	protected org.eclipse.papyrus.sysml.requirements.TestCase testCase1 = null;

	protected NamedElement verifierNamedElement = null;

	// ////////////////////////////////////////////////////////////////////

	protected org.eclipse.papyrus.sysml.requirements.TestCase testCase2 = null;

	protected Model model = null;

	/**
	 * Constructs a new Requirement test case with the given name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public RequirementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Requirement test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected Requirement getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Requirement test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected void setFixture(Requirement fixture) {
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
		setFixture(RequirementsFactory.eINSTANCE.createRequirement());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create classes & interface
		defaultClass = model.createOwnedClass("defaultClass", false);

		// Add Requirement stereotypes
		default_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(defaultClass, RequirementsPackage.eINSTANCE.getRequirement());

		// ////////////////////////////////////////////////////////////////////
		// Prepare getMaster test elements
		// ////////////////////////////////////////////////////////////////////

		master = model.createOwnedClass("master", false);
		master_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(master, RequirementsPackage.eINSTANCE.getRequirement());
		copy = model.createOwnedClass("copy", false);
		copy_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(copy, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "copy" (Abstraction) between master and copy
		// copy -> master
		Abstraction c_m = UMLFactory.eINSTANCE.createAbstraction();
		c_m.getClients().add(copy);
		c_m.getSuppliers().add(master);
		model.getPackagedElements().add(c_m);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(c_m, RequirementsPackage.eINSTANCE.getCopy());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getDerived / getDerivedFrom test elements
		// ////////////////////////////////////////////////////////////////////

		derive1 = model.createOwnedClass("d1", false);
		derive1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(derive1, RequirementsPackage.eINSTANCE.getRequirement());

		derive2 = model.createOwnedClass("d2", false);
		derive2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(derive2, RequirementsPackage.eINSTANCE.getRequirement());

		derived1 = model.createOwnedClass("dd1", false);
		derived1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(derived1, RequirementsPackage.eINSTANCE.getRequirement());

		derived2 = model.createOwnedClass("dd2", false);
		derived2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(derived2, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "DeriveReqt" (Abstraction) between derive and derived
		// derived1 -> derive1, derive2
		// derived2 -> derive2
		Abstraction d11 = UMLFactory.eINSTANCE.createAbstraction();
		d11.getClients().add(derived1);
		d11.getSuppliers().add(derive1);
		model.getPackagedElements().add(d11);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(d11, RequirementsPackage.eINSTANCE.getDeriveReqt());

		Abstraction d12 = UMLFactory.eINSTANCE.createAbstraction();
		d12.getClients().add(derived1);
		d12.getSuppliers().add(derive2);
		model.getPackagedElements().add(d12);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(d12, RequirementsPackage.eINSTANCE.getDeriveReqt());

		Abstraction d22 = UMLFactory.eINSTANCE.createAbstraction();
		d22.getClients().add(derived2);
		d22.getSuppliers().add(derive2);
		model.getPackagedElements().add(d22);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(d22, RequirementsPackage.eINSTANCE.getDeriveReqt());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getSatisfiedBy test elements
		// ////////////////////////////////////////////////////////////////////

		satisfied = model.createOwnedClass("satisfied", false);
		satisfied_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(satisfied, RequirementsPackage.eINSTANCE.getRequirement());

		satisfyingNE1 = model.createOwnedClass("sNE1", false);
		satisfyingNE2 = model.createOwnedClass("sNE2", false);

		// Add "Satisfy" (Realization) between satisfyingNE(s) and satisfied
		// requirement
		// satisfyingNE1, satisfyingNE2 -> satisfied
		Realization ne1_s1 = UMLFactory.eINSTANCE.createRealization();
		ne1_s1.getClients().add(satisfyingNE1);
		ne1_s1.getSuppliers().add(satisfied);
		model.getPackagedElements().add(ne1_s1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(ne1_s1, RequirementsPackage.eINSTANCE.getSatisfy());

		Realization ne2_s1 = UMLFactory.eINSTANCE.createRealization();
		ne2_s1.getClients().add(satisfyingNE2);
		ne2_s1.getSuppliers().add(satisfied);
		model.getPackagedElements().add(ne2_s1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(ne2_s1, RequirementsPackage.eINSTANCE.getSatisfy());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getRefinedBy test elements
		// ////////////////////////////////////////////////////////////////////

		refined = model.createOwnedClass("refined", false);
		refined_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(refined, RequirementsPackage.eINSTANCE.getRequirement());

		refiningNE1 = model.createOwnedClass("rNE1", false);
		refiningNE2 = model.createOwnedClass("rNE2", false);

		// Add "Refine" (Abstraction) between refiningNE(s) and refined
		// requirement
		// refiningNE1, refiningNE2 -> refined
		Abstraction rne1_s1 = UMLFactory.eINSTANCE.createAbstraction();
		rne1_s1.getClients().add(refiningNE1);
		rne1_s1.getSuppliers().add(refined);
		model.getPackagedElements().add(rne1_s1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(rne1_s1, StandardPackage.eINSTANCE.getRefine());

		Abstraction rne2_s1 = UMLFactory.eINSTANCE.createAbstraction();
		rne2_s1.getClients().add(refiningNE2);
		rne2_s1.getSuppliers().add(refined);
		model.getPackagedElements().add(rne2_s1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(rne2_s1, StandardPackage.eINSTANCE.getRefine());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getTracedTo test elements
		// ////////////////////////////////////////////////////////////////////

		traced1 = model.createOwnedClass("traced1", false);
		traced1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(traced1, RequirementsPackage.eINSTANCE.getRequirement());

		traced2 = model.createOwnedClass("traced2", false);
		traced2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(traced2, RequirementsPackage.eINSTANCE.getRequirement());

		trace = model.createOwnedClass("trace", false);
		trace_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(trace, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "Trace" (Abstraction)
		// [traced1, traced2] -> trace
		Abstraction t11 = UMLFactory.eINSTANCE.createAbstraction();
		t11.getClients().add(traced1);
		t11.getSuppliers().add(trace);
		model.getPackagedElements().add(t11);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t11, StandardPackage.eINSTANCE.getTrace());

		Abstraction t12 = UMLFactory.eINSTANCE.createAbstraction();
		t12.getClients().add(traced2);
		t12.getSuppliers().add(trace);
		model.getPackagedElements().add(t12);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t12, StandardPackage.eINSTANCE.getTrace());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getVerifiedBy test elements
		// ////////////////////////////////////////////////////////////////////

		verifierNamedElement = model.createOwnedClass("verifierNamedElement", false);

		Class verified = model.createOwnedClass("verified", false);
		verified_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(verified, RequirementsPackage.eINSTANCE.getRequirement());

		Class testClass = model.createOwnedClass("testClass", false);
		Operation op1 = testClass.createOwnedOperation("op1", null, null, null);
		Operation op2 = testClass.createOwnedOperation("op2", null, null, null);

		testCase1 = (org.eclipse.papyrus.sysml.requirements.TestCase)StereotypeApplicationHelper.INSTANCE.applyStereotype(op1, RequirementsPackage.eINSTANCE.getTestCase());
		testCase2 = (org.eclipse.papyrus.sysml.requirements.TestCase)StereotypeApplicationHelper.INSTANCE.applyStereotype(op2, RequirementsPackage.eINSTANCE.getTestCase());

		// Add "Verify" (Abstraction)
		// testCase1, testCase2 -> verified
		Abstraction t1_v = UMLFactory.eINSTANCE.createAbstraction();
		t1_v.getClients().add(op1);
		t1_v.getSuppliers().add(verified);
		model.getPackagedElements().add(t1_v);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t1_v, RequirementsPackage.eINSTANCE.getVerify());

		Abstraction t2_v = UMLFactory.eINSTANCE.createAbstraction();
		t2_v.getClients().add(op2);
		t2_v.getSuppliers().add(verified);
		model.getPackagedElements().add(t2_v);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t2_v, RequirementsPackage.eINSTANCE.getVerify());

		// Add "Verify" (Abstraction)
		// verifierNamedElement -> verified
		Abstraction t3_v = UMLFactory.eINSTANCE.createAbstraction();
		t3_v.getClients().add(verifierNamedElement);
		t3_v.getSuppliers().add(verified);
		model.getPackagedElements().add(t3_v);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t3_v, RequirementsPackage.eINSTANCE.getVerify());

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
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerived()
	 * <em>Derived</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getDerived()
	 * @generated NOT
	 */
	public void testGetDerived() {

		// Isolated requirement : default_req.getDerived() = []
		if(!default_req.getDerived().isEmpty()) {
			fail();
		}

		// Verifies : derive1_req.getDerived() = [derived1_req]
		if(!derive1_req.getDerived().contains(derived1_req)) {
			fail();
		}

		// Verifies : derive2_req.getDerived() = [derived1_req, derived2_req]
		if(!derive2_req.getDerived().contains(derived1_req)) {
			fail();
		}

		if(!derive2_req.getDerived().contains(derived2_req)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom()
	 * <em>Derived From</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom()
	 * @generated NOT
	 */
	public void testGetDerivedFrom() {

		// Isolated requirement : default_req.getDerivedFrom() = []
		if(!default_req.getDerivedFrom().isEmpty()) {
			fail();
		}

		// Verifies : derived2_req.getDerivedFrom() = [derive2_req]
		if(!derived2_req.getDerivedFrom().contains(derive2_req)) {
			fail();
		}

		// Verifies : derived1_req.getDerivedFrom() = [derive1_req, derive2_req]
		if(!derived1_req.getDerivedFrom().contains(derive1_req)) {
			fail();
		}
		if(!derived1_req.getDerivedFrom().contains(derive2_req)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getMaster()
	 * <em>Master</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getMaster()
	 * @generated NOT
	 */
	public void testGetMaster() {

		// Isolated requirement : default_req.getMaster() = null
		if(default_req.getMaster() != null) {
			fail();
		}

		// Try retrieving Master from Copy requirement
		if(!master_req.equals(copy_req.getMaster())) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy()
	 * <em>Refined By</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy()
	 * @generated NOT
	 */
	public void testGetRefinedBy() {

		// Isolated requirement : default_req.getRefinedBy() = []
		if(!default_req.getRefinedBy().isEmpty()) {
			fail();
		}

		// Verifies : refined_req.getRefinedBy() = [refiningNE1, refiningNE2]
		if(!refined_req.getRefinedBy().contains(refiningNE1)) {
			fail();
		}
		if(!refined_req.getRefinedBy().contains(refiningNE2)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy()
	 * <em>Satisfied By</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy()
	 * @generated NOT
	 */
	public void testGetSatisfiedBy() {

		// Isolated requirement : default_req.getSatisfiedBy() = []
		if(!default_req.getSatisfiedBy().isEmpty()) {
			fail();
		}

		// Verifies : satisfied_req.getSatisfiedBy() = [satisfyingNE1, satisfyingNE2]
		if(!satisfied_req.getSatisfiedBy().contains(satisfyingNE1)) {
			fail();
		}
		if(!satisfied_req.getSatisfiedBy().contains(satisfyingNE2)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo()
	 * <em>Traced To</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo()
	 * @generated NOT
	 */
	public void testGetTracedTo() {

		// Isolated requirement : default_req.getTracedTo = []
		if(!default_req.getTracedTo().isEmpty()) {
			fail();
		}

		// DeriveReqt / Verify / Copy inherits from Trace
		// Test getter through Copy (should not be taken into account see bug #352563)
		if(master_req.getTracedTo().contains(copy)) {
			fail();
		}

		// Test getter through DeriveReqt (tracedTo = Clients)
		// derived1 -> [derive1_req, derive2_req] (should not be taken into account see bug #352563)
		// derived2 -> [derive2_req] (should not be taken into account see bug #352563)
		if(derive1_req.getTracedTo().contains(derived1)) {
			fail();
		}
		if(derive2_req.getTracedTo().contains(derived1)) {
			fail();
		}
		if(derive2_req.getTracedTo().contains(derived2)) {
			fail();
		}

		// Test getter through Verify (should not be taken into account see bug #352563)
		// Should not happen...

		// Direct test
		if(!trace_req.getTracedTo().contains(traced1)) {
			fail();
		}
		if(!trace_req.getTracedTo().contains(traced2)) {
			fail();
		}

	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy()
	 * <em>Verified By</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy()
	 * @generated NOT
	 */
	public void testGetVerifiedBy() {

		// Isolated requirement : default_req.getVerifiedBy() = []
		if(!default_req.getVerifiedBy().isEmpty()) {
			fail();
		}

		// Test getVerifiedBy getter for
		// [testCase1, testCase2, verifierNamedElement] -> verified_req
		if(!verified_req.getVerifiedBy().contains(testCase1.getBase_Operation())) {
			fail();
		}
		if(!verified_req.getVerifiedBy().contains(testCase2.getBase_Operation())) {
			fail();
		}
		if(!verified_req.getVerifiedBy().contains(verifierNamedElement)) {
			fail();
		}
	}

} // RequirementTest
