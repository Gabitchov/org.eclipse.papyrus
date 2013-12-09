/**
 */
package ElementCreationMenuModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ElementCreationMenuModel.ElementCreationMenuModelFactory
 * @model kind="package"
 * @generated
 */
public interface ElementCreationMenuModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ElementCreationMenuModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ElementCreationMenuModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ElementCreationMenuModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementCreationMenuModelPackage eINSTANCE = ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ElementCreationMenuModel.impl.MenuImpl <em>Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ElementCreationMenuModel.impl.MenuImpl
	 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getMenu()
	 * @generated
	 */
	int MENU = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ICON = 1;

	/**
	 * The number of structural features of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ElementCreationMenuModel.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ElementCreationMenuModel.impl.FolderImpl
	 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__LABEL = MENU__LABEL;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__ICON = MENU__ICON;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__MENU = MENU_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = MENU_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = MENU_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ElementCreationMenuModel.impl.CreationMenuImpl <em>Creation Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ElementCreationMenuModel.impl.CreationMenuImpl
	 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getCreationMenu()
	 * @generated
	 */
	int CREATION_MENU = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU__LABEL = MENU__LABEL;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU__ICON = MENU__ICON;

	/**
	 * The feature id for the '<em><b>Element Type Id Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU__ELEMENT_TYPE_ID_REF = MENU_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU__ROLE = MENU_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display All Roles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU__DISPLAY_ALL_ROLES = MENU_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Creation Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU_FEATURE_COUNT = MENU_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Creation Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_MENU_OPERATION_COUNT = MENU_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ElementCreationMenuModel.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see ElementCreationMenuModel.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link ElementCreationMenuModel.Folder#getMenu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Menu</em>'.
	 * @see ElementCreationMenuModel.Folder#getMenu()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Menu();

	/**
	 * Returns the meta object for class '{@link ElementCreationMenuModel.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu</em>'.
	 * @see ElementCreationMenuModel.Menu
	 * @generated
	 */
	EClass getMenu();

	/**
	 * Returns the meta object for the attribute '{@link ElementCreationMenuModel.Menu#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see ElementCreationMenuModel.Menu#getLabel()
	 * @see #getMenu()
	 * @generated
	 */
	EAttribute getMenu_Label();

	/**
	 * Returns the meta object for the attribute '{@link ElementCreationMenuModel.Menu#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see ElementCreationMenuModel.Menu#getIcon()
	 * @see #getMenu()
	 * @generated
	 */
	EAttribute getMenu_Icon();

	/**
	 * Returns the meta object for class '{@link ElementCreationMenuModel.CreationMenu <em>Creation Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creation Menu</em>'.
	 * @see ElementCreationMenuModel.CreationMenu
	 * @generated
	 */
	EClass getCreationMenu();

	/**
	 * Returns the meta object for the attribute '{@link ElementCreationMenuModel.CreationMenu#getElementTypeIdRef <em>Element Type Id Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type Id Ref</em>'.
	 * @see ElementCreationMenuModel.CreationMenu#getElementTypeIdRef()
	 * @see #getCreationMenu()
	 * @generated
	 */
	EAttribute getCreationMenu_ElementTypeIdRef();

	/**
	 * Returns the meta object for the attribute '{@link ElementCreationMenuModel.CreationMenu#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see ElementCreationMenuModel.CreationMenu#getRole()
	 * @see #getCreationMenu()
	 * @generated
	 */
	EAttribute getCreationMenu_Role();

	/**
	 * Returns the meta object for the attribute '{@link ElementCreationMenuModel.CreationMenu#isDisplayAllRoles <em>Display All Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display All Roles</em>'.
	 * @see ElementCreationMenuModel.CreationMenu#isDisplayAllRoles()
	 * @see #getCreationMenu()
	 * @generated
	 */
	EAttribute getCreationMenu_DisplayAllRoles();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ElementCreationMenuModelFactory getElementCreationMenuModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ElementCreationMenuModel.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ElementCreationMenuModel.impl.FolderImpl
		 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Menu</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__MENU = eINSTANCE.getFolder_Menu();

		/**
		 * The meta object literal for the '{@link ElementCreationMenuModel.impl.MenuImpl <em>Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ElementCreationMenuModel.impl.MenuImpl
		 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getMenu()
		 * @generated
		 */
		EClass MENU = eINSTANCE.getMenu();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU__LABEL = eINSTANCE.getMenu_Label();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU__ICON = eINSTANCE.getMenu_Icon();

		/**
		 * The meta object literal for the '{@link ElementCreationMenuModel.impl.CreationMenuImpl <em>Creation Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ElementCreationMenuModel.impl.CreationMenuImpl
		 * @see ElementCreationMenuModel.impl.ElementCreationMenuModelPackageImpl#getCreationMenu()
		 * @generated
		 */
		EClass CREATION_MENU = eINSTANCE.getCreationMenu();

		/**
		 * The meta object literal for the '<em><b>Element Type Id Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATION_MENU__ELEMENT_TYPE_ID_REF = eINSTANCE.getCreationMenu_ElementTypeIdRef();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATION_MENU__ROLE = eINSTANCE.getCreationMenu_Role();

		/**
		 * The meta object literal for the '<em><b>Display All Roles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATION_MENU__DISPLAY_ALL_ROLES = eINSTANCE.getCreationMenu_DisplayAllRoles();

	}

} //ElementCreationMenuModelPackage
