/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList#getFormalParameter <em>Formal Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameterList()
 * @model
 * @generated
 */
public interface FormalParameterList extends EObject
{
  /**
   * Returns the value of the '<em><b>Formal Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameter</em>' containment reference list.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameterList_FormalParameter()
   * @model containment="true"
   * @generated
   */
  EList<FormalParameter> getFormalParameter();

} // FormalParameterList
