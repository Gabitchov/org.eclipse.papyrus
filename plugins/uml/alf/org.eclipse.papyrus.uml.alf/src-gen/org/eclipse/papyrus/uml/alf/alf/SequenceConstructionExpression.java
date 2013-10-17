/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Construction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression#getSequenceElement <em>Sequence Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression#getRangeUpper <em>Range Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionExpression()
 * @model
 * @generated
 */
public interface SequenceConstructionExpression extends SequenceElement
{
  /**
   * Returns the value of the '<em><b>Sequence Element</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.uml.alf.alf.SequenceElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Element</em>' containment reference list.
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionExpression_SequenceElement()
   * @model containment="true"
   * @generated
   */
  EList<SequenceElement> getSequenceElement();

  /**
   * Returns the value of the '<em><b>Range Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range Upper</em>' containment reference.
   * @see #setRangeUpper(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionExpression_RangeUpper()
   * @model containment="true"
   * @generated
   */
  Expression getRangeUpper();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression#getRangeUpper <em>Range Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range Upper</em>' containment reference.
   * @see #getRangeUpper()
   * @generated
   */
  void setRangeUpper(Expression value);

} // SequenceConstructionExpression
