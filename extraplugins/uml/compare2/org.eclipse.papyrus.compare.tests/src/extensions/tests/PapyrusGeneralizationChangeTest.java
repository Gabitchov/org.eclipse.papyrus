/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package extensions.tests;

import extensions.ExtensionsFactory;
import extensions.PapyrusGeneralizationChange;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Papyrus Generalization Change</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusGeneralizationChangeTest extends PapyrusDiffTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PapyrusGeneralizationChangeTest.class);
	}

	/**
	 * Constructs a new Papyrus Generalization Change test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusGeneralizationChangeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Papyrus Generalization Change test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PapyrusGeneralizationChange getFixture() {
		return (PapyrusGeneralizationChange)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExtensionsFactory.eINSTANCE.createPapyrusGeneralizationChange());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PapyrusGeneralizationChangeTest
