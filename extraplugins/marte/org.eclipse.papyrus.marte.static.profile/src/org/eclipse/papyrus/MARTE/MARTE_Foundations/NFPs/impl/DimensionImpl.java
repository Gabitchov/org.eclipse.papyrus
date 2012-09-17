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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;
import org.eclipse.uml2.uml.Enumeration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl#getBaseDimension <em>Base Dimension</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl#getBaseExponent <em>Base Exponent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl#getBase_Enumeration <em>Base Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionImpl extends EObjectImpl implements Dimension {
	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected String symbol = SYMBOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseDimension() <em>Base Dimension</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseDimension()
	 * @generated
	 * @ordered
	 */
	protected EList<Dimension> baseDimension;

	/**
	 * The cached value of the '{@link #getBaseExponent() <em>Base Exponent</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseExponent()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> baseExponent;

	/**
	 * The cached value of the '{@link #getBase_Enumeration() <em>Base Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Enumeration()
	 * @generated
	 * @ordered
	 */
	protected Enumeration base_Enumeration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NFPsPackage.Literals.DIMENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		String oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NFPsPackage.DIMENSION__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dimension> getBaseDimension() {
		if (baseDimension == null) {
			baseDimension = new EObjectResolvingEList<Dimension>(Dimension.class, this, NFPsPackage.DIMENSION__BASE_DIMENSION);
		}
		return baseDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getBaseExponent() {
		if (baseExponent == null) {
			baseExponent = new EDataTypeEList<Integer>(Integer.class, this, NFPsPackage.DIMENSION__BASE_EXPONENT);
		}
		return baseExponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration getBase_Enumeration() {
		if (base_Enumeration != null && base_Enumeration.eIsProxy()) {
			InternalEObject oldBase_Enumeration = (InternalEObject)base_Enumeration;
			base_Enumeration = (Enumeration)eResolveProxy(oldBase_Enumeration);
			if (base_Enumeration != oldBase_Enumeration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NFPsPackage.DIMENSION__BASE_ENUMERATION, oldBase_Enumeration, base_Enumeration));
			}
		}
		return base_Enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration basicGetBase_Enumeration() {
		return base_Enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Enumeration(Enumeration newBase_Enumeration) {
		Enumeration oldBase_Enumeration = base_Enumeration;
		base_Enumeration = newBase_Enumeration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NFPsPackage.DIMENSION__BASE_ENUMERATION, oldBase_Enumeration, base_Enumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NFPsPackage.DIMENSION__SYMBOL:
				return getSymbol();
			case NFPsPackage.DIMENSION__BASE_DIMENSION:
				return getBaseDimension();
			case NFPsPackage.DIMENSION__BASE_EXPONENT:
				return getBaseExponent();
			case NFPsPackage.DIMENSION__BASE_ENUMERATION:
				if (resolve) return getBase_Enumeration();
				return basicGetBase_Enumeration();
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
			case NFPsPackage.DIMENSION__SYMBOL:
				setSymbol((String)newValue);
				return;
			case NFPsPackage.DIMENSION__BASE_DIMENSION:
				getBaseDimension().clear();
				getBaseDimension().addAll((Collection<? extends Dimension>)newValue);
				return;
			case NFPsPackage.DIMENSION__BASE_EXPONENT:
				getBaseExponent().clear();
				getBaseExponent().addAll((Collection<? extends Integer>)newValue);
				return;
			case NFPsPackage.DIMENSION__BASE_ENUMERATION:
				setBase_Enumeration((Enumeration)newValue);
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
			case NFPsPackage.DIMENSION__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
				return;
			case NFPsPackage.DIMENSION__BASE_DIMENSION:
				getBaseDimension().clear();
				return;
			case NFPsPackage.DIMENSION__BASE_EXPONENT:
				getBaseExponent().clear();
				return;
			case NFPsPackage.DIMENSION__BASE_ENUMERATION:
				setBase_Enumeration((Enumeration)null);
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
			case NFPsPackage.DIMENSION__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
			case NFPsPackage.DIMENSION__BASE_DIMENSION:
				return baseDimension != null && !baseDimension.isEmpty();
			case NFPsPackage.DIMENSION__BASE_EXPONENT:
				return baseExponent != null && !baseExponent.isEmpty();
			case NFPsPackage.DIMENSION__BASE_ENUMERATION:
				return base_Enumeration != null;
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
		result.append(" (symbol: ");
		result.append(symbol);
		result.append(", baseExponent: ");
		result.append(baseExponent);
		result.append(')');
		return result.toString();
	}

} //DimensionImpl
