/**
 */
package org.eclipse.papyrus.RobotML;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Robot Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobotKind()
 * @model
 * @generated
 */
public enum RobotKind implements Enumerator {
	/**
	 * The '<em><b>UUV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UUV_VALUE
	 * @generated
	 * @ordered
	 */
	UUV(0, "UUV", "UUV"),

	/**
	 * The '<em><b>UG Vcar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UG_VCAR_VALUE
	 * @generated
	 * @ordered
	 */
	UG_VCAR(1, "UGVcar", "UGVcar"),

	/**
	 * The '<em><b>UG Vdifferential</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UG_VDIFFERENTIAL_VALUE
	 * @generated
	 * @ordered
	 */
	UG_VDIFFERENTIAL(2, "UGVdifferential", "UGVdifferential"),

	/**
	 * The '<em><b>UAV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UAV_VALUE
	 * @generated
	 * @ordered
	 */
	UAV(3, "UAV", "UAV"),

	/**
	 * The '<em><b>USV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USV_VALUE
	 * @generated
	 * @ordered
	 */
	USV(4, "USV", "USV"),

	/**
	 * The '<em><b>Piloted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PILOTED_VALUE
	 * @generated
	 * @ordered
	 */
	PILOTED(5, "piloted", "piloted");

	/**
	 * The '<em><b>UUV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UUV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UUV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UUV_VALUE = 0;

	/**
	 * The '<em><b>UG Vcar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UG Vcar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UG_VCAR
	 * @model name="UGVcar"
	 * @generated
	 * @ordered
	 */
	public static final int UG_VCAR_VALUE = 1;

	/**
	 * The '<em><b>UG Vdifferential</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UG Vdifferential</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UG_VDIFFERENTIAL
	 * @model name="UGVdifferential"
	 * @generated
	 * @ordered
	 */
	public static final int UG_VDIFFERENTIAL_VALUE = 2;

	/**
	 * The '<em><b>UAV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UAV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UAV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UAV_VALUE = 3;

	/**
	 * The '<em><b>USV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USV_VALUE = 4;

	/**
	 * The '<em><b>Piloted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Piloted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PILOTED
	 * @model name="piloted"
	 * @generated
	 * @ordered
	 */
	public static final int PILOTED_VALUE = 5;

	/**
	 * An array of all the '<em><b>Robot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RobotKind[] VALUES_ARRAY =
		new RobotKind[] {
			UUV,
			UG_VCAR,
			UG_VDIFFERENTIAL,
			UAV,
			USV,
			PILOTED,
		};

	/**
	 * A public read-only list of all the '<em><b>Robot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RobotKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Robot Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RobotKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RobotKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Robot Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RobotKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RobotKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Robot Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RobotKind get(int value) {
		switch (value) {
			case UUV_VALUE: return UUV;
			case UG_VCAR_VALUE: return UG_VCAR;
			case UG_VDIFFERENTIAL_VALUE: return UG_VDIFFERENTIAL;
			case UAV_VALUE: return UAV;
			case USV_VALUE: return USV;
			case PILOTED_VALUE: return PILOTED;
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
	private RobotKind(int value, String name, String literal) {
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
	
} //RobotKind
