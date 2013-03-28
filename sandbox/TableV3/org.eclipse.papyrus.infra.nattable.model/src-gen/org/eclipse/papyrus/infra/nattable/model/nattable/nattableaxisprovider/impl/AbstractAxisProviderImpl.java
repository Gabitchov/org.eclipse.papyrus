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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Axis Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl#getJavaAxisManagerIds <em>Java Axis Manager Ids</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl#getAxisConfiguration <em>Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl#getPastedElementTypeId <em>Pasted Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractAxisProviderImpl extends EModelElementImpl implements AbstractAxisProvider {
	/**
	 * The cached value of the '{@link #getJavaAxisManagerIds() <em>Java Axis Manager Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaAxisManagerIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> javaAxisManagerIds;

	/**
	 * The cached value of the '{@link #getAxisConfiguration() <em>Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected AbstractAxisConfiguration axisConfiguration;

	/**
	 * The default value of the '{@link #getPastedElementTypeId() <em>Pasted Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String PASTED_ELEMENT_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPastedElementTypeId() <em>Pasted Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementTypeId()
	 * @generated
	 * @ordered
	 */
	protected String pastedElementTypeId = PASTED_ELEMENT_TYPE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPastedElementContainmentFeature() <em>Pasted Element Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementContainmentFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference pastedElementContainmentFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractAxisProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisproviderPackage.Literals.ABSTRACT_AXIS_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getJavaAxisManagerIds() {
		if (javaAxisManagerIds == null) {
			javaAxisManagerIds = new EDataTypeUniqueEList<String>(String.class, this, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS);
		}
		return javaAxisManagerIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAxisConfiguration getAxisConfiguration() {
		return axisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAxisConfiguration(AbstractAxisConfiguration newAxisConfiguration, NotificationChain msgs) {
		AbstractAxisConfiguration oldAxisConfiguration = axisConfiguration;
		axisConfiguration = newAxisConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION, oldAxisConfiguration, newAxisConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisConfiguration(AbstractAxisConfiguration newAxisConfiguration) {
		if (newAxisConfiguration != axisConfiguration) {
			NotificationChain msgs = null;
			if (axisConfiguration != null)
				msgs = ((InternalEObject)axisConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION, null, msgs);
			if (newAxisConfiguration != null)
				msgs = ((InternalEObject)newAxisConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION, null, msgs);
			msgs = basicSetAxisConfiguration(newAxisConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION, newAxisConfiguration, newAxisConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPastedElementTypeId() {
		return pastedElementTypeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPastedElementTypeId(String newPastedElementTypeId) {
		String oldPastedElementTypeId = pastedElementTypeId;
		pastedElementTypeId = newPastedElementTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID, oldPastedElementTypeId, pastedElementTypeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPastedElementContainmentFeature() {
		if (pastedElementContainmentFeature != null && pastedElementContainmentFeature.eIsProxy()) {
			InternalEObject oldPastedElementContainmentFeature = (InternalEObject)pastedElementContainmentFeature;
			pastedElementContainmentFeature = (EReference)eResolveProxy(oldPastedElementContainmentFeature);
			if (pastedElementContainmentFeature != oldPastedElementContainmentFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
			}
		}
		return pastedElementContainmentFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetPastedElementContainmentFeature() {
		return pastedElementContainmentFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPastedElementContainmentFeature(EReference newPastedElementContainmentFeature) {
		EReference oldPastedElementContainmentFeature = pastedElementContainmentFeature;
		pastedElementContainmentFeature = newPastedElementContainmentFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAxis> getAxis() {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION:
				return basicSetAxisConfiguration(null, msgs);
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
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS:
				return getJavaAxisManagerIds();
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION:
				return getAxisConfiguration();
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID:
				return getPastedElementTypeId();
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				if (resolve) return getPastedElementContainmentFeature();
				return basicGetPastedElementContainmentFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS:
				getJavaAxisManagerIds().clear();
				getJavaAxisManagerIds().addAll((Collection<? extends String>)newValue);
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION:
				setAxisConfiguration((AbstractAxisConfiguration)newValue);
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID:
				setPastedElementTypeId((String)newValue);
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)newValue);
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
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS:
				getJavaAxisManagerIds().clear();
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION:
				setAxisConfiguration((AbstractAxisConfiguration)null);
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID:
				setPastedElementTypeId(PASTED_ELEMENT_TYPE_ID_EDEFAULT);
				return;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)null);
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
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS:
				return javaAxisManagerIds != null && !javaAxisManagerIds.isEmpty();
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION:
				return axisConfiguration != null;
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID:
				return PASTED_ELEMENT_TYPE_ID_EDEFAULT == null ? pastedElementTypeId != null : !PASTED_ELEMENT_TYPE_ID_EDEFAULT.equals(pastedElementTypeId);
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				return pastedElementContainmentFeature != null;
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
			case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER___GET_AXIS:
				return getAxis();
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
		result.append(" (javaAxisManagerIds: "); //$NON-NLS-1$
		result.append(javaAxisManagerIds);
		result.append(", pastedElementTypeId: "); //$NON-NLS-1$
		result.append(pastedElementTypeId);
		result.append(')');
		return result.toString();
	}

} //AbstractAxisProviderImpl
