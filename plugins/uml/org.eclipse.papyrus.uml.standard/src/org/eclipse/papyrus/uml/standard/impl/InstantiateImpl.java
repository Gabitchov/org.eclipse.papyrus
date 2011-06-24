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
import org.eclipse.papyrus.uml.standard.Instantiate;
import org.eclipse.papyrus.uml.standard.StandardPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instantiate</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.standard.impl.InstantiateImpl#getBase_Usage <em>Base Usage</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InstantiateImpl extends EObjectImpl implements Instantiate {

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
	protected InstantiateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.INSTANTIATE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.INSTANTIATE__BASE_USAGE, oldBase_Usage, base_Usage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.INSTANTIATE__BASE_USAGE, oldBase_Usage, base_Usage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case StandardPackage.INSTANTIATE__BASE_USAGE:
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
		case StandardPackage.INSTANTIATE__BASE_USAGE:
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
		case StandardPackage.INSTANTIATE__BASE_USAGE:
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
		case StandardPackage.INSTANTIATE__BASE_USAGE:
			return base_Usage != null;
		}
		return super.eIsSet(featureID);
	}

} // InstantiateImpl
