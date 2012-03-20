/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parenthesized Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getExpOrTypeCast <em>Exp Or Type Cast</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getCasted <em>Casted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getParenthesizedExpression()
 * @model
 * @generated
 */
public interface ParenthesizedExpression extends ValueSpecification, NonLiteralValueSpecification
{
  /**
   * Returns the value of the '<em><b>Exp Or Type Cast</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp Or Type Cast</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp Or Type Cast</em>' containment reference.
   * @see #setExpOrTypeCast(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getParenthesizedExpression_ExpOrTypeCast()
   * @model containment="true"
   * @generated
   */
  Expression getExpOrTypeCast();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getExpOrTypeCast <em>Exp Or Type Cast</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp Or Type Cast</em>' containment reference.
   * @see #getExpOrTypeCast()
   * @generated
   */
  void setExpOrTypeCast(Expression value);

  /**
   * Returns the value of the '<em><b>Casted</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Casted</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Casted</em>' containment reference.
   * @see #setCasted(NonLiteralValueSpecification)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getParenthesizedExpression_Casted()
   * @model containment="true"
   * @generated
   */
  NonLiteralValueSpecification getCasted();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getCasted <em>Casted</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Casted</em>' containment reference.
   * @see #getCasted()
   * @generated
   */
  void setCasted(NonLiteralValueSpecification value);

  /**
   * Returns the value of the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suffix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suffix</em>' containment reference.
   * @see #setSuffix(SuffixExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getParenthesizedExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  SuffixExpression getSuffix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression#getSuffix <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suffix</em>' containment reference.
   * @see #getSuffix()
   * @generated
   */
  void setSuffix(SuffixExpression value);

} // ParenthesizedExpression
