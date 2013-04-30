/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packaged Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackagedElement#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackagedElement#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackagedElement#getImportVisibilityIndicator <em>Import Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackagedElement#getPackagedElementDefinition <em>Packaged Element Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackagedElement()
 * @model
 * @generated
 */
public interface PackagedElement extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackagedElement_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackagedElement#getComment <em>Comment</em>}' attribute.
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackagedElement_StereotypeAnnotations()
   * @model containment="true"
   * @generated
   */
  StereotypeAnnotations getStereotypeAnnotations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackagedElement#getStereotypeAnnotations <em>Stereotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype Annotations</em>' containment reference.
   * @see #getStereotypeAnnotations()
   * @generated
   */
  void setStereotypeAnnotations(StereotypeAnnotations value);

  /**
   * Returns the value of the '<em><b>Import Visibility Indicator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Visibility Indicator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Visibility Indicator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator
   * @see #setImportVisibilityIndicator(ImportVisibilityIndicator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackagedElement_ImportVisibilityIndicator()
   * @model
   * @generated
   */
  ImportVisibilityIndicator getImportVisibilityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackagedElement#getImportVisibilityIndicator <em>Import Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Visibility Indicator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator
   * @see #getImportVisibilityIndicator()
   * @generated
   */
  void setImportVisibilityIndicator(ImportVisibilityIndicator value);

  /**
   * Returns the value of the '<em><b>Packaged Element Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packaged Element Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packaged Element Definition</em>' containment reference.
   * @see #setPackagedElementDefinition(PackagedElementDefinition)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackagedElement_PackagedElementDefinition()
   * @model containment="true"
   * @generated
   */
  PackagedElementDefinition getPackagedElementDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackagedElement#getPackagedElementDefinition <em>Packaged Element Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Packaged Element Definition</em>' containment reference.
   * @see #getPackagedElementDefinition()
   * @generated
   */
  void setPackagedElementDefinition(PackagedElementDefinition value);

} // PackagedElement
