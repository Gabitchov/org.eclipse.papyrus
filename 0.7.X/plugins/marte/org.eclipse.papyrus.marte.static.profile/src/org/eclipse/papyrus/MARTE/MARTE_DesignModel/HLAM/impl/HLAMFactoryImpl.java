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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HLAMFactoryImpl extends EFactoryImpl implements HLAMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HLAMFactory init() {
		try {
			HLAMFactory theHLAMFactory = (HLAMFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/HLAM/1"); 
			if (theHLAMFactory != null) {
				return theHLAMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HLAMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLAMFactoryImpl() {
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
			case HLAMPackage.RT_UNIT: return createRtUnit();
			case HLAMPackage.PP_UNIT: return createPpUnit();
			case HLAMPackage.RT_FEATURE: return createRtFeature();
			case HLAMPackage.RT_SPECIFICATION: return createRtSpecification();
			case HLAMPackage.RT_ACTION: return createRtAction();
			case HLAMPackage.RT_SERVICE: return createRtService();
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
			case HLAMPackage.POOL_MGT_POLICY_KIND:
				return createPoolMgtPolicyKindFromString(eDataType, initialValue);
			case HLAMPackage.CALL_CONCURRENCY_KIND:
				return createCallConcurrencyKindFromString(eDataType, initialValue);
			case HLAMPackage.SYNCHRONIZATION_KIND:
				return createSynchronizationKindFromString(eDataType, initialValue);
			case HLAMPackage.EXECUTION_KIND:
				return createExecutionKindFromString(eDataType, initialValue);
			case HLAMPackage.CONCURRENCY_KIND:
				return createConcurrencyKindFromString(eDataType, initialValue);
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
			case HLAMPackage.POOL_MGT_POLICY_KIND:
				return convertPoolMgtPolicyKindToString(eDataType, instanceValue);
			case HLAMPackage.CALL_CONCURRENCY_KIND:
				return convertCallConcurrencyKindToString(eDataType, instanceValue);
			case HLAMPackage.SYNCHRONIZATION_KIND:
				return convertSynchronizationKindToString(eDataType, instanceValue);
			case HLAMPackage.EXECUTION_KIND:
				return convertExecutionKindToString(eDataType, instanceValue);
			case HLAMPackage.CONCURRENCY_KIND:
				return convertConcurrencyKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RtUnit createRtUnit() {
		RtUnitImpl rtUnit = new RtUnitImpl();
		return rtUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PpUnit createPpUnit() {
		PpUnitImpl ppUnit = new PpUnitImpl();
		return ppUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RtFeature createRtFeature() {
		RtFeatureImpl rtFeature = new RtFeatureImpl();
		return rtFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RtSpecification createRtSpecification() {
		RtSpecificationImpl rtSpecification = new RtSpecificationImpl();
		return rtSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RtAction createRtAction() {
		RtActionImpl rtAction = new RtActionImpl();
		return rtAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RtService createRtService() {
		RtServiceImpl rtService = new RtServiceImpl();
		return rtService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PoolMgtPolicyKind createPoolMgtPolicyKindFromString(EDataType eDataType, String initialValue) {
		PoolMgtPolicyKind result = PoolMgtPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPoolMgtPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallConcurrencyKind createCallConcurrencyKindFromString(EDataType eDataType, String initialValue) {
		CallConcurrencyKind result = CallConcurrencyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCallConcurrencyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind createSynchronizationKindFromString(EDataType eDataType, String initialValue) {
		SynchronizationKind result = SynchronizationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronizationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionKind createExecutionKindFromString(EDataType eDataType, String initialValue) {
		ExecutionKind result = ExecutionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrencyKind createConcurrencyKindFromString(EDataType eDataType, String initialValue) {
		ConcurrencyKind result = ConcurrencyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConcurrencyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLAMPackage getHLAMPackage() {
		return (HLAMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HLAMPackage getPackage() {
		return HLAMPackage.eINSTANCE;
	}

} //HLAMFactoryImpl
