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
package org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.*;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesFactory;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesPackage;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind;
import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicNFP_TypesFactoryImpl extends EFactoryImpl implements BasicNFP_TypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicNFP_TypesFactory init() {
		try {
			BasicNFP_TypesFactory theBasicNFP_TypesFactory = (BasicNFP_TypesFactory)EPackage.Registry.INSTANCE.getEFactory(BasicNFP_TypesPackage.eNS_URI);
			if (theBasicNFP_TypesFactory != null) {
				return theBasicNFP_TypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BasicNFP_TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicNFP_TypesFactoryImpl() {
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
			case BasicNFP_TypesPackage.SOURCE_KIND:
				return createSourceKindFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.DIRECTION_KIND:
				return createDirectionKindFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.STATISTICAL_QUALIFIER_KIND:
				return createStatisticalQualifierKindFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_COMMON_TYPE:
				return createNFP_CommonTypeFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_BOOLEAN:
				return createNFP_BooleanFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_NATURAL:
				return createNFP_NaturalFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_STRING:
				return createNFP_StringFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_REAL:
				return createNFP_RealFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_INTEGER:
				return createNFP_IntegerFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_DATE_TIME:
				return createNFP_DateTimeFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_DURATION:
				return createNFP_DurationFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_DATA_TX_RATE:
				return createNFP_DataTxRateFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_FREQUENCY:
				return createNFP_FrequencyFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_POWER:
				return createNFP_PowerFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_DATA_SIZE:
				return createNFP_DataSizeFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_ENERGY:
				return createNFP_EnergyFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_LENGTH:
				return createNFP_LengthFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_AREA:
				return createNFP_AreaFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.ARRIVAL_PATTERN:
				return createArrivalPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.PERIODIC_PATTERN:
				return createPeriodicPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.APERIODIC_PATTERN:
				return createAperiodicPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.CLOSED_PATTERN:
				return createClosedPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.SPORADIC_PATTERN:
				return createSporadicPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.BURST_PATTERN:
				return createBurstPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.IRREGULAR_PATTERN:
				return createIrregularPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_PERCENTAGE:
				return createNFP_PercentageFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.OPEN_PATTERN:
				return createOpenPatternFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_PRICE:
				return createNFP_PriceFromString(eDataType, initialValue);
			case BasicNFP_TypesPackage.NFP_WEIGHT:
				return createNFP_WeightFromString(eDataType, initialValue);
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
			case BasicNFP_TypesPackage.SOURCE_KIND:
				return convertSourceKindToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.DIRECTION_KIND:
				return convertDirectionKindToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.STATISTICAL_QUALIFIER_KIND:
				return convertStatisticalQualifierKindToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_COMMON_TYPE:
				return convertNFP_CommonTypeToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_BOOLEAN:
				return convertNFP_BooleanToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_NATURAL:
				return convertNFP_NaturalToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_STRING:
				return convertNFP_StringToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_REAL:
				return convertNFP_RealToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_INTEGER:
				return convertNFP_IntegerToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_DATE_TIME:
				return convertNFP_DateTimeToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_DURATION:
				return convertNFP_DurationToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_DATA_TX_RATE:
				return convertNFP_DataTxRateToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_FREQUENCY:
				return convertNFP_FrequencyToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_POWER:
				return convertNFP_PowerToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_DATA_SIZE:
				return convertNFP_DataSizeToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_ENERGY:
				return convertNFP_EnergyToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_LENGTH:
				return convertNFP_LengthToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_AREA:
				return convertNFP_AreaToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.ARRIVAL_PATTERN:
				return convertArrivalPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.PERIODIC_PATTERN:
				return convertPeriodicPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.APERIODIC_PATTERN:
				return convertAperiodicPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.CLOSED_PATTERN:
				return convertClosedPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.SPORADIC_PATTERN:
				return convertSporadicPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.BURST_PATTERN:
				return convertBurstPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.IRREGULAR_PATTERN:
				return convertIrregularPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_PERCENTAGE:
				return convertNFP_PercentageToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.OPEN_PATTERN:
				return convertOpenPatternToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_PRICE:
				return convertNFP_PriceToString(eDataType, instanceValue);
			case BasicNFP_TypesPackage.NFP_WEIGHT:
				return convertNFP_WeightToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceKind createSourceKindFromString(EDataType eDataType, String initialValue) {
		SourceKind result = SourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKind createDirectionKindFromString(EDataType eDataType, String initialValue) {
		DirectionKind result = DirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalQualifierKind createStatisticalQualifierKindFromString(EDataType eDataType, String initialValue) {
		StatisticalQualifierKind result = StatisticalQualifierKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatisticalQualifierKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_CommonTypeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_CommonTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_BooleanFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_BooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_NaturalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_NaturalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_StringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_StringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_RealFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_RealToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_IntegerFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_IntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_DateTimeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_DateTimeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_DurationFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_DurationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_DataTxRateFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_DataTxRateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_FrequencyFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_FrequencyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_PowerFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_PowerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_DataSizeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_DataSizeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_EnergyFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_EnergyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_LengthFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_LengthToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_AreaFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_AreaToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createArrivalPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArrivalPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPeriodicPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPeriodicPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAperiodicPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAperiodicPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createClosedPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClosedPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createSporadicPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSporadicPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createBurstPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBurstPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIrregularPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIrregularPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_PercentageFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_PercentageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createOpenPatternFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOpenPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_PriceFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_PriceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNFP_WeightFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNFP_WeightToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicNFP_TypesPackage getBasicNFP_TypesPackage() {
		return (BasicNFP_TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasicNFP_TypesPackage getPackage() {
		return BasicNFP_TypesPackage.eINSTANCE;
	}

} //BasicNFP_TypesFactoryImpl
