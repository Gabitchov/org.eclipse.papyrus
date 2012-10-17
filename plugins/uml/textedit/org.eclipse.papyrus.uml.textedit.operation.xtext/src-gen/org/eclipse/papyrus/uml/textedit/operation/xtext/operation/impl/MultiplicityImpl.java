/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl#isNonUnique <em>Non Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityImpl#isSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityImpl extends MinimalEObjectImpl.Container implements Multiplicity
{
  /**
   * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRange()
   * @generated
   * @ordered
   */
  protected MultiplicityRange range;

  /**
   * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected boolean ordered = ORDERED_EDEFAULT;

  /**
   * The default value of the '{@link #isNonUnique() <em>Non Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonUnique()
   * @generated
   * @ordered
   */
  protected static final boolean NON_UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNonUnique() <em>Non Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonUnique()
   * @generated
   * @ordered
   */
  protected boolean nonUnique = NON_UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #isSequence() <em>Sequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequence()
   * @generated
   * @ordered
   */
  protected static final boolean SEQUENCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSequence() <em>Sequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequence()
   * @generated
   * @ordered
   */
  protected boolean sequence = SEQUENCE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicityImpl()
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
    return OperationPackage.Literals.MULTIPLICITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRange getRange()
  {
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRange(MultiplicityRange newRange, NotificationChain msgs)
  {
    MultiplicityRange oldRange = range;
    range = newRange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY__RANGE, oldRange, newRange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRange(MultiplicityRange newRange)
  {
    if (newRange != range)
    {
      NotificationChain msgs = null;
      if (range != null)
        msgs = ((InternalEObject)range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY__RANGE, null, msgs);
      if (newRange != null)
        msgs = ((InternalEObject)newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY__RANGE, null, msgs);
      msgs = basicSetRange(newRange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY__RANGE, newRange, newRange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOrdered()
  {
    return ordered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrdered(boolean newOrdered)
  {
    boolean oldOrdered = ordered;
    ordered = newOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNonUnique()
  {
    return nonUnique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonUnique(boolean newNonUnique)
  {
    boolean oldNonUnique = nonUnique;
    nonUnique = newNonUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY__NON_UNIQUE, oldNonUnique, nonUnique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSequence()
  {
    return sequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequence(boolean newSequence)
  {
    boolean oldSequence = sequence;
    sequence = newSequence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY__SEQUENCE, oldSequence, sequence));
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
      case OperationPackage.MULTIPLICITY__RANGE:
        return basicSetRange(null, msgs);
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
      case OperationPackage.MULTIPLICITY__RANGE:
        return getRange();
      case OperationPackage.MULTIPLICITY__ORDERED:
        return isOrdered();
      case OperationPackage.MULTIPLICITY__NON_UNIQUE:
        return isNonUnique();
      case OperationPackage.MULTIPLICITY__SEQUENCE:
        return isSequence();
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
      case OperationPackage.MULTIPLICITY__RANGE:
        setRange((MultiplicityRange)newValue);
        return;
      case OperationPackage.MULTIPLICITY__ORDERED:
        setOrdered((Boolean)newValue);
        return;
      case OperationPackage.MULTIPLICITY__NON_UNIQUE:
        setNonUnique((Boolean)newValue);
        return;
      case OperationPackage.MULTIPLICITY__SEQUENCE:
        setSequence((Boolean)newValue);
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
      case OperationPackage.MULTIPLICITY__RANGE:
        setRange((MultiplicityRange)null);
        return;
      case OperationPackage.MULTIPLICITY__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case OperationPackage.MULTIPLICITY__NON_UNIQUE:
        setNonUnique(NON_UNIQUE_EDEFAULT);
        return;
      case OperationPackage.MULTIPLICITY__SEQUENCE:
        setSequence(SEQUENCE_EDEFAULT);
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
      case OperationPackage.MULTIPLICITY__RANGE:
        return range != null;
      case OperationPackage.MULTIPLICITY__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case OperationPackage.MULTIPLICITY__NON_UNIQUE:
        return nonUnique != NON_UNIQUE_EDEFAULT;
      case OperationPackage.MULTIPLICITY__SEQUENCE:
        return sequence != SEQUENCE_EDEFAULT;
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
    result.append(" (ordered: ");
    result.append(ordered);
    result.append(", nonUnique: ");
    result.append(nonUnique);
    result.append(", sequence: ");
    result.append(sequence);
    result.append(')');
    return result.toString();
  }

} //MultiplicityImpl
