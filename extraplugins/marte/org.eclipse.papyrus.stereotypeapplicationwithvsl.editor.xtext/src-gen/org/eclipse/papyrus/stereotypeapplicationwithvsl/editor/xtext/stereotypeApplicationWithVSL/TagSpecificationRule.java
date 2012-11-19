/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Specification Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getTagSpecificationRule()
 * @model
 * @generated
 */
public interface TagSpecificationRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(Property)
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getTagSpecificationRule_Property()
   * @model
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ExpressionValueRule)
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getTagSpecificationRule_Value()
   * @model containment="true"
   * @generated
   */
  ExpressionValueRule getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ExpressionValueRule value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getExpectedType(this) ;'"
   * @generated
   */
  Type getExpectedType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.ContextUtil.getContextElement(this) ;'"
   * @generated
   */
  Element getContextElement();

} // TagSpecificationRule
