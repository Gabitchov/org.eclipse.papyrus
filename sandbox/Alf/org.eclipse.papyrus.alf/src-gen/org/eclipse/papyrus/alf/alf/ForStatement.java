/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ForStatement#getForControl <em>For Control</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ForStatement#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>For Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For Control</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For Control</em>' containment reference.
   * @see #setForControl(ForControl)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getForStatement_ForControl()
   * @model containment="true"
   * @generated
   */
  ForControl getForControl();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ForStatement#getForControl <em>For Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For Control</em>' containment reference.
   * @see #getForControl()
   * @generated
   */
  void setForControl(ForControl value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getForStatement_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ForStatement#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // ForStatement
