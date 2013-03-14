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
import org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification From Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ClassificationFromClauseImpl#getQualifiedNameList <em>Qualified Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationFromClauseImpl extends MinimalEObjectImpl.Container implements ClassificationFromClause
{
  /**
   * The cached value of the '{@link #getQualifiedNameList() <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedNameList()
   * @generated
   * @ordered
   */
  protected QualifiedNameList qualifiedNameList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationFromClauseImpl()
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
    return AlfPackage.Literals.CLASSIFICATION_FROM_CLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList getQualifiedNameList()
  {
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedNameList(QualifiedNameList newQualifiedNameList, NotificationChain msgs)
  {
    QualifiedNameList oldQualifiedNameList = qualifiedNameList;
    qualifiedNameList = newQualifiedNameList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST, oldQualifiedNameList, newQualifiedNameList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifiedNameList(QualifiedNameList newQualifiedNameList)
  {
    if (newQualifiedNameList != qualifiedNameList)
    {
      NotificationChain msgs = null;
      if (qualifiedNameList != null)
        msgs = ((InternalEObject)qualifiedNameList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST, null, msgs);
      if (newQualifiedNameList != null)
        msgs = ((InternalEObject)newQualifiedNameList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST, null, msgs);
      msgs = basicSetQualifiedNameList(newQualifiedNameList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST, newQualifiedNameList, newQualifiedNameList));
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
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST:
        return basicSetQualifiedNameList(null, msgs);
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
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST:
        return getQualifiedNameList();
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
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)newValue);
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
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)null);
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
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST:
        return qualifiedNameList != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassificationFromClauseImpl
