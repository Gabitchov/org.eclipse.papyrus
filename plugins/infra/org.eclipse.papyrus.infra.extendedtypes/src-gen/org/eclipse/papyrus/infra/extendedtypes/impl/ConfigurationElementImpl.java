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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IconEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl#getIdentifier <em>Identifier</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl#getIconEntry <em>Icon Entry</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ConfigurationElementImpl extends EObjectImpl implements ConfigurationElement {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIconEntry() <em>Icon Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIconEntry()
	 * @generated
	 * @ordered
	 */
	protected IconEntry iconEntry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConfigurationElementImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getConfigurationElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.CONFIGURATION_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.CONFIGURATION_ELEMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.CONFIGURATION_ELEMENT__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IconEntry getIconEntry() {
		return iconEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetIconEntry(IconEntry newIconEntry, NotificationChain msgs) {
		IconEntry oldIconEntry = iconEntry;
		iconEntry = newIconEntry;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY, oldIconEntry, newIconEntry);
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
	public void setIconEntry(IconEntry newIconEntry) {
		if(newIconEntry != iconEntry) {
			NotificationChain msgs = null;
			if(iconEntry != null)
				msgs = ((InternalEObject)iconEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY, null, msgs);
			if(newIconEntry != null)
				msgs = ((InternalEObject)newIconEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY, null, msgs);
			msgs = basicSetIconEntry(newIconEntry, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY, newIconEntry, newIconEntry));
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
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY:
			return basicSetIconEntry(null, msgs);
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
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__NAME:
			return getName();
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__DESCRIPTION:
			return getDescription();
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__IDENTIFIER:
			return getIdentifier();
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY:
			return getIconEntry();
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
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__NAME:
			setName((String)newValue);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__DESCRIPTION:
			setDescription((String)newValue);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__IDENTIFIER:
			setIdentifier((String)newValue);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY:
			setIconEntry((IconEntry)newValue);
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
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__IDENTIFIER:
			setIdentifier(IDENTIFIER_EDEFAULT);
			return;
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY:
			setIconEntry((IconEntry)null);
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
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__IDENTIFIER:
			return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT__ICON_ENTRY:
			return iconEntry != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", identifier: "); //$NON-NLS-1$
		result.append(identifier);
		result.append(')');
		return result.toString();
	}
} //ConfigurationElementImpl
