/*****************************************************************************
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade;

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
 * @see org.eclipse.papyrus.facade.FacadeFactory
 * @model kind="package"
 * @generated
 */
public interface FacadePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "facade";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/facade";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "facade";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FacadePackage eINSTANCE = org.eclipse.papyrus.facade.impl.FacadePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.impl.FacadeImpl <em>Facade</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.impl.FacadeImpl
	 * @see org.eclipse.papyrus.facade.impl.FacadePackageImpl#getFacade()
	 * @generated
	 */
	int FACADE = 0;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE__EXTENSION_DEFINITIONS = 0;

	/**
	 * The feature id for the '<em><b>Virtualmetamodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE__VIRTUALMETAMODEL = 1;

	/**
	 * The number of structural features of the '<em>Facade</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Facade</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.Facade <em>Facade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facade</em>'.
	 * @see org.eclipse.papyrus.facade.Facade
	 * @generated
	 */
	EClass getFacade();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.Facade#getExtensionDefinitions <em>Extension Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension Definitions</em>'.
	 * @see org.eclipse.papyrus.facade.Facade#getExtensionDefinitions()
	 * @see #getFacade()
	 * @generated
	 */
	EReference getFacade_ExtensionDefinitions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.facade.Facade#getVirtualmetamodel <em>Virtualmetamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Virtualmetamodel</em>'.
	 * @see org.eclipse.papyrus.facade.Facade#getVirtualmetamodel()
	 * @see #getFacade()
	 * @generated
	 */
	EReference getFacade_Virtualmetamodel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FacadeFactory getFacadeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.impl.FacadeImpl <em>Facade</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.impl.FacadeImpl
		 * @see org.eclipse.papyrus.facade.impl.FacadePackageImpl#getFacade()
		 * @generated
		 */
		EClass FACADE = eINSTANCE.getFacade();

		/**
		 * The meta object literal for the '<em><b>Extension Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACADE__EXTENSION_DEFINITIONS = eINSTANCE.getFacade_ExtensionDefinitions();

		/**
		 * The meta object literal for the '<em><b>Virtualmetamodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACADE__VIRTUALMETAMODEL = eINSTANCE.getFacade_Virtualmetamodel();

	}

} //FacadePackage
