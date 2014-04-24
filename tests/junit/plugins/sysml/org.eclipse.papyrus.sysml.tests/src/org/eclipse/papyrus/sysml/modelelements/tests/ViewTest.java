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

import static org.junit.Assert.fail;

import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.View;
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
public class ViewTest extends AbstractPapyrusTest {

	protected View fixture = null;

	protected Package p0 = null;

	protected Package p1 = null;

	protected Class c1 = null;

	protected ViewPoint vp1 = null;

	protected View v0 = null;

	protected View v1 = null;

	protected Model model = null;

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
	@Before
	public void setUp() throws Exception {
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

		v0 = (View)StereotypeApplicationHelper.INSTANCE.applyStereotype(p0, ModelelementsPackage.eINSTANCE.getView());
		v1 = (View)StereotypeApplicationHelper.INSTANCE.applyStereotype(p1, ModelelementsPackage.eINSTANCE.getView());

		// Add ViewPoint stereotype
		vp1 = (ViewPoint)StereotypeApplicationHelper.INSTANCE.applyStereotype(c1, ModelelementsPackage.eINSTANCE.getViewPoint());

		// Add Abstractions with allocate stereotype
		// v1 (p1) -> vp1 (c1)
		Abstraction v1_vp1 = UMLFactory.eINSTANCE.createAbstraction();
		v1_vp1.getClients().add(p1);
		v1_vp1.getSuppliers().add(c1);
		model.getPackagedElements().add(v1_vp1);

		StereotypeApplicationHelper.INSTANCE.applyStereotype(v1_vp1, ModelelementsPackage.eINSTANCE.getConform());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 * <em>View Point</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 * @generated NOT
	 */
	@Test
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
