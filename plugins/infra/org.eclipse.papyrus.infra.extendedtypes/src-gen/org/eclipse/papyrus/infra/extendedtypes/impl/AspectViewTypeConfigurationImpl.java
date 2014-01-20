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
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeAdviceConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect View Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.AspectViewTypeConfigurationImpl#getAdviceConfiguration <em>Advice Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AspectViewTypeConfigurationImpl extends ViewTypeConfigurationImpl implements AspectViewTypeConfiguration {

	/**
	 * The cached value of the '{@link #getAdviceConfiguration() <em>Advice Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdviceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected AspectViewTypeAdviceConfiguration adviceConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AspectViewTypeConfigurationImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getAspectViewTypeConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectViewTypeAdviceConfiguration getAdviceConfiguration() {
		return adviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAdviceConfiguration(AspectViewTypeAdviceConfiguration newAdviceConfiguration, NotificationChain msgs) {
		AspectViewTypeAdviceConfiguration oldAdviceConfiguration = adviceConfiguration;
		adviceConfiguration = newAdviceConfiguration;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION, oldAdviceConfiguration, newAdviceConfiguration);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdviceConfiguration(AspectViewTypeAdviceConfiguration newAdviceConfiguration) {
		if(newAdviceConfiguration != adviceConfiguration) {
			NotificationChain msgs = null;
			if(adviceConfiguration != null)
				msgs = ((InternalEObject)adviceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION, null, msgs);
			if(newAdviceConfiguration != null)
				msgs = ((InternalEObject)newAdviceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION, null, msgs);
			msgs = basicSetAdviceConfiguration(newAdviceConfiguration, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION, newAdviceConfiguration, newAdviceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return basicSetAdviceConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return getAdviceConfiguration();
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			setAdviceConfiguration((AspectViewTypeAdviceConfiguration)newValue);
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			setAdviceConfiguration((AspectViewTypeAdviceConfiguration)null);
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return adviceConfiguration != null;
		}
		return super.eIsSet(featureID);
	}
} //AspectViewTypeConfigurationImpl
