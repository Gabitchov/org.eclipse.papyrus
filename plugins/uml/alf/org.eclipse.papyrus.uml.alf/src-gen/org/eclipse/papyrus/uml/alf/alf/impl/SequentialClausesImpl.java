/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.alf.SequentialClauses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequential Clauses</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequentialClausesImpl#getConccurentClauses <em>Conccurent Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequentialClausesImpl extends MinimalEObjectImpl.Container implements SequentialClauses
{
  /**
   * The cached value of the '{@link #getConccurentClauses() <em>Conccurent Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConccurentClauses()
   * @generated
   * @ordered
   */
  protected EList<ConcurrentClauses> conccurentClauses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequentialClausesImpl()
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
    return AlfPackage.Literals.SEQUENTIAL_CLAUSES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConcurrentClauses> getConccurentClauses()
  {
    if (conccurentClauses == null)
    {
      conccurentClauses = new EObjectContainmentEList<ConcurrentClauses>(ConcurrentClauses.class, this, AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES);
    }
    return conccurentClauses;
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES:
        return ((InternalEList<?>)getConccurentClauses()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES:
        return getConccurentClauses();
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES:
        getConccurentClauses().clear();
        getConccurentClauses().addAll((Collection<? extends ConcurrentClauses>)newValue);
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES:
        getConccurentClauses().clear();
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
      case AlfPackage.SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES:
        return conccurentClauses != null && !conccurentClauses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SequentialClausesImpl
