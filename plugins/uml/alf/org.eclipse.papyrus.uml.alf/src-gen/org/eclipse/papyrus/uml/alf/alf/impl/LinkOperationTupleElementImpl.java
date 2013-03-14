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
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Operation Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.LinkOperationTupleElementImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.LinkOperationTupleElementImpl#getRoleIndex <em>Role Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.LinkOperationTupleElementImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkOperationTupleElementImpl extends MinimalEObjectImpl.Container implements LinkOperationTupleElement
{
  /**
   * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
  protected static final String ROLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
  protected String role = ROLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRoleIndex() <em>Role Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleIndex()
   * @generated
   * @ordered
   */
  protected Expression roleIndex;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected Expression object;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkOperationTupleElementImpl()
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
    return AlfPackage.Literals.LINK_OPERATION_TUPLE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRole()
  {
    return role;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRole(String newRole)
  {
    String oldRole = role;
    role = newRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE, oldRole, role));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRoleIndex()
  {
    return roleIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoleIndex(Expression newRoleIndex, NotificationChain msgs)
  {
    Expression oldRoleIndex = roleIndex;
    roleIndex = newRoleIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX, oldRoleIndex, newRoleIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleIndex(Expression newRoleIndex)
  {
    if (newRoleIndex != roleIndex)
    {
      NotificationChain msgs = null;
      if (roleIndex != null)
        msgs = ((InternalEObject)roleIndex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX, null, msgs);
      if (newRoleIndex != null)
        msgs = ((InternalEObject)newRoleIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX, null, msgs);
      msgs = basicSetRoleIndex(newRoleIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX, newRoleIndex, newRoleIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObject(Expression newObject, NotificationChain msgs)
  {
    Expression oldObject = object;
    object = newObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT, oldObject, newObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(Expression newObject)
  {
    if (newObject != object)
    {
      NotificationChain msgs = null;
      if (object != null)
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT, newObject, newObject));
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
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX:
        return basicSetRoleIndex(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT:
        return basicSetObject(null, msgs);
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
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE:
        return getRole();
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX:
        return getRoleIndex();
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT:
        return getObject();
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
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE:
        setRole((String)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX:
        setRoleIndex((Expression)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT:
        setObject((Expression)newValue);
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
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE:
        setRole(ROLE_EDEFAULT);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX:
        setRoleIndex((Expression)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT:
        setObject((Expression)null);
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
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE:
        return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX:
        return roleIndex != null;
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT__OBJECT:
        return object != null;
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
    result.append(" (role: ");
    result.append(role);
    result.append(')');
    return result.toString();
  }

} //LinkOperationTupleElementImpl
