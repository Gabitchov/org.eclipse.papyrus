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
package org.eclipse.papyrus.eastadl.environment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.environment.ClampConnector;
import org.eclipse.papyrus.eastadl.environment.Environment;
import org.eclipse.papyrus.eastadl.environment.EnvironmentPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl#getEnvironmentModel <em>Environment Model</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl#getClampConnector <em>Clamp Connector</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.environment.impl.EnvironmentImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnvironmentImpl extends ContextImpl implements Environment {

	/**
	 * The cached value of the '{@link #getEnvironmentModel() <em>Environment Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEnvironmentModel()
	 * @generated
	 * @ordered
	 */
	protected FunctionPrototype environmentModel;

	/**
	 * The cached value of the '{@link #getClampConnector() <em>Clamp Connector</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getClampConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<ClampConnector> clampConnector;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionPrototype basicGetEnvironmentModel() {
		return environmentModel;
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
		case EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL:
			if(resolve)
				return getEnvironmentModel();
			return basicGetEnvironmentModel();
		case EnvironmentPackage.ENVIRONMENT__CLAMP_CONNECTOR:
			return getClampConnector();
		case EnvironmentPackage.ENVIRONMENT__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
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
		case EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL:
			return environmentModel != null;
		case EnvironmentPackage.ENVIRONMENT__CLAMP_CONNECTOR:
			return clampConnector != null && !clampConnector.isEmpty();
		case EnvironmentPackage.ENVIRONMENT__BASE_CLASS:
			return base_Class != null;
		case EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE:
			return base_Package != null;
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
		case EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL:
			setEnvironmentModel((FunctionPrototype)newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__CLAMP_CONNECTOR:
			getClampConnector().clear();
			getClampConnector().addAll((Collection<? extends ClampConnector>)newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
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
		return EnvironmentPackage.Literals.ENVIRONMENT;
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
		case EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL:
			setEnvironmentModel((FunctionPrototype)null);
			return;
		case EnvironmentPackage.ENVIRONMENT__CLAMP_CONNECTOR:
			getClampConnector().clear();
			return;
		case EnvironmentPackage.ENVIRONMENT__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
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
	public EList<ClampConnector> getClampConnector() {
		if(clampConnector == null) {
			clampConnector = new EObjectResolvingEList<ClampConnector>(ClampConnector.class, this, EnvironmentPackage.ENVIRONMENT__CLAMP_CONNECTOR);
		}
		return clampConnector;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnvironmentPackage.ENVIRONMENT__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.ENVIRONMENT__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.ENVIRONMENT__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionPrototype getEnvironmentModel() {
		if(environmentModel != null && environmentModel.eIsProxy()) {
			InternalEObject oldEnvironmentModel = (InternalEObject)environmentModel;
			environmentModel = (FunctionPrototype)eResolveProxy(oldEnvironmentModel);
			if(environmentModel != oldEnvironmentModel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL, oldEnvironmentModel, environmentModel));
			}
		}
		return environmentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEnvironmentModel(FunctionPrototype newEnvironmentModel) {
		FunctionPrototype oldEnvironmentModel = environmentModel;
		environmentModel = newEnvironmentModel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.ENVIRONMENT__ENVIRONMENT_MODEL, oldEnvironmentModel, environmentModel));
	}

} //EnvironmentImpl
