/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl#getChoiceAttrib <em>Choice Attrib</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl#getDefaultAttrib <em>Default Attrib</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceTypeImpl extends EObjectImpl implements ChoiceType {
	/**
	 * The cached value of the '{@link #getChoiceAttrib() <em>Choice Attrib</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoiceAttrib()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> choiceAttrib;

	/**
	 * The cached value of the '{@link #getDefaultAttrib() <em>Default Attrib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultAttrib()
	 * @generated
	 * @ordered
	 */
	protected Property defaultAttrib;

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataTypesPackage.Literals.CHOICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getChoiceAttrib() {
		if (choiceAttrib == null) {
			choiceAttrib = new EObjectResolvingEList<Property>(Property.class, this, DataTypesPackage.CHOICE_TYPE__CHOICE_ATTRIB);
		}
		return choiceAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getDefaultAttrib() {
		if (defaultAttrib != null && defaultAttrib.eIsProxy()) {
			InternalEObject oldDefaultAttrib = (InternalEObject)defaultAttrib;
			defaultAttrib = (Property)eResolveProxy(oldDefaultAttrib);
			if (defaultAttrib != oldDefaultAttrib) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB, oldDefaultAttrib, defaultAttrib));
			}
		}
		return defaultAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetDefaultAttrib() {
		return defaultAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultAttrib(Property newDefaultAttrib) {
		Property oldDefaultAttrib = defaultAttrib;
		defaultAttrib = newDefaultAttrib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB, oldDefaultAttrib, defaultAttrib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypesPackage.CHOICE_TYPE__CHOICE_ATTRIB:
				return getChoiceAttrib();
			case DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB:
				if (resolve) return getDefaultAttrib();
				return basicGetDefaultAttrib();
			case DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
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
			case DataTypesPackage.CHOICE_TYPE__CHOICE_ATTRIB:
				getChoiceAttrib().clear();
				getChoiceAttrib().addAll((Collection<? extends Property>)newValue);
				return;
			case DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB:
				setDefaultAttrib((Property)newValue);
				return;
			case DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
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
			case DataTypesPackage.CHOICE_TYPE__CHOICE_ATTRIB:
				getChoiceAttrib().clear();
				return;
			case DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB:
				setDefaultAttrib((Property)null);
				return;
			case DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
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
			case DataTypesPackage.CHOICE_TYPE__CHOICE_ATTRIB:
				return choiceAttrib != null && !choiceAttrib.isEmpty();
			case DataTypesPackage.CHOICE_TYPE__DEFAULT_ATTRIB:
				return defaultAttrib != null;
			case DataTypesPackage.CHOICE_TYPE__BASE_DATA_TYPE:
				return base_DataType != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceTypeImpl
