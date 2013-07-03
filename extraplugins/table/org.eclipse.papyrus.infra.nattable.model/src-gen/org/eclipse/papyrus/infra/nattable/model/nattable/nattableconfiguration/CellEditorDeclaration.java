/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cell Editor Declaration</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Indicates how the CellEditor must be declared.
 * In the common table, we display features as columns and objects as line.
 * In this case the cell editors are specific to features, so the cell editor must be declared on the columns.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getCellEditorDeclaration()
 * @model
 * @generated
 */
public enum CellEditorDeclaration implements Enumerator {
	/**
	 * The '<em><b>COLUMN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	COLUMN(0, "COLUMN", "COLUMN"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ROW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW_VALUE
	 * @generated
	 * @ordered
	 */
	ROW(1, "ROW", "ROW"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CELL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #CELL_VALUE
	 * @generated
	 * @ordered
	 */
	CELL(2, "CELL", "CELL"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>COLUMN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLUMN</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COLUMN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLUMN_VALUE = 0;

	/**
	 * The '<em><b>ROW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROW</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROW_VALUE = 1;

	/**
	 * The '<em><b>CELL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CELL</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CELL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CELL_VALUE = 2;

	/**
	 * An array of all the '<em><b>Cell Editor Declaration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final CellEditorDeclaration[] VALUES_ARRAY = new CellEditorDeclaration[]{ COLUMN, ROW, CELL, };

	/**
	 * A public read-only list of all the '<em><b>Cell Editor Declaration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<CellEditorDeclaration> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Cell Editor Declaration</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CellEditorDeclaration get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			CellEditorDeclaration result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cell Editor Declaration</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CellEditorDeclaration getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			CellEditorDeclaration result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cell Editor Declaration</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CellEditorDeclaration get(int value) {
		switch(value) {
		case COLUMN_VALUE:
			return COLUMN;
		case ROW_VALUE:
			return ROW;
		case CELL_VALUE:
			return CELL;
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
	private CellEditorDeclaration(int value, String name, String literal) {
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
	public int getValue() {
		return value;
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
	public String getLiteral() {
		return literal;
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

} //CellEditorDeclaration
