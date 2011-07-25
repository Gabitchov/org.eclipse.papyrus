/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.constraints.ConstraintsPackage;

import org.eclipse.papyrus.newchild.NewchildPackage;

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
 * @see org.eclipse.papyrus.newchild.ncpolicy.NcpolicyFactory
 * @model kind="package"
 * @generated
 */
public interface NcpolicyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ncpolicy";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/newchild/policy";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ncpolicy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NcpolicyPackage eINSTANCE = org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl <em>New EMF Child Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewEMFChildMenu()
	 * @generated
	 */
	int NEW_EMF_CHILD_MENU = 0;

	/**
	 * The feature id for the '<em><b>Submenus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__SUBMENUS = NewchildPackage.MENU__SUBMENUS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__ID = NewchildPackage.MENU__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__NAME = NewchildPackage.MENU__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__ICON = NewchildPackage.MENU__ICON;

	/**
	 * The feature id for the '<em><b>Create In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__CREATE_IN = NewchildPackage.MENU_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__LAYOUT = NewchildPackage.MENU_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU__GROUPS = NewchildPackage.MENU_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>New EMF Child Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EMF_CHILD_MENU_FEATURE_COUNT = NewchildPackage.MENU_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl <em>New Child Policy Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewChildPolicySet()
	 * @generated
	 */
	int NEW_CHILD_POLICY_SET = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_SET__CONSTRAINTS = ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_SET__ELEMENT_MULTIPLICITY = ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_SET__NAME = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_SET__POLICIES = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Child Policy Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_SET_FEATURE_COUNT = ConstraintsPackage.DISPLAY_UNIT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicyImpl <em>New Child Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicyImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewChildPolicy()
	 * @generated
	 */
	int NEW_CHILD_POLICY = 2;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY__ROLES = 0;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY__ECLASSES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY__NAME = 2;

	/**
	 * The number of structural features of the '<em>New Child Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHILD_POLICY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.FilterPolicyImpl <em>Filter Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.FilterPolicyImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getFilterPolicy()
	 * @generated
	 */
	int FILTER_POLICY = 3;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_POLICY__ROLES = NEW_CHILD_POLICY__ROLES;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_POLICY__ECLASSES = NEW_CHILD_POLICY__ECLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_POLICY__NAME = NEW_CHILD_POLICY__NAME;

	/**
	 * The number of structural features of the '<em>Filter Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_POLICY_FEATURE_COUNT = NEW_CHILD_POLICY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.ReplacePolicyImpl <em>Replace Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.ReplacePolicyImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getReplacePolicy()
	 * @generated
	 */
	int REPLACE_POLICY = 4;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_POLICY__ROLES = NEW_CHILD_POLICY__ROLES;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_POLICY__ECLASSES = NEW_CHILD_POLICY__ECLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_POLICY__NAME = NEW_CHILD_POLICY__NAME;

	/**
	 * The feature id for the '<em><b>Replace With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_POLICY__REPLACE_WITH = NEW_CHILD_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replace Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_POLICY_FEATURE_COUNT = NEW_CHILD_POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.CustomPolicyImpl <em>Custom Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.CustomPolicyImpl
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getCustomPolicy()
	 * @generated
	 */
	int CUSTOM_POLICY = 5;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_POLICY__ROLES = NEW_CHILD_POLICY__ROLES;

	/**
	 * The feature id for the '<em><b>EClasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_POLICY__ECLASSES = NEW_CHILD_POLICY__ECLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_POLICY__NAME = NEW_CHILD_POLICY__NAME;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_POLICY__CLASS_NAME = NEW_CHILD_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_POLICY_FEATURE_COUNT = NEW_CHILD_POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.CreateIn <em>Create In</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.CreateIn
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getCreateIn()
	 * @generated
	 */
	int CREATE_IN = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.newchild.ncpolicy.Layout <em>Layout</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.newchild.ncpolicy.Layout
	 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu <em>New EMF Child Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New EMF Child Menu</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu
	 * @generated
	 */
	EClass getNewEMFChildMenu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getCreateIn <em>Create In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create In</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getCreateIn()
	 * @see #getNewEMFChildMenu()
	 * @generated
	 */
	EAttribute getNewEMFChildMenu_CreateIn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getLayout()
	 * @see #getNewEMFChildMenu()
	 * @generated
	 */
	EAttribute getNewEMFChildMenu_Layout();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewEMFChildMenu#getGroups()
	 * @see #getNewEMFChildMenu()
	 * @generated
	 */
	EReference getNewEMFChildMenu_Groups();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet <em>New Child Policy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Child Policy Set</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet
	 * @generated
	 */
	EClass getNewChildPolicySet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet#getName()
	 * @see #getNewChildPolicySet()
	 * @generated
	 */
	EAttribute getNewChildPolicySet_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policies</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet#getPolicies()
	 * @see #getNewChildPolicySet()
	 * @generated
	 */
	EReference getNewChildPolicySet_Policies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy <em>New Child Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Child Policy</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy
	 * @generated
	 */
	EClass getNewChildPolicy();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Roles</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getRoles()
	 * @see #getNewChildPolicy()
	 * @generated
	 */
	EAttribute getNewChildPolicy_Roles();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getEClasses <em>EClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EClasses</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getEClasses()
	 * @see #getNewChildPolicy()
	 * @generated
	 */
	EReference getNewChildPolicy_EClasses();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy#getName()
	 * @see #getNewChildPolicy()
	 * @generated
	 */
	EAttribute getNewChildPolicy_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.FilterPolicy <em>Filter Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Policy</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.FilterPolicy
	 * @generated
	 */
	EClass getFilterPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy <em>Replace Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace Policy</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy
	 * @generated
	 */
	EClass getReplacePolicy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy#getReplaceWith <em>Replace With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Replace With</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy#getReplaceWith()
	 * @see #getReplacePolicy()
	 * @generated
	 */
	EReference getReplacePolicy_ReplaceWith();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.newchild.ncpolicy.CustomPolicy <em>Custom Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Policy</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.CustomPolicy
	 * @generated
	 */
	EClass getCustomPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.newchild.ncpolicy.CustomPolicy#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.CustomPolicy#getClassName()
	 * @see #getCustomPolicy()
	 * @generated
	 */
	EAttribute getCustomPolicy_ClassName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.newchild.ncpolicy.CreateIn <em>Create In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Create In</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.CreateIn
	 * @generated
	 */
	EEnum getCreateIn();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.newchild.ncpolicy.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.Layout
	 * @generated
	 */
	EEnum getLayout();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NcpolicyFactory getNcpolicyFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl <em>New EMF Child Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewEMFChildMenuImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewEMFChildMenu()
		 * @generated
		 */
		EClass NEW_EMF_CHILD_MENU = eINSTANCE.getNewEMFChildMenu();

		/**
		 * The meta object literal for the '<em><b>Create In</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_EMF_CHILD_MENU__CREATE_IN = eINSTANCE.getNewEMFChildMenu_CreateIn();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_EMF_CHILD_MENU__LAYOUT = eINSTANCE.getNewEMFChildMenu_Layout();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_EMF_CHILD_MENU__GROUPS = eINSTANCE.getNewEMFChildMenu_Groups();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl <em>New Child Policy Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicySetImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewChildPolicySet()
		 * @generated
		 */
		EClass NEW_CHILD_POLICY_SET = eINSTANCE.getNewChildPolicySet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_CHILD_POLICY_SET__NAME = eINSTANCE.getNewChildPolicySet_Name();

		/**
		 * The meta object literal for the '<em><b>Policies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_CHILD_POLICY_SET__POLICIES = eINSTANCE.getNewChildPolicySet_Policies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicyImpl <em>New Child Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NewChildPolicyImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getNewChildPolicy()
		 * @generated
		 */
		EClass NEW_CHILD_POLICY = eINSTANCE.getNewChildPolicy();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_CHILD_POLICY__ROLES = eINSTANCE.getNewChildPolicy_Roles();

		/**
		 * The meta object literal for the '<em><b>EClasses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_CHILD_POLICY__ECLASSES = eINSTANCE.getNewChildPolicy_EClasses();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_CHILD_POLICY__NAME = eINSTANCE.getNewChildPolicy_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.FilterPolicyImpl <em>Filter Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.FilterPolicyImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getFilterPolicy()
		 * @generated
		 */
		EClass FILTER_POLICY = eINSTANCE.getFilterPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.ReplacePolicyImpl <em>Replace Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.ReplacePolicyImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getReplacePolicy()
		 * @generated
		 */
		EClass REPLACE_POLICY = eINSTANCE.getReplacePolicy();

		/**
		 * The meta object literal for the '<em><b>Replace With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE_POLICY__REPLACE_WITH = eINSTANCE.getReplacePolicy_ReplaceWith();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.impl.CustomPolicyImpl <em>Custom Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.CustomPolicyImpl
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getCustomPolicy()
		 * @generated
		 */
		EClass CUSTOM_POLICY = eINSTANCE.getCustomPolicy();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_POLICY__CLASS_NAME = eINSTANCE.getCustomPolicy_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.CreateIn <em>Create In</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.CreateIn
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getCreateIn()
		 * @generated
		 */
		EEnum CREATE_IN = eINSTANCE.getCreateIn();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.newchild.ncpolicy.Layout <em>Layout</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.newchild.ncpolicy.Layout
		 * @see org.eclipse.papyrus.newchild.ncpolicy.impl.NcpolicyPackageImpl#getLayout()
		 * @generated
		 */
		EEnum LAYOUT = eINSTANCE.getLayout();

	}

} //NcpolicyPackage
