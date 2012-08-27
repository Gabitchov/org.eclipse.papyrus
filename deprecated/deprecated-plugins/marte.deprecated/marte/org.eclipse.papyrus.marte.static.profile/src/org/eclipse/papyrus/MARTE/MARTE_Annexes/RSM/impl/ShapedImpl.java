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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped;

import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shaped</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.ShapedImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.ShapedImpl#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShapedImpl extends EObjectImpl implements Shaped {
	/**
	 * The default value of the '{@link #getShape() <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected static final String SHAPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected String shape = SHAPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_MultiplicityElement() <em>Base Multiplicity Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_MultiplicityElement()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityElement base_MultiplicityElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RSMPackage.Literals.SHAPED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShape() {
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShape(String newShape) {
		String oldShape = shape;
		shape = newShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.SHAPED__SHAPE, oldShape, shape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityElement getBase_MultiplicityElement() {
		if (base_MultiplicityElement != null && base_MultiplicityElement.eIsProxy()) {
			InternalEObject oldBase_MultiplicityElement = (InternalEObject)base_MultiplicityElement;
			base_MultiplicityElement = (MultiplicityElement)eResolveProxy(oldBase_MultiplicityElement);
			if (base_MultiplicityElement != oldBase_MultiplicityElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT, oldBase_MultiplicityElement, base_MultiplicityElement));
			}
		}
		return base_MultiplicityElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityElement basicGetBase_MultiplicityElement() {
		return base_MultiplicityElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_MultiplicityElement(MultiplicityElement newBase_MultiplicityElement) {
		MultiplicityElement oldBase_MultiplicityElement = base_MultiplicityElement;
		base_MultiplicityElement = newBase_MultiplicityElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT, oldBase_MultiplicityElement, base_MultiplicityElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RSMPackage.SHAPED__SHAPE:
				return getShape();
			case RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT:
				if (resolve) return getBase_MultiplicityElement();
				return basicGetBase_MultiplicityElement();
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
			case RSMPackage.SHAPED__SHAPE:
				setShape((String)newValue);
				return;
			case RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT:
				setBase_MultiplicityElement((MultiplicityElement)newValue);
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
			case RSMPackage.SHAPED__SHAPE:
				setShape(SHAPE_EDEFAULT);
				return;
			case RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT:
				setBase_MultiplicityElement((MultiplicityElement)null);
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
			case RSMPackage.SHAPED__SHAPE:
				return SHAPE_EDEFAULT == null ? shape != null : !SHAPE_EDEFAULT.equals(shape);
			case RSMPackage.SHAPED__BASE_MULTIPLICITY_ELEMENT:
				return base_MultiplicityElement != null;
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
		result.append(" (shape: ");
		result.append(shape);
		result.append(')');
		return result.toString();
	}

} //ShapedImpl
