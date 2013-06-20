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
 * A representation of the literals of the enumeration '<em><b>SERVICE TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage#getSERVICE_TYPE()
 * @model
 * @generated
 */
public enum SERVICE_TYPE implements Enumerator {
	/**
	 * The '<em><b>SERVICE GPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GPS_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_GPS(0, "SERVICE_GPS", "SERVICE_GPS"),

	/**
	 * The '<em><b>SERVICE GLONASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GLONASS_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_GLONASS(1, "SERVICE_GLONASS", "SERVICE_GLONASS"),

	/**
	 * The '<em><b>SERVICE COMPASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_COMPASS_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_COMPASS(2, "SERVICE_COMPASS", "SERVICE_COMPASS"),

	/**
	 * The '<em><b>SERVICE GALILEO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GALILEO_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_GALILEO(3, "SERVICE_GALILEO", "SERVICE_GALILEO");

	/**
	 * The '<em><b>SERVICE GPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE GPS</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_GPS_VALUE = 0;

	/**
	 * The '<em><b>SERVICE GLONASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE GLONASS</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GLONASS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_GLONASS_VALUE = 1;

	/**
	 * The '<em><b>SERVICE COMPASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE COMPASS</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_COMPASS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_COMPASS_VALUE = 2;

	/**
	 * The '<em><b>SERVICE GALILEO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE GALILEO</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVICE_GALILEO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_GALILEO_VALUE = 3;

	/**
	 * An array of all the '<em><b>SERVICE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final SERVICE_TYPE[] VALUES_ARRAY = new SERVICE_TYPE[]{ SERVICE_GPS, SERVICE_GLONASS, SERVICE_COMPASS, SERVICE_GALILEO, };

	/**
	 * A public read-only list of all the '<em><b>SERVICE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<SERVICE_TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SERVICE TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SERVICE_TYPE get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			SERVICE_TYPE result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SERVICE TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SERVICE_TYPE getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			SERVICE_TYPE result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SERVICE TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SERVICE_TYPE get(int value) {
		switch(value) {
		case SERVICE_GPS_VALUE:
			return SERVICE_GPS;
		case SERVICE_GLONASS_VALUE:
			return SERVICE_GLONASS;
		case SERVICE_COMPASS_VALUE:
			return SERVICE_COMPASS;
		case SERVICE_GALILEO_VALUE:
			return SERVICE_GALILEO;
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
	private SERVICE_TYPE(int value, String name, String literal) {
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

} //SERVICE_TYPE
