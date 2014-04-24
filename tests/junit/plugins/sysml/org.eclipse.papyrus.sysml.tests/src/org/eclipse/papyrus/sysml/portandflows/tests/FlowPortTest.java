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

import static org.junit.Assert.fail;

import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.FlowSpecification;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsFactory;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.utils.SysMLTestResources;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Flow Port</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic() <em>Is Atomic</em>}</li>
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
public class FlowPortTest extends AbstractPapyrusTest {

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
	@Before
	public void setUp() throws Exception {
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
		fp0 = (FlowPort)StereotypeApplicationHelper.INSTANCE.applyStereotype(p0, PortandflowsPackage.eINSTANCE.getFlowPort());
		fp1 = (FlowPort)StereotypeApplicationHelper.INSTANCE.applyStereotype(p1, PortandflowsPackage.eINSTANCE.getFlowPort());
		fp1.setDirection(FlowDirection.OUT);
		fp2 = (FlowPort)StereotypeApplicationHelper.INSTANCE.applyStereotype(p2, PortandflowsPackage.eINSTANCE.getFlowPort());
		fp2.setDirection(FlowDirection.IN);
		fp2.setIsConjugated(true);

		// Add FlowSpecification
		fsp2 = (FlowSpecification)StereotypeApplicationHelper.INSTANCE.applyStereotype(i2, PortandflowsPackage.eINSTANCE.getFlowSpecification());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic() <em>Is Atomic</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic()
	 * @generated NOT
	 */
	@Test
	public void testIsAtomic() {
		// FlowPort without type is Atomic
		if(!fp0.isAtomic()) {
			fail();
		}

		// FlowPort type is not a FlowSpecification
		if(!fp1.isAtomic()) {
			fail();
		}

		// FlowPort type is a FlowSpecification
		if(fp2.isAtomic()) {
			fail();
		}
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon()
	 * <em>Get Icon</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon()
	 * @generated NOT
	 */
	@Test
	public void testGetIcon() {

		// Retrieve Stereotype
		Stereotype s = UMLUtil.getStereotype(fp0);

		//Image i0 = s.getIcons().get(1); // IN
		Image i1 = s.getIcons().get(2); // OUT
		Image i2 = s.getIcons().get(3); // INOUT
		Image i3 = s.getIcons().get(4); // NA

		if(!fp0.getIcon().equals(i2)) { // fp0 is INOUT
			fail();
		}

		if(!fp1.getIcon().equals(i1)) { // fp1 is OUT
			fail();
		}

		if(!fp2.getIcon().equals(i3)) { // fp2 is atomic
			fail();
		}
	}

} // FlowPortTest
