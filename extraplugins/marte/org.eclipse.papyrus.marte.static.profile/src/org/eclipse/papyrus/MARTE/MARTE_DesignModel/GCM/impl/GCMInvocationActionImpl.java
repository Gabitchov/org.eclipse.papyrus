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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InvocationAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl#getBase_InvocationAction <em>Base Invocation Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl#getOnFeature <em>On Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GCMInvocationActionImpl extends EObjectImpl implements GCMInvocationAction {
	/**
	 * The cached value of the '{@link #getBase_InvocationAction() <em>Base Invocation Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InvocationAction()
	 * @generated
	 * @ordered
	 */
	protected InvocationAction base_InvocationAction;

	/**
	 * The cached value of the '{@link #getOnFeature() <em>On Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature onFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GCMInvocationActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GCMPackage.Literals.GCM_INVOCATION_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction getBase_InvocationAction() {
		if (base_InvocationAction != null && base_InvocationAction.eIsProxy()) {
			InternalEObject oldBase_InvocationAction = (InternalEObject)base_InvocationAction;
			base_InvocationAction = (InvocationAction)eResolveProxy(oldBase_InvocationAction);
			if (base_InvocationAction != oldBase_InvocationAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
			}
		}
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction basicGetBase_InvocationAction() {
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InvocationAction(InvocationAction newBase_InvocationAction) {
		InvocationAction oldBase_InvocationAction = base_InvocationAction;
		base_InvocationAction = newBase_InvocationAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getOnFeature() {
		if (onFeature != null && onFeature.eIsProxy()) {
			InternalEObject oldOnFeature = (InternalEObject)onFeature;
			onFeature = (Feature)eResolveProxy(oldOnFeature);
			if (onFeature != oldOnFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE, oldOnFeature, onFeature));
			}
		}
		return onFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetOnFeature() {
		return onFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnFeature(Feature newOnFeature) {
		Feature oldOnFeature = onFeature;
		onFeature = newOnFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE, oldOnFeature, onFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION:
				if (resolve) return getBase_InvocationAction();
				return basicGetBase_InvocationAction();
			case GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE:
				if (resolve) return getOnFeature();
				return basicGetOnFeature();
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
			case GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)newValue);
				return;
			case GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE:
				setOnFeature((Feature)newValue);
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
			case GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)null);
				return;
			case GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE:
				setOnFeature((Feature)null);
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
			case GCMPackage.GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION:
				return base_InvocationAction != null;
			case GCMPackage.GCM_INVOCATION_ACTION__ON_FEATURE:
				return onFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //GCMInvocationActionImpl
