/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.FCM.ExtendedSignature;
import org.eclipse.papyrus.FCM.FCMPackage;

import org.eclipse.uml2.uml.TemplateSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl#getBase_TemplateSignature <em>Base Template Signature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl#getBaseSignature <em>Base Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedSignatureImpl extends EObjectImpl implements ExtendedSignature {
	/**
	 * The cached value of the '{@link #getBase_TemplateSignature() <em>Base Template Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignature base_TemplateSignature;

	/**
	 * The cached value of the '{@link #getBaseSignature() <em>Base Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignature baseSignature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.EXTENDED_SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature getBase_TemplateSignature() {
		if (base_TemplateSignature != null && base_TemplateSignature.eIsProxy()) {
			InternalEObject oldBase_TemplateSignature = (InternalEObject)base_TemplateSignature;
			base_TemplateSignature = (TemplateSignature)eResolveProxy(oldBase_TemplateSignature);
			if (base_TemplateSignature != oldBase_TemplateSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE, oldBase_TemplateSignature, base_TemplateSignature));
			}
		}
		return base_TemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature basicGetBase_TemplateSignature() {
		return base_TemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_TemplateSignature(TemplateSignature newBase_TemplateSignature) {
		TemplateSignature oldBase_TemplateSignature = base_TemplateSignature;
		base_TemplateSignature = newBase_TemplateSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE, oldBase_TemplateSignature, base_TemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature getBaseSignature() {
		if (baseSignature != null && baseSignature.eIsProxy()) {
			InternalEObject oldBaseSignature = (InternalEObject)baseSignature;
			baseSignature = (TemplateSignature)eResolveProxy(oldBaseSignature);
			if (baseSignature != oldBaseSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE, oldBaseSignature, baseSignature));
			}
		}
		return baseSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature basicGetBaseSignature() {
		return baseSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseSignature(TemplateSignature newBaseSignature) {
		TemplateSignature oldBaseSignature = baseSignature;
		baseSignature = newBaseSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE, oldBaseSignature, baseSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				if (resolve) return getBase_TemplateSignature();
				return basicGetBase_TemplateSignature();
			case FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE:
				if (resolve) return getBaseSignature();
				return basicGetBaseSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				setBase_TemplateSignature((TemplateSignature)newValue);
				return;
			case FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE:
				setBaseSignature((TemplateSignature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				setBase_TemplateSignature((TemplateSignature)null);
				return;
			case FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE:
				setBaseSignature((TemplateSignature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FCMPackage.EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				return base_TemplateSignature != null;
			case FCMPackage.EXTENDED_SIGNATURE__BASE_SIGNATURE:
				return baseSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtendedSignatureImpl
