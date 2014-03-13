/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.emf.newchild.CustomFiller;
import org.eclipse.papyrus.infra.emf.newchild.Menu;
import org.eclipse.papyrus.infra.emf.newchild.MenuAction;
import org.eclipse.papyrus.infra.emf.newchild.MenuContainer;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;
import org.eclipse.papyrus.infra.emf.newchild.MenuItem;
import org.eclipse.papyrus.infra.emf.newchild.MenuPosition;
import org.eclipse.papyrus.infra.emf.newchild.MenuRoot;
import org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration;
import org.eclipse.papyrus.infra.emf.newchild.NewchildFactory;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;
import org.eclipse.papyrus.infra.emf.newchild.Separator;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl.NcpolicyPackageImpl;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.uml2.types.TypesPackage;




/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NewchildPackageImpl extends EPackageImpl implements NewchildPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newchildConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass separatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customFillerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum menuPositionEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NewchildPackageImpl() {
		super(eNS_URI, NewchildFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NewchildPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NewchildPackage init() {
		if (isInited) return (NewchildPackage)EPackage.Registry.INSTANCE.getEPackage(NewchildPackage.eNS_URI);

		// Obtain or create and register package
		NewchildPackageImpl theNewchildPackage = (NewchildPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NewchildPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NewchildPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConstraintsPackage.eINSTANCE.eClass();
		ExtendedtypesPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NcpolicyPackageImpl theNcpolicyPackage = (NcpolicyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NcpolicyPackage.eNS_URI) instanceof NcpolicyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NcpolicyPackage.eNS_URI) : NcpolicyPackage.eINSTANCE);

		// Create package meta-data objects
		theNewchildPackage.createPackageContents();
		theNcpolicyPackage.createPackageContents();

		// Initialize created meta-data
		theNewchildPackage.initializePackageContents();
		theNcpolicyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNewchildPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NewchildPackage.eNS_URI, theNewchildPackage);
		return theNewchildPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewchildConfiguration() {
		return newchildConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewchildConfiguration_Roots() {
		return (EReference)newchildConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewchildConfiguration_Name() {
		return (EAttribute)newchildConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewchildConfiguration_NewChildPolicies() {
		return (EReference)newchildConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuRoot() {
		return menuRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuRoot_Groups() {
		return (EReference)menuRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuRoot_Name() {
		return (EAttribute)menuRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuItem() {
		return menuItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Id() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuContainer() {
		return menuContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuContainer_Submenus() {
		return (EReference)menuContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenu() {
		return menuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenu_Name() {
		return (EAttribute)menuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenu_Icon() {
		return (EAttribute)menuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuAction() {
		return menuActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuAction_ElementType() {
		return (EReference)menuActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeparator() {
		return separatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuGroup() {
		return menuGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuGroup_Before() {
		return (EAttribute)menuGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuGroup_After() {
		return (EAttribute)menuGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuGroup_AbsolutePosition() {
		return (EAttribute)menuGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomFiller() {
		return customFillerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomFiller_ClassName() {
		return (EAttribute)customFillerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMenuPosition() {
		return menuPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewchildFactory getNewchildFactory() {
		return (NewchildFactory)getEFactoryInstance();
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
		newchildConfigurationEClass = createEClass(NEWCHILD_CONFIGURATION);
		createEReference(newchildConfigurationEClass, NEWCHILD_CONFIGURATION__ROOTS);
		createEAttribute(newchildConfigurationEClass, NEWCHILD_CONFIGURATION__NAME);
		createEReference(newchildConfigurationEClass, NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES);

		menuRootEClass = createEClass(MENU_ROOT);
		createEReference(menuRootEClass, MENU_ROOT__GROUPS);
		createEAttribute(menuRootEClass, MENU_ROOT__NAME);

		menuItemEClass = createEClass(MENU_ITEM);
		createEAttribute(menuItemEClass, MENU_ITEM__ID);

		menuContainerEClass = createEClass(MENU_CONTAINER);
		createEReference(menuContainerEClass, MENU_CONTAINER__SUBMENUS);

		menuEClass = createEClass(MENU);
		createEAttribute(menuEClass, MENU__NAME);
		createEAttribute(menuEClass, MENU__ICON);

		menuActionEClass = createEClass(MENU_ACTION);
		createEReference(menuActionEClass, MENU_ACTION__ELEMENT_TYPE);

		separatorEClass = createEClass(SEPARATOR);

		menuGroupEClass = createEClass(MENU_GROUP);
		createEAttribute(menuGroupEClass, MENU_GROUP__BEFORE);
		createEAttribute(menuGroupEClass, MENU_GROUP__AFTER);
		createEAttribute(menuGroupEClass, MENU_GROUP__ABSOLUTE_POSITION);

		customFillerEClass = createEClass(CUSTOM_FILLER);
		createEAttribute(customFillerEClass, CUSTOM_FILLER__CLASS_NAME);

		// Create enums
		menuPositionEEnum = createEEnum(MENU_POSITION);
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
		NcpolicyPackage theNcpolicyPackage = (NcpolicyPackage)EPackage.Registry.INSTANCE.getEPackage(NcpolicyPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ConstraintsPackage theConstraintsPackage = (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);
		ExtendedtypesPackage theExtendedtypesPackage = (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theNcpolicyPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		menuRootEClass.getESuperTypes().add(this.getMenuContainer());
		menuRootEClass.getESuperTypes().add(theConstraintsPackage.getDisplayUnit());
		menuEClass.getESuperTypes().add(this.getMenuContainer());
		menuEClass.getESuperTypes().add(this.getMenuItem());
		menuActionEClass.getESuperTypes().add(this.getMenuItem());
		separatorEClass.getESuperTypes().add(this.getMenuItem());
		menuGroupEClass.getESuperTypes().add(this.getMenuContainer());
		customFillerEClass.getESuperTypes().add(this.getMenuItem());

		// Initialize classes and features; add operations and parameters
		initEClass(newchildConfigurationEClass, NewchildConfiguration.class, "NewchildConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewchildConfiguration_Roots(), this.getMenuRoot(), null, "roots", null, 0, -1, NewchildConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewchildConfiguration_Name(), theEcorePackage.getEString(), "name", null, 1, 1, NewchildConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewchildConfiguration_NewChildPolicies(), theNcpolicyPackage.getNewChildPolicySet(), null, "newChildPolicies", null, 0, -1, NewchildConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuRootEClass, MenuRoot.class, "MenuRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMenuRoot_Groups(), this.getMenuGroup(), null, "groups", null, 0, -1, MenuRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuRoot_Name(), theEcorePackage.getEString(), "name", null, 1, 1, MenuRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuItemEClass, MenuItem.class, "MenuItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMenuItem_Id(), theEcorePackage.getEString(), "id", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuContainerEClass, MenuContainer.class, "MenuContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMenuContainer_Submenus(), this.getMenuItem(), null, "submenus", null, 0, -1, MenuContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuEClass, Menu.class, "Menu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMenu_Name(), ecorePackage.getEString(), "name", null, 1, 1, Menu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenu_Icon(), theEcorePackage.getEString(), "icon", null, 0, 1, Menu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuActionEClass, MenuAction.class, "MenuAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMenuAction_ElementType(), theEcorePackage.getEObject(), null, "elementType", null, 1, 1, MenuAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(separatorEClass, Separator.class, "Separator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(menuGroupEClass, MenuGroup.class, "MenuGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMenuGroup_Before(), theEcorePackage.getEString(), "before", null, 0, 1, MenuGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuGroup_After(), theEcorePackage.getEString(), "after", null, 0, 1, MenuGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuGroup_AbsolutePosition(), this.getMenuPosition(), "absolutePosition", "top", 0, 1, MenuGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customFillerEClass, CustomFiller.class, "CustomFiller", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomFiller_ClassName(), theEcorePackage.getEString(), "className", null, 1, 1, CustomFiller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(menuPositionEEnum, MenuPosition.class, "MenuPosition");
		addEEnumLiteral(menuPositionEEnum, MenuPosition.TOP);
		addEEnumLiteral(menuPositionEEnum, MenuPosition.BOTTOM);

		// Create resource
		createResource(eNS_URI);
	}

} //NewchildPackageImpl
