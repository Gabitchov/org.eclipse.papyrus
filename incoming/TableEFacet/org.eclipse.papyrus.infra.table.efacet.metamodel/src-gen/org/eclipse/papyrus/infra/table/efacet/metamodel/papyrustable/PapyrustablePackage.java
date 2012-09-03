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
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable;

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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This package contains the model used to store the Papyrus Table.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustableFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrustablePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrustable"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/PapyrusTable/0.9.0/papyrustable"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyrustable"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustablePackage eINSTANCE = org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrustablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl <em>Papyrus Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrustablePackageImpl#getPapyrusTable()
	 * @generated
	 */
	int PAPYRUS_TABLE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__TABLE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Filling Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__FILLING_MODE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__CONTEXT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__QUERIES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Using User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__USING_USER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Using Context Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__USING_CONTEXT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Using Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__USING_QUERIES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Papyrus Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode <em>Filling Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrustablePackageImpl#getFillingMode()
	 * @generated
	 */
	int FILLING_MODE = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable <em>Papyrus Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable
	 * @generated
	 */
	EClass getPapyrusTable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getName()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getType()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getTable()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EReference getPapyrusTable_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getFillingMode <em>Filling Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filling Mode</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getFillingMode()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_FillingMode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getContextFeature <em>Context Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getContextFeature()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EReference getPapyrusTable_ContextFeature();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Queries</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getQueries()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EReference getPapyrusTable_Queries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingUser <em>Using User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using User</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingUser()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_UsingUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingContextFeature <em>Using Context Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using Context Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingContextFeature()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_UsingContextFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingQueries <em>Using Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using Queries</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingQueries()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_UsingQueries();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode <em>Filling Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Filling Mode</em>'.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @generated
	 */
	EEnum getFillingMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrustableFactory getPapyrustableFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl <em>Papyrus Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrusTableImpl
		 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrustablePackageImpl#getPapyrusTable()
		 * @generated
		 */
		EClass PAPYRUS_TABLE = eINSTANCE.getPapyrusTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__NAME = eINSTANCE.getPapyrusTable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__TYPE = eINSTANCE.getPapyrusTable_Type();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE__TABLE = eINSTANCE.getPapyrusTable_Table();

		/**
		 * The meta object literal for the '<em><b>Filling Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__FILLING_MODE = eINSTANCE.getPapyrusTable_FillingMode();

		/**
		 * The meta object literal for the '<em><b>Context Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE__CONTEXT_FEATURE = eINSTANCE.getPapyrusTable_ContextFeature();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE__QUERIES = eINSTANCE.getPapyrusTable_Queries();

		/**
		 * The meta object literal for the '<em><b>Using User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__USING_USER = eINSTANCE.getPapyrusTable_UsingUser();

		/**
		 * The meta object literal for the '<em><b>Using Context Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__USING_CONTEXT_FEATURE = eINSTANCE.getPapyrusTable_UsingContextFeature();

		/**
		 * The meta object literal for the '<em><b>Using Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__USING_QUERIES = eINSTANCE.getPapyrusTable_UsingQueries();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode <em>Filling Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
		 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl.PapyrustablePackageImpl#getFillingMode()
		 * @generated
		 */
		EEnum FILLING_MODE = eINSTANCE.getFillingMode();

	}

} //PapyrustablePackage
