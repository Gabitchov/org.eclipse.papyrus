/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpression#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpression#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpression()
 * @model
 * @generated
 */
public interface ConditionalOrExpression extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpression_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpression#getUnaryExpression <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Expression</em>' containment reference.
   * @see #getUnaryExpression()
   * @generated
   */
  void setUnaryExpression(UnaryExpression value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpression_ConditionalOrExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ConditionalOrExpressionCompletion getConditionalOrExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpression#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditional Or Expression Completion</em>' containment reference.
   * @see #getConditionalOrExpressionCompletion()
   * @generated
   */
  void setConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion value);

} // ConditionalOrExpression
