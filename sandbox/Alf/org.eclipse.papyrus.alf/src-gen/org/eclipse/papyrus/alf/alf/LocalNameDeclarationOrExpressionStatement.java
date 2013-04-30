/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Name Declaration Or Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getPotentiallyAmbiguousName <em>Potentially Ambiguous Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getMultiplicaityIndicator <em>Multiplicaity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getNonNameExpression <em>Non Name Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement()
 * @model
 * @generated
 */
public interface LocalNameDeclarationOrExpressionStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Potentially Ambiguous Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potentially Ambiguous Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Potentially Ambiguous Name</em>' containment reference.
   * @see #setPotentiallyAmbiguousName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_PotentiallyAmbiguousName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getPotentiallyAmbiguousName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getPotentiallyAmbiguousName <em>Potentially Ambiguous Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Potentially Ambiguous Name</em>' containment reference.
   * @see #getPotentiallyAmbiguousName()
   * @generated
   */
  void setPotentiallyAmbiguousName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Multiplicaity Indicator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicaity Indicator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicaity Indicator</em>' containment reference.
   * @see #setMultiplicaityIndicator(MultiplicityIndicator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_MultiplicaityIndicator()
   * @model containment="true"
   * @generated
   */
  MultiplicityIndicator getMultiplicaityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getMultiplicaityIndicator <em>Multiplicaity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicaity Indicator</em>' containment reference.
   * @see #getMultiplicaityIndicator()
   * @generated
   */
  void setMultiplicaityIndicator(MultiplicityIndicator value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Local Name Declaration Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Name Declaration Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Name Declaration Completion</em>' containment reference.
   * @see #setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_LocalNameDeclarationCompletion()
   * @model containment="true"
   * @generated
   */
  LocalNameDeclarationStatementCompletion getLocalNameDeclarationCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Name Declaration Completion</em>' containment reference.
   * @see #getLocalNameDeclarationCompletion()
   * @generated
   */
  void setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_NameToExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  NameToExpressionCompletion getNameToExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getNameToExpressionCompletion <em>Name To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name To Expression Completion</em>' containment reference.
   * @see #getNameToExpressionCompletion()
   * @generated
   */
  void setNameToExpressionCompletion(NameToExpressionCompletion value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationOrExpressionStatement_NonNameExpression()
   * @model containment="true"
   * @generated
   */
  NonNameExpression getNonNameExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement#getNonNameExpression <em>Non Name Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Name Expression</em>' containment reference.
   * @see #getNonNameExpression()
   * @generated
   */
  void setNonNameExpression(NonNameExpression value);

} // LocalNameDeclarationOrExpressionStatement
