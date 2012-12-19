/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.MultiplicityRangeImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityRangeImpl extends MinimalEObjectImpl.Container implements MultiplicityRange
{
  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected NUMBER_LITERAL_WITHOUT_SUFFIX lower;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected NUMBER_LITERAL_WITHOUT_SUFFIX upper;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicityRangeImpl()
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
    return OperationPackage.Literals.MULTIPLICITY_RANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NUMBER_LITERAL_WITHOUT_SUFFIX getLower()
  {
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLower(NUMBER_LITERAL_WITHOUT_SUFFIX newLower, NotificationChain msgs)
  {
    NUMBER_LITERAL_WITHOUT_SUFFIX oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY_RANGE__LOWER, oldLower, newLower);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLower(NUMBER_LITERAL_WITHOUT_SUFFIX newLower)
  {
    if (newLower != lower)
    {
      NotificationChain msgs = null;
      if (lower != null)
        msgs = ((InternalEObject)lower).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY_RANGE__LOWER, null, msgs);
      if (newLower != null)
        msgs = ((InternalEObject)newLower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY_RANGE__LOWER, null, msgs);
      msgs = basicSetLower(newLower, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY_RANGE__LOWER, newLower, newLower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NUMBER_LITERAL_WITHOUT_SUFFIX getUpper()
  {
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpper(NUMBER_LITERAL_WITHOUT_SUFFIX newUpper, NotificationChain msgs)
  {
    NUMBER_LITERAL_WITHOUT_SUFFIX oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY_RANGE__UPPER, oldUpper, newUpper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpper(NUMBER_LITERAL_WITHOUT_SUFFIX newUpper)
  {
    if (newUpper != upper)
    {
      NotificationChain msgs = null;
      if (upper != null)
        msgs = ((InternalEObject)upper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY_RANGE__UPPER, null, msgs);
      if (newUpper != null)
        msgs = ((InternalEObject)newUpper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.MULTIPLICITY_RANGE__UPPER, null, msgs);
      msgs = basicSetUpper(newUpper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.MULTIPLICITY_RANGE__UPPER, newUpper, newUpper));
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
      case OperationPackage.MULTIPLICITY_RANGE__LOWER:
        return basicSetLower(null, msgs);
      case OperationPackage.MULTIPLICITY_RANGE__UPPER:
        return basicSetUpper(null, msgs);
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
      case OperationPackage.MULTIPLICITY_RANGE__LOWER:
        return getLower();
      case OperationPackage.MULTIPLICITY_RANGE__UPPER:
        return getUpper();
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
      case OperationPackage.MULTIPLICITY_RANGE__LOWER:
        setLower((NUMBER_LITERAL_WITHOUT_SUFFIX)newValue);
        return;
      case OperationPackage.MULTIPLICITY_RANGE__UPPER:
        setUpper((NUMBER_LITERAL_WITHOUT_SUFFIX)newValue);
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
      case OperationPackage.MULTIPLICITY_RANGE__LOWER:
        setLower((NUMBER_LITERAL_WITHOUT_SUFFIX)null);
        return;
      case OperationPackage.MULTIPLICITY_RANGE__UPPER:
        setUpper((NUMBER_LITERAL_WITHOUT_SUFFIX)null);
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
      case OperationPackage.MULTIPLICITY_RANGE__LOWER:
        return lower != null;
      case OperationPackage.MULTIPLICITY_RANGE__UPPER:
        return upper != null;
    }
    return super.eIsSet(featureID);
  }

} //MultiplicityRangeImpl
