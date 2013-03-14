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
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Page#getPseudo <em>Pseudo</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Page#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPage()
 * @model
 * @generated
 */
public interface Page extends Content
{
  /**
   * Returns the value of the '<em><b>Pseudo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pseudo</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pseudo</em>' containment reference.
   * @see #setPseudo(PseudoPage)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPage_Pseudo()
   * @model containment="true"
   * @generated
   */
  PseudoPage getPseudo();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Page#getPseudo <em>Pseudo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pseudo</em>' containment reference.
   * @see #getPseudo()
   * @generated
   */
  void setPseudo(PseudoPage value);

  /**
   * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarations</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPage_Declarations()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getDeclarations();

} // Page
