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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.uml.alf.alf.SwitchDefaultClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Default Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SwitchDefaultClauseImpl#getStatementSequence <em>Statement Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchDefaultClauseImpl extends MinimalEObjectImpl.Container implements SwitchDefaultClause
{
  /**
   * The cached value of the '{@link #getStatementSequence() <em>Statement Sequence</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatementSequence()
   * @generated
   * @ordered
   */
  protected NonEmptyStatementSequence statementSequence;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SwitchDefaultClauseImpl()
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
    return AlfPackage.Literals.SWITCH_DEFAULT_CLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonEmptyStatementSequence getStatementSequence()
  {
    return statementSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatementSequence(NonEmptyStatementSequence newStatementSequence, NotificationChain msgs)
  {
    NonEmptyStatementSequence oldStatementSequence = statementSequence;
    statementSequence = newStatementSequence;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE, oldStatementSequence, newStatementSequence);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatementSequence(NonEmptyStatementSequence newStatementSequence)
  {
    if (newStatementSequence != statementSequence)
    {
      NotificationChain msgs = null;
      if (statementSequence != null)
        msgs = ((InternalEObject)statementSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE, null, msgs);
      if (newStatementSequence != null)
        msgs = ((InternalEObject)newStatementSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE, null, msgs);
      msgs = basicSetStatementSequence(newStatementSequence, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE, newStatementSequence, newStatementSequence));
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
      case AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE:
        return basicSetStatementSequence(null, msgs);
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
      case AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE:
        return getStatementSequence();
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
      case AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE:
        setStatementSequence((NonEmptyStatementSequence)newValue);
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
      case AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE:
        setStatementSequence((NonEmptyStatementSequence)null);
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
      case AlfPackage.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE:
        return statementSequence != null;
    }
    return super.eIsSet(featureID);
  }

} //SwitchDefaultClauseImpl
