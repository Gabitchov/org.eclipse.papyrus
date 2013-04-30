/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.RelationalExpression#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.RelationalExpression#getRelationalExpressionCompletion <em>Relational Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getRelationalExpression_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.RelationalExpression#getUnaryExpression <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Expression</em>' containment reference.
   * @see #getUnaryExpression()
   * @generated
   */
  void setUnaryExpression(UnaryExpression value);

  /**
   * Returns the value of the '<em><b>Relational Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relational Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relational Expression Completion</em>' containment reference.
   * @see #setRelationalExpressionCompletion(RelationalExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getRelationalExpression_RelationalExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  RelationalExpressionCompletion getRelationalExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.RelationalExpression#getRelationalExpressionCompletion <em>Relational Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relational Expression Completion</em>' containment reference.
   * @see #getRelationalExpressionCompletion()
   * @generated
   */
  void setRelationalExpressionCompletion(RelationalExpressionCompletion value);

} // RelationalExpression
