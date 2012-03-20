/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collect Or Iterate Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getCollectOrIterateOperation()
 * @model
 * @generated
 */
public interface CollectOrIterateOperation extends SequenceExpansionExpression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperator
   * @see #setOp(CollectOrIterateOperator)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getCollectOrIterateOperation_Op()
   * @model
   * @generated
   */
  CollectOrIterateOperator getOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperator
   * @see #getOp()
   * @generated
   */
  void setOp(CollectOrIterateOperator value);

} // CollectOrIterateOperation
