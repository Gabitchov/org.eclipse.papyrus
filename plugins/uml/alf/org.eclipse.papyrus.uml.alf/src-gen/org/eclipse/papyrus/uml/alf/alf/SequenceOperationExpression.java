/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getTuple <em>Tuple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceOperationExpression()
 * @model
 * @generated
 */
public interface SequenceOperationExpression extends SuffixExpression
{
  /**
   * Returns the value of the '<em><b>Operation Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Name</em>' containment reference.
   * @see #setOperationName(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceOperationExpression_OperationName()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getOperationName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getOperationName <em>Operation Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Name</em>' containment reference.
   * @see #getOperationName()
   * @generated
   */
  void setOperationName(QualifiedNameWithBinding value);

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
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceOperationExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  Tuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(Tuple value);

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
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceOperationExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  SuffixExpression getSuffix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression#getSuffix <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suffix</em>' containment reference.
   * @see #getSuffix()
   * @generated
   */
  void setSuffix(SuffixExpression value);

} // SequenceOperationExpression
