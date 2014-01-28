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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Velocity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl#getVelocity_linear <em>Velocity linear</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl#getVelocity_angular <em>Velocity angular</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VelocityImpl extends MinimalEObjectImpl.Container implements Velocity {
	/**
	 * The cached value of the '{@link #getVelocity_linear() <em>Velocity linear</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity_linear()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Linear velocity_linear;

	/**
	 * The cached value of the '{@link #getVelocity_angular() <em>Velocity angular</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity_angular()
	 * @generated
	 * @ordered
	 */
	protected Velocity_Angular velocity_angular;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VelocityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp4_datatypesPackage.Literals.VELOCITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Linear getVelocity_linear() {
		return velocity_linear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVelocity_linear(Velocity_Linear newVelocity_linear, NotificationChain msgs) {
		Velocity_Linear oldVelocity_linear = velocity_linear;
		velocity_linear = newVelocity_linear;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR, oldVelocity_linear, newVelocity_linear);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocity_linear(Velocity_Linear newVelocity_linear) {
		if (newVelocity_linear != velocity_linear) {
			NotificationChain msgs = null;
			if (velocity_linear != null)
				msgs = ((InternalEObject)velocity_linear).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR, null, msgs);
			if (newVelocity_linear != null)
				msgs = ((InternalEObject)newVelocity_linear).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR, null, msgs);
			msgs = basicSetVelocity_linear(newVelocity_linear, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR, newVelocity_linear, newVelocity_linear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular getVelocity_angular() {
		return velocity_angular;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVelocity_angular(Velocity_Angular newVelocity_angular, NotificationChain msgs) {
		Velocity_Angular oldVelocity_angular = velocity_angular;
		velocity_angular = newVelocity_angular;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR, oldVelocity_angular, newVelocity_angular);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocity_angular(Velocity_Angular newVelocity_angular) {
		if (newVelocity_angular != velocity_angular) {
			NotificationChain msgs = null;
			if (velocity_angular != null)
				msgs = ((InternalEObject)velocity_angular).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR, null, msgs);
			if (newVelocity_angular != null)
				msgs = ((InternalEObject)newVelocity_angular).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR, null, msgs);
			msgs = basicSetVelocity_angular(newVelocity_angular, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR, newVelocity_angular, newVelocity_angular));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR:
				return basicSetVelocity_linear(null, msgs);
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR:
				return basicSetVelocity_angular(null, msgs);
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
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR:
				return getVelocity_linear();
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR:
				return getVelocity_angular();
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
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR:
				setVelocity_linear((Velocity_Linear)newValue);
				return;
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR:
				setVelocity_angular((Velocity_Angular)newValue);
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
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR:
				setVelocity_linear((Velocity_Linear)null);
				return;
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR:
				setVelocity_angular((Velocity_Angular)null);
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
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_LINEAR:
				return velocity_linear != null;
			case Oarp4_datatypesPackage.VELOCITY__VELOCITY_ANGULAR:
				return velocity_angular != null;
		}
		return super.eIsSet(featureID);
	}

} //VelocityImpl
