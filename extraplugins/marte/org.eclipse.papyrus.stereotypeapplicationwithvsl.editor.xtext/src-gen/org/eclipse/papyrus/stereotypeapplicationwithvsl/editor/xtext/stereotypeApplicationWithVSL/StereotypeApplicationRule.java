/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Application Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getTagSpecification <em>Tag Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getStereotypeApplicationRule()
 * @model
 * @generated
 */
public interface StereotypeApplicationRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' reference.
   * @see #setStereotype(Stereotype)
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getStereotypeApplicationRule_Stereotype()
   * @model
   * @generated
   */
  Stereotype getStereotype();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getStereotype <em>Stereotype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype</em>' reference.
   * @see #getStereotype()
   * @generated
   */
  void setStereotype(Stereotype value);

  /**
   * Returns the value of the '<em><b>Tag Specification</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag Specification</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag Specification</em>' containment reference list.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getStereotypeApplicationRule_TagSpecification()
   * @model containment="true"
   * @generated
   */
  EList<TagSpecificationRule> getTagSpecification();

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

} // StereotypeApplicationRule
