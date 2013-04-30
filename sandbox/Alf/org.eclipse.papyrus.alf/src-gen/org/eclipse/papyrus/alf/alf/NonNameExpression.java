/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Name Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNameExpression#getNonNameUnaryExpression <em>Non Name Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNameExpression#getExpressionCompletion <em>Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNameExpression()
 * @model
 * @generated
 */
public interface NonNameExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Non Name Unary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Name Unary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Name Unary Expression</em>' containment reference.
   * @see #setNonNameUnaryExpression(NonNameUnaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNameExpression_NonNameUnaryExpression()
   * @model containment="true"
   * @generated
   */
  NonNameUnaryExpression getNonNameUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNameExpression#getNonNameUnaryExpression <em>Non Name Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Name Unary Expression</em>' containment reference.
   * @see #getNonNameUnaryExpression()
   * @generated
   */
  void setNonNameUnaryExpression(NonNameUnaryExpression value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNameExpression_ExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ExpressionCompletion getExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNameExpression#getExpressionCompletion <em>Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Completion</em>' containment reference.
   * @see #getExpressionCompletion()
   * @generated
   */
  void setExpressionCompletion(ExpressionCompletion value);

} // NonNameExpression
