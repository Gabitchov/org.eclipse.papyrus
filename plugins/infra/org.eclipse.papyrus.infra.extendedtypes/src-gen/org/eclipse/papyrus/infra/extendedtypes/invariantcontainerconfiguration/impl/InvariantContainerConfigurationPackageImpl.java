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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantContainerConfigurationPackageImpl extends EPackageImpl implements InvariantContainerConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantContainerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hierarchyPermissionEClass = null;

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InvariantContainerConfigurationPackageImpl() {
		super(eNS_URI, InvariantContainerConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InvariantContainerConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InvariantContainerConfigurationPackage init() {
		if (isInited) return (InvariantContainerConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantContainerConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		InvariantContainerConfigurationPackageImpl theInvariantContainerConfigurationPackage = (InvariantContainerConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InvariantContainerConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InvariantContainerConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		InvariantSemanticTypeConfigurationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInvariantContainerConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theInvariantContainerConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInvariantContainerConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InvariantContainerConfigurationPackage.eNS_URI, theInvariantContainerConfigurationPackage);
		return theInvariantContainerConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantContainerConfiguration() {
		return invariantContainerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariantContainerConfiguration_Permissions() {
		return (EReference)invariantContainerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHierarchyPermission() {
		return hierarchyPermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_ChildType() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_IsPermitted() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_IsStrict() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerConfigurationFactory getInvariantContainerConfigurationFactory() {
		return (InvariantContainerConfigurationFactory)getEFactoryInstance();
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
		invariantContainerConfigurationEClass = createEClass(INVARIANT_CONTAINER_CONFIGURATION);
		createEReference(invariantContainerConfigurationEClass, INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS);

		hierarchyPermissionEClass = createEClass(HIERARCHY_PERMISSION);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__CHILD_TYPE);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__IS_PERMITTED);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__IS_STRICT);
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
		InvariantSemanticTypeConfigurationPackage theInvariantSemanticTypeConfigurationPackage = (InvariantSemanticTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantSemanticTypeConfigurationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		invariantContainerConfigurationEClass.getESuperTypes().add(theInvariantSemanticTypeConfigurationPackage.getInvariantRuleConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(invariantContainerConfigurationEClass, InvariantContainerConfiguration.class, "InvariantContainerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariantContainerConfiguration_Permissions(), this.getHierarchyPermission(), null, "permissions", null, 0, -1, InvariantContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hierarchyPermissionEClass, HierarchyPermission.class, "HierarchyPermission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHierarchyPermission_ChildType(), theEcorePackage.getEString(), "childType", null, 0, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHierarchyPermission_IsPermitted(), theEcorePackage.getEBoolean(), "isPermitted", null, 0, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHierarchyPermission_IsStrict(), theEcorePackage.getEBoolean(), "isStrict", null, 0, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InvariantContainerConfigurationPackageImpl
