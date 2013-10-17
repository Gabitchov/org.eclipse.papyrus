/**
 */
package org.eclipse.papyrus.RobotML;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Robotic Middleware Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticMiddlewareKind()
 * @model
 * @generated
 */
public enum RoboticMiddlewareKind implements Enumerator {
	/**
	 * The '<em><b>RT Maps</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RT_MAPS_VALUE
	 * @generated
	 * @ordered
	 */
	RT_MAPS(0, "RTMaps", "RTMaps"),

	/**
	 * The '<em><b>AROCAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AROCAM_VALUE
	 * @generated
	 * @ordered
	 */
	AROCAM(1, "AROCAM", "AROCAM"),

	/**
	 * The '<em><b>ROS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROS_VALUE
	 * @generated
	 * @ordered
	 */
	ROS(2, "ROS", "ROS"),

	/**
	 * The '<em><b>OROCOS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OROCOS_VALUE
	 * @generated
	 * @ordered
	 */
	OROCOS(3, "OROCOS", "OROCOS"),

	/**
	 * The '<em><b>URBI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URBI_VALUE
	 * @generated
	 * @ordered
	 */
	URBI(4, "URBI", "URBI");

	/**
	 * The '<em><b>RT Maps</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RT Maps</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RT_MAPS
	 * @model name="RTMaps"
	 * @generated
	 * @ordered
	 */
	public static final int RT_MAPS_VALUE = 0;

	/**
	 * The '<em><b>AROCAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AROCAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AROCAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AROCAM_VALUE = 1;

	/**
	 * The '<em><b>ROS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROS_VALUE = 2;

	/**
	 * The '<em><b>OROCOS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OROCOS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OROCOS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OROCOS_VALUE = 3;

	/**
	 * The '<em><b>URBI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>URBI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #URBI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int URBI_VALUE = 4;

	/**
	 * An array of all the '<em><b>Robotic Middleware Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RoboticMiddlewareKind[] VALUES_ARRAY =
		new RoboticMiddlewareKind[] {
			RT_MAPS,
			AROCAM,
			ROS,
			OROCOS,
			URBI,
		};

	/**
	 * A public read-only list of all the '<em><b>Robotic Middleware Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RoboticMiddlewareKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Robotic Middleware Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RoboticMiddlewareKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoboticMiddlewareKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Robotic Middleware Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RoboticMiddlewareKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoboticMiddlewareKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Robotic Middleware Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RoboticMiddlewareKind get(int value) {
		switch (value) {
			case RT_MAPS_VALUE: return RT_MAPS;
			case AROCAM_VALUE: return AROCAM;
			case ROS_VALUE: return ROS;
			case OROCOS_VALUE: return OROCOS;
			case URBI_VALUE: return URBI;
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
	private RoboticMiddlewareKind(int value, String name, String literal) {
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
	
} //RoboticMiddlewareKind
