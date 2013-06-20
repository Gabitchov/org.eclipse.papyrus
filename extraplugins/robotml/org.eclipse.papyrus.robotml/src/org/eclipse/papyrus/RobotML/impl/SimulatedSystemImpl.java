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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.SimulatedSystem;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulated System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl#getBase_Property <em>Base Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl#getMesh <em>Mesh</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SimulatedSystemImpl extends SoftwareImpl implements SimulatedSystem {

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getMesh() <em>Mesh</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMesh()
	 * @generated
	 * @ordered
	 */
	protected EList<String> mesh;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SimulatedSystemImpl() {
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
		return RobotMLPackage.Literals.SIMULATED_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property getBase_Property() {
		if(base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if(base_Property != oldBase_Property) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getMesh() {
		if(mesh == null) {
			mesh = new EDataTypeUniqueEList<String>(String.class, this, RobotMLPackage.SIMULATED_SYSTEM__MESH);
		}
		return mesh;
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
		case RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY:
			if(resolve)
				return getBase_Property();
			return basicGetBase_Property();
		case RobotMLPackage.SIMULATED_SYSTEM__MESH:
			return getMesh();
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
		case RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY:
			setBase_Property((Property)newValue);
			return;
		case RobotMLPackage.SIMULATED_SYSTEM__MESH:
			getMesh().clear();
			getMesh().addAll((Collection<? extends String>)newValue);
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
		case RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY:
			setBase_Property((Property)null);
			return;
		case RobotMLPackage.SIMULATED_SYSTEM__MESH:
			getMesh().clear();
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
		case RobotMLPackage.SIMULATED_SYSTEM__BASE_PROPERTY:
			return base_Property != null;
		case RobotMLPackage.SIMULATED_SYSTEM__MESH:
			return mesh != null && !mesh.isEmpty();
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
		result.append(" (mesh: ");
		result.append(mesh);
		result.append(')');
		return result.toString();
	}

} //SimulatedSystemImpl
