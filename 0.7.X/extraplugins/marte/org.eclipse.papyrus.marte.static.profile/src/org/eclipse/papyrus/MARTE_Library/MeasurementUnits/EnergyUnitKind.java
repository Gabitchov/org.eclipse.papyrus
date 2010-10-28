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
package org.eclipse.papyrus.MARTE_Library.MeasurementUnits;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Energy Unit Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage#getEnergyUnitKind()
 * @model
 * @generated
 */
public enum EnergyUnitKind implements Enumerator {
	/**
	 * The '<em><b>J</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #J_VALUE
	 * @generated
	 * @ordered
	 */
	J(0, "J", "J"),

	/**
	 * The '<em><b>KJ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KJ_VALUE
	 * @generated
	 * @ordered
	 */
	KJ(1, "KJ", "KJ"),

	/**
	 * The '<em><b>Wh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WH_VALUE
	 * @generated
	 * @ordered
	 */
	WH(2, "Wh", "Wh"),

	/**
	 * The '<em><b>KWh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KWH_VALUE
	 * @generated
	 * @ordered
	 */
	KWH(3, "KWh", "KWh"),

	/**
	 * The '<em><b>MWh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MWH_VALUE
	 * @generated
	 * @ordered
	 */
	MWH(4, "mWh", "mWh");

	/**
	 * The '<em><b>J</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>J</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #J
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int J_VALUE = 0;

	/**
	 * The '<em><b>KJ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KJ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KJ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KJ_VALUE = 1;

	/**
	 * The '<em><b>Wh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WH
	 * @model name="Wh"
	 * @generated
	 * @ordered
	 */
	public static final int WH_VALUE = 2;

	/**
	 * The '<em><b>KWh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KWh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KWH
	 * @model name="KWh"
	 * @generated
	 * @ordered
	 */
	public static final int KWH_VALUE = 3;

	/**
	 * The '<em><b>MWh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MWh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MWH
	 * @model name="mWh"
	 * @generated
	 * @ordered
	 */
	public static final int MWH_VALUE = 4;

	/**
	 * An array of all the '<em><b>Energy Unit Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnergyUnitKind[] VALUES_ARRAY =
		new EnergyUnitKind[] {
			J,
			KJ,
			WH,
			KWH,
			MWH,
		};

	/**
	 * A public read-only list of all the '<em><b>Energy Unit Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EnergyUnitKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Energy Unit Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnergyUnitKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnergyUnitKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Energy Unit Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnergyUnitKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnergyUnitKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Energy Unit Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnergyUnitKind get(int value) {
		switch (value) {
			case J_VALUE: return J;
			case KJ_VALUE: return KJ;
			case WH_VALUE: return WH;
			case KWH_VALUE: return KWH;
			case MWH_VALUE: return MWH;
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
	private EnergyUnitKind(int value, String name, String literal) {
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
	
} //EnergyUnitKind
