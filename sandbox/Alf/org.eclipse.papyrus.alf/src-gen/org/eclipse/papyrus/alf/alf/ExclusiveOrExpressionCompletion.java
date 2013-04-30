/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusive Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion#getAndExpressionCompletion <em>And Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion#getAndExpression <em>And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExclusiveOrExpressionCompletion()
 * @model
 * @generated
 */
public interface ExclusiveOrExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>And Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>And Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>And Expression Completion</em>' containment reference.
   * @see #setAndExpressionCompletion(AndExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExclusiveOrExpressionCompletion_AndExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  AndExpressionCompletion getAndExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion#getAndExpressionCompletion <em>And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>And Expression Completion</em>' containment reference.
   * @see #getAndExpressionCompletion()
   * @generated
   */
  void setAndExpressionCompletion(AndExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>And Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.AndExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>And Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>And Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getExclusiveOrExpressionCompletion_AndExpression()
   * @model containment="true"
   * @generated
   */
  EList<AndExpression> getAndExpression();

} // ExclusiveOrExpressionCompletion
