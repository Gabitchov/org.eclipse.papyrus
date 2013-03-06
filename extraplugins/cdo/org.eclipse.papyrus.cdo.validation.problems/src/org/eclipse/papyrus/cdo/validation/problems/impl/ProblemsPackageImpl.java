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
package org.eclipse.papyrus.cdo.validation.problems.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ProblemsPackageImpl
		extends EPackageImpl
		implements ProblemsPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eProblemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eProblemsContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum eSeverityEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eDiagnosticEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eIteratorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProblemsPackageImpl() {
		super(eNS_URI, ProblemsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link ProblemsPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProblemsPackage init() {
		if (isInited)
			return (ProblemsPackage) EPackage.Registry.INSTANCE
				.getEPackage(ProblemsPackage.eNS_URI);

		// Obtain or create and register package
		ProblemsPackageImpl theProblemsPackage = (ProblemsPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof ProblemsPackageImpl
			? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new ProblemsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theProblemsPackage.createPackageContents();

		// Initialize created meta-data
		theProblemsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProblemsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProblemsPackage.eNS_URI,
			theProblemsPackage);
		return theProblemsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEProblem() {
		return eProblemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEProblem_Severity() {
		return (EAttribute) eProblemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEProblem_Message() {
		return (EAttribute) eProblemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEProblem_Source() {
		return (EAttribute) eProblemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEProblem_Code() {
		return (EAttribute) eProblemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblem_Element() {
		return (EReference) eProblemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblem_Related() {
		return (EReference) eProblemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblem_Container() {
		return (EReference) eProblemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblem__ToDiagnostic() {
		return eProblemEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEProblemsContainer() {
		return eProblemsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblemsContainer_Problems() {
		return (EReference) eProblemsContainerEClass.getEStructuralFeatures()
			.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblemsContainer_Subjects() {
		return (EReference) eProblemsContainerEClass.getEStructuralFeatures()
			.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblemsContainer_Subcontainers() {
		return (EReference) eProblemsContainerEClass.getEStructuralFeatures()
			.get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEProblemsContainer_Container() {
		return (EReference) eProblemsContainerEClass.getEStructuralFeatures()
			.get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblemsContainer__AllProblems() {
		return eProblemsContainerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblemsContainer__AllProblems__EObject() {
		return eProblemsContainerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblemsContainer__AllDiagnostics() {
		return eProblemsContainerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblemsContainer__AllDiagnostics__EObject() {
		return eProblemsContainerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEProblemsContainer__GetWorstProblem__EObject() {
		return eProblemsContainerEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getESeverity() {
		return eSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getEDiagnostic() {
		return eDiagnosticEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getEIterator() {
		return eIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProblemsFactory getProblemsFactory() {
		return (ProblemsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		eProblemEClass = createEClass(EPROBLEM);
		createEAttribute(eProblemEClass, EPROBLEM__SEVERITY);
		createEAttribute(eProblemEClass, EPROBLEM__MESSAGE);
		createEAttribute(eProblemEClass, EPROBLEM__SOURCE);
		createEAttribute(eProblemEClass, EPROBLEM__CODE);
		createEReference(eProblemEClass, EPROBLEM__ELEMENT);
		createEReference(eProblemEClass, EPROBLEM__RELATED);
		createEReference(eProblemEClass, EPROBLEM__CONTAINER);
		createEOperation(eProblemEClass, EPROBLEM___TO_DIAGNOSTIC);

		eProblemsContainerEClass = createEClass(EPROBLEMS_CONTAINER);
		createEReference(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER__PROBLEMS);
		createEReference(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER__SUBJECTS);
		createEReference(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER__SUBCONTAINERS);
		createEReference(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER__CONTAINER);
		createEOperation(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER___ALL_PROBLEMS);
		createEOperation(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER___ALL_PROBLEMS__EOBJECT);
		createEOperation(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS);
		createEOperation(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS__EOBJECT);
		createEOperation(eProblemsContainerEClass,
			EPROBLEMS_CONTAINER___GET_WORST_PROBLEM__EOBJECT);

		// Create enums
		eSeverityEEnum = createEEnum(ESEVERITY);

		// Create data types
		eDiagnosticEDataType = createEDataType(EDIAGNOSTIC);
		eIteratorEDataType = createEDataType(EITERATOR);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		addETypeParameter(eIteratorEDataType, "E"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(
			eProblemEClass,
			EProblem.class,
			"EProblem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
			getEProblem_Severity(),
			this.getESeverity(),
			"severity", null, 1, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
			getEProblem_Message(),
			ecorePackage.getEString(),
			"message", null, 1, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
			getEProblem_Source(),
			ecorePackage.getEString(),
			"source", null, 1, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
			getEProblem_Code(),
			ecorePackage.getEInt(),
			"code", null, 0, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblem_Element(),
			ecorePackage.getEObject(),
			null,
			"element", null, 1, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblem_Related(),
			ecorePackage.getEObject(),
			null,
			"related", null, 0, -1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblem_Container(),
			this.getEProblemsContainer(),
			this.getEProblemsContainer_Problems(),
			"container", null, 0, 1, EProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getEProblem__ToDiagnostic(), this.getEDiagnostic(),
			"toDiagnostic", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			eProblemsContainerEClass,
			EProblemsContainer.class,
			"EProblemsContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getEProblemsContainer_Problems(),
			this.getEProblem(),
			this.getEProblem_Container(),
			"problems", null, 0, -1, EProblemsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblemsContainer_Subjects(),
			ecorePackage.getEObject(),
			null,
			"subjects", null, 0, -1, EProblemsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblemsContainer_Subcontainers(),
			this.getEProblemsContainer(),
			this.getEProblemsContainer_Container(),
			"subcontainers", null, 0, -1, EProblemsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getEProblemsContainer_Container(),
			this.getEProblemsContainer(),
			this.getEProblemsContainer_Subcontainers(),
			"container", null, 0, 1, EProblemsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getEProblemsContainer__AllProblems(),
			null, "allProblems", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(this.getEIterator());
		EGenericType g2 = createEGenericType(this.getEProblem());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getEProblemsContainer__AllProblems__EObject(),
			null, "allProblems", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(),
			"element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getEIterator());
		g2 = createEGenericType(this.getEProblem());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEOperation(getEProblemsContainer__AllDiagnostics(),
			this.getEDiagnostic(),
			"allDiagnostics", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEProblemsContainer__AllDiagnostics__EObject(),
			this.getEDiagnostic(),
			"allDiagnostics", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(),
			"element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEProblemsContainer__GetWorstProblem__EObject(),
			this.getEProblem(), "getWorstProblem", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(),
			"element", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(eSeverityEEnum, ESeverity.class, "ESeverity"); //$NON-NLS-1$
		addEEnumLiteral(eSeverityEEnum, ESeverity.OK);
		addEEnumLiteral(eSeverityEEnum, ESeverity.INFO);
		addEEnumLiteral(eSeverityEEnum, ESeverity.WARNING);
		addEEnumLiteral(eSeverityEEnum, ESeverity.ERROR);
		addEEnumLiteral(eSeverityEEnum, ESeverity.CANCEL);

		// Initialize data types
		initEDataType(eDiagnosticEDataType, Diagnostic.class,
			"EDiagnostic", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eIteratorEDataType, Iterator.class,
			"EIterator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} // ProblemsPackageImpl
