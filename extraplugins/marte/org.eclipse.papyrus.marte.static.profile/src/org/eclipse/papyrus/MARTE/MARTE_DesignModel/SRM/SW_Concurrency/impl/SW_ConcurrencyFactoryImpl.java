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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.*;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyFactory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SW_ConcurrencyFactoryImpl extends EFactoryImpl implements SW_ConcurrencyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SW_ConcurrencyFactory init() {
		try {
			SW_ConcurrencyFactory theSW_ConcurrencyFactory = (SW_ConcurrencyFactory)EPackage.Registry.INSTANCE.getEFactory(SW_ConcurrencyPackage.eNS_URI);
			if (theSW_ConcurrencyFactory != null) {
				return theSW_ConcurrencyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SW_ConcurrencyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_ConcurrencyFactoryImpl() {
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
			case SW_ConcurrencyPackage.ENTRY_POINT: return createEntryPoint();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE: return createInterruptResource();
			case SW_ConcurrencyPackage.SW_SCHEDULABLE_RESOURCE: return createSwSchedulableResource();
			case SW_ConcurrencyPackage.SW_TIMER_RESOURCE: return createSwTimerResource();
			case SW_ConcurrencyPackage.MEMORY_PARTITION: return createMemoryPartition();
			case SW_ConcurrencyPackage.ALARM: return createAlarm();
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
			case SW_ConcurrencyPackage.INTERRUPT_KIND:
				return createInterruptKindFromString(eDataType, initialValue);
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
			case SW_ConcurrencyPackage.INTERRUPT_KIND:
				return convertInterruptKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPoint createEntryPoint() {
		EntryPointImpl entryPoint = new EntryPointImpl();
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterruptResource createInterruptResource() {
		InterruptResourceImpl interruptResource = new InterruptResourceImpl();
		return interruptResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwSchedulableResource createSwSchedulableResource() {
		SwSchedulableResourceImpl swSchedulableResource = new SwSchedulableResourceImpl();
		return swSchedulableResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwTimerResource createSwTimerResource() {
		SwTimerResourceImpl swTimerResource = new SwTimerResourceImpl();
		return swTimerResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryPartition createMemoryPartition() {
		MemoryPartitionImpl memoryPartition = new MemoryPartitionImpl();
		return memoryPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alarm createAlarm() {
		AlarmImpl alarm = new AlarmImpl();
		return alarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterruptKind createInterruptKindFromString(EDataType eDataType, String initialValue) {
		InterruptKind result = InterruptKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterruptKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_ConcurrencyPackage getSW_ConcurrencyPackage() {
		return (SW_ConcurrencyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SW_ConcurrencyPackage getPackage() {
		return SW_ConcurrencyPackage.eINSTANCE;
	}

} //SW_ConcurrencyFactoryImpl
