/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Speed Tics Left Right</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl#getSpeed_tics_left <em>Speed tics left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl#getSpeed_tics_right <em>Speed tics right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Speed_Tics_Left_RightImpl extends MinimalEObjectImpl.Container implements Speed_Tics_Left_Right {
	/**
	 * The cached value of the '{@link #getSpeed_tics_left() <em>Speed tics left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed_tics_left()
	 * @generated
	 * @ordered
	 */
	protected Speed_Tics speed_tics_left;

	/**
	 * The cached value of the '{@link #getSpeed_tics_right() <em>Speed tics right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed_tics_right()
	 * @generated
	 * @ordered
	 */
	protected Speed_Tics speed_tics_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Speed_Tics_Left_RightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp4_datatypesPackage.Literals.SPEED_TICS_LEFT_RIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Speed_Tics getSpeed_tics_left() {
		return speed_tics_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpeed_tics_left(Speed_Tics newSpeed_tics_left, NotificationChain msgs) {
		Speed_Tics oldSpeed_tics_left = speed_tics_left;
		speed_tics_left = newSpeed_tics_left;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT, oldSpeed_tics_left, newSpeed_tics_left);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeed_tics_left(Speed_Tics newSpeed_tics_left) {
		if (newSpeed_tics_left != speed_tics_left) {
			NotificationChain msgs = null;
			if (speed_tics_left != null)
				msgs = ((InternalEObject)speed_tics_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT, null, msgs);
			if (newSpeed_tics_left != null)
				msgs = ((InternalEObject)newSpeed_tics_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT, null, msgs);
			msgs = basicSetSpeed_tics_left(newSpeed_tics_left, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT, newSpeed_tics_left, newSpeed_tics_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Speed_Tics getSpeed_tics_right() {
		return speed_tics_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpeed_tics_right(Speed_Tics newSpeed_tics_right, NotificationChain msgs) {
		Speed_Tics oldSpeed_tics_right = speed_tics_right;
		speed_tics_right = newSpeed_tics_right;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT, oldSpeed_tics_right, newSpeed_tics_right);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeed_tics_right(Speed_Tics newSpeed_tics_right) {
		if (newSpeed_tics_right != speed_tics_right) {
			NotificationChain msgs = null;
			if (speed_tics_right != null)
				msgs = ((InternalEObject)speed_tics_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT, null, msgs);
			if (newSpeed_tics_right != null)
				msgs = ((InternalEObject)newSpeed_tics_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT, null, msgs);
			msgs = basicSetSpeed_tics_right(newSpeed_tics_right, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT, newSpeed_tics_right, newSpeed_tics_right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT:
				return basicSetSpeed_tics_left(null, msgs);
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT:
				return basicSetSpeed_tics_right(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT:
				return getSpeed_tics_left();
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT:
				return getSpeed_tics_right();
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
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT:
				setSpeed_tics_left((Speed_Tics)newValue);
				return;
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT:
				setSpeed_tics_right((Speed_Tics)newValue);
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
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT:
				setSpeed_tics_left((Speed_Tics)null);
				return;
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT:
				setSpeed_tics_right((Speed_Tics)null);
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
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT:
				return speed_tics_left != null;
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT:
				return speed_tics_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Speed_Tics_Left_RightImpl
