/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalDefinition#getSignalDeclaration <em>Signal Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalDefinition#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalDefinition()
 * @model
 * @generated
 */
public interface SignalDefinition extends ClassifierDefinition
{
  /**
   * Returns the value of the '<em><b>Signal Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal Declaration</em>' containment reference.
   * @see #setSignalDeclaration(SignalDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalDefinition_SignalDeclaration()
   * @model containment="true"
   * @generated
   */
  SignalDeclaration getSignalDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalDefinition#getSignalDeclaration <em>Signal Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal Declaration</em>' containment reference.
   * @see #getSignalDeclaration()
   * @generated
   */
  void setSignalDeclaration(SignalDeclaration value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalDefinition_StructuredBody()
   * @model containment="true"
   * @generated
   */
  StructuredBody getStructuredBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalDefinition#getStructuredBody <em>Structured Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structured Body</em>' containment reference.
   * @see #getStructuredBody()
   * @generated
   */
  void setStructuredBody(StructuredBody value);

} // SignalDefinition
