/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inclusive Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion#getExclusiveOrExpressionCompletion <em>Exclusive Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion#getExclusiveOrExpression <em>Exclusive Or Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpressionCompletion()
 * @model
 * @generated
 */
public interface InclusiveOrExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Exclusive Or Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exclusive Or Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exclusive Or Expression Completion</em>' containment reference.
   * @see #setExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpressionCompletion_ExclusiveOrExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ExclusiveOrExpressionCompletion getExclusiveOrExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion#getExclusiveOrExpressionCompletion <em>Exclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exclusive Or Expression Completion</em>' containment reference.
   * @see #getExclusiveOrExpressionCompletion()
   * @generated
   */
  void setExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Exclusive Or Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exclusive Or Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exclusive Or Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInclusiveOrExpressionCompletion_ExclusiveOrExpression()
   * @model containment="true"
   * @generated
   */
  EList<ExclusiveOrExpression> getExclusiveOrExpression();

} // InclusiveOrExpressionCompletion
