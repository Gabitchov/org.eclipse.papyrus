/**
 */
package Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.PackageImport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * "preBody" is added to a C++ body file before automatic include statements, "body" after
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cpp.CppInclude#getBody <em>Body</em>}</li>
 *   <li>{@link Cpp.CppInclude#getHeader <em>Header</em>}</li>
 *   <li>{@link Cpp.CppInclude#getBase_package <em>Base package</em>}</li>
 *   <li>{@link Cpp.CppInclude#getBase_class <em>Base class</em>}</li>
 *   <li>{@link Cpp.CppInclude#getBase_PackageImport <em>Base Package Import</em>}</li>
 *   <li>{@link Cpp.CppInclude#getPreBody <em>Pre Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cpp.CppPackage#getCppInclude()
 * @model
 * @generated
 */
public interface CppInclude extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see Cpp.CppPackage#getCppInclude_Body()
	 * @model default="" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(String)
	 * @see Cpp.CppPackage#getCppInclude_Header()
	 * @model default="" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(String value);

	/**
	 * Returns the value of the '<em><b>Base package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base package</em>' reference.
	 * @see #setBase_package(org.eclipse.uml2.uml.Package)
	 * @see Cpp.CppPackage#getCppInclude_Base_package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_package();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getBase_package <em>Base package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base package</em>' reference.
	 * @see #getBase_package()
	 * @generated
	 */
	void setBase_package(org.eclipse.uml2.uml.Package value);

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
	 * @see Cpp.CppPackage#getCppInclude_Base_class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_class();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getBase_class <em>Base class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base class</em>' reference.
	 * @see #getBase_class()
	 * @generated
	 */
	void setBase_class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package Import</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package Import</em>' reference.
	 * @see #setBase_PackageImport(PackageImport)
	 * @see Cpp.CppPackage#getCppInclude_Base_PackageImport()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PackageImport getBase_PackageImport();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getBase_PackageImport <em>Base Package Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package Import</em>' reference.
	 * @see #getBase_PackageImport()
	 * @generated
	 */
	void setBase_PackageImport(PackageImport value);

	/**
	 * Returns the value of the '<em><b>Pre Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Body</em>' attribute.
	 * @see #setPreBody(String)
	 * @see Cpp.CppPackage#getCppInclude_PreBody()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getPreBody();

	/**
	 * Sets the value of the '{@link Cpp.CppInclude#getPreBody <em>Pre Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Body</em>' attribute.
	 * @see #getPreBody()
	 * @generated
	 */
	void setPreBody(String value);

} // CppInclude
