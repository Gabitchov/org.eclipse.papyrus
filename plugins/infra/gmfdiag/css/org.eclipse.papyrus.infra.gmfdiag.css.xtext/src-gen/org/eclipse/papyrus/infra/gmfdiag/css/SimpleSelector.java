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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getSimpleSelector()
 * @model
 * @generated
 */
public interface SimpleSelector extends Selector
{
  /**
   * Returns the value of the '<em><b>Element Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Name</em>' attribute.
   * @see #setElementName(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getSimpleSelector_ElementName()
   * @model
   * @generated
   */
  String getElementName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector#getElementName <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Name</em>' attribute.
   * @see #getElementName()
   * @generated
   */
  void setElementName(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getSimpleSelector_Condition()
   * @model containment="true"
   * @generated
   */
  EList<SelectorCondition> getCondition();

} // SimpleSelector
