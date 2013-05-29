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
package org.eclipse.papyrus.eastadl.dependability.safetyconstraints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ASIL Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The ASILKind is an enumeration metaclass with enumeration literals indicating the level of safety integrity in accordance with ISO26262.
 * 
 * Semantics:
 * The semantics is defined at each enumeration literal and fully defined in the ISO26262 standard.
 * 
 * Extension: 
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getASILKind()
 * @model
 * @generated
 */
public enum ASILKind implements Enumerator {
	/**
	 * The '<em><b>ASIL A</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_A_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_A(0, "ASIL_A", "ASIL_A"), /**
	 * The '<em><b>ASIL D</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_D_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_D(1, "ASIL_D", "ASIL_D"), /**
	 * The '<em><b>ASIL C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_C_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_C(2, "ASIL_C", "ASIL_C"), /**
	 * The '<em><b>ASIL B</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_B_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_B(3, "ASIL_B", "ASIL_B"), /**
	 * The '<em><b>QM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QM_VALUE
	 * @generated
	 * @ordered
	 */
	QM(4, "QM", "QM");

	/**
	 * The '<em><b>ASIL A</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ASIL A, Lowest Safety Integrity Level.
	 * <!-- end-model-doc -->
	 * @see #ASIL_A
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_A_VALUE = 0;

	/**
	 * The '<em><b>ASIL D</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ASIL D, Highest Safety Integrity Level.
	 * <!-- end-model-doc -->
	 * @see #ASIL_D
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_D_VALUE = 1;

	/**
	 * The '<em><b>ASIL C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ASIL C, second highest Safety Integrity Level.
	 * <!-- end-model-doc -->
	 * @see #ASIL_C
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_C_VALUE = 2;

	/**
	 * The '<em><b>ASIL B</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ASIL B, second lowest Safety Integrity Level.
	 * <!-- end-model-doc -->
	 * @see #ASIL_B
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_B_VALUE = 3;

	/**
	 * The '<em><b>QM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Quality Management only, no requirement according to ISO 26262.
	 * <!-- end-model-doc -->
	 * @see #QM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QM_VALUE = 4;

	/**
	 * An array of all the '<em><b>ASIL Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ASILKind[] VALUES_ARRAY =
		new ASILKind[] {
			ASIL_A,
			ASIL_D,
			ASIL_C,
			ASIL_B,
			QM,
		};

	/**
	 * A public read-only list of all the '<em><b>ASIL Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ASILKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ASIL Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ASILKind get(int value) {
		switch (value) {
			case ASIL_A_VALUE: return ASIL_A;
			case ASIL_D_VALUE: return ASIL_D;
			case ASIL_C_VALUE: return ASIL_C;
			case ASIL_B_VALUE: return ASIL_B;
			case QM_VALUE: return QM;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ASIL Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ASILKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ASILKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ASIL Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ASILKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ASILKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
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
	private ASILKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
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
	public int getValue() {
	  return value;
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
	
} //ASILKind
