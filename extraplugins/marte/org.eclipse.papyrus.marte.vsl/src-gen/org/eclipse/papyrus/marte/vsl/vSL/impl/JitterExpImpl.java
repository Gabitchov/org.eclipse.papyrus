/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.JitterExp;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jitter Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl#getFirstInstant <em>First Instant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl#getSecondInstant <em>Second Instant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JitterExpImpl extends TimeExpressionImpl implements JitterExp
{
  /**
   * The cached value of the '{@link #getFirstInstant() <em>First Instant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstInstant()
   * @generated
   * @ordered
   */
  protected InstantObsExpression firstInstant;

  /**
   * The cached value of the '{@link #getSecondInstant() <em>Second Instant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondInstant()
   * @generated
   * @ordered
   */
  protected InstantObsExpression secondInstant;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JitterExpImpl()
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
    return VSLPackage.Literals.JITTER_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstantObsExpression getFirstInstant()
  {
    return firstInstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstInstant(InstantObsExpression newFirstInstant, NotificationChain msgs)
  {
    InstantObsExpression oldFirstInstant = firstInstant;
    firstInstant = newFirstInstant;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.JITTER_EXP__FIRST_INSTANT, oldFirstInstant, newFirstInstant);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstInstant(InstantObsExpression newFirstInstant)
  {
    if (newFirstInstant != firstInstant)
    {
      NotificationChain msgs = null;
      if (firstInstant != null)
        msgs = ((InternalEObject)firstInstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.JITTER_EXP__FIRST_INSTANT, null, msgs);
      if (newFirstInstant != null)
        msgs = ((InternalEObject)newFirstInstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.JITTER_EXP__FIRST_INSTANT, null, msgs);
      msgs = basicSetFirstInstant(newFirstInstant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.JITTER_EXP__FIRST_INSTANT, newFirstInstant, newFirstInstant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstantObsExpression getSecondInstant()
  {
    return secondInstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecondInstant(InstantObsExpression newSecondInstant, NotificationChain msgs)
  {
    InstantObsExpression oldSecondInstant = secondInstant;
    secondInstant = newSecondInstant;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.JITTER_EXP__SECOND_INSTANT, oldSecondInstant, newSecondInstant);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecondInstant(InstantObsExpression newSecondInstant)
  {
    if (newSecondInstant != secondInstant)
    {
      NotificationChain msgs = null;
      if (secondInstant != null)
        msgs = ((InternalEObject)secondInstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.JITTER_EXP__SECOND_INSTANT, null, msgs);
      if (newSecondInstant != null)
        msgs = ((InternalEObject)newSecondInstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.JITTER_EXP__SECOND_INSTANT, null, msgs);
      msgs = basicSetSecondInstant(newSecondInstant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.JITTER_EXP__SECOND_INSTANT, newSecondInstant, newSecondInstant));
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
      case VSLPackage.JITTER_EXP__FIRST_INSTANT:
        return basicSetFirstInstant(null, msgs);
      case VSLPackage.JITTER_EXP__SECOND_INSTANT:
        return basicSetSecondInstant(null, msgs);
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
      case VSLPackage.JITTER_EXP__FIRST_INSTANT:
        return getFirstInstant();
      case VSLPackage.JITTER_EXP__SECOND_INSTANT:
        return getSecondInstant();
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
      case VSLPackage.JITTER_EXP__FIRST_INSTANT:
        setFirstInstant((InstantObsExpression)newValue);
        return;
      case VSLPackage.JITTER_EXP__SECOND_INSTANT:
        setSecondInstant((InstantObsExpression)newValue);
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
      case VSLPackage.JITTER_EXP__FIRST_INSTANT:
        setFirstInstant((InstantObsExpression)null);
        return;
      case VSLPackage.JITTER_EXP__SECOND_INSTANT:
        setSecondInstant((InstantObsExpression)null);
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
      case VSLPackage.JITTER_EXP__FIRST_INSTANT:
        return firstInstant != null;
      case VSLPackage.JITTER_EXP__SECOND_INSTANT:
        return secondInstant != null;
    }
    return super.eIsSet(featureID);
  }

} //JitterExpImpl
