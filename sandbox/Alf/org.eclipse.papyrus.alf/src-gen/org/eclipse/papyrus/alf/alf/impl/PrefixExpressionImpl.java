/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AffixOperator;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.PrefixExpression;
import org.eclipse.papyrus.alf.alf.PrimaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrefixExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrefixExpressionImpl#getPrimaryExpression <em>Primary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrefixExpressionImpl extends NonPostfixNonCastUnaryExpressionImpl implements PrefixExpression
{
  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final AffixOperator OPERATOR_EDEFAULT = AffixOperator.INCR;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected AffixOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getPrimaryExpression() <em>Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryExpression()
   * @generated
   * @ordered
   */
  protected PrimaryExpression primaryExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixExpressionImpl()
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
    return AlfPackage.eINSTANCE.getPrefixExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AffixOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(AffixOperator newOperator)
  {
    AffixOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PREFIX_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression getPrimaryExpression()
  {
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryExpression(PrimaryExpression newPrimaryExpression, NotificationChain msgs)
  {
    PrimaryExpression oldPrimaryExpression = primaryExpression;
    primaryExpression = newPrimaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION, oldPrimaryExpression, newPrimaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryExpression(PrimaryExpression newPrimaryExpression)
  {
    if (newPrimaryExpression != primaryExpression)
    {
      NotificationChain msgs = null;
      if (primaryExpression != null)
        msgs = ((InternalEObject)primaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION, null, msgs);
      if (newPrimaryExpression != null)
        msgs = ((InternalEObject)newPrimaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION, null, msgs);
      msgs = basicSetPrimaryExpression(newPrimaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION, newPrimaryExpression, newPrimaryExpression));
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
      case AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION:
        return basicSetPrimaryExpression(null, msgs);
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
      case AlfPackage.PREFIX_EXPRESSION__OPERATOR:
        return getOperator();
      case AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION:
        return getPrimaryExpression();
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
      case AlfPackage.PREFIX_EXPRESSION__OPERATOR:
        setOperator((AffixOperator)newValue);
        return;
      case AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION:
        setPrimaryExpression((PrimaryExpression)newValue);
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
      case AlfPackage.PREFIX_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION:
        setPrimaryExpression((PrimaryExpression)null);
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
      case AlfPackage.PREFIX_EXPRESSION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case AlfPackage.PREFIX_EXPRESSION__PRIMARY_EXPRESSION:
        return primaryExpression != null;
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //PrefixExpressionImpl
