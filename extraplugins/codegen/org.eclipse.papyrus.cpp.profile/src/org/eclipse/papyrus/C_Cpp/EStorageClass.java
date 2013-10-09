/**
 */
package org.eclipse.papyrus.C_Cpp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EStorage Class</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getEStorageClass()
 * @model
 * @generated
 */
public enum EStorageClass implements Enumerator {
	/**
	 * The '<em><b>Volatile</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLATILE_VALUE
	 * @generated
	 * @ordered
	 */
	VOLATILE(0, "volatile", "volatile"), /**
	 * The '<em><b>Register</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTER_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTER(1, "register", "register"),

	/**
	 * The '<em><b>Extern</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERN_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERN(2, "extern", "extern");

	/**
	 * The '<em><b>Volatile</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Volatile</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLATILE
	 * @model name="volatile"
	 * @generated
	 * @ordered
	 */
	public static final int VOLATILE_VALUE = 0;

	/**
	 * The '<em><b>Register</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Register</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGISTER
	 * @model name="register"
	 * @generated
	 * @ordered
	 */
	public static final int REGISTER_VALUE = 1;

	/**
	 * The '<em><b>Extern</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Extern</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTERN
	 * @model name="extern"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERN_VALUE = 2;

	/**
	 * An array of all the '<em><b>EStorage Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EStorageClass[] VALUES_ARRAY =
		new EStorageClass[] {
			VOLATILE,
			REGISTER,
			EXTERN,
		};

	/**
	 * A public read-only list of all the '<em><b>EStorage Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EStorageClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EStorageClass get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EStorageClass result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EStorageClass getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EStorageClass result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EStorageClass get(int value) {
		switch (value) {
			case VOLATILE_VALUE: return VOLATILE;
			case REGISTER_VALUE: return REGISTER;
			case EXTERN_VALUE: return EXTERN;
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
	private EStorageClass(int value, String name, String literal) {
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
	
} //EStorageClass
