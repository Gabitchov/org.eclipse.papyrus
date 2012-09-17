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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.CacheType;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwCache;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.Repl_Policy;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.WritePolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Cache</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwCacheImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwCacheImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwCacheImpl#getStructure <em>Structure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwCacheImpl#getRepl_Policy <em>Repl Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwCacheImpl#getWritePolicy <em>Write Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwCacheImpl extends HwMemoryImpl implements HwCache {
	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected String level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CacheType TYPE_EDEFAULT = CacheType.DATA;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CacheType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStructure() <em>Structure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure()
	 * @generated
	 * @ordered
	 */
	protected static final String STRUCTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStructure() <em>Structure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure()
	 * @generated
	 * @ordered
	 */
	protected String structure = STRUCTURE_EDEFAULT;

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
	protected HwCacheImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwMemoryPackage.Literals.HW_CACHE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(String newLevel) {
		String oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_CACHE__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CacheType newType) {
		CacheType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_CACHE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructure(String newStructure) {
		String oldStructure = structure;
		structure = newStructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_CACHE__STRUCTURE, oldStructure, structure));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_CACHE__REPL_POLICY, oldRepl_Policy, repl_Policy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_CACHE__WRITE_POLICY, oldWritePolicy, writePolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwMemoryPackage.HW_CACHE__LEVEL:
				return getLevel();
			case HwMemoryPackage.HW_CACHE__TYPE:
				return getType();
			case HwMemoryPackage.HW_CACHE__STRUCTURE:
				return getStructure();
			case HwMemoryPackage.HW_CACHE__REPL_POLICY:
				return getRepl_Policy();
			case HwMemoryPackage.HW_CACHE__WRITE_POLICY:
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
			case HwMemoryPackage.HW_CACHE__LEVEL:
				setLevel((String)newValue);
				return;
			case HwMemoryPackage.HW_CACHE__TYPE:
				setType((CacheType)newValue);
				return;
			case HwMemoryPackage.HW_CACHE__STRUCTURE:
				setStructure((String)newValue);
				return;
			case HwMemoryPackage.HW_CACHE__REPL_POLICY:
				setRepl_Policy((Repl_Policy)newValue);
				return;
			case HwMemoryPackage.HW_CACHE__WRITE_POLICY:
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
			case HwMemoryPackage.HW_CACHE__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case HwMemoryPackage.HW_CACHE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_CACHE__STRUCTURE:
				setStructure(STRUCTURE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_CACHE__REPL_POLICY:
				setRepl_Policy(REPL_POLICY_EDEFAULT);
				return;
			case HwMemoryPackage.HW_CACHE__WRITE_POLICY:
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
			case HwMemoryPackage.HW_CACHE__LEVEL:
				return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
			case HwMemoryPackage.HW_CACHE__TYPE:
				return type != TYPE_EDEFAULT;
			case HwMemoryPackage.HW_CACHE__STRUCTURE:
				return STRUCTURE_EDEFAULT == null ? structure != null : !STRUCTURE_EDEFAULT.equals(structure);
			case HwMemoryPackage.HW_CACHE__REPL_POLICY:
				return repl_Policy != REPL_POLICY_EDEFAULT;
			case HwMemoryPackage.HW_CACHE__WRITE_POLICY:
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
		result.append(" (level: ");
		result.append(level);
		result.append(", type: ");
		result.append(type);
		result.append(", structure: ");
		result.append(structure);
		result.append(", repl_Policy: ");
		result.append(repl_Policy);
		result.append(", writePolicy: ");
		result.append(writePolicy);
		result.append(')');
		return result.toString();
	}

} //HwCacheImpl
