/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * <!-- begin-model-doc -->
 * This package contains the model used in Papyrus to configure a Papyrus EFacet Table
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationFactory
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
	String eNAME = "papyrustableconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/PapyrusTableConfiguration/0.9.0/papyrustableconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustableconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getPapyrusTableConfiguration()
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
	 * The feature id for the '<em><b>Fill Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__FILL_MODE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filling Queries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Listen Context Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Table Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pasted Element Containement Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINEMENT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Papyrus Table Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode <em>Fill Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getFillMode()
	 * @generated
	 */
	int FILL_MODE = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration <em>Papyrus Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration
	 * @generated
	 */
	EClass getPapyrusTableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillMode <em>Fill Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill Mode</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillMode()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EAttribute getPapyrusTableConfiguration_FillMode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingQueries <em>Filling Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filling Queries</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingQueries()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_FillingQueries();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenContextFeature <em>Listen Context Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listen Context Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenContextFeature()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_ListenContextFeature();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getTableConfiguration()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_TableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getPastedElementId <em>Pasted Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Id</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getPastedElementId()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EAttribute getPapyrusTableConfiguration_PastedElementId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getPastedElementContainementFeature <em>Pasted Element Containement Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pasted Element Containement Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getPastedElementContainementFeature()
	 * @see #getPapyrusTableConfiguration()
	 * @generated
	 */
	EReference getPapyrusTableConfiguration_PastedElementContainementFeature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode <em>Fill Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fill Mode</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode
	 * @generated
	 */
	EEnum getFillMode();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl <em>Papyrus Table Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl
		 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getPapyrusTableConfiguration()
		 * @generated
		 */
		EClass PAPYRUS_TABLE_CONFIGURATION = eINSTANCE.getPapyrusTableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Fill Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_CONFIGURATION__FILL_MODE = eINSTANCE.getPapyrusTableConfiguration_FillMode();

		/**
		 * The meta object literal for the '<em><b>Filling Queries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES = eINSTANCE.getPapyrusTableConfiguration_FillingQueries();

		/**
		 * The meta object literal for the '<em><b>Listen Context Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE = eINSTANCE.getPapyrusTableConfiguration_ListenContextFeature();

		/**
		 * The meta object literal for the '<em><b>Table Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION = eINSTANCE.getPapyrusTableConfiguration_TableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID = eINSTANCE.getPapyrusTableConfiguration_PastedElementId();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Containement Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINEMENT_FEATURE = eINSTANCE.getPapyrusTableConfiguration_PastedElementContainementFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode <em>Fill Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode
		 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrustableconfigurationPackageImpl#getFillMode()
		 * @generated
		 */
		EEnum FILL_MODE = eINSTANCE.getFillMode();

	}

} //PapyrustableconfigurationPackage
