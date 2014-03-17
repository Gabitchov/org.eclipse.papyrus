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
 * A representation of the literals of the enumeration '<em><b>Severity Class Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The SeverityClassKind is an enumeration metaclass with enumeration literals indicating the severity attributes S0, S1, S2 or S3 in accordance with
 * ISO26262.
 * 
 * Semantics:
 * The semantics is defined at each enumeration literal and fully defined in the ISO26262 standard.
 * 
 * Extension:
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getSeverityClassKind()
 * @model
 * @generated
 */
public enum SeverityClassKind implements Enumerator {
	/**
	 * The '<em><b>S0</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #S0_VALUE
	 * @generated
	 * @ordered
	 */
	S0(0, "S0", "S0"),

	/**
	 * The '<em><b>S1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #S1_VALUE
	 * @generated
	 * @ordered
	 */
	S1(1, "S1", "S1"),

	/**
	 * The '<em><b>S2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #S2_VALUE
	 * @generated
	 * @ordered
	 */
	S2(2, "S2", "S2"),

	/**
	 * The '<em><b>S3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #S3_VALUE
	 * @generated
	 * @ordered
	 */
	S3(3, "S3", "S3");

	/**
	 * The '<em><b>S0</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No injuries.
	 * <!-- end-model-doc -->
	 * 
	 * @see #S0
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int S0_VALUE = 0;

	/**
	 * The '<em><b>S1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Light and moderate injuries
	 * <!-- end-model-doc -->
	 * 
	 * @see #S1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int S1_VALUE = 1;

	/**
	 * The '<em><b>S2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Severe and life-threatening injuries (survival probable)
	 * <!-- end-model-doc -->
	 * 
	 * @see #S2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int S2_VALUE = 2;

	/**
	 * The '<em><b>S3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Life-threatening injuries (survival uncertain), fatal injuries
	 * <!-- end-model-doc -->
	 * 
	 * @see #S3
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int S3_VALUE = 3;

	/**
	 * An array of all the '<em><b>Severity Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final SeverityClassKind[] VALUES_ARRAY = new SeverityClassKind[]{ S0, S1, S2, S3, };

	/**
	 * A public read-only list of all the '<em><b>Severity Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<SeverityClassKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Severity Class Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SeverityClassKind get(int value) {
		switch(value) {
		case S0_VALUE:
			return S0;
		case S1_VALUE:
			return S1;
		case S2_VALUE:
			return S2;
		case S3_VALUE:
			return S3;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Severity Class Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SeverityClassKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			SeverityClassKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Severity Class Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SeverityClassKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			SeverityClassKind result = VALUES_ARRAY[i];
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
	private SeverityClassKind(int value, String name, String literal) {
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

} //SeverityClassKind
