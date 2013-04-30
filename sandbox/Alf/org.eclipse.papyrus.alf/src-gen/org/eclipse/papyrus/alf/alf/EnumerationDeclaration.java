/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationDeclaration#getSpecializationClause <em>Specialization Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDeclaration()
 * @model
 * @generated
 */
public interface EnumerationDeclaration extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Specialization Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specialization Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specialization Clause</em>' containment reference.
   * @see #setSpecializationClause(SpecializationClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationDeclaration_SpecializationClause()
   * @model containment="true"
   * @generated
   */
  SpecializationClause getSpecializationClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.EnumerationDeclaration#getSpecializationClause <em>Specialization Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specialization Clause</em>' containment reference.
   * @see #getSpecializationClause()
   * @generated
   */
  void setSpecializationClause(SpecializationClause value);

} // EnumerationDeclaration
