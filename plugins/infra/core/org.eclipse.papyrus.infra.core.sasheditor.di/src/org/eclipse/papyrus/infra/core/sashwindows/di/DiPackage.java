/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory
 * @model kind="package"
 * @generated
 */
public interface DiPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "di";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/sashdi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "di";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiPackage eINSTANCE = org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl <em>Sash Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashModel()
	 * @generated
	 */
	int SASH_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Windows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_MODEL__WINDOWS = 0;

	/**
	 * The feature id for the '<em><b>Current Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_MODEL__CURRENT_SELECTION = 1;

	/**
	 * The number of structural features of the '<em>Sash Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PanelParentImpl <em>Panel Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PanelParentImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPanelParent()
	 * @generated
	 */
	int PANEL_PARENT = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_PARENT__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Panel Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_PARENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.WindowImpl <em>Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.WindowImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getWindow()
	 * @generated
	 */
	int WINDOW = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__CHILDREN = PANEL_PARENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__POSITION = PANEL_PARENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__SIZE = PANEL_PARENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__PANEL = PANEL_PARENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = PANEL_PARENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPanelImpl <em>Abstract Panel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPanelImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getAbstractPanel()
	 * @generated
	 */
	int ABSTRACT_PANEL = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PANEL__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Abstract Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PANEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PositionImpl <em>Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PositionImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__Y = 1;

	/**
	 * The number of structural features of the '<em>Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SizeImpl <em>Size</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SizeImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSize()
	 * @generated
	 */
	int SIZE = 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE__LENGTH = 1;

	/**
	 * The number of structural features of the '<em>Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.TabFolderImpl <em>Tab Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.TabFolderImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getTabFolder()
	 * @generated
	 */
	int TAB_FOLDER = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__PARENT = ABSTRACT_PANEL__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__CHILDREN = ABSTRACT_PANEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tab Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER_FEATURE_COUNT = ABSTRACT_PANEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl <em>Page Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPageRef()
	 * @generated
	 */
	int PAGE_REF = 7;

	/**
	 * The feature id for the '<em><b>Emf Page Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_REF__EMF_PAGE_IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_REF__PAGE_IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Object Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_REF__OBJECT_PAGE_IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_REF__PARENT = 3;

	/**
	 * The number of structural features of the '<em>Page Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_REF_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl <em>Sash Panel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashPanel()
	 * @generated
	 */
	int SASH_PANEL = 8;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_PANEL__PARENT = ABSTRACT_PANEL__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_PANEL__CHILDREN = ABSTRACT_PANEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sash Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_PANEL__SASH_POSITION = ABSTRACT_PANEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_PANEL__DIRECTION = ABSTRACT_PANEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sash Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_PANEL_FEATURE_COUNT = ABSTRACT_PANEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPageImpl <em>Abstract Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPageImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getAbstractPage()
	 * @generated
	 */
	int ABSTRACT_PAGE = 9;

	/**
	 * The feature id for the '<em><b>Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PAGE__PAGE_IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Abstract Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PAGE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageListImpl <em>Page List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageListImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPageList()
	 * @generated
	 */
	int PAGE_LIST = 10;

	/**
	 * The feature id for the '<em><b>Available Page</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_LIST__AVAILABLE_PAGE = 0;

	/**
	 * The number of structural features of the '<em>Page List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl <em>Sash Windows Mngr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashWindowsMngr()
	 * @generated
	 */
	int SASH_WINDOWS_MNGR = 11;

	/**
	 * The feature id for the '<em><b>Page List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_WINDOWS_MNGR__PAGE_LIST = 0;

	/**
	 * The feature id for the '<em><b>Sash Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_WINDOWS_MNGR__SASH_MODEL = 1;

	/**
	 * The number of structural features of the '<em>Sash Windows Mngr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SASH_WINDOWS_MNGR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getint()
	 * @generated
	 */
	int INT = 12;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 13;

	/**
	 * The meta object id for the '<em>Float</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getFloat()
	 * @generated
	 */
	int FLOAT = 15;

	/**
	 * The meta object id for the '<em>boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getboolean()
	 * @generated
	 */
	int BOOLEAN = 14;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel <em>Sash Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sash Model</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashModel
	 * @generated
	 */
	EClass getSashModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getWindows <em>Windows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Windows</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getWindows()
	 * @see #getSashModel()
	 * @generated
	 */
	EReference getSashModel_Windows();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getCurrentSelection <em>Current Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Selection</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getCurrentSelection()
	 * @see #getSashModel()
	 * @generated
	 */
	EReference getSashModel_CurrentSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Position</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPosition()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Position();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Size</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Window#getSize()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Size();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Panel</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPanel()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Panel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent <em>Panel Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panel Parent</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent
	 * @generated
	 */
	EClass getPanelParent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent#getChildren()
	 * @see #getPanelParent()
	 * @generated
	 */
	EReference getPanelParent_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel <em>Abstract Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Panel</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel
	 * @generated
	 */
	EClass getAbstractPanel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent()
	 * @see #getAbstractPanel()
	 * @generated
	 */
	EReference getAbstractPanel_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Position
	 * @generated
	 */
	EClass getPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Position#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Position#getX()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Position#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Position#getY()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Size <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Size</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Size
	 * @generated
	 */
	EClass getSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Size#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Size#getWidth()
	 * @see #getSize()
	 * @generated
	 */
	EAttribute getSize_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Size#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.Size#getLength()
	 * @see #getSize()
	 * @generated
	 */
	EAttribute getSize_Length();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder <em>Tab Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab Folder</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder
	 * @generated
	 */
	EClass getTabFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder#getChildren()
	 * @see #getTabFolder()
	 * @generated
	 */
	EReference getTabFolder_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef <em>Page Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Ref</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef
	 * @generated
	 */
	EClass getPageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getEmfPageIdentifier <em>Emf Page Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emf Page Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getEmfPageIdentifier()
	 * @see #getPageRef()
	 * @generated
	 */
	EReference getPageRef_EmfPageIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getPageIdentifier <em>Page Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getPageIdentifier()
	 * @see #getPageRef()
	 * @generated
	 */
	EAttribute getPageRef_PageIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getObjectPageIdentifier <em>Object Page Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Page Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getObjectPageIdentifier()
	 * @see #getPageRef()
	 * @generated
	 */
	EAttribute getPageRef_ObjectPageIdentifier();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent()
	 * @see #getPageRef()
	 * @generated
	 */
	EReference getPageRef_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel <em>Sash Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sash Panel</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel
	 * @generated
	 */
	EClass getSashPanel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getSashPosition <em>Sash Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sash Position</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getSashPosition()
	 * @see #getSashPanel()
	 * @generated
	 */
	EAttribute getSashPanel_SashPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getDirection()
	 * @see #getSashPanel()
	 * @generated
	 */
	EAttribute getSashPanel_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage <em>Abstract Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Page</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage
	 * @generated
	 */
	EClass getAbstractPage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage#getPageIdentifier <em>Page Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage#getPageIdentifier()
	 * @see #getAbstractPage()
	 * @generated
	 */
	EAttribute getAbstractPage_PageIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageList <em>Page List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page List</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageList
	 * @generated
	 */
	EClass getPageList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageList#getAvailablePage <em>Available Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Page</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageList#getAvailablePage()
	 * @see #getPageList()
	 * @generated
	 */
	EReference getPageList_AvailablePage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr <em>Sash Windows Mngr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sash Windows Mngr</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr
	 * @generated
	 */
	EClass getSashWindowsMngr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getPageList <em>Page List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Page List</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getPageList()
	 * @see #getSashWindowsMngr()
	 * @generated
	 */
	EReference getSashWindowsMngr_PageList();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getSashModel <em>Sash Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sash Model</em>'.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getSashModel()
	 * @see #getSashWindowsMngr()
	 * @generated
	 */
	EReference getSashWindowsMngr_SashModel();

	/**
	 * Returns the meta object for data type '<em>int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>int</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getint();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaObject();

	/**
	 * Returns the meta object for data type '<em>Float</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float</em>'.
	 * @model instanceClass="float"
	 * @generated
	 */
	EDataType getFloat();

	/**
	 * Returns the meta object for data type '<em>boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>boolean</em>'.
	 * @model instanceClass="boolean"
	 * @generated
	 */
	EDataType getboolean();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiFactory getDiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl <em>Sash Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashModel()
		 * @generated
		 */
		EClass SASH_MODEL = eINSTANCE.getSashModel();

		/**
		 * The meta object literal for the '<em><b>Windows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SASH_MODEL__WINDOWS = eINSTANCE.getSashModel_Windows();

		/**
		 * The meta object literal for the '<em><b>Current Selection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SASH_MODEL__CURRENT_SELECTION = eINSTANCE.getSashModel_CurrentSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.WindowImpl <em>Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.WindowImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__POSITION = eINSTANCE.getWindow_Position();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__SIZE = eINSTANCE.getWindow_Size();

		/**
		 * The meta object literal for the '<em><b>Panel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__PANEL = eINSTANCE.getWindow_Panel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PanelParentImpl <em>Panel Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PanelParentImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPanelParent()
		 * @generated
		 */
		EClass PANEL_PARENT = eINSTANCE.getPanelParent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANEL_PARENT__CHILDREN = eINSTANCE.getPanelParent_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPanelImpl <em>Abstract Panel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPanelImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getAbstractPanel()
		 * @generated
		 */
		EClass ABSTRACT_PANEL = eINSTANCE.getAbstractPanel();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PANEL__PARENT = eINSTANCE.getAbstractPanel_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PositionImpl <em>Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PositionImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPosition()
		 * @generated
		 */
		EClass POSITION = eINSTANCE.getPosition();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__X = eINSTANCE.getPosition_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__Y = eINSTANCE.getPosition_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SizeImpl <em>Size</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SizeImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSize()
		 * @generated
		 */
		EClass SIZE = eINSTANCE.getSize();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIZE__WIDTH = eINSTANCE.getSize_Width();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIZE__LENGTH = eINSTANCE.getSize_Length();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.TabFolderImpl <em>Tab Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.TabFolderImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getTabFolder()
		 * @generated
		 */
		EClass TAB_FOLDER = eINSTANCE.getTabFolder();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAB_FOLDER__CHILDREN = eINSTANCE.getTabFolder_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl <em>Page Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageRefImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPageRef()
		 * @generated
		 */
		EClass PAGE_REF = eINSTANCE.getPageRef();

		/**
		 * The meta object literal for the '<em><b>Emf Page Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_REF__EMF_PAGE_IDENTIFIER = eINSTANCE.getPageRef_EmfPageIdentifier();

		/**
		 * The meta object literal for the '<em><b>Page Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_REF__PAGE_IDENTIFIER = eINSTANCE.getPageRef_PageIdentifier();

		/**
		 * The meta object literal for the '<em><b>Object Page Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_REF__OBJECT_PAGE_IDENTIFIER = eINSTANCE.getPageRef_ObjectPageIdentifier();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_REF__PARENT = eINSTANCE.getPageRef_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl <em>Sash Panel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashPanel()
		 * @generated
		 */
		EClass SASH_PANEL = eINSTANCE.getSashPanel();

		/**
		 * The meta object literal for the '<em><b>Sash Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SASH_PANEL__SASH_POSITION = eINSTANCE.getSashPanel_SashPosition();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SASH_PANEL__DIRECTION = eINSTANCE.getSashPanel_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPageImpl <em>Abstract Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPageImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getAbstractPage()
		 * @generated
		 */
		EClass ABSTRACT_PAGE = eINSTANCE.getAbstractPage();

		/**
		 * The meta object literal for the '<em><b>Page Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PAGE__PAGE_IDENTIFIER = eINSTANCE.getAbstractPage_PageIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageListImpl <em>Page List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.PageListImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getPageList()
		 * @generated
		 */
		EClass PAGE_LIST = eINSTANCE.getPageList();

		/**
		 * The meta object literal for the '<em><b>Available Page</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_LIST__AVAILABLE_PAGE = eINSTANCE.getPageList_AvailablePage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl <em>Sash Windows Mngr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashWindowsMngrImpl
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getSashWindowsMngr()
		 * @generated
		 */
		EClass SASH_WINDOWS_MNGR = eINSTANCE.getSashWindowsMngr();

		/**
		 * The meta object literal for the '<em><b>Page List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SASH_WINDOWS_MNGR__PAGE_LIST = eINSTANCE.getSashWindowsMngr_PageList();

		/**
		 * The meta object literal for the '<em><b>Sash Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SASH_WINDOWS_MNGR__SASH_MODEL = eINSTANCE.getSashWindowsMngr_SashModel();

		/**
		 * The meta object literal for the '<em>int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getint()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getint();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

		/**
		 * The meta object literal for the '<em>Float</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getFloat()
		 * @generated
		 */
		EDataType FLOAT = eINSTANCE.getFloat();

		/**
		 * The meta object literal for the '<em>boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiPackageImpl#getboolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getboolean();

	}

} //DiPackage
