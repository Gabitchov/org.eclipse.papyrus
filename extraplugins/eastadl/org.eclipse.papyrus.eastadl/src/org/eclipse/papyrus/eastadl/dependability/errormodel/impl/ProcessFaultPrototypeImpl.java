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
package org.eclipse.papyrus.eastadl.dependability.errormodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype;
import org.eclipse.uml2.uml.Event;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Fault Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ProcessFaultPrototypeImpl#getBase_Event <em>Base Event</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessFaultPrototypeImpl extends AnomalyImpl implements ProcessFaultPrototype {

	/**
	 * The cached value of the '{@link #getBase_Event() <em>Base Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Event()
	 * @generated
	 * @ordered
	 */
	protected Event base_Event;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessFaultPrototypeImpl() {
		super();
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
		case ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT:
			if(resolve)
				return getBase_Event();
			return basicGetBase_Event();
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
		case ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT:
			return base_Event != null;
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT:
			setBase_Event((Event)newValue);
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
		return ErrormodelPackage.Literals.PROCESS_FAULT_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Event getBase_Event() {
		if(base_Event != null && base_Event.eIsProxy()) {
			InternalEObject oldBase_Event = (InternalEObject)base_Event;
			base_Event = (Event)eResolveProxy(oldBase_Event);
			if(base_Event != oldBase_Event) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT, oldBase_Event, base_Event));
			}
		}
		return base_Event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Event basicGetBase_Event() {
		return base_Event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Event(Event newBase_Event) {
		Event oldBase_Event = base_Event;
		base_Event = newBase_Event;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT, oldBase_Event, base_Event));
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
		case ErrormodelPackage.PROCESS_FAULT_PROTOTYPE__BASE_EVENT:
			setBase_Event((Event)null);
			return;
		}
		super.eUnset(featureID);
	}

} //ProcessFaultPrototypeImpl
