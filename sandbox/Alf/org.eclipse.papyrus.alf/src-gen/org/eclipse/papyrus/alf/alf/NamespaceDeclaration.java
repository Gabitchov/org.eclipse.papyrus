/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NamespaceDeclaration#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNamespaceDeclaration()
 * @model
 * @generated
 */
public interface NamespaceDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNamespaceDeclaration_QualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NamespaceDeclaration#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(QualifiedName value);

} // NamespaceDeclaration
