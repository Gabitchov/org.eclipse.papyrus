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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.uml2.uml.Port;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hardware Pin Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl#getPortGroup <em>Port Group</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinGroupImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class HardwarePinGroupImpl extends EAElementImpl implements HardwarePinGroup {

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

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
	 * The cached value of the '{@link #getPortGroup() <em>Port Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPortGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwarePinGroup> portGroup;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwarePin> port;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected HardwarePinGroupImpl() {
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
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT:
			if(resolve)
				return getBase_Port();
			return basicGetBase_Port();
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT_GROUP:
			return getPortGroup();
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT:
			return getPort();
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
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT:
			return base_Port != null;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS:
			return base_Class != null;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT_GROUP:
			return portGroup != null && !portGroup.isEmpty();
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT:
			return port != null && !port.isEmpty();
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
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT:
			setBase_Port((Port)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT_GROUP:
			getPortGroup().clear();
			getPortGroup().addAll((Collection<? extends HardwarePinGroup>)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT:
			getPort().clear();
			getPort().addAll((Collection<? extends HardwarePin>)newValue);
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
		return HardwaremodelingPackage.Literals.HARDWARE_PIN_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port getBase_Port() {
		if(base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if(base_Port != oldBase_Port) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT, oldBase_Port, base_Port));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS, oldBase_Class, base_Class));
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
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_PORT:
			setBase_Port((Port)null);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT_GROUP:
			getPortGroup().clear();
			return;
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT:
			getPort().clear();
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
	public EList<HardwarePin> getPort() {
		if(port == null) {
			port = new EObjectResolvingEList<HardwarePin>(HardwarePin.class, this, HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT);
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<HardwarePinGroup> getPortGroup() {
		if(portGroup == null) {
			portGroup = new EObjectResolvingEList<HardwarePinGroup>(HardwarePinGroup.class, this, HardwaremodelingPackage.HARDWARE_PIN_GROUP__PORT_GROUP);
		}
		return portGroup;
	}

} //HardwarePinGroupImpl
