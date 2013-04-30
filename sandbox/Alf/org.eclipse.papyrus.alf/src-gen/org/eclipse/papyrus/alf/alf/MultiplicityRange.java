/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.MultiplicityRange#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.MultiplicityRange#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicityRange()
 * @model
 * @generated
 */
public interface MultiplicityRange extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' containment reference.
   * @see #setLower(INTEGER_LITERAL)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicityRange_Lower()
   * @model containment="true"
   * @generated
   */
  INTEGER_LITERAL getLower();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.MultiplicityRange#getLower <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' containment reference.
   * @see #getLower()
   * @generated
   */
  void setLower(INTEGER_LITERAL value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' containment reference.
   * @see #setUpper(UnlimitedNaturalLiteral)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicityRange_Upper()
   * @model containment="true"
   * @generated
   */
  UnlimitedNaturalLiteral getUpper();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.MultiplicityRange#getUpper <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' containment reference.
   * @see #getUpper()
   * @generated
   */
  void setUpper(UnlimitedNaturalLiteral value);

} // MultiplicityRange
