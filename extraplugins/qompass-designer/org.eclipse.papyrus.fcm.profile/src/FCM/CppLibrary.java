/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cpp Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.CppLibrary#getMacros <em>Macros</em>}</li>
 *   <li>{@link FCM.CppLibrary#getLibs <em>Libs</em>}</li>
 *   <li>{@link FCM.CppLibrary#getLibPaths <em>Lib Paths</em>}</li>
 *   <li>{@link FCM.CppLibrary#getIncludePaths <em>Include Paths</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getCppLibrary()
 * @model
 * @generated
 */
public interface CppLibrary extends ExternalLibrary {
	/**
	 * Returns the value of the '<em><b>Macros</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macros</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macros</em>' attribute list.
	 * @see FCM.FCMPackage#getCppLibrary_Macros()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getMacros();

	/**
	 * Returns the value of the '<em><b>Libs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libs</em>' attribute list.
	 * @see FCM.FCMPackage#getCppLibrary_Libs()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getLibs();

	/**
	 * Returns the value of the '<em><b>Lib Paths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib Paths</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib Paths</em>' attribute list.
	 * @see FCM.FCMPackage#getCppLibrary_LibPaths()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getLibPaths();

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
	 * @see FCM.FCMPackage#getCppLibrary_IncludePaths()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getIncludePaths();

} // CppLibrary
