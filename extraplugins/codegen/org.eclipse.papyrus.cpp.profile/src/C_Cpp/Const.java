/**
 */
package C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Const</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link C_Cpp.Const#getBase_parameter <em>Base parameter</em>}</li>
 *   <li>{@link C_Cpp.Const#getBase_property <em>Base property</em>}</li>
 *   <li>{@link C_Cpp.Const#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see C_Cpp.C_CppPackage#getConst()
 * @model
 * @generated
 */
public interface Const extends EObject {
	/**
	 * Returns the value of the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base parameter</em>' reference.
	 * @see #setBase_parameter(Parameter)
	 * @see C_Cpp.C_CppPackage#getConst_Base_parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getBase_parameter();

	/**
	 * Sets the value of the '{@link C_Cpp.Const#getBase_parameter <em>Base parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base parameter</em>' reference.
	 * @see #getBase_parameter()
	 * @generated
	 */
	void setBase_parameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base property</em>' reference.
	 * @see #setBase_property(Property)
	 * @see C_Cpp.C_CppPackage#getConst_Base_property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_property();

	/**
	 * Sets the value of the '{@link C_Cpp.Const#getBase_property <em>Base property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base property</em>' reference.
	 * @see #getBase_property()
	 * @generated
	 */
	void setBase_property(Property value);

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
	 * @see C_Cpp.C_CppPackage#getConst_Base_operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_operation();

	/**
	 * Sets the value of the '{@link C_Cpp.Const#getBase_operation <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base operation</em>' reference.
	 * @see #getBase_operation()
	 * @generated
	 */
	void setBase_operation(Operation value);

} // Const
