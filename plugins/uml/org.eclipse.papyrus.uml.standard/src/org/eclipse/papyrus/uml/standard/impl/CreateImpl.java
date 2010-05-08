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
import org.eclipse.papyrus.uml.standard.Create;
import org.eclipse.papyrus.uml.standard.StandardPackage;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Usage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Create</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.standard.impl.CreateImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.standard.impl.CreateImpl#getBase_Usage <em>Base Usage</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateImpl extends EObjectImpl implements Create {

	/**
	 * The cached value of the '{@link #getBase_BehavioralFeature() <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature base_BehavioralFeature;

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
	protected CreateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.CREATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehavioralFeature getBase_BehavioralFeature() {
		if(base_BehavioralFeature != null && base_BehavioralFeature.eIsProxy()) {
			InternalEObject oldBase_BehavioralFeature = (InternalEObject)base_BehavioralFeature;
			base_BehavioralFeature = (BehavioralFeature)eResolveProxy(oldBase_BehavioralFeature);
			if(base_BehavioralFeature != oldBase_BehavioralFeature) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
			}
		}
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehavioralFeature basicGetBase_BehavioralFeature() {
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_BehavioralFeature(BehavioralFeature newBase_BehavioralFeature) {
		BehavioralFeature oldBase_BehavioralFeature = base_BehavioralFeature;
		base_BehavioralFeature = newBase_BehavioralFeature;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.CREATE__BASE_USAGE, oldBase_Usage, base_Usage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.CREATE__BASE_USAGE, oldBase_Usage, base_Usage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE:
			if(resolve)
				return getBase_BehavioralFeature();
			return basicGetBase_BehavioralFeature();
		case StandardPackage.CREATE__BASE_USAGE:
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
		case StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE:
			setBase_BehavioralFeature((BehavioralFeature)newValue);
			return;
		case StandardPackage.CREATE__BASE_USAGE:
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
		case StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE:
			setBase_BehavioralFeature((BehavioralFeature)null);
			return;
		case StandardPackage.CREATE__BASE_USAGE:
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
		case StandardPackage.CREATE__BASE_BEHAVIORAL_FEATURE:
			return base_BehavioralFeature != null;
		case StandardPackage.CREATE__BASE_USAGE:
			return base_Usage != null;
		}
		return super.eIsSet(featureID);
	}

} // CreateImpl
