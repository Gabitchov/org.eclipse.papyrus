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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl#getMainInstance <em>Main Instance</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DeploymentPlanImpl extends EObjectImpl implements DeploymentPlan {

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The cached value of the '{@link #getMainInstance() <em>Main Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMainInstance()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification mainInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeploymentPlanImpl() {
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
		return RobotMLPackage.Literals.DEPLOYMENT_PLAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if(base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if(base_Package != oldBase_Package) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification getMainInstance() {
		if(mainInstance != null && mainInstance.eIsProxy()) {
			InternalEObject oldMainInstance = (InternalEObject)mainInstance;
			mainInstance = (InstanceSpecification)eResolveProxy(oldMainInstance);
			if(mainInstance != oldMainInstance) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE, oldMainInstance, mainInstance));
			}
		}
		return mainInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification basicGetMainInstance() {
		return mainInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMainInstance(InstanceSpecification newMainInstance) {
		InstanceSpecification oldMainInstance = mainInstance;
		mainInstance = newMainInstance;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE, oldMainInstance, mainInstance));
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
		case RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
		case RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE:
			if(resolve)
				return getMainInstance();
			return basicGetMainInstance();
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
			return;
		case RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE:
			setMainInstance((InstanceSpecification)newValue);
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
		case RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
			return;
		case RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE:
			setMainInstance((InstanceSpecification)null);
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
		case RobotMLPackage.DEPLOYMENT_PLAN__BASE_PACKAGE:
			return base_Package != null;
		case RobotMLPackage.DEPLOYMENT_PLAN__MAIN_INSTANCE:
			return mainInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //DeploymentPlanImpl
