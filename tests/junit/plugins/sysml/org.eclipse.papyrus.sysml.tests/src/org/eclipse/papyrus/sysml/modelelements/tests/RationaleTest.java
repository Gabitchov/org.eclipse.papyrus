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

import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml.modelelements.Rationale;
import org.junit.After;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Rationale</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class RationaleTest extends AbstractPapyrusTest {

	/**
	 * The fixture for this Rationale test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Rationale fixture = null;

	/**
	 * Returns the fixture for this Rationale test case. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected Rationale getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Rationale test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(Rationale fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@After
	public void setUp() throws Exception {
		setFixture(ModelelementsFactory.eINSTANCE.createRationale());
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

} // RationaleTest
