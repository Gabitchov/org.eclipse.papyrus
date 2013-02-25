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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Content Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl#getJavaContentProviderIds <em>Java Content Provider Ids</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl#getAxis <em>Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultContentProviderImpl extends EModelElementImpl implements DefaultContentProvider {
	/**
	 * The cached value of the '{@link #getJavaContentProviderIds() <em>Java Content Provider Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaContentProviderIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> javaContentProviderIds;
	/**
	 * The cached value of the '{@link #getAxis() <em>Axis</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis()
	 * @generated
	 * @ordered
	 */
	protected EList<IAxis> axis;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultContentProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablecontentproviderPackage.Literals.DEFAULT_CONTENT_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getJavaContentProviderIds() {
		if (javaContentProviderIds == null) {
			javaContentProviderIds = new EDataTypeUniqueEList<String>(String.class, this, NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS);
		}
		return javaContentProviderIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAxis> getAxis() {
		if (axis == null) {
			axis = new EObjectContainmentEList<IAxis>(IAxis.class, this, NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS);
		}
		return axis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS:
				return ((InternalEList<?>)getAxis()).basicRemove(otherEnd, msgs);
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
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS:
				return getJavaContentProviderIds();
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS:
				return getAxis();
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
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS:
				getJavaContentProviderIds().clear();
				getJavaContentProviderIds().addAll((Collection<? extends String>)newValue);
				return;
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS:
				getAxis().clear();
				getAxis().addAll((Collection<? extends IAxis>)newValue);
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
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS:
				getJavaContentProviderIds().clear();
				return;
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS:
				getAxis().clear();
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
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS:
				return javaContentProviderIds != null && !javaContentProviderIds.isEmpty();
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER__AXIS:
				return axis != null && !axis.isEmpty();
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
		result.append(" (javaContentProviderIds: "); //$NON-NLS-1$
		result.append(javaContentProviderIds);
		result.append(')');
		return result.toString();
	}

} //DefaultContentProviderImpl
