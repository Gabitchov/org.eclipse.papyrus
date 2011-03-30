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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transm Mode Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesPackage#getTransmModeKind()
 * @model
 * @generated
 */
public enum TransmModeKind implements Enumerator {
	/**
	 * The '<em><b>Simplex</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIMPLEX_VALUE
	 * @generated
	 * @ordered
	 */
	SIMPLEX(0, "simplex", "simplex"),

	/**
	 * The '<em><b>Half Duplex</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_DUPLEX_VALUE
	 * @generated
	 * @ordered
	 */
	HALF_DUPLEX(1, "halfDuplex", "halfDuplex"),

	/**
	 * The '<em><b>Full Duplex</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULL_DUPLEX_VALUE
	 * @generated
	 * @ordered
	 */
	FULL_DUPLEX(2, "fullDuplex", "fullDuplex");

	/**
	 * The '<em><b>Simplex</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Simplex</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIMPLEX
	 * @model name="simplex"
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLEX_VALUE = 0;

	/**
	 * The '<em><b>Half Duplex</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Half Duplex</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_DUPLEX
	 * @model name="halfDuplex"
	 * @generated
	 * @ordered
	 */
	public static final int HALF_DUPLEX_VALUE = 1;

	/**
	 * The '<em><b>Full Duplex</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Full Duplex</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FULL_DUPLEX
	 * @model name="fullDuplex"
	 * @generated
	 * @ordered
	 */
	public static final int FULL_DUPLEX_VALUE = 2;

	/**
	 * An array of all the '<em><b>Transm Mode Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransmModeKind[] VALUES_ARRAY =
		new TransmModeKind[] {
			SIMPLEX,
			HALF_DUPLEX,
			FULL_DUPLEX,
		};

	/**
	 * A public read-only list of all the '<em><b>Transm Mode Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransmModeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transm Mode Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransmModeKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransmModeKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transm Mode Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransmModeKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransmModeKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transm Mode Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransmModeKind get(int value) {
		switch (value) {
			case SIMPLEX_VALUE: return SIMPLEX;
			case HALF_DUPLEX_VALUE: return HALF_DUPLEX;
			case FULL_DUPLEX_VALUE: return FULL_DUPLEX;
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
	private TransmModeKind(int value, String name, String literal) {
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
	
} //TransmModeKind
