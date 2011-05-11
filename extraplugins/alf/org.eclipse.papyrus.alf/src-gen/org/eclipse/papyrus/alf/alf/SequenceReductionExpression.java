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
 * A representation of the model object '<em><b>Sequence Reduction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceReductionExpression()
 * @model
 * @generated
 */
public interface SequenceReductionExpression extends SuffixExpression
{
  /**
   * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Ordered</em>' attribute.
   * @see #setIsOrdered(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceReductionExpression_IsOrdered()
   * @model
   * @generated
   */
  boolean isIsOrdered();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#isIsOrdered <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Ordered</em>' attribute.
   * @see #isIsOrdered()
   * @generated
   */
  void setIsOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior</em>' containment reference.
   * @see #setBehavior(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceReductionExpression_Behavior()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getBehavior();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#getBehavior <em>Behavior</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior</em>' containment reference.
   * @see #getBehavior()
   * @generated
   */
  void setBehavior(QualifiedNameWithBinding value);

  /**
   * Returns the value of the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suffix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suffix</em>' containment reference.
   * @see #setSuffix(SuffixExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceReductionExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  SuffixExpression getSuffix();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceReductionExpression#getSuffix <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Suffix</em>' containment reference.
   * @see #getSuffix()
   * @generated
   */
  void setSuffix(SuffixExpression value);

} // SequenceReductionExpression
