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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JointState;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joint State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JointStateImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JointStateImpl#getPosition <em>
 * Position</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JointStateImpl#getVelocity <em>
 * Velocity</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.JointStateImpl#getEffort <em>Effort
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JointStateImpl extends EObjectImpl implements JointState {

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EList<String> name;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> position;

	/**
	 * The cached value of the '{@link #getVelocity() <em>Velocity</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVelocity()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> velocity;

	/**
	 * The cached value of the '{@link #getEffort() <em>Effort</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> effort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JointStateImpl() {
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
		return Sensor_datatypesPackage.Literals.JOINT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getName() {
		if(name == null) {
			name = new EDataTypeUniqueEList<String>(String.class, this, Sensor_datatypesPackage.JOINT_STATE__NAME);
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Double> getPosition() {
		if(position == null) {
			position = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.JOINT_STATE__POSITION);
		}
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Double> getVelocity() {
		if(velocity == null) {
			velocity = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.JOINT_STATE__VELOCITY);
		}
		return velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Double> getEffort() {
		if(effort == null) {
			effort = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.JOINT_STATE__EFFORT);
		}
		return effort;
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
		case Sensor_datatypesPackage.JOINT_STATE__NAME:
			return getName();
		case Sensor_datatypesPackage.JOINT_STATE__POSITION:
			return getPosition();
		case Sensor_datatypesPackage.JOINT_STATE__VELOCITY:
			return getVelocity();
		case Sensor_datatypesPackage.JOINT_STATE__EFFORT:
			return getEffort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Sensor_datatypesPackage.JOINT_STATE__NAME:
			getName().clear();
			getName().addAll((Collection<? extends String>)newValue);
			return;
		case Sensor_datatypesPackage.JOINT_STATE__POSITION:
			getPosition().clear();
			getPosition().addAll((Collection<? extends Double>)newValue);
			return;
		case Sensor_datatypesPackage.JOINT_STATE__VELOCITY:
			getVelocity().clear();
			getVelocity().addAll((Collection<? extends Double>)newValue);
			return;
		case Sensor_datatypesPackage.JOINT_STATE__EFFORT:
			getEffort().clear();
			getEffort().addAll((Collection<? extends Double>)newValue);
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
		case Sensor_datatypesPackage.JOINT_STATE__NAME:
			getName().clear();
			return;
		case Sensor_datatypesPackage.JOINT_STATE__POSITION:
			getPosition().clear();
			return;
		case Sensor_datatypesPackage.JOINT_STATE__VELOCITY:
			getVelocity().clear();
			return;
		case Sensor_datatypesPackage.JOINT_STATE__EFFORT:
			getEffort().clear();
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
		case Sensor_datatypesPackage.JOINT_STATE__NAME:
			return name != null && !name.isEmpty();
		case Sensor_datatypesPackage.JOINT_STATE__POSITION:
			return position != null && !position.isEmpty();
		case Sensor_datatypesPackage.JOINT_STATE__VELOCITY:
			return velocity != null && !velocity.isEmpty();
		case Sensor_datatypesPackage.JOINT_STATE__EFFORT:
			return effort != null && !effort.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", position: ");
		result.append(position);
		result.append(", velocity: ");
		result.append(velocity);
		result.append(", effort: ");
		result.append(effort);
		result.append(')');
		return result.toString();
	}

} //JointStateImpl
