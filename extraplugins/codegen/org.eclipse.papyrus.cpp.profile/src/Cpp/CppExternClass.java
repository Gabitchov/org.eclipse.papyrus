/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extern Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppExternClass#getName <em>Name</em>}</li>
 *   <li>{@link Cpp.CppExternClass#getBase_class <em>Base class</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppExternClass()
 * @model
 * @generated
 */
public interface CppExternClass extends EObject {
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
	 * @see Cpp.CppPackage#getCppExternClass_Name()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Cpp.CppExternClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see Cpp.CppPackage#getCppExternClass_Base_class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_class();

	/**
	 * Sets the value of the '{@link Cpp.CppExternClass#getBase_class <em>Base class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base class</em>' reference.
	 * @see #getBase_class()
	 * @generated
	 */
	void setBase_class(org.eclipse.uml2.uml.Class value);

} // CppExternClass
