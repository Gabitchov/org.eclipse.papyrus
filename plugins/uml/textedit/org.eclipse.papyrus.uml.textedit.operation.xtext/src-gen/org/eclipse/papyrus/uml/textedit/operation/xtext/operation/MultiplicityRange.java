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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getMultiplicityRange()
 * @model
 * @generated
 */
public interface MultiplicityRange extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' containment reference.
   * @see #setLower(NUMBER_LITERAL_WITHOUT_SUFFIX)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getMultiplicityRange_Lower()
   * @model containment="true"
   * @generated
   */
  NUMBER_LITERAL_WITHOUT_SUFFIX getLower();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getLower <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' containment reference.
   * @see #getLower()
   * @generated
   */
  void setLower(NUMBER_LITERAL_WITHOUT_SUFFIX value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' containment reference.
   * @see #setUpper(NUMBER_LITERAL_WITHOUT_SUFFIX)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getMultiplicityRange_Upper()
   * @model containment="true"
   * @generated
   */
  NUMBER_LITERAL_WITHOUT_SUFFIX getUpper();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange#getUpper <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' containment reference.
   * @see #getUpper()
   * @generated
   */
  void setUpper(NUMBER_LITERAL_WITHOUT_SUFFIX value);

} // MultiplicityRange
