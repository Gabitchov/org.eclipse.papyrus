/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.FCM.CodeGenOptions;
import org.eclipse.papyrus.FCM.CompToOOmapping;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.ProgLanguage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Gen Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.CodeGenOptionsImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.CodeGenOptionsImpl#getCompToOOmapping <em>Comp To OOmapping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.CodeGenOptionsImpl#getProgLanguage <em>Prog Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeGenOptionsImpl extends EObjectImpl implements CodeGenOptions {
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
	 * The cached value of the '{@link #getCompToOOmapping() <em>Comp To OOmapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompToOOmapping()
	 * @generated
	 * @ordered
	 */
	protected CompToOOmapping compToOOmapping;

	/**
	 * The cached value of the '{@link #getProgLanguage() <em>Prog Language</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgLanguage()
	 * @generated
	 * @ordered
	 */
	protected ProgLanguage progLanguage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeGenOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.CODE_GEN_OPTIONS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompToOOmapping getCompToOOmapping() {
		if (compToOOmapping != null && compToOOmapping.eIsProxy()) {
			InternalEObject oldCompToOOmapping = (InternalEObject)compToOOmapping;
			compToOOmapping = (CompToOOmapping)eResolveProxy(oldCompToOOmapping);
			if (compToOOmapping != oldCompToOOmapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING, oldCompToOOmapping, compToOOmapping));
			}
		}
		return compToOOmapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompToOOmapping basicGetCompToOOmapping() {
		return compToOOmapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompToOOmapping(CompToOOmapping newCompToOOmapping) {
		CompToOOmapping oldCompToOOmapping = compToOOmapping;
		compToOOmapping = newCompToOOmapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING, oldCompToOOmapping, compToOOmapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgLanguage getProgLanguage() {
		if (progLanguage != null && progLanguage.eIsProxy()) {
			InternalEObject oldProgLanguage = (InternalEObject)progLanguage;
			progLanguage = (ProgLanguage)eResolveProxy(oldProgLanguage);
			if (progLanguage != oldProgLanguage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE, oldProgLanguage, progLanguage));
			}
		}
		return progLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgLanguage basicGetProgLanguage() {
		return progLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgLanguage(ProgLanguage newProgLanguage) {
		ProgLanguage oldProgLanguage = progLanguage;
		progLanguage = newProgLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE, oldProgLanguage, progLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING:
				if (resolve) return getCompToOOmapping();
				return basicGetCompToOOmapping();
			case FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE:
				if (resolve) return getProgLanguage();
				return basicGetProgLanguage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING:
				setCompToOOmapping((CompToOOmapping)newValue);
				return;
			case FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE:
				setProgLanguage((ProgLanguage)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING:
				setCompToOOmapping((CompToOOmapping)null);
				return;
			case FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE:
				setProgLanguage((ProgLanguage)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FCMPackage.CODE_GEN_OPTIONS__BASE_PACKAGE:
				return base_Package != null;
			case FCMPackage.CODE_GEN_OPTIONS__COMP_TO_OOMAPPING:
				return compToOOmapping != null;
			case FCMPackage.CODE_GEN_OPTIONS__PROG_LANGUAGE:
				return progLanguage != null;
		}
		return super.eIsSet(featureID);
	}

} //CodeGenOptionsImpl
