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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;


import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getPastedElementTypeId <em>Pasted Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getDefaultVerticalContentProvider <em>Default Vertical Content Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl#getDefaultHorizontalContentProvider <em>Default Horizontal Content Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableEditorConfigurationImpl extends EModelElementImpl implements TableEditorConfiguration {
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
	 * The cached value of the '{@link #getDefaultVerticalContentProvider() <em>Default Vertical Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultVerticalContentProvider()
	 * @generated
	 * @ordered
	 */
	protected IAxisContentsProvider defaultVerticalContentProvider;

	/**
	 * The cached value of the '{@link #getDefaultHorizontalContentProvider() <em>Default Horizontal Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHorizontalContentProvider()
	 * @generated
	 * @ordered
	 */
	protected IAxisContentsProvider defaultHorizontalContentProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableEditorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableconfigurationPackage.Literals.TABLE_EDITOR_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID, oldPastedElementTypeId, pastedElementTypeId));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE, oldPastedElementContainmentFeature, pastedElementContainmentFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAxisContentsProvider getDefaultVerticalContentProvider() {
		return defaultVerticalContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultVerticalContentProvider(IAxisContentsProvider newDefaultVerticalContentProvider, NotificationChain msgs) {
		IAxisContentsProvider oldDefaultVerticalContentProvider = defaultVerticalContentProvider;
		defaultVerticalContentProvider = newDefaultVerticalContentProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER, oldDefaultVerticalContentProvider, newDefaultVerticalContentProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultVerticalContentProvider(IAxisContentsProvider newDefaultVerticalContentProvider) {
		if (newDefaultVerticalContentProvider != defaultVerticalContentProvider) {
			NotificationChain msgs = null;
			if (defaultVerticalContentProvider != null)
				msgs = ((InternalEObject)defaultVerticalContentProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER, null, msgs);
			if (newDefaultVerticalContentProvider != null)
				msgs = ((InternalEObject)newDefaultVerticalContentProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER, null, msgs);
			msgs = basicSetDefaultVerticalContentProvider(newDefaultVerticalContentProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER, newDefaultVerticalContentProvider, newDefaultVerticalContentProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAxisContentsProvider getDefaultHorizontalContentProvider() {
		return defaultHorizontalContentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultHorizontalContentProvider(IAxisContentsProvider newDefaultHorizontalContentProvider, NotificationChain msgs) {
		IAxisContentsProvider oldDefaultHorizontalContentProvider = defaultHorizontalContentProvider;
		defaultHorizontalContentProvider = newDefaultHorizontalContentProvider;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER, oldDefaultHorizontalContentProvider, newDefaultHorizontalContentProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultHorizontalContentProvider(IAxisContentsProvider newDefaultHorizontalContentProvider) {
		if (newDefaultHorizontalContentProvider != defaultHorizontalContentProvider) {
			NotificationChain msgs = null;
			if (defaultHorizontalContentProvider != null)
				msgs = ((InternalEObject)defaultHorizontalContentProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER, null, msgs);
			if (newDefaultHorizontalContentProvider != null)
				msgs = ((InternalEObject)newDefaultHorizontalContentProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER, null, msgs);
			msgs = basicSetDefaultHorizontalContentProvider(newDefaultHorizontalContentProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER, newDefaultHorizontalContentProvider, newDefaultHorizontalContentProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER:
				return basicSetDefaultVerticalContentProvider(null, msgs);
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER:
				return basicSetDefaultHorizontalContentProvider(null, msgs);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID:
				return getPastedElementTypeId();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				if (resolve) return getPastedElementContainmentFeature();
				return basicGetPastedElementContainmentFeature();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER:
				return getDefaultVerticalContentProvider();
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER:
				return getDefaultHorizontalContentProvider();
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID:
				setPastedElementTypeId((String)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER:
				setDefaultVerticalContentProvider((IAxisContentsProvider)newValue);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER:
				setDefaultHorizontalContentProvider((IAxisContentsProvider)newValue);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID:
				setPastedElementTypeId(PASTED_ELEMENT_TYPE_ID_EDEFAULT);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				setPastedElementContainmentFeature((EReference)null);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER:
				setDefaultVerticalContentProvider((IAxisContentsProvider)null);
				return;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER:
				setDefaultHorizontalContentProvider((IAxisContentsProvider)null);
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
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID:
				return PASTED_ELEMENT_TYPE_ID_EDEFAULT == null ? pastedElementTypeId != null : !PASTED_ELEMENT_TYPE_ID_EDEFAULT.equals(pastedElementTypeId);
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE:
				return pastedElementContainmentFeature != null;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER:
				return defaultVerticalContentProvider != null;
			case NattableconfigurationPackage.TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER:
				return defaultHorizontalContentProvider != null;
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
		result.append(" (pastedElementTypeId: "); //$NON-NLS-1$
		result.append(pastedElementTypeId);
		result.append(')');
		return result.toString();
	}

} //TableEditorConfigurationImpl
