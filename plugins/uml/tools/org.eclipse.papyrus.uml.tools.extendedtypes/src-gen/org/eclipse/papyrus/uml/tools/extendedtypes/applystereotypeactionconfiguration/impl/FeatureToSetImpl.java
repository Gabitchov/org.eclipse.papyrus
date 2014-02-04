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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature To Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl#isAtRuntime <em>At Runtime</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureToSetImpl extends EObjectImpl implements FeatureToSet {
	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isAtRuntime() <em>At Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAtRuntime()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AT_RUNTIME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAtRuntime() <em>At Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAtRuntime()
	 * @generated
	 * @ordered
	 */
	protected boolean atRuntime = AT_RUNTIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected FeatureValue value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureToSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplyStereotypeActionConfigurationPackage.Literals.FEATURE_TO_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAtRuntime() {
		return atRuntime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtRuntime(boolean newAtRuntime) {
		boolean oldAtRuntime = atRuntime;
		atRuntime = newAtRuntime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__AT_RUNTIME, oldAtRuntime, atRuntime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureValue getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(FeatureValue newValue, NotificationChain msgs) {
		FeatureValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(FeatureValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE:
				return basicSetValue(null, msgs);
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
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__FEATURE_NAME:
				return getFeatureName();
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__AT_RUNTIME:
				return isAtRuntime();
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE:
				return getValue();
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
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__AT_RUNTIME:
				setAtRuntime((Boolean)newValue);
				return;
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE:
				setValue((FeatureValue)newValue);
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
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__AT_RUNTIME:
				setAtRuntime(AT_RUNTIME_EDEFAULT);
				return;
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE:
				setValue((FeatureValue)null);
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
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__AT_RUNTIME:
				return atRuntime != AT_RUNTIME_EDEFAULT;
			case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(", atRuntime: ");
		result.append(atRuntime);
		result.append(')');
		return result.toString();
	}

} //FeatureToSetImpl
