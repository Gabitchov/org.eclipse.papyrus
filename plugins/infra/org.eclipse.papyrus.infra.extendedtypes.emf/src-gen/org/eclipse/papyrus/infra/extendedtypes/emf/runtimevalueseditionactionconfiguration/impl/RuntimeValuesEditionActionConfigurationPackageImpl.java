/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay;

import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;

import org.eclipse.papyrus.views.properties.environment.EnvironmentPackage;

import org.eclipse.papyrus.views.properties.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeValuesEditionActionConfigurationPackageImpl extends EPackageImpl implements RuntimeValuesEditionActionConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeValuesEditionActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewToDisplayEClass = null;

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimeValuesEditionActionConfigurationPackageImpl() {
		super(eNS_URI, RuntimeValuesEditionActionConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimeValuesEditionActionConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimeValuesEditionActionConfigurationPackage init() {
		if (isInited) return (RuntimeValuesEditionActionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimeValuesEditionActionConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		RuntimeValuesEditionActionConfigurationPackageImpl theRuntimeValuesEditionActionConfigurationPackage = (RuntimeValuesEditionActionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimeValuesEditionActionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimeValuesEditionActionConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();
		EnvironmentPackage.eINSTANCE.eClass();
		ContextsPackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRuntimeValuesEditionActionConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimeValuesEditionActionConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimeValuesEditionActionConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimeValuesEditionActionConfigurationPackage.eNS_URI, theRuntimeValuesEditionActionConfigurationPackage);
		return theRuntimeValuesEditionActionConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeValuesEditionActionConfiguration() {
		return runtimeValuesEditionActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeValuesEditionActionConfiguration_ViewsToDisplay() {
		return (EReference)runtimeValuesEditionActionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewToDisplay() {
		return viewToDisplayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewToDisplay_View() {
		return (EReference)viewToDisplayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionActionConfigurationFactory getRuntimeValuesEditionActionConfigurationFactory() {
		return (RuntimeValuesEditionActionConfigurationFactory)getEFactoryInstance();
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
		runtimeValuesEditionActionConfigurationEClass = createEClass(RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION);
		createEReference(runtimeValuesEditionActionConfigurationEClass, RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY);

		viewToDisplayEClass = createEClass(VIEW_TO_DISPLAY);
		createEReference(viewToDisplayEClass, VIEW_TO_DISPLAY__VIEW);
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
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		runtimeValuesEditionActionConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticActionConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(runtimeValuesEditionActionConfigurationEClass, RuntimeValuesEditionActionConfiguration.class, "RuntimeValuesEditionActionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuntimeValuesEditionActionConfiguration_ViewsToDisplay(), this.getViewToDisplay(), null, "viewsToDisplay", null, 0, -1, RuntimeValuesEditionActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewToDisplayEClass, ViewToDisplay.class, "ViewToDisplay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewToDisplay_View(), theContextsPackage.getView(), null, "view", null, 1, 1, ViewToDisplay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RuntimeValuesEditionActionConfigurationPackageImpl
