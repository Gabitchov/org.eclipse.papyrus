/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getObjectOrRole <em>Object Or Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getRoleIndex <em>Role Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTupleElement()
 * @model
 * @generated
 */
public interface LinkOperationTupleElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Object Or Role</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Or Role</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Or Role</em>' attribute.
   * @see #setObjectOrRole(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTupleElement_ObjectOrRole()
   * @model
   * @generated
   */
  String getObjectOrRole();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getObjectOrRole <em>Object Or Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Or Role</em>' attribute.
   * @see #getObjectOrRole()
   * @generated
   */
  void setObjectOrRole(String value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTupleElement_RoleIndex()
   * @model containment="true"
   * @generated
   */
  Expression getRoleIndex();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getRoleIndex <em>Role Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Index</em>' containment reference.
   * @see #getRoleIndex()
   * @generated
   */
  void setRoleIndex(Expression value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' attribute.
   * @see #setObject(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTupleElement_Object()
   * @model
   * @generated
   */
  String getObject();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTupleElement#getObject <em>Object</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' attribute.
   * @see #getObject()
   * @generated
   */
  void setObject(String value);

} // LinkOperationTupleElement
