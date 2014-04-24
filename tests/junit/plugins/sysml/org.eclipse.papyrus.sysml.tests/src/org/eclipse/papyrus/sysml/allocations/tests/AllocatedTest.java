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
package org.eclipse.papyrus.sysml.allocations.tests;

import static org.junit.Assert.fail;

import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.allocations.Allocated;
import org.eclipse.papyrus.sysml.allocations.AllocationsFactory;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Allocated</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedFrom() <em>Allocated From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedTo() <em>Allocated To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocatedTest extends AbstractPapyrusTest {

	protected Allocated fixture = null;

	protected Class c0 = null;

	protected Class c1 = null;

	protected Class c2 = null;

	protected Class c3 = null;

	protected Class c4 = null;

	protected Allocated ac0 = null;

	protected Allocated ac1 = null;

	protected Allocated ac2 = null;

	protected Allocated ac3 = null;

	protected Allocated ac4 = null;

	protected Model model = null;

	/**
	 * Returns the fixture for this Allocated test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected Allocated getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Allocated test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(Allocated fixture) {
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
		setFixture(AllocationsFactory.eINSTANCE.createAllocated());

		// Prepare test
		model = SysMLTestResources.createSysMLModel();
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create classes
		c0 = model.createOwnedClass("C0", false);
		c1 = model.createOwnedClass("C1", false);
		c2 = model.createOwnedClass("C2", false);
		c3 = model.createOwnedClass("C3", false);
		c4 = model.createOwnedClass("C4", false);

		// Add Allocated stereotype

		ac0 = (Allocated)StereotypeApplicationHelper.INSTANCE.applyStereotype(c0, AllocationsPackage.eINSTANCE.getAllocated());
		ac1 = (Allocated)StereotypeApplicationHelper.INSTANCE.applyStereotype(c1, AllocationsPackage.eINSTANCE.getAllocated());
		ac2 = (Allocated)StereotypeApplicationHelper.INSTANCE.applyStereotype(c2, AllocationsPackage.eINSTANCE.getAllocated());
		ac3 = (Allocated)StereotypeApplicationHelper.INSTANCE.applyStereotype(c3, AllocationsPackage.eINSTANCE.getAllocated());
		ac4 = (Allocated)StereotypeApplicationHelper.INSTANCE.applyStereotype(c4, AllocationsPackage.eINSTANCE.getAllocated());

		// Add Abstractions with allocate stereotype
		// c1 -> c2, c3
		// c4 -> c3
		Abstraction c1_c2 = UMLFactory.eINSTANCE.createAbstraction();
		c1_c2.getClients().add(c1);
		c1_c2.getSuppliers().add(c2);
		model.getPackagedElements().add(c1_c2);

		StereotypeApplicationHelper.INSTANCE.applyStereotype(c1_c2, AllocationsPackage.eINSTANCE.getAllocate());

		Abstraction c1_c3 = UMLFactory.eINSTANCE.createAbstraction();
		model.getPackagedElements().add(c1_c3);
		c1_c3.getClients().add(c1);
		c1_c3.getSuppliers().add(c3);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(c1_c3, AllocationsPackage.eINSTANCE.getAllocate());

		Abstraction c4_c3 = UMLFactory.eINSTANCE.createAbstraction();
		model.getPackagedElements().add(c4_c3);
		c4_c3.getClients().add(c4);
		c4_c3.getSuppliers().add(c3);
		StereotypeApplicationHelper.INSTANCE.applyStereotype(c4_c3, AllocationsPackage.eINSTANCE.getAllocate());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedFrom()
	 * <em>Allocated From</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedFrom()
	 * @generated NOT
	 */
	@Test
	public void testGetAllocatedFrom() {

		// Verifies : ac0.getAllocatedFrom = []
		if(!ac0.getAllocatedFrom().isEmpty()) {
			fail();
		}

		// Verifies : ac2.getAllocatedFrom = [c1]
		if(!ac2.getAllocatedFrom().contains(c1)) {
			fail();
		}

		// Verifies : ac3.getAllocatedFrom = [c1, c4]
		if(!(ac3.getAllocatedFrom().contains(c1) && ac3.getAllocatedFrom().contains(c4))) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedTo()
	 * <em>Allocated To</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedTo()
	 * @generated NOT
	 */
	@Test
	public void testGetAllocatedTo() {

		// Verifies : ac0.getAllocatedTo = []
		if(!ac0.getAllocatedTo().isEmpty()) {
			fail();
		}

		// Verifies : ac0.getAllocatedTo = [c2, c3]
		if(!(ac1.getAllocatedTo().contains(c2) && ac1.getAllocatedTo().contains(c3))) {
			fail();
		}

		// Verifies : ac4.getAllocatedTo = [c3]
		if(!ac4.getAllocatedTo().contains(c3)) {
			fail();
		}
	}

} // AllocatedTest
