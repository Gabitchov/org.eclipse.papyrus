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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Message Resource Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getMessageResourceKind()
 * @model
 * @generated
 */
public enum MessageResourceKind implements Enumerator {
	/**
	 * The '<em><b>Message Queue</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_QUEUE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_QUEUE(0, "MessageQueue", "MessageQueue"),

	/**
	 * The '<em><b>Pipe</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIPE_VALUE
	 * @generated
	 * @ordered
	 */
	PIPE(1, "Pipe", "Pipe"),

	/**
	 * The '<em><b>Blackboard</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLACKBOARD_VALUE
	 * @generated
	 * @ordered
	 */
	BLACKBOARD(2, "Blackboard", "Blackboard"),

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
	 * The '<em><b>Message Queue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Message Queue</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_QUEUE
	 * @model name="MessageQueue"
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_QUEUE_VALUE = 0;

	/**
	 * The '<em><b>Pipe</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pipe</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIPE
	 * @model name="Pipe"
	 * @generated
	 * @ordered
	 */
	public static final int PIPE_VALUE = 1;

	/**
	 * The '<em><b>Blackboard</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Blackboard</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLACKBOARD
	 * @model name="Blackboard"
	 * @generated
	 * @ordered
	 */
	public static final int BLACKBOARD_VALUE = 2;

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
	 * An array of all the '<em><b>Message Resource Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MessageResourceKind[] VALUES_ARRAY =
		new MessageResourceKind[] {
			MESSAGE_QUEUE,
			PIPE,
			BLACKBOARD,
			UNDEF,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Message Resource Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MessageResourceKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Message Resource Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageResourceKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageResourceKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Resource Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageResourceKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageResourceKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Resource Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageResourceKind get(int value) {
		switch (value) {
			case MESSAGE_QUEUE_VALUE: return MESSAGE_QUEUE;
			case PIPE_VALUE: return PIPE;
			case BLACKBOARD_VALUE: return BLACKBOARD;
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
	private MessageResourceKind(int value, String name, String literal) {
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
	
} //MessageResourceKind
