/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.Platform#getLibrary <em>Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPlatform()
 * @model
 * @generated
 */
public interface Platform extends org.eclipse.papyrus.RobotML.System {
	/**
	 * Returns the value of the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Node</em>' reference.
	 * @see #setBase_Node(Node)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPlatform_Base_Node()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getBase_Node();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Node</em>' reference.
	 * @see #getBase_Node()
	 * @generated
	 */
	void setBase_Node(Node value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.RobotML.ExternalLibrary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' reference list.
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPlatform_Library()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ExternalLibrary> getLibrary();

} // Platform
