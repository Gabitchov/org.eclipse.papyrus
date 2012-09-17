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
package org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl#getFillingMode <em>Filling Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl#getFillingQueries <em>Filling Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl#getListenContextFeature <em>Listen Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.impl.PapyrusTableConfigurationImpl#getTableConfiguration <em>Table Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTableConfigurationImpl extends EModelElementImpl implements PapyrusTableConfiguration {
	/**
	 * The default value of the '{@link #getFillingMode() <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingMode()
	 * @generated
	 * @ordered
	 */
	protected static final FillingMode FILLING_MODE_EDEFAULT = FillingMode.USER;

	/**
	 * The cached value of the '{@link #getFillingMode() <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingMode()
	 * @generated
	 * @ordered
	 */
	protected FillingMode fillingMode = FILLING_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFillingQueries() <em>Filling Queries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<Query> fillingQueries;

	/**
	 * The cached value of the '{@link #getListenContextFeature() <em>Listen Context Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenContextFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference listenContextFeature;

	/**
	 * The cached value of the '{@link #getTableConfiguration() <em>Table Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableConfiguration tableConfiguration;

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
		return PapyrustableconfigurationPackage.Literals.PAPYRUS_TABLE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillingMode getFillingMode() {
		return fillingMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillingMode(FillingMode newFillingMode) {
		FillingMode oldFillingMode = fillingMode;
		fillingMode = newFillingMode == null ? FILLING_MODE_EDEFAULT : newFillingMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE, oldFillingMode, fillingMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Query> getFillingQueries() {
		if (fillingQueries == null) {
			fillingQueries = new EObjectResolvingEList<Query>(Query.class, this, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES);
		}
		return fillingQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListenContextFeature() {
		if (listenContextFeature != null && listenContextFeature.eIsProxy()) {
			InternalEObject oldListenContextFeature = (InternalEObject)listenContextFeature;
			listenContextFeature = (EReference)eResolveProxy(oldListenContextFeature);
			if (listenContextFeature != oldListenContextFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE, oldListenContextFeature, listenContextFeature));
			}
		}
		return listenContextFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetListenContextFeature() {
		return listenContextFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListenContextFeature(EReference newListenContextFeature) {
		EReference oldListenContextFeature = listenContextFeature;
		listenContextFeature = newListenContextFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE, oldListenContextFeature, listenContextFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableConfiguration getTableConfiguration() {
		return tableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTableConfiguration(TableConfiguration newTableConfiguration, NotificationChain msgs) {
		TableConfiguration oldTableConfiguration = tableConfiguration;
		tableConfiguration = newTableConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, oldTableConfiguration, newTableConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableConfiguration(TableConfiguration newTableConfiguration) {
		if (newTableConfiguration != tableConfiguration) {
			NotificationChain msgs = null;
			if (tableConfiguration != null)
				msgs = ((InternalEObject)tableConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, null, msgs);
			if (newTableConfiguration != null)
				msgs = ((InternalEObject)newTableConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, null, msgs);
			msgs = basicSetTableConfiguration(newTableConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION, newTableConfiguration, newTableConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
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
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE:
				return getFillingMode();
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES:
				return getFillingQueries();
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE:
				if (resolve) return getListenContextFeature();
				return basicGetListenContextFeature();
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				return getTableConfiguration();
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
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE:
				setFillingMode((FillingMode)newValue);
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES:
				getFillingQueries().clear();
				getFillingQueries().addAll((Collection<? extends Query>)newValue);
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE:
				setListenContextFeature((EReference)newValue);
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration)newValue);
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
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE:
				setFillingMode(FILLING_MODE_EDEFAULT);
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES:
				getFillingQueries().clear();
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE:
				setListenContextFeature((EReference)null);
				return;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
				setTableConfiguration((TableConfiguration)null);
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
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_MODE:
				return fillingMode != FILLING_MODE_EDEFAULT;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__FILLING_QUERIES:
				return fillingQueries != null && !fillingQueries.isEmpty();
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__LISTEN_CONTEXT_FEATURE:
				return listenContextFeature != null;
			case PapyrustableconfigurationPackage.PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION:
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
		result.append(" (fillingMode: "); //$NON-NLS-1$
		result.append(fillingMode);
		result.append(')');
		return result.toString();
	}

} //PapyrusTableConfigurationImpl
