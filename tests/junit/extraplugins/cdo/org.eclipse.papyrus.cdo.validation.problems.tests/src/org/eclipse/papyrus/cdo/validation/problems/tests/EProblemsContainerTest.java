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
import java.util.Iterator;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>EProblems Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems() <em>All Problems</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems(org.eclipse.emf.ecore.EObject) <em>All Problems</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics() <em>All Diagnostics</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics(org.eclipse.emf.ecore.EObject) <em>All Diagnostics</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getWorstProblem(org.eclipse.emf.ecore.EObject) <em>Get Worst Problem</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EProblemsContainerTest extends TestCase {

	/**
	 * The fixture for this EProblems Container test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EProblemsContainer fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EProblemsContainerTest.class);
	}

	/**
	 * Constructs a new EProblems Container test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EProblemsContainerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EProblems Container test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(EProblemsContainer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EProblems Container test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EProblemsContainer getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		EProblemsContainer root = ProblemsFactory.eINSTANCE.createEProblemsContainer();
		root.getProblems().add(createProblem(EProblemTest.ELEMENT, "root"));

		EProblemsContainer level1 = ProblemsFactory.eINSTANCE.createEProblemsContainer();
		root.getSubcontainers().add(level1);
		level1.getProblems().add(createProblem(EProblemTest.RELATED1, "a"));
		level1.getProblems().add(createProblem(EProblemTest.RELATED2, "b"));

		EProblemsContainer level2 = ProblemsFactory.eINSTANCE.createEProblemsContainer();
		level1.getSubcontainers().add(level2);
		level1.getProblems().add(createProblem(EProblemTest.RELATED2, "c"));
		level1.getProblems().add(createProblem(EProblemTest.RELATED1, "d"));

		setFixture(root);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems()
	 * <em>All Problems</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems()
	 * @generated NOT
	 */
	public void testAllProblems() {
		final Iterator<String> messages = Arrays.asList("root", "a", "b", "c", "d").iterator();
		final Iterator<EObject> elements = Arrays.asList(EProblemTest.ELEMENT, EProblemTest.RELATED1, EProblemTest.RELATED2, EProblemTest.RELATED2, EProblemTest.RELATED1).iterator();

		for(Iterator<EProblem> allProblems = getFixture().allProblems(); allProblems.hasNext();) {
			assertProblem(allProblems.next(), messages.next(), elements.next());
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems(org.eclipse.emf.ecore.EObject)
	 * <em>All Problems</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testAllProblems__EObject() {
		final Iterator<String> messages = Arrays.asList("b", "c").iterator();
		final Iterator<EObject> elements = Arrays.asList(EProblemTest.RELATED2, EProblemTest.RELATED2).iterator();

		for(Iterator<EProblem> allProblems = getFixture().allProblems(EProblemTest.RELATED2); allProblems.hasNext();) {
			assertProblem(allProblems.next(), messages.next(), elements.next());
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics()
	 * <em>All Diagnostics</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics()
	 * @generated NOT
	 */
	public void testAllDiagnostics() {
		final Iterator<String> messages = Arrays.asList("root", "a", "b", "c", "d").iterator();
		final Iterator<EObject> elements = Arrays.asList(EProblemTest.ELEMENT, EProblemTest.RELATED1, EProblemTest.RELATED2, EProblemTest.RELATED2, EProblemTest.RELATED1).iterator();

		for(Diagnostic diag : getFixture().allDiagnostics()) {
			EProblemTest.assertDiagnostic(diag, messages.next(), elements.next());
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics(org.eclipse.emf.ecore.EObject)
	 * <em>All Diagnostics</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testAllDiagnostics__EObject() {
		final Iterator<String> messages = Arrays.asList("a", "d").iterator();
		final Iterator<EObject> elements = Arrays.asList(EProblemTest.RELATED1, EProblemTest.RELATED1).iterator();

		for(Diagnostic diag : getFixture().allDiagnostics(EProblemTest.RELATED1)) {
			EProblemTest.assertDiagnostic(diag, messages.next(), elements.next());
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getWorstProblem(org.eclipse.emf.ecore.EObject)
	 * <em>Get Worst Problem</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getWorstProblem(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testGetWorstProblem__EObject() {
		// change severities in the fixture
		Iterator<ESeverity> severities = Arrays.asList(ESeverity.INFO, ESeverity.WARNING).iterator();
		for(Iterator<EProblem> problems = getFixture().allProblems(EProblemTest.RELATED1); problems.hasNext();) {
			problems.next().setSeverity(severities.next());
		}

		assertSame(ESeverity.WARNING, getFixture().getWorstProblem(EProblemTest.RELATED1).getSeverity());
		assertSame(ESeverity.ERROR, getFixture().getWorstProblem(EProblemTest.ELEMENT).getSeverity());
		assertNull(getFixture().getWorstProblem(EcorePackage.eINSTANCE));
	}

	protected EProblem createProblem(EObject element, String message) {
		EProblem result = ProblemsFactory.eINSTANCE.createEProblem();

		result.setSeverity(EProblemTest.SEVERITY);
		result.setSource(EProblemTest.SOURCE);
		result.setCode(EProblemTest.CODE);
		result.setMessage(message);
		result.setElement(element);

		return result;
	}

	static void assertProblem(EProblem problem, String message, EObject element, EObject... related) {
		assertSame(ESeverity.ERROR, problem.getSeverity());
		assertEquals(EProblemTest.SOURCE, problem.getSource());
		assertEquals(EProblemTest.CODE, problem.getCode());
		assertEquals(message, problem.getMessage());
		assertSame(element, problem.getElement());
		assertArrayEquals(related, problem.getRelated().toArray());
	}
} // EProblemsContainerTest
