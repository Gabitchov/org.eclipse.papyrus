/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getTypePart <em>Type Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDeclaration()
 * @model
 * @generated
 */
public interface ActivityDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Template Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Parameters</em>' containment reference.
   * @see #setTemplateParameters(TemplateParameters)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDeclaration_TemplateParameters()
   * @model containment="true"
   * @generated
   */
  TemplateParameters getTemplateParameters();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getTemplateParameters <em>Template Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template Parameters</em>' containment reference.
   * @see #getTemplateParameters()
   * @generated
   */
  void setTemplateParameters(TemplateParameters value);

  /**
   * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameters</em>' containment reference.
   * @see #setFormalParameters(FormalParameters)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDeclaration_FormalParameters()
   * @model containment="true"
   * @generated
   */
  FormalParameters getFormalParameters();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameters</em>' containment reference.
   * @see #getFormalParameters()
   * @generated
   */
  void setFormalParameters(FormalParameters value);

  /**
   * Returns the value of the '<em><b>Type Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Part</em>' containment reference.
   * @see #setTypePart(TypePart)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDeclaration_TypePart()
   * @model containment="true"
   * @generated
   */
  TypePart getTypePart();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDeclaration#getTypePart <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Part</em>' containment reference.
   * @see #getTypePart()
   * @generated
   */
  void setTypePart(TypePart value);

} // ActivityDeclaration
