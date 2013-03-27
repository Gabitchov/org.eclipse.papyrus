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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc --> A model of problems, intended
 * primarily as a persistence vehicle for Ecore Diagnostics in contexts where
 * Eclipse resource problem markers (IProblemMarker) are either not available or
 * not appropriate. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory
 * @model kind="package"
 * @generated
 */
public interface ProblemsPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "problems"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/cdo/problems/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "problems"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ProblemsPackage eINSTANCE = org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl <em>EProblem</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEProblem()
	 * @generated
	 */
	int EPROBLEM = 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__SEVERITY = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__CODE = 3;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Related</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__RELATED = 5;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__TYPE = 7;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEM__ATTRIBUTES = 8;

	/**
	 * The number of structural features of the '<em>EProblem</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>To Diagnostic</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM___TO_DIAGNOSTIC = 0;

	/**
	 * The number of operations of the '<em>EProblem</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEM_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl <em>EProblems Container</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEProblemsContainer()
	 * @generated
	 */
	int EPROBLEMS_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER__PROBLEMS = 0;

	/**
	 * The feature id for the '<em><b>Subjects</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER__SUBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Subcontainers</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER__SUBCONTAINERS = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER__CONTAINER = 3;

	/**
	 * The number of structural features of the '<em>EProblems Container</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>All Problems</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER___ALL_PROBLEMS = 0;

	/**
	 * The operation id for the '<em>All Problems</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER___ALL_PROBLEMS__EOBJECT = 1;

	/**
	 * The operation id for the '<em>All Diagnostics</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS = 2;

	/**
	 * The operation id for the '<em>All Diagnostics</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS__EOBJECT = 3;

	/**
	 * The operation id for the '<em>Get Worst Problem</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER___GET_WORST_PROBLEM__EOBJECT = 4;

	/**
	 * The number of operations of the '<em>EProblems Container</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROBLEMS_CONTAINER_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.cdo.validation.problems.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.AttributeImpl
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.cdo.validation.problems.ESeverity <em>ESeverity</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.cdo.validation.problems.ESeverity
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getESeverity()
	 * @generated
	 */
	int ESEVERITY = 3;

	/**
	 * The meta object id for the '<em>EDiagnostic</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEDiagnostic()
	 * @generated
	 */
	int EDIAGNOSTIC = 4;

	/**
	 * The meta object id for the '<em>EIterator</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see java.util.Iterator
	 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEIterator()
	 * @generated
	 */
	int EITERATOR = 5;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem <em>EProblem</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProblem</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem
	 * @generated
	 */
	EClass getEProblem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getSeverity()
	 * @see #getEProblem()
	 * @generated
	 */
	EAttribute getEProblem_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getMessage()
	 * @see #getEProblem()
	 * @generated
	 */
	EAttribute getEProblem_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getSource()
	 * @see #getEProblem()
	 * @generated
	 */
	EAttribute getEProblem_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getCode()
	 * @see #getEProblem()
	 * @generated
	 */
	EAttribute getEProblem_Code();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getElement()
	 * @see #getEProblem()
	 * @generated
	 */
	EReference getEProblem_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getRelated <em>Related</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getRelated()
	 * @see #getEProblem()
	 * @generated
	 */
	EReference getEProblem_Related();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer()
	 * @see #getEProblem()
	 * @generated
	 */
	EReference getEProblem_Container();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getType()
	 * @see #getEProblem()
	 * @generated
	 */
	EAttribute getEProblem_Type();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Attributes</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#getAttributes()
	 * @see #getEProblem()
	 * @generated
	 */
	EReference getEProblem_Attributes();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#toDiagnostic() <em>To Diagnostic</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>To Diagnostic</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblem#toDiagnostic()
	 * @generated
	 */
	EOperation getEProblem__ToDiagnostic();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer
	 * <em>EProblems Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>EProblems Container</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer
	 * @generated
	 */
	EClass getEProblemsContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Problems</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getProblems()
	 * @see #getEProblemsContainer()
	 * @generated
	 */
	EReference getEProblemsContainer_Problems();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subjects</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubjects()
	 * @see #getEProblemsContainer()
	 * @generated
	 */
	EReference getEProblemsContainer_Subjects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubcontainers <em>Subcontainers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcontainers</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getSubcontainers()
	 * @see #getEProblemsContainer()
	 * @generated
	 */
	EReference getEProblemsContainer_Subcontainers();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getContainer()
	 * @see #getEProblemsContainer()
	 * @generated
	 */
	EReference getEProblemsContainer_Container();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems() <em>All Problems</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>All Problems</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems()
	 * @generated
	 */
	EOperation getEProblemsContainer__AllProblems();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems(org.eclipse.emf.ecore.EObject) <em>All Problems</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>All Problems</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allProblems(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getEProblemsContainer__AllProblems__EObject();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics() <em>All Diagnostics</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>All Diagnostics</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics()
	 * @generated
	 */
	EOperation getEProblemsContainer__AllDiagnostics();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics(org.eclipse.emf.ecore.EObject) <em>All Diagnostics</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>All Diagnostics</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#allDiagnostics(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getEProblemsContainer__AllDiagnostics__EObject();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getWorstProblem(org.eclipse.emf.ecore.EObject) <em>Get Worst Problem</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the '<em>Get Worst Problem</em>' operation.
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getWorstProblem(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getEProblemsContainer__GetWorstProblem__EObject();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.cdo.validation.problems.ESeverity <em>ESeverity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESeverity</em>'.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ESeverity
	 * @generated
	 */
	EEnum getESeverity();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.Diagnostic <em>EDiagnostic</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EDiagnostic</em>'.
	 * @see org.eclipse.emf.common.util.Diagnostic
	 * @model instanceClass="org.eclipse.emf.common.util.Diagnostic" serializeable="false"
	 * @generated
	 */
	EDataType getEDiagnostic();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>EIterator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EIterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator" serializeable="false" typeParameters="E"
	 * @generated
	 */
	EDataType getEIterator();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProblemsFactory getProblemsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl
		 * <em>EProblem</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEProblem()
		 * @generated
		 */
		EClass EPROBLEM = eINSTANCE.getEProblem();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROBLEM__SEVERITY = eINSTANCE.getEProblem_Severity();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROBLEM__MESSAGE = eINSTANCE.getEProblem_Message();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROBLEM__SOURCE = eINSTANCE.getEProblem_Source();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROBLEM__CODE = eINSTANCE.getEProblem_Code();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEM__ELEMENT = eINSTANCE.getEProblem_Element();

		/**
		 * The meta object literal for the '<em><b>Related</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEM__RELATED = eINSTANCE.getEProblem_Related();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEM__CONTAINER = eINSTANCE.getEProblem_Container();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROBLEM__TYPE = eINSTANCE.getEProblem_Type();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEM__ATTRIBUTES = eINSTANCE.getEProblem_Attributes();

		/**
		 * The meta object literal for the '<em><b>To Diagnostic</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEM___TO_DIAGNOSTIC = eINSTANCE.getEProblem__ToDiagnostic();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl <em>EProblems Container</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEProblemsContainer()
		 * @generated
		 */
		EClass EPROBLEMS_CONTAINER = eINSTANCE.getEProblemsContainer();

		/**
		 * The meta object literal for the '<em><b>Problems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEMS_CONTAINER__PROBLEMS = eINSTANCE.getEProblemsContainer_Problems();

		/**
		 * The meta object literal for the '<em><b>Subjects</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEMS_CONTAINER__SUBJECTS = eINSTANCE.getEProblemsContainer_Subjects();

		/**
		 * The meta object literal for the '<em><b>Subcontainers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEMS_CONTAINER__SUBCONTAINERS = eINSTANCE.getEProblemsContainer_Subcontainers();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROBLEMS_CONTAINER__CONTAINER = eINSTANCE.getEProblemsContainer_Container();

		/**
		 * The meta object literal for the '<em><b>All Problems</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEMS_CONTAINER___ALL_PROBLEMS = eINSTANCE.getEProblemsContainer__AllProblems();

		/**
		 * The meta object literal for the '<em><b>All Problems</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEMS_CONTAINER___ALL_PROBLEMS__EOBJECT = eINSTANCE.getEProblemsContainer__AllProblems__EObject();

		/**
		 * The meta object literal for the '<em><b>All Diagnostics</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS = eINSTANCE.getEProblemsContainer__AllDiagnostics();

		/**
		 * The meta object literal for the '<em><b>All Diagnostics</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS__EOBJECT = eINSTANCE.getEProblemsContainer__AllDiagnostics__EObject();

		/**
		 * The meta object literal for the '<em><b>Get Worst Problem</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EPROBLEMS_CONTAINER___GET_WORST_PROBLEM__EOBJECT = eINSTANCE.getEProblemsContainer__GetWorstProblem__EObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.cdo.validation.problems.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.AttributeImpl
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__KEY = eINSTANCE.getAttribute_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.cdo.validation.problems.ESeverity
		 * <em>ESeverity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.cdo.validation.problems.ESeverity
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getESeverity()
		 * @generated
		 */
		EEnum ESEVERITY = eINSTANCE.getESeverity();

		/**
		 * The meta object literal for the '<em>EDiagnostic</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.Diagnostic
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEDiagnostic()
		 * @generated
		 */
		EDataType EDIAGNOSTIC = eINSTANCE.getEDiagnostic();

		/**
		 * The meta object literal for the '<em>EIterator</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.util.Iterator
		 * @see org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsPackageImpl#getEIterator()
		 * @generated
		 */
		EDataType EITERATOR = eINSTANCE.getEIterator();

	}

} // ProblemsPackage
