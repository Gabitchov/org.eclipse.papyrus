/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.impl;


import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.conversion.di2.Di2Package;
import org.eclipse.papyrus.conversion.di2.Polilyne;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Polilyne</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl#getWaypoints <em>Waypoints
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl#getClosed <em>Closed</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PolilyneImpl extends GraphicPrimitiveImpl implements Polilyne {

	/**
	 * The cached value of the '{@link #getWaypoints() <em>Waypoints</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWaypoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Point> waypoints;

	/**
	 * The cached value of the '{@link #getClosed() <em>Closed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClosed()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> closed;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PolilyneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Di2Package.Literals.POLILYNE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Point> getWaypoints() {
		if (waypoints == null) {
			waypoints = new EDataTypeUniqueEList<Point>(Point.class, this, Di2Package.POLILYNE__WAYPOINTS);
		}
		return waypoints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Boolean> getClosed() {
		if (closed == null) {
			closed = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, Di2Package.POLILYNE__CLOSED);
		}
		return closed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Di2Package.POLILYNE__WAYPOINTS:
			return getWaypoints();
		case Di2Package.POLILYNE__CLOSED:
			return getClosed();
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
		switch (featureID) {
		case Di2Package.POLILYNE__WAYPOINTS:
			getWaypoints().clear();
			getWaypoints().addAll((Collection<? extends Point>) newValue);
			return;
		case Di2Package.POLILYNE__CLOSED:
			getClosed().clear();
			getClosed().addAll((Collection<? extends Boolean>) newValue);
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
		switch (featureID) {
		case Di2Package.POLILYNE__WAYPOINTS:
			getWaypoints().clear();
			return;
		case Di2Package.POLILYNE__CLOSED:
			getClosed().clear();
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
		switch (featureID) {
		case Di2Package.POLILYNE__WAYPOINTS:
			return waypoints != null && !waypoints.isEmpty();
		case Di2Package.POLILYNE__CLOSED:
			return closed != null && !closed.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (waypoints: ");
		result.append(waypoints);
		result.append(", closed: ");
		result.append(closed);
		result.append(')');
		return result.toString();
	}

} // PolilyneImpl
