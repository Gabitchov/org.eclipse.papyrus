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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getModelRules <em>Model Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getOwningRules <em>Owning Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getImplementationID <em>Implementation ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusViewImpl extends ModelKindImpl implements PapyrusView {
	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected PapyrusView parent;
	/**
	 * The cached value of the '{@link #getProfiles() <em>Profiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfiles()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> profiles;
	/**
	 * The cached value of the '{@link #getModelRules() <em>Model Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelRule> modelRules;
	/**
	 * The cached value of the '{@link #getOwningRules() <em>Owning Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningRules()
	 * @generated
	 * @ordered
	 */
	protected EList<OwningRule> owningRules;

	/**
	 * The default value of the '{@link #getImplementationID() <em>Implementation ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationID()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getImplementationID() <em>Implementation ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationID()
	 * @generated
	 * @ordered
	 */
	protected String implementationID = IMPLEMENTATION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' reference list.
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
	protected PapyrusViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PAPYRUS_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_VIEW__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusView getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (PapyrusView)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.PAPYRUS_VIEW__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusView basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(PapyrusView newParent) {
		PapyrusView oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_VIEW__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getProfiles() {
		if (profiles == null) {
			profiles = new EObjectResolvingEList<EPackage>(EPackage.class, this, ConfigurationPackage.PAPYRUS_VIEW__PROFILES);
		}
		return profiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelRule> getModelRules() {
		if (modelRules == null) {
			modelRules = new EObjectContainmentEList<ModelRule>(ModelRule.class, this, ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES);
		}
		return modelRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OwningRule> getOwningRules() {
		if (owningRules == null) {
			owningRules = new EObjectContainmentEList<OwningRule>(OwningRule.class, this, ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES);
		}
		return owningRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationID() {
		return implementationID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationID(String newImplementationID) {
		String oldImplementationID = implementationID;
		implementationID = newImplementationID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID, oldImplementationID, implementationID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectResolvingEList<Category>(Category.class, this, ConfigurationPackage.PAPYRUS_VIEW__CATEGORIES);
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
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
				return ((InternalEList<?>)getModelRules()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				return ((InternalEList<?>)getOwningRules()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.PAPYRUS_VIEW__ICON:
				return getIcon();
			case ConfigurationPackage.PAPYRUS_VIEW__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConfigurationPackage.PAPYRUS_VIEW__PROFILES:
				return getProfiles();
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
				return getModelRules();
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				return getOwningRules();
			case ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID:
				return getImplementationID();
			case ConfigurationPackage.PAPYRUS_VIEW__CATEGORIES:
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
			case ConfigurationPackage.PAPYRUS_VIEW__ICON:
				setIcon((String)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__PARENT:
				setParent((PapyrusView)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__PROFILES:
				getProfiles().clear();
				getProfiles().addAll((Collection<? extends EPackage>)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
				getModelRules().clear();
				getModelRules().addAll((Collection<? extends ModelRule>)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				getOwningRules().clear();
				getOwningRules().addAll((Collection<? extends OwningRule>)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID:
				setImplementationID((String)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__CATEGORIES:
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
			case ConfigurationPackage.PAPYRUS_VIEW__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__PARENT:
				setParent((PapyrusView)null);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__PROFILES:
				getProfiles().clear();
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
				getModelRules().clear();
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				getOwningRules().clear();
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID:
				setImplementationID(IMPLEMENTATION_ID_EDEFAULT);
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__CATEGORIES:
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
			case ConfigurationPackage.PAPYRUS_VIEW__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case ConfigurationPackage.PAPYRUS_VIEW__PARENT:
				return parent != null;
			case ConfigurationPackage.PAPYRUS_VIEW__PROFILES:
				return profiles != null && !profiles.isEmpty();
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
				return modelRules != null && !modelRules.isEmpty();
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				return owningRules != null && !owningRules.isEmpty();
			case ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID:
				return IMPLEMENTATION_ID_EDEFAULT == null ? implementationID != null : !IMPLEMENTATION_ID_EDEFAULT.equals(implementationID);
			case ConfigurationPackage.PAPYRUS_VIEW__CATEGORIES:
				return categories != null && !categories.isEmpty();
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
		result.append(" (icon: ");
		result.append(icon);
		result.append(", implementationID: ");
		result.append(implementationID);
		result.append(')');
		return result.toString();
	}

} //PapyrusViewImpl
