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
package org.eclipse.papyrus.sysml.portandflows.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.FlowSpecification;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsFactory;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Flow Port</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isIsAtomic() <em>Is Atomic</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon() <em>Get Icon</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FlowPortTest extends TestCase {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FlowPortTest.class);
	}

	protected FlowPort fixture = null;

	protected Class c0 = null;

	protected Interface i2 = null;

	protected Port p0 = null;

	protected Port p1 = null;

	protected Port p2 = null;

	protected FlowPort fp0 = null;

	protected FlowPort fp1 = null;

	protected FlowPort fp2 = null;

	protected FlowSpecification fsp2 = null;

	protected Model model = null;

	/**
	 * Constructs a new Flow Port test case with the given name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public FlowPortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Flow Port test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected FlowPort getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Flow Port test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(FlowPort fixture) {
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
		setFixture(PortandflowsFactory.eINSTANCE.createFlowPort());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create classes & interface
		c0 = model.createOwnedClass("c0", false);
		i2 = model.createOwnedInterface("i2");

		// Create type
		PrimitiveType ptype = model.createOwnedPrimitiveType("type");

		// Create ports
		p0 = c0.createOwnedPort("p0", null);
		p1 = c0.createOwnedPort("p1", ptype);
		p2 = c0.createOwnedPort("p2", i2);

		// Add FlowPort stereotypes
		fp0 = (FlowPort)p0.applyStereotype(p0.getApplicableStereotype(SysmlResource.FLOW_PORT_ID));
		fp1 = (FlowPort)p1.applyStereotype(p1.getApplicableStereotype(SysmlResource.FLOW_PORT_ID));
		fp1.setDirection(FlowDirection.OUT);
		fp2 = (FlowPort)p2.applyStereotype(p2.getApplicableStereotype(SysmlResource.FLOW_PORT_ID));
		fp2.setDirection(FlowDirection.IN);
		fp2.setIsConjugated(true);

		// Add FlowSpecification
		fsp2 = (FlowSpecification)i2.applyStereotype(i2.getApplicableStereotype(SysmlResource.FLOW_SPECIFICATION_ID));
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
	 * Tests the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon()
	 * <em>Get Icon</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon()
	 * @generated NOT
	 */
	public void testGetIcon() {

		// Retrieve Stereotype
		Port p = fp0.getBase_Port();
		Stereotype s = p.getAppliedStereotype(SysmlResource.FLOW_PORT_ID);

		// A = Atomic - NA = Not Atomic - NC = Not conjugated - C = Conjugated
		// Image i0 = s.getIcons().get(0); // A_IN
		Image i1 = s.getIcons().get(1); // A_OUT
		Image i2 = s.getIcons().get(2); // A_INOUT
		Image i3 = s.getIcons().get(3); // NA_C_IN
		// Image i4 = s.getIcons().get(4); // NA_C_OUT
		// Image i5 = s.getIcons().get(5); // NA_C_INOUT
		// Image i6 = s.getIcons().get(6); // NA_NC_IN
		// Image i7 = s.getIcons().get(7); // NA_NC_OUT
		// Image i8 = s.getIcons().get(8); // NA_NC_INOUT

		if(!fp0.getIcon().equals(i2)) {
			fail();
		}

		if(!fp1.getIcon().equals(i1)) {
			fail();
		}

		if(!fp2.getIcon().equals(i3)) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isIsAtomic()
	 * <em>Is Atomic</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#isIsAtomic()
	 * @generated NOT
	 */
	public void testIsIsAtomic() {

		// FlowPort without type is Atomic
		if(!fp0.isIsAtomic()) {
			fail();
		}

		// FlowPort type is not a FlowSpecification
		if(!fp1.isIsAtomic()) {
			fail();
		}

		// FlowPort type is a FlowSpecification
		if(fp2.isIsAtomic()) {
			fail();
		}
	}

} // FlowPortTest
