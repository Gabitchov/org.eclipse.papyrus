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
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name With Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.QualifiedNameWithBindingImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.QualifiedNameWithBindingImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.QualifiedNameWithBindingImpl#getRemaining <em>Remaining</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedNameWithBindingImpl extends MinimalEObjectImpl.Container implements QualifiedNameWithBinding
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getBinding() <em>Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinding()
   * @generated
   * @ordered
   */
  protected TemplateBinding binding;

  /**
   * The cached value of the '{@link #getRemaining() <em>Remaining</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRemaining()
   * @generated
   * @ordered
   */
  protected QualifiedNameWithBinding remaining;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNameWithBindingImpl()
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
    return AlfPackage.Literals.QUALIFIED_NAME_WITH_BINDING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITH_BINDING__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBinding getBinding()
  {
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBinding(TemplateBinding newBinding, NotificationChain msgs)
  {
    TemplateBinding oldBinding = binding;
    binding = newBinding;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING, oldBinding, newBinding);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBinding(TemplateBinding newBinding)
  {
    if (newBinding != binding)
    {
      NotificationChain msgs = null;
      if (binding != null)
        msgs = ((InternalEObject)binding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING, null, msgs);
      if (newBinding != null)
        msgs = ((InternalEObject)newBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING, null, msgs);
      msgs = basicSetBinding(newBinding, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING, newBinding, newBinding));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithBinding getRemaining()
  {
    return remaining;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRemaining(QualifiedNameWithBinding newRemaining, NotificationChain msgs)
  {
    QualifiedNameWithBinding oldRemaining = remaining;
    remaining = newRemaining;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING, oldRemaining, newRemaining);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRemaining(QualifiedNameWithBinding newRemaining)
  {
    if (newRemaining != remaining)
    {
      NotificationChain msgs = null;
      if (remaining != null)
        msgs = ((InternalEObject)remaining).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING, null, msgs);
      if (newRemaining != null)
        msgs = ((InternalEObject)newRemaining).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING, null, msgs);
      msgs = basicSetRemaining(newRemaining, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING, newRemaining, newRemaining));
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
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING:
        return basicSetBinding(null, msgs);
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING:
        return basicSetRemaining(null, msgs);
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
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__ID:
        return getId();
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING:
        return getBinding();
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING:
        return getRemaining();
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
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__ID:
        setId((String)newValue);
        return;
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING:
        setBinding((TemplateBinding)newValue);
        return;
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING:
        setRemaining((QualifiedNameWithBinding)newValue);
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
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__ID:
        setId(ID_EDEFAULT);
        return;
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING:
        setBinding((TemplateBinding)null);
        return;
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING:
        setRemaining((QualifiedNameWithBinding)null);
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
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__BINDING:
        return binding != null;
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING__REMAINING:
        return remaining != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //QualifiedNameWithBindingImpl
