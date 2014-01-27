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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Velocity Angular Left Right</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl#getVelocity_angular_left <em>Velocity angular left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl#getVelocity_angular_right <em>Velocity angular right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Velocity_Angular_Left_RightImpl extends MinimalEObjectImpl.Container implements Velocity_Angular_Left_Right {
	/**
	 * The cached value of the '{@link #getVelocity_angular_left() <em>Velocity angular left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity_angular_left()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Angular velocity_angular_left;

	/**
	 * The cached value of the '{@link #getVelocity_angular_right() <em>Velocity angular right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity_angular_right()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Angular velocity_angular_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Velocity_Angular_Left_RightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp4_datatypesPackage.Literals.VELOCITY_ANGULAR_LEFT_RIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular getVelocity_angular_left() {
		return velocity_angular_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVelocity_angular_left(Velocity_Angular newVelocity_angular_left, NotificationChain msgs) {
		Velocity_Angular oldVelocity_angular_left = velocity_angular_left;
		velocity_angular_left = newVelocity_angular_left;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT, oldVelocity_angular_left, newVelocity_angular_left);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocity_angular_left(Velocity_Angular newVelocity_angular_left) {
		if (newVelocity_angular_left != velocity_angular_left) {
			NotificationChain msgs = null;
			if (velocity_angular_left != null)
				msgs = ((InternalEObject)velocity_angular_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT, null, msgs);
			if (newVelocity_angular_left != null)
				msgs = ((InternalEObject)newVelocity_angular_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT, null, msgs);
			msgs = basicSetVelocity_angular_left(newVelocity_angular_left, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT, newVelocity_angular_left, newVelocity_angular_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular getVelocity_angular_right() {
		return velocity_angular_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVelocity_angular_right(Velocity_Angular newVelocity_angular_right, NotificationChain msgs) {
		Velocity_Angular oldVelocity_angular_right = velocity_angular_right;
		velocity_angular_right = newVelocity_angular_right;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT, oldVelocity_angular_right, newVelocity_angular_right);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocity_angular_right(Velocity_Angular newVelocity_angular_right) {
		if (newVelocity_angular_right != velocity_angular_right) {
			NotificationChain msgs = null;
			if (velocity_angular_right != null)
				msgs = ((InternalEObject)velocity_angular_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT, null, msgs);
			if (newVelocity_angular_right != null)
				msgs = ((InternalEObject)newVelocity_angular_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT, null, msgs);
			msgs = basicSetVelocity_angular_right(newVelocity_angular_right, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT, newVelocity_angular_right, newVelocity_angular_right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT:
				return basicSetVelocity_angular_left(null, msgs);
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT:
				return basicSetVelocity_angular_right(null, msgs);
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
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT:
				return getVelocity_angular_left();
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT:
				return getVelocity_angular_right();
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
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT:
				setVelocity_angular_left((Velocity_Angular)newValue);
				return;
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT:
				setVelocity_angular_right((Velocity_Angular)newValue);
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
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT:
				setVelocity_angular_left((Velocity_Angular)null);
				return;
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT:
				setVelocity_angular_right((Velocity_Angular)null);
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
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT:
				return velocity_angular_left != null;
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT:
				return velocity_angular_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Velocity_Angular_Left_RightImpl
