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
package org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesFactory;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesPackage;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GRM_BasicTypesFactoryImpl extends EFactoryImpl implements GRM_BasicTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GRM_BasicTypesFactory init() {
		try {
			GRM_BasicTypesFactory theGRM_BasicTypesFactory = (GRM_BasicTypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///MARTE_Library/GRM_BasicTypes.ecore"); 
			if (theGRM_BasicTypesFactory != null) {
				return theGRM_BasicTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GRM_BasicTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GRM_BasicTypesFactoryImpl() {
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
			case GRM_BasicTypesPackage.SCHED_POLICY_KIND:
				return createSchedPolicyKindFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.PROTECT_PROTOCOL_KIND:
				return createProtectProtocolKindFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.PERIODIC_SERVER_KIND:
				return createPeriodicServerKindFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.EDF_PARAMETERS:
				return createEDF_ParametersFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.SCHED_PARAMETERS:
				return createSchedParametersFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.FIXED_PRIORITY_PARAMETERS:
				return createFixedPriorityParametersFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.PERIODIC_SERVER_PARAMETERS:
				return createPeriodicServerParametersFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.POOLING_PARAMETERS:
				return createPoolingParametersFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.SCHEDULE_SPECIFICATION:
				return createScheduleSpecificationFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.TABLE_DRIVEN_SCHEDULE:
				return createTableDrivenScheduleFromString(eDataType, initialValue);
			case GRM_BasicTypesPackage.TABLE_ENTRY_TYPE:
				return createTableEntryTypeFromString(eDataType, initialValue);
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
			case GRM_BasicTypesPackage.SCHED_POLICY_KIND:
				return convertSchedPolicyKindToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.PROTECT_PROTOCOL_KIND:
				return convertProtectProtocolKindToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.PERIODIC_SERVER_KIND:
				return convertPeriodicServerKindToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.EDF_PARAMETERS:
				return convertEDF_ParametersToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.SCHED_PARAMETERS:
				return convertSchedParametersToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.FIXED_PRIORITY_PARAMETERS:
				return convertFixedPriorityParametersToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.PERIODIC_SERVER_PARAMETERS:
				return convertPeriodicServerParametersToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.POOLING_PARAMETERS:
				return convertPoolingParametersToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.SCHEDULE_SPECIFICATION:
				return convertScheduleSpecificationToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.TABLE_DRIVEN_SCHEDULE:
				return convertTableDrivenScheduleToString(eDataType, instanceValue);
			case GRM_BasicTypesPackage.TABLE_ENTRY_TYPE:
				return convertTableEntryTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedPolicyKind createSchedPolicyKindFromString(EDataType eDataType, String initialValue) {
		SchedPolicyKind result = SchedPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectProtocolKind createProtectProtocolKindFromString(EDataType eDataType, String initialValue) {
		ProtectProtocolKind result = ProtectProtocolKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProtectProtocolKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicServerKind createPeriodicServerKindFromString(EDataType eDataType, String initialValue) {
		PeriodicServerKind result = PeriodicServerKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPeriodicServerKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createEDF_ParametersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDF_ParametersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createSchedParametersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedParametersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFixedPriorityParametersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFixedPriorityParametersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPeriodicServerParametersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPeriodicServerParametersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPoolingParametersFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPoolingParametersToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createScheduleSpecificationFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScheduleSpecificationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTableDrivenScheduleFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTableDrivenScheduleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTableEntryTypeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTableEntryTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GRM_BasicTypesPackage getGRM_BasicTypesPackage() {
		return (GRM_BasicTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GRM_BasicTypesPackage getPackage() {
		return GRM_BasicTypesPackage.eINSTANCE;
	}

} //GRM_BasicTypesFactoryImpl
