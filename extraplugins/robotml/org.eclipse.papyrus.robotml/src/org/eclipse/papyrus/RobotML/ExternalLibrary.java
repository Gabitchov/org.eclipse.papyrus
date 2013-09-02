/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibPath <em>Lib Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibFileFormat <em>Lib File Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getBase_Interface <em>Base Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getExternalLibrary()
 * @model
 * @generated
 */
public interface ExternalLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Lib Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib Path</em>' attribute.
	 * @see #setLibPath(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getExternalLibrary_LibPath()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLibPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibPath <em>Lib Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lib Path</em>' attribute.
	 * @see #getLibPath()
	 * @generated
	 */
	void setLibPath(String value);

	/**
	 * Returns the value of the '<em><b>Lib File Format</b></em>' attribute.
	 * The default value is <code>"elf"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib File Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib File Format</em>' attribute.
	 * @see #setLibFileFormat(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getExternalLibrary_LibFileFormat()
	 * @model default="elf" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLibFileFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibFileFormat <em>Lib File Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lib File Format</em>' attribute.
	 * @see #getLibFileFormat()
	 * @generated
	 */
	void setLibFileFormat(String value);

	/**
	 * Returns the value of the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Interface</em>' reference.
	 * @see #setBase_Interface(Interface)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getExternalLibrary_Base_Interface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getBase_Interface();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getBase_Interface <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Interface</em>' reference.
	 * @see #getBase_Interface()
	 * @generated
	 */
	void setBase_Interface(Interface value);

} // ExternalLibrary
