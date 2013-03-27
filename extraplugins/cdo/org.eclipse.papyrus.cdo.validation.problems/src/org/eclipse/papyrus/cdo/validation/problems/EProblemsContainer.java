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
package org.eclipse.papyrus.cdo.validation.problems;

import java.util.Iterator;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>EProblems Container</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An optional container for problems, to provide a single node that can be conveniently contained in some larger structure such as an XML resource (which can only have one root element) or other generic container.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubcontainers <em>Subcontainers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblemsContainer()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface EProblemsContainer extends CDOObject {

	/**
	 * Returns the value of the '<em><b>Problems</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.cdo.validation.problems.EProblem}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problems</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problems</em>' containment reference list.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblemsContainer_Problems()
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<EProblem> getProblems();

	/**
	 * Returns the value of the '<em><b>Subjects</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.emf.ecore.EObject}. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Optional reference to elements that are the subjects of some collection
	 * of problems. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Subjects</em>' reference list.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblemsContainer_Subjects()
	 * @model
	 * @generated
	 */
	EList<EObject> getSubjects();

	/**
	 * Returns the value of the '<em><b>Subcontainers</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer}.
	 * It is bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer
	 * <em>Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> Optional nested group of containers, possibly
	 * referencing different subjects than the parent container. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Subcontainers</em>' containment reference
	 *         list.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblemsContainer_Subcontainers()
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<EProblemsContainer> getSubcontainers();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubcontainers <em>Subcontainers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(EProblemsContainer)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblemsContainer_Container()
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubcontainers
	 * @model opposite="subcontainers" transient="false"
	 * @generated
	 */
	EProblemsContainer getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EProblemsContainer value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.cdo.validation.problems.EIterator<org.eclipse.papyrus.cdo.validation.problems.EProblem>" required="true"
	 * @generated
	 */
	Iterator<EProblem> allProblems();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.cdo.validation.problems.EIterator<org.eclipse.papyrus.cdo.validation.problems.EProblem>" required="true" elementRequired="true"
	 * @generated
	 */
	Iterator<EProblem> allProblems(EObject element);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.cdo.validation.problems.EDiagnostic"
	 * @generated
	 */
	EList<Diagnostic> allDiagnostics();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.cdo.validation.problems.EDiagnostic" elementRequired="true"
	 * @generated
	 */
	EList<Diagnostic> allDiagnostics(EObject element);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EProblem getWorstProblem(EObject element);

} // EProblemsContainer
