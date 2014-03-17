/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureImpl#getExhibitedIn <em>Exhibited In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureImpl extends MinimalEObjectImpl.Container implements Architecture {
	/**
	 * The cached value of the '{@link #getExhibitedIn() <em>Exhibited In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExhibitedIn()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.papyrus.infra.viewpoints.iso42010.System exhibitedIn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System getExhibitedIn() {
		if (exhibitedIn != null && exhibitedIn.eIsProxy()) {
			InternalEObject oldExhibitedIn = (InternalEObject)exhibitedIn;
			exhibitedIn = (org.eclipse.papyrus.infra.viewpoints.iso42010.System)eResolveProxy(oldExhibitedIn);
			if (exhibitedIn != oldExhibitedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Iso42010Package.ARCHITECTURE__EXHIBITED_IN, oldExhibitedIn, exhibitedIn));
			}
		}
		return exhibitedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System basicGetExhibitedIn() {
		return exhibitedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExhibitedIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System newExhibitedIn, NotificationChain msgs) {
		org.eclipse.papyrus.infra.viewpoints.iso42010.System oldExhibitedIn = exhibitedIn;
		exhibitedIn = newExhibitedIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE__EXHIBITED_IN, oldExhibitedIn, newExhibitedIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExhibitedIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System newExhibitedIn) {
		if (newExhibitedIn != exhibitedIn) {
			NotificationChain msgs = null;
			if (exhibitedIn != null)
				msgs = ((InternalEObject)exhibitedIn).eInverseRemove(this, Iso42010Package.SYSTEM__EXHIBITS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
			if (newExhibitedIn != null)
				msgs = ((InternalEObject)newExhibitedIn).eInverseAdd(this, Iso42010Package.SYSTEM__EXHIBITS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
			msgs = basicSetExhibitedIn(newExhibitedIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE__EXHIBITED_IN, newExhibitedIn, newExhibitedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				if (exhibitedIn != null)
					msgs = ((InternalEObject)exhibitedIn).eInverseRemove(this, Iso42010Package.SYSTEM__EXHIBITS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
				return basicSetExhibitedIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				return basicSetExhibitedIn(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				if (resolve) return getExhibitedIn();
				return basicGetExhibitedIn();
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
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				setExhibitedIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)newValue);
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
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				setExhibitedIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)null);
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
			case Iso42010Package.ARCHITECTURE__EXHIBITED_IN:
				return exhibitedIn != null;
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureImpl
