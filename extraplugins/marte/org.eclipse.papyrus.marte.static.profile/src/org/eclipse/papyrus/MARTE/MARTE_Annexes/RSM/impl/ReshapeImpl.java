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

import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reshape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.ReshapeImpl#getPatternShape <em>Pattern Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.ReshapeImpl#getRepetitonShape <em>Repetiton Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReshapeImpl extends LinkTopologyImpl implements Reshape {
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
	 * The default value of the '{@link #getRepetitonShape() <em>Repetiton Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitonShape()
	 * @generated
	 * @ordered
	 */
	protected static final String REPETITON_SHAPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepetitonShape() <em>Repetiton Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitonShape()
	 * @generated
	 * @ordered
	 */
	protected String repetitonShape = REPETITON_SHAPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReshapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RSMPackage.Literals.RESHAPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.RESHAPE__PATTERN_SHAPE, oldPatternShape, patternShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepetitonShape() {
		return repetitonShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetitonShape(String newRepetitonShape) {
		String oldRepetitonShape = repetitonShape;
		repetitonShape = newRepetitonShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.RESHAPE__REPETITON_SHAPE, oldRepetitonShape, repetitonShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RSMPackage.RESHAPE__PATTERN_SHAPE:
				return getPatternShape();
			case RSMPackage.RESHAPE__REPETITON_SHAPE:
				return getRepetitonShape();
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
			case RSMPackage.RESHAPE__PATTERN_SHAPE:
				setPatternShape((String)newValue);
				return;
			case RSMPackage.RESHAPE__REPETITON_SHAPE:
				setRepetitonShape((String)newValue);
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
			case RSMPackage.RESHAPE__PATTERN_SHAPE:
				setPatternShape(PATTERN_SHAPE_EDEFAULT);
				return;
			case RSMPackage.RESHAPE__REPETITON_SHAPE:
				setRepetitonShape(REPETITON_SHAPE_EDEFAULT);
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
			case RSMPackage.RESHAPE__PATTERN_SHAPE:
				return PATTERN_SHAPE_EDEFAULT == null ? patternShape != null : !PATTERN_SHAPE_EDEFAULT.equals(patternShape);
			case RSMPackage.RESHAPE__REPETITON_SHAPE:
				return REPETITON_SHAPE_EDEFAULT == null ? repetitonShape != null : !REPETITON_SHAPE_EDEFAULT.equals(repetitonShape);
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
		result.append(", repetitonShape: ");
		result.append(repetitonShape);
		result.append(')');
		return result.toString();
	}

} //ReshapeImpl
