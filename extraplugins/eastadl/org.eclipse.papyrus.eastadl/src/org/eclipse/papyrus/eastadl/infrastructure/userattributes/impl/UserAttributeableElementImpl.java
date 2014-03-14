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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Attributeable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl#getUaValue <em>Ua Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl#getUaType <em>Ua Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl#getAttributedElement <em>Attributed Element
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl#getBase_NamedElement <em>Base Named Element
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UserAttributeableElementImpl extends EObjectImpl implements UserAttributeableElement {

	/**
	 * The cached value of the '{@link #getUaValue() <em>Ua Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUaValue()
	 * @generated
	 * @ordered
	 */
	protected EList<UserAttributeValue> uaValue;

	/**
	 * The cached value of the '{@link #getUaType() <em>Ua Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUaType()
	 * @generated
	 * @ordered
	 */
	protected EList<UserAttributeElementType> uaType;

	/**
	 * The cached value of the '{@link #getAttributedElement() <em>Attributed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAttributedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement attributedElement;

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UserAttributeableElementImpl() {
		super();
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
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE:
			return getUaValue();
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE:
			return getUaType();
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT:
			if(resolve)
				return getAttributedElement();
			return basicGetAttributedElement();
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT:
			if(resolve)
				return getBase_NamedElement();
			return basicGetBase_NamedElement();
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
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE:
			return uaValue != null && !uaValue.isEmpty();
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE:
			return uaType != null && !uaType.isEmpty();
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT:
			return attributedElement != null;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT:
			return base_NamedElement != null;
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
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE:
			getUaValue().clear();
			getUaValue().addAll((Collection<? extends UserAttributeValue>)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE:
			getUaType().clear();
			getUaType().addAll((Collection<? extends UserAttributeElementType>)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT:
			setAttributedElement((NamedElement)newValue);
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)newValue);
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
		return UserattributesPackage.Literals.USER_ATTRIBUTEABLE_ELEMENT;
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
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE:
			getUaValue().clear();
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE:
			getUaType().clear();
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT:
			setAttributedElement((NamedElement)null);
			return;
		case UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)null);
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
	public EList<UserAttributeElementType> getUaType() {
		if(uaType == null) {
			uaType = new EObjectResolvingEList<UserAttributeElementType>(UserAttributeElementType.class, this, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE);
		}
		return uaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getAttributedElement() {
		if(attributedElement != null && attributedElement.eIsProxy()) {
			InternalEObject oldAttributedElement = (InternalEObject)attributedElement;
			attributedElement = (NamedElement)eResolveProxy(oldAttributedElement);
			if(attributedElement != oldAttributedElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT, oldAttributedElement, attributedElement));
			}
		}
		return attributedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetAttributedElement() {
		return attributedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAttributedElement(NamedElement newAttributedElement) {
		NamedElement oldAttributedElement = attributedElement;
		attributedElement = newAttributedElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT, oldAttributedElement, attributedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if(base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if(base_NamedElement != oldBase_NamedElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UserAttributeValue> getUaValue() {
		if(uaValue == null) {
			uaValue = new EObjectResolvingEList<UserAttributeValue>(UserAttributeValue.class, this, UserattributesPackage.USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE);
		}
		return uaValue;
	}

} //UserAttributeableElementImpl
