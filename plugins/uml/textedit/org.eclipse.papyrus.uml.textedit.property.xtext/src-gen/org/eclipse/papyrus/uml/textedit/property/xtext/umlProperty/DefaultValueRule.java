/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Value Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getDefaultValueRule()
 * @model
 * @generated
 */
public interface DefaultValueRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #setDefault(String)
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getDefaultValueRule_Default()
   * @model
   * @generated
   */
  String getDefault();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule#getDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #getDefault()
   * @generated
   */
  void setDefault(String value);

} // DefaultValueRule
