/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotML.Algorithm;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl#getBase_Transition <em>Base Transition</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {

	/**
	 * The cached value of the '{@link #getBase_Transition() <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Transition()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Transition base_Transition;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Algorithm guard;

	/**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected Algorithm effect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Transition getBase_Transition() {
		if(base_Transition != null && base_Transition.eIsProxy()) {
			InternalEObject oldBase_Transition = (InternalEObject)base_Transition;
			base_Transition = (org.eclipse.uml2.uml.Transition)eResolveProxy(oldBase_Transition);
			if(base_Transition != oldBase_Transition) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.TRANSITION__BASE_TRANSITION, oldBase_Transition, base_Transition));
			}
		}
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Transition basicGetBase_Transition() {
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Transition(org.eclipse.uml2.uml.Transition newBase_Transition) {
		org.eclipse.uml2.uml.Transition oldBase_Transition = base_Transition;
		base_Transition = newBase_Transition;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.TRANSITION__BASE_TRANSITION, oldBase_Transition, base_Transition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm getGuard() {
		if(guard != null && guard.eIsProxy()) {
			InternalEObject oldGuard = (InternalEObject)guard;
			guard = (Algorithm)eResolveProxy(oldGuard);
			if(guard != oldGuard) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.TRANSITION__GUARD, oldGuard, guard));
			}
		}
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm basicGetGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGuard(Algorithm newGuard) {
		Algorithm oldGuard = guard;
		guard = newGuard;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.TRANSITION__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm getEffect() {
		if(effect != null && effect.eIsProxy()) {
			InternalEObject oldEffect = (InternalEObject)effect;
			effect = (Algorithm)eResolveProxy(oldEffect);
			if(effect != oldEffect) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.TRANSITION__EFFECT, oldEffect, effect));
			}
		}
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm basicGetEffect() {
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEffect(Algorithm newEffect) {
		Algorithm oldEffect = effect;
		effect = newEffect;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.TRANSITION__EFFECT, oldEffect, effect));
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
		case RobotMLPackage.TRANSITION__BASE_TRANSITION:
			if(resolve)
				return getBase_Transition();
			return basicGetBase_Transition();
		case RobotMLPackage.TRANSITION__GUARD:
			if(resolve)
				return getGuard();
			return basicGetGuard();
		case RobotMLPackage.TRANSITION__EFFECT:
			if(resolve)
				return getEffect();
			return basicGetEffect();
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case RobotMLPackage.TRANSITION__BASE_TRANSITION:
			setBase_Transition((org.eclipse.uml2.uml.Transition)newValue);
			return;
		case RobotMLPackage.TRANSITION__GUARD:
			setGuard((Algorithm)newValue);
			return;
		case RobotMLPackage.TRANSITION__EFFECT:
			setEffect((Algorithm)newValue);
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
	public void eUnset(int featureID) {
		switch(featureID) {
		case RobotMLPackage.TRANSITION__BASE_TRANSITION:
			setBase_Transition((org.eclipse.uml2.uml.Transition)null);
			return;
		case RobotMLPackage.TRANSITION__GUARD:
			setGuard((Algorithm)null);
			return;
		case RobotMLPackage.TRANSITION__EFFECT:
			setEffect((Algorithm)null);
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
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case RobotMLPackage.TRANSITION__BASE_TRANSITION:
			return base_Transition != null;
		case RobotMLPackage.TRANSITION__GUARD:
			return guard != null;
		case RobotMLPackage.TRANSITION__EFFECT:
			return effect != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
