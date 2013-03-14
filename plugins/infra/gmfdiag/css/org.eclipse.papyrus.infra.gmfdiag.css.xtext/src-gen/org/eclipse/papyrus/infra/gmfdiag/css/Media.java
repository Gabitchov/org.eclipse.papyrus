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
 * A representation of the model object '<em><b>Media</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Media#getMedia <em>Media</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Media#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getMedia()
 * @model
 * @generated
 */
public interface Media extends Content
{
  /**
   * Returns the value of the '<em><b>Media</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Media</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Media</em>' attribute list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getMedia_Media()
   * @model unique="false"
   * @generated
   */
  EList<String> getMedia();

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getMedia_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Ruleset> getRules();

} // Media
