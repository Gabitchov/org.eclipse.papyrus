/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structured Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StructuredMember#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StructuredMember#getStreotypeAnnotations <em>Streotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StructuredMember#isIsPublic <em>Is Public</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StructuredMember#getPropertyDefinition <em>Property Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredMember()
 * @model
 * @generated
 */
public interface StructuredMember extends EObject
{
  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredMember_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StructuredMember#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

  /**
   * Returns the value of the '<em><b>Streotype Annotations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Streotype Annotations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Streotype Annotations</em>' containment reference.
   * @see #setStreotypeAnnotations(StereotypeAnnotations)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredMember_StreotypeAnnotations()
   * @model containment="true"
   * @generated
   */
  StereotypeAnnotations getStreotypeAnnotations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StructuredMember#getStreotypeAnnotations <em>Streotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Streotype Annotations</em>' containment reference.
   * @see #getStreotypeAnnotations()
   * @generated
   */
  void setStreotypeAnnotations(StereotypeAnnotations value);

  /**
   * Returns the value of the '<em><b>Is Public</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Public</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Public</em>' attribute.
   * @see #setIsPublic(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredMember_IsPublic()
   * @model
   * @generated
   */
  boolean isIsPublic();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StructuredMember#isIsPublic <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Public</em>' attribute.
   * @see #isIsPublic()
   * @generated
   */
  void setIsPublic(boolean value);

  /**
   * Returns the value of the '<em><b>Property Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Definition</em>' containment reference.
   * @see #setPropertyDefinition(PropertyDefinition)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredMember_PropertyDefinition()
   * @model containment="true"
   * @generated
   */
  PropertyDefinition getPropertyDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.StructuredMember#getPropertyDefinition <em>Property Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Definition</em>' containment reference.
   * @see #getPropertyDefinition()
   * @generated
   */
  void setPropertyDefinition(PropertyDefinition value);

} // StructuredMember
