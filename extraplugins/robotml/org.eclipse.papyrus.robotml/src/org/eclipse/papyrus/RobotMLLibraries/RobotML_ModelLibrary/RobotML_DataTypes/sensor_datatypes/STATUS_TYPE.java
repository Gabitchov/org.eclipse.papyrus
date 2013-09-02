/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>STATUS TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage#getSTATUS_TYPE()
 * @model
 * @generated
 */
public enum STATUS_TYPE implements Enumerator {
	/**
	 * The '<em><b>STATUS NO FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_NO_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_NO_FIX(0, "STATUS_NO_FIX", "STATUS_NO_FIX"),

	/**
	 * The '<em><b>STATUS FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_FIX(1, "STATUS_FIX", "STATUS_FIX"),

	/**
	 * The '<em><b>STATUS SBAS FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_SBAS_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_SBAS_FIX(2, "STATUS_SBAS_FIX", "STATUS_SBAS_FIX"),

	/**
	 * The '<em><b>STATUS GBAS FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_GBAS_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_GBAS_FIX(3, "STATUS_GBAS_FIX", "STATUS_GBAS_FIX");

	/**
	 * The '<em><b>STATUS NO FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATUS NO FIX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS_NO_FIX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_NO_FIX_VALUE = 0;

	/**
	 * The '<em><b>STATUS FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATUS FIX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS_FIX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_FIX_VALUE = 1;

	/**
	 * The '<em><b>STATUS SBAS FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATUS SBAS FIX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS_SBAS_FIX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_SBAS_FIX_VALUE = 2;

	/**
	 * The '<em><b>STATUS GBAS FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATUS GBAS FIX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS_GBAS_FIX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_GBAS_FIX_VALUE = 3;

	/**
	 * An array of all the '<em><b>STATUS TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final STATUS_TYPE[] VALUES_ARRAY =
		new STATUS_TYPE[] {
			STATUS_NO_FIX,
			STATUS_FIX,
			STATUS_SBAS_FIX,
			STATUS_GBAS_FIX,
		};

	/**
	 * A public read-only list of all the '<em><b>STATUS TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<STATUS_TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>STATUS TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATUS_TYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATUS_TYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STATUS TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATUS_TYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATUS_TYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STATUS TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STATUS_TYPE get(int value) {
		switch (value) {
			case STATUS_NO_FIX_VALUE: return STATUS_NO_FIX;
			case STATUS_FIX_VALUE: return STATUS_FIX;
			case STATUS_SBAS_FIX_VALUE: return STATUS_SBAS_FIX;
			case STATUS_GBAS_FIX_VALUE: return STATUS_GBAS_FIX;
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
	private STATUS_TYPE(int value, String name, String literal) {
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
	
} //STATUS_TYPE
