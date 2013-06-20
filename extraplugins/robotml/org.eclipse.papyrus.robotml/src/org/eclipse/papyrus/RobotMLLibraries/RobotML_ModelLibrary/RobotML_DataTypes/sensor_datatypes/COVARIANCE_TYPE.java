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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>COVARIANCE TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage#getCOVARIANCE_TYPE()
 * @model
 * @generated
 */
public enum COVARIANCE_TYPE implements Enumerator {
	/**
	 * The '<em><b>COVARIANCE TYPE UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	COVARIANCE_TYPE_UNKNOWN(0, "COVARIANCE_TYPE_UNKNOWN", "COVARIANCE_TYPE_UNKNOWN"),

	/**
	 * The '<em><b>COVARIANCE TYPE APPROXIMATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_APPROXIMATED_VALUE
	 * @generated
	 * @ordered
	 */
	COVARIANCE_TYPE_APPROXIMATED(1, "COVARIANCE_TYPE_APPROXIMATED", "COVARIANCE_TYPE_APPROXIMATED"),

	/**
	 * The '<em><b>COVARIANCE TYPE DIAGONAL KNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #_COVARIANCE_TYPE_DIAGONAL_KNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	_COVARIANCE_TYPE_DIAGONAL_KNOWN(2, "_COVARIANCE_TYPE_DIAGONAL_KNOWN", "_COVARIANCE_TYPE_DIAGONAL_KNOWN"),

	/**
	 * The '<em><b>COVARIANCE TYPE KNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_KNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	COVARIANCE_TYPE_KNOWN(3, "COVARIANCE_TYPE_KNOWN", "COVARIANCE_TYPE_KNOWN");

	/**
	 * The '<em><b>COVARIANCE TYPE UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COVARIANCE TYPE UNKNOWN</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_UNKNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COVARIANCE_TYPE_UNKNOWN_VALUE = 0;

	/**
	 * The '<em><b>COVARIANCE TYPE APPROXIMATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COVARIANCE TYPE APPROXIMATED</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_APPROXIMATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COVARIANCE_TYPE_APPROXIMATED_VALUE = 1;

	/**
	 * The '<em><b>COVARIANCE TYPE DIAGONAL KNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COVARIANCE TYPE DIAGONAL KNOWN</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #_COVARIANCE_TYPE_DIAGONAL_KNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int _COVARIANCE_TYPE_DIAGONAL_KNOWN_VALUE = 2;

	/**
	 * The '<em><b>COVARIANCE TYPE KNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COVARIANCE TYPE KNOWN</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COVARIANCE_TYPE_KNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COVARIANCE_TYPE_KNOWN_VALUE = 3;

	/**
	 * An array of all the '<em><b>COVARIANCE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final COVARIANCE_TYPE[] VALUES_ARRAY = new COVARIANCE_TYPE[]{ COVARIANCE_TYPE_UNKNOWN, COVARIANCE_TYPE_APPROXIMATED, _COVARIANCE_TYPE_DIAGONAL_KNOWN, COVARIANCE_TYPE_KNOWN, };

	/**
	 * A public read-only list of all the '<em><b>COVARIANCE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<COVARIANCE_TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>COVARIANCE TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static COVARIANCE_TYPE get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			COVARIANCE_TYPE result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>COVARIANCE TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static COVARIANCE_TYPE getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			COVARIANCE_TYPE result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>COVARIANCE TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static COVARIANCE_TYPE get(int value) {
		switch(value) {
		case COVARIANCE_TYPE_UNKNOWN_VALUE:
			return COVARIANCE_TYPE_UNKNOWN;
		case COVARIANCE_TYPE_APPROXIMATED_VALUE:
			return COVARIANCE_TYPE_APPROXIMATED;
		case _COVARIANCE_TYPE_DIAGONAL_KNOWN_VALUE:
			return _COVARIANCE_TYPE_DIAGONAL_KNOWN;
		case COVARIANCE_TYPE_KNOWN_VALUE:
			return COVARIANCE_TYPE_KNOWN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private COVARIANCE_TYPE(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //COVARIANCE_TYPE
