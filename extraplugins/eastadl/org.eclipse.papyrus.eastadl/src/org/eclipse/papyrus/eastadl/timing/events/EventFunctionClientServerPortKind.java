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
package org.eclipse.papyrus.eastadl.timing.events;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Event Function Client Server Port Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Possible values of eventKind.
 * 
 * Extension: 
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunctionClientServerPortKind()
 * @model
 * @generated
 */
public enum EventFunctionClientServerPortKind implements Enumerator {
	/**
	 * The '<em><b>Received Request</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECEIVED_REQUEST_VALUE
	 * @generated
	 * @ordered
	 */
	RECEIVED_REQUEST(0, "receivedRequest", "receivedRequest"),

	/**
	 * The '<em><b>Sent Response</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENT_RESPONSE_VALUE
	 * @generated
	 * @ordered
	 */
	SENT_RESPONSE(1, "sentResponse", "sentResponse"),

	/**
	 * The '<em><b>Sent Request</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENT_REQUEST_VALUE
	 * @generated
	 * @ordered
	 */
	SENT_REQUEST(2, "sentRequest", "sentRequest"),

	/**
	 * The '<em><b>Received Response</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECEIVED_RESPONSE_VALUE
	 * @generated
	 * @ordered
	 */
	RECEIVED_RESPONSE(3, "receivedResponse", "receivedResponse");

	/**
	 * The '<em><b>Received Request</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Received Request</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECEIVED_REQUEST
	 * @model name="receivedRequest"
	 * @generated
	 * @ordered
	 */
	public static final int RECEIVED_REQUEST_VALUE = 0;

	/**
	 * The '<em><b>Sent Response</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sent Response</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SENT_RESPONSE
	 * @model name="sentResponse"
	 * @generated
	 * @ordered
	 */
	public static final int SENT_RESPONSE_VALUE = 1;

	/**
	 * The '<em><b>Sent Request</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sent Request</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SENT_REQUEST
	 * @model name="sentRequest"
	 * @generated
	 * @ordered
	 */
	public static final int SENT_REQUEST_VALUE = 2;

	/**
	 * The '<em><b>Received Response</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Received Response</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECEIVED_RESPONSE
	 * @model name="receivedResponse"
	 * @generated
	 * @ordered
	 */
	public static final int RECEIVED_RESPONSE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Event Function Client Server Port Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventFunctionClientServerPortKind[] VALUES_ARRAY =
		new EventFunctionClientServerPortKind[] {
			RECEIVED_REQUEST,
			SENT_RESPONSE,
			SENT_REQUEST,
			RECEIVED_RESPONSE,
		};

	/**
	 * A public read-only list of all the '<em><b>Event Function Client Server Port Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventFunctionClientServerPortKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Event Function Client Server Port Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventFunctionClientServerPortKind get(int value) {
		switch (value) {
			case RECEIVED_REQUEST_VALUE: return RECEIVED_REQUEST;
			case SENT_RESPONSE_VALUE: return SENT_RESPONSE;
			case SENT_REQUEST_VALUE: return SENT_REQUEST;
			case RECEIVED_RESPONSE_VALUE: return RECEIVED_RESPONSE;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Function Client Server Port Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventFunctionClientServerPortKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventFunctionClientServerPortKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Function Client Server Port Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventFunctionClientServerPortKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventFunctionClientServerPortKind result = VALUES_ARRAY[i];
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
	private EventFunctionClientServerPortKind(int value, String name, String literal) {
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
	
} //EventFunctionClientServerPortKind
