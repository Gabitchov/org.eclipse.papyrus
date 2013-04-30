/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Name Postfix Or Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#isAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getCastCompletion <em>Cast Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPostifixExpressionCompletion <em>Postifix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPostfixExpressionCompletion <em>Postfix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getNonNameExpression <em>Non Name Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getBaseExpression <em>Base Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression()
 * @model
 * @generated
 */
public interface NonNamePostfixOrCastExpression extends NonNameUnaryExpression
{
  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute.
   * @see #setAny(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_Any()
   * @model
   * @generated
   */
  boolean isAny();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#isAny <em>Any</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any</em>' attribute.
   * @see #isAny()
   * @generated
   */
  void setAny(boolean value);

  /**
   * Returns the value of the '<em><b>Cast Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cast Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cast Completion</em>' containment reference.
   * @see #setCastCompletion(CastCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_CastCompletion()
   * @model containment="true"
   * @generated
   */
  CastCompletion getCastCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getCastCompletion <em>Cast Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cast Completion</em>' containment reference.
   * @see #getCastCompletion()
   * @generated
   */
  void setCastCompletion(CastCompletion value);

  /**
   * Returns the value of the '<em><b>Potentially Ambiguous Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference.
   * @see #setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_PotentiallyAmbiguousQualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithoutBinding getPotentiallyAmbiguousQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference.
   * @see #getPotentiallyAmbiguousQualifiedName()
   * @generated
   */
  void setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding value);

  /**
   * Returns the value of the '<em><b>Postifix Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postifix Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postifix Expression Completion</em>' containment reference.
   * @see #setPostifixExpressionCompletion(PostfixExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_PostifixExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PostfixExpressionCompletion getPostifixExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPostifixExpressionCompletion <em>Postifix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postifix Expression Completion</em>' containment reference.
   * @see #getPostifixExpressionCompletion()
   * @generated
   */
  void setPostifixExpressionCompletion(PostfixExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Name To Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name To Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name To Expression Completion</em>' containment reference.
   * @see #setNameToExpressionCompletion(NameToExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_NameToExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  NameToExpressionCompletion getNameToExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getNameToExpressionCompletion <em>Name To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name To Expression Completion</em>' containment reference.
   * @see #getNameToExpressionCompletion()
   * @generated
   */
  void setNameToExpressionCompletion(NameToExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Postfix Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postfix Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Expression Completion</em>' containment reference.
   * @see #setPostfixExpressionCompletion(PostfixExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_PostfixExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PostfixExpressionCompletion getPostfixExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getPostfixExpressionCompletion <em>Postfix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Expression Completion</em>' containment reference.
   * @see #getPostfixExpressionCompletion()
   * @generated
   */
  void setPostfixExpressionCompletion(PostfixExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Non Name Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Name Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Name Expression</em>' containment reference.
   * @see #setNonNameExpression(NonNameExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_NonNameExpression()
   * @model containment="true"
   * @generated
   */
  NonNameExpression getNonNameExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getNonNameExpression <em>Non Name Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Name Expression</em>' containment reference.
   * @see #getNonNameExpression()
   * @generated
   */
  void setNonNameExpression(NonNameExpression value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNonNamePostfixOrCastExpression_BaseExpression()
   * @model containment="true"
   * @generated
   */
  BaseExpression getBaseExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression#getBaseExpression <em>Base Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Expression</em>' containment reference.
   * @see #getBaseExpression()
   * @generated
   */
  void setBaseExpression(BaseExpression value);

} // NonNamePostfixOrCastExpression
