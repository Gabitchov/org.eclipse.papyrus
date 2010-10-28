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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HwMemoryFactoryImpl extends EFactoryImpl implements HwMemoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HwMemoryFactory init() {
		try {
			HwMemoryFactory theHwMemoryFactory = (HwMemoryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/HwMemory/1"); 
			if (theHwMemoryFactory != null) {
				return theHwMemoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HwMemoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwMemoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HwMemoryPackage.HW_MEMORY: return createHwMemory();
			case HwMemoryPackage.HW_RAM: return createHwRAM();
			case HwMemoryPackage.HW_ROM: return createHwROM();
			case HwMemoryPackage.HW_DRIVE: return createHwDrive();
			case HwMemoryPackage.HW_CACHE: return createHwCache();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case HwMemoryPackage.REPL_POLICY:
				return createRepl_PolicyFromString(eDataType, initialValue);
			case HwMemoryPackage.WRITE_POLICY:
				return createWritePolicyFromString(eDataType, initialValue);
			case HwMemoryPackage.CACHE_TYPE:
				return createCacheTypeFromString(eDataType, initialValue);
			case HwMemoryPackage.ROM_TYPE:
				return createROM_TypeFromString(eDataType, initialValue);
			case HwMemoryPackage.TIMING:
				return createTimingFromString(eDataType, initialValue);
			case HwMemoryPackage.CACHE_STRUCTURE:
				return createCacheStructureFromString(eDataType, initialValue);
			case HwMemoryPackage.MEMORY_ORGANIZATION:
				return createMemoryOrganizationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case HwMemoryPackage.REPL_POLICY:
				return convertRepl_PolicyToString(eDataType, instanceValue);
			case HwMemoryPackage.WRITE_POLICY:
				return convertWritePolicyToString(eDataType, instanceValue);
			case HwMemoryPackage.CACHE_TYPE:
				return convertCacheTypeToString(eDataType, instanceValue);
			case HwMemoryPackage.ROM_TYPE:
				return convertROM_TypeToString(eDataType, instanceValue);
			case HwMemoryPackage.TIMING:
				return convertTimingToString(eDataType, instanceValue);
			case HwMemoryPackage.CACHE_STRUCTURE:
				return convertCacheStructureToString(eDataType, instanceValue);
			case HwMemoryPackage.MEMORY_ORGANIZATION:
				return convertMemoryOrganizationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwMemory createHwMemory() {
		HwMemoryImpl hwMemory = new HwMemoryImpl();
		return hwMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwRAM createHwRAM() {
		HwRAMImpl hwRAM = new HwRAMImpl();
		return hwRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwROM createHwROM() {
		HwROMImpl hwROM = new HwROMImpl();
		return hwROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwDrive createHwDrive() {
		HwDriveImpl hwDrive = new HwDriveImpl();
		return hwDrive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwCache createHwCache() {
		HwCacheImpl hwCache = new HwCacheImpl();
		return hwCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repl_Policy createRepl_PolicyFromString(EDataType eDataType, String initialValue) {
		Repl_Policy result = Repl_Policy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRepl_PolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WritePolicy createWritePolicyFromString(EDataType eDataType, String initialValue) {
		WritePolicy result = WritePolicy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWritePolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheType createCacheTypeFromString(EDataType eDataType, String initialValue) {
		CacheType result = CacheType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ROM_Type createROM_TypeFromString(EDataType eDataType, String initialValue) {
		ROM_Type result = ROM_Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertROM_TypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTimingFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimingToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCacheStructureFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheStructureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMemoryOrganizationFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMemoryOrganizationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwMemoryPackage getHwMemoryPackage() {
		return (HwMemoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HwMemoryPackage getPackage() {
		return HwMemoryPackage.eINSTANCE;
	}

} //HwMemoryFactoryImpl
