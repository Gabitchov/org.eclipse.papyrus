/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

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
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface InvariantContainerConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "invariantcontainerconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/semantictype/invariant/container/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "invariantcontainerconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantContainerConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationImpl <em>Invariant Container Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationPackageImpl#getInvariantContainerConfiguration()
	 * @generated
	 */
	int INVARIANT_CONTAINER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invariant Container Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CONTAINER_CONFIGURATION_FEATURE_COUNT = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Invariant Container Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CONTAINER_CONFIGURATION_OPERATION_COUNT = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl <em>Hierarchy Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationPackageImpl#getHierarchyPermission()
	 * @generated
	 */
	int HIERARCHY_PERMISSION = 1;

	/**
	 * The feature id for the '<em><b>Child Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIERARCHY_PERMISSION__CHILD_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Is Permitted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIERARCHY_PERMISSION__IS_PERMITTED = 1;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIERARCHY_PERMISSION__IS_STRICT = 2;

	/**
	 * The number of structural features of the '<em>Hierarchy Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIERARCHY_PERMISSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Hierarchy Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIERARCHY_PERMISSION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration <em>Invariant Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Container Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration
	 * @generated
	 */
	EClass getInvariantContainerConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permissions</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration#getPermissions()
	 * @see #getInvariantContainerConfiguration()
	 * @generated
	 */
	EReference getInvariantContainerConfiguration_Permissions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission <em>Hierarchy Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hierarchy Permission</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission
	 * @generated
	 */
	EClass getHierarchyPermission();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#getChildType <em>Child Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Child Type</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#getChildType()
	 * @see #getHierarchyPermission()
	 * @generated
	 */
	EAttribute getHierarchyPermission_ChildType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsPermitted <em>Is Permitted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Permitted</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsPermitted()
	 * @see #getHierarchyPermission()
	 * @generated
	 */
	EAttribute getHierarchyPermission_IsPermitted();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsStrict()
	 * @see #getHierarchyPermission()
	 * @generated
	 */
	EAttribute getHierarchyPermission_IsStrict();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InvariantContainerConfigurationFactory getInvariantContainerConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationImpl <em>Invariant Container Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationPackageImpl#getInvariantContainerConfiguration()
		 * @generated
		 */
		EClass INVARIANT_CONTAINER_CONFIGURATION = eINSTANCE.getInvariantContainerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS = eINSTANCE.getInvariantContainerConfiguration_Permissions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl <em>Hierarchy Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationPackageImpl#getHierarchyPermission()
		 * @generated
		 */
		EClass HIERARCHY_PERMISSION = eINSTANCE.getHierarchyPermission();

		/**
		 * The meta object literal for the '<em><b>Child Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HIERARCHY_PERMISSION__CHILD_TYPE = eINSTANCE.getHierarchyPermission_ChildType();

		/**
		 * The meta object literal for the '<em><b>Is Permitted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HIERARCHY_PERMISSION__IS_PERMITTED = eINSTANCE.getHierarchyPermission_IsPermitted();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HIERARCHY_PERMISSION__IS_STRICT = eINSTANCE.getHierarchyPermission_IsStrict();

	}

} //InvariantContainerConfigurationPackage
