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
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression#getSubterms <em>Subterms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Terms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Terms</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terms</em>' containment reference.
   * @see #setTerms(Term)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getExpression_Terms()
   * @model containment="true"
   * @generated
   */
  Term getTerms();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.Expression#getTerms <em>Terms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Terms</em>' containment reference.
   * @see #getTerms()
   * @generated
   */
  void setTerms(Term value);

  /**
   * Returns the value of the '<em><b>Subterms</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Subterm}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subterms</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subterms</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getExpression_Subterms()
   * @model containment="true"
   * @generated
   */
  EList<Subterm> getSubterms();

} // Expression
