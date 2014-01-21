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
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.Tableconfiguration2Package;

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
 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusTableConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PapyrusTableConfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/PapyrusTableInstance/0.9.1/papyrustableconfiguration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PapyrusTableConfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusTableConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationPackageImpl#getPapyrusTableConfiguration()
	 * @generated
	 */
	int PAPYRUS_TABLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Table Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Columns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__DEFAULT_COLUMNS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Papyrus Table Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration <em>Papyrus Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration
	 * @generated
	 */
	EClass getPapyrusTableConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pasted Element Containment Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementContainmentFeature()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_PastedElementContainmentFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementId <em>Pasted Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Id</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementId()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EAttribute getPapyrusTableConfiguration_PastedElementId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getTableConfiguration()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_TableConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getDefaultColumns <em>Default Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Default Columns</em>'.
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getDefaultColumns()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_DefaultColumns();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusTableConfigurationFactory getPapyrusTableConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl
		 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationPackageImpl#getPapyrusTableConfiguration()
		 * @generated
		 */
		EClass PAPYRUS_TABLE_CONFIGURATION = eINSTANCE.getPapyrusTableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Containment Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE = eINSTANCE.getPapyrusTableConfiguration_PastedElementContainmentFeature();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID = eINSTANCE.getPapyrusTableConfiguration_PastedElementId();

		/**
		 * The meta object literal for the '<em><b>Table Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION = eINSTANCE.getPapyrusTableConfiguration_TableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Default Columns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__DEFAULT_COLUMNS = eINSTANCE.getPapyrusTableConfiguration_DefaultColumns();

	}

} //PapyrusTableConfigurationPackage
