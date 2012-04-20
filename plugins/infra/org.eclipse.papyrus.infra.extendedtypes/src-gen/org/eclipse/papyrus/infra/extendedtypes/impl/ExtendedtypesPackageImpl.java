/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesFactory;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IconEntry;
import org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration;
import org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedtypesPackageImpl extends EPackageImpl implements ExtendedtypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedElementTypeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedElementTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postActionConfigurationEClass = null;

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
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExtendedtypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtendedtypesPackage init() {
		if (isInited) return (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);

		// Obtain or create and register package
		ExtendedtypesPackageImpl theExtendedtypesPackage = (ExtendedtypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtendedtypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtendedtypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfigurationPackage.eINSTANCE.eClass();

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
	 * @generated
	 */
	public EClass getExtendedElementTypeSet() {
		return extendedElementTypeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedElementTypeSet_ElementType() {
		return (EReference)extendedElementTypeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeSet_Id() {
		return (EAttribute)extendedElementTypeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedElementTypeConfiguration() {
		return extendedElementTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_Name() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_Id() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedElementTypeConfiguration_IconEntry() {
		return (EReference)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_Hint() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_KindName() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_SpecializedTypesID() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedElementTypeConfiguration_PreValidation() {
		return (EReference)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedElementTypeConfiguration_PreAction() {
		return (EReference)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedElementTypeConfiguration_PostAction() {
		return (EReference)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedElementTypeConfiguration_SpecializedDiagramTypeID() {
		return (EAttribute)extendedElementTypeConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIconEntry() {
		return iconEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconEntry_IconPath() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconEntry_BundleId() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionConfiguration() {
		return actionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionConfiguration_Label() {
		return (EAttribute)actionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionConfiguration_Id() {
		return (EAttribute)actionConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreActionConfiguration() {
		return preActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostActionConfiguration() {
		return postActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedtypesFactory getExtendedtypesFactory() {
		return (ExtendedtypesFactory)getEFactoryInstance();
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
		extendedElementTypeSetEClass = createEClass(EXTENDED_ELEMENT_TYPE_SET);
		createEReference(extendedElementTypeSetEClass, EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE);
		createEAttribute(extendedElementTypeSetEClass, EXTENDED_ELEMENT_TYPE_SET__ID);

		extendedElementTypeConfigurationEClass = createEClass(EXTENDED_ELEMENT_TYPE_CONFIGURATION);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID);
		createEReference(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID);
		createEReference(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION);
		createEReference(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION);
		createEReference(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION);
		createEAttribute(extendedElementTypeConfigurationEClass, EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID);

		iconEntryEClass = createEClass(ICON_ENTRY);
		createEAttribute(iconEntryEClass, ICON_ENTRY__ICON_PATH);
		createEAttribute(iconEntryEClass, ICON_ENTRY__BUNDLE_ID);

		actionConfigurationEClass = createEClass(ACTION_CONFIGURATION);
		createEAttribute(actionConfigurationEClass, ACTION_CONFIGURATION__LABEL);
		createEAttribute(actionConfigurationEClass, ACTION_CONFIGURATION__ID);

		preActionConfigurationEClass = createEClass(PRE_ACTION_CONFIGURATION);

		postActionConfigurationEClass = createEClass(POST_ACTION_CONFIGURATION);
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
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		preActionConfigurationEClass.getESuperTypes().add(this.getActionConfiguration());
		postActionConfigurationEClass.getESuperTypes().add(this.getActionConfiguration());

		// Initialize classes and features; add operations and parameters
		initEClass(extendedElementTypeSetEClass, ExtendedElementTypeSet.class, "ExtendedElementTypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendedElementTypeSet_ElementType(), this.getExtendedElementTypeConfiguration(), null, "elementType", null, 1, -1, ExtendedElementTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeSet_Id(), ecorePackage.getEString(), "id", null, 1, 1, ExtendedElementTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendedElementTypeConfigurationEClass, ExtendedElementTypeConfiguration.class, "ExtendedElementTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendedElementTypeConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedElementTypeConfiguration_IconEntry(), this.getIconEntry(), null, "iconEntry", null, 0, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeConfiguration_Hint(), ecorePackage.getEString(), "hint", "ExtendedElements", 0, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeConfiguration_KindName(), ecorePackage.getEString(), "kindName", "org.eclipse.gmf.runtime.emf.type.core.IHintedType", 0, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeConfiguration_SpecializedTypesID(), ecorePackage.getEString(), "specializedTypesID", null, 1, -1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedElementTypeConfiguration_PreValidation(), theConfigurationPackage.getQueryConfiguration(), null, "preValidation", null, 0, -1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedElementTypeConfiguration_PreAction(), this.getPreActionConfiguration(), null, "preAction", null, 0, -1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedElementTypeConfiguration_PostAction(), this.getPostActionConfiguration(), null, "postAction", null, 0, -1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedElementTypeConfiguration_SpecializedDiagramTypeID(), ecorePackage.getEString(), "specializedDiagramTypeID", null, 0, 1, ExtendedElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconEntryEClass, IconEntry.class, "IconEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconEntry_IconPath(), ecorePackage.getEString(), "iconPath", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconEntry_BundleId(), ecorePackage.getEString(), "bundleId", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionConfigurationEClass, ActionConfiguration.class, "ActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionConfiguration_Label(), ecorePackage.getEString(), "label", null, 0, 1, ActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, ActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preActionConfigurationEClass, PreActionConfiguration.class, "PreActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postActionConfigurationEClass, PostActionConfiguration.class, "PostActionConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExtendedtypesPackageImpl
