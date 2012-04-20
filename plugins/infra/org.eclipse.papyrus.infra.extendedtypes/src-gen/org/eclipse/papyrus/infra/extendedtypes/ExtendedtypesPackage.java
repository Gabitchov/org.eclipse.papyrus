/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesFactory
 * @model kind="package"
 * @generated
 */
public interface ExtendedtypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extendedtypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/diagram/types/extendedtypes/0.7";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "extendedtypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtendedtypesPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl <em>Extended Element Type Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getExtendedElementTypeSet()
	 * @generated
	 */
	int EXTENDED_ELEMENT_TYPE_SET = 0;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__ID = 1;

	/**
	 * The number of structural features of the '<em>Extended Element Type Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl <em>Extended Element Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getExtendedElementTypeConfiguration()
	 * @generated
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID = 1;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT = 3;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME = 4;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = 5;

	/**
	 * The feature id for the '<em><b>Pre Validation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION = 6;

	/**
	 * The feature id for the '<em><b>Pre Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Post Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Specialized Diagram Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID = 9;

	/**
	 * The number of structural features of the '<em>Extended Element Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl <em>Icon Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getIconEntry()
	 * @generated
	 */
	int ICON_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__ICON_PATH = 0;

	/**
	 * The feature id for the '<em><b>Bundle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__BUNDLE_ID = 1;

	/**
	 * The number of structural features of the '<em>Icon Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl <em>Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getActionConfiguration()
	 * @generated
	 */
	int ACTION_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__ID = 1;

	/**
	 * The number of structural features of the '<em>Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.PreActionConfigurationImpl <em>Pre Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.PreActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getPreActionConfiguration()
	 * @generated
	 */
	int PRE_ACTION_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_ACTION_CONFIGURATION__LABEL = ACTION_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_ACTION_CONFIGURATION__ID = ACTION_CONFIGURATION__ID;

	/**
	 * The number of structural features of the '<em>Pre Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_ACTION_CONFIGURATION_FEATURE_COUNT = ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.PostActionConfigurationImpl <em>Post Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.PostActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getPostActionConfiguration()
	 * @generated
	 */
	int POST_ACTION_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_ACTION_CONFIGURATION__LABEL = ACTION_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_ACTION_CONFIGURATION__ID = ACTION_CONFIGURATION__ID;

	/**
	 * The number of structural features of the '<em>Post Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_ACTION_CONFIGURATION_FEATURE_COUNT = ACTION_CONFIGURATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet <em>Extended Element Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Element Type Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet
	 * @generated
	 */
	EClass getExtendedElementTypeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType()
	 * @see #getExtendedElementTypeSet()
	 * @generated
	 */
	EReference getExtendedElementTypeSet_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getId()
	 * @see #getExtendedElementTypeSet()
	 * @generated
	 */
	EAttribute getExtendedElementTypeSet_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration <em>Extended Element Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Element Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration
	 * @generated
	 */
	EClass getExtendedElementTypeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getName()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getId()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_Id();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getIconEntry()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EReference getExtendedElementTypeConfiguration_IconEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hint</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getHint()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_Hint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getKindName <em>Kind Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getKindName()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_KindName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedTypesID <em>Specialized Types ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Specialized Types ID</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedTypesID()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_SpecializedTypesID();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreValidation <em>Pre Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pre Validation</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreValidation()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EReference getExtendedElementTypeConfiguration_PreValidation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreAction <em>Pre Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pre Action</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreAction()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EReference getExtendedElementTypeConfiguration_PreAction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPostAction <em>Post Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Post Action</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPostAction()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EReference getExtendedElementTypeConfiguration_PostAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specialized Diagram Type ID</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedDiagramTypeID()
	 * @see #getExtendedElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getExtendedElementTypeConfiguration_SpecializedDiagramTypeID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry
	 * @generated
	 */
	EClass getIconEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_IconPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId <em>Bundle Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Id</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_BundleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration <em>Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration
	 * @generated
	 */
	EClass getActionConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getLabel()
	 * @see #getActionConfiguration()
	 * @generated
	 */
	EAttribute getActionConfiguration_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getId()
	 * @see #getActionConfiguration()
	 * @generated
	 */
	EAttribute getActionConfiguration_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration <em>Pre Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration
	 * @generated
	 */
	EClass getPreActionConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration <em>Post Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration
	 * @generated
	 */
	EClass getPostActionConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtendedtypesFactory getExtendedtypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl <em>Extended Element Type Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getExtendedElementTypeSet()
		 * @generated
		 */
		EClass EXTENDED_ELEMENT_TYPE_SET = eINSTANCE.getExtendedElementTypeSet();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE = eINSTANCE.getExtendedElementTypeSet_ElementType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_SET__ID = eINSTANCE.getExtendedElementTypeSet_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl <em>Extended Element Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getExtendedElementTypeConfiguration()
		 * @generated
		 */
		EClass EXTENDED_ELEMENT_TYPE_CONFIGURATION = eINSTANCE.getExtendedElementTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__NAME = eINSTANCE.getExtendedElementTypeConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__ID = eINSTANCE.getExtendedElementTypeConfiguration_Id();

		/**
		 * The meta object literal for the '<em><b>Icon Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY = eINSTANCE.getExtendedElementTypeConfiguration_IconEntry();

		/**
		 * The meta object literal for the '<em><b>Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__HINT = eINSTANCE.getExtendedElementTypeConfiguration_Hint();

		/**
		 * The meta object literal for the '<em><b>Kind Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__KIND_NAME = eINSTANCE.getExtendedElementTypeConfiguration_KindName();

		/**
		 * The meta object literal for the '<em><b>Specialized Types ID</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = eINSTANCE.getExtendedElementTypeConfiguration_SpecializedTypesID();

		/**
		 * The meta object literal for the '<em><b>Pre Validation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_VALIDATION = eINSTANCE.getExtendedElementTypeConfiguration_PreValidation();

		/**
		 * The meta object literal for the '<em><b>Pre Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ELEMENT_TYPE_CONFIGURATION__PRE_ACTION = eINSTANCE.getExtendedElementTypeConfiguration_PreAction();

		/**
		 * The meta object literal for the '<em><b>Post Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ELEMENT_TYPE_CONFIGURATION__POST_ACTION = eINSTANCE.getExtendedElementTypeConfiguration_PostAction();

		/**
		 * The meta object literal for the '<em><b>Specialized Diagram Type ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID = eINSTANCE.getExtendedElementTypeConfiguration_SpecializedDiagramTypeID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl <em>Icon Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getIconEntry()
		 * @generated
		 */
		EClass ICON_ENTRY = eINSTANCE.getIconEntry();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_ENTRY__ICON_PATH = eINSTANCE.getIconEntry_IconPath();

		/**
		 * The meta object literal for the '<em><b>Bundle Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_ENTRY__BUNDLE_ID = eINSTANCE.getIconEntry_BundleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl <em>Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getActionConfiguration()
		 * @generated
		 */
		EClass ACTION_CONFIGURATION = eINSTANCE.getActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_CONFIGURATION__LABEL = eINSTANCE.getActionConfiguration_Label();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_CONFIGURATION__ID = eINSTANCE.getActionConfiguration_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.PreActionConfigurationImpl <em>Pre Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.PreActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getPreActionConfiguration()
		 * @generated
		 */
		EClass PRE_ACTION_CONFIGURATION = eINSTANCE.getPreActionConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.PostActionConfigurationImpl <em>Post Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.PostActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getPostActionConfiguration()
		 * @generated
		 */
		EClass POST_ACTION_CONFIGURATION = eINSTANCE.getPostActionConfiguration();

	}

} //ExtendedtypesPackage
