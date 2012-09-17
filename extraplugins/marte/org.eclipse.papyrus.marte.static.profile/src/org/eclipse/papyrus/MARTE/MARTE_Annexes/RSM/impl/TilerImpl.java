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
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tiler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.TilerImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.TilerImpl#getPaving <em>Paving</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.TilerImpl#getFitting <em>Fitting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.TilerImpl#getTiler <em>Tiler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.TilerImpl#getBase_ConnectorEnd <em>Base Connector End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TilerImpl extends LinkTopologyImpl implements Tiler {
	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaving() <em>Paving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaving()
	 * @generated
	 * @ordered
	 */
	protected static final String PAVING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPaving() <em>Paving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaving()
	 * @generated
	 * @ordered
	 */
	protected String paving = PAVING_EDEFAULT;

	/**
	 * The default value of the '{@link #getFitting() <em>Fitting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFitting()
	 * @generated
	 * @ordered
	 */
	protected static final String FITTING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFitting() <em>Fitting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFitting()
	 * @generated
	 * @ordered
	 */
	protected String fitting = FITTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTiler() <em>Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiler()
	 * @generated
	 * @ordered
	 */
	protected static final String TILER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTiler() <em>Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiler()
	 * @generated
	 * @ordered
	 */
	protected String tiler = TILER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_ConnectorEnd() <em>Base Connector End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ConnectorEnd()
	 * @generated
	 * @ordered
	 */
	protected ConnectorEnd base_ConnectorEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TilerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RSMPackage.Literals.TILER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.TILER__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPaving() {
		return paving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaving(String newPaving) {
		String oldPaving = paving;
		paving = newPaving;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.TILER__PAVING, oldPaving, paving));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFitting() {
		return fitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFitting(String newFitting) {
		String oldFitting = fitting;
		fitting = newFitting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.TILER__FITTING, oldFitting, fitting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTiler() {
		return tiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTiler(String newTiler) {
		String oldTiler = tiler;
		tiler = newTiler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.TILER__TILER, oldTiler, tiler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorEnd getBase_ConnectorEnd() {
		if (base_ConnectorEnd != null && base_ConnectorEnd.eIsProxy()) {
			InternalEObject oldBase_ConnectorEnd = (InternalEObject)base_ConnectorEnd;
			base_ConnectorEnd = (ConnectorEnd)eResolveProxy(oldBase_ConnectorEnd);
			if (base_ConnectorEnd != oldBase_ConnectorEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RSMPackage.TILER__BASE_CONNECTOR_END, oldBase_ConnectorEnd, base_ConnectorEnd));
			}
		}
		return base_ConnectorEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorEnd basicGetBase_ConnectorEnd() {
		return base_ConnectorEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ConnectorEnd(ConnectorEnd newBase_ConnectorEnd) {
		ConnectorEnd oldBase_ConnectorEnd = base_ConnectorEnd;
		base_ConnectorEnd = newBase_ConnectorEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.TILER__BASE_CONNECTOR_END, oldBase_ConnectorEnd, base_ConnectorEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RSMPackage.TILER__ORIGIN:
				return getOrigin();
			case RSMPackage.TILER__PAVING:
				return getPaving();
			case RSMPackage.TILER__FITTING:
				return getFitting();
			case RSMPackage.TILER__TILER:
				return getTiler();
			case RSMPackage.TILER__BASE_CONNECTOR_END:
				if (resolve) return getBase_ConnectorEnd();
				return basicGetBase_ConnectorEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RSMPackage.TILER__ORIGIN:
				setOrigin((String)newValue);
				return;
			case RSMPackage.TILER__PAVING:
				setPaving((String)newValue);
				return;
			case RSMPackage.TILER__FITTING:
				setFitting((String)newValue);
				return;
			case RSMPackage.TILER__TILER:
				setTiler((String)newValue);
				return;
			case RSMPackage.TILER__BASE_CONNECTOR_END:
				setBase_ConnectorEnd((ConnectorEnd)newValue);
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
			case RSMPackage.TILER__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case RSMPackage.TILER__PAVING:
				setPaving(PAVING_EDEFAULT);
				return;
			case RSMPackage.TILER__FITTING:
				setFitting(FITTING_EDEFAULT);
				return;
			case RSMPackage.TILER__TILER:
				setTiler(TILER_EDEFAULT);
				return;
			case RSMPackage.TILER__BASE_CONNECTOR_END:
				setBase_ConnectorEnd((ConnectorEnd)null);
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
			case RSMPackage.TILER__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case RSMPackage.TILER__PAVING:
				return PAVING_EDEFAULT == null ? paving != null : !PAVING_EDEFAULT.equals(paving);
			case RSMPackage.TILER__FITTING:
				return FITTING_EDEFAULT == null ? fitting != null : !FITTING_EDEFAULT.equals(fitting);
			case RSMPackage.TILER__TILER:
				return TILER_EDEFAULT == null ? tiler != null : !TILER_EDEFAULT.equals(tiler);
			case RSMPackage.TILER__BASE_CONNECTOR_END:
				return base_ConnectorEnd != null;
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
		result.append(" (origin: ");
		result.append(origin);
		result.append(", paving: ");
		result.append(paving);
		result.append(", fitting: ");
		result.append(fitting);
		result.append(", tiler: ");
		result.append(tiler);
		result.append(')');
		return result.toString();
	}

} //TilerImpl
