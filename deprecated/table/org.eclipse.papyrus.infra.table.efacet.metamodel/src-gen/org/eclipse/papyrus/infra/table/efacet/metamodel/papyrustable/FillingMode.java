/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Filling Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * @deprecated : You shoudl use the enumeration provided by PapyrusTableConfiguration
 * This enumeration provides literals representing the ways to fill the table.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getFillingMode()
 * @model
 * @generated
 * 
 */
public enum FillingMode implements Enumerator {
	/**
	 * The '<em><b>User</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_VALUE
	 * @generated
	 * @ordered
	 */
	USER(0, "User", "USER"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Queries</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUERIES_VALUE
	 * @generated
	 * @ordered
	 */
	QUERIES(1, "Queries", "QUERIES"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Context Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTEXT_FEATURE(2, "ContextFeature", "CONTEXT_FEATURE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>User</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This user drops the elements to fill the table.
	 * <!-- end-model-doc -->
	 * @see #USER
	 * @model name="User" literal="USER"
	 * @generated
	 * @ordered
	 */
	public static final int USER_VALUE = 0;

	/**
	 * The '<em><b>Queries</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * We use queries to fill the table.
	 * <!-- end-model-doc -->
	 * @see #QUERIES
	 * @model name="Queries" literal="QUERIES"
	 * @generated
	 * @ordered
	 */
	public static final int QUERIES_VALUE = 1;

	/**
	 * The '<em><b>Context Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * We listen a feature of the context of the table to fill it.
	 * <!-- end-model-doc -->
	 * @see #CONTEXT_FEATURE
	 * @model name="ContextFeature" literal="CONTEXT_FEATURE"
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_FEATURE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Filling Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FillingMode[] VALUES_ARRAY =
		new FillingMode[] {
			USER,
			QUERIES,
			CONTEXT_FEATURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Filling Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FillingMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Filling Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FillingMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FillingMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Filling Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FillingMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FillingMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Filling Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FillingMode get(int value) {
		switch (value) {
			case USER_VALUE: return USER;
			case QUERIES_VALUE: return QUERIES;
			case CONTEXT_FEATURE_VALUE: return CONTEXT_FEATURE;
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
	private FillingMode(int value, String name, String literal) {
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
	
} //FillingMode
