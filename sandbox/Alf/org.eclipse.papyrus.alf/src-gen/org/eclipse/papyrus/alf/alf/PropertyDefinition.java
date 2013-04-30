/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PropertyDefinition#getPropertyDeclaration <em>Property Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Declaration</em>' containment reference.
   * @see #setPropertyDeclaration(PropertyDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPropertyDefinition_PropertyDeclaration()
   * @model containment="true"
   * @generated
   */
  PropertyDeclaration getPropertyDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PropertyDefinition#getPropertyDeclaration <em>Property Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Declaration</em>' containment reference.
   * @see #getPropertyDeclaration()
   * @generated
   */
  void setPropertyDeclaration(PropertyDeclaration value);

} // PropertyDefinition
