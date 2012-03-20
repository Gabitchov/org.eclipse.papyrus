/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Invocation Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement#get_this <em>this</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement#getAssignmentCompletion <em>Assignment Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getThisInvocationStatement()
 * @model
 * @generated
 */
public interface ThisInvocationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>this</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>this</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>this</em>' containment reference.
   * @see #set_this(ThisExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getThisInvocationStatement__this()
   * @model containment="true"
   * @generated
   */
  ThisExpression get_this();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement#get_this <em>this</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>this</em>' containment reference.
   * @see #get_this()
   * @generated
   */
  void set_this(ThisExpression value);

  /**
   * Returns the value of the '<em><b>Assignment Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment Completion</em>' containment reference.
   * @see #setAssignmentCompletion(AssignmentCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getThisInvocationStatement_AssignmentCompletion()
   * @model containment="true"
   * @generated
   */
  AssignmentCompletion getAssignmentCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement#getAssignmentCompletion <em>Assignment Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment Completion</em>' containment reference.
   * @see #getAssignmentCompletion()
   * @generated
   */
  void setAssignmentCompletion(AssignmentCompletion value);

} // ThisInvocationStatement
