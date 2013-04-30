/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixOperation#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOperation()
 * @model
 * @generated
 */
public interface PostfixOperation extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.AffixOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AffixOperator
   * @see #setOperator(AffixOperator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixOperation_Operator()
   * @model
   * @generated
   */
  AffixOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixOperation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.AffixOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AffixOperator value);

} // PostfixOperation
