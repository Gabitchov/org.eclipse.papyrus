/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.PrimitiveData;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

import org.eclipse.uml2.uml.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.PrimitiveDataImpl#getBase_PrimitiveType <em>Base Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveDataImpl extends DataTypeImpl implements PrimitiveData {
	/**
	 * The cached value of the '{@link #getBase_PrimitiveType() <em>Base Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType base_PrimitiveType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.PRIMITIVE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getBase_PrimitiveType() {
		if (base_PrimitiveType != null && base_PrimitiveType.eIsProxy()) {
			InternalEObject oldBase_PrimitiveType = (InternalEObject)base_PrimitiveType;
			base_PrimitiveType = (PrimitiveType)eResolveProxy(oldBase_PrimitiveType);
			if (base_PrimitiveType != oldBase_PrimitiveType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE, oldBase_PrimitiveType, base_PrimitiveType));
			}
		}
		return base_PrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType basicGetBase_PrimitiveType() {
		return base_PrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PrimitiveType(PrimitiveType newBase_PrimitiveType) {
		PrimitiveType oldBase_PrimitiveType = base_PrimitiveType;
		base_PrimitiveType = newBase_PrimitiveType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE, oldBase_PrimitiveType, base_PrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE:
				if (resolve) return getBase_PrimitiveType();
				return basicGetBase_PrimitiveType();
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
			case RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE:
				setBase_PrimitiveType((PrimitiveType)newValue);
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
			case RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE:
				setBase_PrimitiveType((PrimitiveType)null);
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
			case RobotMLPackage.PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE:
				return base_PrimitiveType != null;
		}
		return super.eIsSet(featureID);
	}

} //PrimitiveDataImpl
