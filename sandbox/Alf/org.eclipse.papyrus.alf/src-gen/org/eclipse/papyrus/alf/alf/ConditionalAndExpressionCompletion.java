/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional And Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion#getInclusiveOrExpression <em>Inclusive Or Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalAndExpressionCompletion()
 * @model
 * @generated
 */
public interface ConditionalAndExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Inclusive Or Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inclusive Or Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inclusive Or Expression Completion</em>' containment reference.
   * @see #setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalAndExpressionCompletion_InclusiveOrExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  InclusiveOrExpressionCompletion getInclusiveOrExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inclusive Or Expression Completion</em>' containment reference.
   * @see #getInclusiveOrExpressionCompletion()
   * @generated
   */
  void setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Inclusive Or Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.InclusiveOrExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inclusive Or Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inclusive Or Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalAndExpressionCompletion_InclusiveOrExpression()
   * @model containment="true"
   * @generated
   */
  EList<InclusiveOrExpression> getInclusiveOrExpression();

} // ConditionalAndExpressionCompletion
