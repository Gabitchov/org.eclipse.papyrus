/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AliasDefinition#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAliasDefinition()
 * @model
 * @generated
 */
public interface AliasDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Alias</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' containment reference.
   * @see #setAlias(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAliasDefinition_Alias()
   * @model containment="true"
   * @generated
   */
  Name getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AliasDefinition#getAlias <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' containment reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(Name value);

} // AliasDefinition
