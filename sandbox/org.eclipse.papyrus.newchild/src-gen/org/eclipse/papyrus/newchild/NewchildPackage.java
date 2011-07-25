/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.newchild.NewchildFactory
 * @model kind="package"
 * @generated
 */
public interface NewchildPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "newchild";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/newchild";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "newchild";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NewchildPackage eINSTANCE = org.eclipse.papyrus.newchild.impl.NewchildPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.NewchildConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.NewchildConfigurationImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getNewchildConfiguration()
	 * @generated
	 */
	int NEWCHILD_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Roots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWCHILD_CONFIGURATION__ROOTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWCHILD_CONFIGURATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>New Child Policies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWCHILD_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuContainerImpl <em>Menu Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuContainerImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuContainer()
	 * @generated
	 */
	int MENU_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Submenus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_CONTAINER__SUBMENUS = 0;

	/**
	 * The number of structural features of the '<em>Menu Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl <em>Menu Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuRootImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuRoot()
	 * @generated
	 */
	int MENU_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Submenus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT__SUBMENUS = MENU_CONTAINER__SUBMENUS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT__CONSTRAINTS = MENU_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT__ELEMENT_MULTIPLICITY = MENU_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT__GROUPS = MENU_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT__NAME = MENU_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Menu Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ROOT_FEATURE_COUNT = MENU_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuItemImpl <em>Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuItemImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuItem()
	 * @generated
	 */
	int MENU_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ID = 0;

	/**
	 * The number of structural features of the '<em>Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuImpl <em>Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenu()
	 * @generated
	 */
	int MENU = 4;

	/**
	 * The feature id for the '<em><b>Submenus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__SUBMENUS = MENU_CONTAINER__SUBMENUS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ID = MENU_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__NAME = MENU_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ICON = MENU_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_FEATURE_COUNT = MENU_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuActionImpl <em>Menu Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuActionImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuAction()
	 * @generated
	 */
	int MENU_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__ID = MENU_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__ELEMENT_TYPE = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Menu Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.SeparatorImpl <em>Separator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.SeparatorImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getSeparator()
	 * @generated
	 */
	int SEPARATOR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR__ID = MENU_ITEM__ID;

	/**
	 * The number of structural features of the '<em>Separator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.MenuGroupImpl <em>Menu Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.MenuGroupImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuGroup()
	 * @generated
	 */
	int MENU_GROUP = 7;

	/**
	 * The feature id for the '<em><b>Submenus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_GROUP__SUBMENUS = MENU_CONTAINER__SUBMENUS;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_GROUP__BEFORE = MENU_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_GROUP__AFTER = MENU_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Absolute Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_GROUP__ABSOLUTE_POSITION = MENU_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Menu Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_GROUP_FEATURE_COUNT = MENU_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.impl.CustomFillerImpl <em>Custom Filler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.impl.CustomFillerImpl
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getCustomFiller()
	 * @generated
	 */
	int CUSTOM_FILLER = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_FILLER__ID = MENU_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_FILLER__CLASS_NAME = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Filler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_FILLER_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.MenuPosition <em>Menu Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.MenuPosition
	 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuPosition()
	 * @generated
	 */
	int MENU_POSITION = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.NewchildConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.newchild.NewchildConfiguration
	 * @generated
	 */
	EClass getNewchildConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.NewchildConfiguration#getRoots <em>Roots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roots</em>'.
	 * @see org.eclipse.papyrus.newchild.NewchildConfiguration#getRoots()
	 * @see #getNewchildConfiguration()
	 * @generated
	 */
	EReference getNewchildConfiguration_Roots();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.NewchildConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.newchild.NewchildConfiguration#getName()
	 * @see #getNewchildConfiguration()
	 * @generated
	 */
	EAttribute getNewchildConfiguration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.NewchildConfiguration#getNewChildPolicies <em>New Child Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>New Child Policies</em>'.
	 * @see org.eclipse.papyrus.newchild.NewchildConfiguration#getNewChildPolicies()
	 * @see #getNewchildConfiguration()
	 * @generated
	 */
	EReference getNewchildConfiguration_NewChildPolicies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.MenuRoot <em>Menu Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Root</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuRoot
	 * @generated
	 */
	EClass getMenuRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.MenuRoot#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuRoot#getGroups()
	 * @see #getMenuRoot()
	 * @generated
	 */
	EReference getMenuRoot_Groups();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.MenuRoot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuRoot#getName()
	 * @see #getMenuRoot()
	 * @generated
	 */
	EAttribute getMenuRoot_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuItem
	 * @generated
	 */
	EClass getMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.MenuItem#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuItem#getId()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.MenuContainer <em>Menu Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Container</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuContainer
	 * @generated
	 */
	EClass getMenuContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.MenuContainer#getSubmenus <em>Submenus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Submenus</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuContainer#getSubmenus()
	 * @see #getMenuContainer()
	 * @generated
	 */
	EReference getMenuContainer_Submenus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu</em>'.
	 * @see org.eclipse.papyrus.newchild.Menu
	 * @generated
	 */
	EClass getMenu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.Menu#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.newchild.Menu#getName()
	 * @see #getMenu()
	 * @generated
	 */
	EAttribute getMenu_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.Menu#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.newchild.Menu#getIcon()
	 * @see #getMenu()
	 * @generated
	 */
	EAttribute getMenu_Icon();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.MenuAction <em>Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Action</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuAction
	 * @generated
	 */
	EClass getMenuAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.newchild.MenuAction#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuAction#getElementType()
	 * @see #getMenuAction()
	 * @generated
	 */
	EReference getMenuAction_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.Separator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Separator</em>'.
	 * @see org.eclipse.papyrus.newchild.Separator
	 * @generated
	 */
	EClass getSeparator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.MenuGroup <em>Menu Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Group</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuGroup
	 * @generated
	 */
	EClass getMenuGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.MenuGroup#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Before</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuGroup#getBefore()
	 * @see #getMenuGroup()
	 * @generated
	 */
	EAttribute getMenuGroup_Before();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.MenuGroup#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuGroup#getAfter()
	 * @see #getMenuGroup()
	 * @generated
	 */
	EAttribute getMenuGroup_After();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.MenuGroup#getAbsolutePosition <em>Absolute Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Absolute Position</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuGroup#getAbsolutePosition()
	 * @see #getMenuGroup()
	 * @generated
	 */
	EAttribute getMenuGroup_AbsolutePosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.CustomFiller <em>Custom Filler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Filler</em>'.
	 * @see org.eclipse.papyrus.newchild.CustomFiller
	 * @generated
	 */
	EClass getCustomFiller();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.CustomFiller#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.papyrus.newchild.CustomFiller#getClassName()
	 * @see #getCustomFiller()
	 * @generated
	 */
	EAttribute getCustomFiller_ClassName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.newchild.MenuPosition <em>Menu Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Menu Position</em>'.
	 * @see org.eclipse.papyrus.newchild.MenuPosition
	 * @generated
	 */
	EEnum getMenuPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NewchildFactory getNewchildFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.NewchildConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.NewchildConfigurationImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getNewchildConfiguration()
		 * @generated
		 */
		EClass NEWCHILD_CONFIGURATION = eINSTANCE.getNewchildConfiguration();

		/**
		 * The meta object literal for the '<em><b>Roots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEWCHILD_CONFIGURATION__ROOTS = eINSTANCE.getNewchildConfiguration_Roots();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWCHILD_CONFIGURATION__NAME = eINSTANCE.getNewchildConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>New Child Policies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES = eINSTANCE.getNewchildConfiguration_NewChildPolicies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuRootImpl <em>Menu Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuRootImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuRoot()
		 * @generated
		 */
		EClass MENU_ROOT = eINSTANCE.getMenuRoot();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_ROOT__GROUPS = eINSTANCE.getMenuRoot_Groups();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ROOT__NAME = eINSTANCE.getMenuRoot_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuItemImpl <em>Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuItemImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuItem()
		 * @generated
		 */
		EClass MENU_ITEM = eINSTANCE.getMenuItem();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__ID = eINSTANCE.getMenuItem_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuContainerImpl <em>Menu Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuContainerImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuContainer()
		 * @generated
		 */
		EClass MENU_CONTAINER = eINSTANCE.getMenuContainer();

		/**
		 * The meta object literal for the '<em><b>Submenus</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_CONTAINER__SUBMENUS = eINSTANCE.getMenuContainer_Submenus();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuImpl <em>Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenu()
		 * @generated
		 */
		EClass MENU = eINSTANCE.getMenu();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU__NAME = eINSTANCE.getMenu_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU__ICON = eINSTANCE.getMenu_Icon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuActionImpl <em>Menu Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuActionImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuAction()
		 * @generated
		 */
		EClass MENU_ACTION = eINSTANCE.getMenuAction();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_ACTION__ELEMENT_TYPE = eINSTANCE.getMenuAction_ElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.SeparatorImpl <em>Separator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.SeparatorImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getSeparator()
		 * @generated
		 */
		EClass SEPARATOR = eINSTANCE.getSeparator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.MenuGroupImpl <em>Menu Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.MenuGroupImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuGroup()
		 * @generated
		 */
		EClass MENU_GROUP = eINSTANCE.getMenuGroup();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_GROUP__BEFORE = eINSTANCE.getMenuGroup_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_GROUP__AFTER = eINSTANCE.getMenuGroup_After();

		/**
		 * The meta object literal for the '<em><b>Absolute Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_GROUP__ABSOLUTE_POSITION = eINSTANCE.getMenuGroup_AbsolutePosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.impl.CustomFillerImpl <em>Custom Filler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.impl.CustomFillerImpl
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getCustomFiller()
		 * @generated
		 */
		EClass CUSTOM_FILLER = eINSTANCE.getCustomFiller();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_FILLER__CLASS_NAME = eINSTANCE.getCustomFiller_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.MenuPosition <em>Menu Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.MenuPosition
		 * @see org.eclipse.papyrus.newchild.impl.NewchildPackageImpl#getMenuPosition()
		 * @generated
		 */
		EEnum MENU_POSITION = eINSTANCE.getMenuPosition();

	}

} //NewchildPackage
