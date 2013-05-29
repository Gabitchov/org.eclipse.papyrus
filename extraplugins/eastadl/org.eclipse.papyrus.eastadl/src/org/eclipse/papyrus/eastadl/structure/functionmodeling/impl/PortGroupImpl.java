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
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

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
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Port Group</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.PortGroupImpl#getPortGroup <em>Port Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortGroupImpl extends EAElementImpl implements PortGroup {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The cached value of the '{@link #getPortGroup() <em>Port Group</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPortGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<PortGroup> portGroup;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PortGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionmodelingPackage.PORT_GROUP__PORT:
				return getPort();
			case FunctionmodelingPackage.PORT_GROUP__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case FunctionmodelingPackage.PORT_GROUP__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case FunctionmodelingPackage.PORT_GROUP__PORT_GROUP:
				return getPortGroup();
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
			case FunctionmodelingPackage.PORT_GROUP__PORT:
				return !getPort().isEmpty();
			case FunctionmodelingPackage.PORT_GROUP__BASE_CLASS:
				return base_Class != null;
			case FunctionmodelingPackage.PORT_GROUP__BASE_PORT:
				return base_Port != null;
			case FunctionmodelingPackage.PORT_GROUP__PORT_GROUP:
				return portGroup != null && !portGroup.isEmpty();
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
			case FunctionmodelingPackage.PORT_GROUP__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case FunctionmodelingPackage.PORT_GROUP__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case FunctionmodelingPackage.PORT_GROUP__PORT_GROUP:
				getPortGroup().clear();
				getPortGroup().addAll((Collection<? extends PortGroup>)newValue);
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
		return FunctionmodelingPackage.Literals.PORT_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionmodelingPackage.PORT_GROUP__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case FunctionmodelingPackage.PORT_GROUP__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case FunctionmodelingPackage.PORT_GROUP__PORT_GROUP:
				getPortGroup().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<FunctionPort> getPort() {

		EList<FunctionPort> groupedPorts = new BasicEList<FunctionPort>();
		FunctionPort currentFunctionPort;

		if(getBase_Class() != null) {
			// Parse owned Ports
			Iterator<Port> itDep = getBase_Class().getOwnedPorts().iterator();
			while(itDep.hasNext()) {
				Port currentPort = itDep.next();

				// Test if currentPort is stereotyped ADLFlowPort
				currentFunctionPort = (FunctionPort)UMLUtil.getStereotypeApplication(currentPort,
					FunctionPort.class);

				if(currentFunctionPort != null) {
					groupedPorts.add(currentFunctionPort);
				}
			}
		} else if(getBase_Port() != null) {
			// When the stereotype is applied on a Port, the port is expected
			// to be type by a "ADLPortGroup" Class
			// getGroupedPort returns the grouped ports of the ADLPortGroup type
			Type type = getBase_Port().getType();
			if(type instanceof Class) {

				PortGroup currentPortGroupType = (PortGroup)UMLUtil.getStereotypeApplication(type,
						PortGroup.class);

				// The port type is stereotype ADLPortGroup
				if(currentPortGroupType != null) {
					groupedPorts.addAll(currentPortGroupType.getPort());
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<FunctionPort>(FunctionPort.class, groupedPorts.size(), groupedPorts.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.PORT_GROUP__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.PORT_GROUP__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.PORT_GROUP__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.PORT_GROUP__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortGroup> getPortGroup() {
		if (portGroup == null) {
			portGroup = new EObjectResolvingEList<PortGroup>(PortGroup.class, this, FunctionmodelingPackage.PORT_GROUP__PORT_GROUP);
		}
		return portGroup;
	}

} // PortGroupImpl
