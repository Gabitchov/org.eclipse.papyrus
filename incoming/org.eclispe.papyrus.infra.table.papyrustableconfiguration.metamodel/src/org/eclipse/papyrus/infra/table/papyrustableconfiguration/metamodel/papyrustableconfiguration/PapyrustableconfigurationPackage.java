/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableconfigurationPackage;

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
 * <!-- begin-model-doc -->
 * This package contains the model used in Papyrus to configure a PapyrusTableInstance2
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrustableconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrustableconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/PapyrusTableConfiguration/0.9.0/papyrustableconfiguration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.papyrus.infra.table.papyrustableconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustableconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getPapyrusTableConfiguration()
	 * @generated
	 */
	int PAPYRUS_TABLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Default Local Customizations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__DEFAULT_LOCAL_CUSTOMIZATIONS = TableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_LOCAL_CUSTOMIZATIONS;

	/**
	 * The feature id for the '<em><b>Can Be Presented In The Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__CAN_BE_PRESENTED_IN_THE_TABLE = TableconfigurationPackage.TABLE_CONFIGURATION__CAN_BE_PRESENTED_IN_THE_TABLE;

	/**
	 * The feature id for the '<em><b>Forced Cell Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__FORCED_CELL_EDITORS = TableconfigurationPackage.TABLE_CONFIGURATION__FORCED_CELL_EDITORS;

	/**
	 * The feature id for the '<em><b>Default Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__DEFAULT_FACETS = TableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_FACETS;

	/**
	 * The feature id for the '<em><b>Default Customizations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__DEFAULT_CUSTOMIZATIONS = TableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_CUSTOMIZATIONS;

	/**
	 * The feature id for the '<em><b>Instantiation Method</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__INSTANTIATION_METHOD = TableconfigurationPackage.TABLE_CONFIGURATION__INSTANTIATION_METHOD;

	/**
	 * The feature id for the '<em><b>Default Columns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__DEFAULT_COLUMNS = TableconfigurationPackage.TABLE_CONFIGURATION__DEFAULT_COLUMNS;

	/**
	 * The feature id for the '<em><b>Filling Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE = TableconfigurationPackage.TABLE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filling Queries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES = TableconfigurationPackage.TABLE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Listen Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__LISTEN_FEATURE = TableconfigurationPackage.TABLE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Papyrus Table Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION_FEATURE_COUNT = TableconfigurationPackage.TABLE_CONFIGURATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration <em>Papyrus Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration
	 * @generated
	 */
	EClass getPapyrusTableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingMode <em>Filling Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filling Mode</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingMode()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EAttribute getPapyrusTableConfiguration_FillingMode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingQueries <em>Filling Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filling Queries</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingQueries()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_FillingQueries();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenFeature <em>Listen Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listen Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenFeature()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_ListenFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrustableconfigurationFactory getPapyrustableconfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl
		 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getPapyrusTableConfiguration()
		 * @generated
		 */
		EClass PAPYRUS_TABLE_CONFIGURATION = eINSTANCE.getPapyrusTableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Filling Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE = eINSTANCE.getPapyrusTableConfiguration_FillingMode();

		/**
		 * The meta object literal for the '<em><b>Filling Queries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES = eINSTANCE.getPapyrusTableConfiguration_FillingQueries();

		/**
		 * The meta object literal for the '<em><b>Listen Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__LISTEN_FEATURE = eINSTANCE.getPapyrusTableConfiguration_ListenFeature();

	}

} //PapyrustableconfigurationPackage
