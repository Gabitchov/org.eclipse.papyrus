/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;
import org.eclipse.papyrus.infra.emf.newchild.impl.NewchildPackageImpl;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CreateIn;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CustomPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.FilterPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.Layout;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyFactory;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.ReplacePolicy;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.uml2.types.TypesPackage;




/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NcpolicyPackageImpl extends EPackageImpl implements NcpolicyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEMFChildMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newChildPolicySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newChildPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacePolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum createInEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layoutEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NcpolicyPackageImpl() {
		super(eNS_URI, NcpolicyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NcpolicyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NcpolicyPackage init() {
		if (isInited) return (NcpolicyPackage)EPackage.Registry.INSTANCE.getEPackage(NcpolicyPackage.eNS_URI);

		// Obtain or create and register package
		NcpolicyPackageImpl theNcpolicyPackage = (NcpolicyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NcpolicyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NcpolicyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConstraintsPackage.eINSTANCE.eClass();
		ExtendedtypesPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NewchildPackageImpl theNewchildPackage = (NewchildPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NewchildPackage.eNS_URI) instanceof NewchildPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NewchildPackage.eNS_URI) : NewchildPackage.eINSTANCE);

		// Create package meta-data objects
		theNcpolicyPackage.createPackageContents();
		theNewchildPackage.createPackageContents();

		// Initialize created meta-data
		theNcpolicyPackage.initializePackageContents();
		theNewchildPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNcpolicyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NcpolicyPackage.eNS_URI, theNcpolicyPackage);
		return theNcpolicyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEMFChildMenu() {
		return newEMFChildMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEMFChildMenu_CreateIn() {
		return (EAttribute)newEMFChildMenuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEMFChildMenu_Layout() {
		return (EAttribute)newEMFChildMenuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewEMFChildMenu_Groups() {
		return (EReference)newEMFChildMenuEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewChildPolicySet() {
		return newChildPolicySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewChildPolicySet_Name() {
		return (EAttribute)newChildPolicySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewChildPolicySet_Policies() {
		return (EReference)newChildPolicySetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewChildPolicy() {
		return newChildPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewChildPolicy_Roles() {
		return (EAttribute)newChildPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewChildPolicy_EClasses() {
		return (EReference)newChildPolicyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewChildPolicy_Name() {
		return (EAttribute)newChildPolicyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterPolicy() {
		return filterPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacePolicy() {
		return replacePolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacePolicy_ReplaceWith() {
		return (EReference)replacePolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomPolicy() {
		return customPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomPolicy_ClassName() {
		return (EAttribute)customPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCreateIn() {
		return createInEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLayout() {
		return layoutEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NcpolicyFactory getNcpolicyFactory() {
		return (NcpolicyFactory)getEFactoryInstance();
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
		newEMFChildMenuEClass = createEClass(NEW_EMF_CHILD_MENU);
		createEAttribute(newEMFChildMenuEClass, NEW_EMF_CHILD_MENU__CREATE_IN);
		createEAttribute(newEMFChildMenuEClass, NEW_EMF_CHILD_MENU__LAYOUT);
		createEReference(newEMFChildMenuEClass, NEW_EMF_CHILD_MENU__GROUPS);

		newChildPolicySetEClass = createEClass(NEW_CHILD_POLICY_SET);
		createEAttribute(newChildPolicySetEClass, NEW_CHILD_POLICY_SET__NAME);
		createEReference(newChildPolicySetEClass, NEW_CHILD_POLICY_SET__POLICIES);

		newChildPolicyEClass = createEClass(NEW_CHILD_POLICY);
		createEAttribute(newChildPolicyEClass, NEW_CHILD_POLICY__ROLES);
		createEReference(newChildPolicyEClass, NEW_CHILD_POLICY__ECLASSES);
		createEAttribute(newChildPolicyEClass, NEW_CHILD_POLICY__NAME);

		filterPolicyEClass = createEClass(FILTER_POLICY);

		replacePolicyEClass = createEClass(REPLACE_POLICY);
		createEReference(replacePolicyEClass, REPLACE_POLICY__REPLACE_WITH);

		customPolicyEClass = createEClass(CUSTOM_POLICY);
		createEAttribute(customPolicyEClass, CUSTOM_POLICY__CLASS_NAME);

		// Create enums
		createInEEnum = createEEnum(CREATE_IN);
		layoutEEnum = createEEnum(LAYOUT);
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
		NewchildPackage theNewchildPackage = (NewchildPackage)EPackage.Registry.INSTANCE.getEPackage(NewchildPackage.eNS_URI);
		ConstraintsPackage theConstraintsPackage = (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		newEMFChildMenuEClass.getESuperTypes().add(theNewchildPackage.getMenu());
		newChildPolicySetEClass.getESuperTypes().add(theConstraintsPackage.getDisplayUnit());
		filterPolicyEClass.getESuperTypes().add(this.getNewChildPolicy());
		replacePolicyEClass.getESuperTypes().add(this.getNewChildPolicy());
		customPolicyEClass.getESuperTypes().add(this.getNewChildPolicy());

		// Initialize classes and features; add operations and parameters
		initEClass(newEMFChildMenuEClass, NewEMFChildMenu.class, "NewEMFChildMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEMFChildMenu_CreateIn(), this.getCreateIn(), "createIn", "self", 1, 1, NewEMFChildMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewEMFChildMenu_Layout(), this.getLayout(), "layout", "hierarchical", 1, 1, NewEMFChildMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewEMFChildMenu_Groups(), theNewchildPackage.getMenuGroup(), null, "groups", null, 0, -1, NewEMFChildMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newChildPolicySetEClass, NewChildPolicySet.class, "NewChildPolicySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewChildPolicySet_Name(), theEcorePackage.getEString(), "name", null, 1, 1, NewChildPolicySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewChildPolicySet_Policies(), this.getNewChildPolicy(), null, "policies", null, 0, -1, NewChildPolicySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newChildPolicyEClass, NewChildPolicy.class, "NewChildPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewChildPolicy_Roles(), theEcorePackage.getEString(), "roles", null, 0, -1, NewChildPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewChildPolicy_EClasses(), theEcorePackage.getEClass(), null, "eClasses", null, 0, -1, NewChildPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewChildPolicy_Name(), theEcorePackage.getEString(), "name", null, 1, 1, NewChildPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterPolicyEClass, FilterPolicy.class, "FilterPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacePolicyEClass, ReplacePolicy.class, "ReplacePolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacePolicy_ReplaceWith(), theNewchildPackage.getMenuItem(), null, "replaceWith", null, 1, -1, ReplacePolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customPolicyEClass, CustomPolicy.class, "CustomPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomPolicy_ClassName(), theEcorePackage.getEString(), "className", null, 1, 1, CustomPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(createInEEnum, CreateIn.class, "CreateIn");
		addEEnumLiteral(createInEEnum, CreateIn.SELF);
		addEEnumLiteral(createInEEnum, CreateIn.PARENT);

		initEEnum(layoutEEnum, Layout.class, "Layout");
		addEEnumLiteral(layoutEEnum, Layout.HIERARCHICAL);
		addEEnumLiteral(layoutEEnum, Layout.FLAT);
		addEEnumLiteral(layoutEEnum, Layout.AUTO);
	}

} //NcpolicyPackageImpl
