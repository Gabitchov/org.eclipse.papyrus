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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Synchronization Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getSynchronizationKind()
 * @model
 * @generated
 */
public enum SynchronizationKind implements Enumerator {
	/**
	 * The '<em><b>Synchronous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONOUS_VALUE
	 * @generated
	 * @ordered
	 */
	SYNCHRONOUS(0, "synchronous", "synchronous"),

	/**
	 * The '<em><b>Asynchronous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNCHRONOUS_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNCHRONOUS(1, "asynchronous", "asynchronous"),

	/**
	 * The '<em><b>Delayed Synchronous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELAYED_SYNCHRONOUS_VALUE
	 * @generated
	 * @ordered
	 */
	DELAYED_SYNCHRONOUS(2, "delayedSynchronous", "delayedSynchronous"),

	/**
	 * The '<em><b>Rendez Vous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENDEZ_VOUS_VALUE
	 * @generated
	 * @ordered
	 */
	RENDEZ_VOUS(3, "rendezVous", "rendezVous"),

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
	 * The '<em><b>Synchronous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Synchronous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONOUS
	 * @model name="synchronous"
	 * @generated
	 * @ordered
	 */
	public static final int SYNCHRONOUS_VALUE = 0;

	/**
	 * The '<em><b>Asynchronous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Asynchronous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNCHRONOUS
	 * @model name="asynchronous"
	 * @generated
	 * @ordered
	 */
	public static final int ASYNCHRONOUS_VALUE = 1;

	/**
	 * The '<em><b>Delayed Synchronous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Delayed Synchronous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELAYED_SYNCHRONOUS
	 * @model name="delayedSynchronous"
	 * @generated
	 * @ordered
	 */
	public static final int DELAYED_SYNCHRONOUS_VALUE = 2;

	/**
	 * The '<em><b>Rendez Vous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rendez Vous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RENDEZ_VOUS
	 * @model name="rendezVous"
	 * @generated
	 * @ordered
	 */
	public static final int RENDEZ_VOUS_VALUE = 3;

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
	 * An array of all the '<em><b>Synchronization Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SynchronizationKind[] VALUES_ARRAY =
		new SynchronizationKind[] {
			SYNCHRONOUS,
			ASYNCHRONOUS,
			DELAYED_SYNCHRONOUS,
			RENDEZ_VOUS,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Synchronization Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SynchronizationKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Synchronization Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronizationKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronization Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronizationKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronization Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationKind get(int value) {
		switch (value) {
			case SYNCHRONOUS_VALUE: return SYNCHRONOUS;
			case ASYNCHRONOUS_VALUE: return ASYNCHRONOUS;
			case DELAYED_SYNCHRONOUS_VALUE: return DELAYED_SYNCHRONOUS;
			case RENDEZ_VOUS_VALUE: return RENDEZ_VOUS;
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
	private SynchronizationKind(int value, String name, String literal) {
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
	
} //SynchronizationKind
