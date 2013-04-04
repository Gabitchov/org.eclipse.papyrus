/**
 */
package C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Friend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link C_Cpp.Friend#getBase_dependency <em>Base dependency</em>}</li>
 *   <li>{@link C_Cpp.Friend#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see C_Cpp.C_CppPackage#getFriend()
 * @model
 * @generated
 */
public interface Friend extends EObject {
	/**
	 * Returns the value of the '<em><b>Base dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base dependency</em>' reference.
	 * @see #setBase_dependency(Dependency)
	 * @see C_Cpp.C_CppPackage#getFriend_Base_dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_dependency();

	/**
	 * Sets the value of the '{@link C_Cpp.Friend#getBase_dependency <em>Base dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base dependency</em>' reference.
	 * @see #getBase_dependency()
	 * @generated
	 */
	void setBase_dependency(Dependency value);

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
	 * @see C_Cpp.C_CppPackage#getFriend_Base_operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_operation();

	/**
	 * Sets the value of the '{@link C_Cpp.Friend#getBase_operation <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base operation</em>' reference.
	 * @see #getBase_operation()
	 * @generated
	 */
	void setBase_operation(Operation value);

} // Friend
