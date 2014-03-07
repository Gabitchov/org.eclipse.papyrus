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
import org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype;
import org.eclipse.uml2.uml.Event;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Fault Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl#getBase_Event <em>Base Event</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InternalFaultPrototypeImpl extends AnomalyImpl implements InternalFaultPrototype {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

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
	protected InternalFaultPrototypeImpl() {
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
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT:
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
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS:
			return base_Class != null;
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT:
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
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT:
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
		return ErrormodelPackage.Literals.INTERNAL_FAULT_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT, oldBase_Event, base_Event));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT, oldBase_Event, base_Event));
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
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE__BASE_EVENT:
			setBase_Event((Event)null);
			return;
		}
		super.eUnset(featureID);
	}

} //InternalFaultPrototypeImpl
