/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.cdo.validation.problems.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>EProblem</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#toDiagnostic()
 * <em>To Diagnostic</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EProblemTest
		extends TestCase {

	protected static ESeverity SEVERITY = ESeverity.ERROR;

	protected static String SOURCE = "org.eclipse.papyrus.cdo.validation.problems.tests";

	protected static String MESSAGE = "This is a test.";

	protected static int CODE = 42;

	protected static EObject ELEMENT = ProblemsPackage.eINSTANCE;

	protected static EObject RELATED1 = ProblemsPackage.Literals.EPROBLEM;

	protected static EObject RELATED2 = ProblemsPackage.Literals.EDIAGNOSTIC;

	/**
	 * The fixture for this EProblem test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected EProblem fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EProblemTest.class);
	}

	/**
	 * Constructs a new EProblem test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EProblemTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EProblem test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(EProblem fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EProblem test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EProblem getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp()
			throws Exception {
		setFixture(ProblemsFactory.eINSTANCE.createEProblem());

		getFixture().setSeverity(SEVERITY);
		getFixture().setSource(SOURCE);
		getFixture().setCode(CODE);
		getFixture().setMessage(MESSAGE);
		getFixture().setElement(ELEMENT);
		getFixture().getRelated().addAll(Arrays.asList(RELATED1, RELATED2));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown()
			throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#toDiagnostic()
	 * <em>To Diagnostic</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#toDiagnostic()
	 * @generated NOT
	 */
	public void testToDiagnostic() {
		Diagnostic diag = getFixture().toDiagnostic();

		assertDiagnostic(diag, MESSAGE, new Object[]{ELEMENT, RELATED1,
			RELATED2});
	}

	static void assertDiagnostic(Diagnostic diag, String message,
			Object... data) {
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
		assertEquals(SOURCE, diag.getSource());
		assertEquals(CODE, diag.getCode());
		assertEquals(message, diag.getMessage());
		assertNotNull(diag.getData());
		assertArrayEquals(data, diag.getData().toArray());
		assertNull(diag.getException());
		assertTrue(diag.getChildren().isEmpty());
	}
} // EProblemTest
