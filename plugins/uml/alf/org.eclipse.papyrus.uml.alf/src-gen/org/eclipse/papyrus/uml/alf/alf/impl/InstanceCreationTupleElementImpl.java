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
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Creation Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InstanceCreationTupleElementImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.InstanceCreationTupleElementImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceCreationTupleElementImpl extends MinimalEObjectImpl.Container implements InstanceCreationTupleElement
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
  protected InstanceCreationTupleElementImpl()
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
    return AlfPackage.Literals.INSTANCE_CREATION_TUPLE_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE, oldRole, role));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT, oldObject, newObject);
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
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT, newObject, newObject));
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
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT:
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
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE:
        return getRole();
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT:
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
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE:
        setRole((String)newValue);
        return;
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT:
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
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE:
        setRole(ROLE_EDEFAULT);
        return;
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT:
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
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE:
        return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT:
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

} //InstanceCreationTupleElementImpl
