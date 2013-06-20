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
package org.eclipse.papyrus.RobotML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.RobotML.Algorithm;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.State;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.StateImpl#getBase_State <em>Base State</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.StateImpl#getOperation <em>Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.StateImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {

	/**
	 * The cached value of the '{@link #getBase_State() <em>Base State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_State()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.State base_State;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Algorithm operation;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StateImpl() {
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
		return RobotMLPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.State getBase_State() {
		if(base_State != null && base_State.eIsProxy()) {
			InternalEObject oldBase_State = (InternalEObject)base_State;
			base_State = (org.eclipse.uml2.uml.State)eResolveProxy(oldBase_State);
			if(base_State != oldBase_State) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.STATE__BASE_STATE, oldBase_State, base_State));
			}
		}
		return base_State;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.State basicGetBase_State() {
		return base_State;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_State(org.eclipse.uml2.uml.State newBase_State) {
		org.eclipse.uml2.uml.State oldBase_State = base_State;
		base_State = newBase_State;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STATE__BASE_STATE, oldBase_State, base_State));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm getOperation() {
		if(operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (Algorithm)eResolveProxy(oldOperation);
			if(operation != oldOperation) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.STATE__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Algorithm basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOperation(Algorithm newOperation) {
		Algorithm oldOperation = operation;
		operation = newOperation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STATE__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Property> getArguments() {
		if(arguments == null) {
			arguments = new EObjectResolvingEList<Property>(Property.class, this, RobotMLPackage.STATE__ARGUMENTS);
		}
		return arguments;
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
		case RobotMLPackage.STATE__BASE_STATE:
			if(resolve)
				return getBase_State();
			return basicGetBase_State();
		case RobotMLPackage.STATE__OPERATION:
			if(resolve)
				return getOperation();
			return basicGetOperation();
		case RobotMLPackage.STATE__ARGUMENTS:
			return getArguments();
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
		case RobotMLPackage.STATE__BASE_STATE:
			setBase_State((org.eclipse.uml2.uml.State)newValue);
			return;
		case RobotMLPackage.STATE__OPERATION:
			setOperation((Algorithm)newValue);
			return;
		case RobotMLPackage.STATE__ARGUMENTS:
			getArguments().clear();
			getArguments().addAll((Collection<? extends Property>)newValue);
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
		case RobotMLPackage.STATE__BASE_STATE:
			setBase_State((org.eclipse.uml2.uml.State)null);
			return;
		case RobotMLPackage.STATE__OPERATION:
			setOperation((Algorithm)null);
			return;
		case RobotMLPackage.STATE__ARGUMENTS:
			getArguments().clear();
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
		case RobotMLPackage.STATE__BASE_STATE:
			return base_State != null;
		case RobotMLPackage.STATE__OPERATION:
			return operation != null;
		case RobotMLPackage.STATE__ARGUMENTS:
			return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
