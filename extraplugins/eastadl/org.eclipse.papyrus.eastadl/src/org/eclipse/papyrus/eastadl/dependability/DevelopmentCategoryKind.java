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
package org.eclipse.papyrus.eastadl.dependability;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Development Category Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * DevelopmentCategoryKind in an enumeration with enumeration literals indicating whether the item is a modification of an existing item or if it is a new development.
 * 
 * Semantics:
 * The semantics is defined at each enumeration literal and fully defined in the ISO26262 standard.
 * 
 * Extension: 
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDevelopmentCategoryKind()
 * @model
 * @generated
 */
public enum DevelopmentCategoryKind implements Enumerator {
	/**
	 * The '<em><b>Modification Of Existing Item</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFICATION_OF_EXISTING_ITEM_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFICATION_OF_EXISTING_ITEM(0, "modificationOfExistingItem", "modificationOfExistingItem"),

	/**
	 * The '<em><b>New Item Development</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_ITEM_DEVELOPMENT_VALUE
	 * @generated
	 * @ordered
	 */
	NEW_ITEM_DEVELOPMENT(1, "newItemDevelopment", "newItemDevelopment");

	/**
	 * The '<em><b>Modification Of Existing Item</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of a modification the relevant lifecycle sub-phases and activities shall be determined.
	 * <!-- end-model-doc -->
	 * @see #MODIFICATION_OF_EXISTING_ITEM
	 * @model name="modificationOfExistingItem"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFICATION_OF_EXISTING_ITEM_VALUE = 0;

	/**
	 * The '<em><b>New Item Development</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of a new development, the entire lifecycle shall be passed through.
	 * <!-- end-model-doc -->
	 * @see #NEW_ITEM_DEVELOPMENT
	 * @model name="newItemDevelopment"
	 * @generated
	 * @ordered
	 */
	public static final int NEW_ITEM_DEVELOPMENT_VALUE = 1;

	/**
	 * An array of all the '<em><b>Development Category Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DevelopmentCategoryKind[] VALUES_ARRAY =
		new DevelopmentCategoryKind[] {
			MODIFICATION_OF_EXISTING_ITEM,
			NEW_ITEM_DEVELOPMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Development Category Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DevelopmentCategoryKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Development Category Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DevelopmentCategoryKind get(int value) {
		switch (value) {
			case MODIFICATION_OF_EXISTING_ITEM_VALUE: return MODIFICATION_OF_EXISTING_ITEM;
			case NEW_ITEM_DEVELOPMENT_VALUE: return NEW_ITEM_DEVELOPMENT;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Development Category Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DevelopmentCategoryKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DevelopmentCategoryKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Development Category Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DevelopmentCategoryKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DevelopmentCategoryKind result = VALUES_ARRAY[i];
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
	private DevelopmentCategoryKind(int value, String name, String literal) {
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
	
} //DevelopmentCategoryKind
