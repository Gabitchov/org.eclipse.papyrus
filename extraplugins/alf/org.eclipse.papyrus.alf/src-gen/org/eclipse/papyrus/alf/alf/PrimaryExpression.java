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
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Prefix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix</em>' containment reference.
   * @see #setPrefix(ValueSpecification)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpression_Prefix()
   * @model containment="true"
   * @generated
   */
  ValueSpecification getPrefix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PrimaryExpression#getPrefix <em>Prefix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' containment reference.
   * @see #getPrefix()
   * @generated
   */
  void setPrefix(ValueSpecification value);

} // PrimaryExpression
