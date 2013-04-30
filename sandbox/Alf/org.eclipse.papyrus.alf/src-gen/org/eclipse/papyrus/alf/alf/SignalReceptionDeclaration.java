/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Reception Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration#getSignalName <em>Signal Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration#getSpecializationClause <em>Specialization Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDeclaration()
 * @model
 * @generated
 */
public interface SignalReceptionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Signal Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal Name</em>' containment reference.
   * @see #setSignalName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDeclaration_SignalName()
   * @model containment="true"
   * @generated
   */
  Name getSignalName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration#getSignalName <em>Signal Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal Name</em>' containment reference.
   * @see #getSignalName()
   * @generated
   */
  void setSignalName(Name value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSignalReceptionDeclaration_SpecializationClause()
   * @model containment="true"
   * @generated
   */
  SpecializationClause getSpecializationClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration#getSpecializationClause <em>Specialization Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specialization Clause</em>' containment reference.
   * @see #getSpecializationClause()
   * @generated
   */
  void setSpecializationClause(SpecializationClause value);

} // SignalReceptionDeclaration
