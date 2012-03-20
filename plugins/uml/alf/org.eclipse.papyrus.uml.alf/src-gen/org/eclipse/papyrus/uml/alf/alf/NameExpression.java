/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPrefixOp <em>Prefix Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getInvocationCompletion <em>Invocation Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPostfixOp <em>Postfix Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression()
 * @model
 * @generated
 */
public interface NameExpression extends ValueSpecification, NonLiteralValueSpecification
{
  /**
   * Returns the value of the '<em><b>Prefix Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix Op</em>' attribute.
   * @see #setPrefixOp(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_PrefixOp()
   * @model
   * @generated
   */
  String getPrefixOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPrefixOp <em>Prefix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix Op</em>' attribute.
   * @see #getPrefixOp()
   * @generated
   */
  void setPrefixOp(String value);

  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(QualifiedNamePath)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_Path()
   * @model containment="true"
   * @generated
   */
  QualifiedNamePath getPath();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(QualifiedNamePath value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Invocation Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocation Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocation Completion</em>' containment reference.
   * @see #setInvocationCompletion(Tuple)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_InvocationCompletion()
   * @model containment="true"
   * @generated
   */
  Tuple getInvocationCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getInvocationCompletion <em>Invocation Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invocation Completion</em>' containment reference.
   * @see #getInvocationCompletion()
   * @generated
   */
  void setInvocationCompletion(Tuple value);

  /**
   * Returns the value of the '<em><b>Sequence Construction Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Construction Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Construction Completion</em>' containment reference.
   * @see #setSequenceConstructionCompletion(SequenceConstructionOrAccessCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_SequenceConstructionCompletion()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionOrAccessCompletion getSequenceConstructionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Construction Completion</em>' containment reference.
   * @see #getSequenceConstructionCompletion()
   * @generated
   */
  void setSequenceConstructionCompletion(SequenceConstructionOrAccessCompletion value);

  /**
   * Returns the value of the '<em><b>Postfix Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postfix Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Op</em>' attribute.
   * @see #setPostfixOp(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_PostfixOp()
   * @model
   * @generated
   */
  String getPostfixOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getPostfixOp <em>Postfix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Op</em>' attribute.
   * @see #getPostfixOp()
   * @generated
   */
  void setPostfixOp(String value);

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
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNameExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  SuffixExpression getSuffix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression#getSuffix <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suffix</em>' containment reference.
   * @see #getSuffix()
   * @generated
   */
  void setSuffix(SuffixExpression value);

} // NameExpression
