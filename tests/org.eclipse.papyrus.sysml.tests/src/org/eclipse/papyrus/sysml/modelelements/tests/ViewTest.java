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
package org.eclipse.papyrus.sysml.modelelements.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml.modelelements.Conform;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml.modelelements.View;
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>View</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.View#getViewPoint() <em>View Point</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ViewTest extends TestCase {

	/**
	 * The fixture for this View test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static String CONFORM_ID = "SysML::ModelElements::Conform";

	public static String VIEW_ID = "SysML::ModelElements::View";

	public static String VIEWPOINT_ID = "SysML::ModelElements::ViewPoint";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ViewTest.class);
	}

	protected View fixture = null;

	protected Package p0 = null;

	protected Package p1 = null;

	protected Class c1 = null;

	protected ViewPoint vp1 = null;

	protected View v0 = null;

	protected View v1 = null;

	protected Model model = null;

	/**
	 * Constructs a new View test case with the given name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this View test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected View getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this View test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(View fixture) {
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
		setFixture(ModelelementsFactory.eINSTANCE.createView());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create packages
		p0 = model.createNestedPackage("p0");
		p1 = model.createNestedPackage("p1");

		// Create classes
		c1 = model.createOwnedClass("c1", false);

		// Add View stereotype
		v0 = (View)p0.applyStereotype(p0.getApplicableStereotype(VIEW_ID));
		v1 = (View)p1.applyStereotype(p1.getApplicableStereotype(VIEW_ID));

		// Add ViewPoint stereotype
		vp1 = (ViewPoint)c1.applyStereotype(c1.getApplicableStereotype(VIEWPOINT_ID));

		// Add Abstractions with allocate stereotype
		// v1 (p1) -> vp1 (c1)
		Abstraction v1_vp1 = UMLFactory.eINSTANCE.createAbstraction();
		v1_vp1.getClients().add(p1);
		v1_vp1.getSuppliers().add(c1);
		model.getPackagedElements().add(v1_vp1);
		@SuppressWarnings("unused")
		Conform c_v1_vp1 = (Conform)v1_vp1.applyStereotype(v1_vp1.getApplicableStereotype(CONFORM_ID));

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
	 * Tests the '{@link org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 * <em>View Point</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 * @generated NOT
	 */
	public void testGetViewPoint() {

		// Verifies : v0.getViewPoint = []
		if(v0.getViewPoint() != null) {
			fail();
		}

		// Verifies : v1.getViewPoint = vp1
		if(!v1.getViewPoint().equals(vp1)) {
			fail();
		}
	}

} // ViewTest
