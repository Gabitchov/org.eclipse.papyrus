/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.standard.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.uml.standard.Send;
import org.eclipse.papyrus.uml.standard.StandardPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Send</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.standard.impl.SendImpl#getBase_Usage <em>Base Usage</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SendImpl extends EObjectImpl implements Send {

	/**
	 * The cached value of the '{@link #getBase_Usage() <em>Base Usage</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Usage()
	 * @generated
	 * @ordered
	 */
	protected Usage base_Usage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SEND;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Usage getBase_Usage() {
		if(base_Usage != null && base_Usage.eIsProxy()) {
			InternalEObject oldBase_Usage = (InternalEObject)base_Usage;
			base_Usage = (Usage)eResolveProxy(oldBase_Usage);
			if(base_Usage != oldBase_Usage) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEND__BASE_USAGE, oldBase_Usage, base_Usage));
			}
		}
		return base_Usage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Usage basicGetBase_Usage() {
		return base_Usage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Usage(Usage newBase_Usage) {
		Usage oldBase_Usage = base_Usage;
		base_Usage = newBase_Usage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEND__BASE_USAGE, oldBase_Usage, base_Usage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case StandardPackage.SEND__BASE_USAGE:
			if(resolve)
				return getBase_Usage();
			return basicGetBase_Usage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case StandardPackage.SEND__BASE_USAGE:
			setBase_Usage((Usage)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case StandardPackage.SEND__BASE_USAGE:
			setBase_Usage((Usage)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case StandardPackage.SEND__BASE_USAGE:
			return base_Usage != null;
		}
		return super.eIsSet(featureID);
	}

} // SendImpl
