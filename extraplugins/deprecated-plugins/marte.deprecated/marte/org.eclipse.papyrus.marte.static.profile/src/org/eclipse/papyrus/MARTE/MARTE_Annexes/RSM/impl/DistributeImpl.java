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

import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.DistributeImpl#getPatternShape <em>Pattern Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.DistributeImpl#getRepetitionSpace <em>Repetition Space</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.DistributeImpl#getFromTiler <em>From Tiler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.DistributeImpl#getToTiler <em>To Tiler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributeImpl extends AllocateImpl implements Distribute {
	/**
	 * The default value of the '{@link #getPatternShape() <em>Pattern Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternShape()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_SHAPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatternShape() <em>Pattern Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternShape()
	 * @generated
	 * @ordered
	 */
	protected String patternShape = PATTERN_SHAPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepetitionSpace() <em>Repetition Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitionSpace()
	 * @generated
	 * @ordered
	 */
	protected static final String REPETITION_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepetitionSpace() <em>Repetition Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitionSpace()
	 * @generated
	 * @ordered
	 */
	protected String repetitionSpace = REPETITION_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromTiler() <em>From Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromTiler()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_TILER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromTiler() <em>From Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromTiler()
	 * @generated
	 * @ordered
	 */
	protected String fromTiler = FROM_TILER_EDEFAULT;

	/**
	 * The default value of the '{@link #getToTiler() <em>To Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToTiler()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_TILER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToTiler() <em>To Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToTiler()
	 * @generated
	 * @ordered
	 */
	protected String toTiler = TO_TILER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RSMPackage.Literals.DISTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatternShape() {
		return patternShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternShape(String newPatternShape) {
		String oldPatternShape = patternShape;
		patternShape = newPatternShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.DISTRIBUTE__PATTERN_SHAPE, oldPatternShape, patternShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepetitionSpace() {
		return repetitionSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetitionSpace(String newRepetitionSpace) {
		String oldRepetitionSpace = repetitionSpace;
		repetitionSpace = newRepetitionSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.DISTRIBUTE__REPETITION_SPACE, oldRepetitionSpace, repetitionSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromTiler() {
		return fromTiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromTiler(String newFromTiler) {
		String oldFromTiler = fromTiler;
		fromTiler = newFromTiler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.DISTRIBUTE__FROM_TILER, oldFromTiler, fromTiler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToTiler() {
		return toTiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToTiler(String newToTiler) {
		String oldToTiler = toTiler;
		toTiler = newToTiler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.DISTRIBUTE__TO_TILER, oldToTiler, toTiler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RSMPackage.DISTRIBUTE__PATTERN_SHAPE:
				return getPatternShape();
			case RSMPackage.DISTRIBUTE__REPETITION_SPACE:
				return getRepetitionSpace();
			case RSMPackage.DISTRIBUTE__FROM_TILER:
				return getFromTiler();
			case RSMPackage.DISTRIBUTE__TO_TILER:
				return getToTiler();
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
			case RSMPackage.DISTRIBUTE__PATTERN_SHAPE:
				setPatternShape((String)newValue);
				return;
			case RSMPackage.DISTRIBUTE__REPETITION_SPACE:
				setRepetitionSpace((String)newValue);
				return;
			case RSMPackage.DISTRIBUTE__FROM_TILER:
				setFromTiler((String)newValue);
				return;
			case RSMPackage.DISTRIBUTE__TO_TILER:
				setToTiler((String)newValue);
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
			case RSMPackage.DISTRIBUTE__PATTERN_SHAPE:
				setPatternShape(PATTERN_SHAPE_EDEFAULT);
				return;
			case RSMPackage.DISTRIBUTE__REPETITION_SPACE:
				setRepetitionSpace(REPETITION_SPACE_EDEFAULT);
				return;
			case RSMPackage.DISTRIBUTE__FROM_TILER:
				setFromTiler(FROM_TILER_EDEFAULT);
				return;
			case RSMPackage.DISTRIBUTE__TO_TILER:
				setToTiler(TO_TILER_EDEFAULT);
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
			case RSMPackage.DISTRIBUTE__PATTERN_SHAPE:
				return PATTERN_SHAPE_EDEFAULT == null ? patternShape != null : !PATTERN_SHAPE_EDEFAULT.equals(patternShape);
			case RSMPackage.DISTRIBUTE__REPETITION_SPACE:
				return REPETITION_SPACE_EDEFAULT == null ? repetitionSpace != null : !REPETITION_SPACE_EDEFAULT.equals(repetitionSpace);
			case RSMPackage.DISTRIBUTE__FROM_TILER:
				return FROM_TILER_EDEFAULT == null ? fromTiler != null : !FROM_TILER_EDEFAULT.equals(fromTiler);
			case RSMPackage.DISTRIBUTE__TO_TILER:
				return TO_TILER_EDEFAULT == null ? toTiler != null : !TO_TILER_EDEFAULT.equals(toTiler);
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
		result.append(" (patternShape: ");
		result.append(patternShape);
		result.append(", repetitionSpace: ");
		result.append(repetitionSpace);
		result.append(", fromTiler: ");
		result.append(fromTiler);
		result.append(", toTiler: ");
		result.append(toTiler);
		result.append(')');
		return result.toString();
	}

} //DistributeImpl
