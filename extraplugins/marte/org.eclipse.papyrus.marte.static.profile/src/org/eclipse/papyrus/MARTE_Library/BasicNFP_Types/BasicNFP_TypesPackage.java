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
package org.eclipse.papyrus.MARTE_Library.BasicNFP_Types;

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
 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesFactory
 * @model kind="package"
 * @generated
 */
public interface BasicNFP_TypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BasicNFP_Types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/BasicNFP_Types.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.BasicNFP_Types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicNFP_TypesPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind <em>Source Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getSourceKind()
	 * @generated
	 */
	int SOURCE_KIND = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind <em>Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getDirectionKind()
	 * @generated
	 */
	int DIRECTION_KIND = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind <em>Statistical Qualifier Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getStatisticalQualifierKind()
	 * @generated
	 */
	int STATISTICAL_QUALIFIER_KIND = 2;

	/**
	 * The meta object id for the '<em>NFP Common Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_CommonType()
	 * @generated
	 */
	int NFP_COMMON_TYPE = 3;

	/**
	 * The meta object id for the '<em>NFP Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Boolean()
	 * @generated
	 */
	int NFP_BOOLEAN = 4;

	/**
	 * The meta object id for the '<em>NFP Natural</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Natural()
	 * @generated
	 */
	int NFP_NATURAL = 5;

	/**
	 * The meta object id for the '<em>NFP String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_String()
	 * @generated
	 */
	int NFP_STRING = 6;

	/**
	 * The meta object id for the '<em>NFP Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Real()
	 * @generated
	 */
	int NFP_REAL = 7;

	/**
	 * The meta object id for the '<em>NFP Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Integer()
	 * @generated
	 */
	int NFP_INTEGER = 8;

	/**
	 * The meta object id for the '<em>NFP Date Time</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DateTime()
	 * @generated
	 */
	int NFP_DATE_TIME = 9;

	/**
	 * The meta object id for the '<em>NFP Duration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Duration()
	 * @generated
	 */
	int NFP_DURATION = 10;

	/**
	 * The meta object id for the '<em>NFP Data Tx Rate</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DataTxRate()
	 * @generated
	 */
	int NFP_DATA_TX_RATE = 11;

	/**
	 * The meta object id for the '<em>NFP Frequency</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Frequency()
	 * @generated
	 */
	int NFP_FREQUENCY = 12;

	/**
	 * The meta object id for the '<em>NFP Power</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Power()
	 * @generated
	 */
	int NFP_POWER = 13;

	/**
	 * The meta object id for the '<em>NFP Data Size</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DataSize()
	 * @generated
	 */
	int NFP_DATA_SIZE = 14;

	/**
	 * The meta object id for the '<em>NFP Energy</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Energy()
	 * @generated
	 */
	int NFP_ENERGY = 15;

	/**
	 * The meta object id for the '<em>NFP Length</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Length()
	 * @generated
	 */
	int NFP_LENGTH = 16;

	/**
	 * The meta object id for the '<em>NFP Area</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Area()
	 * @generated
	 */
	int NFP_AREA = 17;

	/**
	 * The meta object id for the '<em>Arrival Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getArrivalPattern()
	 * @generated
	 */
	int ARRIVAL_PATTERN = 18;

	/**
	 * The meta object id for the '<em>Periodic Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getPeriodicPattern()
	 * @generated
	 */
	int PERIODIC_PATTERN = 19;

	/**
	 * The meta object id for the '<em>Aperiodic Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getAperiodicPattern()
	 * @generated
	 */
	int APERIODIC_PATTERN = 20;

	/**
	 * The meta object id for the '<em>Closed Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getClosedPattern()
	 * @generated
	 */
	int CLOSED_PATTERN = 21;

	/**
	 * The meta object id for the '<em>Sporadic Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getSporadicPattern()
	 * @generated
	 */
	int SPORADIC_PATTERN = 22;

	/**
	 * The meta object id for the '<em>Burst Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getBurstPattern()
	 * @generated
	 */
	int BURST_PATTERN = 23;

	/**
	 * The meta object id for the '<em>Irregular Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getIrregularPattern()
	 * @generated
	 */
	int IRREGULAR_PATTERN = 24;

	/**
	 * The meta object id for the '<em>NFP Percentage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Percentage()
	 * @generated
	 */
	int NFP_PERCENTAGE = 25;

	/**
	 * The meta object id for the '<em>Open Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getOpenPattern()
	 * @generated
	 */
	int OPEN_PATTERN = 26;

	/**
	 * The meta object id for the '<em>NFP Price</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Price()
	 * @generated
	 */
	int NFP_PRICE = 27;

	/**
	 * The meta object id for the '<em>NFP Weight</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Weight()
	 * @generated
	 */
	int NFP_WEIGHT = 28;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind <em>Source Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Source Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind
	 * @generated
	 */
	EEnum getSourceKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind <em>Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind
	 * @generated
	 */
	EEnum getDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind <em>Statistical Qualifier Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Statistical Qualifier Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind
	 * @generated
	 */
	EEnum getStatisticalQualifierKind();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Common Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Common Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_CommonType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Boolean</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Boolean();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Natural</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Natural();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_String();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Real</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Real();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Integer</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Integer();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Date Time</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_DateTime();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Duration</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Duration();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Data Tx Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Data Tx Rate</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_DataTxRate();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Frequency</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Frequency();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Power</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Power();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Data Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Data Size</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_DataSize();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Energy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Energy</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Energy();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Length</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Length();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Area</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Area();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Arrival Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Arrival Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getArrivalPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Periodic Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Periodic Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPeriodicPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Aperiodic Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Aperiodic Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getAperiodicPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Closed Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Closed Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getClosedPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Sporadic Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sporadic Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getSporadicPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Burst Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Burst Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getBurstPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Irregular Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Irregular Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getIrregularPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Percentage</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Percentage();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Open Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Open Pattern</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getOpenPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Price</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Price();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>NFP Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>NFP Weight</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNFP_Weight();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BasicNFP_TypesFactory getBasicNFP_TypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind <em>Source Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.SourceKind
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getSourceKind()
		 * @generated
		 */
		EEnum SOURCE_KIND = eINSTANCE.getSourceKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind <em>Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.DirectionKind
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getDirectionKind()
		 * @generated
		 */
		EEnum DIRECTION_KIND = eINSTANCE.getDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind <em>Statistical Qualifier Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.StatisticalQualifierKind
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getStatisticalQualifierKind()
		 * @generated
		 */
		EEnum STATISTICAL_QUALIFIER_KIND = eINSTANCE.getStatisticalQualifierKind();

		/**
		 * The meta object literal for the '<em>NFP Common Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_CommonType()
		 * @generated
		 */
		EDataType NFP_COMMON_TYPE = eINSTANCE.getNFP_CommonType();

		/**
		 * The meta object literal for the '<em>NFP Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Boolean()
		 * @generated
		 */
		EDataType NFP_BOOLEAN = eINSTANCE.getNFP_Boolean();

		/**
		 * The meta object literal for the '<em>NFP Natural</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Natural()
		 * @generated
		 */
		EDataType NFP_NATURAL = eINSTANCE.getNFP_Natural();

		/**
		 * The meta object literal for the '<em>NFP String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_String()
		 * @generated
		 */
		EDataType NFP_STRING = eINSTANCE.getNFP_String();

		/**
		 * The meta object literal for the '<em>NFP Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Real()
		 * @generated
		 */
		EDataType NFP_REAL = eINSTANCE.getNFP_Real();

		/**
		 * The meta object literal for the '<em>NFP Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Integer()
		 * @generated
		 */
		EDataType NFP_INTEGER = eINSTANCE.getNFP_Integer();

		/**
		 * The meta object literal for the '<em>NFP Date Time</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DateTime()
		 * @generated
		 */
		EDataType NFP_DATE_TIME = eINSTANCE.getNFP_DateTime();

		/**
		 * The meta object literal for the '<em>NFP Duration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Duration()
		 * @generated
		 */
		EDataType NFP_DURATION = eINSTANCE.getNFP_Duration();

		/**
		 * The meta object literal for the '<em>NFP Data Tx Rate</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DataTxRate()
		 * @generated
		 */
		EDataType NFP_DATA_TX_RATE = eINSTANCE.getNFP_DataTxRate();

		/**
		 * The meta object literal for the '<em>NFP Frequency</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Frequency()
		 * @generated
		 */
		EDataType NFP_FREQUENCY = eINSTANCE.getNFP_Frequency();

		/**
		 * The meta object literal for the '<em>NFP Power</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Power()
		 * @generated
		 */
		EDataType NFP_POWER = eINSTANCE.getNFP_Power();

		/**
		 * The meta object literal for the '<em>NFP Data Size</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_DataSize()
		 * @generated
		 */
		EDataType NFP_DATA_SIZE = eINSTANCE.getNFP_DataSize();

		/**
		 * The meta object literal for the '<em>NFP Energy</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Energy()
		 * @generated
		 */
		EDataType NFP_ENERGY = eINSTANCE.getNFP_Energy();

		/**
		 * The meta object literal for the '<em>NFP Length</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Length()
		 * @generated
		 */
		EDataType NFP_LENGTH = eINSTANCE.getNFP_Length();

		/**
		 * The meta object literal for the '<em>NFP Area</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Area()
		 * @generated
		 */
		EDataType NFP_AREA = eINSTANCE.getNFP_Area();

		/**
		 * The meta object literal for the '<em>Arrival Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getArrivalPattern()
		 * @generated
		 */
		EDataType ARRIVAL_PATTERN = eINSTANCE.getArrivalPattern();

		/**
		 * The meta object literal for the '<em>Periodic Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getPeriodicPattern()
		 * @generated
		 */
		EDataType PERIODIC_PATTERN = eINSTANCE.getPeriodicPattern();

		/**
		 * The meta object literal for the '<em>Aperiodic Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getAperiodicPattern()
		 * @generated
		 */
		EDataType APERIODIC_PATTERN = eINSTANCE.getAperiodicPattern();

		/**
		 * The meta object literal for the '<em>Closed Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getClosedPattern()
		 * @generated
		 */
		EDataType CLOSED_PATTERN = eINSTANCE.getClosedPattern();

		/**
		 * The meta object literal for the '<em>Sporadic Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getSporadicPattern()
		 * @generated
		 */
		EDataType SPORADIC_PATTERN = eINSTANCE.getSporadicPattern();

		/**
		 * The meta object literal for the '<em>Burst Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getBurstPattern()
		 * @generated
		 */
		EDataType BURST_PATTERN = eINSTANCE.getBurstPattern();

		/**
		 * The meta object literal for the '<em>Irregular Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getIrregularPattern()
		 * @generated
		 */
		EDataType IRREGULAR_PATTERN = eINSTANCE.getIrregularPattern();

		/**
		 * The meta object literal for the '<em>NFP Percentage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Percentage()
		 * @generated
		 */
		EDataType NFP_PERCENTAGE = eINSTANCE.getNFP_Percentage();

		/**
		 * The meta object literal for the '<em>Open Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getOpenPattern()
		 * @generated
		 */
		EDataType OPEN_PATTERN = eINSTANCE.getOpenPattern();

		/**
		 * The meta object literal for the '<em>NFP Price</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Price()
		 * @generated
		 */
		EDataType NFP_PRICE = eINSTANCE.getNFP_Price();

		/**
		 * The meta object literal for the '<em>NFP Weight</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl#getNFP_Weight()
		 * @generated
		 */
		EDataType NFP_WEIGHT = eINSTANCE.getNFP_Weight();

	}

} //BasicNFP_TypesPackage
