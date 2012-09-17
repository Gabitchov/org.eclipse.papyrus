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
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Reduction Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceReductionExpressionImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceReductionExpressionImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceReductionExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceReductionExpressionImpl extends SuffixExpressionImpl implements SequenceReductionExpression
{
  /**
   * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected boolean isOrdered = IS_ORDERED_EDEFAULT;

  /**
   * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehavior()
   * @generated
   * @ordered
   */
  protected QualifiedNameWithBinding behavior;

  /**
   * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuffix()
   * @generated
   * @ordered
   */
  protected SuffixExpression suffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceReductionExpressionImpl()
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
    return AlfPackage.Literals.SEQUENCE_REDUCTION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsOrdered()
  {
    return isOrdered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsOrdered(boolean newIsOrdered)
  {
    boolean oldIsOrdered = isOrdered;
    isOrdered = newIsOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED, oldIsOrdered, isOrdered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithBinding getBehavior()
  {
    return behavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehavior(QualifiedNameWithBinding newBehavior, NotificationChain msgs)
  {
    QualifiedNameWithBinding oldBehavior = behavior;
    behavior = newBehavior;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR, oldBehavior, newBehavior);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehavior(QualifiedNameWithBinding newBehavior)
  {
    if (newBehavior != behavior)
    {
      NotificationChain msgs = null;
      if (behavior != null)
        msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR, null, msgs);
      if (newBehavior != null)
        msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR, null, msgs);
      msgs = basicSetBehavior(newBehavior, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR, newBehavior, newBehavior));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuffixExpression getSuffix()
  {
    return suffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuffix(SuffixExpression newSuffix, NotificationChain msgs)
  {
    SuffixExpression oldSuffix = suffix;
    suffix = newSuffix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX, oldSuffix, newSuffix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuffix(SuffixExpression newSuffix)
  {
    if (newSuffix != suffix)
    {
      NotificationChain msgs = null;
      if (suffix != null)
        msgs = ((InternalEObject)suffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX, null, msgs);
      if (newSuffix != null)
        msgs = ((InternalEObject)newSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX, null, msgs);
      msgs = basicSetSuffix(newSuffix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX, newSuffix, newSuffix));
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
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR:
        return basicSetBehavior(null, msgs);
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX:
        return basicSetSuffix(null, msgs);
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
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED:
        return isIsOrdered();
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR:
        return getBehavior();
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX:
        return getSuffix();
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
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED:
        setIsOrdered((Boolean)newValue);
        return;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR:
        setBehavior((QualifiedNameWithBinding)newValue);
        return;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)newValue);
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
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED:
        setIsOrdered(IS_ORDERED_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR:
        setBehavior((QualifiedNameWithBinding)null);
        return;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)null);
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
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED:
        return isOrdered != IS_ORDERED_EDEFAULT;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR:
        return behavior != null;
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION__SUFFIX:
        return suffix != null;
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
    result.append(" (isOrdered: ");
    result.append(isOrdered);
    result.append(')');
    return result.toString();
  }

} //SequenceReductionExpressionImpl
