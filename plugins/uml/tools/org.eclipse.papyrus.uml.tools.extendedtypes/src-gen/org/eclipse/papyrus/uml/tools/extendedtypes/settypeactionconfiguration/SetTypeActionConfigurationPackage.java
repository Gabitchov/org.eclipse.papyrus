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
package org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

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
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface SetTypeActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "settypeactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/uml/settypeaction/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "settypeactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SetTypeActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationImpl <em>Set Type Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationPackageImpl#getSetTypeActionConfiguration()
	 * @generated
	 */
	int SET_TYPE_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Valid Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__VALID_TYPES = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creation Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION__CREATION_TYPES = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Type Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration <em>Set Type Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type Action Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration
	 * @generated
	 */
	EClass getSetTypeActionConfiguration();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getValidTypes <em>Valid Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Valid Types</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getValidTypes()
	 * @see #getSetTypeActionConfiguration()
	 * @generated
	 */
	EAttribute getSetTypeActionConfiguration_ValidTypes();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getCreationTypes <em>Creation Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Creation Types</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getCreationTypes()
	 * @see #getSetTypeActionConfiguration()
	 * @generated
	 */
	EAttribute getSetTypeActionConfiguration_CreationTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SetTypeActionConfigurationFactory getSetTypeActionConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationImpl <em>Set Type Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl.SetTypeActionConfigurationPackageImpl#getSetTypeActionConfiguration()
		 * @generated
		 */
		EClass SET_TYPE_ACTION_CONFIGURATION = eINSTANCE.getSetTypeActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Valid Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TYPE_ACTION_CONFIGURATION__VALID_TYPES = eINSTANCE.getSetTypeActionConfiguration_ValidTypes();

		/**
		 * The meta object literal for the '<em><b>Creation Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TYPE_ACTION_CONFIGURATION__CREATION_TYPES = eINSTANCE.getSetTypeActionConfiguration_CreationTypes();

	}

} //SetTypeActionConfigurationPackage
