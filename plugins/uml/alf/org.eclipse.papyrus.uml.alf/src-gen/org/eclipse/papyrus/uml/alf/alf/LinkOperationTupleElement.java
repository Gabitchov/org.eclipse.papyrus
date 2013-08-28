/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getRoleIndex <em>Role Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLinkOperationTupleElement()
 * @model
 * @generated
 */
public interface LinkOperationTupleElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Role</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role</em>' attribute.
   * @see #setRole(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLinkOperationTupleElement_Role()
   * @model
   * @generated
   */
  String getRole();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getRole <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role</em>' attribute.
   * @see #getRole()
   * @generated
   */
  void setRole(String value);

  /**
   * Returns the value of the '<em><b>Role Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Index</em>' containment reference.
   * @see #setRoleIndex(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLinkOperationTupleElement_RoleIndex()
   * @model containment="true"
   * @generated
   */
  Expression getRoleIndex();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getRoleIndex <em>Role Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Index</em>' containment reference.
   * @see #getRoleIndex()
   * @generated
   */
  void setRoleIndex(Expression value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #setObject(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getLinkOperationTupleElement_Object()
   * @model containment="true"
   * @generated
   */
  Expression getObject();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #getObject()
   * @generated
   */
  void setObject(Expression value);

} // LinkOperationTupleElement
