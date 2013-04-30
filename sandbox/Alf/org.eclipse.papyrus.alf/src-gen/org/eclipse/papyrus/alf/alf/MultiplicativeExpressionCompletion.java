/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion#getUnaryExpression <em>Unary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicativeExpressionCompletion()
 * @model
 * @generated
 */
public interface MultiplicativeExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.MultiplicativeOperator}.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.MultiplicativeOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute list.
   * @see org.eclipse.papyrus.alf.alf.MultiplicativeOperator
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicativeExpressionCompletion_Operator()
   * @model unique="false"
   * @generated
   */
  EList<MultiplicativeOperator> getOperator();

  /**
   * Returns the value of the '<em><b>Unary Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.UnaryExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicativeExpressionCompletion_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  EList<UnaryExpression> getUnaryExpression();

} // MultiplicativeExpressionCompletion
