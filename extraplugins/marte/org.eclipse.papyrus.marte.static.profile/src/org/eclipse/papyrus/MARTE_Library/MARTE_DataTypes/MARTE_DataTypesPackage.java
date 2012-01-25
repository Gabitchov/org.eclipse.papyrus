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
package org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes;

import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface MARTE_DataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MARTE_DataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/MARTE_DataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.MARTE_DataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MARTE_DataTypesPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind <em>Transm Mode Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getTransmModeKind()
	 * @generated
	 */
	int TRANSM_MODE_KIND = 0;

	/**
	 * The meta object id for the '<em>Integer Vector</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerVector()
	 * @generated
	 */
	int INTEGER_VECTOR = 1;

	/**
	 * The meta object id for the '<em>Integer Matrix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerMatrix()
	 * @generated
	 */
	int INTEGER_MATRIX = 2;

	/**
	 * The meta object id for the '<em>VSL Expression</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getVSL_Expression()
	 * @generated
	 */
	int VSL_EXPRESSION = 3;

	/**
	 * The meta object id for the '<em>Integer Interval</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerInterval()
	 * @generated
	 */
	int INTEGER_INTERVAL = 4;

	/**
	 * The meta object id for the '<em>Utility Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getUtilityType()
	 * @generated
	 */
	int UTILITY_TYPE = 5;

	/**
	 * The meta object id for the '<em>Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getArray()
	 * @generated
	 */
	int ARRAY = 6;

	/**
	 * The meta object id for the '<em>Realnterval</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealnterval()
	 * @generated
	 */
	int REALNTERVAL = 7;

	/**
	 * The meta object id for the '<em>NFP Frequency Interval</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getNFP_FrequencyInterval()
	 * @generated
	 */
	int NFP_FREQUENCY_INTERVAL = 8;

	/**
	 * The meta object id for the '<em>Interval</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getInterval()
	 * @generated
	 */
	int INTERVAL = 9;

	/**
	 * The meta object id for the '<em>NFP Natural Interval</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getNFP_NaturalInterval()
	 * @generated
	 */
	int NFP_NATURAL_INTERVAL = 10;

	/**
	 * The meta object id for the '<em>Real Vector</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealVector()
	 * @generated
	 */
	int REAL_VECTOR = 11;

	/**
	 * The meta object id for the '<em>Real Matrix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealMatrix()
	 * @generated
	 */
	int REAL_MATRIX = 12;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind <em>Transm Mode Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transm Mode Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind
	 * @generated
	 */
	EEnum getTransmModeKind();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Integer Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Vector</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getIntegerVector();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Integer Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Matrix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getIntegerMatrix();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>VSL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>VSL Expression</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getVSL_Expression();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Integer Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Interval</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getIntegerInterval();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Utility Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Utility Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUtilityType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Array</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getArray();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Realnterval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Realnterval</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getRealnterval();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Frequency Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Frequency Interval</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_FrequencyInterval();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Interval</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getInterval();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Natural Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Natural Interval</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_NaturalInterval();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Real Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real Vector</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getRealVector();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Real Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real Matrix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getRealMatrix();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MARTE_DataTypesFactory getMARTE_DataTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind <em>Transm Mode Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getTransmModeKind()
		 * @generated
		 */
		EEnum TRANSM_MODE_KIND = eINSTANCE.getTransmModeKind();

		/**
		 * The meta object literal for the '<em>Integer Vector</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerVector()
		 * @generated
		 */
		EDataType INTEGER_VECTOR = eINSTANCE.getIntegerVector();

		/**
		 * The meta object literal for the '<em>Integer Matrix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerMatrix()
		 * @generated
		 */
		EDataType INTEGER_MATRIX = eINSTANCE.getIntegerMatrix();

		/**
		 * The meta object literal for the '<em>VSL Expression</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getVSL_Expression()
		 * @generated
		 */
		EDataType VSL_EXPRESSION = eINSTANCE.getVSL_Expression();

		/**
		 * The meta object literal for the '<em>Integer Interval</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getIntegerInterval()
		 * @generated
		 */
		EDataType INTEGER_INTERVAL = eINSTANCE.getIntegerInterval();

		/**
		 * The meta object literal for the '<em>Utility Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getUtilityType()
		 * @generated
		 */
		EDataType UTILITY_TYPE = eINSTANCE.getUtilityType();

		/**
		 * The meta object literal for the '<em>Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getArray()
		 * @generated
		 */
		EDataType ARRAY = eINSTANCE.getArray();

		/**
		 * The meta object literal for the '<em>Realnterval</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealnterval()
		 * @generated
		 */
		EDataType REALNTERVAL = eINSTANCE.getRealnterval();

		/**
		 * The meta object literal for the '<em>NFP Frequency Interval</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getNFP_FrequencyInterval()
		 * @generated
		 */
		EDataType NFP_FREQUENCY_INTERVAL = eINSTANCE.getNFP_FrequencyInterval();

		/**
		 * The meta object literal for the '<em>Interval</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getInterval()
		 * @generated
		 */
		EDataType INTERVAL = eINSTANCE.getInterval();

		/**
		 * The meta object literal for the '<em>NFP Natural Interval</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getNFP_NaturalInterval()
		 * @generated
		 */
		EDataType NFP_NATURAL_INTERVAL = eINSTANCE.getNFP_NaturalInterval();

		/**
		 * The meta object literal for the '<em>Real Vector</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealVector()
		 * @generated
		 */
		EDataType REAL_VECTOR = eINSTANCE.getRealVector();

		/**
		 * The meta object literal for the '<em>Real Matrix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl#getRealMatrix()
		 * @generated
		 */
		EDataType REAL_MATRIX = eINSTANCE.getRealMatrix();

	}

} //MARTE_DataTypesPackage
