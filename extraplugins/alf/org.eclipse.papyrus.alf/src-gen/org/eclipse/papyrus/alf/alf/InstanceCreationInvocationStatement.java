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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Invocation Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.InstanceCreationInvocationStatement#get_new <em>new</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationInvocationStatement()
 * @model
 * @generated
 */
public interface InstanceCreationInvocationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>new</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>new</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>new</em>' containment reference.
   * @see #set_new(InstanceCreationExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getInstanceCreationInvocationStatement__new()
   * @model containment="true"
   * @generated
   */
  InstanceCreationExpression get_new();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.InstanceCreationInvocationStatement#get_new <em>new</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>new</em>' containment reference.
   * @see #get_new()
   * @generated
   */
  void set_new(InstanceCreationExpression value);

} // InstanceCreationInvocationStatement
