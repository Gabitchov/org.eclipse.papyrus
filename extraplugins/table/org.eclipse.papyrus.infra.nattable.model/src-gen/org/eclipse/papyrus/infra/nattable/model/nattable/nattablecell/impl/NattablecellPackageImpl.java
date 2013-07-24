/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.NattableaxisPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.EObjectAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.impl.NattabletesterPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class NattablecellPackageImpl extends EPackageImpl implements NattablecellPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iCellAxisWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eObjectAxisWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass idAxisWrapperEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattablecellPackageImpl() {
		super(eNS_URI, NattablecellFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link NattablecellPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattablecellPackage init() {
		if(isInited)
			return (NattablecellPackage)EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI);

		// Obtain or create and register package
		NattablecellPackageImpl theNattablecellPackage = (NattablecellPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattablecellPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattablecellPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) : NattableconfigurationPackage.eINSTANCE);
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) instanceof NattableaxisproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) : NattableaxisproviderPackage.eINSTANCE);
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) instanceof NattablelabelproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) : NattablelabelproviderPackage.eINSTANCE);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) instanceof NattableaxisconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) : NattableaxisconfigurationPackage.eINSTANCE);
		NattabletesterPackageImpl theNattabletesterPackage = (NattabletesterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) instanceof NattabletesterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) : NattabletesterPackage.eINSTANCE);
		NattableaxisPackageImpl theNattableaxisPackage = (NattableaxisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI) instanceof NattableaxisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI) : NattableaxisPackage.eINSTANCE);
		NattableproblemPackageImpl theNattableproblemPackage = (NattableproblemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) instanceof NattableproblemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) : NattableproblemPackage.eINSTANCE);

		// Create package meta-data objects
		theNattablecellPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();
		theNattableaxisproviderPackage.createPackageContents();
		theNattablelabelproviderPackage.createPackageContents();
		theNattableaxisconfigurationPackage.createPackageContents();
		theNattabletesterPackage.createPackageContents();
		theNattableaxisPackage.createPackageContents();
		theNattableproblemPackage.createPackageContents();

		// Initialize created meta-data
		theNattablecellPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();
		theNattableaxisproviderPackage.initializePackageContents();
		theNattablelabelproviderPackage.initializePackageContents();
		theNattableaxisconfigurationPackage.initializePackageContents();
		theNattabletesterPackage.initializePackageContents();
		theNattableaxisPackage.initializePackageContents();
		theNattableproblemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNattablecellPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattablecellPackage.eNS_URI, theNattablecellPackage);
		return theNattablecellPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCell() {
		return cellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCell_ColumnWrapper() {
		return (EReference)cellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCell_RowWrapper() {
		return (EReference)cellEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCell_Problems() {
		return (EReference)cellEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getICellAxisWrapper() {
		return iCellAxisWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getICellAxisWrapper__GetElement() {
		return iCellAxisWrapperEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEObjectAxisWrapper() {
		return eObjectAxisWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEObjectAxisWrapper_Element() {
		return (EReference)eObjectAxisWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIdAxisWrapper() {
		return idAxisWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIdAxisWrapper_Element() {
		return (EAttribute)idAxisWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NattablecellFactory getNattablecellFactory() {
		return (NattablecellFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		cellEClass = createEClass(CELL);
		createEReference(cellEClass, CELL__COLUMN_WRAPPER);
		createEReference(cellEClass, CELL__ROW_WRAPPER);
		createEReference(cellEClass, CELL__PROBLEMS);

		iCellAxisWrapperEClass = createEClass(ICELL_AXIS_WRAPPER);
		createEOperation(iCellAxisWrapperEClass, ICELL_AXIS_WRAPPER___GET_ELEMENT);

		eObjectAxisWrapperEClass = createEClass(EOBJECT_AXIS_WRAPPER);
		createEReference(eObjectAxisWrapperEClass, EOBJECT_AXIS_WRAPPER__ELEMENT);

		idAxisWrapperEClass = createEClass(ID_AXIS_WRAPPER);
		createEAttribute(idAxisWrapperEClass, ID_AXIS_WRAPPER__ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NattableproblemPackage theNattableproblemPackage = (NattableproblemPackage)EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cellEClass.getESuperTypes().add(ecorePackage.getEModelElement());
		iCellAxisWrapperEClass.getESuperTypes().add(ecorePackage.getEModelElement());
		eObjectAxisWrapperEClass.getESuperTypes().add(this.getICellAxisWrapper());
		idAxisWrapperEClass.getESuperTypes().add(this.getICellAxisWrapper());

		// Initialize classes, features, and operations; add parameters
		initEClass(cellEClass, Cell.class, "Cell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCell_ColumnWrapper(), this.getICellAxisWrapper(), null, "columnWrapper", null, 1, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCell_RowWrapper(), this.getICellAxisWrapper(), null, "rowWrapper", null, 1, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCell_Problems(), theNattableproblemPackage.getProblem(), null, "problems", null, 0, -1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iCellAxisWrapperEClass, ICellAxisWrapper.class, "ICellAxisWrapper", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEOperation(getICellAxisWrapper__GetElement(), ecorePackage.getEJavaObject(), "getElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(eObjectAxisWrapperEClass, EObjectAxisWrapper.class, "EObjectAxisWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEObjectAxisWrapper_Element(), ecorePackage.getEObject(), null, "element", null, 1, 1, EObjectAxisWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(idAxisWrapperEClass, IdAxisWrapper.class, "IdAxisWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIdAxisWrapper_Element(), ecorePackage.getEString(), "element", null, 0, 1, IdAxisWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
	}

} //NattablecellPackageImpl
