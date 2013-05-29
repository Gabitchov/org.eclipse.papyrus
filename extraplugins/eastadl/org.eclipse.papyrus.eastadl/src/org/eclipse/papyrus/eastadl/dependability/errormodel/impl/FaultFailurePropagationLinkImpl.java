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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Fault Failure Propagation Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#isImmediatePropagation <em>Immediate Propagation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#getToPort <em>To Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#getFromPort <em>From Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#getFromPort_path <em>From Port path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl#getToPort_path <em>To Port path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultFailurePropagationLinkImpl extends EAElementImpl implements FaultFailurePropagationLink {

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
	 * The default value of the '{@link #isImmediatePropagation() <em>Immediate Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isImmediatePropagation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMMEDIATE_PROPAGATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImmediatePropagation() <em>Immediate Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isImmediatePropagation()
	 * @generated
	 * @ordered
	 */
	protected boolean immediatePropagation = IMMEDIATE_PROPAGATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFromPort_path() <em>From Port path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPort_path()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorModelPrototype> fromPort_path;

	/**
	 * The cached value of the '{@link #getToPort_path() <em>To Port path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPort_path()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorModelPrototype> toPort_path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultFailurePropagationLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FaultFailurePort basicGetFromPort() {
		FaultFailurePort currentFlowPort = null;

		if(getBase_Connector() != null) {
			// Parse owned Connectors
			if(getBase_Connector().getEnds().size() >= 2) {
				ConnectorEnd current = getBase_Connector().getEnds().get(0);
				ConnectableElement ce = current.getRole();

				if((ce != null) && (ce instanceof Port)) {
					// Test if ConnectableElement ce is FaultFailurePort
					currentFlowPort = (FaultFailurePort)UMLUtil.getStereotypeApplication(ce, 
						FaultFailurePort.class);
				}
			}
		}
		return currentFlowPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorModelPrototype> getFromPort_path() {
		if (fromPort_path == null) {
			fromPort_path = new EObjectResolvingEList<ErrorModelPrototype>(ErrorModelPrototype.class, this, ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH);
		}
		return fromPort_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorModelPrototype> getToPort_path() {
		if (toPort_path == null) {
			toPort_path = new EObjectResolvingEList<ErrorModelPrototype>(ErrorModelPrototype.class, this, ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH);
		}
		return toPort_path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FaultFailurePort basicGetToPort() {
		FaultFailurePort currentFlowPort = null;

		if(getBase_Connector() != null) {
			// Parse owned Connectors
			if(getBase_Connector().getEnds().size() >= 2) {
				ConnectorEnd current = getBase_Connector().getEnds().get(1);
				ConnectableElement ce = current.getRole();

				if((ce != null) && (ce instanceof Port)) {
					// Test if ce is stereotyped FaultFailurePort
					currentFlowPort = (FaultFailurePort)UMLUtil.getStereotypeApplication(ce, FaultFailurePort.class);
				}
			}
		}
		return currentFlowPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION:
				return isImmediatePropagation();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT:
				if (resolve) return getToPort();
				return basicGetToPort();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT:
				if (resolve) return getFromPort();
				return basicGetFromPort();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH:
				return getFromPort_path();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH:
				return getToPort_path();
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
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR:
				return base_Connector != null;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION:
				return immediatePropagation != IMMEDIATE_PROPAGATION_EDEFAULT;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT:
				return basicGetToPort() != null;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT:
				return basicGetFromPort() != null;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH:
				return fromPort_path != null && !fromPort_path.isEmpty();
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH:
				return toPort_path != null && !toPort_path.isEmpty();
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
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION:
				setImmediatePropagation((Boolean)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH:
				getFromPort_path().clear();
				getFromPort_path().addAll((Collection<? extends ErrorModelPrototype>)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH:
				getToPort_path().clear();
				getToPort_path().addAll((Collection<? extends ErrorModelPrototype>)newValue);
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
		return ErrormodelPackage.Literals.FAULT_FAILURE_PROPAGATION_LINK;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR, oldBase_Connector, base_Connector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION:
				setImmediatePropagation(IMMEDIATE_PROPAGATION_EDEFAULT);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH:
				getFromPort_path().clear();
				return;
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH:
				getToPort_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FaultFailurePort getFromPort() {
		FaultFailurePort fromPort = basicGetFromPort();
		return fromPort != null && fromPort.eIsProxy() ? (FaultFailurePort)eResolveProxy((InternalEObject)fromPort) : fromPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FaultFailurePort getToPort() {
		FaultFailurePort toPort = basicGetToPort();
		return toPort != null && toPort.eIsProxy() ? (FaultFailurePort)eResolveProxy((InternalEObject)toPort) : toPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediatePropagation() {
		return immediatePropagation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediatePropagation(boolean newImmediatePropagation) {
		boolean oldImmediatePropagation = immediatePropagation;
		immediatePropagation = newImmediatePropagation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION, oldImmediatePropagation, immediatePropagation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (immediatePropagation: ");
		result.append(immediatePropagation);
		result.append(')');
		return result.toString();
	}

} // FaultFailurePropagationLinkImpl
