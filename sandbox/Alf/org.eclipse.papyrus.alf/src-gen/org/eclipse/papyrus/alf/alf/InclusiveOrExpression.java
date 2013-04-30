/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inclusive Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpression()
 * @model
 * @generated
 */
public interface InclusiveOrExpression extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpression_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression#getUnaryExpression <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Expression</em>' containment reference.
   * @see #getUnaryExpression()
   * @generated
   */
  void setUnaryExpression(UnaryExpression value);

  /**
   * Returns the value of the '<em><b>Inclusive Or Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inclusive Or Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inclusive Or Expression Completion</em>' containment reference.
   * @see #setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpression_InclusiveOrExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  InclusiveOrExpressionCompletion getInclusiveOrExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inclusive Or Expression Completion</em>' containment reference.
   * @see #getInclusiveOrExpressionCompletion()
   * @generated
   */
  void setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion value);

} // InclusiveOrExpression
