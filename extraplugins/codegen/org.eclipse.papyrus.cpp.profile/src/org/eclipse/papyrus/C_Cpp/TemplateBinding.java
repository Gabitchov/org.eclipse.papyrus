/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTemplateBinding()
 * @model
 * @generated
 */
public interface TemplateBinding extends EObject {
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTemplateBinding_Binding()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBinding <em>Binding</em>}' attribute.
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
	 * @see #setBase_templatebinding(org.eclipse.uml2.uml.TemplateBinding)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTemplateBinding_Base_templatebinding()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.TemplateBinding getBase_templatebinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding#getBase_templatebinding <em>Base templatebinding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base templatebinding</em>' reference.
	 * @see #getBase_templatebinding()
	 * @generated
	 */
	void setBase_templatebinding(org.eclipse.uml2.uml.TemplateBinding value);

} // TemplateBinding
