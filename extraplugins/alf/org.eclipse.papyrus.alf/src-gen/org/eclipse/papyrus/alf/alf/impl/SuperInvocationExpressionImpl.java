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
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.OperationCallExpression;
import org.eclipse.papyrus.alf.alf.OperationCallExpressionWithoutDot;
import org.eclipse.papyrus.alf.alf.SuperInvocationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SuperInvocationExpressionImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SuperInvocationExpressionImpl#getOperationCallWithoutDot <em>Operation Call Without Dot</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SuperInvocationExpressionImpl#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperInvocationExpressionImpl extends ValueSpecificationImpl implements SuperInvocationExpression
{
  /**
   * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected static final String CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected String className = CLASS_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperationCallWithoutDot() <em>Operation Call Without Dot</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationCallWithoutDot()
   * @generated
   * @ordered
   */
  protected OperationCallExpressionWithoutDot operationCallWithoutDot;

  /**
   * The cached value of the '{@link #getOperationCall() <em>Operation Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationCall()
   * @generated
   * @ordered
   */
  protected OperationCallExpression operationCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SuperInvocationExpressionImpl()
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
    return AlfPackage.Literals.SUPER_INVOCATION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassName(String newClassName)
  {
    String oldClassName = className;
    className = newClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__CLASS_NAME, oldClassName, className));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCallExpressionWithoutDot getOperationCallWithoutDot()
  {
    return operationCallWithoutDot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationCallWithoutDot(OperationCallExpressionWithoutDot newOperationCallWithoutDot, NotificationChain msgs)
  {
    OperationCallExpressionWithoutDot oldOperationCallWithoutDot = operationCallWithoutDot;
    operationCallWithoutDot = newOperationCallWithoutDot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT, oldOperationCallWithoutDot, newOperationCallWithoutDot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCallWithoutDot(OperationCallExpressionWithoutDot newOperationCallWithoutDot)
  {
    if (newOperationCallWithoutDot != operationCallWithoutDot)
    {
      NotificationChain msgs = null;
      if (operationCallWithoutDot != null)
        msgs = ((InternalEObject)operationCallWithoutDot).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT, null, msgs);
      if (newOperationCallWithoutDot != null)
        msgs = ((InternalEObject)newOperationCallWithoutDot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT, null, msgs);
      msgs = basicSetOperationCallWithoutDot(newOperationCallWithoutDot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT, newOperationCallWithoutDot, newOperationCallWithoutDot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCallExpression getOperationCall()
  {
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationCall(OperationCallExpression newOperationCall, NotificationChain msgs)
  {
    OperationCallExpression oldOperationCall = operationCall;
    operationCall = newOperationCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL, oldOperationCall, newOperationCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCall(OperationCallExpression newOperationCall)
  {
    if (newOperationCall != operationCall)
    {
      NotificationChain msgs = null;
      if (operationCall != null)
        msgs = ((InternalEObject)operationCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL, null, msgs);
      if (newOperationCall != null)
        msgs = ((InternalEObject)newOperationCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL, null, msgs);
      msgs = basicSetOperationCall(newOperationCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL, newOperationCall, newOperationCall));
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT:
        return basicSetOperationCallWithoutDot(null, msgs);
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL:
        return basicSetOperationCall(null, msgs);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__CLASS_NAME:
        return getClassName();
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT:
        return getOperationCallWithoutDot();
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL:
        return getOperationCall();
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__CLASS_NAME:
        setClassName((String)newValue);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT:
        setOperationCallWithoutDot((OperationCallExpressionWithoutDot)newValue);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL:
        setOperationCall((OperationCallExpression)newValue);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__CLASS_NAME:
        setClassName(CLASS_NAME_EDEFAULT);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT:
        setOperationCallWithoutDot((OperationCallExpressionWithoutDot)null);
        return;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL:
        setOperationCall((OperationCallExpression)null);
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
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__CLASS_NAME:
        return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL_WITHOUT_DOT:
        return operationCallWithoutDot != null;
      case AlfPackage.SUPER_INVOCATION_EXPRESSION__OPERATION_CALL:
        return operationCall != null;
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
    result.append(" (className: ");
    result.append(className);
    result.append(')');
    return result.toString();
  }

} //SuperInvocationExpressionImpl
