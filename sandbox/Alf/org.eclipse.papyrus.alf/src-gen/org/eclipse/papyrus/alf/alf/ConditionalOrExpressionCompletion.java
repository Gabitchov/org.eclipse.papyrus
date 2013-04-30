/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion#getConditionalAndExpressionCompletion <em>Conditional And Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion#getConditionalAndExpression <em>Conditional And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpressionCompletion()
 * @model
 * @generated
 */
public interface ConditionalOrExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Conditional And Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditional And Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditional And Expression Completion</em>' containment reference.
   * @see #setConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpressionCompletion_ConditionalAndExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ConditionalAndExpressionCompletion getConditionalAndExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion#getConditionalAndExpressionCompletion <em>Conditional And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditional And Expression Completion</em>' containment reference.
   * @see #getConditionalAndExpressionCompletion()
   * @generated
   */
  void setConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Conditional And Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ConditionalAndExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditional And Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditional And Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getConditionalOrExpressionCompletion_ConditionalAndExpression()
   * @model containment="true"
   * @generated
   */
  EList<ConditionalAndExpression> getConditionalAndExpression();

} // ConditionalOrExpressionCompletion
