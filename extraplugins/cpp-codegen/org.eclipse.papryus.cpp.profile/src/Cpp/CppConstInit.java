/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Const Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppConstInit#getInitialisation <em>Initialisation</em>}</li>
 *   <li>{@link Cpp.CppConstInit#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppConstInit()
 * @model
 * @generated
 */
public interface CppConstInit extends EObject {
	/**
	 * Returns the value of the '<em><b>Initialisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialisation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialisation</em>' attribute.
	 * @see #setInitialisation(String)
	 * @see Cpp.CppPackage#getCppConstInit_Initialisation()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getInitialisation();

	/**
	 * Sets the value of the '{@link Cpp.CppConstInit#getInitialisation <em>Initialisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialisation</em>' attribute.
	 * @see #getInitialisation()
	 * @generated
	 */
	void setInitialisation(String value);

	/**
	 * Returns the value of the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base operation</em>' reference.
	 * @see #setBase_operation(Operation)
	 * @see Cpp.CppPackage#getCppConstInit_Base_operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_operation();

	/**
	 * Sets the value of the '{@link Cpp.CppConstInit#getBase_operation <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base operation</em>' reference.
	 * @see #getBase_operation()
	 * @generated
	 */
	void setBase_operation(Operation value);

} // CppConstInit
