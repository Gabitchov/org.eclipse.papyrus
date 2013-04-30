/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Expression#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Expression#getExpressionCompletion <em>Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends InitializationExpression
{
  /**
   * Returns the value of the '<em><b>Unary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Expression</em>' containment reference.
   * @see #setUnaryExpression(UnaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExpression_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Expression#getUnaryExpression <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Expression</em>' containment reference.
   * @see #getUnaryExpression()
   * @generated
   */
  void setUnaryExpression(UnaryExpression value);

  /**
   * Returns the value of the '<em><b>Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Completion</em>' containment reference.
   * @see #setExpressionCompletion(ExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExpression_ExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ExpressionCompletion getExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Expression#getExpressionCompletion <em>Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Completion</em>' containment reference.
   * @see #getExpressionCompletion()
   * @generated
   */
  void setExpressionCompletion(ExpressionCompletion value);

} // Expression
