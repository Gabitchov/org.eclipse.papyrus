/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.PackageImport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An arbitrary string that is added to header and body file. Although primarily intended for manual include directives, it can be used for arbitrary definitions.
 * "preBody" is added to a C++ body file before automatic include statements, "body" after
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getPreBody <em>Pre Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getBase_package <em>Base package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getBase_class <em>Base class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Include#getBase_PackageImport <em>Base Package Import</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude()
 * @model
 * @generated
 */
public interface Include extends EObject {
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_Body()
	 * @model default="" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getBody <em>Body</em>}' attribute.
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_Header()
	 * @model default="" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getHeader <em>Header</em>}' attribute.
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_Base_package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_package <em>Base package</em>}' reference.
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_Base_class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_class <em>Base class</em>}' reference.
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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_Base_PackageImport()
	 * @model ordered="false"
	 * @generated
	 */
	PackageImport getBase_PackageImport();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getBase_PackageImport <em>Base Package Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package Import</em>' reference.
	 * @see #getBase_PackageImport()
	 * @generated
	 */
	void setBase_PackageImport(PackageImport value);

	/**
	 * Returns the value of the '<em><b>Pre Body</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Body</em>' attribute.
	 * @see #setPreBody(String)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getInclude_PreBody()
	 * @model default="" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getPreBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Include#getPreBody <em>Pre Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Body</em>' attribute.
	 * @see #getPreBody()
	 * @generated
	 */
	void setPreBody(String value);

} // Include
