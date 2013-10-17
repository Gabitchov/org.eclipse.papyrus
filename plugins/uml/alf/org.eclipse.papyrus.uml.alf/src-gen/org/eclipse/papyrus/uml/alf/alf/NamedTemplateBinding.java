/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding#getFormal <em>Formal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNamedTemplateBinding()
 * @model
 * @generated
 */
public interface NamedTemplateBinding extends EObject
{
  /**
   * Returns the value of the '<em><b>Formal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal</em>' attribute.
   * @see #setFormal(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNamedTemplateBinding_Formal()
   * @model
   * @generated
   */
  String getFormal();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding#getFormal <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal</em>' attribute.
   * @see #getFormal()
   * @generated
   */
  void setFormal(String value);

  /**
   * Returns the value of the '<em><b>Actual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual</em>' containment reference.
   * @see #setActual(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getNamedTemplateBinding_Actual()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getActual();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding#getActual <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual</em>' containment reference.
   * @see #getActual()
   * @generated
   */
  void setActual(QualifiedNameWithBinding value);

} // NamedTemplateBinding
