/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppTemplate#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link Cpp.CppTemplate#getBase_class <em>Base class</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppTemplate()
 * @model
 * @generated
 */
public interface CppTemplate extends EObject {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' attribute.
	 * @see #setDeclaration(String)
	 * @see Cpp.CppPackage#getCppTemplate_Declaration()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDeclaration();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplate#getDeclaration <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' attribute.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(String value);

	/**
	 * Returns the value of the '<em><b>Base class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base class</em>' reference.
	 * @see #setBase_class(org.eclipse.uml2.uml.Class)
	 * @see Cpp.CppPackage#getCppTemplate_Base_class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_class();

	/**
	 * Sets the value of the '{@link Cpp.CppTemplate#getBase_class <em>Base class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base class</em>' reference.
	 * @see #getBase_class()
	 * @generated
	 */
	void setBase_class(org.eclipse.uml2.uml.Class value);

} // CppTemplate
