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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inter Repetition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.InterRepetitionImpl#getRepetitionShapeDependence <em>Repetition Shape Dependence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.InterRepetitionImpl#isIsModulo <em>Is Modulo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterRepetitionImpl extends LinkTopologyImpl implements InterRepetition {
	/**
	 * The default value of the '{@link #getRepetitionShapeDependence() <em>Repetition Shape Dependence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitionShapeDependence()
	 * @generated
	 * @ordered
	 */
	protected static final String REPETITION_SHAPE_DEPENDENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepetitionShapeDependence() <em>Repetition Shape Dependence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitionShapeDependence()
	 * @generated
	 * @ordered
	 */
	protected String repetitionShapeDependence = REPETITION_SHAPE_DEPENDENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsModulo() <em>Is Modulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsModulo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MODULO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsModulo() <em>Is Modulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsModulo()
	 * @generated
	 * @ordered
	 */
	protected boolean isModulo = IS_MODULO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterRepetitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RSMPackage.Literals.INTER_REPETITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepetitionShapeDependence() {
		return repetitionShapeDependence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetitionShapeDependence(String newRepetitionShapeDependence) {
		String oldRepetitionShapeDependence = repetitionShapeDependence;
		repetitionShapeDependence = newRepetitionShapeDependence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.INTER_REPETITION__REPETITION_SHAPE_DEPENDENCE, oldRepetitionShapeDependence, repetitionShapeDependence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsModulo() {
		return isModulo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsModulo(boolean newIsModulo) {
		boolean oldIsModulo = isModulo;
		isModulo = newIsModulo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.INTER_REPETITION__IS_MODULO, oldIsModulo, isModulo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RSMPackage.INTER_REPETITION__REPETITION_SHAPE_DEPENDENCE:
				return getRepetitionShapeDependence();
			case RSMPackage.INTER_REPETITION__IS_MODULO:
				return isIsModulo();
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
			case RSMPackage.INTER_REPETITION__REPETITION_SHAPE_DEPENDENCE:
				setRepetitionShapeDependence((String)newValue);
				return;
			case RSMPackage.INTER_REPETITION__IS_MODULO:
				setIsModulo((Boolean)newValue);
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
			case RSMPackage.INTER_REPETITION__REPETITION_SHAPE_DEPENDENCE:
				setRepetitionShapeDependence(REPETITION_SHAPE_DEPENDENCE_EDEFAULT);
				return;
			case RSMPackage.INTER_REPETITION__IS_MODULO:
				setIsModulo(IS_MODULO_EDEFAULT);
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
			case RSMPackage.INTER_REPETITION__REPETITION_SHAPE_DEPENDENCE:
				return REPETITION_SHAPE_DEPENDENCE_EDEFAULT == null ? repetitionShapeDependence != null : !REPETITION_SHAPE_DEPENDENCE_EDEFAULT.equals(repetitionShapeDependence);
			case RSMPackage.INTER_REPETITION__IS_MODULO:
				return isModulo != IS_MODULO_EDEFAULT;
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
		result.append(" (repetitionShapeDependence: ");
		result.append(repetitionShapeDependence);
		result.append(", isModulo: ");
		result.append(isModulo);
		result.append(')');
		return result.toString();
	}

} //InterRepetitionImpl
