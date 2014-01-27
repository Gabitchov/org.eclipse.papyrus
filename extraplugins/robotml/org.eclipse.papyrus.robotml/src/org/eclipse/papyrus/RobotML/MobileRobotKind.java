/**
 */
package org.eclipse.papyrus.RobotML;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mobile Robot Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getMobileRobotKind()
 * @model
 * @generated
 */
public enum MobileRobotKind implements Enumerator {
	/**
	 * The '<em><b>Air Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIR_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	AIR_VEHICLE(0, "AirVehicle", "AirVehicle"),

	/**
	 * The '<em><b>Hybrid Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYBRID_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	HYBRID_VEHICLE(1, "HybridVehicle", "HybridVehicle"),

	/**
	 * The '<em><b>Surface Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURFACE_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	SURFACE_VEHICLE(2, "SurfaceVehicle", "SurfaceVehicle"),

	/**
	 * The '<em><b>Underwater Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDERWATER_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	UNDERWATER_VEHICLE(3, "UnderwaterVehicle", "UnderwaterVehicle"),

	/**
	 * The '<em><b>Car Like Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAR_LIKE_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	CAR_LIKE_VEHICLE(4, "CarLikeVehicle", "CarLikeVehicle"),

	/**
	 * The '<em><b>Differential Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIFFERENTIAL_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	DIFFERENTIAL_VEHICLE(5, "DifferentialVehicle", "DifferentialVehicle"),

	/**
	 * The '<em><b>Legged Vehicle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEGGED_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	LEGGED_VEHICLE(6, "LeggedVehicle", "LeggedVehicle");

	/**
	 * The '<em><b>Air Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Air Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIR_VEHICLE
	 * @model name="AirVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int AIR_VEHICLE_VALUE = 0;

	/**
	 * The '<em><b>Hybrid Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hybrid Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYBRID_VEHICLE
	 * @model name="HybridVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int HYBRID_VEHICLE_VALUE = 1;

	/**
	 * The '<em><b>Surface Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Surface Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SURFACE_VEHICLE
	 * @model name="SurfaceVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int SURFACE_VEHICLE_VALUE = 2;

	/**
	 * The '<em><b>Underwater Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Underwater Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDERWATER_VEHICLE
	 * @model name="UnderwaterVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int UNDERWATER_VEHICLE_VALUE = 3;

	/**
	 * The '<em><b>Car Like Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Car Like Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAR_LIKE_VEHICLE
	 * @model name="CarLikeVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int CAR_LIKE_VEHICLE_VALUE = 4;

	/**
	 * The '<em><b>Differential Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Differential Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIFFERENTIAL_VEHICLE
	 * @model name="DifferentialVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int DIFFERENTIAL_VEHICLE_VALUE = 5;

	/**
	 * The '<em><b>Legged Vehicle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Legged Vehicle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEGGED_VEHICLE
	 * @model name="LeggedVehicle"
	 * @generated
	 * @ordered
	 */
	public static final int LEGGED_VEHICLE_VALUE = 6;

	/**
	 * An array of all the '<em><b>Mobile Robot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MobileRobotKind[] VALUES_ARRAY =
		new MobileRobotKind[] {
			AIR_VEHICLE,
			HYBRID_VEHICLE,
			SURFACE_VEHICLE,
			UNDERWATER_VEHICLE,
			CAR_LIKE_VEHICLE,
			DIFFERENTIAL_VEHICLE,
			LEGGED_VEHICLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Mobile Robot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MobileRobotKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mobile Robot Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MobileRobotKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MobileRobotKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mobile Robot Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MobileRobotKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MobileRobotKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mobile Robot Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MobileRobotKind get(int value) {
		switch (value) {
			case AIR_VEHICLE_VALUE: return AIR_VEHICLE;
			case HYBRID_VEHICLE_VALUE: return HYBRID_VEHICLE;
			case SURFACE_VEHICLE_VALUE: return SURFACE_VEHICLE;
			case UNDERWATER_VEHICLE_VALUE: return UNDERWATER_VEHICLE;
			case CAR_LIKE_VEHICLE_VALUE: return CAR_LIKE_VEHICLE;
			case DIFFERENTIAL_VEHICLE_VALUE: return DIFFERENTIAL_VEHICLE;
			case LEGGED_VEHICLE_VALUE: return LEGGED_VEHICLE;
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
	private MobileRobotKind(int value, String name, String literal) {
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
	
} //MobileRobotKind
