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
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.papyrus.uml.standard.Refine;
import org.eclipse.papyrus.uml.standard.Trace;
import org.eclipse.papyrus.uml.standard.util.StandardResource;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;

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
		default_reqR = (RequirementRelated)defaultClass.applyStereotype(defaultClass.getApplicableStereotype(SysmlResource.REQUIREMENT_RELATED_ID));

		// ////////////////////////////////////////////////////////////////////
		// Prepare getTracedFrom test elements
		// ////////////////////////////////////////////////////////////////////

		Class traced = model.createOwnedClass("traced", false);
		traced_reqR = (RequirementRelated)traced.applyStereotype(traced.getApplicableStereotype(SysmlResource.REQUIREMENT_RELATED_ID));

		Class trace1 = model.createOwnedClass("trace1", false);
		trace1_req = (Requirement)trace1.applyStereotype(trace1.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));
		Class trace2 = model.createOwnedClass("trace2", false);
		trace2_req = (Requirement)trace2.applyStereotype(trace2.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));

		// Add "Trace" (Abstraction)
		// trace1, trace2 -> traced
		Abstraction t11 = UMLFactory.eINSTANCE.createAbstraction();
		t11.getClients().add(trace1);
		t11.getSuppliers().add(traced);
		model.getPackagedElements().add(t11);
		@SuppressWarnings("unused")
		Trace t_t11 = (Trace)t11.applyStereotype(t11.getApplicableStereotype(StandardResource.TRACE_ID));

		Abstraction t12 = UMLFactory.eINSTANCE.createAbstraction();
		t12.getClients().add(trace2);
		t12.getSuppliers().add(traced);
		model.getPackagedElements().add(t12);
		@SuppressWarnings("unused")
		Trace t_t12 = (Trace)t12.applyStereotype(t12.getApplicableStereotype(StandardResource.TRACE_ID));

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getSatisfies() test elements
		// ////////////////////////////////////////////////////////////////////

		Class satisfying = model.createOwnedClass("satisfying", false);
		satisfying_reqR = (RequirementRelated)satisfying.applyStereotype(satisfying.getApplicableStereotype(SysmlResource.REQUIREMENT_RELATED_ID));

		Class satisfied1 = model.createOwnedClass("satisfied1", false);
		satisfied1_req = (Requirement)satisfied1.applyStereotype(satisfied1.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));
		Class satisfied2 = model.createOwnedClass("satisfied2", false);
		satisfied2_req = (Requirement)satisfied2.applyStereotype(satisfied2.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));

		// Add "Satisfy" (Realization)
		// satisfying_reqR -> satisfied1_req, satisfied2_req
		Realization s1 = UMLFactory.eINSTANCE.createRealization();
		s1.getClients().add(satisfying);
		s1.getSuppliers().add(satisfied1);
		model.getPackagedElements().add(s1);
		@SuppressWarnings("unused")
		Satisfy s_s1 = (Satisfy)s1.applyStereotype(s1.getApplicableStereotype(SysmlResource.SATISFY_ID));

		Realization s2 = UMLFactory.eINSTANCE.createRealization();
		s2.getClients().add(satisfying);
		s2.getSuppliers().add(satisfied2);
		model.getPackagedElements().add(s2);
		@SuppressWarnings("unused")
		Satisfy s_s2 = (Satisfy)s2.applyStereotype(s2.getApplicableStereotype(SysmlResource.SATISFY_ID));

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getVerifies() test elements
		// ////////////////////////////////////////////////////////////////////

		Class verifying = model.createOwnedClass("verifying", false);
		verifying_reqR = (RequirementRelated)verifying.applyStereotype(verifying.getApplicableStereotype(SysmlResource.REQUIREMENT_RELATED_ID));

		Class verified1 = model.createOwnedClass("verified1", false);
		verified1_req = (Requirement)verified1.applyStereotype(verified1.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));
		Class verified2 = model.createOwnedClass("verified2", false);
		verified2_req = (Requirement)verified2.applyStereotype(verified2.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));

		// Add "Verify" (Realization)
		// verifying_reqR -> verified1_req, verified2_req
		Realization v1 = UMLFactory.eINSTANCE.createRealization();
		v1.getClients().add(verifying);
		v1.getSuppliers().add(verified1);
		model.getPackagedElements().add(v1);
		@SuppressWarnings("unused")
		Verify v_v1 = (Verify)v1.applyStereotype(v1.getApplicableStereotype(SysmlResource.VERIFY_ID));

		Realization v2 = UMLFactory.eINSTANCE.createRealization();
		v2.getClients().add(verifying);
		v2.getSuppliers().add(verified2);
		model.getPackagedElements().add(v2);
		@SuppressWarnings("unused")
		Verify v_v2 = (Verify)v2.applyStereotype(v2.getApplicableStereotype(SysmlResource.VERIFY_ID));

		// ////////////////////////////////////////////////////////////////////

		// ////////////////////////////////////////////////////////////////////
		// Prepare getRefines() test elements
		// ////////////////////////////////////////////////////////////////////

		Class refining = model.createOwnedClass("refining", false);
		refining_reqR = (RequirementRelated)refining.applyStereotype(refining.getApplicableStereotype(SysmlResource.REQUIREMENT_RELATED_ID));

		Class refined1 = model.createOwnedClass("refined1", false);
		refined1_req = (Requirement)refined1.applyStereotype(refined1.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));
		Class refined2 = model.createOwnedClass("refined2", false);
		refined2_req = (Requirement)refined2.applyStereotype(refined2.getApplicableStereotype(SysmlResource.REQUIREMENT_ID));

		// Add "Refine" (Abstraction)
		// refining_reqR -> refined1_req, refined2_req
		Abstraction r1 = UMLFactory.eINSTANCE.createAbstraction();
		r1.getClients().add(refining);
		r1.getSuppliers().add(refined1);
		model.getPackagedElements().add(r1);
		@SuppressWarnings("unused")
		Refine r_r1 = (Refine)r1.applyStereotype(r1.getApplicableStereotype(StandardResource.REFINE_ID));

		Abstraction r2 = UMLFactory.eINSTANCE.createAbstraction();
		r2.getClients().add(refining);
		r2.getSuppliers().add(refined2);
		model.getPackagedElements().add(r2);
		@SuppressWarnings("unused")
		Refine r_r2 = (Refine)r2.applyStereotype(r2.getApplicableStereotype(StandardResource.REFINE_ID));

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
