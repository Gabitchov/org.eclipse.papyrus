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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Binding Time Kind</b></em>', and utility methods for working with them. <!-- end-user-doc
 * --> <!-- begin-model-doc --> The binding time kind gives the set of possible binding times.
 * 
 * Semantics: BindingTimeKind has no specific semantics. Further subclasses of BindingTimeKind will
 * add semantics appropriate to the concept they represent. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getBindingTimeKind()
 * @model
 * @generated
 */
public enum BindingTimeKind implements Enumerator {
	/**
	 * The '<em><b>System Design Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_DESIGN_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_DESIGN_TIME(0, "systemDesignTime", "systemDesignTime"), /**
	 * The '<em><b>Code Generation Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CODE_GENERATION_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	CODE_GENERATION_TIME(1, "codeGenerationTime", "codeGenerationTime"), /**
	 * The '<em><b>Precompile Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRECOMPILE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	PRECOMPILE_TIME(2, "precompileTime", "precompileTime"), /**
	 * The '<em><b>Link Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINK_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	LINK_TIME(3, "linkTime", "linkTime"), /**
	 * The '<em><b>Post Build</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_BUILD_VALUE
	 * @generated
	 * @ordered
	 */
	POST_BUILD(4, "postBuild", "postBuild"), /**
	 * The '<em><b>Runtime</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNTIME_VALUE
	 * @generated
	 * @ordered
	 */
	RUNTIME(5, "runtime", "runtime");

	/**
	 * The '<em><b>System Design Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound during development of the EE-System.
	 * 
	 * From AUTOSAR:
	 * * Designing the VFB.
	 * * Software Component types (portinterfaces).
	 * * SWC Prototypes and the Connections between SWCprototypes.
	 * * Designing the Topology
	 * * ECUs and interconnecting Networks
	 * * Designing the Communication Matrix and Data Mapping
	 * <!-- end-model-doc -->
	 * @see #SYSTEM_DESIGN_TIME
	 * @model name="systemDesignTime"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_DESIGN_TIME_VALUE = 0;

	/**
	 * The '<em><b>Code Generation Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound during code generation.
	 * 
	 * From AUTOSAR:
	 * * Coding by hand, based on requirements document.
	 * * Tool based code generation, e.g. from a model.
	 * * The model may contain variants.
	 * * Only code for the selected variant(s) is actually generated.
	 * <!-- end-model-doc -->
	 * @see #CODE_GENERATION_TIME
	 * @model name="codeGenerationTime"
	 * @generated
	 * @ordered
	 */
	public static final int CODE_GENERATION_TIME_VALUE = 1;

	/**
	 * The '<em><b>Precompile Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound during or immediately prior to code compilation.
	 * 
	 * From AUTOSAR:
	 * This is typically the C-Preprocessor. Exclude parts of the code from the compilation process, e.g., because they are not required for the selected variant, because they are incompatible with the selected variant, because they require resources that are not present in the selected variant. Object code is only generated for the selected variant(s). The code that is excluded at this stage code will not be available at later stages.
	 * <!-- end-model-doc -->
	 * @see #PRECOMPILE_TIME
	 * @model name="precompileTime"
	 * @generated
	 * @ordered
	 */
	public static final int PRECOMPILE_TIME_VALUE = 2;

	/**
	 * The '<em><b>Link Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound during linking.
	 * 
	 * From AUTOSAR:
	 * Configure what is included in object code, and what is omitted
	 * Based on which variant(s) are selected
	 * E.g. for modules that are delivered as object code (as opposed to those that are delivered as source code)
	 * <!-- end-model-doc -->
	 * @see #LINK_TIME
	 * @model name="linkTime"
	 * @generated
	 * @ordered
	 */
	public static final int LINK_TIME_VALUE = 3;

	/**
	 * The '<em><b>Post Build</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound at certain occasions after shipment, for example when the vehicle is in a workshop.
	 * <!-- end-model-doc -->
	 * @see #POST_BUILD
	 * @model name="postBuild"
	 * @generated
	 * @ordered
	 */
	public static final int POST_BUILD_VALUE = 4;

	/**
	 * The '<em><b>Runtime</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Variability will be bound by the customer after shipment by way of vehicle configuration.
	 * 
	 * Variability with such a late binding time can also be seen as a special functionality of the system which is not documented as variability at all. However, it is sometimes advantageous to represent such cases as variability in order to be able to seamlessly include them in the overall variability management activities.
	 * <!-- end-model-doc -->
	 * @see #RUNTIME
	 * @model name="runtime"
	 * @generated
	 * @ordered
	 */
	public static final int RUNTIME_VALUE = 5;

	/**
	 * An array of all the '<em><b>Binding Time Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BindingTimeKind[] VALUES_ARRAY = new BindingTimeKind[] {
			SYSTEM_DESIGN_TIME,
			CODE_GENERATION_TIME,
			PRECOMPILE_TIME,
			LINK_TIME,
			POST_BUILD,
			RUNTIME,
		};

	/**
	 * A public read-only list of all the '<em><b>Binding Time Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<BindingTimeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Binding Time Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static BindingTimeKind get(int value) {
		switch (value) {
			case SYSTEM_DESIGN_TIME_VALUE: return SYSTEM_DESIGN_TIME;
			case CODE_GENERATION_TIME_VALUE: return CODE_GENERATION_TIME;
			case PRECOMPILE_TIME_VALUE: return PRECOMPILE_TIME;
			case LINK_TIME_VALUE: return LINK_TIME;
			case POST_BUILD_VALUE: return POST_BUILD;
			case RUNTIME_VALUE: return RUNTIME;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding Time Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static BindingTimeKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BindingTimeKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding Time Kind</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BindingTimeKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BindingTimeKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private BindingTimeKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} // BindingTimeKind
