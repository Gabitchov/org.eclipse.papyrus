/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getAcceptClause <em>Accept Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getSimpleCompletion <em>Simple Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getCompoundCompletion <em>Compound Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptStatement()
 * @model
 * @generated
 */
public interface AcceptStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Accept Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accept Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accept Clause</em>' containment reference.
   * @see #setAcceptClause(AcceptClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptStatement_AcceptClause()
   * @model containment="true"
   * @generated
   */
  AcceptClause getAcceptClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getAcceptClause <em>Accept Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accept Clause</em>' containment reference.
   * @see #getAcceptClause()
   * @generated
   */
  void setAcceptClause(AcceptClause value);

  /**
   * Returns the value of the '<em><b>Simple Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Completion</em>' containment reference.
   * @see #setSimpleCompletion(SimpleAcceptStatementCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptStatement_SimpleCompletion()
   * @model containment="true"
   * @generated
   */
  SimpleAcceptStatementCompletion getSimpleCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getSimpleCompletion <em>Simple Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Completion</em>' containment reference.
   * @see #getSimpleCompletion()
   * @generated
   */
  void setSimpleCompletion(SimpleAcceptStatementCompletion value);

  /**
   * Returns the value of the '<em><b>Compound Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compound Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compound Completion</em>' containment reference.
   * @see #setCompoundCompletion(CompoundAcceptStatementCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptStatement_CompoundCompletion()
   * @model containment="true"
   * @generated
   */
  CompoundAcceptStatementCompletion getCompoundCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptStatement#getCompoundCompletion <em>Compound Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compound Completion</em>' containment reference.
   * @see #getCompoundCompletion()
   * @generated
   */
  void setCompoundCompletion(CompoundAcceptStatementCompletion value);

} // AcceptStatement
