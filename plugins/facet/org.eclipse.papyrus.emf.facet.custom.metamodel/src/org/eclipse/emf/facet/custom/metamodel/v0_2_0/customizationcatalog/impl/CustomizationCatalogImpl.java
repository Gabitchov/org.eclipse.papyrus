/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *   	Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationCatalog;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customization Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl#getInstalledEntries <em>Installed Entries</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomizationCatalogImpl extends EObjectImpl implements CustomizationCatalog {
	/**
	 * The cached value of the '{@link #getInstalledEntries() <em>Installed Entries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstalledEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> installedEntries;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomizationCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomizationcatalogPackage.Literals.CUSTOMIZATION_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getInstalledEntries() {
		if (installedEntries == null) {
			installedEntries = new EObjectResolvingEList<EObject>(EObject.class, this, CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES);
		}
		return installedEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES:
				return getInstalledEntries();
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__NAME:
				return getName();
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
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES:
				getInstalledEntries().clear();
				getInstalledEntries().addAll((Collection<? extends EObject>)newValue);
				return;
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__NAME:
				setName((String)newValue);
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
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES:
				getInstalledEntries().clear();
				return;
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__NAME:
				setName(NAME_EDEFAULT);
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
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES:
				return installedEntries != null && !installedEntries.isEmpty();
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CustomizationCatalogImpl
