/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Pseudo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pseudo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl#getPseudo <em>Pseudo</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.impl.PseudoImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PseudoImpl extends SelectorConditionImpl implements Pseudo
{
  /**
   * The default value of the '{@link #getPseudo() <em>Pseudo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPseudo()
   * @generated
   * @ordered
   */
  protected static final String PSEUDO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPseudo() <em>Pseudo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPseudo()
   * @generated
   * @ordered
   */
  protected String pseudo = PSEUDO_EDEFAULT;

  /**
   * The default value of the '{@link #getArgs() <em>Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected static final String ARGS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected String args = ARGS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PseudoImpl()
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
    return CssPackage.Literals.PSEUDO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPseudo()
  {
    return pseudo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPseudo(String newPseudo)
  {
    String oldPseudo = pseudo;
    pseudo = newPseudo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.PSEUDO__PSEUDO, oldPseudo, pseudo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArgs()
  {
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgs(String newArgs)
  {
    String oldArgs = args;
    args = newArgs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CssPackage.PSEUDO__ARGS, oldArgs, args));
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
      case CssPackage.PSEUDO__PSEUDO:
        return getPseudo();
      case CssPackage.PSEUDO__ARGS:
        return getArgs();
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
      case CssPackage.PSEUDO__PSEUDO:
        setPseudo((String)newValue);
        return;
      case CssPackage.PSEUDO__ARGS:
        setArgs((String)newValue);
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
      case CssPackage.PSEUDO__PSEUDO:
        setPseudo(PSEUDO_EDEFAULT);
        return;
      case CssPackage.PSEUDO__ARGS:
        setArgs(ARGS_EDEFAULT);
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
      case CssPackage.PSEUDO__PSEUDO:
        return PSEUDO_EDEFAULT == null ? pseudo != null : !PSEUDO_EDEFAULT.equals(pseudo);
      case CssPackage.PSEUDO__ARGS:
        return ARGS_EDEFAULT == null ? args != null : !ARGS_EDEFAULT.equals(args);
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
    result.append(" (pseudo: ");
    result.append(pseudo);
    result.append(", args: ");
    result.append(args);
    result.append(')');
    return result.toString();
  }

} //PseudoImpl
