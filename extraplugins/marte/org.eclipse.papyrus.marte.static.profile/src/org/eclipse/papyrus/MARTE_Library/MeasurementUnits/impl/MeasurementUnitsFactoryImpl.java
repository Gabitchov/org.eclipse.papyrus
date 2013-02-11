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
package org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.*;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsFactory;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasurementUnitsFactoryImpl extends EFactoryImpl implements MeasurementUnitsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurementUnitsFactory init() {
		try {
			MeasurementUnitsFactory theMeasurementUnitsFactory = (MeasurementUnitsFactory)EPackage.Registry.INSTANCE.getEFactory(MeasurementUnitsPackage.eNS_URI);
			if (theMeasurementUnitsFactory != null) {
				return theMeasurementUnitsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MeasurementUnitsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementUnitsFactoryImpl() {
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
			case MeasurementUnitsPackage.TIME_UNIT_KIND:
				return createTimeUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.POWER_UNIT_KIND:
				return createPowerUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.FREQUENCY_UNIT_KIND:
				return createFrequencyUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.DATA_SIZE_UNIT_KIND:
				return createDataSizeUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.DATA_TX_RATE_UNIT_KIND:
				return createDataTxRateUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.ENERGY_UNIT_KIND:
				return createEnergyUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.LENGTH_UNIT_KIND:
				return createLengthUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.AREA_UNIT_KIND:
				return createAreaUnitKindFromString(eDataType, initialValue);
			case MeasurementUnitsPackage.WEIGHT_UNIT_KIND:
				return createWeightUnitKindFromString(eDataType, initialValue);
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
			case MeasurementUnitsPackage.TIME_UNIT_KIND:
				return convertTimeUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.POWER_UNIT_KIND:
				return convertPowerUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.FREQUENCY_UNIT_KIND:
				return convertFrequencyUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.DATA_SIZE_UNIT_KIND:
				return convertDataSizeUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.DATA_TX_RATE_UNIT_KIND:
				return convertDataTxRateUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.ENERGY_UNIT_KIND:
				return convertEnergyUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.LENGTH_UNIT_KIND:
				return convertLengthUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.AREA_UNIT_KIND:
				return convertAreaUnitKindToString(eDataType, instanceValue);
			case MeasurementUnitsPackage.WEIGHT_UNIT_KIND:
				return convertWeightUnitKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnitKind createTimeUnitKindFromString(EDataType eDataType, String initialValue) {
		TimeUnitKind result = TimeUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerUnitKind createPowerUnitKindFromString(EDataType eDataType, String initialValue) {
		PowerUnitKind result = PowerUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FrequencyUnitKind createFrequencyUnitKindFromString(EDataType eDataType, String initialValue) {
		FrequencyUnitKind result = FrequencyUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFrequencyUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSizeUnitKind createDataSizeUnitKindFromString(EDataType eDataType, String initialValue) {
		DataSizeUnitKind result = DataSizeUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataSizeUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTxRateUnitKind createDataTxRateUnitKindFromString(EDataType eDataType, String initialValue) {
		DataTxRateUnitKind result = DataTxRateUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTxRateUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyUnitKind createEnergyUnitKindFromString(EDataType eDataType, String initialValue) {
		EnergyUnitKind result = EnergyUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnergyUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LengthUnitKind createLengthUnitKindFromString(EDataType eDataType, String initialValue) {
		LengthUnitKind result = LengthUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLengthUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaUnitKind createAreaUnitKindFromString(EDataType eDataType, String initialValue) {
		AreaUnitKind result = AreaUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAreaUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeightUnitKind createWeightUnitKindFromString(EDataType eDataType, String initialValue) {
		WeightUnitKind result = WeightUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWeightUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementUnitsPackage getMeasurementUnitsPackage() {
		return (MeasurementUnitsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MeasurementUnitsPackage getPackage() {
		return MeasurementUnitsPackage.eINSTANCE;
	}

} //MeasurementUnitsFactoryImpl
