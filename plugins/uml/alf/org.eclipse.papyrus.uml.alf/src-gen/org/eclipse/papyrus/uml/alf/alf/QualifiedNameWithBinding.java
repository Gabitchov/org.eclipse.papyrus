/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name With Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getRemaining <em>Remaining</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNameWithBinding()
 * @model
 * @generated
 */
public interface QualifiedNameWithBinding extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNameWithBinding_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Binding</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binding</em>' containment reference.
   * @see #setBinding(TemplateBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNameWithBinding_Binding()
   * @model containment="true"
   * @generated
   */
  TemplateBinding getBinding();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getBinding <em>Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binding</em>' containment reference.
   * @see #getBinding()
   * @generated
   */
  void setBinding(TemplateBinding value);

  /**
   * Returns the value of the '<em><b>Remaining</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Remaining</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Remaining</em>' containment reference.
   * @see #setRemaining(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNameWithBinding_Remaining()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getRemaining();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding#getRemaining <em>Remaining</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Remaining</em>' containment reference.
   * @see #getRemaining()
   * @generated
   */
  void setRemaining(QualifiedNameWithBinding value);

} // QualifiedNameWithBinding
