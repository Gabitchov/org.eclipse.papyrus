/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tool Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getToolKind()
 * @model
 * @generated
 */
public enum ToolKind implements Enumerator {
	/**
	 * The '<em><b>Creation Tool</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATION_TOOL_VALUE
	 * @generated
	 * @ordered
	 */
	CREATION_TOOL(0, "CreationTool", "CreationTool"),

	/**
	 * The '<em><b>Connection Tool</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONNECTION_TOOL_VALUE
	 * @generated
	 * @ordered
	 */
	CONNECTION_TOOL(1, "ConnectionTool", "ConnectionTool");

	/**
	 * The '<em><b>Creation Tool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Creation Tool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CREATION_TOOL
	 * @model name="CreationTool"
	 * @generated
	 * @ordered
	 */
	public static final int CREATION_TOOL_VALUE = 0;

	/**
	 * The '<em><b>Connection Tool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Connection Tool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONNECTION_TOOL
	 * @model name="ConnectionTool"
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_TOOL_VALUE = 1;

	/**
	 * An array of all the '<em><b>Tool Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ToolKind[] VALUES_ARRAY =
		new ToolKind[] {
			CREATION_TOOL,
			CONNECTION_TOOL,
		};

	/**
	 * A public read-only list of all the '<em><b>Tool Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ToolKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tool Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ToolKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ToolKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tool Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ToolKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ToolKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tool Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ToolKind get(int value) {
		switch (value) {
			case CREATION_TOOL_VALUE: return CREATION_TOOL;
			case CONNECTION_TOOL_VALUE: return CONNECTION_TOOL;
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
	private ToolKind(int value, String name, String literal) {
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
	
} //ToolKind
