/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDefinition#getEnumerationClause <em>Enumeration Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDefinition#getEnumerationBody <em>Enumeration Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinition()
 * @model
 * @generated
 */
public interface EnumerationDefinition extends ClassifierDefinition
{
  /**
   * Returns the value of the '<em><b>Enumeration Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration Clause</em>' containment reference.
   * @see #setEnumerationClause(EnumerationDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinition_EnumerationClause()
   * @model containment="true"
   * @generated
   */
  EnumerationDeclaration getEnumerationClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinition#getEnumerationClause <em>Enumeration Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration Clause</em>' containment reference.
   * @see #getEnumerationClause()
   * @generated
   */
  void setEnumerationClause(EnumerationDeclaration value);

  /**
   * Returns the value of the '<em><b>Enumeration Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration Body</em>' containment reference.
   * @see #setEnumerationBody(EnumerationBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinition_EnumerationBody()
   * @model containment="true"
   * @generated
   */
  EnumerationBody getEnumerationBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinition#getEnumerationBody <em>Enumeration Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration Body</em>' containment reference.
   * @see #getEnumerationBody()
   * @generated
   */
  void setEnumerationBody(EnumerationBody value);

} // EnumerationDefinition
