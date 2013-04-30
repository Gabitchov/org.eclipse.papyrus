/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptBlock#getAcceptClause <em>Accept Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptBlock#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptBlock()
 * @model
 * @generated
 */
public interface AcceptBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Accept Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accept Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accept Clause</em>' containment reference.
   * @see #setAcceptClause(AcceptClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptBlock_AcceptClause()
   * @model containment="true"
   * @generated
   */
  AcceptClause getAcceptClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptBlock#getAcceptClause <em>Accept Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accept Clause</em>' containment reference.
   * @see #getAcceptClause()
   * @generated
   */
  void setAcceptClause(AcceptClause value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptBlock_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptBlock#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // AcceptBlock
