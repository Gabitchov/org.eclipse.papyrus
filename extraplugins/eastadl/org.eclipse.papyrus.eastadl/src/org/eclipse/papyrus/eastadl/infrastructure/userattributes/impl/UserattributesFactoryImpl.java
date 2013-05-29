/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesFactory;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UserattributesFactoryImpl extends EFactoryImpl implements UserattributesFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UserattributesPackage getPackage() {
		return UserattributesPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserattributesFactory init() {
		try {
			UserattributesFactory theUserattributesFactory = (UserattributesFactory)EPackage.Registry.INSTANCE.getEFactory(UserattributesPackage.eNS_URI);
			if (theUserattributesFactory != null) {
				return theUserattributesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UserattributesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserattributesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE: return createUserAttributeElementType();
			case UserattributesPackage.USER_ATTRIBUTE_DEFINITION: return createUserAttributeDefinition();
			case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT: return createUserAttributeableElement();
			case UserattributesPackage.USER_ATTRIBUTE_VALUE: return createUserAttributeValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAttributeDefinition createUserAttributeDefinition() {
		UserAttributeDefinitionImpl userAttributeDefinition = new UserAttributeDefinitionImpl();
		return userAttributeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAttributeableElement createUserAttributeableElement() {
		UserAttributeableElementImpl userAttributeableElement = new UserAttributeableElementImpl();
		return userAttributeableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAttributeElementType createUserAttributeElementType() {
		UserAttributeElementTypeImpl userAttributeElementType = new UserAttributeElementTypeImpl();
		return userAttributeElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAttributeValue createUserAttributeValue() {
		UserAttributeValueImpl userAttributeValue = new UserAttributeValueImpl();
		return userAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserattributesPackage getUserattributesPackage() {
		return (UserattributesPackage)getEPackage();
	}

} //UserattributesFactoryImpl
