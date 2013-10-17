/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.AccessCompletion#getAccessIndex <em>Access Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAccessCompletion()
 * @model
 * @generated
 */
public interface AccessCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Access Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access Index</em>' containment reference.
   * @see #setAccessIndex(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAccessCompletion_AccessIndex()
   * @model containment="true"
   * @generated
   */
  Expression getAccessIndex();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.AccessCompletion#getAccessIndex <em>Access Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access Index</em>' containment reference.
   * @see #getAccessIndex()
   * @generated
   */
  void setAccessIndex(Expression value);

} // AccessCompletion
