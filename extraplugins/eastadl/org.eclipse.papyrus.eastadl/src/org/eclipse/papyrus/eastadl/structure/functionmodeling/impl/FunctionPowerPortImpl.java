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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Function Power Port</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionPowerPortImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FunctionPowerPortImpl extends FunctionPortImpl implements FunctionPowerPort {

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionPowerPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CompositeDatatype basicGetType() {
		CompositeDatatype dataType = null;

		if(getBase_Port() != null) {
			Type umlType = getBase_Port().getType();

			if(umlType != null) {
				dataType = (CompositeDatatype)UMLUtil.getStereotypeApplication(umlType, CompositeDatatype.class);
			}
		}

		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT:
			if(resolve)
				return getBase_Port();
			return basicGetBase_Port();
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__TYPE:
			if(resolve)
				return getType();
			return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT:
			return base_Port != null;
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__TYPE:
			return basicGetType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT:
			setBase_Port((Port)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionmodelingPackage.Literals.FUNCTION_POWER_PORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT, oldBase_Port, base_Port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case FunctionmodelingPackage.FUNCTION_POWER_PORT__BASE_PORT:
			setBase_Port((Port)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeDatatype getType() {
		CompositeDatatype type = basicGetType();
		return type != null && type.eIsProxy() ? (CompositeDatatype)eResolveProxy((InternalEObject)type) : type;
	}

} // FunctionPowerPortImpl
