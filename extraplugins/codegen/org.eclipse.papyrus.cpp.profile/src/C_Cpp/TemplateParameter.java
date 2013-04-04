/**
 */
package C_Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link C_Cpp.TemplateParameter#getName <em>Name</em>}</li>
 *   <li>{@link C_Cpp.TemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see C_Cpp.C_CppPackage#getTemplateParameter()
 * @model
 * @generated
 */
public interface TemplateParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see C_Cpp.C_CppPackage#getTemplateParameter_Name()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link C_Cpp.TemplateParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Base templateparameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base templateparameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base templateparameter</em>' reference.
	 * @see #setBase_templateparameter(org.eclipse.uml2.uml.TemplateParameter)
	 * @see C_Cpp.C_CppPackage#getTemplateParameter_Base_templateparameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.TemplateParameter getBase_templateparameter();

	/**
	 * Sets the value of the '{@link C_Cpp.TemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base templateparameter</em>' reference.
	 * @see #getBase_templateparameter()
	 * @generated
	 */
	void setBase_templateparameter(org.eclipse.uml2.uml.TemplateParameter value);

} // TemplateParameter
