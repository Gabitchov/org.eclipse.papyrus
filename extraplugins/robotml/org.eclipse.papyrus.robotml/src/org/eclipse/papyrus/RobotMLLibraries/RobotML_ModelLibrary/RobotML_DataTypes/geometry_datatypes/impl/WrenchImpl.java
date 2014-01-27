/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Wrench;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wrench</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.WrenchImpl#getForce <em>Force</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.WrenchImpl#getTorque <em>Torque</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WrenchImpl extends MinimalEObjectImpl.Container implements Wrench {
	/**
	 * The cached value of the '{@link #getForce() <em>Force</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForce()
	 * @generated
	 * @ordered
	 */
	protected Vector3 force;

	/**
	 * The cached value of the '{@link #getTorque() <em>Torque</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTorque()
	 * @generated
	 * @ordered
	 */
	protected Vector3 torque;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WrenchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Geometry_datatypesPackage.Literals.WRENCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3 getForce() {
		return force;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForce(Vector3 newForce, NotificationChain msgs) {
		Vector3 oldForce = force;
		force = newForce;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.WRENCH__FORCE, oldForce, newForce);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForce(Vector3 newForce) {
		if (newForce != force) {
			NotificationChain msgs = null;
			if (force != null)
				msgs = ((InternalEObject)force).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.WRENCH__FORCE, null, msgs);
			if (newForce != null)
				msgs = ((InternalEObject)newForce).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.WRENCH__FORCE, null, msgs);
			msgs = basicSetForce(newForce, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.WRENCH__FORCE, newForce, newForce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3 getTorque() {
		return torque;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTorque(Vector3 newTorque, NotificationChain msgs) {
		Vector3 oldTorque = torque;
		torque = newTorque;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.WRENCH__TORQUE, oldTorque, newTorque);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorque(Vector3 newTorque) {
		if (newTorque != torque) {
			NotificationChain msgs = null;
			if (torque != null)
				msgs = ((InternalEObject)torque).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.WRENCH__TORQUE, null, msgs);
			if (newTorque != null)
				msgs = ((InternalEObject)newTorque).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.WRENCH__TORQUE, null, msgs);
			msgs = basicSetTorque(newTorque, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.WRENCH__TORQUE, newTorque, newTorque));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Geometry_datatypesPackage.WRENCH__FORCE:
				return basicSetForce(null, msgs);
			case Geometry_datatypesPackage.WRENCH__TORQUE:
				return basicSetTorque(null, msgs);
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
			case Geometry_datatypesPackage.WRENCH__FORCE:
				return getForce();
			case Geometry_datatypesPackage.WRENCH__TORQUE:
				return getTorque();
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
			case Geometry_datatypesPackage.WRENCH__FORCE:
				setForce((Vector3)newValue);
				return;
			case Geometry_datatypesPackage.WRENCH__TORQUE:
				setTorque((Vector3)newValue);
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
			case Geometry_datatypesPackage.WRENCH__FORCE:
				setForce((Vector3)null);
				return;
			case Geometry_datatypesPackage.WRENCH__TORQUE:
				setTorque((Vector3)null);
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
			case Geometry_datatypesPackage.WRENCH__FORCE:
				return force != null;
			case Geometry_datatypesPackage.WRENCH__TORQUE:
				return torque != null;
		}
		return super.eIsSet(featureID);
	}

} //WrenchImpl
