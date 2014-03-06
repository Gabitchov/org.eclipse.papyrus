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
package org.eclipse.papyrus.eastadl.behavior;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Function Behavior Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * FunctionBehaviorKind is an enumeration which lists the various representations, used to describe a FunctionBehavior. It is used as a property of a
 * FunctionBehavior. Several representations are listed; however one can always extend this list by using the literal OTHER.
 * 
 * Semantics:
 * Distinction between UML and MARTE comes from the slight differences in the behavioral definitions (namely concerning data-flow oriented behaviors).
 * 
 * It shall be noted that though one can use several languages to provide a representation of a FunctionBehavior, the semantics shall remain compliant
 * with the overall EAST-ADL2 execution semantics.
 * 
 * Extension:
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehaviorKind()
 * @model
 * @generated
 */
public enum FunctionBehaviorKind implements Enumerator {
	/**
	 * The '<em><b>ASCET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ASCET_VALUE
	 * @generated
	 * @ordered
	 */
	ASCET(0, "ASCET", "ASCET"),

	/**
	 * The '<em><b>OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(1, "OTHER", "OTHER"),

	/**
	 * The '<em><b>SCADE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SCADE_VALUE
	 * @generated
	 * @ordered
	 */
	SCADE(2, "SCADE", "SCADE"),

	/**
	 * The '<em><b>SDL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SDL_VALUE
	 * @generated
	 * @ordered
	 */
	SDL(3, "SDL", "SDL"),

	/**
	 * The '<em><b>SIMULINK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SIMULINK_VALUE
	 * @generated
	 * @ordered
	 */
	SIMULINK(4, "SIMULINK", "SIMULINK"),

	/**
	 * The '<em><b>STATEMATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATEMATE_VALUE
	 * @generated
	 * @ordered
	 */
	STATEMATE(5, "STATEMATE", "STATEMATE"), /**
	 * The '<em><b>MARTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MARTE_VALUE
	 * @generated
	 * @ordered
	 */
	MARTE(6, "MARTE", "MARTE"), /**
	 * The '<em><b>UML</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #UML_VALUE
	 * @generated
	 * @ordered
	 */
	UML(7, "UML", "UML");

	/**
	 * The '<em><b>ASCET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASCET</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ASCET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASCET_VALUE = 0;

	/**
	 * The '<em><b>OTHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OTHER</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OTHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 1;

	/**
	 * The '<em><b>SCADE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCADE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SCADE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCADE_VALUE = 2;

	/**
	 * The '<em><b>SDL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SDL</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SDL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SDL_VALUE = 3;

	/**
	 * The '<em><b>SIMULINK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIMULINK</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SIMULINK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIMULINK_VALUE = 4;

	/**
	 * The '<em><b>STATEMATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATEMATE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATEMATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATEMATE_VALUE = 5;

	/**
	 * The '<em><b>MARTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MARTE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MARTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MARTE_VALUE = 6;

	/**
	 * The '<em><b>UML</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UML</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #UML
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UML_VALUE = 7;

	/**
	 * An array of all the '<em><b>Function Behavior Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final FunctionBehaviorKind[] VALUES_ARRAY = new FunctionBehaviorKind[]{ ASCET, OTHER, SCADE, SDL, SIMULINK, STATEMATE, MARTE, UML, };

	/**
	 * A public read-only list of all the '<em><b>Function Behavior Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<FunctionBehaviorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Function Behavior Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FunctionBehaviorKind get(int value) {
		switch(value) {
		case ASCET_VALUE:
			return ASCET;
		case OTHER_VALUE:
			return OTHER;
		case SCADE_VALUE:
			return SCADE;
		case SDL_VALUE:
			return SDL;
		case SIMULINK_VALUE:
			return SIMULINK;
		case STATEMATE_VALUE:
			return STATEMATE;
		case MARTE_VALUE:
			return MARTE;
		case UML_VALUE:
			return UML;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Behavior Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FunctionBehaviorKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionBehaviorKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Behavior Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FunctionBehaviorKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionBehaviorKind result = VALUES_ARRAY[i];
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
	private FunctionBehaviorKind(int value, String name, String literal) {
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

} //FunctionBehaviorKind
