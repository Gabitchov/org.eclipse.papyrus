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
package org.eclipse.papyrus.MARTE_Library.MeasurementUnits;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsFactory
 * @model kind="package"
 * @generated
 */
public interface MeasurementUnitsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MeasurementUnits";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/MeasurementUnits.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.MeasurementUnits";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementUnitsPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind <em>Time Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getTimeUnitKind()
	 * @generated
	 */
	int TIME_UNIT_KIND = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind <em>Power Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getPowerUnitKind()
	 * @generated
	 */
	int POWER_UNIT_KIND = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind <em>Frequency Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getFrequencyUnitKind()
	 * @generated
	 */
	int FREQUENCY_UNIT_KIND = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind <em>Data Size Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getDataSizeUnitKind()
	 * @generated
	 */
	int DATA_SIZE_UNIT_KIND = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind <em>Data Tx Rate Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getDataTxRateUnitKind()
	 * @generated
	 */
	int DATA_TX_RATE_UNIT_KIND = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind <em>Energy Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getEnergyUnitKind()
	 * @generated
	 */
	int ENERGY_UNIT_KIND = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind <em>Length Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getLengthUnitKind()
	 * @generated
	 */
	int LENGTH_UNIT_KIND = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind <em>Area Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getAreaUnitKind()
	 * @generated
	 */
	int AREA_UNIT_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind <em>Weight Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getWeightUnitKind()
	 * @generated
	 */
	int WEIGHT_UNIT_KIND = 8;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind <em>Time Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind
	 * @generated
	 */
	EEnum getTimeUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind <em>Power Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Power Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind
	 * @generated
	 */
	EEnum getPowerUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind <em>Frequency Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Frequency Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind
	 * @generated
	 */
	EEnum getFrequencyUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind <em>Data Size Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Size Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind
	 * @generated
	 */
	EEnum getDataSizeUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind <em>Data Tx Rate Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Tx Rate Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind
	 * @generated
	 */
	EEnum getDataTxRateUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind <em>Energy Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Energy Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind
	 * @generated
	 */
	EEnum getEnergyUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind <em>Length Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Length Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind
	 * @generated
	 */
	EEnum getLengthUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind <em>Area Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Area Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind
	 * @generated
	 */
	EEnum getAreaUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind <em>Weight Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weight Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind
	 * @generated
	 */
	EEnum getWeightUnitKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeasurementUnitsFactory getMeasurementUnitsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind <em>Time Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getTimeUnitKind()
		 * @generated
		 */
		EEnum TIME_UNIT_KIND = eINSTANCE.getTimeUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind <em>Power Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.PowerUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getPowerUnitKind()
		 * @generated
		 */
		EEnum POWER_UNIT_KIND = eINSTANCE.getPowerUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind <em>Frequency Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getFrequencyUnitKind()
		 * @generated
		 */
		EEnum FREQUENCY_UNIT_KIND = eINSTANCE.getFrequencyUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind <em>Data Size Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getDataSizeUnitKind()
		 * @generated
		 */
		EEnum DATA_SIZE_UNIT_KIND = eINSTANCE.getDataSizeUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind <em>Data Tx Rate Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataTxRateUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getDataTxRateUnitKind()
		 * @generated
		 */
		EEnum DATA_TX_RATE_UNIT_KIND = eINSTANCE.getDataTxRateUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind <em>Energy Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.EnergyUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getEnergyUnitKind()
		 * @generated
		 */
		EEnum ENERGY_UNIT_KIND = eINSTANCE.getEnergyUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind <em>Length Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.LengthUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getLengthUnitKind()
		 * @generated
		 */
		EEnum LENGTH_UNIT_KIND = eINSTANCE.getLengthUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind <em>Area Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.AreaUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getAreaUnitKind()
		 * @generated
		 */
		EEnum AREA_UNIT_KIND = eINSTANCE.getAreaUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind <em>Weight Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.WeightUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl#getWeightUnitKind()
		 * @generated
		 */
		EEnum WEIGHT_UNIT_KIND = eINSTANCE.getWeightUnitKind();

	}

} //MeasurementUnitsPackage
