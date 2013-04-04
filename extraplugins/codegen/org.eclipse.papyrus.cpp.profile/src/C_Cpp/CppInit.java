/**
 */
package C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cpp Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link C_Cpp.CppInit#getValue <em>Value</em>}</li>
 *   <li>{@link C_Cpp.CppInit#getBase_enumerationliteral <em>Base enumerationliteral</em>}</li>
 * </ul>
 * </p>
 *
 * @see C_Cpp.C_CppPackage#getCppInit()
 * @model
 * @generated
 */
public interface CppInit extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see C_Cpp.C_CppPackage#getCppInit_Value()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link C_Cpp.CppInit#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Base enumerationliteral</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base enumerationliteral</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base enumerationliteral</em>' reference.
	 * @see #setBase_enumerationliteral(EnumerationLiteral)
	 * @see C_Cpp.C_CppPackage#getCppInit_Base_enumerationliteral()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumerationLiteral getBase_enumerationliteral();

	/**
	 * Sets the value of the '{@link C_Cpp.CppInit#getBase_enumerationliteral <em>Base enumerationliteral</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base enumerationliteral</em>' reference.
	 * @see #getBase_enumerationliteral()
	 * @generated
	 */
	void setBase_enumerationliteral(EnumerationLiteral value);

} // CppInit
