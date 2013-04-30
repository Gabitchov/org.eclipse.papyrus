/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Multiplicity;
import org.eclipse.papyrus.alf.alf.MultiplicityRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicityImpl#getMultiplicityRange <em>Multiplicity Range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicityImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicityImpl#isIsNonUnique <em>Is Non Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicityImpl#isIsSequence <em>Is Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityImpl extends MinimalEObjectImpl.Container implements Multiplicity
{
  /**
   * The cached value of the '{@link #getMultiplicityRange() <em>Multiplicity Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicityRange()
   * @generated
   * @ordered
   */
  protected MultiplicityRange multiplicityRange;

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
   * The default value of the '{@link #isIsNonUnique() <em>Is Non Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNonUnique()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NON_UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNonUnique() <em>Is Non Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNonUnique()
   * @generated
   * @ordered
   */
  protected boolean isNonUnique = IS_NON_UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsSequence() <em>Is Sequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsSequence()
   * @generated
   * @ordered
   */
  protected static final boolean IS_SEQUENCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsSequence() <em>Is Sequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsSequence()
   * @generated
   * @ordered
   */
  protected boolean isSequence = IS_SEQUENCE_EDEFAULT;

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
    return AlfPackage.eINSTANCE.getMultiplicity();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRange getMultiplicityRange()
  {
    return multiplicityRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicityRange(MultiplicityRange newMultiplicityRange, NotificationChain msgs)
  {
    MultiplicityRange oldMultiplicityRange = multiplicityRange;
    multiplicityRange = newMultiplicityRange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE, oldMultiplicityRange, newMultiplicityRange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicityRange(MultiplicityRange newMultiplicityRange)
  {
    if (newMultiplicityRange != multiplicityRange)
    {
      NotificationChain msgs = null;
      if (multiplicityRange != null)
        msgs = ((InternalEObject)multiplicityRange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE, null, msgs);
      if (newMultiplicityRange != null)
        msgs = ((InternalEObject)newMultiplicityRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE, null, msgs);
      msgs = basicSetMultiplicityRange(newMultiplicityRange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE, newMultiplicityRange, newMultiplicityRange));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICITY__IS_ORDERED, oldIsOrdered, isOrdered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsNonUnique()
  {
    return isNonUnique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsNonUnique(boolean newIsNonUnique)
  {
    boolean oldIsNonUnique = isNonUnique;
    isNonUnique = newIsNonUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICITY__IS_NON_UNIQUE, oldIsNonUnique, isNonUnique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsSequence()
  {
    return isSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsSequence(boolean newIsSequence)
  {
    boolean oldIsSequence = isSequence;
    isSequence = newIsSequence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICITY__IS_SEQUENCE, oldIsSequence, isSequence));
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
      case AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE:
        return basicSetMultiplicityRange(null, msgs);
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
      case AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE:
        return getMultiplicityRange();
      case AlfPackage.MULTIPLICITY__IS_ORDERED:
        return isIsOrdered();
      case AlfPackage.MULTIPLICITY__IS_NON_UNIQUE:
        return isIsNonUnique();
      case AlfPackage.MULTIPLICITY__IS_SEQUENCE:
        return isIsSequence();
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
      case AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE:
        setMultiplicityRange((MultiplicityRange)newValue);
        return;
      case AlfPackage.MULTIPLICITY__IS_ORDERED:
        setIsOrdered((Boolean)newValue);
        return;
      case AlfPackage.MULTIPLICITY__IS_NON_UNIQUE:
        setIsNonUnique((Boolean)newValue);
        return;
      case AlfPackage.MULTIPLICITY__IS_SEQUENCE:
        setIsSequence((Boolean)newValue);
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
      case AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE:
        setMultiplicityRange((MultiplicityRange)null);
        return;
      case AlfPackage.MULTIPLICITY__IS_ORDERED:
        setIsOrdered(IS_ORDERED_EDEFAULT);
        return;
      case AlfPackage.MULTIPLICITY__IS_NON_UNIQUE:
        setIsNonUnique(IS_NON_UNIQUE_EDEFAULT);
        return;
      case AlfPackage.MULTIPLICITY__IS_SEQUENCE:
        setIsSequence(IS_SEQUENCE_EDEFAULT);
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
      case AlfPackage.MULTIPLICITY__MULTIPLICITY_RANGE:
        return multiplicityRange != null;
      case AlfPackage.MULTIPLICITY__IS_ORDERED:
        return isOrdered != IS_ORDERED_EDEFAULT;
      case AlfPackage.MULTIPLICITY__IS_NON_UNIQUE:
        return isNonUnique != IS_NON_UNIQUE_EDEFAULT;
      case AlfPackage.MULTIPLICITY__IS_SEQUENCE:
        return isSequence != IS_SEQUENCE_EDEFAULT;
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
    result.append(", isNonUnique: ");
    result.append(isNonUnique);
    result.append(", isSequence: ");
    result.append(isSequence);
    result.append(')');
    return result.toString();
  }

} //MultiplicityImpl
