/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassifyStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassifyStatement#getClassificationClause <em>Classification Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassifyStatement()
 * @model
 * @generated
 */
public interface ClassifyStatement extends Statement
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
   * @see #setExpression(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassifyStatement_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassifyStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Classification Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classification Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classification Clause</em>' containment reference.
   * @see #setClassificationClause(ClassificationClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassifyStatement_ClassificationClause()
   * @model containment="true"
   * @generated
   */
  ClassificationClause getClassificationClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassifyStatement#getClassificationClause <em>Classification Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classification Clause</em>' containment reference.
   * @see #getClassificationClause()
   * @generated
   */
  void setClassificationClause(ClassificationClause value);

} // ClassifyStatement
