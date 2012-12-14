/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableconfigurationPackage;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationFactory;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustableconfigurationPackageImpl extends EPackageImpl implements PapyrustableconfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTableConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fillModeEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrustableconfigurationPackageImpl() {
		super(eNS_URI, PapyrustableconfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrustableconfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrustableconfigurationPackage init() {
		if (isInited) return (PapyrustableconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(PapyrustableconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		PapyrustableconfigurationPackageImpl thePapyrustableconfigurationPackage = (PapyrustableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrustableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrustableconfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TablePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrustableconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		thePapyrustableconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrustableconfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrustableconfigurationPackage.eNS_URI, thePapyrustableconfigurationPackage);
		return thePapyrustableconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTableConfiguration() {
		return papyrusTableConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableConfiguration_FillMode() {
		return (EAttribute)papyrusTableConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_FillingQueries() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_ListenContextFeature() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_TableConfiguration() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableConfiguration_PastedElementId() {
		return (EAttribute)papyrusTableConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_PastedElementContainementFeature() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFillMode() {
		return fillModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableconfigurationFactory getPapyrustableconfigurationFactory() {
		return (PapyrustableconfigurationFactory)getEFactoryInstance();
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
		papyrusTableConfigurationEClass = createEClass(PAPYRUS_TABLE_CONFIGURATION);
		createEAttribute(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__FILL_MODE);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION);
		createEAttribute(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINEMENT_FEATURE);

		// Create enums
		fillModeEEnum = createEEnum(FILL_MODE);
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
		ExtensiblePackage theExtensiblePackage = (ExtensiblePackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI);
		TableconfigurationPackage theTableconfigurationPackage = (TableconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(TableconfigurationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusTableConfigurationEClass.getESuperTypes().add(ecorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusTableConfigurationEClass, PapyrusTableConfiguration.class, "PapyrusTableConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPapyrusTableConfiguration_FillMode(), this.getFillMode(), "fillMode", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTableConfiguration_FillingQueries(), theExtensiblePackage.getQuery(), null, "fillingQueries", null, 0, -1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTableConfiguration_ListenContextFeature(), ecorePackage.getEReference(), null, "listenContextFeature", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTableConfiguration_TableConfiguration(), theTableconfigurationPackage.getTableConfiguration(), null, "tableConfiguration", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTableConfiguration_PastedElementId(), theEcorePackage.getEString(), "pastedElementId", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTableConfiguration_PastedElementContainementFeature(), theEcorePackage.getEReference(), null, "pastedElementContainementFeature", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(fillModeEEnum, FillMode.class, "FillMode"); //$NON-NLS-1$
		addEEnumLiteral(fillModeEEnum, FillMode.USER);
		addEEnumLiteral(fillModeEEnum, FillMode.QUERIES);
		addEEnumLiteral(fillModeEEnum, FillMode.CONTEXT_FEATURE);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrustableconfigurationPackageImpl
