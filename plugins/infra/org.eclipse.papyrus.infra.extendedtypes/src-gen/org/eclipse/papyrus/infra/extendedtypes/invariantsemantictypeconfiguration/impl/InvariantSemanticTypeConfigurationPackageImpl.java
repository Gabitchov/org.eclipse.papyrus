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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.AndRule;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.OrRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantSemanticTypeConfigurationPackageImpl extends EPackageImpl implements InvariantSemanticTypeConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantSemanticTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orRuleEClass = null;

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InvariantSemanticTypeConfigurationPackageImpl() {
		super(eNS_URI, InvariantSemanticTypeConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InvariantSemanticTypeConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InvariantSemanticTypeConfigurationPackage init() {
		if (isInited) return (InvariantSemanticTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantSemanticTypeConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		InvariantSemanticTypeConfigurationPackageImpl theInvariantSemanticTypeConfigurationPackage = (InvariantSemanticTypeConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InvariantSemanticTypeConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InvariantSemanticTypeConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInvariantSemanticTypeConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theInvariantSemanticTypeConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInvariantSemanticTypeConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InvariantSemanticTypeConfigurationPackage.eNS_URI, theInvariantSemanticTypeConfigurationPackage);
		return theInvariantSemanticTypeConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantSemanticTypeConfiguration() {
		return invariantSemanticTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration() {
		return (EReference)invariantSemanticTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantRuleConfiguration() {
		return invariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposedRuleConfiguration() {
		return composedRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedRuleConfiguration_ComposedRules() {
		return (EReference)composedRuleConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndRule() {
		return andRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrRule() {
		return orRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantSemanticTypeConfigurationFactory getInvariantSemanticTypeConfigurationFactory() {
		return (InvariantSemanticTypeConfigurationFactory)getEFactoryInstance();
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
		invariantSemanticTypeConfigurationEClass = createEClass(INVARIANT_SEMANTIC_TYPE_CONFIGURATION);
		createEReference(invariantSemanticTypeConfigurationEClass, INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION);

		invariantRuleConfigurationEClass = createEClass(INVARIANT_RULE_CONFIGURATION);

		composedRuleConfigurationEClass = createEClass(COMPOSED_RULE_CONFIGURATION);
		createEReference(composedRuleConfigurationEClass, COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES);

		andRuleEClass = createEClass(AND_RULE);

		orRuleEClass = createEClass(OR_RULE);
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
		ExtendedtypesPackage theExtendedtypesPackage = (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		invariantSemanticTypeConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticTypeConfiguration());
		composedRuleConfigurationEClass.getESuperTypes().add(this.getInvariantRuleConfiguration());
		andRuleEClass.getESuperTypes().add(this.getComposedRuleConfiguration());
		orRuleEClass.getESuperTypes().add(this.getComposedRuleConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(invariantSemanticTypeConfigurationEClass, InvariantSemanticTypeConfiguration.class, "InvariantSemanticTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration(), this.getInvariantRuleConfiguration(), null, "invariantRuleConfiguration", null, 1, 1, InvariantSemanticTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantRuleConfigurationEClass, InvariantRuleConfiguration.class, "InvariantRuleConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(composedRuleConfigurationEClass, ComposedRuleConfiguration.class, "ComposedRuleConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedRuleConfiguration_ComposedRules(), this.getInvariantRuleConfiguration(), null, "composedRules", null, 2, -1, ComposedRuleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andRuleEClass, AndRule.class, "AndRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orRuleEClass, OrRule.class, "OrRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //InvariantSemanticTypeConfigurationPackageImpl
