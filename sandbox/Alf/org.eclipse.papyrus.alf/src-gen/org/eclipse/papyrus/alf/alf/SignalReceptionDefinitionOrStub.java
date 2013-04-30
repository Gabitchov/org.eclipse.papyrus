/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Reception Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub#getSignalReceptionOrDeclaration <em>Signal Reception Or Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDefinitionOrStub()
 * @model
 * @generated
 */
public interface SignalReceptionDefinitionOrStub extends ActiveFeatureDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Signal Reception Or Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal Reception Or Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal Reception Or Declaration</em>' containment reference.
   * @see #setSignalReceptionOrDeclaration(SignalReceptionDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDefinitionOrStub_SignalReceptionOrDeclaration()
   * @model containment="true"
   * @generated
   */
  SignalReceptionDeclaration getSignalReceptionOrDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub#getSignalReceptionOrDeclaration <em>Signal Reception Or Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal Reception Or Declaration</em>' containment reference.
   * @see #getSignalReceptionOrDeclaration()
   * @generated
   */
  void setSignalReceptionOrDeclaration(SignalReceptionDeclaration value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDefinitionOrStub_StructuredBody()
   * @model containment="true"
   * @generated
   */
  StructuredBody getStructuredBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub#getStructuredBody <em>Structured Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structured Body</em>' containment reference.
   * @see #getStructuredBody()
   * @generated
   */
  void setStructuredBody(StructuredBody value);

} // SignalReceptionDefinitionOrStub
