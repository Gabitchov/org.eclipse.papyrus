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
 * A representation of the model object '<em><b>Classification To Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationToClause#getQualifiedNameList <em>Qualified Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationToClause()
 * @model
 * @generated
 */
public interface ClassificationToClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Qualified Name List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name List</em>' containment reference.
   * @see #setQualifiedNameList(QualifiedNameList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationToClause_QualifiedNameList()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getQualifiedNameList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationToClause#getQualifiedNameList <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name List</em>' containment reference.
   * @see #getQualifiedNameList()
   * @generated
   */
  void setQualifiedNameList(QualifiedNameList value);

} // ClassificationToClause
