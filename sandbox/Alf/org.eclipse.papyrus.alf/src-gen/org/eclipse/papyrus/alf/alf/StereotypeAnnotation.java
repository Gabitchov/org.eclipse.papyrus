/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotation#getStereotypeName <em>Stereotype Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotation#getTaggedValues <em>Tagged Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStereotypeAnnotation()
 * @model
 * @generated
 */
public interface StereotypeAnnotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Stereotype Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype Name</em>' containment reference.
   * @see #setStereotypeName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStereotypeAnnotation_StereotypeName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getStereotypeName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotation#getStereotypeName <em>Stereotype Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype Name</em>' containment reference.
   * @see #getStereotypeName()
   * @generated
   */
  void setStereotypeName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Tagged Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Values</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Values</em>' containment reference.
   * @see #setTaggedValues(TaggedValues)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStereotypeAnnotation_TaggedValues()
   * @model containment="true"
   * @generated
   */
  TaggedValues getTaggedValues();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StereotypeAnnotation#getTaggedValues <em>Tagged Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tagged Values</em>' containment reference.
   * @see #getTaggedValues()
   * @generated
   */
  void setTaggedValues(TaggedValues value);

} // StereotypeAnnotation
