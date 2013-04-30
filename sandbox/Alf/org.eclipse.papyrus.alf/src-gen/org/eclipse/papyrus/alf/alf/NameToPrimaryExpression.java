/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name To Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getLinkOperationCompletion <em>Link Operation Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getClassExtentExpressionCompletion <em>Class Extent Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getBehaviorInvocation <em>Behavior Invocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToPrimaryExpression()
 * @model
 * @generated
 */
public interface NameToPrimaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Link Operation Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Link Operation Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Operation Completion</em>' containment reference.
   * @see #setLinkOperationCompletion(LinkOperationCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToPrimaryExpression_LinkOperationCompletion()
   * @model containment="true"
   * @generated
   */
  LinkOperationCompletion getLinkOperationCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getLinkOperationCompletion <em>Link Operation Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link Operation Completion</em>' containment reference.
   * @see #getLinkOperationCompletion()
   * @generated
   */
  void setLinkOperationCompletion(LinkOperationCompletion value);

  /**
   * Returns the value of the '<em><b>Class Extent Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Extent Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Extent Expression Completion</em>' containment reference.
   * @see #setClassExtentExpressionCompletion(ClassExtentExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToPrimaryExpression_ClassExtentExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  ClassExtentExpressionCompletion getClassExtentExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getClassExtentExpressionCompletion <em>Class Extent Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Extent Expression Completion</em>' containment reference.
   * @see #getClassExtentExpressionCompletion()
   * @generated
   */
  void setClassExtentExpressionCompletion(ClassExtentExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Sequence Construction Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Construction Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Construction Completion</em>' containment reference.
   * @see #setSequenceConstructionCompletion(SequenceConstructionExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToPrimaryExpression_SequenceConstructionCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionExpressionCompletion getSequenceConstructionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Construction Completion</em>' containment reference.
   * @see #getSequenceConstructionCompletion()
   * @generated
   */
  void setSequenceConstructionCompletion(SequenceConstructionExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Behavior Invocation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior Invocation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior Invocation</em>' containment reference.
   * @see #setBehaviorInvocation(BehaviorInvocation)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameToPrimaryExpression_BehaviorInvocation()
   * @model containment="true"
   * @generated
   */
  BehaviorInvocation getBehaviorInvocation();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameToPrimaryExpression#getBehaviorInvocation <em>Behavior Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Invocation</em>' containment reference.
   * @see #getBehaviorInvocation()
   * @generated
   */
  void setBehaviorInvocation(BehaviorInvocation value);

} // NameToPrimaryExpression
