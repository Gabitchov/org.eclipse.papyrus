/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppTemplateBinding#getBinding <em>Binding</em>}</li>
 *   <li>{@link Cpp.CppTemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppTemplateBinding()
 * @model
 * @generated
 */
public interface CppTemplateBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' attribute.
	 * @see #setBinding(String)
	 * @see Cpp.CppPackage#getCppTemplateBinding_Binding()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getBinding();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplateBinding#getBinding <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' attribute.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(String value);

	/**
	 * Returns the value of the '<em><b>Base templatebinding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base templatebinding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base templatebinding</em>' reference.
	 * @see #setBase_templatebinding(TemplateBinding)
	 * @see Cpp.CppPackage#getCppTemplateBinding_Base_templatebinding()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateBinding getBase_templatebinding();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base templatebinding</em>' reference.
	 * @see #getBase_templatebinding()
	 * @generated
	 */
	void setBase_templatebinding(TemplateBinding value);

} // CppTemplateBinding
