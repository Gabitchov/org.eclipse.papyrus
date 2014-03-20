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
package org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration ' <em><b>Deviation Permission Kind</b></em>', and utility methods for
 * working with them. <!--
 * end-user-doc --> <!-- begin-model-doc --> Possible values for deviation attributes.
 * 
 * Semantics: DeviationPermissionKind has no specific semantics. Further subclasses of
 * DeviationPermissionKind will add semantics appropriate to the concept they represent. <!--
 * end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getDeviationPermissionKind()
 * @model
 * @generated
 */
public enum DeviationPermissionKind implements Enumerator {
	/**
	 * The '<em><b>No</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NO_VALUE
	 * @generated
	 * @ordered
	 */
	NO(0, "no", "no"),

	/**
	 * The '<em><b>Subtree</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SUBTREE_VALUE
	 * @generated
	 * @ordered
	 */
	SUBTREE(1, "subtree", "subtree"),

	/**
	 * The '<em><b>Append</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #APPEND_VALUE
	 * @generated
	 * @ordered
	 */
	APPEND(2, "append", "append"),

	/**
	 * The '<em><b>Subset</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SUBSET_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSET(3, "subset", "subset"),

	/**
	 * The '<em><b>Yes</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #YES_VALUE
	 * @generated
	 * @ordered
	 */
	YES(4, "yes", "yes"), /**
	 * The '<em><b>Widen</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #WIDEN_VALUE
	 * @generated
	 * @ordered
	 */
	WIDEN(5, "widen", "widen");

	/**
	 * The '<em><b>NO</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NO</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation is not allowed. <!--
	 * end-model-doc -->
	 * 
	 * @see #NO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NO_VALUE = 0;

	/**
	 * The '<em><b>SUBTREE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBTREE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation permission holds for a complete
	 * subtree. <!-- end-model-doc -->
	 * 
	 * @see #SUBTREE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBTREE_VALUE = 1;

	/**
	 * The '<em><b>APPEND</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APPEND</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation is allowed if achieved by
	 * appending features <!-- end-model-doc -->
	 * 
	 * @see #APPEND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPEND_VALUE = 2;

	/**
	 * The '<em><b>SUBSET</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBSET</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation permission holds for a subset of
	 * features. <!-- end-model-doc -->
	 * 
	 * @see #SUBSET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSET_VALUE = 3;

	/**
	 * The '<em><b>YES</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>YES</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation permission holds. <!--
	 * end-model-doc -->
	 * 
	 * @see #YES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int YES_VALUE = 4;

	/**
	 * The '<em><b>Widen</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Feature groups may only be widened, i.e. it is only legal to add features into a feature group that were not grouped before, but not to ungroup
	 * features. This kind is only applicable to deviation attribute 'allowRegrouping'.
	 * <!-- end-model-doc -->
	 * 
	 * @see #WIDEN
	 * @model name="widen"
	 * @generated
	 * @ordered
	 */
	public static final int WIDEN_VALUE = 5;

	/**
	 * An array of all the '<em><b>Deviation Permission Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DeviationPermissionKind[] VALUES_ARRAY = new DeviationPermissionKind[]{ NO, SUBTREE, APPEND, SUBSET, YES, WIDEN, };

	/**
	 * A public read-only list of all the '<em><b>Deviation Permission Kind</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<DeviationPermissionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Deviation Permission Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DeviationPermissionKind get(int value) {
		switch(value) {
		case NO_VALUE:
			return NO;
		case SUBTREE_VALUE:
			return SUBTREE;
		case APPEND_VALUE:
			return APPEND;
		case SUBSET_VALUE:
			return SUBSET;
		case YES_VALUE:
			return YES;
		case WIDEN_VALUE:
			return WIDEN;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deviation Permission Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DeviationPermissionKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeviationPermissionKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deviation Permission Kind</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DeviationPermissionKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeviationPermissionKind result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private DeviationPermissionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // DeviationPermissionKind
