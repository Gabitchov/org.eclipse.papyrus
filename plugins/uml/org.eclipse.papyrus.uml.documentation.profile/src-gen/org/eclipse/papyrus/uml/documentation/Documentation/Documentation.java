/**
 */
package org.eclipse.papyrus.uml.documentation.Documentation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.documentation.Documentation.Documentation#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.documentation.Documentation.Documentation#getAssociatedResource <em>Associated Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.documentation.Documentation.DocumentationPackage#getDocumentation()
 * @model
 * @generated
 */
public interface Documentation extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.eclipse.papyrus.uml.documentation.Documentation.DocumentationPackage#getDocumentation_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.documentation.Documentation.Documentation#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Associated Resource</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Resource</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Resource</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.documentation.Documentation.DocumentationPackage#getDocumentation_AssociatedResource()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getAssociatedResource();

} // Documentation
