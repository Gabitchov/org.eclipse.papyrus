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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit;

import org.eclipse.uml2.uml.BehavioredClassifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pp Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl#getConcPolicy <em>Conc Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PpUnitImpl extends EObjectImpl implements PpUnit {
	/**
	 * The default value of the '{@link #getConcPolicy() <em>Conc Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final CallConcurrencyKind CONC_POLICY_EDEFAULT = CallConcurrencyKind.SEQUENTIAL;

	/**
	 * The cached value of the '{@link #getConcPolicy() <em>Conc Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcPolicy()
	 * @generated
	 * @ordered
	 */
	protected CallConcurrencyKind concPolicy = CONC_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected String memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_BehavioredClassifier() <em>Base Behaviored Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioredClassifier()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClassifier base_BehavioredClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PpUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.PP_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallConcurrencyKind getConcPolicy() {
		return concPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcPolicy(CallConcurrencyKind newConcPolicy) {
		CallConcurrencyKind oldConcPolicy = concPolicy;
		concPolicy = newConcPolicy == null ? CONC_POLICY_EDEFAULT : newConcPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.PP_UNIT__CONC_POLICY, oldConcPolicy, concPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(String newMemorySize) {
		String oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.PP_UNIT__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier getBase_BehavioredClassifier() {
		if (base_BehavioredClassifier != null && base_BehavioredClassifier.eIsProxy()) {
			InternalEObject oldBase_BehavioredClassifier = (InternalEObject)base_BehavioredClassifier;
			base_BehavioredClassifier = (BehavioredClassifier)eResolveProxy(oldBase_BehavioredClassifier);
			if (base_BehavioredClassifier != oldBase_BehavioredClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER, oldBase_BehavioredClassifier, base_BehavioredClassifier));
			}
		}
		return base_BehavioredClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier basicGetBase_BehavioredClassifier() {
		return base_BehavioredClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_BehavioredClassifier(BehavioredClassifier newBase_BehavioredClassifier) {
		BehavioredClassifier oldBase_BehavioredClassifier = base_BehavioredClassifier;
		base_BehavioredClassifier = newBase_BehavioredClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER, oldBase_BehavioredClassifier, base_BehavioredClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.PP_UNIT__CONC_POLICY:
				return getConcPolicy();
			case HLAMPackage.PP_UNIT__MEMORY_SIZE:
				return getMemorySize();
			case HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				if (resolve) return getBase_BehavioredClassifier();
				return basicGetBase_BehavioredClassifier();
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
			case HLAMPackage.PP_UNIT__CONC_POLICY:
				setConcPolicy((CallConcurrencyKind)newValue);
				return;
			case HLAMPackage.PP_UNIT__MEMORY_SIZE:
				setMemorySize((String)newValue);
				return;
			case HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				setBase_BehavioredClassifier((BehavioredClassifier)newValue);
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
			case HLAMPackage.PP_UNIT__CONC_POLICY:
				setConcPolicy(CONC_POLICY_EDEFAULT);
				return;
			case HLAMPackage.PP_UNIT__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				setBase_BehavioredClassifier((BehavioredClassifier)null);
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
			case HLAMPackage.PP_UNIT__CONC_POLICY:
				return concPolicy != CONC_POLICY_EDEFAULT;
			case HLAMPackage.PP_UNIT__MEMORY_SIZE:
				return MEMORY_SIZE_EDEFAULT == null ? memorySize != null : !MEMORY_SIZE_EDEFAULT.equals(memorySize);
			case HLAMPackage.PP_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				return base_BehavioredClassifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (concPolicy: ");
		result.append(concPolicy);
		result.append(", memorySize: ");
		result.append(memorySize);
		result.append(')');
		return result.toString();
	}

} //PpUnitImpl
