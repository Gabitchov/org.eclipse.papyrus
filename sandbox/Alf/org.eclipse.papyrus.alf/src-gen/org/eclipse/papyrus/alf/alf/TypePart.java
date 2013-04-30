/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.TypePart#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.TypePart#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTypePart()
 * @model
 * @generated
 */
public interface TypePart extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' containment reference.
   * @see #setTypeName(TypeName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTypePart_TypeName()
   * @model containment="true"
   * @generated
   */
  TypeName getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.TypePart#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(TypeName value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(Multiplicity)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTypePart_Multiplicity()
   * @model containment="true"
   * @generated
   */
  Multiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.TypePart#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(Multiplicity value);

} // TypePart
