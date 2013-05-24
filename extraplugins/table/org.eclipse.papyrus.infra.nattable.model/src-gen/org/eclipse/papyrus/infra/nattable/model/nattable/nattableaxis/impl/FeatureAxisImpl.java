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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.FeatureAxisImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.FeatureAxisImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.FeatureAxisImpl#getLocalLabelConfiguration <em>Local Label Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureAxisImpl extends MinimalEObjectImpl.Container implements FeatureAxis {
	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected AxisManagerRepresentation manager;

	/**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected String alias = ALIAS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalLabelConfiguration() <em>Local Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected FeatureLabelProviderConfiguration localLabelConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureAxisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisPackage.Literals.FEATURE_AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisManagerRepresentation getManager() {
		if (manager != null && manager.eIsProxy()) {
			InternalEObject oldManager = (InternalEObject)manager;
			manager = (AxisManagerRepresentation)eResolveProxy(oldManager);
			if (manager != oldManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisPackage.FEATURE_AXIS__MANAGER, oldManager, manager));
			}
		}
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisManagerRepresentation basicGetManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(AxisManagerRepresentation newManager) {
		AxisManagerRepresentation oldManager = manager;
		manager = newManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisPackage.FEATURE_AXIS__MANAGER, oldManager, manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisPackage.FEATURE_AXIS__ALIAS, oldAlias, alias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLabelProviderConfiguration getLocalLabelConfiguration() {
		if (localLabelConfiguration != null && localLabelConfiguration.eIsProxy()) {
			InternalEObject oldLocalLabelConfiguration = (InternalEObject)localLabelConfiguration;
			localLabelConfiguration = (FeatureLabelProviderConfiguration)eResolveProxy(oldLocalLabelConfiguration);
			if (localLabelConfiguration != oldLocalLabelConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION, oldLocalLabelConfiguration, localLabelConfiguration));
			}
		}
		return localLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLabelProviderConfiguration basicGetLocalLabelConfiguration() {
		return localLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalLabelConfiguration(FeatureLabelProviderConfiguration newLocalLabelConfiguration) {
		FeatureLabelProviderConfiguration oldLocalLabelConfiguration = localLabelConfiguration;
		localLabelConfiguration = newLocalLabelConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION, oldLocalLabelConfiguration, localLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisPackage.FEATURE_AXIS__MANAGER:
				if (resolve) return getManager();
				return basicGetManager();
			case NattableaxisPackage.FEATURE_AXIS__ALIAS:
				return getAlias();
			case NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION:
				if (resolve) return getLocalLabelConfiguration();
				return basicGetLocalLabelConfiguration();
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
			case NattableaxisPackage.FEATURE_AXIS__MANAGER:
				setManager((AxisManagerRepresentation)newValue);
				return;
			case NattableaxisPackage.FEATURE_AXIS__ALIAS:
				setAlias((String)newValue);
				return;
			case NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((FeatureLabelProviderConfiguration)newValue);
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
			case NattableaxisPackage.FEATURE_AXIS__MANAGER:
				setManager((AxisManagerRepresentation)null);
				return;
			case NattableaxisPackage.FEATURE_AXIS__ALIAS:
				setAlias(ALIAS_EDEFAULT);
				return;
			case NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((FeatureLabelProviderConfiguration)null);
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
			case NattableaxisPackage.FEATURE_AXIS__MANAGER:
				return manager != null;
			case NattableaxisPackage.FEATURE_AXIS__ALIAS:
				return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
			case NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case NattableaxisPackage.FEATURE_AXIS___GET_ELEMENT:
				return getElement();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (alias: "); //$NON-NLS-1$
		result.append(alias);
		result.append(')');
		return result.toString();
	}

} //FeatureAxisImpl
