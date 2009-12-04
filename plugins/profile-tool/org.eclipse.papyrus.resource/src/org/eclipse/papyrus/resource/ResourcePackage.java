/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.resource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.resource.ResourceFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcePackage extends EPackage {

	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "resource";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyurs/0.7.0/Resource";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "resource";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ResourcePackage eINSTANCE = org.eclipse.papyrus.resource.impl.ResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.resource.impl.ResourceImpl
	 * <em>Resource</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.resource.impl.ResourceImpl
	 * @see org.eclipse.papyrus.resource.impl.ResourcePackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Eobjects</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE__EOBJECTS = 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.resource.impl.ResourceEObjectImpl
	 * <em>EObject</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.resource.impl.ResourceEObjectImpl
	 * @see org.eclipse.papyrus.resource.impl.ResourcePackageImpl#getResourceEObject()
	 * @generated
	 */
	int RESOURCE_EOBJECT = 1;

	/**
	 * The number of structural features of the '<em>EObject</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EOBJECT_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.resource.Resource
	 * <em>Resource</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.papyrus.resource.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.resource.Resource#getEobjects <em>Eobjects</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Eobjects</em>'.
	 * @see org.eclipse.papyrus.resource.Resource#getEobjects()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Eobjects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.resource.ResourceEObject
	 * <em>EObject</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EObject</em>'.
	 * @see org.eclipse.papyrus.resource.ResourceEObject
	 * @generated
	 */
	EClass getResourceEObject();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceFactory getResourceFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.resource.impl.ResourceImpl
		 * <em>Resource</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.resource.impl.ResourceImpl
		 * @see org.eclipse.papyrus.resource.impl.ResourcePackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Eobjects</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RESOURCE__EOBJECTS = eINSTANCE.getResource_Eobjects();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.resource.impl.ResourceEObjectImpl <em>EObject</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.resource.impl.ResourceEObjectImpl
		 * @see org.eclipse.papyrus.resource.impl.ResourcePackageImpl#getResourceEObject()
		 * @generated
		 */
		EClass RESOURCE_EOBJECT = eINSTANCE.getResourceEObject();

	}

} // ResourcePackage
