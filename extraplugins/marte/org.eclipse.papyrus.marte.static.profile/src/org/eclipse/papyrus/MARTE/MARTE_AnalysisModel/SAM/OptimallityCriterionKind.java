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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Optimallity Criterion Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getOptimallityCriterionKind()
 * @model
 * @generated
 */
public enum OptimallityCriterionKind implements Enumerator {
	/**
	 * The '<em><b>Meet Hard Deadlines</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEET_HARD_DEADLINES_VALUE
	 * @generated
	 * @ordered
	 */
	MEET_HARD_DEADLINES(0, "meetHardDeadlines", "meetHardDeadlines"),

	/**
	 * The '<em><b>Minimize Missed Deadlines</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMIZE_MISSED_DEADLINES_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMIZE_MISSED_DEADLINES(1, "minimizeMissedDeadlines", "minimizeMissedDeadlines"),

	/**
	 * The '<em><b>Minimized Mean Tardiness</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMIZED_MEAN_TARDINESS_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMIZED_MEAN_TARDINESS(2, "minimizedMeanTardiness", "minimizedMeanTardiness"),

	/**
	 * The '<em><b>Undef</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEF_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEF(3, "undef", "undef"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(4, "other", "other");

	/**
	 * The '<em><b>Meet Hard Deadlines</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meet Hard Deadlines</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEET_HARD_DEADLINES
	 * @model name="meetHardDeadlines"
	 * @generated
	 * @ordered
	 */
	public static final int MEET_HARD_DEADLINES_VALUE = 0;

	/**
	 * The '<em><b>Minimize Missed Deadlines</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Minimize Missed Deadlines</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINIMIZE_MISSED_DEADLINES
	 * @model name="minimizeMissedDeadlines"
	 * @generated
	 * @ordered
	 */
	public static final int MINIMIZE_MISSED_DEADLINES_VALUE = 1;

	/**
	 * The '<em><b>Minimized Mean Tardiness</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Minimized Mean Tardiness</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINIMIZED_MEAN_TARDINESS
	 * @model name="minimizedMeanTardiness"
	 * @generated
	 * @ordered
	 */
	public static final int MINIMIZED_MEAN_TARDINESS_VALUE = 2;

	/**
	 * The '<em><b>Undef</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undef</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEF
	 * @model name="undef"
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
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Optimallity Criterion Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OptimallityCriterionKind[] VALUES_ARRAY =
		new OptimallityCriterionKind[] {
			MEET_HARD_DEADLINES,
			MINIMIZE_MISSED_DEADLINES,
			MINIMIZED_MEAN_TARDINESS,
			UNDEF,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Optimallity Criterion Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OptimallityCriterionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Optimallity Criterion Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptimallityCriterionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OptimallityCriterionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Optimallity Criterion Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptimallityCriterionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OptimallityCriterionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Optimallity Criterion Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptimallityCriterionKind get(int value) {
		switch (value) {
			case MEET_HARD_DEADLINES_VALUE: return MEET_HARD_DEADLINES;
			case MINIMIZE_MISSED_DEADLINES_VALUE: return MINIMIZE_MISSED_DEADLINES;
			case MINIMIZED_MEAN_TARDINESS_VALUE: return MINIMIZED_MEAN_TARDINESS;
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
	private OptimallityCriterionKind(int value, String name, String literal) {
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
	
} //OptimallityCriterionKind
