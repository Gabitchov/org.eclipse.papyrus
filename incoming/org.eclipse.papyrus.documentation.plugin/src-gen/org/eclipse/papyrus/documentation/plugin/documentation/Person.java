/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.documentation.plugin.documentation;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a person
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getEMail <em>EMail</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getCurrentCompany <em>Current Company</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EModelElement {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getPerson_FirstName()
	 * @model required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getPerson_LastName()
	 * @model required="true"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>EMail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EMail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EMail</em>' attribute.
	 * @see #setEMail(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getPerson_EMail()
	 * @model required="true"
	 * @generated
	 */
	String getEMail();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getEMail <em>EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EMail</em>' attribute.
	 * @see #getEMail()
	 * @generated
	 */
	void setEMail(String value);

	/**
	 * Returns the value of the '<em><b>Current Company</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Company</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Company</em>' attribute.
	 * @see #setCurrentCompany(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getPerson_CurrentCompany()
	 * @model
	 * @generated
	 */
	String getCurrentCompany();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.Person#getCurrentCompany <em>Current Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Company</em>' attribute.
	 * @see #getCurrentCompany()
	 * @generated
	 */
	void setCurrentCompany(String value);

} // Person
