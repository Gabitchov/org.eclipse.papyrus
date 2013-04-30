/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub#getAssociationDeclaration <em>Association Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAssociationDefinitionOrStub()
 * @model
 * @generated
 */
public interface AssociationDefinitionOrStub extends ClassifierDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Association Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Declaration</em>' containment reference.
   * @see #setAssociationDeclaration(AssociationDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAssociationDefinitionOrStub_AssociationDeclaration()
   * @model containment="true"
   * @generated
   */
  AssociationDeclaration getAssociationDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub#getAssociationDeclaration <em>Association Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association Declaration</em>' containment reference.
   * @see #getAssociationDeclaration()
   * @generated
   */
  void setAssociationDeclaration(AssociationDeclaration value);

  /**
   * Returns the value of the '<em><b>Structured Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structured Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structured Body</em>' containment reference.
   * @see #setStructuredBody(StructuredBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAssociationDefinitionOrStub_StructuredBody()
   * @model containment="true"
   * @generated
   */
  StructuredBody getStructuredBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub#getStructuredBody <em>Structured Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structured Body</em>' containment reference.
   * @see #getStructuredBody()
   * @generated
   */
  void setStructuredBody(StructuredBody value);

} // AssociationDefinitionOrStub
