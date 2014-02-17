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
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement;
import org.eclipse.papyrus.infra.extendedtypes.ElementTypeAdviceConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesFactory;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IconEntry;
import org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExtendedtypesPackageImpl extends EPackageImpl implements ExtendedtypesPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass extendedElementTypeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iconEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass configurationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass matcherConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass viewActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass semanticActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass semanticTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass viewTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeAdviceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass aspectSemanticTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass aspectViewTypeConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtendedtypesPackageImpl() {
		super(eNS_URI, ExtendedtypesFactory.eINSTANCE);
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
	 * This method is used to initialize {@link ExtendedtypesPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtendedtypesPackage init() {
		if(isInited)
			return (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);
		// Obtain or create and register package
		ExtendedtypesPackageImpl theExtendedtypesPackage = (ExtendedtypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtendedtypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtendedtypesPackageImpl());
		isInited = true;
		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		// Create package meta-data objects
		theExtendedtypesPackage.createPackageContents();
		// Initialize created meta-data
		theExtendedtypesPackage.initializePackageContents();
		// Mark meta-data to indicate it can't be changed
		theExtendedtypesPackage.freeze();
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtendedtypesPackage.eNS_URI, theExtendedtypesPackage);
		return theExtendedtypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExtendedElementTypeSet() {
		return extendedElementTypeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExtendedElementTypeSet_ElementType() {
		return (EReference)extendedElementTypeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getExtendedElementTypeSet_Extensible() {
		return (EAttribute)extendedElementTypeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypeConfiguration() {
		return elementTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementTypeConfiguration_Hint() {
		return (EAttribute)elementTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementTypeConfiguration_KindName() {
		return (EAttribute)elementTypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementTypeConfiguration_SpecializedTypesID() {
		return (EAttribute)elementTypeConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypeConfiguration_MatcherConfiguration() {
		return (EReference)elementTypeConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIconEntry() {
		return iconEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIconEntry_IconPath() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIconEntry_BundleId() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConfigurationElement() {
		return configurationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConfigurationElement_Name() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConfigurationElement_Description() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConfigurationElement_Identifier() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConfigurationElement_IconEntry() {
		return (EReference)configurationElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMatcherConfiguration() {
		return matcherConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActionConfiguration() {
		return actionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getViewActionConfiguration() {
		return viewActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSemanticActionConfiguration() {
		return semanticActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSemanticTypeConfiguration() {
		return semanticTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getViewTypeConfiguration() {
		return viewTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getViewTypeConfiguration_SpecializedDiagramTypeID() {
		return (EAttribute)viewTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypeAdviceConfiguration() {
		return elementTypeAdviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAspectSemanticTypeConfiguration() {
		return aspectSemanticTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAspectSemanticTypeConfiguration_ActionConfiguration() {
		return (EReference)aspectSemanticTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAspectViewTypeConfiguration() {
		return aspectViewTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAspectViewTypeConfiguration_ActionConfiguration() {
		return (EReference)aspectViewTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedtypesFactory getExtendedtypesFactory() {
		return (ExtendedtypesFactory)getEFactoryInstance();
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
		extendedElementTypeSetEClass = createEClass(EXTENDED_ELEMENT_TYPE_SET);
		createEReference(extendedElementTypeSetEClass, EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE);
		createEAttribute(extendedElementTypeSetEClass, EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE);
		elementTypeConfigurationEClass = createEClass(ELEMENT_TYPE_CONFIGURATION);
		createEAttribute(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__HINT);
		createEAttribute(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__KIND_NAME);
		createEAttribute(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID);
		createEReference(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION);
		iconEntryEClass = createEClass(ICON_ENTRY);
		createEAttribute(iconEntryEClass, ICON_ENTRY__ICON_PATH);
		createEAttribute(iconEntryEClass, ICON_ENTRY__BUNDLE_ID);
		configurationElementEClass = createEClass(CONFIGURATION_ELEMENT);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__NAME);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__DESCRIPTION);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__IDENTIFIER);
		createEReference(configurationElementEClass, CONFIGURATION_ELEMENT__ICON_ENTRY);
		matcherConfigurationEClass = createEClass(MATCHER_CONFIGURATION);
		actionConfigurationEClass = createEClass(ACTION_CONFIGURATION);
		viewActionConfigurationEClass = createEClass(VIEW_ACTION_CONFIGURATION);
		semanticActionConfigurationEClass = createEClass(SEMANTIC_ACTION_CONFIGURATION);
		semanticTypeConfigurationEClass = createEClass(SEMANTIC_TYPE_CONFIGURATION);
		viewTypeConfigurationEClass = createEClass(VIEW_TYPE_CONFIGURATION);
		createEAttribute(viewTypeConfigurationEClass, VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID);
		elementTypeAdviceConfigurationEClass = createEClass(ELEMENT_TYPE_ADVICE_CONFIGURATION);
		aspectSemanticTypeConfigurationEClass = createEClass(ASPECT_SEMANTIC_TYPE_CONFIGURATION);
		createEReference(aspectSemanticTypeConfigurationEClass, ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION);
		aspectViewTypeConfigurationEClass = createEClass(ASPECT_VIEW_TYPE_CONFIGURATION);
		createEReference(aspectViewTypeConfigurationEClass, ASPECT_VIEW_TYPE_CONFIGURATION__ACTION_CONFIGURATION);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		// Create type parameters
		// Set bounds for type parameters
		// Add supertypes to classes
		extendedElementTypeSetEClass.getESuperTypes().add(this.getConfigurationElement());
		elementTypeConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		actionConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		viewActionConfigurationEClass.getESuperTypes().add(this.getActionConfiguration());
		semanticActionConfigurationEClass.getESuperTypes().add(this.getActionConfiguration());
		semanticTypeConfigurationEClass.getESuperTypes().add(this.getElementTypeConfiguration());
		viewTypeConfigurationEClass.getESuperTypes().add(this.getElementTypeConfiguration());
		elementTypeAdviceConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		aspectSemanticTypeConfigurationEClass.getESuperTypes().add(this.getSemanticTypeConfiguration());
		aspectViewTypeConfigurationEClass.getESuperTypes().add(this.getViewTypeConfiguration());
		// Initialize classes and features; add operations and parameters
		initEClass(extendedElementTypeSetEClass, ExtendedElementTypeSet.class, "ExtendedElementTypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExtendedElementTypeSet_ElementType(), this.getElementTypeConfiguration(), null, "elementType", null, 1, -1, ExtendedElementTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExtendedElementTypeSet_Extensible(), theEcorePackage.getEBoolean(), "extensible", null, 0, 1, ExtendedElementTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(elementTypeConfigurationEClass, ElementTypeConfiguration.class, "ElementTypeConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getElementTypeConfiguration_Hint(), ecorePackage.getEString(), "hint", "ExtendedElements", 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getElementTypeConfiguration_KindName(), ecorePackage.getEString(), "kindName", "org.eclipse.gmf.runtime.emf.type.core.IHintedType", 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getElementTypeConfiguration_SpecializedTypesID(), ecorePackage.getEString(), "specializedTypesID", null, 1, -1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getElementTypeConfiguration_MatcherConfiguration(), this.getMatcherConfiguration(), null, "matcherConfiguration", null, 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(iconEntryEClass, IconEntry.class, "IconEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIconEntry_IconPath(), ecorePackage.getEString(), "iconPath", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIconEntry_BundleId(), ecorePackage.getEString(), "bundleId", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(configurationElementEClass, ConfigurationElement.class, "ConfigurationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getConfigurationElement_Name(), theEcorePackage.getEString(), "name", null, 1, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getConfigurationElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getConfigurationElement_Identifier(), theEcorePackage.getEString(), "identifier", null, 1, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConfigurationElement_IconEntry(), this.getIconEntry(), null, "iconEntry", null, 0, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(matcherConfigurationEClass, MatcherConfiguration.class, "MatcherConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(actionConfigurationEClass, ActionConfiguration.class, "ActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(viewActionConfigurationEClass, ViewActionConfiguration.class, "ViewActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(semanticActionConfigurationEClass, SemanticActionConfiguration.class, "SemanticActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(semanticTypeConfigurationEClass, SemanticTypeConfiguration.class, "SemanticTypeConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(viewTypeConfigurationEClass, ViewTypeConfiguration.class, "ViewTypeConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getViewTypeConfiguration_SpecializedDiagramTypeID(), ecorePackage.getEString(), "specializedDiagramTypeID", null, 0, 1, ViewTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(elementTypeAdviceConfigurationEClass, ElementTypeAdviceConfiguration.class, "ElementTypeAdviceConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEClass(aspectSemanticTypeConfigurationEClass, AspectSemanticTypeConfiguration.class, "AspectSemanticTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAspectSemanticTypeConfiguration_ActionConfiguration(), this.getSemanticActionConfiguration(), null, "actionConfiguration", null, 0, -1, AspectSemanticTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEClass(aspectViewTypeConfigurationEClass, AspectViewTypeConfiguration.class, "AspectViewTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAspectViewTypeConfiguration_ActionConfiguration(), this.getViewActionConfiguration(), null, "actionConfiguration", null, 0, -1, AspectViewTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		// Create resource
		createResource(eNS_URI);
	}
} //ExtendedtypesPackageImpl
