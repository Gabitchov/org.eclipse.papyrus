/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Actual Choice</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.FCM.FCMPackage#getActualChoice()
 * @model
 * @generated
 */
public enum ActualChoice implements Enumerator {
	/**
	 * The '<em><b>Pass Actual</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASS_ACTUAL_VALUE
	 * @generated
	 * @ordered
	 */
	PASS_ACTUAL(0, "PassActual", "PassActual"), /**
	 * The '<em><b>Interface Of PPort</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_OF_PPORT_VALUE
	 * @generated
	 * @ordered
	 */
	INTERFACE_OF_PPORT(1, "InterfaceOfPPort", "InterfaceOfPPort"),

	/**
	 * The '<em><b>Interface Of Rport</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_OF_RPORT_VALUE
	 * @generated
	 * @ordered
	 */
	INTERFACE_OF_RPORT(2, "InterfaceOfRport", "InterfaceOfRport");

	/**
	 * The '<em><b>Pass Actual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pass Actual</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASS_ACTUAL
	 * @model name="PassActual"
	 * @generated
	 * @ordered
	 */
	public static final int PASS_ACTUAL_VALUE = 0;

	/**
	 * The '<em><b>Interface Of PPort</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interface Of PPort</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_OF_PPORT
	 * @model name="InterfaceOfPPort"
	 * @generated
	 * @ordered
	 */
	public static final int INTERFACE_OF_PPORT_VALUE = 1;

	/**
	 * The '<em><b>Interface Of Rport</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interface Of Rport</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_OF_RPORT
	 * @model name="InterfaceOfRport"
	 * @generated
	 * @ordered
	 */
	public static final int INTERFACE_OF_RPORT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Actual Choice</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ActualChoice[] VALUES_ARRAY =
		new ActualChoice[] {
			PASS_ACTUAL,
			INTERFACE_OF_PPORT,
			INTERFACE_OF_RPORT,
		};

	/**
	 * A public read-only list of all the '<em><b>Actual Choice</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ActualChoice> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Actual Choice</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActualChoice get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActualChoice result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Actual Choice</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActualChoice getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActualChoice result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Actual Choice</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActualChoice get(int value) {
		switch (value) {
			case PASS_ACTUAL_VALUE: return PASS_ACTUAL;
			case INTERFACE_OF_PPORT_VALUE: return INTERFACE_OF_PPORT;
			case INTERFACE_OF_RPORT_VALUE: return INTERFACE_OF_RPORT;
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
	private ActualChoice(int value, String name, String literal) {
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
	
} //ActualChoice
