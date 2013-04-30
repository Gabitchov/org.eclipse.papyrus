/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AssignmentExpressionCompletion#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAssignmentExpressionCompletion()
 * @model
 * @generated
 */
public interface AssignmentExpressionCompletion extends ExpressionCompletion
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.AssignmentOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AssignmentOperator
   * @see #setOperator(AssignmentOperator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAssignmentExpressionCompletion_Operator()
   * @model
   * @generated
   */
  AssignmentOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AssignmentExpressionCompletion#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AssignmentOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AssignmentOperator value);

} // AssignmentExpressionCompletion
