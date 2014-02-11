/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage
 * @generated
 */
public class Std_datatypesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Std_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Std_datatypesSwitch() {
		if (modelPackage == null) {
			modelPackage = Std_datatypesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Std_datatypesPackage.HEADER: {
				Header header = (Header)theEObject;
				T result = caseHeader(header);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.MULTI_ARRAY_DIMENSION: {
				MultiArrayDimension multiArrayDimension = (MultiArrayDimension)theEObject;
				T result = caseMultiArrayDimension(multiArrayDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.MULTI_ARRAY_LAYOUT: {
				MultiArrayLayout multiArrayLayout = (MultiArrayLayout)theEObject;
				T result = caseMultiArrayLayout(multiArrayLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.BYTE_MULTI_ARRAY: {
				ByteMultiArray byteMultiArray = (ByteMultiArray)theEObject;
				T result = caseByteMultiArray(byteMultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.COLOR_RGBA: {
				ColorRGBA colorRGBA = (ColorRGBA)theEObject;
				T result = caseColorRGBA(colorRGBA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.FLOAT32_MULTI_ARRAY: {
				Float32MultiArray float32MultiArray = (Float32MultiArray)theEObject;
				T result = caseFloat32MultiArray(float32MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.INT32_MULTI_ARRAY: {
				Int32MultiArray int32MultiArray = (Int32MultiArray)theEObject;
				T result = caseInt32MultiArray(int32MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.INT8_MULTI_ARRAY: {
				Int8MultiArray int8MultiArray = (Int8MultiArray)theEObject;
				T result = caseInt8MultiArray(int8MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.INT16_MULTI_ARRAY: {
				Int16MultiArray int16MultiArray = (Int16MultiArray)theEObject;
				T result = caseInt16MultiArray(int16MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.INT64_MULTI_ARRAY: {
				Int64MultiArray int64MultiArray = (Int64MultiArray)theEObject;
				T result = caseInt64MultiArray(int64MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.FLOAT64_MULTI_ARRAY: {
				Float64MultiArray float64MultiArray = (Float64MultiArray)theEObject;
				T result = caseFloat64MultiArray(float64MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.UINT64_MULTI_ARRAY: {
				UInt64MultiArray uInt64MultiArray = (UInt64MultiArray)theEObject;
				T result = caseUInt64MultiArray(uInt64MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.UIINT16_MULTI_ARRAY: {
				UIint16MultiArray uIint16MultiArray = (UIint16MultiArray)theEObject;
				T result = caseUIint16MultiArray(uIint16MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.UINT32_MULTI_ARRAY: {
				UInt32MultiArray uInt32MultiArray = (UInt32MultiArray)theEObject;
				T result = caseUInt32MultiArray(uInt32MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Std_datatypesPackage.UINT8_MULTI_ARRAY: {
				UInt8MultiArray uInt8MultiArray = (UInt8MultiArray)theEObject;
				T result = caseUInt8MultiArray(uInt8MultiArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Header</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeader(Header object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Array Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiArrayDimension(MultiArrayDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Array Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Array Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiArrayLayout(MultiArrayLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseByteMultiArray(ByteMultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color RGBA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color RGBA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorRGBA(ColorRGBA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float32 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float32 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloat32MultiArray(Float32MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int32 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int32 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInt32MultiArray(Int32MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int8 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int8 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInt8MultiArray(Int8MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int16 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int16 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInt16MultiArray(Int16MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int64 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int64 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInt64MultiArray(Int64MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float64 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float64 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloat64MultiArray(Float64MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UInt64 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UInt64 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUInt64MultiArray(UInt64MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UIint16 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UIint16 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUIint16MultiArray(UIint16MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UInt32 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UInt32 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUInt32MultiArray(UInt32MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UInt8 Multi Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UInt8 Multi Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUInt8MultiArray(UInt8MultiArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Std_datatypesSwitch
