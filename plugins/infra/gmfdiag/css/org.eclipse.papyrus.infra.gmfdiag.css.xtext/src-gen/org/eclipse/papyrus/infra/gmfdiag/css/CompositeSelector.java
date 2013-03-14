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
 * A representation of the model object '<em><b>Composite Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getCombinator <em>Combinator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getCompositeSelector()
 * @model
 * @generated
 */
public interface CompositeSelector extends Selector
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(SimpleSelector)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getCompositeSelector_Left()
   * @model containment="true"
   * @generated
   */
  SimpleSelector getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(SimpleSelector value);

  /**
   * Returns the value of the '<em><b>Combinator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Combinator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Combinator</em>' containment reference.
   * @see #setCombinator(Combinator)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getCompositeSelector_Combinator()
   * @model containment="true"
   * @generated
   */
  Combinator getCombinator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getCombinator <em>Combinator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Combinator</em>' containment reference.
   * @see #getCombinator()
   * @generated
   */
  void setCombinator(Combinator value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Selector)
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getCompositeSelector_Right()
   * @model containment="true"
   * @generated
   */
  Selector getRight();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Selector value);

} // CompositeSelector
