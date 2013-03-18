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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractAxisConfigurationImpl#getLabelConfiguration <em>Label Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractAxisConfigurationImpl extends EModelElementImpl implements AbstractAxisConfiguration {
	/**
	 * The cached value of the '{@link #getLabelConfiguration() <em>Label Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ILabelConfiguration labelConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractAxisConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.ABSTRACT_AXIS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabelConfiguration getLabelConfiguration() {
		return labelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabelConfiguration(ILabelConfiguration newLabelConfiguration, NotificationChain msgs) {
		ILabelConfiguration oldLabelConfiguration = labelConfiguration;
		labelConfiguration = newLabelConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION, oldLabelConfiguration, newLabelConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelConfiguration(ILabelConfiguration newLabelConfiguration) {
		if (newLabelConfiguration != labelConfiguration) {
			NotificationChain msgs = null;
			if (labelConfiguration != null)
				msgs = ((InternalEObject)labelConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION, null, msgs);
			if (newLabelConfiguration != null)
				msgs = ((InternalEObject)newLabelConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION, null, msgs);
			msgs = basicSetLabelConfiguration(newLabelConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION, newLabelConfiguration, newLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION:
				return basicSetLabelConfiguration(null, msgs);
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
			case NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION:
				return getLabelConfiguration();
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
			case NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION:
				setLabelConfiguration((ILabelConfiguration)newValue);
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
			case NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION:
				setLabelConfiguration((ILabelConfiguration)null);
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
			case NattableaxisconfigurationPackage.ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION:
				return labelConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractAxisConfigurationImpl
