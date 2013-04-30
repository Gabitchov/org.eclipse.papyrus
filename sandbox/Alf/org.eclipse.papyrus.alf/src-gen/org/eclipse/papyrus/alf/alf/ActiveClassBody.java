/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Class Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActiveClassBody#getActiveClassMember <em>Active Class Member</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActiveClassBody#getBehaviorClasue <em>Behavior Clasue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassBody()
 * @model
 * @generated
 */
public interface ActiveClassBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Active Class Member</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ActiveClassMember}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active Class Member</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active Class Member</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassBody_ActiveClassMember()
   * @model containment="true"
   * @generated
   */
  EList<ActiveClassMember> getActiveClassMember();

  /**
   * Returns the value of the '<em><b>Behavior Clasue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior Clasue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior Clasue</em>' containment reference.
   * @see #setBehaviorClasue(BehaviorClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassBody_BehaviorClasue()
   * @model containment="true"
   * @generated
   */
  BehaviorClause getBehaviorClasue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActiveClassBody#getBehaviorClasue <em>Behavior Clasue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Clasue</em>' containment reference.
   * @see #getBehaviorClasue()
   * @generated
   */
  void setBehaviorClasue(BehaviorClause value);

} // ActiveClassBody
