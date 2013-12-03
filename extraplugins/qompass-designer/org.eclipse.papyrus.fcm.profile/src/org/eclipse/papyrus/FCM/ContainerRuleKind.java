/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Container Rule Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.FCM.FCMPackage#getContainerRuleKind()
 * @model
 * @generated
 */
public enum ContainerRuleKind implements Enumerator {
	/**
	 * The '<em><b>Component Rule</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_RULE_VALUE
	 * @generated
	 * @ordered
	 */
	COMPONENT_RULE(0, "ComponentRule", "ComponentRule"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Light Weight OO Rule</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHT_WEIGHT_OO_RULE_VALUE
	 * @generated
	 * @ordered
	 */
	LIGHT_WEIGHT_OO_RULE(1, "LightWeightOORule", "LightWeightOORule"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Component Rule</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Component Rule</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_RULE
	 * @model name="ComponentRule"
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_RULE_VALUE = 0;

	/**
	 * The '<em><b>Light Weight OO Rule</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Light Weight OO Rule</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHT_WEIGHT_OO_RULE
	 * @model name="LightWeightOORule"
	 * @generated
	 * @ordered
	 */
	public static final int LIGHT_WEIGHT_OO_RULE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Container Rule Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ContainerRuleKind[] VALUES_ARRAY =
		new ContainerRuleKind[] {
			COMPONENT_RULE,
			LIGHT_WEIGHT_OO_RULE,
		};

	/**
	 * A public read-only list of all the '<em><b>Container Rule Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContainerRuleKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Container Rule Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerRuleKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContainerRuleKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container Rule Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerRuleKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContainerRuleKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container Rule Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerRuleKind get(int value) {
		switch (value) {
			case COMPONENT_RULE_VALUE: return COMPONENT_RULE;
			case LIGHT_WEIGHT_OO_RULE_VALUE: return LIGHT_WEIGHT_OO_RULE;
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
	private ContainerRuleKind(int value, String name, String literal) {
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
	
} //ContainerRuleKind
