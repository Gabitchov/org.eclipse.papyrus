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
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getMedia <em>Media</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(String)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getImport_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

  /**
   * Returns the value of the '<em><b>Uri</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' containment reference.
   * @see #setUri(Uri)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getImport_Uri()
   * @model containment="true"
   * @generated
   */
  Uri getUri();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Import#getUri <em>Uri</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' containment reference.
   * @see #getUri()
   * @generated
   */
  void setUri(Uri value);

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
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getImport_Media()
   * @model unique="false"
   * @generated
   */
  EList<String> getMedia();

} // Import
