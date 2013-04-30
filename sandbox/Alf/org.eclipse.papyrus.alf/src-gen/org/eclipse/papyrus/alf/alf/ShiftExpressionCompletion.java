/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion#getAdditiveExpressionCompletion <em>Additive Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion#getAdditiveExpression <em>Additive Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getShiftExpressionCompletion()
 * @model
 * @generated
 */
public interface ShiftExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Additive Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additive Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additive Expression Completion</em>' containment reference.
   * @see #setAdditiveExpressionCompletion(AdditiveExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getShiftExpressionCompletion_AdditiveExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  AdditiveExpressionCompletion getAdditiveExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion#getAdditiveExpressionCompletion <em>Additive Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additive Expression Completion</em>' containment reference.
   * @see #getAdditiveExpressionCompletion()
   * @generated
   */
  void setAdditiveExpressionCompletion(AdditiveExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ShiftOperator}.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.ShiftOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute list.
   * @see org.eclipse.papyrus.alf.alf.ShiftOperator
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getShiftExpressionCompletion_Operator()
   * @model unique="false"
   * @generated
   */
  EList<ShiftOperator> getOperator();

  /**
   * Returns the value of the '<em><b>Additive Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.AdditiveExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additive Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additive Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getShiftExpressionCompletion_AdditiveExpression()
   * @model containment="true"
   * @generated
   */
  EList<AdditiveExpression> getAdditiveExpression();

} // ShiftExpressionCompletion
