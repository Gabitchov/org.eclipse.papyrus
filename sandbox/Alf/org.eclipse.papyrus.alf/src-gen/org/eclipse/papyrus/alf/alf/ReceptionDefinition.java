/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reception Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ReceptionDefinition#getReceptionName <em>Reception Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getReceptionDefinition()
 * @model
 * @generated
 */
public interface ReceptionDefinition extends ActiveFeatureDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Reception Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reception Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reception Name</em>' containment reference.
   * @see #setReceptionName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getReceptionDefinition_ReceptionName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getReceptionName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ReceptionDefinition#getReceptionName <em>Reception Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reception Name</em>' containment reference.
   * @see #getReceptionName()
   * @generated
   */
  void setReceptionName(QualifiedName value);

} // ReceptionDefinition
