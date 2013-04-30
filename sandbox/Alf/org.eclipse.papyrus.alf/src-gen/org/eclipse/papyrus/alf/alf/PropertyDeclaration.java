/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#getTypePart <em>Type Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDeclaration()
 * @model
 * @generated
 */
public interface PropertyDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Composite</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Composite</em>' attribute.
   * @see #setIsComposite(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDeclaration_IsComposite()
   * @model
   * @generated
   */
  boolean isIsComposite();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#isIsComposite <em>Is Composite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Composite</em>' attribute.
   * @see #isIsComposite()
   * @generated
   */
  void setIsComposite(boolean value);

  /**
   * Returns the value of the '<em><b>Type Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Part</em>' containment reference.
   * @see #setTypePart(TypePart)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDeclaration_TypePart()
   * @model containment="true"
   * @generated
   */
  TypePart getTypePart();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PropertyDeclaration#getTypePart <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Part</em>' containment reference.
   * @see #getTypePart()
   * @generated
   */
  void setTypePart(TypePart value);

} // PropertyDeclaration
