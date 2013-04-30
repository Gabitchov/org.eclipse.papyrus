/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceElements#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceElements#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceElements#getSequenceElementListCompletion <em>Sequence Element List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceElements#getSequenceInitializationExpression <em>Sequence Initialization Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceElements()
 * @model
 * @generated
 */
public interface SequenceElements extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression1</em>' containment reference.
   * @see #setExpression1(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceElements_Expression1()
   * @model containment="true"
   * @generated
   */
  Expression getExpression1();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceElements#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(Expression value);

  /**
   * Returns the value of the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression2</em>' containment reference.
   * @see #setExpression2(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceElements_Expression2()
   * @model containment="true"
   * @generated
   */
  Expression getExpression2();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceElements#getExpression2 <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression2</em>' containment reference.
   * @see #getExpression2()
   * @generated
   */
  void setExpression2(Expression value);

  /**
   * Returns the value of the '<em><b>Sequence Element List Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Element List Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Element List Completion</em>' containment reference.
   * @see #setSequenceElementListCompletion(SequenceElementListCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceElements_SequenceElementListCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceElementListCompletion getSequenceElementListCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceElements#getSequenceElementListCompletion <em>Sequence Element List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Element List Completion</em>' containment reference.
   * @see #getSequenceElementListCompletion()
   * @generated
   */
  void setSequenceElementListCompletion(SequenceElementListCompletion value);

  /**
   * Returns the value of the '<em><b>Sequence Initialization Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Initialization Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Initialization Expression</em>' containment reference.
   * @see #setSequenceInitializationExpression(SequenceInitializationExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceElements_SequenceInitializationExpression()
   * @model containment="true"
   * @generated
   */
  SequenceInitializationExpression getSequenceInitializationExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceElements#getSequenceInitializationExpression <em>Sequence Initialization Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Initialization Expression</em>' containment reference.
   * @see #getSequenceInitializationExpression()
   * @generated
   */
  void setSequenceInitializationExpression(SequenceInitializationExpression value);

} // SequenceElements
