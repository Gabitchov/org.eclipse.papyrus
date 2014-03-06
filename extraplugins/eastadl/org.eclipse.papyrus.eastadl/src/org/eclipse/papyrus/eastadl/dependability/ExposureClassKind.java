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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.dependability;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Exposure Class Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The ExposureClassKind is an enumeration metaclass with enumeration literals indicating the probability attributes E1, E2, E3 or E4 in accordance
 * with ISO26262.
 * 
 * Semantics:
 * The semantics is defined at each enumeration literal and fully defined in the ISO26262 standard.
 * 
 * Extension:
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getExposureClassKind()
 * @model
 * @generated
 */
public enum ExposureClassKind implements Enumerator {
	/**
	 * The '<em><b>E1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #E1_VALUE
	 * @generated
	 * @ordered
	 */
	E1(0, "E1", "E1"),

	/**
	 * The '<em><b>E2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #E2_VALUE
	 * @generated
	 * @ordered
	 */
	E2(1, "E2", "E2"),

	/**
	 * The '<em><b>E3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #E3_VALUE
	 * @generated
	 * @ordered
	 */
	E3(2, "E3", "E3"),

	/**
	 * The '<em><b>E4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #E4_VALUE
	 * @generated
	 * @ordered
	 */
	E4(3, "E4", "E4");

	/**
	 * The '<em><b>E1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rare events
	 * Situations that occur less often yhan once a year for the great majority of drivers
	 * <!-- end-model-doc -->
	 * 
	 * @see #E1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int E1_VALUE = 0;

	/**
	 * The '<em><b>E2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sometimes
	 * Situations that occur a few times a year for the great majority of drivers
	 * <!-- end-model-doc -->
	 * 
	 * @see #E2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int E2_VALUE = 1;

	/**
	 * The '<em><b>E3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Quite often
	 * Situations that occur once a month or more often for an average driver
	 * <!-- end-model-doc -->
	 * 
	 * @see #E3
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int E3_VALUE = 2;

	/**
	 * The '<em><b>E4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Often
	 * All situations that occur during almost every drive on average
	 * <!-- end-model-doc -->
	 * 
	 * @see #E4
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int E4_VALUE = 3;

	/**
	 * An array of all the '<em><b>Exposure Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ExposureClassKind[] VALUES_ARRAY = new ExposureClassKind[]{ E1, E2, E3, E4, };

	/**
	 * A public read-only list of all the '<em><b>Exposure Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ExposureClassKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Exposure Class Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ExposureClassKind get(int value) {
		switch(value) {
		case E1_VALUE:
			return E1;
		case E2_VALUE:
			return E2;
		case E3_VALUE:
			return E3;
		case E4_VALUE:
			return E4;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Exposure Class Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ExposureClassKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExposureClassKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Exposure Class Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ExposureClassKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExposureClassKind result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
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
	private ExposureClassKind(int value, String name, String literal) {
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
	public String getLiteral() {
		return literal;
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
	public int getValue() {
		return value;
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

} //ExposureClassKind
