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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ruleset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl#getSelectors <em>Selectors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.RulesetImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RulesetImpl extends ContentImpl implements Ruleset
{
  /**
   * The cached value of the '{@link #getSelectors() <em>Selectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectors()
   * @generated
   * @ordered
   */
  protected EList<Selector> selectors;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Declaration> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RulesetImpl()
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
    return CssPackage.Literals.RULESET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Selector> getSelectors()
  {
    if (selectors == null)
    {
      selectors = new EObjectContainmentEList<Selector>(Selector.class, this, CssPackage.RULESET__SELECTORS);
    }
    return selectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Declaration> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<Declaration>(Declaration.class, this, CssPackage.RULESET__PROPERTIES);
    }
    return properties;
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
      case CssPackage.RULESET__SELECTORS:
        return ((InternalEList<?>)getSelectors()).basicRemove(otherEnd, msgs);
      case CssPackage.RULESET__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
      case CssPackage.RULESET__SELECTORS:
        return getSelectors();
      case CssPackage.RULESET__PROPERTIES:
        return getProperties();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CssPackage.RULESET__SELECTORS:
        getSelectors().clear();
        getSelectors().addAll((Collection<? extends Selector>)newValue);
        return;
      case CssPackage.RULESET__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Declaration>)newValue);
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
      case CssPackage.RULESET__SELECTORS:
        getSelectors().clear();
        return;
      case CssPackage.RULESET__PROPERTIES:
        getProperties().clear();
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
      case CssPackage.RULESET__SELECTORS:
        return selectors != null && !selectors.isEmpty();
      case CssPackage.RULESET__PROPERTIES:
        return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RulesetImpl
