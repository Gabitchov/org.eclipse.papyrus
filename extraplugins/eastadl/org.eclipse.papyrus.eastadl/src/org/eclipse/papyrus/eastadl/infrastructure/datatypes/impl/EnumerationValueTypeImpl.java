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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType;
import org.eclipse.uml2.uml.Enumeration;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl#isIsMultiValued <em>Is Multi Valued</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl#getLiteralSemantics <em>Literal Semantics</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl#getBase_Enumeration <em>Base Enumeration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnumerationValueTypeImpl extends ValueTypeImpl implements EnumerationValueType {

	/**
	 * The default value of the '{@link #isIsMultiValued() <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsMultiValued()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MULTI_VALUED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMultiValued() <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsMultiValued()
	 * @generated
	 * @ordered
	 */
	protected boolean isMultiValued = IS_MULTI_VALUED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLiteralSemantics() <em>Literal Semantics</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralSemantics()
	 * @generated
	 * @ordered
	 */
	protected EList<String> literalSemantics;

	/**
	 * The cached value of the '{@link #getBase_Enumeration() <em>Base Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Enumeration()
	 * @generated
	 * @ordered
	 */
	protected Enumeration base_Enumeration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EnumerationValueTypeImpl() {
		super();
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
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED:
			return isIsMultiValued();
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS:
			return getLiteralSemantics();
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION:
			if(resolve)
				return getBase_Enumeration();
			return basicGetBase_Enumeration();
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
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED:
			return isMultiValued != IS_MULTI_VALUED_EDEFAULT;
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS:
			return literalSemantics != null && !literalSemantics.isEmpty();
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION:
			return base_Enumeration != null;
		}
		return super.eIsSet(featureID);
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
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED:
			setIsMultiValued((Boolean)newValue);
			return;
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS:
			getLiteralSemantics().clear();
			getLiteralSemantics().addAll((Collection<? extends String>)newValue);
			return;
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION:
			setBase_Enumeration((Enumeration)newValue);
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
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.ENUMERATION_VALUE_TYPE;
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
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED:
			setIsMultiValued(IS_MULTI_VALUED_EDEFAULT);
			return;
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS:
			getLiteralSemantics().clear();
			return;
		case DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION:
			setBase_Enumeration((Enumeration)null);
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
	public EList<String> getLiteralSemantics() {
		if(literalSemantics == null) {
			literalSemantics = new EDataTypeEList<String>(String.class, this, DatatypesPackage.ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS);
		}
		return literalSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Enumeration getBase_Enumeration() {
		if(base_Enumeration != null && base_Enumeration.eIsProxy()) {
			InternalEObject oldBase_Enumeration = (InternalEObject)base_Enumeration;
			base_Enumeration = (Enumeration)eResolveProxy(oldBase_Enumeration);
			if(base_Enumeration != oldBase_Enumeration) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION, oldBase_Enumeration, base_Enumeration));
			}
		}
		return base_Enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Enumeration basicGetBase_Enumeration() {
		return base_Enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Enumeration(Enumeration newBase_Enumeration) {
		Enumeration oldBase_Enumeration = base_Enumeration;
		base_Enumeration = newBase_Enumeration;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.ENUMERATION_VALUE_TYPE__BASE_ENUMERATION, oldBase_Enumeration, base_Enumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsMultiValued() {
		return isMultiValued;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsMultiValued(boolean newIsMultiValued) {
		boolean oldIsMultiValued = isMultiValued;
		isMultiValued = newIsMultiValued;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED, oldIsMultiValued, isMultiValued));
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
		result.append(" (isMultiValued: ");
		result.append(isMultiValued);
		result.append(", literalSemantics: ");
		result.append(literalSemantics);
		result.append(')');
		return result.toString();
	}

} //EnumerationValueTypeImpl
