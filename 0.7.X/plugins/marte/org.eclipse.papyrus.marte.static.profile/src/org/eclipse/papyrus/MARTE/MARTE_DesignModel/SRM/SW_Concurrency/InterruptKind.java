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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Interrupt Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage#getInterruptKind()
 * @model
 * @generated
 */
public enum InterruptKind implements Enumerator {
	/**
	 * The '<em><b>Hardware Interruption</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARDWARE_INTERRUPTION_VALUE
	 * @generated
	 * @ordered
	 */
	HARDWARE_INTERRUPTION(0, "HardwareInterruption", "HardwareInterruption"),

	/**
	 * The '<em><b>Processor Detected Exception</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESSOR_DETECTED_EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESSOR_DETECTED_EXCEPTION(1, "ProcessorDetectedException", "ProcessorDetectedException"),

	/**
	 * The '<em><b>Programmed Exception</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROGRAMMED_EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	PROGRAMMED_EXCEPTION(2, "ProgrammedException", "ProgrammedException"),

	/**
	 * The '<em><b>Undef</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEF_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEF(3, "Undef", "Undef"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(4, "Other", "Other");

	/**
	 * The '<em><b>Hardware Interruption</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hardware Interruption</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HARDWARE_INTERRUPTION
	 * @model name="HardwareInterruption"
	 * @generated
	 * @ordered
	 */
	public static final int HARDWARE_INTERRUPTION_VALUE = 0;

	/**
	 * The '<em><b>Processor Detected Exception</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Processor Detected Exception</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESSOR_DETECTED_EXCEPTION
	 * @model name="ProcessorDetectedException"
	 * @generated
	 * @ordered
	 */
	public static final int PROCESSOR_DETECTED_EXCEPTION_VALUE = 1;

	/**
	 * The '<em><b>Programmed Exception</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Programmed Exception</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROGRAMMED_EXCEPTION
	 * @model name="ProgrammedException"
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAMMED_EXCEPTION_VALUE = 2;

	/**
	 * The '<em><b>Undef</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undef</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEF
	 * @model name="Undef"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEF_VALUE = 3;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Interrupt Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InterruptKind[] VALUES_ARRAY =
		new InterruptKind[] {
			HARDWARE_INTERRUPTION,
			PROCESSOR_DETECTED_EXCEPTION,
			PROGRAMMED_EXCEPTION,
			UNDEF,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Interrupt Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InterruptKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Interrupt Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InterruptKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InterruptKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interrupt Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InterruptKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InterruptKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interrupt Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InterruptKind get(int value) {
		switch (value) {
			case HARDWARE_INTERRUPTION_VALUE: return HARDWARE_INTERRUPTION;
			case PROCESSOR_DETECTED_EXCEPTION_VALUE: return PROCESSOR_DETECTED_EXCEPTION;
			case PROGRAMMED_EXCEPTION_VALUE: return PROGRAMMED_EXCEPTION;
			case UNDEF_VALUE: return UNDEF;
			case OTHER_VALUE: return OTHER;
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
	private InterruptKind(int value, String name, String literal) {
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
	
} //InterruptKind
