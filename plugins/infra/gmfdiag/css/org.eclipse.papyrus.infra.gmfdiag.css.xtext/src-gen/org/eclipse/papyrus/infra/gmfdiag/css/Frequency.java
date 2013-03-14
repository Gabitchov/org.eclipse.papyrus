/*****************************************************************************
 * Copyright (c) 2012-2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frequency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getFrequency()
 * @model
 * @generated
 */
public interface Frequency extends Term
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference.
   * @see #setOp(UnaryOperator)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getFrequency_Op()
   * @model containment="true"
   * @generated
   */
  UnaryOperator getOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getOp <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' containment reference.
   * @see #getOp()
   * @generated
   */
  void setOp(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getFrequency_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' attribute.
   * @see #setUnit(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getFrequency_Unit()
   * @model
   * @generated
   */
  String getUnit();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Frequency#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see #getUnit()
   * @generated
   */
  void setUnit(String value);

} // Frequency
