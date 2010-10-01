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
package org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Time Standard Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage#getTimeStandardKind()
 * @model
 * @generated
 */
public enum TimeStandardKind implements Enumerator {
	/**
	 * The '<em><b>TAI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAI_VALUE
	 * @generated
	 * @ordered
	 */
	TAI(0, "TAI", "TAI"),

	/**
	 * The '<em><b>UT0</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UT0_VALUE
	 * @generated
	 * @ordered
	 */
	UT0(1, "UT0", "UT0"),

	/**
	 * The '<em><b>UT1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UT1_VALUE
	 * @generated
	 * @ordered
	 */
	UT1(2, "UT1", "UT1"),

	/**
	 * The '<em><b>UTC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UTC_VALUE
	 * @generated
	 * @ordered
	 */
	UTC(3, "UTC", "UTC"),

	/**
	 * The '<em><b>Local</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL(4, "Local", "Local"),

	/**
	 * The '<em><b>TT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TT_VALUE
	 * @generated
	 * @ordered
	 */
	TT(5, "TT", "TT"),

	/**
	 * The '<em><b>TBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TBD_VALUE
	 * @generated
	 * @ordered
	 */
	TBD(6, "TBD", "TBD"),

	/**
	 * The '<em><b>TCG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TCG_VALUE
	 * @generated
	 * @ordered
	 */
	TCG(7, "TCG", "TCG"),

	/**
	 * The '<em><b>TCB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TCB_VALUE
	 * @generated
	 * @ordered
	 */
	TCB(8, "TCB", "TCB"),

	/**
	 * The '<em><b>Sidereal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEREAL_VALUE
	 * @generated
	 * @ordered
	 */
	SIDEREAL(9, "Sidereal", "Sidereal"),

	/**
	 * The '<em><b>GPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GPS_VALUE
	 * @generated
	 * @ordered
	 */
	GPS(10, "GPS", "GPS");

	/**
	 * The '<em><b>TAI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TAI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TAI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TAI_VALUE = 0;

	/**
	 * The '<em><b>UT0</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UT0</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UT0
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UT0_VALUE = 1;

	/**
	 * The '<em><b>UT1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UT1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UT1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UT1_VALUE = 2;

	/**
	 * The '<em><b>UTC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UTC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UTC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UTC_VALUE = 3;

	/**
	 * The '<em><b>Local</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL
	 * @model name="Local"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_VALUE = 4;

	/**
	 * The '<em><b>TT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TT_VALUE = 5;

	/**
	 * The '<em><b>TBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TBD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TBD_VALUE = 6;

	/**
	 * The '<em><b>TCG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TCG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TCG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TCG_VALUE = 7;

	/**
	 * The '<em><b>TCB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TCB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TCB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TCB_VALUE = 8;

	/**
	 * The '<em><b>Sidereal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sidereal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIDEREAL
	 * @model name="Sidereal"
	 * @generated
	 * @ordered
	 */
	public static final int SIDEREAL_VALUE = 9;

	/**
	 * The '<em><b>GPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GPS_VALUE = 10;

	/**
	 * An array of all the '<em><b>Time Standard Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TimeStandardKind[] VALUES_ARRAY =
		new TimeStandardKind[] {
			TAI,
			UT0,
			UT1,
			UTC,
			LOCAL,
			TT,
			TBD,
			TCG,
			TCB,
			SIDEREAL,
			GPS,
		};

	/**
	 * A public read-only list of all the '<em><b>Time Standard Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TimeStandardKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Time Standard Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimeStandardKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeStandardKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Time Standard Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimeStandardKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeStandardKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Time Standard Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimeStandardKind get(int value) {
		switch (value) {
			case TAI_VALUE: return TAI;
			case UT0_VALUE: return UT0;
			case UT1_VALUE: return UT1;
			case UTC_VALUE: return UTC;
			case LOCAL_VALUE: return LOCAL;
			case TT_VALUE: return TT;
			case TBD_VALUE: return TBD;
			case TCG_VALUE: return TCG;
			case TCB_VALUE: return TCB;
			case SIDEREAL_VALUE: return SIDEREAL;
			case GPS_VALUE: return GPS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TimeStandardKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TimeStandardKind
