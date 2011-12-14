/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;
import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplyStereotypeActionConfigurationPackageImpl extends EPackageImpl implements ApplyStereotypeActionConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applyStereotypeActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeToApplyEClass = null;

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
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ApplyStereotypeActionConfigurationPackageImpl() {
		super(eNS_URI, ApplyStereotypeActionConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ApplyStereotypeActionConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ApplyStereotypeActionConfigurationPackage init() {
		if (isInited) return (ApplyStereotypeActionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplyStereotypeActionConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		ApplyStereotypeActionConfigurationPackageImpl theApplyStereotypeActionConfigurationPackage = (ApplyStereotypeActionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ApplyStereotypeActionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ApplyStereotypeActionConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theApplyStereotypeActionConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theApplyStereotypeActionConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theApplyStereotypeActionConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ApplyStereotypeActionConfigurationPackage.eNS_URI, theApplyStereotypeActionConfigurationPackage);
		return theApplyStereotypeActionConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplyStereotypeActionConfiguration() {
		return applyStereotypeActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplyStereotypeActionConfiguration_StereotypesToApply() {
		return (EReference)applyStereotypeActionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeToApply() {
		return stereotypeToApplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeToApply_StereotypeQualifiedName() {
		return (EAttribute)stereotypeToApplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeToApply_UpdateName() {
		return (EAttribute)stereotypeToApplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeToApply_RequiredProfiles() {
		return (EAttribute)stereotypeToApplyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationFactory getApplyStereotypeActionConfigurationFactory() {
		return (ApplyStereotypeActionConfigurationFactory)getEFactoryInstance();
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
		applyStereotypeActionConfigurationEClass = createEClass(APPLY_STEREOTYPE_ACTION_CONFIGURATION);
		createEReference(applyStereotypeActionConfigurationEClass, APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY);

		stereotypeToApplyEClass = createEClass(STEREOTYPE_TO_APPLY);
		createEAttribute(stereotypeToApplyEClass, STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME);
		createEAttribute(stereotypeToApplyEClass, STEREOTYPE_TO_APPLY__UPDATE_NAME);
		createEAttribute(stereotypeToApplyEClass, STEREOTYPE_TO_APPLY__REQUIRED_PROFILES);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		applyStereotypeActionConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getPostActionConfiguration());

		// Initialize classes and features; add operations and parameters
		initEClass(applyStereotypeActionConfigurationEClass, ApplyStereotypeActionConfiguration.class, "ApplyStereotypeActionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplyStereotypeActionConfiguration_StereotypesToApply(), this.getStereotypeToApply(), null, "stereotypesToApply", null, 0, -1, ApplyStereotypeActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypeToApplyEClass, StereotypeToApply.class, "StereotypeToApply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeToApply_StereotypeQualifiedName(), theTypesPackage.getString(), "stereotypeQualifiedName", null, 0, 1, StereotypeToApply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypeToApply_UpdateName(), theTypesPackage.getBoolean(), "updateName", null, 0, 1, StereotypeToApply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypeToApply_RequiredProfiles(), theEcorePackage.getEString(), "requiredProfiles", null, 1, -1, StereotypeToApply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ApplyStereotypeActionConfigurationPackageImpl
