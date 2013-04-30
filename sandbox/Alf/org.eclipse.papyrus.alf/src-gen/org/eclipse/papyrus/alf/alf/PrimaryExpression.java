/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getBaseExpression <em>Base Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getParenthesizedExpression <em>Parenthesized Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends EObject
{
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression_NameOrPrimaryExpression()
   * @model containment="true"
   * @generated
   */
  NameOrPrimaryExpression getNameOrPrimaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Or Primary Expression</em>' containment reference.
   * @see #getNameOrPrimaryExpression()
   * @generated
   */
  void setNameOrPrimaryExpression(NameOrPrimaryExpression value);

  /**
   * Returns the value of the '<em><b>Base Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Expression</em>' containment reference.
   * @see #setBaseExpression(BaseExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression_BaseExpression()
   * @model containment="true"
   * @generated
   */
  BaseExpression getBaseExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getBaseExpression <em>Base Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Expression</em>' containment reference.
   * @see #getBaseExpression()
   * @generated
   */
  void setBaseExpression(BaseExpression value);

  /**
   * Returns the value of the '<em><b>Parenthesized Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parenthesized Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parenthesized Expression</em>' containment reference.
   * @see #setParenthesizedExpression(ParenthesizedExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression_ParenthesizedExpression()
   * @model containment="true"
   * @generated
   */
  ParenthesizedExpression getParenthesizedExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getParenthesizedExpression <em>Parenthesized Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parenthesized Expression</em>' containment reference.
   * @see #getParenthesizedExpression()
   * @generated
   */
  void setParenthesizedExpression(ParenthesizedExpression value);

  /**
   * Returns the value of the '<em><b>Primary Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Expression Completion</em>' containment reference.
   * @see #setPrimaryExpressionCompletion(PrimaryExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression_PrimaryExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PrimaryExpressionCompletion getPrimaryExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Expression Completion</em>' containment reference.
   * @see #getPrimaryExpressionCompletion()
   * @generated
   */
  void setPrimaryExpressionCompletion(PrimaryExpressionCompletion value);

} // PrimaryExpression
