/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Or Assignement Or Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getTypePart_OR_assignedPart_OR_invocationPart <em>Type Part OR assigned Part OR invocation Part</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getVariableDeclarationCompletion <em>Variable Declaration Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getAssignmentCompletion <em>Assignment Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInvocationOrAssignementOrDeclarationStatement()
 * @model
 * @generated
 */
public interface InvocationOrAssignementOrDeclarationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Type Part OR assigned Part OR invocation Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Part OR assigned Part OR invocation Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Part OR assigned Part OR invocation Part</em>' containment reference.
   * @see #setTypePart_OR_assignedPart_OR_invocationPart(NameExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()
   * @model containment="true"
   * @generated
   */
  NameExpression getTypePart_OR_assignedPart_OR_invocationPart();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getTypePart_OR_assignedPart_OR_invocationPart <em>Type Part OR assigned Part OR invocation Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Part OR assigned Part OR invocation Part</em>' containment reference.
   * @see #getTypePart_OR_assignedPart_OR_invocationPart()
   * @generated
   */
  void setTypePart_OR_assignedPart_OR_invocationPart(NameExpression value);

  /**
   * Returns the value of the '<em><b>Variable Declaration Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Declaration Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Declaration Completion</em>' containment reference.
   * @see #setVariableDeclarationCompletion(VariableDeclarationCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletion()
   * @model containment="true"
   * @generated
   */
  VariableDeclarationCompletion getVariableDeclarationCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getVariableDeclarationCompletion <em>Variable Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Declaration Completion</em>' containment reference.
   * @see #getVariableDeclarationCompletion()
   * @generated
   */
  void setVariableDeclarationCompletion(VariableDeclarationCompletion value);

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
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()
   * @model containment="true"
   * @generated
   */
  AssignmentCompletion getAssignmentCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement#getAssignmentCompletion <em>Assignment Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment Completion</em>' containment reference.
   * @see #getAssignmentCompletion()
   * @generated
   */
  void setAssignmentCompletion(AssignmentCompletion value);

} // InvocationOrAssignementOrDeclarationStatement
