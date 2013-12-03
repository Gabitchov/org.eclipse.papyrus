/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualPropertyImpl#getVirtualMetaclass <em>Virtual Metaclass</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualPropertyImpl extends VirtualTypedElementImpl implements VirtualProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VirtualmetamodelPackage.Literals.VIRTUAL_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMetaclass getVirtualMetaclass() {
		if (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS) return null;
		return (VirtualMetaclass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVirtualMetaclass(VirtualMetaclass newVirtualMetaclass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVirtualMetaclass, VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualMetaclass(VirtualMetaclass newVirtualMetaclass) {
		if (newVirtualMetaclass != eInternalContainer() || (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS && newVirtualMetaclass != null)) {
			if (EcoreUtil.isAncestor(this, newVirtualMetaclass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVirtualMetaclass != null)
				msgs = ((InternalEObject)newVirtualMetaclass).eInverseAdd(this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES, VirtualMetaclass.class, msgs);
			msgs = basicSetVirtualMetaclass(newVirtualMetaclass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS, newVirtualMetaclass, newVirtualMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVirtualMetaclass((VirtualMetaclass)otherEnd, msgs);
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return basicSetVirtualMetaclass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return eInternalContainer().eInverseRemove(this, VirtualmetamodelPackage.VIRTUAL_METACLASS__PROPERTIES, VirtualMetaclass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return getVirtualMetaclass();
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				setVirtualMetaclass((VirtualMetaclass)newValue);
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				setVirtualMetaclass((VirtualMetaclass)null);
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
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY__VIRTUAL_METACLASS:
				return getVirtualMetaclass() != null;
		}
		return super.eIsSet(featureID);
	}

} //VirtualPropertyImpl
