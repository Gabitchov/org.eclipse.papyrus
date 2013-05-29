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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Validation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl#getVerify <em>Verify</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl#getVvCase <em>Vv Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl#getVvTarget <em>Vv Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationValidationImpl extends ContextImpl implements VerificationValidation {
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
	 * The cached value of the '{@link #getVerify() <em>Verify</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerify()
	 * @generated
	 * @ordered
	 */
	protected EList<Verify> verify;

	/**
	 * The cached value of the '{@link #getVvCase() <em>Vv Case</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVvCase()
	 * @generated
	 * @ordered
	 */
	protected EList<VVCase> vvCase;

	/**
	 * The cached value of the '{@link #getVvTarget() <em>Vv Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVvTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<VVTarget> vvTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerificationValidationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VERIFY:
				return getVerify();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_CASE:
				return getVvCase();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_TARGET:
				return getVvTarget();
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
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS:
				return base_Class != null;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE:
				return base_Package != null;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VERIFY:
				return verify != null && !verify.isEmpty();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_CASE:
				return vvCase != null && !vvCase.isEmpty();
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_TARGET:
				return vvTarget != null && !vvTarget.isEmpty();
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
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VERIFY:
				getVerify().clear();
				getVerify().addAll((Collection<? extends Verify>)newValue);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_CASE:
				getVvCase().clear();
				getVvCase().addAll((Collection<? extends VVCase>)newValue);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_TARGET:
				getVvTarget().clear();
				getVvTarget().addAll((Collection<? extends VVTarget>)newValue);
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
		return VerificationvalidationPackage.Literals.VERIFICATION_VALIDATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VERIFY:
				getVerify().clear();
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_CASE:
				getVvCase().clear();
				return;
			case VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_TARGET:
				getVvTarget().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Verify> getVerify() {
		if (verify == null) {
			verify = new EObjectResolvingEList<Verify>(Verify.class, this, VerificationvalidationPackage.VERIFICATION_VALIDATION__VERIFY);
		}
		return verify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VVCase> getVvCase() {
		if (vvCase == null) {
			vvCase = new EObjectResolvingEList<VVCase>(VVCase.class, this, VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_CASE);
		}
		return vvCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VVTarget> getVvTarget() {
		if (vvTarget == null) {
			vvTarget = new EObjectResolvingEList<VVTarget>(VVTarget.class, this, VerificationvalidationPackage.VERIFICATION_VALIDATION__VV_TARGET);
		}
		return vvTarget;
	}

} //VerificationValidationImpl
