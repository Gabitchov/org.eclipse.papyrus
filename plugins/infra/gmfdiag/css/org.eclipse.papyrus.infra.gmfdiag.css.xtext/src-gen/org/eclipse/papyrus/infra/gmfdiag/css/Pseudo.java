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
 * A representation of the model object '<em><b>Pseudo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getPseudo <em>Pseudo</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPseudo()
 * @model
 * @generated
 */
public interface Pseudo extends SelectorCondition
{
  /**
   * Returns the value of the '<em><b>Pseudo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pseudo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pseudo</em>' attribute.
   * @see #setPseudo(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPseudo_Pseudo()
   * @model
   * @generated
   */
  String getPseudo();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getPseudo <em>Pseudo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pseudo</em>' attribute.
   * @see #getPseudo()
   * @generated
   */
  void setPseudo(String value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' attribute.
   * @see #setArgs(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getPseudo_Args()
   * @model
   * @generated
   */
  String getArgs();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Pseudo#getArgs <em>Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Args</em>' attribute.
   * @see #getArgs()
   * @generated
   */
  void setArgs(String value);

} // Pseudo
