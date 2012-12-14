/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TemplateParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppTemplateParameter#getName <em>Name</em>}</li>
 *   <li>{@link Cpp.CppTemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppTemplateParameter()
 * @model
 * @generated
 */
public interface CppTemplateParameter extends EObject {
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
	 * @see Cpp.CppPackage#getCppTemplateParameter_Name()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplateParameter#getName <em>Name</em>}' attribute.
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
	 * @see #setBase_templateparameter(TemplateParameter)
	 * @see Cpp.CppPackage#getCppTemplateParameter_Base_templateparameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateParameter getBase_templateparameter();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplateParameter#getBase_templateparameter <em>Base templateparameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base templateparameter</em>' reference.
	 * @see #getBase_templateparameter()
	 * @generated
	 */
	void setBase_templateparameter(TemplateParameter value);

} // CppTemplateParameter
