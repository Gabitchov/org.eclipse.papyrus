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
import org.eclipse.papyrus.uml.alf.alf.AccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.PartialSequenceConstructionCompletion;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Construction Or Access Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionOrAccessCompletionImpl#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionOrAccessCompletionImpl#getAccessCompletion <em>Access Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionOrAccessCompletionImpl#getSequenceCompletion <em>Sequence Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionOrAccessCompletionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceConstructionOrAccessCompletionImpl extends MinimalEObjectImpl.Container implements SequenceConstructionOrAccessCompletion
{
  /**
   * The default value of the '{@link #isMultiplicityIndicator() <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected static final boolean MULTIPLICITY_INDICATOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMultiplicityIndicator() <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected boolean multiplicityIndicator = MULTIPLICITY_INDICATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getAccessCompletion() <em>Access Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessCompletion()
   * @generated
   * @ordered
   */
  protected AccessCompletion accessCompletion;

  /**
   * The cached value of the '{@link #getSequenceCompletion() <em>Sequence Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceCompletion()
   * @generated
   * @ordered
   */
  protected PartialSequenceConstructionCompletion sequenceCompletion;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected SequenceConstructionExpression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceConstructionOrAccessCompletionImpl()
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
    return AlfPackage.Literals.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMultiplicityIndicator()
  {
    return multiplicityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicityIndicator(boolean newMultiplicityIndicator)
  {
    boolean oldMultiplicityIndicator = multiplicityIndicator;
    multiplicityIndicator = newMultiplicityIndicator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR, oldMultiplicityIndicator, multiplicityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccessCompletion getAccessCompletion()
  {
    return accessCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccessCompletion(AccessCompletion newAccessCompletion, NotificationChain msgs)
  {
    AccessCompletion oldAccessCompletion = accessCompletion;
    accessCompletion = newAccessCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION, oldAccessCompletion, newAccessCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessCompletion(AccessCompletion newAccessCompletion)
  {
    if (newAccessCompletion != accessCompletion)
    {
      NotificationChain msgs = null;
      if (accessCompletion != null)
        msgs = ((InternalEObject)accessCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION, null, msgs);
      if (newAccessCompletion != null)
        msgs = ((InternalEObject)newAccessCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION, null, msgs);
      msgs = basicSetAccessCompletion(newAccessCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION, newAccessCompletion, newAccessCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSequenceConstructionCompletion getSequenceCompletion()
  {
    return sequenceCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceCompletion(PartialSequenceConstructionCompletion newSequenceCompletion, NotificationChain msgs)
  {
    PartialSequenceConstructionCompletion oldSequenceCompletion = sequenceCompletion;
    sequenceCompletion = newSequenceCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION, oldSequenceCompletion, newSequenceCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceCompletion(PartialSequenceConstructionCompletion newSequenceCompletion)
  {
    if (newSequenceCompletion != sequenceCompletion)
    {
      NotificationChain msgs = null;
      if (sequenceCompletion != null)
        msgs = ((InternalEObject)sequenceCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION, null, msgs);
      if (newSequenceCompletion != null)
        msgs = ((InternalEObject)newSequenceCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION, null, msgs);
      msgs = basicSetSequenceCompletion(newSequenceCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION, newSequenceCompletion, newSequenceCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(SequenceConstructionExpression newExpression, NotificationChain msgs)
  {
    SequenceConstructionExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(SequenceConstructionExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION, newExpression, newExpression));
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION:
        return basicSetAccessCompletion(null, msgs);
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION:
        return basicSetSequenceCompletion(null, msgs);
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR:
        return isMultiplicityIndicator();
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION:
        return getAccessCompletion();
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION:
        return getSequenceCompletion();
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION:
        return getExpression();
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((Boolean)newValue);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION:
        setAccessCompletion((AccessCompletion)newValue);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION:
        setSequenceCompletion((PartialSequenceConstructionCompletion)newValue);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION:
        setExpression((SequenceConstructionExpression)newValue);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator(MULTIPLICITY_INDICATOR_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION:
        setAccessCompletion((AccessCompletion)null);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION:
        setSequenceCompletion((PartialSequenceConstructionCompletion)null);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION:
        setExpression((SequenceConstructionExpression)null);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR:
        return multiplicityIndicator != MULTIPLICITY_INDICATOR_EDEFAULT;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION:
        return accessCompletion != null;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION:
        return sequenceCompletion != null;
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION:
        return expression != null;
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
    result.append(" (multiplicityIndicator: ");
    result.append(multiplicityIndicator);
    result.append(')');
    return result.toString();
  }

} //SequenceConstructionOrAccessCompletionImpl
