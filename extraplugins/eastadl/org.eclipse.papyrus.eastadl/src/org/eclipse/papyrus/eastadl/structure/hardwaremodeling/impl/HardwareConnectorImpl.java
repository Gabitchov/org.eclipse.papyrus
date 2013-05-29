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
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hardware Connector</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl#getPort1_path <em>Port1 path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareConnectorImpl#getPort2_path <em>Port2 path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HardwareConnectorImpl extends EAElementImpl implements HardwareConnector {

	/**
	 * The cached value of the '{@link #getBase_Connector() <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Connector()
	 * @generated
	 * @ordered
	 */
	protected Connector base_Connector;

	/**
	 * The cached value of the '{@link #getPort1_path() <em>Port1 path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort1_path()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwareComponentPrototype> port1_path;

	/**
	 * The cached value of the '{@link #getPort2_path() <em>Port2 path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort2_path()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwareComponentPrototype> port2_path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HardwareConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT:
				return getPort();
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT1_PATH:
				return getPort1_path();
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT2_PATH:
				return getPort2_path();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR:
				return base_Connector != null;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT:
				return !getPort().isEmpty();
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT1_PATH:
				return port1_path != null && !port1_path.isEmpty();
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT2_PATH:
				return port2_path != null && !port2_path.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends HardwarePin>)newValue);
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT1_PATH:
				getPort1_path().clear();
				getPort1_path().addAll((Collection<? extends HardwareComponentPrototype>)newValue);
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT2_PATH:
				getPort2_path().clear();
				getPort2_path().addAll((Collection<? extends HardwareComponentPrototype>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwaremodelingPackage.Literals.HARDWARE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector getBase_Connector() {
		if (base_Connector != null && base_Connector.eIsProxy()) {
			InternalEObject oldBase_Connector = (InternalEObject)base_Connector;
			base_Connector = (Connector)eResolveProxy(oldBase_Connector);
			if (base_Connector != oldBase_Connector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
			}
		}
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector basicGetBase_Connector() {
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Connector(Connector newBase_Connector) {
		Connector oldBase_Connector = base_Connector;
		base_Connector = newBase_Connector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT:
				getPort().clear();
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT1_PATH:
				getPort1_path().clear();
				return;
			case HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT2_PATH:
				getPort2_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<HardwarePin> getPort() {
		// Implementation for abstract super class method (ADLVariableElement)
		EList<HardwarePin> results = new BasicEList<HardwarePin>();
		HardwarePin currentHwPort = null;

		// Retrieve base element
		if(getBase_Connector() != null) {
			Connector co = getBase_Connector();

			// Find HwPort
			Iterator<ConnectorEnd> it = co.getEnds().iterator();

			while(it.hasNext()) {
				ConnectorEnd currentEnd = it.next();
				if(currentEnd.getRole() != null) {
					currentHwPort = (HardwarePin)UMLUtil.getStereotypeApplication(currentEnd.getRole(),
						HardwarePin.class);

					if(currentHwPort != null) {
						results.add(currentHwPort);
					}
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<HardwarePin>(HardwarePin.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwareComponentPrototype> getPort1_path() {
		if (port1_path == null) {
			port1_path = new EObjectResolvingEList<HardwareComponentPrototype>(HardwareComponentPrototype.class, this, HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT1_PATH);
		}
		return port1_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwareComponentPrototype> getPort2_path() {
		if (port2_path == null) {
			port2_path = new EObjectResolvingEList<HardwareComponentPrototype>(HardwareComponentPrototype.class, this, HardwaremodelingPackage.HARDWARE_CONNECTOR__PORT2_PATH);
		}
		return port2_path;
	}

} // HardwareConnectorImpl
