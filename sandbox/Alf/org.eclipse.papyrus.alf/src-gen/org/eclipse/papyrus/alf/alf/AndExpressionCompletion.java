/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AndExpressionCompletion#getEqualityExpressionCompletion <em>Equality Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AndExpressionCompletion#getEqualityExpression <em>Equality Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpressionCompletion()
 * @model
 * @generated
 */
public interface AndExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Equality Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equality Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equality Expression Completion</em>' containment reference.
   * @see #setEqualityExpressionCompletion(EqualityExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpressionCompletion_EqualityExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  EqualityExpressionCompletion getEqualityExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AndExpressionCompletion#getEqualityExpressionCompletion <em>Equality Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Equality Expression Completion</em>' containment reference.
   * @see #getEqualityExpressionCompletion()
   * @generated
   */
  void setEqualityExpressionCompletion(EqualityExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Equality Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.EqualityExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equality Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equality Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAndExpressionCompletion_EqualityExpression()
   * @model containment="true"
   * @generated
   */
  EList<EqualityExpression> getEqualityExpression();

} // AndExpressionCompletion
