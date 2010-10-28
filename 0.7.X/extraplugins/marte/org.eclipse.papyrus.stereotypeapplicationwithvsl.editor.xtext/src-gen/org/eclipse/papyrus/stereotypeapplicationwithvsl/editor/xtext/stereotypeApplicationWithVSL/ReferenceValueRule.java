/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Value Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ReferenceValueRule#getReferencedElement <em>Referenced Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getReferenceValueRule()
 * @model
 * @generated
 */
public interface ReferenceValueRule extends ValueRule
{
  /**
   * Returns the value of the '<em><b>Referenced Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Element</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Element</em>' reference.
   * @see #setReferencedElement(NamedElement)
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getReferenceValueRule_ReferencedElement()
   * @model
   * @generated
   */
  NamedElement getReferencedElement();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ReferenceValueRule#getReferencedElement <em>Referenced Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Element</em>' reference.
   * @see #getReferencedElement()
   * @generated
   */
  void setReferencedElement(NamedElement value);

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

} // ReferenceValueRule
