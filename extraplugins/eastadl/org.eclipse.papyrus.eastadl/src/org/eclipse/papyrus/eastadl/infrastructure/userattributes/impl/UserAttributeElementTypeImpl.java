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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl#getExtendedElementType <em>Extended Element
 * Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl#getAttribute <em>Attribute</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl#getValidFor <em>Valid For</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UserAttributeElementTypeImpl extends EAElementImpl implements UserAttributeElementType {

	/**
	 * The cached value of the '{@link #getExtendedElementType() <em>Extended Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtendedElementType()
	 * @generated
	 * @ordered
	 */
	protected UserAttributeElementType extendedElementType;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<UserAttributeDefinition> attribute;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getValidFor() <em>Valid For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValidFor()
	 * @generated
	 * @ordered
	 */
	protected static final String VALID_FOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidFor() <em>Valid For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValidFor()
	 * @generated
	 * @ordered
	 */
	protected String validFor = VALID_FOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UserAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UserAttributeElementType basicGetExtendedElementType() {
		return extendedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE:
			if(resolve)
				return getExtendedElementType();
			return basicGetExtendedElementType();
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE:
			return getAttribute();
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR:
			return getValidFor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE:
			return extendedElementType != null;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE:
			return attribute != null && !attribute.isEmpty();
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS:
			return base_Class != null;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR:
			return VALID_FOR_EDEFAULT == null ? validFor != null : !VALID_FOR_EDEFAULT.equals(validFor);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE:
			setExtendedElementType((UserAttributeElementType)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE:
			getAttribute().clear();
			getAttribute().addAll((Collection<? extends UserAttributeDefinition>)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR:
			setValidFor((String)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UserattributesPackage.Literals.USER_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE:
			setExtendedElementType((UserAttributeElementType)null);
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE:
			getAttribute().clear();
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR:
			setValidFor(VALID_FOR_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UserAttributeDefinition> getAttribute() {
		if(attribute == null) {
			attribute = new EObjectResolvingEList<UserAttributeDefinition>(UserAttributeDefinition.class, this, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UserAttributeElementType getExtendedElementType() {
		if(extendedElementType != null && extendedElementType.eIsProxy()) {
			InternalEObject oldExtendedElementType = (InternalEObject)extendedElementType;
			extendedElementType = (UserAttributeElementType)eResolveProxy(oldExtendedElementType);
			if(extendedElementType != oldExtendedElementType) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE, oldExtendedElementType, extendedElementType));
			}
		}
		return extendedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getValidFor() {
		return validFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtendedElementType(UserAttributeElementType newExtendedElementType) {
		UserAttributeElementType oldExtendedElementType = extendedElementType;
		extendedElementType = newExtendedElementType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE, oldExtendedElementType, extendedElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValidFor(String newValidFor) {
		String oldValidFor = validFor;
		validFor = newValidFor;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserattributesPackage.USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR, oldValidFor, validFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (validFor: ");
		result.append(validFor);
		result.append(')');
		return result.toString();
	}

} //UserAttributeElementTypeImpl
