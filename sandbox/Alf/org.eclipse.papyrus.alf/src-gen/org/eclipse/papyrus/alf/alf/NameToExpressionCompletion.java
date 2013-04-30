/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name To Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToExpressionCompletion#getNameToPrimary <em>Name To Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToExpressionCompletion#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToExpressionCompletion()
 * @model
 * @generated
 */
public interface NameToExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Name To Primary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name To Primary</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name To Primary</em>' containment reference.
   * @see #setNameToPrimary(NameToPrimaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToExpressionCompletion_NameToPrimary()
   * @model containment="true"
   * @generated
   */
  NameToPrimaryExpression getNameToPrimary();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToExpressionCompletion#getNameToPrimary <em>Name To Primary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name To Primary</em>' containment reference.
   * @see #getNameToPrimary()
   * @generated
   */
  void setNameToPrimary(NameToPrimaryExpression value);

  /**
   * Returns the value of the '<em><b>Primary To Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary To Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary To Expression Completion</em>' containment reference.
   * @see #setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToExpressionCompletion_PrimaryToExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PrimaryToExpressionCompletion getPrimaryToExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToExpressionCompletion#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary To Expression Completion</em>' containment reference.
   * @see #getPrimaryToExpressionCompletion()
   * @generated
   */
  void setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion value);

} // NameToExpressionCompletion
