/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.VisibilityIndicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visibility Indicator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.VisibilityIndicatorImpl#getPUBLIC <em>PUBLIC</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.VisibilityIndicatorImpl#getPRIVATE <em>PRIVATE</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.VisibilityIndicatorImpl#getPROTECTED <em>PROTECTED</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisibilityIndicatorImpl extends MinimalEObjectImpl.Container implements VisibilityIndicator
{
  /**
   * The default value of the '{@link #getPUBLIC() <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPUBLIC()
   * @generated
   * @ordered
   */
  protected static final String PUBLIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPUBLIC() <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPUBLIC()
   * @generated
   * @ordered
   */
  protected String public_ = PUBLIC_EDEFAULT;

  /**
   * The default value of the '{@link #getPRIVATE() <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPRIVATE()
   * @generated
   * @ordered
   */
  protected static final String PRIVATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPRIVATE() <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPRIVATE()
   * @generated
   * @ordered
   */
  protected String private_ = PRIVATE_EDEFAULT;

  /**
   * The default value of the '{@link #getPROTECTED() <em>PROTECTED</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPROTECTED()
   * @generated
   * @ordered
   */
  protected static final String PROTECTED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPROTECTED() <em>PROTECTED</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPROTECTED()
   * @generated
   * @ordered
   */
  protected String protected_ = PROTECTED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VisibilityIndicatorImpl()
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
    return AlfPackage.eINSTANCE.getVisibilityIndicator();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPUBLIC()
  {
    return public_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPUBLIC(String newPUBLIC)
  {
    String oldPUBLIC = public_;
    public_ = newPUBLIC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VISIBILITY_INDICATOR__PUBLIC, oldPUBLIC, public_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPRIVATE()
  {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPRIVATE(String newPRIVATE)
  {
    String oldPRIVATE = private_;
    private_ = newPRIVATE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VISIBILITY_INDICATOR__PRIVATE, oldPRIVATE, private_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPROTECTED()
  {
    return protected_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPROTECTED(String newPROTECTED)
  {
    String oldPROTECTED = protected_;
    protected_ = newPROTECTED;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VISIBILITY_INDICATOR__PROTECTED, oldPROTECTED, protected_));
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
      case AlfPackage.VISIBILITY_INDICATOR__PUBLIC:
        return getPUBLIC();
      case AlfPackage.VISIBILITY_INDICATOR__PRIVATE:
        return getPRIVATE();
      case AlfPackage.VISIBILITY_INDICATOR__PROTECTED:
        return getPROTECTED();
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
      case AlfPackage.VISIBILITY_INDICATOR__PUBLIC:
        setPUBLIC((String)newValue);
        return;
      case AlfPackage.VISIBILITY_INDICATOR__PRIVATE:
        setPRIVATE((String)newValue);
        return;
      case AlfPackage.VISIBILITY_INDICATOR__PROTECTED:
        setPROTECTED((String)newValue);
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
      case AlfPackage.VISIBILITY_INDICATOR__PUBLIC:
        setPUBLIC(PUBLIC_EDEFAULT);
        return;
      case AlfPackage.VISIBILITY_INDICATOR__PRIVATE:
        setPRIVATE(PRIVATE_EDEFAULT);
        return;
      case AlfPackage.VISIBILITY_INDICATOR__PROTECTED:
        setPROTECTED(PROTECTED_EDEFAULT);
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
      case AlfPackage.VISIBILITY_INDICATOR__PUBLIC:
        return PUBLIC_EDEFAULT == null ? public_ != null : !PUBLIC_EDEFAULT.equals(public_);
      case AlfPackage.VISIBILITY_INDICATOR__PRIVATE:
        return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
      case AlfPackage.VISIBILITY_INDICATOR__PROTECTED:
        return PROTECTED_EDEFAULT == null ? protected_ != null : !PROTECTED_EDEFAULT.equals(protected_);
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
    result.append(" (PUBLIC: ");
    result.append(public_);
    result.append(", PRIVATE: ");
    result.append(private_);
    result.append(", PROTECTED: ");
    result.append(protected_);
    result.append(')');
    return result.toString();
  }

} //VisibilityIndicatorImpl
