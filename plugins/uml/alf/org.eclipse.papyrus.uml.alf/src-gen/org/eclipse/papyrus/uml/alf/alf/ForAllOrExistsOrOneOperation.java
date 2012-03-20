/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For All Or Exists Or One Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getForAllOrExistsOrOneOperation()
 * @model
 * @generated
 */
public interface ForAllOrExistsOrOneOperation extends SequenceExpansionExpression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperator
   * @see #setOp(ForAllOrExistsOrOneOperator)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getForAllOrExistsOrOneOperation_Op()
   * @model
   * @generated
   */
  ForAllOrExistsOrOneOperator getOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperator
   * @see #getOp()
   * @generated
   */
  void setOp(ForAllOrExistsOrOneOperator value);

} // ForAllOrExistsOrOneOperation
