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
import org.eclipse.papyrus.sysml.requirements.RequirementRelated;
import org.eclipse.papyrus.sysml.requirements.RequirementsFactory;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Requirement Related</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom() <em>Traced From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies() <em>Satisfies</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines() <em>Refines</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies() <em>Verifies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementRelatedTest extends TestCase {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RequirementRelatedTest.class);
	}

	protected RequirementRelated fixture = null;

	protected RequirementRelated default_reqR = null;

	protected Model model = null;

	// ////////////////////////////////////////////////////////////////////

	protected Class copy = null;

	protected Class master = null;

	protected Requirement copy_req = null;

	protected Requirement master_req = null;

	protected RequirementRelated copy_reqR = null;

	protected Requirement trace1_req = null;

	protected Requirement trace2_req = null;

	protected RequirementRelated traced_reqR = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Requirement satisfied1_req = null;

	protected Requirement satisfied2_req = null;

	protected RequirementRelated satisfying_reqR = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Requirement verified1_req = null;

	protected Requirement verified2_req = null;

	protected RequirementRelated verifying_reqR = null;

	// ////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////
	protected Requirement refined1_req = null;

	protected Requirement refined2_req = null;

	protected RequirementRelated refining_reqR = null;

	// ////////////////////////////////////////////////////////////////////

	/**
	 * Constructs a new Requirement Related test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RequirementRelatedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Requirement Related test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected RequirementRelated getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Requirement Related test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(RequirementRelated fixture) {
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
		setFixture(RequirementsFactory.eINSTANCE.createRequirementRelated());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create classes & interface
		Class defaultClass = model.createOwnedClass("defaultClass", false);

		// Add Requirement stereotypes
		default_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(defaultClass, RequirementsPackage.eINSTANCE.getRequirementRelated());

		// ////////////////////////////////////////////////////////////////////
		// Prepare getTracedFrom test elements
		// ////////////////////////////////////////////////////////////////////

		Class traced = model.createOwnedClass("traced", false);
		traced_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(traced, RequirementsPackage.eINSTANCE.getRequirementRelated());

		Class trace1 = model.createOwnedClass("trace1", false);
		trace1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(trace1, RequirementsPackage.eINSTANCE.getRequirement());

		Class trace2 = model.createOwnedClass("trace2", false);
		trace2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(trace2, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "Trace" (Abstraction)
		// trace1, trace2 -> traced
		Abstraction t11 = UMLFactory.eINSTANCE.createAbstraction();
		t11.getClients().add(traced);
		t11.getSuppliers().add(trace1);
		model.getPackagedElements().add(t11);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t11, StandardPackage.eINSTANCE.getTrace());

		Abstraction t12 = UMLFactory.eINSTANCE.createAbstraction();
		t12.getClients().add(traced);
		t12.getSuppliers().add(trace2);
		model.getPackagedElements().add(t12);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(t12, StandardPackage.eINSTANCE.getTrace());

		master = model.createOwnedClass("master", false);
		master_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(master, RequirementsPackage.eINSTANCE.getRequirement());

		copy = model.createOwnedClass("copy", false);
		copy_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(copy, RequirementsPackage.eINSTANCE.getRequirement());
		copy_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(copy, RequirementsPackage.eINSTANCE.getRequirementRelated());

		// Add "copy" (Abstraction) between master and copy
		// copy -> master
		Abstraction c_m = UMLFactory.eINSTANCE.createAbstraction();
		c_m.getClients().add(copy);
		c_m.getSuppliers().add(master);
		model.getPackagedElements().add(c_m);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(c_m, RequirementsPackage.eINSTANCE.getCopy());


		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getSatisfies() test elements
		// ////////////////////////////////////////////////////////////////////

		Class satisfying = model.createOwnedClass("satisfying", false);
		satisfying_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(satisfying, RequirementsPackage.eINSTANCE.getRequirementRelated());

		Class satisfied1 = model.createOwnedClass("satisfied1", false);
		satisfied1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(satisfied1, RequirementsPackage.eINSTANCE.getRequirement());

		Class satisfied2 = model.createOwnedClass("satisfied2", false);
		satisfied2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(satisfied2, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "Satisfy" (Realization)
		// satisfying_reqR -> satisfied1_req, satisfied2_req
		Realization s1 = UMLFactory.eINSTANCE.createRealization();
		s1.getClients().add(satisfying);
		s1.getSuppliers().add(satisfied1);
		model.getPackagedElements().add(s1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(s1, RequirementsPackage.eINSTANCE.getSatisfy());


		Realization s2 = UMLFactory.eINSTANCE.createRealization();
		s2.getClients().add(satisfying);
		s2.getSuppliers().add(satisfied2);
		model.getPackagedElements().add(s2);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(s2, RequirementsPackage.eINSTANCE.getSatisfy());

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getVerifies() test elements
		// ////////////////////////////////////////////////////////////////////

		Class verifying = model.createOwnedClass("verifying", false);
		verifying_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(verifying, RequirementsPackage.eINSTANCE.getRequirementRelated());

		Class verified1 = model.createOwnedClass("verified1", false);
		verified1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(verified1, RequirementsPackage.eINSTANCE.getRequirement());
		Class verified2 = model.createOwnedClass("verified2", false);
		verified2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(verified2, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "Verify" (Realization)
		// verifying_reqR -> verified1_req, verified2_req
		Realization v1 = UMLFactory.eINSTANCE.createRealization();
		v1.getClients().add(verifying);
		v1.getSuppliers().add(verified1);
		model.getPackagedElements().add(v1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(v1, RequirementsPackage.eINSTANCE.getVerify());

		Realization v2 = UMLFactory.eINSTANCE.createRealization();
		v2.getClients().add(verifying);
		v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(v2);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(v2, RequirementsPackage.eINSTANCE.getVerify());


		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getRefines() test elements
		// ////////////////////////////////////////////////////////////////////

		Class refining = model.createOwnedClass("refining", false);
		refining_reqR = (RequirementRelated)StereotypeApplicationHelper.INSTANCE.applyStereotype(refining, RequirementsPackage.eINSTANCE.getRequirementRelated());

		Class refined1 = model.createOwnedClass("refined1", false);
		refined1_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(refined1, RequirementsPackage.eINSTANCE.getRequirement());
		Class refined2 = model.createOwnedClass("refined2", false);
		refined2_req = (Requirement)StereotypeApplicationHelper.INSTANCE.applyStereotype(refined2, RequirementsPackage.eINSTANCE.getRequirement());

		// Add "Refine" (Abstraction)
		// refining_reqR -> refined1_req, refined2_req
		Abstraction r1 = UMLFactory.eINSTANCE.createAbstraction();
		r1.getClients().add(refining);
		r1.getSuppliers().add(refined1);
		model.getPackagedElements().add(r1);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(r1, StandardPackage.eINSTANCE.getRefine());

		Abstraction r2 = UMLFactory.eINSTANCE.createAbstraction();
		r2.getClients().add(refining);
		r2.getSuppliers().add(refined2);
		model.getPackagedElements().add(r2);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(r2, StandardPackage.eINSTANCE.getRefine());


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
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines()
	 * <em>Refines</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines()
	 * @generated NOT
	 */
	public void testGetRefines() {

		// Isolated RequirementRelated
		if(!default_reqR.getRefines().isEmpty()) {
			fail();
		}

		// refining_reqR.getRefines() = [refined1_req, refined2_req]
		if(!refining_reqR.getRefines().contains(refined1_req)) {
			fail();
		}
		if(!refining_reqR.getRefines().contains(refined2_req)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies()
	 * <em>Satisfies</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies()
	 * @generated NOT
	 */
	public void testGetSatisfies() {

		// Isolated RequirementRelated
		if(!default_reqR.getSatisfies().isEmpty()) {
			fail();
		}

		// satisfying_reqR.getSatisfies() = [satisfied1_req, satisfied2_req]
		if(!satisfying_reqR.getSatisfies().contains(satisfied1_req)) {
			fail();
		}
		if(!satisfying_reqR.getSatisfies().contains(satisfied2_req)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom()
	 * <em>Traced From</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom()
	 * @generated NOT
	 */
	public void testGetTracedFrom() {

		// Isolated RequirementRelated
		if(!default_reqR.getTracedFrom().isEmpty()) {
			fail();
		}

		// traced_reqR.getTraceFrom() = [trace1_Req, trace2_req]
		if(!traced_reqR.getTracedFrom().contains(trace1_req)) {
			fail();
		}
		if(!traced_reqR.getTracedFrom().contains(trace2_req)) {
			fail();
		}

		// Should not include Trace subtypes clients
		// Test getter through Copy (should not be taken into account see bug #352563)
		if(copy_reqR.getTracedFrom().contains(master)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies()
	 * <em>Verifies</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies()
	 * @generated NOT
	 */
	public void testGetVerifies() {

		// Isolated RequirementRelated
		if(!default_reqR.getVerifies().isEmpty()) {
			fail();
		}

		// verifying_reqR.getVerifies() = [verified1_req, verified2_req]
		if(!verifying_reqR.getVerifies().contains(verified1_req)) {
			fail();
		}
		if(!verifying_reqR.getVerifies().contains(verified2_req)) {
			fail();
		}

	}

} // RequirementRelatedTest
