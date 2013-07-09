/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ObjectIdAxis;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Id Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.ObjectIdAxisImpl#getLocalLabelConfiguration <em>Local Label Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectIdAxisImpl extends IdAxisImpl implements ObjectIdAxis {

	/**
	 * The cached value of the '{@link #getLocalLabelConfiguration() <em>Local Label Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ObjectLabelProviderConfiguration localLabelConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectIdAxisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisPackage.Literals.OBJECT_ID_AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectLabelProviderConfiguration getLocalLabelConfiguration() {
		return localLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalLabelConfiguration(ObjectLabelProviderConfiguration newLocalLabelConfiguration, NotificationChain msgs) {
		ObjectLabelProviderConfiguration oldLocalLabelConfiguration = localLabelConfiguration;
		localLabelConfiguration = newLocalLabelConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION, oldLocalLabelConfiguration, newLocalLabelConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalLabelConfiguration(ObjectLabelProviderConfiguration newLocalLabelConfiguration) {
		if (newLocalLabelConfiguration != localLabelConfiguration) {
			NotificationChain msgs = null;
			if (localLabelConfiguration != null)
				msgs = ((InternalEObject)localLabelConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION, null, msgs);
			if (newLocalLabelConfiguration != null)
				msgs = ((InternalEObject)newLocalLabelConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION, null, msgs);
			msgs = basicSetLocalLabelConfiguration(newLocalLabelConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION, newLocalLabelConfiguration, newLocalLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				return basicSetLocalLabelConfiguration(null, msgs);
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
			case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				return getLocalLabelConfiguration();
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
			case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((ObjectLabelProviderConfiguration)newValue);
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
			case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((ObjectLabelProviderConfiguration)null);
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
			case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				return localLabelConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ObjectAxis.class) {
			switch (derivedFeatureID) {
				case NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION: return NattableaxisPackage.OBJECT_AXIS__LOCAL_LABEL_CONFIGURATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ObjectAxis.class) {
			switch (baseFeatureID) {
				case NattableaxisPackage.OBJECT_AXIS__LOCAL_LABEL_CONFIGURATION: return NattableaxisPackage.OBJECT_ID_AXIS__LOCAL_LABEL_CONFIGURATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ObjectIdAxisImpl
