/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.IfStatement#getSequentialClausses <em>Sequential Clausses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.IfStatement#getFinalClause <em>Final Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Sequential Clausses</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequential Clausses</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequential Clausses</em>' containment reference.
   * @see #setSequentialClausses(SequentialClauses)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getIfStatement_SequentialClausses()
   * @model containment="true"
   * @generated
   */
  SequentialClauses getSequentialClausses();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.IfStatement#getSequentialClausses <em>Sequential Clausses</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequential Clausses</em>' containment reference.
   * @see #getSequentialClausses()
   * @generated
   */
  void setSequentialClausses(SequentialClauses value);

  /**
   * Returns the value of the '<em><b>Final Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final Clause</em>' containment reference.
   * @see #setFinalClause(FinalClause)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getIfStatement_FinalClause()
   * @model containment="true"
   * @generated
   */
  FinalClause getFinalClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.IfStatement#getFinalClause <em>Final Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final Clause</em>' containment reference.
   * @see #getFinalClause()
   * @generated
   */
  void setFinalClause(FinalClause value);

} // IfStatement
