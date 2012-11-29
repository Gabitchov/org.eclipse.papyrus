/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl#getPastedElementId <em>Pasted Element Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl.PapyrusTableConfigurationImpl#getTableConfiguration <em>Table Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTableConfigurationImpl extends 
EModelElementImpl implements PapyrusTableConfiguration {
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
	 * The default value of the '{@link #getPastedElementId() <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementId()
	 * @generated
	 * @ordered
	 */
	protected static final String PASTED_ELEMENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPastedElementId() <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedElementId()
	 * @generated
	 * @ordered
	 */
	protected String pastedElementId = PASTED_ELEMENT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTableConfiguration() <em>Table Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableConfiguration2 tableConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusTableConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusTableConfigurationPackage.Literals.PAPYRUS_TABLE_CONFIGURATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPastedElementId() {
		return pastedElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPastedElementId(String newPastedElementId) {
		String oldPastedElementId = pastedElementId;
		pastedElementId = newPastedElementId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID, oldPastedElementId, pastedElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableConfiguration2 getTableConfiguration() {
		return tableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTableConfiguration(TableConfiguration2 newTableConfiguration, NotificationChain msgs) {
		TableConfiguration2 oldTableConfiguration = tableConfiguration;
		tableConfiguration = newTableConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, oldTableConfiguration, newTableConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableConfiguration(TableConfiguration2 newTableConfiguration) {
		if (newTableConfiguration != tableConfiguration) {
			NotificationChain msgs = null;
			if (tableConfiguration != null)
				msgs = ((InternalEObject)tableConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, null, msgs);
			if (newTableConfiguration != null)
				msgs = ((InternalEObject)newTableConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, null, msgs);
			msgs = basicSetTableConfiguration(newTableConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, newTableConfiguration, newTableConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				return basicSetTableConfiguration(null, msgs);
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
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				if (resolve) return getPastedElementContainmentFeature();
				return basicGetPastedElementContainmentFeature();
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID:
				return getPastedElementId();
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				return getTableConfiguration();
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
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)newValue);
				return;
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID:
				setPastedElementId((String)newValue);
				return;
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration2)newValue);
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
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)null);
				return;
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID:
				setPastedElementId(PASTED_ELEMENT_ID_EDEFAULT);
				return;
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration2)null);
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
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				return pastedElementContainmentFeature != null;
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID:
				return PASTED_ELEMENT_ID_EDEFAULT == null ? pastedElementId != null : !PASTED_ELEMENT_ID_EDEFAULT.equals(pastedElementId);
			case PapyrusTableConfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				return tableConfiguration != null;
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
		result.append(" (pastedElementId: ");
		result.append(pastedElementId);
		result.append(')');
		return result.toString();
	}

} //PapyrusTableConfigurationImpl
