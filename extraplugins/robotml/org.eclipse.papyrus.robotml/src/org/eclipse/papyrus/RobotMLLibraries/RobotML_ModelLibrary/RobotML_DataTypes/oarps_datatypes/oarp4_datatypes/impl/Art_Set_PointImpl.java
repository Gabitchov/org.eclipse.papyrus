/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Art Set Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl#getOmega_left <em>Omega left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl#getOmega_right <em>Omega right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Art_Set_PointImpl extends MinimalEObjectImpl.Container implements Art_Set_Point {
	/**
	 * The cached value of the '{@link #getOmega_left() <em>Omega left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmega_left()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Angular omega_left;

	/**
	 * The cached value of the '{@link #getOmega_right() <em>Omega right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmega_right()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Angular omega_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Art_Set_PointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp4_datatypesPackage.Literals.ART_SET_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular getOmega_left() {
		return omega_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOmega_left(Velocity_Angular newOmega_left, NotificationChain msgs) {
		Velocity_Angular oldOmega_left = omega_left;
		omega_left = newOmega_left;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT, oldOmega_left, newOmega_left);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmega_left(Velocity_Angular newOmega_left) {
		if (newOmega_left != omega_left) {
			NotificationChain msgs = null;
			if (omega_left != null)
				msgs = ((InternalEObject)omega_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT, null, msgs);
			if (newOmega_left != null)
				msgs = ((InternalEObject)newOmega_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT, null, msgs);
			msgs = basicSetOmega_left(newOmega_left, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT, newOmega_left, newOmega_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular getOmega_right() {
		return omega_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOmega_right(Velocity_Angular newOmega_right, NotificationChain msgs) {
		Velocity_Angular oldOmega_right = omega_right;
		omega_right = newOmega_right;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT, oldOmega_right, newOmega_right);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmega_right(Velocity_Angular newOmega_right) {
		if (newOmega_right != omega_right) {
			NotificationChain msgs = null;
			if (omega_right != null)
				msgs = ((InternalEObject)omega_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT, null, msgs);
			if (newOmega_right != null)
				msgs = ((InternalEObject)newOmega_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT, null, msgs);
			msgs = basicSetOmega_right(newOmega_right, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT, newOmega_right, newOmega_right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT:
				return basicSetOmega_left(null, msgs);
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT:
				return basicSetOmega_right(null, msgs);
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
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT:
				return getOmega_left();
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT:
				return getOmega_right();
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
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT:
				setOmega_left((Velocity_Angular)newValue);
				return;
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT:
				setOmega_right((Velocity_Angular)newValue);
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
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT:
				setOmega_left((Velocity_Angular)null);
				return;
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT:
				setOmega_right((Velocity_Angular)null);
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
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_LEFT:
				return omega_left != null;
			case Oarp4_datatypesPackage.ART_SET_POINT__OMEGA_RIGHT:
				return omega_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Art_Set_PointImpl
