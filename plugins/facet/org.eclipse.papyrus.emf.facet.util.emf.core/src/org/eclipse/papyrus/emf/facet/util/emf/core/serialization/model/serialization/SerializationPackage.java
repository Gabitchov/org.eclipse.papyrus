/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.util.emf.core.serialization.model.serialization;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.papyrus.emf.facet.util.emf.core.serialization.model.serialization.SerializationFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("all")
public interface SerializationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "serialization"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/serialization/0.1.incubation"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "serialization"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializationPackage eINSTANCE = org.eclipse.papyrus.emf.facet.util.emf.core.serialization.model.serialization.impl.SerializationPackageImpl.init();

	/**
	 * The meta object id for the '<em>Extensible Serializable Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.papyrus.emf.facet.util.emf.core.serialization.model.serialization.impl.SerializationPackageImpl#getExtensibleSerializableJavaObject()
	 * @generated
	 */
	int EXTENSIBLE_SERIALIZABLE_JAVA_OBJECT = 0;


	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Extensible Serializable Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Extensible Serializable Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getExtensibleSerializableJavaObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SerializationFactory getSerializationFactory();

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
		 * The meta object literal for the '<em>Extensible Serializable Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.papyrus.emf.facet.util.emf.core.serialization.model.serialization.impl.SerializationPackageImpl#getExtensibleSerializableJavaObject()
		 * @generated
		 */
		EDataType EXTENSIBLE_SERIALIZABLE_JAVA_OBJECT = SerializationPackage.eINSTANCE.getExtensibleSerializableJavaObject();

	}

} //SerializationPackage
