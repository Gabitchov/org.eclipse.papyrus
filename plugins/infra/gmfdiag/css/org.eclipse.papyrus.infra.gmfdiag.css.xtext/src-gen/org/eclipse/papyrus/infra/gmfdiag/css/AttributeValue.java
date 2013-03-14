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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getAttributeValue()
 * @model
 * @generated
 */
public interface AttributeValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP
   * @see #setOperator(ATTRIBUTE_OP)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getAttributeValue_Operator()
   * @model
   * @generated
   */
  ATTRIBUTE_OP getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP
   * @see #getOperator()
   * @generated
   */
  void setOperator(ATTRIBUTE_OP value);

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
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getAttributeValue_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // AttributeValue
