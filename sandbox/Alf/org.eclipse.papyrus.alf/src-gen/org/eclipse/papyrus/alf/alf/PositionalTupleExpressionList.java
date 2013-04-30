/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Positional Tuple Expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PositionalTupleExpressionList#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPositionalTupleExpressionList()
 * @model
 * @generated
 */
public interface PositionalTupleExpressionList extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPositionalTupleExpressionList_Expression()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpression();

} // PositionalTupleExpressionList
