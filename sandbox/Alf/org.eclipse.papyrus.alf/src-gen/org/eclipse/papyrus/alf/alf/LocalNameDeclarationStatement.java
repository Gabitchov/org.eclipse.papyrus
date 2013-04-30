/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Name Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationStatement()
 * @model
 * @generated
 */
public interface LocalNameDeclarationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationStatement_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' containment reference.
   * @see #setTypeName(TypeName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationStatement_TypeName()
   * @model containment="true"
   * @generated
   */
  TypeName getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(TypeName value);

  /**
   * Returns the value of the '<em><b>Multiplicity Indicator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity Indicator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity Indicator</em>' containment reference.
   * @see #setMultiplicityIndicator(MultiplicityIndicator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationStatement_MultiplicityIndicator()
   * @model containment="true"
   * @generated
   */
  MultiplicityIndicator getMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getMultiplicityIndicator <em>Multiplicity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' containment reference.
   * @see #getMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(MultiplicityIndicator value);

  /**
   * Returns the value of the '<em><b>Local Name Declaration Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Name Declaration Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Name Declaration Completion</em>' containment reference.
   * @see #setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLocalNameDeclarationStatement_LocalNameDeclarationCompletion()
   * @model containment="true"
   * @generated
   */
  LocalNameDeclarationStatementCompletion getLocalNameDeclarationCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Name Declaration Completion</em>' containment reference.
   * @see #getLocalNameDeclarationCompletion()
   * @generated
   */
  void setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion value);

} // LocalNameDeclarationStatement
