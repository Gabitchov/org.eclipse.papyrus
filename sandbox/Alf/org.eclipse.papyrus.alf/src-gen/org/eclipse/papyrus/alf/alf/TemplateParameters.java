/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.TemplateParameters#getClassifierTemplateParameter <em>Classifier Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTemplateParameters()
 * @model
 * @generated
 */
public interface TemplateParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Classifier Template Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ClassifierTemplateParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier Template Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier Template Parameter</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTemplateParameters_ClassifierTemplateParameter()
   * @model containment="true"
   * @generated
   */
  EList<ClassifierTemplateParameter> getClassifierTemplateParameter();

} // TemplateParameters
