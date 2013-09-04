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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Pose;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseWithCovariance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pose With Covariance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.PoseWithCovarianceImpl#getPose <em>Pose</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.PoseWithCovarianceImpl#getCovariance <em>Covariance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PoseWithCovarianceImpl extends MinimalEObjectImpl.Container implements PoseWithCovariance {
	/**
	 * The cached value of the '{@link #getPose() <em>Pose</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPose()
	 * @generated
	 * @ordered
	 */
	protected Pose pose;

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
	protected PoseWithCovarianceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Geometry_datatypesPackage.Literals.POSE_WITH_COVARIANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pose getPose() {
		return pose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPose(Pose newPose, NotificationChain msgs) {
		Pose oldPose = pose;
		pose = newPose;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE, oldPose, newPose);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPose(Pose newPose) {
		if (newPose != pose) {
			NotificationChain msgs = null;
			if (pose != null)
				msgs = ((InternalEObject)pose).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE, null, msgs);
			if (newPose != null)
				msgs = ((InternalEObject)newPose).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE, null, msgs);
			msgs = basicSetPose(newPose, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE, newPose, newPose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getCovariance() {
		if (covariance == null) {
			covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Geometry_datatypesPackage.POSE_WITH_COVARIANCE__COVARIANCE);
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
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE:
				return basicSetPose(null, msgs);
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
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE:
				return getPose();
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__COVARIANCE:
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
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE:
				setPose((Pose)newValue);
				return;
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__COVARIANCE:
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
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE:
				setPose((Pose)null);
				return;
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__COVARIANCE:
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
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__POSE:
				return pose != null;
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE__COVARIANCE:
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

} //PoseWithCovarianceImpl
