/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Construction Or Access Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getAccessCompletion <em>Access Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getSequenceCompletion <em>Sequence Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionOrAccessCompletion()
 * @model
 * @generated
 */
public interface SequenceConstructionOrAccessCompletion extends EObject
{
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
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionOrAccessCompletion_MultiplicityIndicator()
   * @model
   * @generated
   */
  boolean isMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #isMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(boolean value);

  /**
   * Returns the value of the '<em><b>Access Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access Completion</em>' containment reference.
   * @see #setAccessCompletion(AccessCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionOrAccessCompletion_AccessCompletion()
   * @model containment="true"
   * @generated
   */
  AccessCompletion getAccessCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getAccessCompletion <em>Access Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access Completion</em>' containment reference.
   * @see #getAccessCompletion()
   * @generated
   */
  void setAccessCompletion(AccessCompletion value);

  /**
   * Returns the value of the '<em><b>Sequence Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Completion</em>' containment reference.
   * @see #setSequenceCompletion(PartialSequenceConstructionCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionOrAccessCompletion_SequenceCompletion()
   * @model containment="true"
   * @generated
   */
  PartialSequenceConstructionCompletion getSequenceCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getSequenceCompletion <em>Sequence Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Completion</em>' containment reference.
   * @see #getSequenceCompletion()
   * @generated
   */
  void setSequenceCompletion(PartialSequenceConstructionCompletion value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(SequenceConstructionExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getSequenceConstructionOrAccessCompletion_Expression()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(SequenceConstructionExpression value);

} // SequenceConstructionOrAccessCompletion
