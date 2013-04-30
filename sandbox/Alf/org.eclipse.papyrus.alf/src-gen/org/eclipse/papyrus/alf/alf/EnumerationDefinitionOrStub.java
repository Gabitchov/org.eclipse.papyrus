/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub#getEnumerationDeclaration <em>Enumeration Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub#getEnumerationBody <em>Enumeration Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinitionOrStub()
 * @model
 * @generated
 */
public interface EnumerationDefinitionOrStub extends ClassifierDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Enumeration Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration Declaration</em>' containment reference.
   * @see #setEnumerationDeclaration(EnumerationDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinitionOrStub_EnumerationDeclaration()
   * @model containment="true"
   * @generated
   */
  EnumerationDeclaration getEnumerationDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub#getEnumerationDeclaration <em>Enumeration Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration Declaration</em>' containment reference.
   * @see #getEnumerationDeclaration()
   * @generated
   */
  void setEnumerationDeclaration(EnumerationDeclaration value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDefinitionOrStub_EnumerationBody()
   * @model containment="true"
   * @generated
   */
  EnumerationBody getEnumerationBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub#getEnumerationBody <em>Enumeration Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration Body</em>' containment reference.
   * @see #getEnumerationBody()
   * @generated
   */
  void setEnumerationBody(EnumerationBody value);

} // EnumerationDefinitionOrStub
