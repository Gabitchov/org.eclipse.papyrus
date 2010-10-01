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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwRAM;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.Repl_Policy;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.WritePolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw RAM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getIsSynchronous <em>Is Synchronous</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getIsNonVolatile <em>Is Non Volatile</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getRepl_Policy <em>Repl Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwRAMImpl#getWritePolicy <em>Write Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwRAMImpl extends HwMemoryImpl implements HwRAM {
	/**
	 * The default value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected String organization = ORGANIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsSynchronous() <em>Is Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSynchronous()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SYNCHRONOUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSynchronous() <em>Is Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSynchronous()
	 * @generated
	 * @ordered
	 */
	protected String isSynchronous = IS_SYNCHRONOUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsStatic()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_STATIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsStatic()
	 * @generated
	 * @ordered
	 */
	protected String isStatic = IS_STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsNonVolatile() <em>Is Non Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsNonVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_NON_VOLATILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsNonVolatile() <em>Is Non Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsNonVolatile()
	 * @generated
	 * @ordered
	 */
	protected String isNonVolatile = IS_NON_VOLATILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepl_Policy() <em>Repl Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepl_Policy()
	 * @generated
	 * @ordered
	 */
	protected static final Repl_Policy REPL_POLICY_EDEFAULT = Repl_Policy.LRU;

	/**
	 * The cached value of the '{@link #getRepl_Policy() <em>Repl Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepl_Policy()
	 * @generated
	 * @ordered
	 */
	protected Repl_Policy repl_Policy = REPL_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWritePolicy() <em>Write Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWritePolicy()
	 * @generated
	 * @ordered
	 */
	protected static final WritePolicy WRITE_POLICY_EDEFAULT = WritePolicy.WRITE_BACK;

	/**
	 * The cached value of the '{@link #getWritePolicy() <em>Write Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWritePolicy()
	 * @generated
	 * @ordered
	 */
	protected WritePolicy writePolicy = WRITE_POLICY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwRAMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwMemoryPackage.Literals.HW_RAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganization(String newOrganization) {
		String oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__ORGANIZATION, oldOrganization, organization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSynchronous() {
		return isSynchronous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronous(String newIsSynchronous) {
		String oldIsSynchronous = isSynchronous;
		isSynchronous = newIsSynchronous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__IS_SYNCHRONOUS, oldIsSynchronous, isSynchronous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStatic(String newIsStatic) {
		String oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsNonVolatile() {
		return isNonVolatile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsNonVolatile(String newIsNonVolatile) {
		String oldIsNonVolatile = isNonVolatile;
		isNonVolatile = newIsNonVolatile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__IS_NON_VOLATILE, oldIsNonVolatile, isNonVolatile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repl_Policy getRepl_Policy() {
		return repl_Policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepl_Policy(Repl_Policy newRepl_Policy) {
		Repl_Policy oldRepl_Policy = repl_Policy;
		repl_Policy = newRepl_Policy == null ? REPL_POLICY_EDEFAULT : newRepl_Policy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__REPL_POLICY, oldRepl_Policy, repl_Policy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WritePolicy getWritePolicy() {
		return writePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWritePolicy(WritePolicy newWritePolicy) {
		WritePolicy oldWritePolicy = writePolicy;
		writePolicy = newWritePolicy == null ? WRITE_POLICY_EDEFAULT : newWritePolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_RAM__WRITE_POLICY, oldWritePolicy, writePolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwMemoryPackage.HW_RAM__ORGANIZATION:
				return getOrganization();
			case HwMemoryPackage.HW_RAM__IS_SYNCHRONOUS:
				return getIsSynchronous();
			case HwMemoryPackage.HW_RAM__IS_STATIC:
				return getIsStatic();
			case HwMemoryPackage.HW_RAM__IS_NON_VOLATILE:
				return getIsNonVolatile();
			case HwMemoryPackage.HW_RAM__REPL_POLICY:
				return getRepl_Policy();
			case HwMemoryPackage.HW_RAM__WRITE_POLICY:
				return getWritePolicy();
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
			case HwMemoryPackage.HW_RAM__ORGANIZATION:
				setOrganization((String)newValue);
				return;
			case HwMemoryPackage.HW_RAM__IS_SYNCHRONOUS:
				setIsSynchronous((String)newValue);
				return;
			case HwMemoryPackage.HW_RAM__IS_STATIC:
				setIsStatic((String)newValue);
				return;
			case HwMemoryPackage.HW_RAM__IS_NON_VOLATILE:
				setIsNonVolatile((String)newValue);
				return;
			case HwMemoryPackage.HW_RAM__REPL_POLICY:
				setRepl_Policy((Repl_Policy)newValue);
				return;
			case HwMemoryPackage.HW_RAM__WRITE_POLICY:
				setWritePolicy((WritePolicy)newValue);
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
			case HwMemoryPackage.HW_RAM__ORGANIZATION:
				setOrganization(ORGANIZATION_EDEFAULT);
				return;
			case HwMemoryPackage.HW_RAM__IS_SYNCHRONOUS:
				setIsSynchronous(IS_SYNCHRONOUS_EDEFAULT);
				return;
			case HwMemoryPackage.HW_RAM__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case HwMemoryPackage.HW_RAM__IS_NON_VOLATILE:
				setIsNonVolatile(IS_NON_VOLATILE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_RAM__REPL_POLICY:
				setRepl_Policy(REPL_POLICY_EDEFAULT);
				return;
			case HwMemoryPackage.HW_RAM__WRITE_POLICY:
				setWritePolicy(WRITE_POLICY_EDEFAULT);
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
			case HwMemoryPackage.HW_RAM__ORGANIZATION:
				return ORGANIZATION_EDEFAULT == null ? organization != null : !ORGANIZATION_EDEFAULT.equals(organization);
			case HwMemoryPackage.HW_RAM__IS_SYNCHRONOUS:
				return IS_SYNCHRONOUS_EDEFAULT == null ? isSynchronous != null : !IS_SYNCHRONOUS_EDEFAULT.equals(isSynchronous);
			case HwMemoryPackage.HW_RAM__IS_STATIC:
				return IS_STATIC_EDEFAULT == null ? isStatic != null : !IS_STATIC_EDEFAULT.equals(isStatic);
			case HwMemoryPackage.HW_RAM__IS_NON_VOLATILE:
				return IS_NON_VOLATILE_EDEFAULT == null ? isNonVolatile != null : !IS_NON_VOLATILE_EDEFAULT.equals(isNonVolatile);
			case HwMemoryPackage.HW_RAM__REPL_POLICY:
				return repl_Policy != REPL_POLICY_EDEFAULT;
			case HwMemoryPackage.HW_RAM__WRITE_POLICY:
				return writePolicy != WRITE_POLICY_EDEFAULT;
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
		result.append(" (organization: ");
		result.append(organization);
		result.append(", isSynchronous: ");
		result.append(isSynchronous);
		result.append(", isStatic: ");
		result.append(isStatic);
		result.append(", isNonVolatile: ");
		result.append(isNonVolatile);
		result.append(", repl_Policy: ");
		result.append(repl_Policy);
		result.append(", writePolicy: ");
		result.append(writePolicy);
		result.append(')');
		return result.toString();
	}

} //HwRAMImpl
