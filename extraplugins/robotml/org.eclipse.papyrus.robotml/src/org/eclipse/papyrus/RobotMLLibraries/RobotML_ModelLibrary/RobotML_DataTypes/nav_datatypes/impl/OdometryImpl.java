/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseWithCovariance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.TwistWithCovariance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Odometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl#getHeader <em>Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl#getChild_frame_id <em>Child
 * frame id</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl#getPose <em>Pose</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OdometryImpl#getTwist <em>Twist</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OdometryImpl extends EObjectImpl implements Odometry {

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The default value of the '{@link #getChild_frame_id() <em>Child frame id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChild_frame_id()
	 * @generated
	 * @ordered
	 */
	protected static final String CHILD_FRAME_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChild_frame_id() <em>Child frame id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChild_frame_id()
	 * @generated
	 * @ordered
	 */
	protected String child_frame_id = CHILD_FRAME_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPose() <em>Pose</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPose()
	 * @generated
	 * @ordered
	 */
	protected PoseWithCovariance pose;

	/**
	 * The cached value of the '{@link #getTwist() <em>Twist</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTwist()
	 * @generated
	 * @ordered
	 */
	protected TwistWithCovariance twist;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OdometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Nav_datatypesPackage.Literals.ODOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__HEADER, oldHeader, newHeader);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if(newHeader != header) {
			NotificationChain msgs = null;
			if(header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getChild_frame_id() {
		return child_frame_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setChild_frame_id(String newChild_frame_id) {
		String oldChild_frame_id = child_frame_id;
		child_frame_id = newChild_frame_id;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__CHILD_FRAME_ID, oldChild_frame_id, child_frame_id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PoseWithCovariance getPose() {
		return pose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPose(PoseWithCovariance newPose, NotificationChain msgs) {
		PoseWithCovariance oldPose = pose;
		pose = newPose;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__POSE, oldPose, newPose);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPose(PoseWithCovariance newPose) {
		if(newPose != pose) {
			NotificationChain msgs = null;
			if(pose != null)
				msgs = ((InternalEObject)pose).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__POSE, null, msgs);
			if(newPose != null)
				msgs = ((InternalEObject)newPose).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__POSE, null, msgs);
			msgs = basicSetPose(newPose, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__POSE, newPose, newPose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TwistWithCovariance getTwist() {
		return twist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTwist(TwistWithCovariance newTwist, NotificationChain msgs) {
		TwistWithCovariance oldTwist = twist;
		twist = newTwist;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__TWIST, oldTwist, newTwist);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTwist(TwistWithCovariance newTwist) {
		if(newTwist != twist) {
			NotificationChain msgs = null;
			if(twist != null)
				msgs = ((InternalEObject)twist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__TWIST, null, msgs);
			if(newTwist != null)
				msgs = ((InternalEObject)newTwist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.ODOMETRY__TWIST, null, msgs);
			msgs = basicSetTwist(newTwist, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.ODOMETRY__TWIST, newTwist, newTwist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case Nav_datatypesPackage.ODOMETRY__HEADER:
			return basicSetHeader(null, msgs);
		case Nav_datatypesPackage.ODOMETRY__POSE:
			return basicSetPose(null, msgs);
		case Nav_datatypesPackage.ODOMETRY__TWIST:
			return basicSetTwist(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case Nav_datatypesPackage.ODOMETRY__HEADER:
			return getHeader();
		case Nav_datatypesPackage.ODOMETRY__CHILD_FRAME_ID:
			return getChild_frame_id();
		case Nav_datatypesPackage.ODOMETRY__POSE:
			return getPose();
		case Nav_datatypesPackage.ODOMETRY__TWIST:
			return getTwist();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Nav_datatypesPackage.ODOMETRY__HEADER:
			setHeader((Header)newValue);
			return;
		case Nav_datatypesPackage.ODOMETRY__CHILD_FRAME_ID:
			setChild_frame_id((String)newValue);
			return;
		case Nav_datatypesPackage.ODOMETRY__POSE:
			setPose((PoseWithCovariance)newValue);
			return;
		case Nav_datatypesPackage.ODOMETRY__TWIST:
			setTwist((TwistWithCovariance)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case Nav_datatypesPackage.ODOMETRY__HEADER:
			setHeader((Header)null);
			return;
		case Nav_datatypesPackage.ODOMETRY__CHILD_FRAME_ID:
			setChild_frame_id(CHILD_FRAME_ID_EDEFAULT);
			return;
		case Nav_datatypesPackage.ODOMETRY__POSE:
			setPose((PoseWithCovariance)null);
			return;
		case Nav_datatypesPackage.ODOMETRY__TWIST:
			setTwist((TwistWithCovariance)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case Nav_datatypesPackage.ODOMETRY__HEADER:
			return header != null;
		case Nav_datatypesPackage.ODOMETRY__CHILD_FRAME_ID:
			return CHILD_FRAME_ID_EDEFAULT == null ? child_frame_id != null : !CHILD_FRAME_ID_EDEFAULT.equals(child_frame_id);
		case Nav_datatypesPackage.ODOMETRY__POSE:
			return pose != null;
		case Nav_datatypesPackage.ODOMETRY__TWIST:
			return twist != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (child_frame_id: ");
		result.append(child_frame_id);
		result.append(')');
		return result.toString();
	}

} //OdometryImpl
