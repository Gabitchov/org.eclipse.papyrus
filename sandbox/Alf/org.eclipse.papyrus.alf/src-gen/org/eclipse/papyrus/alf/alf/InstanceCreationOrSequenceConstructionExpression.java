/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Or Sequence Construction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getSequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getTuple <em>Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationOrSequenceConstructionExpression()
 * @model
 * @generated
 */
public interface InstanceCreationOrSequenceConstructionExpression extends BaseExpression
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationOrSequenceConstructionExpression_QualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Sequence Construction Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Construction Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Construction Expression Completion</em>' containment reference.
   * @see #setSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionExpressionCompletion getSequenceConstructionExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getSequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Construction Expression Completion</em>' containment reference.
   * @see #getSequenceConstructionExpressionCompletion()
   * @generated
   */
  void setSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(Tuple)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationOrSequenceConstructionExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  Tuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InstanceCreationOrSequenceConstructionExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(Tuple value);

} // InstanceCreationOrSequenceConstructionExpression
