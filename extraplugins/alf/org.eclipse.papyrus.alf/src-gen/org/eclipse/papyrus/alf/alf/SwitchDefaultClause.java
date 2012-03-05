/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Default Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SwitchDefaultClause#getStatementSequence <em>Statement Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchDefaultClause()
 * @model
 * @generated
 */
public interface SwitchDefaultClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Statement Sequence</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement Sequence</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement Sequence</em>' containment reference.
   * @see #setStatementSequence(NonEmptyStatementSequence)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchDefaultClause_StatementSequence()
   * @model containment="true"
   * @generated
   */
  NonEmptyStatementSequence getStatementSequence();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SwitchDefaultClause#getStatementSequence <em>Statement Sequence</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement Sequence</em>' containment reference.
   * @see #getStatementSequence()
   * @generated
   */
  void setStatementSequence(NonEmptyStatementSequence value);

} // SwitchDefaultClause
