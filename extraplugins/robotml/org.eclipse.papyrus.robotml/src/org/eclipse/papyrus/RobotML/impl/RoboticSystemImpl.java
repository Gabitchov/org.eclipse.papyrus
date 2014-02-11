/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.RoboticSystem;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Robotic System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl#getLocalPosition <em>Local Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl#getLocalOrientation <em>Local Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoboticSystemImpl extends SystemImpl implements RoboticSystem {
	/**
	 * The cached value of the '{@link #getLocalPosition() <em>Local Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalPosition()
	 * @generated
	 * @ordered
	 */
	protected Point32 localPosition;

	/**
	 * The cached value of the '{@link #getLocalOrientation() <em>Local Orientation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalOrientation()
	 * @generated
	 * @ordered
	 */
	protected Point32 localOrientation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboticSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.ROBOTIC_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point32 getLocalPosition() {
		return localPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalPosition(Point32 newLocalPosition, NotificationChain msgs) {
		Point32 oldLocalPosition = localPosition;
		localPosition = newLocalPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION, oldLocalPosition, newLocalPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalPosition(Point32 newLocalPosition) {
		if (newLocalPosition != localPosition) {
			NotificationChain msgs = null;
			if (localPosition != null)
				msgs = ((InternalEObject)localPosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION, null, msgs);
			if (newLocalPosition != null)
				msgs = ((InternalEObject)newLocalPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION, null, msgs);
			msgs = basicSetLocalPosition(newLocalPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION, newLocalPosition, newLocalPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point32 getLocalOrientation() {
		return localOrientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalOrientation(Point32 newLocalOrientation, NotificationChain msgs) {
		Point32 oldLocalOrientation = localOrientation;
		localOrientation = newLocalOrientation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION, oldLocalOrientation, newLocalOrientation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalOrientation(Point32 newLocalOrientation) {
		if (newLocalOrientation != localOrientation) {
			NotificationChain msgs = null;
			if (localOrientation != null)
				msgs = ((InternalEObject)localOrientation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION, null, msgs);
			if (newLocalOrientation != null)
				msgs = ((InternalEObject)newLocalOrientation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION, null, msgs);
			msgs = basicSetLocalOrientation(newLocalOrientation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION, newLocalOrientation, newLocalOrientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION:
				return basicSetLocalPosition(null, msgs);
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION:
				return basicSetLocalOrientation(null, msgs);
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
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION:
				return getLocalPosition();
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION:
				return getLocalOrientation();
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
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION:
				setLocalPosition((Point32)newValue);
				return;
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION:
				setLocalOrientation((Point32)newValue);
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
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION:
				setLocalPosition((Point32)null);
				return;
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION:
				setLocalOrientation((Point32)null);
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
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_POSITION:
				return localPosition != null;
			case RobotMLPackage.ROBOTIC_SYSTEM__LOCAL_ORIENTATION:
				return localOrientation != null;
		}
		return super.eIsSet(featureID);
	}

} //RoboticSystemImpl
