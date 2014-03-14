/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;
import org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureFrameworkImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl#getDefaultStakeholder <em>Default Stakeholder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusConfigurationImpl extends ArchitectureFrameworkImpl implements PapyrusConfiguration {
	/**
	 * The cached value of the '{@link #getDefaultStakeholder() <em>Default Stakeholder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStakeholder()
	 * @generated
	 * @ordered
	 */
	protected Stakeholder defaultStakeholder;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EPackage metamodel;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PAPYRUS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder getDefaultStakeholder() {
		if (defaultStakeholder != null && defaultStakeholder.eIsProxy()) {
			InternalEObject oldDefaultStakeholder = (InternalEObject)defaultStakeholder;
			defaultStakeholder = (Stakeholder)eResolveProxy(oldDefaultStakeholder);
			if (defaultStakeholder != oldDefaultStakeholder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER, oldDefaultStakeholder, defaultStakeholder));
			}
		}
		return defaultStakeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder basicGetDefaultStakeholder() {
		return defaultStakeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultStakeholder(Stakeholder newDefaultStakeholder) {
		Stakeholder oldDefaultStakeholder = defaultStakeholder;
		defaultStakeholder = newDefaultStakeholder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER, oldDefaultStakeholder, defaultStakeholder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetamodel() {
		if (metamodel != null && metamodel.eIsProxy()) {
			InternalEObject oldMetamodel = (InternalEObject)metamodel;
			metamodel = (EPackage)eResolveProxy(oldMetamodel);
			if (metamodel != oldMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL, oldMetamodel, metamodel));
			}
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(EPackage newMetamodel) {
		EPackage oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<Category>(Category.class, this, ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER:
				if (resolve) return getDefaultStakeholder();
				return basicGetDefaultStakeholder();
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL:
				if (resolve) return getMetamodel();
				return basicGetMetamodel();
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES:
				return getCategories();
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
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER:
				setDefaultStakeholder((Stakeholder)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL:
				setMetamodel((EPackage)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>)newValue);
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
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER:
				setDefaultStakeholder((Stakeholder)null);
				return;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL:
				setMetamodel((EPackage)null);
				return;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES:
				getCategories().clear();
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
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER:
				return defaultStakeholder != null;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__METAMODEL:
				return metamodel != null;
			case ConfigurationPackage.PAPYRUS_CONFIGURATION__CATEGORIES:
				return categories != null && !categories.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PapyrusConfigurationImpl
