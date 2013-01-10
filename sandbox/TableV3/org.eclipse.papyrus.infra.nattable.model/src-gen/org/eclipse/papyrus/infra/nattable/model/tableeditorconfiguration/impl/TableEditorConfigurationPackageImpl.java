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
package org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.LocalTableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TableEditorConfigurationPackageImpl extends EPackageImpl implements TableEditorConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEditorConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localTableEditorConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TableEditorConfigurationPackageImpl() {
		super(eNS_URI, TableEditorConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TableEditorConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TableEditorConfigurationPackage init() {
		if (isInited) return (TableEditorConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(TableEditorConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		TableEditorConfigurationPackageImpl theTableEditorConfigurationPackage = (TableEditorConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TableEditorConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TableEditorConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTableEditorConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theTableEditorConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTableEditorConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TableEditorConfigurationPackage.eNS_URI, theTableEditorConfigurationPackage);
		return theTableEditorConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableEditorConfiguration() {
		return tableEditorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableEditorConfiguration_Type() {
		return (EAttribute)tableEditorConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableEditorConfiguration_PastedElementTypeId() {
		return (EAttribute)tableEditorConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableEditorConfiguration_PastedElementContainmentFeature() {
		return (EReference)tableEditorConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalTableEditorConfiguration() {
		return localTableEditorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalTableEditorConfiguration_DefaultTableEditorConfiguration() {
		return (EReference)localTableEditorConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableEditorConfigurationFactory getTableEditorConfigurationFactory() {
		return (TableEditorConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tableEditorConfigurationEClass = createEClass(TABLE_EDITOR_CONFIGURATION);
		createEAttribute(tableEditorConfigurationEClass, TABLE_EDITOR_CONFIGURATION__TYPE);
		createEAttribute(tableEditorConfigurationEClass, TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID);
		createEReference(tableEditorConfigurationEClass, TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE);

		localTableEditorConfigurationEClass = createEClass(LOCAL_TABLE_EDITOR_CONFIGURATION);
		createEReference(localTableEditorConfigurationEClass, LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tableEditorConfigurationEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		localTableEditorConfigurationEClass.getESuperTypes().add(this.getTableEditorConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(tableEditorConfigurationEClass, TableEditorConfiguration.class, "TableEditorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTableEditorConfiguration_Type(), ecorePackage.getEString(), "type", null, 0, 1, TableEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTableEditorConfiguration_PastedElementTypeId(), theEcorePackage.getEString(), "pastedElementTypeId", null, 0, 1, TableEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableEditorConfiguration_PastedElementContainmentFeature(), theEcorePackage.getEReference(), null, "pastedElementContainmentFeature", null, 0, 1, TableEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(localTableEditorConfigurationEClass, LocalTableEditorConfiguration.class, "LocalTableEditorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLocalTableEditorConfiguration_DefaultTableEditorConfiguration(), this.getTableEditorConfiguration(), null, "defaultTableEditorConfiguration", null, 0, 1, LocalTableEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //TableEditorConfigurationPackageImpl
