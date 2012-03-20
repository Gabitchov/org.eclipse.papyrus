/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Name Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLocalNameDeclarationStatement()
 * @model
 * @generated
 */
public interface LocalNameDeclarationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Var Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Name</em>' attribute.
   * @see #setVarName(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLocalNameDeclarationStatement_VarName()
   * @model
   * @generated
   */
  String getVarName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getVarName <em>Var Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Name</em>' attribute.
   * @see #getVarName()
   * @generated
   */
  void setVarName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLocalNameDeclarationStatement_Type()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(QualifiedNameWithBinding value);

  /**
   * Returns the value of the '<em><b>Multiplicity Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity Indicator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #setMultiplicityIndicator(boolean)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLocalNameDeclarationStatement_MultiplicityIndicator()
   * @model
   * @generated
   */
  boolean isMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#isMultiplicityIndicator <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #isMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(boolean value);

  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(SequenceElement)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLocalNameDeclarationStatement_Init()
   * @model containment="true"
   * @generated
   */
  SequenceElement getInit();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(SequenceElement value);

} // LocalNameDeclarationStatement
