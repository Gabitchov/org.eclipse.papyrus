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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Element Type Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl#isExtensible <em>Extensible</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExtendedElementTypeSetImpl extends ConfigurationElementImpl implements ExtendedElementTypeSet {

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementTypeConfiguration> elementType;

	/**
	 * The default value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isExtensible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENSIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isExtensible()
	 * @generated
	 * @ordered
	 */
	protected boolean extensible = EXTENSIBLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtendedElementTypeSetImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getExtendedElementTypeSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ElementTypeConfiguration> getElementType() {
		if(elementType == null) {
			elementType = new EObjectContainmentEList<ElementTypeConfiguration>(ElementTypeConfiguration.class, this, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE);
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isExtensible() {
		return extensible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtensible(boolean newExtensible) {
		boolean oldExtensible = extensible;
		extensible = newExtensible;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE, oldExtensible, extensible));
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
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE:
			return ((InternalEList<?>)getElementType()).basicRemove(otherEnd, msgs);
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
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE:
			return getElementType();
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE:
			return isExtensible();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE:
			getElementType().clear();
			getElementType().addAll((Collection<? extends ElementTypeConfiguration>)newValue);
			return;
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE:
			setExtensible((Boolean)newValue);
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
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE:
			getElementType().clear();
			return;
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE:
			setExtensible(EXTENSIBLE_EDEFAULT);
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
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE:
			return elementType != null && !elementType.isEmpty();
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE:
			return extensible != EXTENSIBLE_EDEFAULT;
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
		result.append(" (extensible: "); //$NON-NLS-1$
		result.append(extensible);
		result.append(')');
		return result.toString();
	}
} //ExtendedElementTypeSetImpl
