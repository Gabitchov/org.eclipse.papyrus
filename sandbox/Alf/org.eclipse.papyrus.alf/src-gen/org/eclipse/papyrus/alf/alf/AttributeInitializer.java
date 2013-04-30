/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AttributeInitializer#getInitializationExpression <em>Initialization Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAttributeInitializer()
 * @model
 * @generated
 */
public interface AttributeInitializer extends EObject
{
  /**
   * Returns the value of the '<em><b>Initialization Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initialization Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initialization Expression</em>' containment reference.
   * @see #setInitializationExpression(InitializationExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAttributeInitializer_InitializationExpression()
   * @model containment="true"
   * @generated
   */
  InitializationExpression getInitializationExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AttributeInitializer#getInitializationExpression <em>Initialization Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initialization Expression</em>' containment reference.
   * @see #getInitializationExpression()
   * @generated
   */
  void setInitializationExpression(InitializationExpression value);

} // AttributeInitializer
