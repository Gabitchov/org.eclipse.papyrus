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
package org.eclipse.papyrus.infra.gmfdiag.css.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.css.Combinator;
import org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Selector;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl#getCombinator <em>Combinator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.CompositeSelectorImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeSelectorImpl extends SelectorImpl implements CompositeSelector
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected SimpleSelector left;

  /**
   * The cached value of the '{@link #getCombinator() <em>Combinator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCombinator()
   * @generated
   * @ordered
   */
  protected Combinator combinator;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected Selector right;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositeSelectorImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CssPackage.Literals.COMPOSITE_SELECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleSelector getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(SimpleSelector newLeft, NotificationChain msgs)
  {
    SimpleSelector oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(SimpleSelector newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combinator getCombinator()
  {
    return combinator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCombinator(Combinator newCombinator, NotificationChain msgs)
  {
    Combinator oldCombinator = combinator;
    combinator = newCombinator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__COMBINATOR, oldCombinator, newCombinator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCombinator(Combinator newCombinator)
  {
    if (newCombinator != combinator)
    {
      NotificationChain msgs = null;
      if (combinator != null)
        msgs = ((InternalEObject)combinator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__COMBINATOR, null, msgs);
      if (newCombinator != null)
        msgs = ((InternalEObject)newCombinator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__COMBINATOR, null, msgs);
      msgs = basicSetCombinator(newCombinator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__COMBINATOR, newCombinator, newCombinator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(Selector newRight, NotificationChain msgs)
  {
    Selector oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__RIGHT, oldRight, newRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRight(Selector newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CssPackage.COMPOSITE_SELECTOR__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.COMPOSITE_SELECTOR__RIGHT, newRight, newRight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CssPackage.COMPOSITE_SELECTOR__LEFT:
        return basicSetLeft(null, msgs);
      case CssPackage.COMPOSITE_SELECTOR__COMBINATOR:
        return basicSetCombinator(null, msgs);
      case CssPackage.COMPOSITE_SELECTOR__RIGHT:
        return basicSetRight(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CssPackage.COMPOSITE_SELECTOR__LEFT:
        return getLeft();
      case CssPackage.COMPOSITE_SELECTOR__COMBINATOR:
        return getCombinator();
      case CssPackage.COMPOSITE_SELECTOR__RIGHT:
        return getRight();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CssPackage.COMPOSITE_SELECTOR__LEFT:
        setLeft((SimpleSelector)newValue);
        return;
      case CssPackage.COMPOSITE_SELECTOR__COMBINATOR:
        setCombinator((Combinator)newValue);
        return;
      case CssPackage.COMPOSITE_SELECTOR__RIGHT:
        setRight((Selector)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CssPackage.COMPOSITE_SELECTOR__LEFT:
        setLeft((SimpleSelector)null);
        return;
      case CssPackage.COMPOSITE_SELECTOR__COMBINATOR:
        setCombinator((Combinator)null);
        return;
      case CssPackage.COMPOSITE_SELECTOR__RIGHT:
        setRight((Selector)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CssPackage.COMPOSITE_SELECTOR__LEFT:
        return left != null;
      case CssPackage.COMPOSITE_SELECTOR__COMBINATOR:
        return combinator != null;
      case CssPackage.COMPOSITE_SELECTOR__RIGHT:
        return right != null;
    }
    return super.eIsSet(featureID);
  }

} //CompositeSelectorImpl
