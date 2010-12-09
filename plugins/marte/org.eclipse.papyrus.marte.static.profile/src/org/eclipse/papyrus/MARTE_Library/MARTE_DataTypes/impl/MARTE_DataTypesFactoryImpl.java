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
package org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MARTE_DataTypesFactoryImpl extends EFactoryImpl implements MARTE_DataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MARTE_DataTypesFactory init() {
		try {
			MARTE_DataTypesFactory theMARTE_DataTypesFactory = (MARTE_DataTypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///MARTE_Library/MARTE_DataTypes.ecore"); 
			if (theMARTE_DataTypesFactory != null) {
				return theMARTE_DataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MARTE_DataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MARTE_DataTypesFactoryImpl() {
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
			case MARTE_DataTypesPackage.TRANSM_MODE_KIND:
				return createTransmModeKindFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.INTEGER_VECTOR:
				return createIntegerVectorFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.INTEGER_MATRIX:
				return createIntegerMatrixFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.VSL_EXPRESSION:
				return createVSL_ExpressionFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.INTEGER_INTERVAL:
				return createIntegerIntervalFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.UTILITY_TYPE:
				return createUtilityTypeFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.ARRAY:
				return createArrayFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.REALNTERVAL:
				return createRealntervalFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.NFP_FREQUENCY_INTERVAL:
				return createNFP_FrequencyIntervalFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.INTERVAL:
				return createIntervalFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.NFP_NATURAL_INTERVAL:
				return createNFP_NaturalIntervalFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.REAL_VECTOR:
				return createRealVectorFromString(eDataType, initialValue);
			case MARTE_DataTypesPackage.REAL_MATRIX:
				return createRealMatrixFromString(eDataType, initialValue);
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
			case MARTE_DataTypesPackage.TRANSM_MODE_KIND:
				return convertTransmModeKindToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.INTEGER_VECTOR:
				return convertIntegerVectorToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.INTEGER_MATRIX:
				return convertIntegerMatrixToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.VSL_EXPRESSION:
				return convertVSL_ExpressionToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.INTEGER_INTERVAL:
				return convertIntegerIntervalToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.UTILITY_TYPE:
				return convertUtilityTypeToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.ARRAY:
				return convertArrayToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.REALNTERVAL:
				return convertRealntervalToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.NFP_FREQUENCY_INTERVAL:
				return convertNFP_FrequencyIntervalToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.INTERVAL:
				return convertIntervalToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.NFP_NATURAL_INTERVAL:
				return convertNFP_NaturalIntervalToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.REAL_VECTOR:
				return convertRealVectorToString(eDataType, instanceValue);
			case MARTE_DataTypesPackage.REAL_MATRIX:
				return convertRealMatrixToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransmModeKind createTransmModeKindFromString(EDataType eDataType, String initialValue) {
		TransmModeKind result = TransmModeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransmModeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIntegerVectorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerVectorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIntegerMatrixFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerMatrixToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createVSL_ExpressionFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVSL_ExpressionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIntegerIntervalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerIntervalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUtilityTypeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUtilityTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createArrayFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createRealntervalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealntervalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_FrequencyIntervalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_FrequencyIntervalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIntervalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntervalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_NaturalIntervalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_NaturalIntervalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createRealVectorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealVectorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createRealMatrixFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealMatrixToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MARTE_DataTypesPackage getMARTE_DataTypesPackage() {
		return (MARTE_DataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MARTE_DataTypesPackage getPackage() {
		return MARTE_DataTypesPackage.eINSTANCE;
	}

} //MARTE_DataTypesFactoryImpl
