/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary To Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion#getExpressionCompletion <em>Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryToExpressionCompletion()
 * @model
 * @generated
 */
public interface PrimaryToExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Post Fix Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Post Fix Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Post Fix Expression Completion</em>' containment reference.
   * @see #setPostFixExpressionCompletion(PostfixExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryToExpressionCompletion_PostFixExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PostfixExpressionCompletion getPostFixExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Post Fix Expression Completion</em>' containment reference.
   * @see #getPostFixExpressionCompletion()
   * @generated
   */
  void setPostFixExpressionCompletion(PostfixExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Completion</em>' containment reference.
   * @see #setExpressionCompletion(ExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryToExpressionCompletion_ExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ExpressionCompletion getExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion#getExpressionCompletion <em>Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Completion</em>' containment reference.
   * @see #getExpressionCompletion()
   * @generated
   */
  void setExpressionCompletion(ExpressionCompletion value);

} // PrimaryToExpressionCompletion
