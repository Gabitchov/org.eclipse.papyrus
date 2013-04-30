/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Or Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getNonNamePostfixOrCastExpression <em>Non Name Postfix Or Cast Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOrCastExpression()
 * @model
 * @generated
 */
public interface PostfixOrCastExpression extends UnaryExpression, CastCompletion
{
  /**
   * Returns the value of the '<em><b>Non Name Postfix Or Cast Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Name Postfix Or Cast Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Name Postfix Or Cast Expression</em>' containment reference.
   * @see #setNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOrCastExpression_NonNamePostfixOrCastExpression()
   * @model containment="true"
   * @generated
   */
  NonNamePostfixOrCastExpression getNonNamePostfixOrCastExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getNonNamePostfixOrCastExpression <em>Non Name Postfix Or Cast Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Name Postfix Or Cast Expression</em>' containment reference.
   * @see #getNonNamePostfixOrCastExpression()
   * @generated
   */
  void setNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression value);

  /**
   * Returns the value of the '<em><b>Name Or Primary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Or Primary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Or Primary Expression</em>' containment reference.
   * @see #setNameOrPrimaryExpression(NameOrPrimaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOrCastExpression_NameOrPrimaryExpression()
   * @model containment="true"
   * @generated
   */
  NameOrPrimaryExpression getNameOrPrimaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Or Primary Expression</em>' containment reference.
   * @see #getNameOrPrimaryExpression()
   * @generated
   */
  void setNameOrPrimaryExpression(NameOrPrimaryExpression value);

  /**
   * Returns the value of the '<em><b>Post Fix Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Post Fix Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Post Fix Expression Completion</em>' containment reference.
   * @see #setPostFixExpressionCompletion(PostfixExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOrCastExpression_PostFixExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PostfixExpressionCompletion getPostFixExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixOrCastExpression#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Post Fix Expression Completion</em>' containment reference.
   * @see #getPostFixExpressionCompletion()
   * @generated
   */
  void setPostFixExpressionCompletion(PostfixExpressionCompletion value);

} // PostfixOrCastExpression
