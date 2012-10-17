/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clear Assoc Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ClearAssocExpression#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClearAssocExpression()
 * @model
 * @generated
 */
public interface ClearAssocExpression extends LinkOperationExpression
{
  /**
   * Returns the value of the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' containment reference.
   * @see #setEnd(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClearAssocExpression_End()
   * @model containment="true"
   * @generated
   */
  Expression getEnd();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ClearAssocExpression#getEnd <em>End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' containment reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Expression value);

} // ClearAssocExpression
