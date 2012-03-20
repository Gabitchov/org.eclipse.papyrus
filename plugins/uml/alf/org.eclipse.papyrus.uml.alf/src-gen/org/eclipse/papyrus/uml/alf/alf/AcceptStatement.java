/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getClause <em>Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getSimpleAccept <em>Simple Accept</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getCompoundAccept <em>Compound Accept</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAcceptStatement()
 * @model
 * @generated
 */
public interface AcceptStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clause</em>' containment reference.
   * @see #setClause(AcceptClause)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAcceptStatement_Clause()
   * @model containment="true"
   * @generated
   */
  AcceptClause getClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getClause <em>Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clause</em>' containment reference.
   * @see #getClause()
   * @generated
   */
  void setClause(AcceptClause value);

  /**
   * Returns the value of the '<em><b>Simple Accept</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Accept</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Accept</em>' containment reference.
   * @see #setSimpleAccept(SimpleAcceptStatementCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAcceptStatement_SimpleAccept()
   * @model containment="true"
   * @generated
   */
  SimpleAcceptStatementCompletion getSimpleAccept();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getSimpleAccept <em>Simple Accept</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Accept</em>' containment reference.
   * @see #getSimpleAccept()
   * @generated
   */
  void setSimpleAccept(SimpleAcceptStatementCompletion value);

  /**
   * Returns the value of the '<em><b>Compound Accept</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compound Accept</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compound Accept</em>' containment reference.
   * @see #setCompoundAccept(CompoundAcceptStatementCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAcceptStatement_CompoundAccept()
   * @model containment="true"
   * @generated
   */
  CompoundAcceptStatementCompletion getCompoundAccept();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement#getCompoundAccept <em>Compound Accept</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compound Accept</em>' containment reference.
   * @see #getCompoundAccept()
   * @generated
   */
  void setCompoundAccept(CompoundAcceptStatementCompletion value);

} // AcceptStatement
