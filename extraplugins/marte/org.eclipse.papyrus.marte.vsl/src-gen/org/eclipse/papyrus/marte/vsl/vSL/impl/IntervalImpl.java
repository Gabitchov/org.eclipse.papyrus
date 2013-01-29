/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl#getIsLowerIncluded <em>Is Lower Included</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl#getIsUpperIncluded <em>Is Upper Included</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntervalImpl extends ValueSpecificationImpl implements Interval
{
  /**
   * The default value of the '{@link #getIsLowerIncluded() <em>Is Lower Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsLowerIncluded()
   * @generated
   * @ordered
   */
  protected static final String IS_LOWER_INCLUDED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsLowerIncluded() <em>Is Lower Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsLowerIncluded()
   * @generated
   * @ordered
   */
  protected String isLowerIncluded = IS_LOWER_INCLUDED_EDEFAULT;

  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected Expression lower;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected Expression upper;

  /**
   * The default value of the '{@link #getIsUpperIncluded() <em>Is Upper Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsUpperIncluded()
   * @generated
   * @ordered
   */
  protected static final String IS_UPPER_INCLUDED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsUpperIncluded() <em>Is Upper Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsUpperIncluded()
   * @generated
   * @ordered
   */
  protected String isUpperIncluded = IS_UPPER_INCLUDED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntervalImpl()
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
    return VSLPackage.Literals.INTERVAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIsLowerIncluded()
  {
    return isLowerIncluded;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsLowerIncluded(String newIsLowerIncluded)
  {
    String oldIsLowerIncluded = isLowerIncluded;
    isLowerIncluded = newIsLowerIncluded;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__IS_LOWER_INCLUDED, oldIsLowerIncluded, isLowerIncluded));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLower()
  {
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLower(Expression newLower, NotificationChain msgs)
  {
    Expression oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__LOWER, oldLower, newLower);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLower(Expression newLower)
  {
    if (newLower != lower)
    {
      NotificationChain msgs = null;
      if (lower != null)
        msgs = ((InternalEObject)lower).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INTERVAL__LOWER, null, msgs);
      if (newLower != null)
        msgs = ((InternalEObject)newLower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INTERVAL__LOWER, null, msgs);
      msgs = basicSetLower(newLower, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__LOWER, newLower, newLower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getUpper()
  {
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpper(Expression newUpper, NotificationChain msgs)
  {
    Expression oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__UPPER, oldUpper, newUpper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpper(Expression newUpper)
  {
    if (newUpper != upper)
    {
      NotificationChain msgs = null;
      if (upper != null)
        msgs = ((InternalEObject)upper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INTERVAL__UPPER, null, msgs);
      if (newUpper != null)
        msgs = ((InternalEObject)newUpper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INTERVAL__UPPER, null, msgs);
      msgs = basicSetUpper(newUpper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__UPPER, newUpper, newUpper));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIsUpperIncluded()
  {
    return isUpperIncluded;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsUpperIncluded(String newIsUpperIncluded)
  {
    String oldIsUpperIncluded = isUpperIncluded;
    isUpperIncluded = newIsUpperIncluded;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INTERVAL__IS_UPPER_INCLUDED, oldIsUpperIncluded, isUpperIncluded));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFilteredParentRule(final EClass filter)
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;
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
      case VSLPackage.INTERVAL__LOWER:
        return basicSetLower(null, msgs);
      case VSLPackage.INTERVAL__UPPER:
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
      case VSLPackage.INTERVAL__IS_LOWER_INCLUDED:
        return getIsLowerIncluded();
      case VSLPackage.INTERVAL__LOWER:
        return getLower();
      case VSLPackage.INTERVAL__UPPER:
        return getUpper();
      case VSLPackage.INTERVAL__IS_UPPER_INCLUDED:
        return getIsUpperIncluded();
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
      case VSLPackage.INTERVAL__IS_LOWER_INCLUDED:
        setIsLowerIncluded((String)newValue);
        return;
      case VSLPackage.INTERVAL__LOWER:
        setLower((Expression)newValue);
        return;
      case VSLPackage.INTERVAL__UPPER:
        setUpper((Expression)newValue);
        return;
      case VSLPackage.INTERVAL__IS_UPPER_INCLUDED:
        setIsUpperIncluded((String)newValue);
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
      case VSLPackage.INTERVAL__IS_LOWER_INCLUDED:
        setIsLowerIncluded(IS_LOWER_INCLUDED_EDEFAULT);
        return;
      case VSLPackage.INTERVAL__LOWER:
        setLower((Expression)null);
        return;
      case VSLPackage.INTERVAL__UPPER:
        setUpper((Expression)null);
        return;
      case VSLPackage.INTERVAL__IS_UPPER_INCLUDED:
        setIsUpperIncluded(IS_UPPER_INCLUDED_EDEFAULT);
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
      case VSLPackage.INTERVAL__IS_LOWER_INCLUDED:
        return IS_LOWER_INCLUDED_EDEFAULT == null ? isLowerIncluded != null : !IS_LOWER_INCLUDED_EDEFAULT.equals(isLowerIncluded);
      case VSLPackage.INTERVAL__LOWER:
        return lower != null;
      case VSLPackage.INTERVAL__UPPER:
        return upper != null;
      case VSLPackage.INTERVAL__IS_UPPER_INCLUDED:
        return IS_UPPER_INCLUDED_EDEFAULT == null ? isUpperIncluded != null : !IS_UPPER_INCLUDED_EDEFAULT.equals(isUpperIncluded);
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
    result.append(" (isLowerIncluded: ");
    result.append(isLowerIncluded);
    result.append(", isUpperIncluded: ");
    result.append(isUpperIncluded);
    result.append(')');
    return result.toString();
  }

} //IntervalImpl
