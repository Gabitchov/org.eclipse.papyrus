/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl;

import java.util.Date;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UIint16MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Std_datatypesFactoryImpl extends EFactoryImpl implements Std_datatypesFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Std_datatypesFactory init() {
		try {
			Std_datatypesFactory theStd_datatypesFactory = (Std_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/std_datatypes.ecore");
			if(theStd_datatypesFactory != null) {
				return theStd_datatypesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Std_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Std_datatypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case Std_datatypesPackage.HEADER:
			return createHeader();
		case Std_datatypesPackage.MULTI_ARRAY_DIMENSION:
			return createMultiArrayDimension();
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT:
			return createMultiArrayLayout();
		case Std_datatypesPackage.BYTE_MULTI_ARRAY:
			return createByteMultiArray();
		case Std_datatypesPackage.COLOR_RGBA:
			return createColorRGBA();
		case Std_datatypesPackage.FLOAT32_MULTI_ARRAY:
			return createFloat32MultiArray();
		case Std_datatypesPackage.INT32_MULTI_ARRAY:
			return createInt32MultiArray();
		case Std_datatypesPackage.INT8_MULTI_ARRAY:
			return createInt8MultiArray();
		case Std_datatypesPackage.INT16_MULTI_ARRAY:
			return createInt16MultiArray();
		case Std_datatypesPackage.INT64_MULTI_ARRAY:
			return createInt64MultiArray();
		case Std_datatypesPackage.FLOAT64_MULTI_ARRAY:
			return createFloat64MultiArray();
		case Std_datatypesPackage.UINT64_MULTI_ARRAY:
			return createUInt64MultiArray();
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY:
			return createUIint16MultiArray();
		case Std_datatypesPackage.UINT32_MULTI_ARRAY:
			return createUInt32MultiArray();
		case Std_datatypesPackage.UINT8_MULTI_ARRAY:
			return createUInt8MultiArray();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case Std_datatypesPackage.UINT32:
			return createUInt32FromString(eDataType, initialValue);
		case Std_datatypesPackage.TIME:
			return createTimeFromString(eDataType, initialValue);
		case Std_datatypesPackage.STRING:
			return createStringFromString(eDataType, initialValue);
		case Std_datatypesPackage.BYTE:
			return createByteFromString(eDataType, initialValue);
		case Std_datatypesPackage.FLOAT64:
			return createFloat64FromString(eDataType, initialValue);
		case Std_datatypesPackage.INT8:
			return createInt8FromString(eDataType, initialValue);
		case Std_datatypesPackage.BOOL:
			return createBoolFromString(eDataType, initialValue);
		case Std_datatypesPackage.UINT8:
			return createUInt8FromString(eDataType, initialValue);
		case Std_datatypesPackage.UINT16:
			return createUInt16FromString(eDataType, initialValue);
		case Std_datatypesPackage.INT32:
			return createInt32FromString(eDataType, initialValue);
		case Std_datatypesPackage.INT16:
			return createInt16FromString(eDataType, initialValue);
		case Std_datatypesPackage.CHAR:
			return createCharFromString(eDataType, initialValue);
		case Std_datatypesPackage.DURATION:
			return createDurationFromString(eDataType, initialValue);
		case Std_datatypesPackage.INT64:
			return createInt64FromString(eDataType, initialValue);
		case Std_datatypesPackage.UINT64:
			return createUInt64FromString(eDataType, initialValue);
		case Std_datatypesPackage.FLOAT32:
			return createFloat32FromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case Std_datatypesPackage.UINT32:
			return convertUInt32ToString(eDataType, instanceValue);
		case Std_datatypesPackage.TIME:
			return convertTimeToString(eDataType, instanceValue);
		case Std_datatypesPackage.STRING:
			return convertStringToString(eDataType, instanceValue);
		case Std_datatypesPackage.BYTE:
			return convertByteToString(eDataType, instanceValue);
		case Std_datatypesPackage.FLOAT64:
			return convertFloat64ToString(eDataType, instanceValue);
		case Std_datatypesPackage.INT8:
			return convertInt8ToString(eDataType, instanceValue);
		case Std_datatypesPackage.BOOL:
			return convertBoolToString(eDataType, instanceValue);
		case Std_datatypesPackage.UINT8:
			return convertUInt8ToString(eDataType, instanceValue);
		case Std_datatypesPackage.UINT16:
			return convertUInt16ToString(eDataType, instanceValue);
		case Std_datatypesPackage.INT32:
			return convertInt32ToString(eDataType, instanceValue);
		case Std_datatypesPackage.INT16:
			return convertInt16ToString(eDataType, instanceValue);
		case Std_datatypesPackage.CHAR:
			return convertCharToString(eDataType, instanceValue);
		case Std_datatypesPackage.DURATION:
			return convertDurationToString(eDataType, instanceValue);
		case Std_datatypesPackage.INT64:
			return convertInt64ToString(eDataType, instanceValue);
		case Std_datatypesPackage.UINT64:
			return convertUInt64ToString(eDataType, instanceValue);
		case Std_datatypesPackage.FLOAT32:
			return convertFloat32ToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Header createHeader() {
		HeaderImpl header = new HeaderImpl();
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiArrayDimension createMultiArrayDimension() {
		MultiArrayDimensionImpl multiArrayDimension = new MultiArrayDimensionImpl();
		return multiArrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiArrayLayout createMultiArrayLayout() {
		MultiArrayLayoutImpl multiArrayLayout = new MultiArrayLayoutImpl();
		return multiArrayLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ByteMultiArray createByteMultiArray() {
		ByteMultiArrayImpl byteMultiArray = new ByteMultiArrayImpl();
		return byteMultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ColorRGBA createColorRGBA() {
		ColorRGBAImpl colorRGBA = new ColorRGBAImpl();
		return colorRGBA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float32MultiArray createFloat32MultiArray() {
		Float32MultiArrayImpl float32MultiArray = new Float32MultiArrayImpl();
		return float32MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Int32MultiArray createInt32MultiArray() {
		Int32MultiArrayImpl int32MultiArray = new Int32MultiArrayImpl();
		return int32MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Int8MultiArray createInt8MultiArray() {
		Int8MultiArrayImpl int8MultiArray = new Int8MultiArrayImpl();
		return int8MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Int16MultiArray createInt16MultiArray() {
		Int16MultiArrayImpl int16MultiArray = new Int16MultiArrayImpl();
		return int16MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Int64MultiArray createInt64MultiArray() {
		Int64MultiArrayImpl int64MultiArray = new Int64MultiArrayImpl();
		return int64MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float64MultiArray createFloat64MultiArray() {
		Float64MultiArrayImpl float64MultiArray = new Float64MultiArrayImpl();
		return float64MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UInt64MultiArray createUInt64MultiArray() {
		UInt64MultiArrayImpl uInt64MultiArray = new UInt64MultiArrayImpl();
		return uInt64MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIint16MultiArray createUIint16MultiArray() {
		UIint16MultiArrayImpl uIint16MultiArray = new UIint16MultiArrayImpl();
		return uIint16MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UInt32MultiArray createUInt32MultiArray() {
		UInt32MultiArrayImpl uInt32MultiArray = new UInt32MultiArrayImpl();
		return uInt32MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UInt8MultiArray createUInt8MultiArray() {
		UInt8MultiArrayImpl uInt8MultiArray = new UInt8MultiArrayImpl();
		return uInt8MultiArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Long createUInt32FromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUInt32ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date createTimeFromString(EDataType eDataType, String initialValue) {
		return (Date)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTimeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Byte createByteFromString(EDataType eDataType, String initialValue) {
		return (Byte)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertByteToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Double createFloat64FromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFloat64ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Character createInt8FromString(EDataType eDataType, String initialValue) {
		return (Character)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertInt8ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Boolean createBoolFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBoolToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Character createUInt8FromString(EDataType eDataType, String initialValue) {
		return (Character)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUInt8ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Integer createUInt16FromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUInt16ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Integer createInt32FromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertInt32ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Integer createInt16FromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertInt16ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Character createCharFromString(EDataType eDataType, String initialValue) {
		return (Character)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCharToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Double createDurationFromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDurationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Double createInt64FromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertInt64ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Long createUInt64FromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUInt64ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float createFloat32FromString(EDataType eDataType, String initialValue) {
		return (Float)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFloat32ToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Std_datatypesPackage getStd_datatypesPackage() {
		return (Std_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Std_datatypesPackage getPackage() {
		return Std_datatypesPackage.eINSTANCE;
	}

} //Std_datatypesFactoryImpl
