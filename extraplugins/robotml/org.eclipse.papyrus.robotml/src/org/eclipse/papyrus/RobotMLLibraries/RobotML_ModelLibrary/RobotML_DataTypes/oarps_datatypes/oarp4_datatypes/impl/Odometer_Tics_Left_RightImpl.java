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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Odometer Tics Left Right</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl#getOdometer_tics_left <em>Odometer tics left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl#getOdometer_tics_right <em>Odometer tics right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Odometer_Tics_Left_RightImpl extends MinimalEObjectImpl.Container implements Odometer_Tics_Left_Right {
	/**
	 * The cached value of the '{@link #getOdometer_tics_left() <em>Odometer tics left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOdometer_tics_left()
	 * @generated
	 * @ordered
	 */
	protected Odometer_Tics odometer_tics_left;

	/**
	 * The cached value of the '{@link #getOdometer_tics_right() <em>Odometer tics right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOdometer_tics_right()
	 * @generated
	 * @ordered
	 */
	protected Odometer_Tics odometer_tics_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Odometer_Tics_Left_RightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp4_datatypesPackage.Literals.ODOMETER_TICS_LEFT_RIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Odometer_Tics getOdometer_tics_left() {
		return odometer_tics_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOdometer_tics_left(Odometer_Tics newOdometer_tics_left, NotificationChain msgs) {
		Odometer_Tics oldOdometer_tics_left = odometer_tics_left;
		odometer_tics_left = newOdometer_tics_left;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT, oldOdometer_tics_left, newOdometer_tics_left);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOdometer_tics_left(Odometer_Tics newOdometer_tics_left) {
		if (newOdometer_tics_left != odometer_tics_left) {
			NotificationChain msgs = null;
			if (odometer_tics_left != null)
				msgs = ((InternalEObject)odometer_tics_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT, null, msgs);
			if (newOdometer_tics_left != null)
				msgs = ((InternalEObject)newOdometer_tics_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT, null, msgs);
			msgs = basicSetOdometer_tics_left(newOdometer_tics_left, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT, newOdometer_tics_left, newOdometer_tics_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Odometer_Tics getOdometer_tics_right() {
		return odometer_tics_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOdometer_tics_right(Odometer_Tics newOdometer_tics_right, NotificationChain msgs) {
		Odometer_Tics oldOdometer_tics_right = odometer_tics_right;
		odometer_tics_right = newOdometer_tics_right;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT, oldOdometer_tics_right, newOdometer_tics_right);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOdometer_tics_right(Odometer_Tics newOdometer_tics_right) {
		if (newOdometer_tics_right != odometer_tics_right) {
			NotificationChain msgs = null;
			if (odometer_tics_right != null)
				msgs = ((InternalEObject)odometer_tics_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT, null, msgs);
			if (newOdometer_tics_right != null)
				msgs = ((InternalEObject)newOdometer_tics_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT, null, msgs);
			msgs = basicSetOdometer_tics_right(newOdometer_tics_right, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT, newOdometer_tics_right, newOdometer_tics_right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT:
				return basicSetOdometer_tics_left(null, msgs);
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT:
				return basicSetOdometer_tics_right(null, msgs);
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
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT:
				return getOdometer_tics_left();
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT:
				return getOdometer_tics_right();
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
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT:
				setOdometer_tics_left((Odometer_Tics)newValue);
				return;
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT:
				setOdometer_tics_right((Odometer_Tics)newValue);
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
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT:
				setOdometer_tics_left((Odometer_Tics)null);
				return;
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT:
				setOdometer_tics_right((Odometer_Tics)null);
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
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT:
				return odometer_tics_left != null;
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT:
				return odometer_tics_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Odometer_Tics_Left_RightImpl
