/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.timing.events.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.papyrus.eastadl.timing.events.EventFunction;
import org.eclipse.papyrus.eastadl.timing.events.EventsPackage;
import org.eclipse.papyrus.eastadl.timing.impl.EventImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl#getFunction <em>Function</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl#getFunctionType <em>Function Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl#getFunction_path <em>Function path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EventFunctionImpl extends EventImpl implements EventFunction {

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionPrototype function;

	/**
	 * The cached value of the '{@link #getFunctionType() <em>Function Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunctionType()
	 * @generated
	 * @ordered
	 */
	protected FunctionType functionType;

	/**
	 * The cached value of the '{@link #getFunction_path() <em>Function path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunction_path()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPrototype> function_path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EventFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionPrototype basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionType basicGetFunctionType() {
		return functionType;
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
		case EventsPackage.EVENT_FUNCTION__FUNCTION:
			if(resolve)
				return getFunction();
			return basicGetFunction();
		case EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE:
			if(resolve)
				return getFunctionType();
			return basicGetFunctionType();
		case EventsPackage.EVENT_FUNCTION__FUNCTION_PATH:
			return getFunction_path();
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
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case EventsPackage.EVENT_FUNCTION__FUNCTION:
			return function != null;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE:
			return functionType != null;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_PATH:
			return function_path != null && !function_path.isEmpty();
		}
		return super.eIsSet(featureID);
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
		case EventsPackage.EVENT_FUNCTION__FUNCTION:
			setFunction((FunctionPrototype)newValue);
			return;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE:
			setFunctionType((FunctionType)newValue);
			return;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_PATH:
			getFunction_path().clear();
			getFunction_path().addAll((Collection<? extends FunctionPrototype>)newValue);
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
	protected EClass eStaticClass() {
		return EventsPackage.Literals.EVENT_FUNCTION;
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
		case EventsPackage.EVENT_FUNCTION__FUNCTION:
			setFunction((FunctionPrototype)null);
			return;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE:
			setFunctionType((FunctionType)null);
			return;
		case EventsPackage.EVENT_FUNCTION__FUNCTION_PATH:
			getFunction_path().clear();
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
	public FunctionPrototype getFunction() {
		if(function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (FunctionPrototype)eResolveProxy(oldFunction);
			if(function != oldFunction) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.EVENT_FUNCTION__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionType getFunctionType() {
		if(functionType != null && functionType.eIsProxy()) {
			InternalEObject oldFunctionType = (InternalEObject)functionType;
			functionType = (FunctionType)eResolveProxy(oldFunctionType);
			if(functionType != oldFunctionType) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE, oldFunctionType, functionType));
			}
		}
		return functionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFunction(FunctionPrototype newFunction) {
		FunctionPrototype oldFunction = function;
		function = newFunction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FUNCTION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFunctionType(FunctionType newFunctionType) {
		FunctionType oldFunctionType = functionType;
		functionType = newFunctionType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FUNCTION__FUNCTION_TYPE, oldFunctionType, functionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FunctionPrototype> getFunction_path() {
		if(function_path == null) {
			function_path = new EObjectResolvingEList<FunctionPrototype>(FunctionPrototype.class, this, EventsPackage.EVENT_FUNCTION__FUNCTION_PATH);
		}
		return function_path;
	}

} //EventFunctionImpl
