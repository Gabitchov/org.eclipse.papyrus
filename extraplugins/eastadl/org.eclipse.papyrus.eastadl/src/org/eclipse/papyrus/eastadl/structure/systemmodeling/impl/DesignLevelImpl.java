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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Design Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl#getFunctionalDesignArchitecture <em>Functional Design Architecture</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl#getHardwareDesignArchitecture <em>Hardware Design Architecture</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DesignLevelImpl extends ContextImpl implements DesignLevel {
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
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The cached value of the '{@link #getFunctionalDesignArchitecture() <em>Functional Design Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalDesignArchitecture()
	 * @generated
	 * @ordered
	 */
	protected DesignFunctionPrototype functionalDesignArchitecture;

	/**
	 * The cached value of the '{@link #getHardwareDesignArchitecture() <em>Hardware Design Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardwareDesignArchitecture()
	 * @generated
	 * @ordered
	 */
	protected HardwareComponentPrototype hardwareDesignArchitecture;

	/**
	 * The cached value of the '{@link #getAllocation() <em>Allocation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocation()
	 * @generated
	 * @ordered
	 */
	protected EList<Allocation> allocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DesignLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignFunctionPrototype basicGetFunctionalDesignArchitecture() {
		return functionalDesignArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareComponentPrototype basicGetHardwareDesignArchitecture() {
		return hardwareDesignArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE:
				if (resolve) return getFunctionalDesignArchitecture();
				return basicGetFunctionalDesignArchitecture();
			case SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE:
				if (resolve) return getHardwareDesignArchitecture();
				return basicGetHardwareDesignArchitecture();
			case SystemmodelingPackage.DESIGN_LEVEL__ALLOCATION:
				return getAllocation();
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
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS:
				return base_Class != null;
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE:
				return base_Package != null;
			case SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE:
				return functionalDesignArchitecture != null;
			case SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE:
				return hardwareDesignArchitecture != null;
			case SystemmodelingPackage.DESIGN_LEVEL__ALLOCATION:
				return allocation != null && !allocation.isEmpty();
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
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE:
				setFunctionalDesignArchitecture((DesignFunctionPrototype)newValue);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE:
				setHardwareDesignArchitecture((HardwareComponentPrototype)newValue);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__ALLOCATION:
				getAllocation().clear();
				getAllocation().addAll((Collection<? extends Allocation>)newValue);
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
		return SystemmodelingPackage.Literals.DESIGN_LEVEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE:
				setFunctionalDesignArchitecture((DesignFunctionPrototype)null);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE:
				setHardwareDesignArchitecture((HardwareComponentPrototype)null);
				return;
			case SystemmodelingPackage.DESIGN_LEVEL__ALLOCATION:
				getAllocation().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Allocation> getAllocation() {
		if (allocation == null) {
			allocation = new EObjectResolvingEList<Allocation>(Allocation.class, this, SystemmodelingPackage.DESIGN_LEVEL__ALLOCATION);
		}
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignFunctionPrototype getFunctionalDesignArchitecture() {
		if (functionalDesignArchitecture != null && functionalDesignArchitecture.eIsProxy()) {
			InternalEObject oldFunctionalDesignArchitecture = (InternalEObject)functionalDesignArchitecture;
			functionalDesignArchitecture = (DesignFunctionPrototype)eResolveProxy(oldFunctionalDesignArchitecture);
			if (functionalDesignArchitecture != oldFunctionalDesignArchitecture) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE, oldFunctionalDesignArchitecture, functionalDesignArchitecture));
			}
		}
		return functionalDesignArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareComponentPrototype getHardwareDesignArchitecture() {
		if (hardwareDesignArchitecture != null && hardwareDesignArchitecture.eIsProxy()) {
			InternalEObject oldHardwareDesignArchitecture = (InternalEObject)hardwareDesignArchitecture;
			hardwareDesignArchitecture = (HardwareComponentPrototype)eResolveProxy(oldHardwareDesignArchitecture);
			if (hardwareDesignArchitecture != oldHardwareDesignArchitecture) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE, oldHardwareDesignArchitecture, hardwareDesignArchitecture));
			}
		}
		return hardwareDesignArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionalDesignArchitecture(DesignFunctionPrototype newFunctionalDesignArchitecture) {
		DesignFunctionPrototype oldFunctionalDesignArchitecture = functionalDesignArchitecture;
		functionalDesignArchitecture = newFunctionalDesignArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE, oldFunctionalDesignArchitecture, functionalDesignArchitecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardwareDesignArchitecture(HardwareComponentPrototype newHardwareDesignArchitecture) {
		HardwareComponentPrototype oldHardwareDesignArchitecture = hardwareDesignArchitecture;
		hardwareDesignArchitecture = newHardwareDesignArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE, oldHardwareDesignArchitecture, hardwareDesignArchitecture));
	}

} //DesignLevelImpl
