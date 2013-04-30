/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Multiplicity#getMultiplicityRange <em>Multiplicity Range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsNonUnique <em>Is Non Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsSequence <em>Is Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicity()
 * @model
 * @generated
 */
public interface Multiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicity Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity Range</em>' containment reference.
   * @see #setMultiplicityRange(MultiplicityRange)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicity_MultiplicityRange()
   * @model containment="true"
   * @generated
   */
  MultiplicityRange getMultiplicityRange();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Multiplicity#getMultiplicityRange <em>Multiplicity Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Range</em>' containment reference.
   * @see #getMultiplicityRange()
   * @generated
   */
  void setMultiplicityRange(MultiplicityRange value);

  /**
   * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Ordered</em>' attribute.
   * @see #setIsOrdered(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicity_IsOrdered()
   * @model
   * @generated
   */
  boolean isIsOrdered();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsOrdered <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Ordered</em>' attribute.
   * @see #isIsOrdered()
   * @generated
   */
  void setIsOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Is Non Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Non Unique</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Non Unique</em>' attribute.
   * @see #setIsNonUnique(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicity_IsNonUnique()
   * @model
   * @generated
   */
  boolean isIsNonUnique();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsNonUnique <em>Is Non Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Non Unique</em>' attribute.
   * @see #isIsNonUnique()
   * @generated
   */
  void setIsNonUnique(boolean value);

  /**
   * Returns the value of the '<em><b>Is Sequence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Sequence</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Sequence</em>' attribute.
   * @see #setIsSequence(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getMultiplicity_IsSequence()
   * @model
   * @generated
   */
  boolean isIsSequence();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Multiplicity#isIsSequence <em>Is Sequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Sequence</em>' attribute.
   * @see #isIsSequence()
   * @generated
   */
  void setIsSequence(boolean value);

} // Multiplicity
