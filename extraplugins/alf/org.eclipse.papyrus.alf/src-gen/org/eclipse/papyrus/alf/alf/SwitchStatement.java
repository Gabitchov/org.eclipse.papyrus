/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SwitchStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SwitchStatement#getSwitchClause <em>Switch Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SwitchStatement#getDefaultClause <em>Default Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchStatement_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SwitchStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Switch Clause</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.SwitchClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Switch Clause</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Switch Clause</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchStatement_SwitchClause()
   * @model containment="true"
   * @generated
   */
  EList<SwitchClause> getSwitchClause();

  /**
   * Returns the value of the '<em><b>Default Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Clause</em>' containment reference.
   * @see #setDefaultClause(SwitchDefaultClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSwitchStatement_DefaultClause()
   * @model containment="true"
   * @generated
   */
  SwitchDefaultClause getDefaultClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SwitchStatement#getDefaultClause <em>Default Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Clause</em>' containment reference.
   * @see #getDefaultClause()
   * @generated
   */
  void setDefaultClause(SwitchDefaultClause value);

} // SwitchStatement
