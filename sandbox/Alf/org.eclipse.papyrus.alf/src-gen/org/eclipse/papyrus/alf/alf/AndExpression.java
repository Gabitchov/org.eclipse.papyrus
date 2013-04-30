/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AndExpression#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AndExpression#getAndExpressionCompletion <em>And Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpression()
 * @model
 * @generated
 */
public interface AndExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Unary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Expression</em>' containment reference.
   * @see #setUnaryExpression(UnaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpression_UnaryExpression()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getUnaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AndExpression#getUnaryExpression <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Expression</em>' containment reference.
   * @see #getUnaryExpression()
   * @generated
   */
  void setUnaryExpression(UnaryExpression value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpression_AndExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  AndExpressionCompletion getAndExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AndExpression#getAndExpressionCompletion <em>And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>And Expression Completion</em>' containment reference.
   * @see #getAndExpressionCompletion()
   * @generated
   */
  void setAndExpressionCompletion(AndExpressionCompletion value);

} // AndExpression
