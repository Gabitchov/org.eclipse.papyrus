/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getTuple <em>Tuple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getSequenceConstuctionCompletion <em>Sequence Constuction Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationExpression()
 * @model
 * @generated
 */
public interface InstanceCreationExpression extends ValueSpecification, NonLiteralValueSpecification
{
  /**
   * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constructor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constructor</em>' containment reference.
   * @see #setConstructor(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationExpression_Constructor()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getConstructor();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getConstructor <em>Constructor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constructor</em>' containment reference.
   * @see #getConstructor()
   * @generated
   */
  void setConstructor(QualifiedNameWithBinding value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(InstanceCreationTuple)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  InstanceCreationTuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(InstanceCreationTuple value);

  /**
   * Returns the value of the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suffix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suffix</em>' containment reference.
   * @see #setSuffix(SuffixExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  SuffixExpression getSuffix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getSuffix <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suffix</em>' containment reference.
   * @see #getSuffix()
   * @generated
   */
  void setSuffix(SuffixExpression value);

  /**
   * Returns the value of the '<em><b>Sequence Constuction Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Constuction Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Constuction Completion</em>' containment reference.
   * @see #setSequenceConstuctionCompletion(SequenceConstructionCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationExpression_SequenceConstuctionCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionCompletion getSequenceConstuctionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression#getSequenceConstuctionCompletion <em>Sequence Constuction Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Constuction Completion</em>' containment reference.
   * @see #getSequenceConstuctionCompletion()
   * @generated
   */
  void setSequenceConstuctionCompletion(SequenceConstructionCompletion value);

} // InstanceCreationExpression
