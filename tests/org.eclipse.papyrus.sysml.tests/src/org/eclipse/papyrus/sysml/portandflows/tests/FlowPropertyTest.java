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
import org.eclipse.papyrus.sysml.portandflows.FlowProperty;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsFactory;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Flow Property</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty#getIcon() <em>Get Icon</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FlowPropertyTest extends TestCase {

	public static String FLOWPROPERTY_ID = "SysML::PortAndFlows::FlowProperty";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FlowPropertyTest.class);
	}

	/**
	 * The fixture for this Flow Property test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected FlowProperty fixture = null;

	protected Interface i = null;

	protected FlowProperty fp0 = null;

	protected FlowProperty fp1 = null;

	protected FlowProperty fp2 = null;

	protected Model model = null;

	/**
	 * Constructs a new Flow Property test case with the given name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public FlowPropertyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Flow Property test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected FlowProperty getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Flow Property test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void setFixture(FlowProperty fixture) {
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
		setFixture(PortandflowsFactory.eINSTANCE.createFlowProperty());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if (model == null) {
			fail();
		}

		if (model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create interface
		i = model.createOwnedInterface("i");

		// Create properties
		Property p0 = i.createOwnedAttribute("p0", null);
		Property p1 = i.createOwnedAttribute("p1", null);
		Property p2 = i.createOwnedAttribute("p2", null);

		// Add FlowPort stereotypes
		fp0 = (FlowProperty) p0.applyStereotype(p0.getApplicableStereotype(FLOWPROPERTY_ID));
		fp0.setDirection(FlowDirection.IN);

		fp1 = (FlowProperty) p1.applyStereotype(p1.getApplicableStereotype(FLOWPROPERTY_ID));
		fp1.setDirection(FlowDirection.OUT);

		fp2 = (FlowProperty) p2.applyStereotype(p2.getApplicableStereotype(FLOWPROPERTY_ID));
		fp2.setDirection(FlowDirection.INOUT);

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
	 * Tests the '{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty#getIcon()
	 * <em>Get Icon</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowProperty#getIcon()
	 * @generated NOT
	 */
	public void testGetIcon() {

		// Retrieve Stereotype
		Property p = fp0.getBase_Property();
		Stereotype s = p.getAppliedStereotype(FLOWPROPERTY_ID);

		Image i0 = s.getIcons().get(0); // IN
		Image i1 = s.getIcons().get(1); // OUT
		Image i2 = s.getIcons().get(2); // INOUT

		if (!fp0.getIcon().equals(i0)) {
			fail();
		}

		if (!fp1.getIcon().equals(i1)) {
			fail();
		}

		if (!fp2.getIcon().equals(i2)) {
			fail();
		}
	}

} // FlowPropertyTest
