/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Any Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceAnyExpression#getSequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceAnyExpression()
 * @model
 * @generated
 */
public interface SequenceAnyExpression extends BaseExpression
{
  /**
   * Returns the value of the '<em><b>Sequence Construction Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Construction Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Construction Expression Completion</em>' containment reference.
   * @see #setSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceAnyExpression_SequenceConstructionExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionExpressionCompletion getSequenceConstructionExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceAnyExpression#getSequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Construction Expression Completion</em>' containment reference.
   * @see #getSequenceConstructionExpressionCompletion()
   * @generated
   */
  void setSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion value);

} // SequenceAnyExpression
