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
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort;
import org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind;
import org.eclipse.papyrus.eastadl.timing.events.EventsPackage;
import org.eclipse.papyrus.eastadl.timing.impl.EventImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Function Client Server Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl#getEventKind <em>Event Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl#getPort_path <em>Port path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventFunctionClientServerPortImpl extends EventImpl implements EventFunctionClientServerPort {
	/**
	 * The default value of the '{@link #getEventKind() <em>Event Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventKind()
	 * @generated
	 * @ordered
	 */
	protected static final EventFunctionClientServerPortKind EVENT_KIND_EDEFAULT = EventFunctionClientServerPortKind.RECEIVED_REQUEST;

	/**
	 * The cached value of the '{@link #getEventKind() <em>Event Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventKind()
	 * @generated
	 * @ordered
	 */
	protected EventFunctionClientServerPortKind eventKind = EVENT_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected FunctionClientServerPort port;

	/**
	 * The cached value of the '{@link #getPort_path() <em>Port path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort_path()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPrototype> port_path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventFunctionClientServerPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionClientServerPort basicGetPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND:
				return getEventKind();
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT:
				if (resolve) return getPort();
				return basicGetPort();
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH:
				return getPort_path();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND:
				return eventKind != EVENT_KIND_EDEFAULT;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT:
				return port != null;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH:
				return port_path != null && !port_path.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND:
				setEventKind((EventFunctionClientServerPortKind)newValue);
				return;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT:
				setPort((FunctionClientServerPort)newValue);
				return;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH:
				getPort_path().clear();
				getPort_path().addAll((Collection<? extends FunctionPrototype>)newValue);
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
	protected EClass eStaticClass() {
		return EventsPackage.Literals.EVENT_FUNCTION_CLIENT_SERVER_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND:
				setEventKind(EVENT_KIND_EDEFAULT);
				return;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT:
				setPort((FunctionClientServerPort)null);
				return;
			case EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH:
				getPort_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventFunctionClientServerPortKind getEventKind() {
		return eventKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionClientServerPort getPort() {
		if (port != null && port.eIsProxy()) {
			InternalEObject oldPort = (InternalEObject)port;
			port = (FunctionClientServerPort)eResolveProxy(oldPort);
			if (port != oldPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT, oldPort, port));
			}
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventKind(EventFunctionClientServerPortKind newEventKind) {
		EventFunctionClientServerPortKind oldEventKind = eventKind;
		eventKind = newEventKind == null ? EVENT_KIND_EDEFAULT : newEventKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND, oldEventKind, eventKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(FunctionClientServerPort newPort) {
		FunctionClientServerPort oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionPrototype> getPort_path() {
		if (port_path == null) {
			port_path = new EObjectResolvingEList<FunctionPrototype>(FunctionPrototype.class, this, EventsPackage.EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH);
		}
		return port_path;
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
		result.append(" (eventKind: ");
		result.append(eventKind);
		result.append(')');
		return result.toString();
	}

} //EventFunctionClientServerPortImpl
