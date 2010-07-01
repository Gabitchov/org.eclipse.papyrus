/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.property.editor.xtext.umlProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifier Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification()
 * @model
 * @generated
 */
public interface ModifierSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind
   * @see #setValue(ModifierKind)
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification_Value()
   * @model
   * @generated
   */
  ModifierKind getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind
   * @see #getValue()
   * @generated
   */
  void setValue(ModifierKind value);

} // ModifierSpecification
