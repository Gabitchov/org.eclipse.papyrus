/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassMember#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassMember#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassMember#getVisibilityIndicator <em>Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassMember#getClassMemberDefinition <em>Class Member Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassMember()
 * @model
 * @generated
 */
public interface ClassMember extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassMember_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassMember#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

  /**
   * Returns the value of the '<em><b>Stereotype Annotations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype Annotations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype Annotations</em>' containment reference.
   * @see #setStereotypeAnnotations(StereotypeAnnotations)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassMember_StereotypeAnnotations()
   * @model containment="true"
   * @generated
   */
  StereotypeAnnotations getStereotypeAnnotations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassMember#getStereotypeAnnotations <em>Stereotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype Annotations</em>' containment reference.
   * @see #getStereotypeAnnotations()
   * @generated
   */
  void setStereotypeAnnotations(StereotypeAnnotations value);

  /**
   * Returns the value of the '<em><b>Visibility Indicator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility Indicator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility Indicator</em>' containment reference.
   * @see #setVisibilityIndicator(VisibilityIndicator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassMember_VisibilityIndicator()
   * @model containment="true"
   * @generated
   */
  VisibilityIndicator getVisibilityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassMember#getVisibilityIndicator <em>Visibility Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility Indicator</em>' containment reference.
   * @see #getVisibilityIndicator()
   * @generated
   */
  void setVisibilityIndicator(VisibilityIndicator value);

  /**
   * Returns the value of the '<em><b>Class Member Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Member Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Member Definition</em>' containment reference.
   * @see #setClassMemberDefinition(ClassMemberDefinition)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassMember_ClassMemberDefinition()
   * @model containment="true"
   * @generated
   */
  ClassMemberDefinition getClassMemberDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassMember#getClassMemberDefinition <em>Class Member Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Member Definition</em>' containment reference.
   * @see #getClassMemberDefinition()
   * @generated
   */
  void setClassMemberDefinition(ClassMemberDefinition value);

} // ClassMember
