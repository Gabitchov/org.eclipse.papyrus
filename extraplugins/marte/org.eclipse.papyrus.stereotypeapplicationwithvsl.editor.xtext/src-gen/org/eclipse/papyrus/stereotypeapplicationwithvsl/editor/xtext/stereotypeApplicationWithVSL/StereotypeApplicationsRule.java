/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Applications Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule#getStereotypeApplications <em>Stereotype Applications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getStereotypeApplicationsRule()
 * @model
 * @generated
 */
public interface StereotypeApplicationsRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Stereotype Applications</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype Applications</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype Applications</em>' containment reference list.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#getStereotypeApplicationsRule_StereotypeApplications()
   * @model containment="true"
   * @generated
   */
  EList<StereotypeApplicationRule> getStereotypeApplications();

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

} // StereotypeApplicationsRule
