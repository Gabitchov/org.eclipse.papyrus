/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AttributeDefinition#getPropertyDeclaration <em>Property Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AttributeDefinition#getAttributeInitializer <em>Attribute Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAttributeDefinition()
 * @model
 * @generated
 */
public interface AttributeDefinition extends FeatureDefinitionOrStub
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAttributeDefinition_PropertyDeclaration()
   * @model containment="true"
   * @generated
   */
  PropertyDeclaration getPropertyDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AttributeDefinition#getPropertyDeclaration <em>Property Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Declaration</em>' containment reference.
   * @see #getPropertyDeclaration()
   * @generated
   */
  void setPropertyDeclaration(PropertyDeclaration value);

  /**
   * Returns the value of the '<em><b>Attribute Initializer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Initializer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Initializer</em>' containment reference.
   * @see #setAttributeInitializer(AttributeInitializer)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAttributeDefinition_AttributeInitializer()
   * @model containment="true"
   * @generated
   */
  AttributeInitializer getAttributeInitializer();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AttributeDefinition#getAttributeInitializer <em>Attribute Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Initializer</em>' containment reference.
   * @see #getAttributeInitializer()
   * @generated
   */
  void setAttributeInitializer(AttributeInitializer value);

} // AttributeDefinition
