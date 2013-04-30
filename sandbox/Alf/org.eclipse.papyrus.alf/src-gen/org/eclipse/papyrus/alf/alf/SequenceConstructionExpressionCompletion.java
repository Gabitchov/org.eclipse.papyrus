/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Construction Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion#getMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion#getSequenceElements <em>Sequence Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionExpressionCompletion()
 * @model
 * @generated
 */
public interface SequenceConstructionExpressionCompletion extends EObject
{
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionExpressionCompletion_MultiplicityIndicator()
   * @model containment="true"
   * @generated
   */
  MultiplicityIndicator getMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion#getMultiplicityIndicator <em>Multiplicity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' containment reference.
   * @see #getMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(MultiplicityIndicator value);

  /**
   * Returns the value of the '<em><b>Sequence Elements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Elements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Elements</em>' containment reference.
   * @see #setSequenceElements(SequenceElements)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionExpressionCompletion_SequenceElements()
   * @model containment="true"
   * @generated
   */
  SequenceElements getSequenceElements();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion#getSequenceElements <em>Sequence Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Elements</em>' containment reference.
   * @see #getSequenceElements()
   * @generated
   */
  void setSequenceElements(SequenceElements value);

} // SequenceConstructionExpressionCompletion
