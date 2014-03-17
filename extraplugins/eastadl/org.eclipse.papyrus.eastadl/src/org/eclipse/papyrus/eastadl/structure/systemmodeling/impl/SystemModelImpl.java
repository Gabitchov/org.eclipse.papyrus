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
package org.eclipse.papyrus.eastadl.structure.systemmodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getImplementationLevel <em>Implementation Level</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getAnalysisLevel <em>Analysis Level</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getDesignLevel <em>Design Level</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getVehicleLevel <em>Vehicle Level</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SystemModelImpl extends ContextImpl implements SystemModel {

	/**
	 * The cached value of the '{@link #getImplementationLevel() <em>Implementation Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getImplementationLevel()
	 * @generated
	 * @ordered
	 */
	protected ImplementationLevel implementationLevel;

	/**
	 * The cached value of the '{@link #getAnalysisLevel() <em>Analysis Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAnalysisLevel()
	 * @generated
	 * @ordered
	 */
	protected AnalysisLevel analysisLevel;

	/**
	 * The cached value of the '{@link #getDesignLevel() <em>Design Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDesignLevel()
	 * @generated
	 * @ordered
	 */
	protected DesignLevel designLevel;

	/**
	 * The cached value of the '{@link #getVehicleLevel() <em>Vehicle Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVehicleLevel()
	 * @generated
	 * @ordered
	 */
	protected VehicleLevel vehicleLevel;

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
	protected SystemModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalysisLevel basicGetAnalysisLevel() {
		return analysisLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignLevel basicGetDesignLevel() {
		return designLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImplementationLevel basicGetImplementationLevel() {
		return implementationLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VehicleLevel basicGetVehicleLevel() {
		return vehicleLevel;
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
		case SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL:
			if(resolve)
				return getImplementationLevel();
			return basicGetImplementationLevel();
		case SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL:
			if(resolve)
				return getAnalysisLevel();
			return basicGetAnalysisLevel();
		case SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL:
			if(resolve)
				return getDesignLevel();
			return basicGetDesignLevel();
		case SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL:
			if(resolve)
				return getVehicleLevel();
			return basicGetVehicleLevel();
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE:
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
		case SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL:
			return implementationLevel != null;
		case SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL:
			return analysisLevel != null;
		case SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL:
			return designLevel != null;
		case SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL:
			return vehicleLevel != null;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS:
			return base_Class != null;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL:
			setImplementationLevel((ImplementationLevel)newValue);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL:
			setAnalysisLevel((AnalysisLevel)newValue);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL:
			setDesignLevel((DesignLevel)newValue);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL:
			setVehicleLevel((VehicleLevel)newValue);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE:
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
		return SystemmodelingPackage.Literals.SYSTEM_MODEL;
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
		case SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL:
			setImplementationLevel((ImplementationLevel)null);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL:
			setAnalysisLevel((AnalysisLevel)null);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL:
			setDesignLevel((DesignLevel)null);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL:
			setVehicleLevel((VehicleLevel)null);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE:
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
	public AnalysisLevel getAnalysisLevel() {
		if(analysisLevel != null && analysisLevel.eIsProxy()) {
			InternalEObject oldAnalysisLevel = (InternalEObject)analysisLevel;
			analysisLevel = (AnalysisLevel)eResolveProxy(oldAnalysisLevel);
			if(analysisLevel != oldAnalysisLevel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL, oldAnalysisLevel, analysisLevel));
			}
		}
		return analysisLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignLevel getDesignLevel() {
		if(designLevel != null && designLevel.eIsProxy()) {
			InternalEObject oldDesignLevel = (InternalEObject)designLevel;
			designLevel = (DesignLevel)eResolveProxy(oldDesignLevel);
			if(designLevel != oldDesignLevel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL, oldDesignLevel, designLevel));
			}
		}
		return designLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImplementationLevel getImplementationLevel() {
		if(implementationLevel != null && implementationLevel.eIsProxy()) {
			InternalEObject oldImplementationLevel = (InternalEObject)implementationLevel;
			implementationLevel = (ImplementationLevel)eResolveProxy(oldImplementationLevel);
			if(implementationLevel != oldImplementationLevel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL, oldImplementationLevel, implementationLevel));
			}
		}
		return implementationLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VehicleLevel getVehicleLevel() {
		if(vehicleLevel != null && vehicleLevel.eIsProxy()) {
			InternalEObject oldVehicleLevel = (InternalEObject)vehicleLevel;
			vehicleLevel = (VehicleLevel)eResolveProxy(oldVehicleLevel);
			if(vehicleLevel != oldVehicleLevel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL, oldVehicleLevel, vehicleLevel));
			}
		}
		return vehicleLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnalysisLevel(AnalysisLevel newAnalysisLevel) {
		AnalysisLevel oldAnalysisLevel = analysisLevel;
		analysisLevel = newAnalysisLevel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__ANALYSIS_LEVEL, oldAnalysisLevel, analysisLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDesignLevel(DesignLevel newDesignLevel) {
		DesignLevel oldDesignLevel = designLevel;
		designLevel = newDesignLevel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__DESIGN_LEVEL, oldDesignLevel, designLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setImplementationLevel(ImplementationLevel newImplementationLevel) {
		ImplementationLevel oldImplementationLevel = implementationLevel;
		implementationLevel = newImplementationLevel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__IMPLEMENTATION_LEVEL, oldImplementationLevel, implementationLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVehicleLevel(VehicleLevel newVehicleLevel) {
		VehicleLevel oldVehicleLevel = vehicleLevel;
		vehicleLevel = newVehicleLevel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__VEHICLE_LEVEL, oldVehicleLevel, vehicleLevel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.SYSTEM_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
	}

} //SystemModelImpl
