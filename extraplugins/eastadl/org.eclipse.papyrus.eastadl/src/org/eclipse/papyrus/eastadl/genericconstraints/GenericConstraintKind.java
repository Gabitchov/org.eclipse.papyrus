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
package org.eclipse.papyrus.eastadl.genericconstraints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generic Constraint Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Enumeration for different type of constraints.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraintKind()
 * @model
 * @generated
 */
public enum GenericConstraintKind implements Enumerator {
	/**
	 * The '<em><b>Power Consumption</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #POWER_CONSUMPTION_VALUE
	 * @generated
	 * @ordered
	 */
	POWER_CONSUMPTION(0, "powerConsumption", "powerConsumption"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(1, "other", "other"),

	/**
	 * The '<em><b>Piece Cost</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #PIECE_COST_VALUE
	 * @generated
	 * @ordered
	 */
	PIECE_COST(2, "pieceCost", "pieceCost"), /**
	 * The '<em><b>Weight</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #WEIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	WEIGHT(3, "weight", "weight"), /**
	 * The '<em><b>Standard</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #STANDARD_VALUE
	 * @generated
	 * @ordered
	 */
	STANDARD(4, "standard", "standard"), /**
	 * The '<em><b>Cable Length</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #CABLE_LENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	CABLE_LENGTH(5, "cableLength", "cableLength"), /**
	 * The '<em><b>Development Cost</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #DEVELOPMENT_COST_VALUE
	 * @generated
	 * @ordered
	 */
	DEVELOPMENT_COST(6, "developmentCost", "developmentCost"), /**
	 * The '<em><b>Function Allocation Different Nodes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #FUNCTION_ALLOCATION_DIFFERENT_NODES_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTION_ALLOCATION_DIFFERENT_NODES(7, "functionAllocationDifferentNodes", "functionAllocationDifferentNodes"), /**
	 * The '
	 * <em><b>Function Allocation Same Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #FUNCTION_ALLOCATION_SAME_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTION_ALLOCATION_SAME_NODE(8, "functionAllocationSameNode", "functionAllocationSameNode"), /**
	 * The '<em><b>Power Supply Independent</b></em>'
	 * literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #POWER_SUPPLY_INDEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	POWER_SUPPLY_INDEPENDENT(9, "powerSupplyIndependent", "powerSupplyIndependent");

	/**
	 * The '<em><b>Power Consumption</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Power Consumption</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #POWER_CONSUMPTION
	 * @model name="powerConsumption"
	 * @generated
	 * @ordered
	 */
	public static final int POWER_CONSUMPTION_VALUE = 0;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OTHER
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 1;

	/**
	 * The '<em><b>Piece Cost</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Piece Cost</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PIECE_COST
	 * @model name="pieceCost"
	 * @generated
	 * @ordered
	 */
	public static final int PIECE_COST_VALUE = 2;

	/**
	 * The '<em><b>Weight</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Weight</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WEIGHT
	 * @model name="weight"
	 * @generated
	 * @ordered
	 */
	public static final int WEIGHT_VALUE = 3;

	/**
	 * The '<em><b>Standard</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Standard</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STANDARD
	 * @model name="standard"
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD_VALUE = 4;

	/**
	 * The '<em><b>Cable Length</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cable Length</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CABLE_LENGTH
	 * @model name="cableLength"
	 * @generated
	 * @ordered
	 */
	public static final int CABLE_LENGTH_VALUE = 5;

	/**
	 * The '<em><b>Development Cost</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Development Cost</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DEVELOPMENT_COST
	 * @model name="developmentCost"
	 * @generated
	 * @ordered
	 */
	public static final int DEVELOPMENT_COST_VALUE = 6;

	/**
	 * The '<em><b>Function Allocation Different Nodes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Function Allocation Different Nodes</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FUNCTION_ALLOCATION_DIFFERENT_NODES
	 * @model name="functionAllocationDifferentNodes"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_ALLOCATION_DIFFERENT_NODES_VALUE = 7;

	/**
	 * The '<em><b>Function Allocation Same Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Function Allocation Same Node</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FUNCTION_ALLOCATION_SAME_NODE
	 * @model name="functionAllocationSameNode"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_ALLOCATION_SAME_NODE_VALUE = 8;

	/**
	 * The '<em><b>Power Supply Independent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Power Supply Independent</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #POWER_SUPPLY_INDEPENDENT
	 * @model name="powerSupplyIndependent"
	 * @generated
	 * @ordered
	 */
	public static final int POWER_SUPPLY_INDEPENDENT_VALUE = 9;

	/**
	 * An array of all the '<em><b>Generic Constraint Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final GenericConstraintKind[] VALUES_ARRAY = new GenericConstraintKind[]{ POWER_CONSUMPTION, OTHER, PIECE_COST, WEIGHT, STANDARD, CABLE_LENGTH, DEVELOPMENT_COST, FUNCTION_ALLOCATION_DIFFERENT_NODES, FUNCTION_ALLOCATION_SAME_NODE, POWER_SUPPLY_INDEPENDENT, };

	/**
	 * A public read-only list of all the '<em><b>Generic Constraint Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<GenericConstraintKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generic Constraint Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static GenericConstraintKind get(int value) {
		switch(value) {
		case POWER_CONSUMPTION_VALUE:
			return POWER_CONSUMPTION;
		case OTHER_VALUE:
			return OTHER;
		case PIECE_COST_VALUE:
			return PIECE_COST;
		case WEIGHT_VALUE:
			return WEIGHT;
		case STANDARD_VALUE:
			return STANDARD;
		case CABLE_LENGTH_VALUE:
			return CABLE_LENGTH;
		case DEVELOPMENT_COST_VALUE:
			return DEVELOPMENT_COST;
		case FUNCTION_ALLOCATION_DIFFERENT_NODES_VALUE:
			return FUNCTION_ALLOCATION_DIFFERENT_NODES;
		case FUNCTION_ALLOCATION_SAME_NODE_VALUE:
			return FUNCTION_ALLOCATION_SAME_NODE;
		case POWER_SUPPLY_INDEPENDENT_VALUE:
			return POWER_SUPPLY_INDEPENDENT;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generic Constraint Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static GenericConstraintKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenericConstraintKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generic Constraint Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static GenericConstraintKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenericConstraintKind result = VALUES_ARRAY[i];
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
	private GenericConstraintKind(int value, String name, String literal) {
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

} //GenericConstraintKind
