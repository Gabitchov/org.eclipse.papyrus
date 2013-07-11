/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.documentation.plugin.documentation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root for a plug-in documentation
 * 
 * Contains a description of the plug-in
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Documentation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Documentation#getImplicitDependencies <em>Implicit Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Documentation#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Documentation#getAdditionalComments <em>Additional Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getDocumentation()
 * @model
 * @generated
 */
public interface Documentation extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getDocumentation_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.Documentation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Implicit Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.documentation.plugin.documentation.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit Dependencies</em>' containment reference list.
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getDocumentation_ImplicitDependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getImplicitDependencies();

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.documentation.plugin.documentation.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referent</em>' containment reference list.
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getDocumentation_Referent()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getReferent();

	/**
	 * Returns the value of the '<em><b>Additional Comments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.documentation.plugin.documentation.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Comments</em>' containment reference list.
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getDocumentation_AdditionalComments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Comment> getAdditionalComments();

} // Documentation
