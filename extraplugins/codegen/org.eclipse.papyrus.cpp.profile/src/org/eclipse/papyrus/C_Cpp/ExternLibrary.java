/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extern Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mark a package as External Library. If this package is used, the associated CDT project will be configured accordingly.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludePaths <em>Include Paths</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getBase_package <em>Base package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibPaths <em>Lib Paths</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getMacros <em>Macros</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getLibs <em>Libs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary()
 * @model
 * @generated
 */
public interface ExternLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Include Paths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Paths</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Paths</em>' attribute list.
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_IncludePaths()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getIncludePaths();

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
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_Base_package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary#getBase_package <em>Base package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base package</em>' reference.
	 * @see #getBase_package()
	 * @generated
	 */
	void setBase_package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Lib Paths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib Paths</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib Paths</em>' attribute list.
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_LibPaths()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getLibPaths();

	/**
	 * Returns the value of the '<em><b>Macros</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macros</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macros</em>' attribute list.
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_Macros()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getMacros();

	/**
	 * Returns the value of the '<em><b>Libs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libs</em>' attribute list.
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_Libs()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getLibs();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' attribute list.
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getExternLibrary_Includes()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getIncludes();

} // ExternLibrary
