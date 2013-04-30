/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameBinding#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameBinding#getTemplateBinding <em>Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameBinding()
 * @model
 * @generated
 */
public interface NameBinding extends UnqualifiedName
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameBinding_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameBinding#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Template Binding</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Binding</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Binding</em>' containment reference.
   * @see #setTemplateBinding(TemplateBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameBinding_TemplateBinding()
   * @model containment="true"
   * @generated
   */
  TemplateBinding getTemplateBinding();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameBinding#getTemplateBinding <em>Template Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template Binding</em>' containment reference.
   * @see #getTemplateBinding()
   * @generated
   */
  void setTemplateBinding(TemplateBinding value);

} // NameBinding
