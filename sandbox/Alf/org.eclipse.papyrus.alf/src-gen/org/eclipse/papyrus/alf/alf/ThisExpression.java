/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ThisExpression#getTuple <em>Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getThisExpression()
 * @model
 * @generated
 */
public interface ThisExpression extends BaseExpression
{
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getThisExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  Tuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ThisExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(Tuple value);

} // ThisExpression
