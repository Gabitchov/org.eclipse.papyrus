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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDomain;
import org.eclipse.uml2.uml.Namespace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDomainImpl#getBase_Namespace <em>Base Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedDomainImpl extends EObjectImpl implements TimedDomain {
	/**
	 * The cached value of the '{@link #getBase_Namespace() <em>Base Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Namespace()
	 * @generated
	 * @ordered
	 */
	protected Namespace base_Namespace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.TIMED_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace getBase_Namespace() {
		if (base_Namespace != null && base_Namespace.eIsProxy()) {
			InternalEObject oldBase_Namespace = (InternalEObject)base_Namespace;
			base_Namespace = (Namespace)eResolveProxy(oldBase_Namespace);
			if (base_Namespace != oldBase_Namespace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.TIMED_DOMAIN__BASE_NAMESPACE, oldBase_Namespace, base_Namespace));
			}
		}
		return base_Namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace basicGetBase_Namespace() {
		return base_Namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Namespace(Namespace newBase_Namespace) {
		Namespace oldBase_Namespace = base_Namespace;
		base_Namespace = newBase_Namespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_DOMAIN__BASE_NAMESPACE, oldBase_Namespace, base_Namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.TIMED_DOMAIN__BASE_NAMESPACE:
				if (resolve) return getBase_Namespace();
				return basicGetBase_Namespace();
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
			case TimePackage.TIMED_DOMAIN__BASE_NAMESPACE:
				setBase_Namespace((Namespace)newValue);
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
			case TimePackage.TIMED_DOMAIN__BASE_NAMESPACE:
				setBase_Namespace((Namespace)null);
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
			case TimePackage.TIMED_DOMAIN__BASE_NAMESPACE:
				return base_Namespace != null;
		}
		return super.eIsSet(featureID);
	}

} //TimedDomainImpl
