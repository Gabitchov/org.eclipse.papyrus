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
import org.eclipse.papyrus.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unlimited Natural Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnlimitedNaturalLiteralImpl#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.UnlimitedNaturalLiteralImpl#isStar <em>Star</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnlimitedNaturalLiteralImpl extends MinimalEObjectImpl.Container implements UnlimitedNaturalLiteral
{
  /**
   * The cached value of the '{@link #getInteger() <em>Integer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteger()
   * @generated
   * @ordered
   */
  protected INTEGER_LITERAL integer;

  /**
   * The default value of the '{@link #isStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStar()
   * @generated
   * @ordered
   */
  protected static final boolean STAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStar()
   * @generated
   * @ordered
   */
  protected boolean star = STAR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnlimitedNaturalLiteralImpl()
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
    return AlfPackage.eINSTANCE.getUnlimitedNaturalLiteral();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTEGER_LITERAL getInteger()
  {
    return integer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInteger(INTEGER_LITERAL newInteger, NotificationChain msgs)
  {
    INTEGER_LITERAL oldInteger = integer;
    integer = newInteger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER, oldInteger, newInteger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInteger(INTEGER_LITERAL newInteger)
  {
    if (newInteger != integer)
    {
      NotificationChain msgs = null;
      if (integer != null)
        msgs = ((InternalEObject)integer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER, null, msgs);
      if (newInteger != null)
        msgs = ((InternalEObject)newInteger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER, null, msgs);
      msgs = basicSetInteger(newInteger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER, newInteger, newInteger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStar()
  {
    return star;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStar(boolean newStar)
  {
    boolean oldStar = star;
    star = newStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.UNLIMITED_NATURAL_LITERAL__STAR, oldStar, star));
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
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER:
        return basicSetInteger(null, msgs);
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
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER:
        return getInteger();
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__STAR:
        return isStar();
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
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER:
        setInteger((INTEGER_LITERAL)newValue);
        return;
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__STAR:
        setStar((Boolean)newValue);
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
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER:
        setInteger((INTEGER_LITERAL)null);
        return;
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__STAR:
        setStar(STAR_EDEFAULT);
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
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__INTEGER:
        return integer != null;
      case AlfPackage.UNLIMITED_NATURAL_LITERAL__STAR:
        return star != STAR_EDEFAULT;
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
    result.append(" (star: ");
    result.append(star);
    result.append(')');
    return result.toString();
  }

} //UnlimitedNaturalLiteralImpl
