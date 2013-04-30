/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getTypePart <em>Type Part</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getRedefinitionClause <em>Redefinition Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration()
 * @model
 * @generated
 */
public interface OperationDeclaration extends OperationDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Abstract</em>' attribute.
   * @see #setIsAbstract(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_IsAbstract()
   * @model
   * @generated
   */
  boolean isIsAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#isIsAbstract <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Abstract</em>' attribute.
   * @see #isIsAbstract()
   * @generated
   */
  void setIsAbstract(boolean value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameters</em>' containment reference.
   * @see #setFormalParameters(FormalParameters)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_FormalParameters()
   * @model containment="true"
   * @generated
   */
  FormalParameters getFormalParameters();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameters</em>' containment reference.
   * @see #getFormalParameters()
   * @generated
   */
  void setFormalParameters(FormalParameters value);

  /**
   * Returns the value of the '<em><b>Type Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Part</em>' containment reference.
   * @see #setTypePart(TypePart)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_TypePart()
   * @model containment="true"
   * @generated
   */
  TypePart getTypePart();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getTypePart <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Part</em>' containment reference.
   * @see #getTypePart()
   * @generated
   */
  void setTypePart(TypePart value);

  /**
   * Returns the value of the '<em><b>Redefinition Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Redefinition Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Redefinition Clause</em>' containment reference.
   * @see #setRedefinitionClause(RedefinitionClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_RedefinitionClause()
   * @model containment="true"
   * @generated
   */
  RedefinitionClause getRedefinitionClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getRedefinitionClause <em>Redefinition Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Redefinition Clause</em>' containment reference.
   * @see #getRedefinitionClause()
   * @generated
   */
  void setRedefinitionClause(RedefinitionClause value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getOperationDeclaration_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.OperationDeclaration#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // OperationDeclaration
