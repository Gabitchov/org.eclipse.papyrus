/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Twist;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.TwistWithCovariance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Twist With Covariance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TwistWithCovarianceImpl#getTwist <em>Twist</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TwistWithCovarianceImpl#getCovariance <em>Covariance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TwistWithCovarianceImpl extends MinimalEObjectImpl.Container implements TwistWithCovariance {
	/**
	 * The cached value of the '{@link #getTwist() <em>Twist</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwist()
	 * @generated
	 * @ordered
	 */
	protected Twist twist;

	/**
	 * The cached value of the '{@link #getCovariance() <em>Covariance</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCovariance()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> covariance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TwistWithCovarianceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Geometry_datatypesPackage.Literals.TWIST_WITH_COVARIANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Twist getTwist() {
		return twist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTwist(Twist newTwist, NotificationChain msgs) {
		Twist oldTwist = twist;
		twist = newTwist;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST, oldTwist, newTwist);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTwist(Twist newTwist) {
		if (newTwist != twist) {
			NotificationChain msgs = null;
			if (twist != null)
				msgs = ((InternalEObject)twist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST, null, msgs);
			if (newTwist != null)
				msgs = ((InternalEObject)newTwist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST, null, msgs);
			msgs = basicSetTwist(newTwist, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST, newTwist, newTwist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getCovariance() {
		if (covariance == null) {
			covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__COVARIANCE);
		}
		return covariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST:
				return basicSetTwist(null, msgs);
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
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST:
				return getTwist();
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__COVARIANCE:
				return getCovariance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST:
				setTwist((Twist)newValue);
				return;
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__COVARIANCE:
				getCovariance().clear();
				getCovariance().addAll((Collection<? extends Double>)newValue);
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
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST:
				setTwist((Twist)null);
				return;
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__COVARIANCE:
				getCovariance().clear();
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
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__TWIST:
				return twist != null;
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE__COVARIANCE:
				return covariance != null && !covariance.isEmpty();
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
		result.append(" (covariance: ");
		result.append(covariance);
		result.append(')');
		return result.toString();
	}

} //TwistWithCovarianceImpl
