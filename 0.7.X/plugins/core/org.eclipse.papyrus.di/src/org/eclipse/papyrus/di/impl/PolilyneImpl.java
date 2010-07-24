/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.Polilyne;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Polilyne</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.PolilyneImpl#getWaypoints <em>Waypoints</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.PolilyneImpl#getClosed <em>Closed</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PolilyneImpl extends GraphicPrimitiveImpl implements Polilyne {

	/**
	 * The cached value of the '{@link #getWaypoints() <em>Waypoints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWaypoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Point> waypoints;

	/**
	 * The cached value of the '{@link #getClosed() <em>Closed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getClosed()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> closed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PolilyneImpl() {
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
		return DiPackage.Literals.POLILYNE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Point> getWaypoints() {
		if(waypoints == null) {
			waypoints = new EDataTypeUniqueEList<Point>(Point.class, this, DiPackage.POLILYNE__WAYPOINTS);
		}
		return waypoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Boolean> getClosed() {
		if(closed == null) {
			closed = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, DiPackage.POLILYNE__CLOSED);
		}
		return closed;
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
		case DiPackage.POLILYNE__WAYPOINTS:
			return getWaypoints();
		case DiPackage.POLILYNE__CLOSED:
			return getClosed();
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
		case DiPackage.POLILYNE__WAYPOINTS:
			getWaypoints().clear();
			getWaypoints().addAll((Collection<? extends Point>)newValue);
			return;
		case DiPackage.POLILYNE__CLOSED:
			getClosed().clear();
			getClosed().addAll((Collection<? extends Boolean>)newValue);
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
		case DiPackage.POLILYNE__WAYPOINTS:
			getWaypoints().clear();
			return;
		case DiPackage.POLILYNE__CLOSED:
			getClosed().clear();
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
		case DiPackage.POLILYNE__WAYPOINTS:
			return waypoints != null && !waypoints.isEmpty();
		case DiPackage.POLILYNE__CLOSED:
			return closed != null && !closed.isEmpty();
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
		result.append(" (waypoints: ");
		result.append(waypoints);
		result.append(", closed: ");
		result.append(closed);
		result.append(')');
		return result.toString();
	}

} //PolilyneImpl
