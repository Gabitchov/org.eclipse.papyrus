/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prefix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrefixExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrefixExpression#getPrimaryExpression <em>Primary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrefixExpression()
 * @model
 * @generated
 */
public interface PrefixExpression extends NonPostfixNonCastUnaryExpression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.AffixOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AffixOperator
   * @see #setOperator(AffixOperator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrefixExpression_Operator()
   * @model
   * @generated
   */
  AffixOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrefixExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AffixOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AffixOperator value);

  /**
   * Returns the value of the '<em><b>Primary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Expression</em>' containment reference.
   * @see #setPrimaryExpression(PrimaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrefixExpression_PrimaryExpression()
   * @model containment="true"
   * @generated
   */
  PrimaryExpression getPrimaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrefixExpression#getPrimaryExpression <em>Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Expression</em>' containment reference.
   * @see #getPrimaryExpression()
   * @generated
   */
  void setPrimaryExpression(PrimaryExpression value);

} // PrefixExpression
