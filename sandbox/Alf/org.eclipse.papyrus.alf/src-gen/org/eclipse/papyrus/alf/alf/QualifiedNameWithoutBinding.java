/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name Without Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding#getUnqualified <em>Unqualified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding#getNameCompletion <em>Name Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getQualifiedNameWithoutBinding()
 * @model
 * @generated
 */
public interface QualifiedNameWithoutBinding extends EObject
{
  /**
   * Returns the value of the '<em><b>Unqualified</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unqualified</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unqualified</em>' containment reference.
   * @see #setUnqualified(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getQualifiedNameWithoutBinding_Unqualified()
   * @model containment="true"
   * @generated
   */
  Name getUnqualified();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding#getUnqualified <em>Unqualified</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unqualified</em>' containment reference.
   * @see #getUnqualified()
   * @generated
   */
  void setUnqualified(Name value);

  /**
   * Returns the value of the '<em><b>Name Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Completion</em>' containment reference.
   * @see #setNameCompletion(ColonQualifiedNameCompletionWithoutBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getQualifiedNameWithoutBinding_NameCompletion()
   * @model containment="true"
   * @generated
   */
  ColonQualifiedNameCompletionWithoutBinding getNameCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding#getNameCompletion <em>Name Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Completion</em>' containment reference.
   * @see #getNameCompletion()
   * @generated
   */
  void setNameCompletion(ColonQualifiedNameCompletionWithoutBinding value);

} // QualifiedNameWithoutBinding
