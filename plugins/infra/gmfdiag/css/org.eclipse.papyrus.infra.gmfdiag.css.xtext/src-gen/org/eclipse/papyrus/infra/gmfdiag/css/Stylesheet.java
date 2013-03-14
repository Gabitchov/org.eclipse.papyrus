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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stylesheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getCharset <em>Charset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getStylesheet()
 * @model
 * @generated
 */
public interface Stylesheet extends EObject
{
  /**
   * Returns the value of the '<em><b>Charset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Charset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Charset</em>' attribute.
   * @see #setCharset(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getStylesheet_Charset()
   * @model
   * @generated
   */
  String getCharset();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet#getCharset <em>Charset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Charset</em>' attribute.
   * @see #getCharset()
   * @generated
   */
  void setCharset(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getStylesheet_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Content}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getStylesheet_Contents()
   * @model containment="true"
   * @generated
   */
  EList<Content> getContents();

} // Stylesheet
