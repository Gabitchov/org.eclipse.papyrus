/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Named Expression List Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion#getIndexedNamedExpression <em>Indexed Named Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getIndexedNamedExpressionListCompletion()
 * @model
 * @generated
 */
public interface IndexedNamedExpressionListCompletion extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getIndexedNamedExpressionListCompletion_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Indexed Named Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.IndexedNamedExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indexed Named Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indexed Named Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getIndexedNamedExpressionListCompletion_IndexedNamedExpression()
   * @model containment="true"
   * @generated
   */
  EList<IndexedNamedExpression> getIndexedNamedExpression();

} // IndexedNamedExpressionListCompletion
