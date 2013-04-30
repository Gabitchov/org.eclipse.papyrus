/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LiteralExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLiteralExpression()
 * @model
 * @generated
 */
public interface LiteralExpression extends BaseExpression
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(PRIMITIVE_LITERAL)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLiteralExpression_Expression()
   * @model containment="true"
   * @generated
   */
  PRIMITIVE_LITERAL getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LiteralExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(PRIMITIVE_LITERAL value);

} // LiteralExpression
