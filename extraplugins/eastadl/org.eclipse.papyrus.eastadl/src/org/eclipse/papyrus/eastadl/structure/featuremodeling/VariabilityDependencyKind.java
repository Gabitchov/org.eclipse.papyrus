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
package org.eclipse.papyrus.eastadl.structure.featuremodeling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variability Dependency Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This enumeration encapsulates the available types of constraints that can be applied to a FeatureLink or VariationGroup (the latter is applicable only if the variability extension is used).
 * 
 * Semantics:
 * Predefined kinds of constraints that can be associated to a FeatureLink or VariationGroup.
 * 
 * Extension: 
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getVariabilityDependencyKind()
 * @model
 * @generated
 */
public enum VariabilityDependencyKind implements Enumerator {
	/**
	 * The '<em><b>Needs</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEEDS_VALUE
	 * @generated
	 * @ordered
	 */
	NEEDS(0, "needs", "needs"),

	/**
	 * The '<em><b>Optional Alternative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL_ALTERNATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	OPTIONAL_ALTERNATIVE(1, "optionalAlternative", "optionalAlternative"),

	/**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOM(2, "custom", "custom"),

	/**
	 * The '<em><b>Mandatory Alternative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY_ALTERNATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	MANDATORY_ALTERNATIVE(3, "mandatoryAlternative", "mandatoryAlternative"),

	/**
	 * The '<em><b>Suggests</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUGGESTS_VALUE
	 * @generated
	 * @ordered
	 */
	SUGGESTS(4, "suggests", "suggests"),

	/**
	 * The '<em><b>Impedes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPEDES_VALUE
	 * @generated
	 * @ordered
	 */
	IMPEDES(5, "impedes", "impedes");

	/**
	 * The '<em><b>Needs</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When used in a FeatureLink: if the FeatureLink's start feature S is selected, then also its end feature E must be selected: not (S and not E). Always unidirectional.
	 * 
	 * When used in a VariationGroup: assuming the ordered association variableElement in meta-class VariationGroup refers to elements VE1, VE2, ..., VEn, this kind states that VE1 requires (i.e. may not appear without) all other elements VE2, VE3, ..., VEn.
	 * <!-- end-model-doc -->
	 * @see #NEEDS
	 * @model name="needs"
	 * @generated
	 * @ordered
	 */
	public static final int NEEDS_VALUE = 0;

	/**
	 * The '<em><b>Optional Alternative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When used in a FeatureLink: the FeatureLink's start feature S and end feature E are incompatible and must never be both selected in a single configuration: not (S and E). Always bidirectional.
	 * 
	 * When used in a VariationGroup: this kind states that at most(!) one element of the elements denoted by association variableElement of the VariationGroup must be selected in any valid final system configuration.
	 * <!-- end-model-doc -->
	 * @see #OPTIONAL_ALTERNATIVE
	 * @model name="optionalAlternative"
	 * @generated
	 * @ordered
	 */
	public static final int OPTIONAL_ALTERNATIVE_VALUE = 1;

	/**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When used in a FeatureLink: the attribute customType in the FeatureLink defines the custom feature link type as explained there.
	 * 
	 * When used in a VariationGroup: this kind states that the dependency between the elements denoted by association variableElement of the VariationGroup will be defined by a logical expression in attribute 'constraint' of the VariationGroup.
	 * <!-- end-model-doc -->
	 * @see #CUSTOM
	 * @model name="custom"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM_VALUE = 2;

	/**
	 * The '<em><b>Mandatory Alternative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When used in a FeatureLink: either the FeatureLink's start feature S or its end feature E must be selected in any configuration: S xor E. Always bidirectional.
	 * 
	 * When used in a VariationGroup: this kind states that exactly(!) one element of the elements denoted by association variableElement of the VariationGroup must be selected in any valid final system configuration.
	 * <!-- end-model-doc -->
	 * @see #MANDATORY_ALTERNATIVE
	 * @model name="mandatoryAlternative"
	 * @generated
	 * @ordered
	 */
	public static final int MANDATORY_ALTERNATIVE_VALUE = 3;

	/**
	 * The '<em><b>Suggests</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Weak form of "needs". 
	 * 
	 * When used in a FeatureLink: if the FeatureLink's start feature S is selected, then usually(!) also its end feature E must be selected. You can select S without E but you should have a good reason to do so. Always unidirectional.
	 * 
	 * When used in a VariationGroup: accordingly as above.
	 * <!-- end-model-doc -->
	 * @see #SUGGESTS
	 * @model name="suggests"
	 * @generated
	 * @ordered
	 */
	public static final int SUGGESTS_VALUE = 4;

	/**
	 * The '<em><b>Impedes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Weak from of "excludes".
	 * 
	 * When used in a FeatureLink: the FeatureLink's start feature S and its end feature E must usually(!) not be selected in a single configuration. You can select S together with E but you should have a good reason to do so. Always bidirectional.
	 * 
	 * When used in a VariationGroup: accordingly as above.
	 * <!-- end-model-doc -->
	 * @see #IMPEDES
	 * @model name="impedes"
	 * @generated
	 * @ordered
	 */
	public static final int IMPEDES_VALUE = 5;

	/**
	 * An array of all the '<em><b>Variability Dependency Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariabilityDependencyKind[] VALUES_ARRAY =
		new VariabilityDependencyKind[] {
			NEEDS,
			OPTIONAL_ALTERNATIVE,
			CUSTOM,
			MANDATORY_ALTERNATIVE,
			SUGGESTS,
			IMPEDES,
		};

	/**
	 * A public read-only list of all the '<em><b>Variability Dependency Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariabilityDependencyKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variability Dependency Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariabilityDependencyKind get(int value) {
		switch (value) {
			case NEEDS_VALUE: return NEEDS;
			case OPTIONAL_ALTERNATIVE_VALUE: return OPTIONAL_ALTERNATIVE;
			case CUSTOM_VALUE: return CUSTOM;
			case MANDATORY_ALTERNATIVE_VALUE: return MANDATORY_ALTERNATIVE;
			case SUGGESTS_VALUE: return SUGGESTS;
			case IMPEDES_VALUE: return IMPEDES;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variability Dependency Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariabilityDependencyKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariabilityDependencyKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variability Dependency Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariabilityDependencyKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariabilityDependencyKind result = VALUES_ARRAY[i];
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
	private VariabilityDependencyKind(int value, String name, String literal) {
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
	
} //VariabilityDependencyKind
