/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion#getConditionalExpression <em>Conditional Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalExpressionCompletion()
 * @model
 * @generated
 */
public interface ConditionalExpressionCompletion extends ExpressionCompletion
{
  /**
   * Returns the value of the '<em><b>Conditional Or Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditional Or Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditional Or Expression Completion</em>' containment reference.
   * @see #setConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalExpressionCompletion_ConditionalOrExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ConditionalOrExpressionCompletion getConditionalOrExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditional Or Expression Completion</em>' containment reference.
   * @see #getConditionalOrExpressionCompletion()
   * @generated
   */
  void setConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Conditional Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditional Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditional Expression</em>' containment reference.
   * @see #setConditionalExpression(ConditionalExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalExpressionCompletion_ConditionalExpression()
   * @model containment="true"
   * @generated
   */
  ConditionalExpression getConditionalExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion#getConditionalExpression <em>Conditional Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditional Expression</em>' containment reference.
   * @see #getConditionalExpression()
   * @generated
   */
  void setConditionalExpression(ConditionalExpression value);

} // ConditionalExpressionCompletion
