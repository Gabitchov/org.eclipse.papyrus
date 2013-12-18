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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Element Type Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl#getHint <em>Hint</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl#getKindName <em>Kind Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl#getSpecializedTypesID <em>Specialized Types ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ElementTypeConfigurationImpl extends ConfigurationElementImpl implements ElementTypeConfiguration {

	/**
	 * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected static final String HINT_EDEFAULT = "ExtendedElements"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected String hint = HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NAME_EDEFAULT = "org.eclipse.gmf.runtime.emf.type.core.IHintedType"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected String kindName = KIND_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecializedTypesID() <em>Specialized Types ID</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpecializedTypesID()
	 * @generated
	 * @ordered
	 */
	protected EList<String> specializedTypesID;

	/**
	 * The cached value of the '{@link #getMatcherConfiguration() <em>Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMatcherConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MatcherConfiguration matcherConfiguration;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementTypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHint(String newHint) {
		String oldHint = hint;
		hint = newHint;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT, oldHint, hint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getKindName() {
		return kindName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKindName(String newKindName) {
		String oldKindName = kindName;
		kindName = newKindName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME, oldKindName, kindName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getSpecializedTypesID() {
		if(specializedTypesID == null) {
			specializedTypesID = new EDataTypeUniqueEList<String>(String.class, this, ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID);
		}
		return specializedTypesID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MatcherConfiguration getMatcherConfiguration() {
		return matcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetMatcherConfiguration(MatcherConfiguration newMatcherConfiguration, NotificationChain msgs) {
		MatcherConfiguration oldMatcherConfiguration = matcherConfiguration;
		matcherConfiguration = newMatcherConfiguration;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION, oldMatcherConfiguration, newMatcherConfiguration);
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
	public void setMatcherConfiguration(MatcherConfiguration newMatcherConfiguration) {
		if(newMatcherConfiguration != matcherConfiguration) {
			NotificationChain msgs = null;
			if(matcherConfiguration != null)
				msgs = ((InternalEObject)matcherConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			if(newMatcherConfiguration != null)
				msgs = ((InternalEObject)newMatcherConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION, null, msgs);
			msgs = basicSetMatcherConfiguration(newMatcherConfiguration, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION, newMatcherConfiguration, newMatcherConfiguration));
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
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			return basicSetMatcherConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
			return getHint();
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
			return getKindName();
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
			return getSpecializedTypesID();
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			return getMatcherConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
			setHint((String)newValue);
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
			setKindName((String)newValue);
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
			getSpecializedTypesID().clear();
			getSpecializedTypesID().addAll((Collection<? extends String>)newValue);
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			setMatcherConfiguration((MatcherConfiguration)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
			setHint(HINT_EDEFAULT);
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
			setKindName(KIND_NAME_EDEFAULT);
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
			getSpecializedTypesID().clear();
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			setMatcherConfiguration((MatcherConfiguration)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
			return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
			return KIND_NAME_EDEFAULT == null ? kindName != null : !KIND_NAME_EDEFAULT.equals(kindName);
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
			return specializedTypesID != null && !specializedTypesID.isEmpty();
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			return matcherConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hint: "); //$NON-NLS-1$
		result.append(hint);
		result.append(", kindName: "); //$NON-NLS-1$
		result.append(kindName);
		result.append(", specializedTypesID: "); //$NON-NLS-1$
		result.append(specializedTypesID);
		result.append(')');
		return result.toString();
	}
} // ElementTypeConfigurationImpl
