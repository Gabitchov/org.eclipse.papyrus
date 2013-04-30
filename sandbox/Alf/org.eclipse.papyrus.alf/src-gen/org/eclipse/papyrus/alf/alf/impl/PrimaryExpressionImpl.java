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
import org.eclipse.papyrus.alf.alf.BaseExpression;
import org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression;
import org.eclipse.papyrus.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryExpressionImpl#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryExpressionImpl#getBaseExpression <em>Base Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryExpressionImpl#getParenthesizedExpression <em>Parenthesized Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryExpressionImpl#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends MinimalEObjectImpl.Container implements PrimaryExpression
{
  /**
   * The cached value of the '{@link #getNameOrPrimaryExpression() <em>Name Or Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameOrPrimaryExpression()
   * @generated
   * @ordered
   */
  protected NameOrPrimaryExpression nameOrPrimaryExpression;

  /**
   * The cached value of the '{@link #getBaseExpression() <em>Base Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseExpression()
   * @generated
   * @ordered
   */
  protected BaseExpression baseExpression;

  /**
   * The cached value of the '{@link #getParenthesizedExpression() <em>Parenthesized Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParenthesizedExpression()
   * @generated
   * @ordered
   */
  protected ParenthesizedExpression parenthesizedExpression;

  /**
   * The cached value of the '{@link #getPrimaryExpressionCompletion() <em>Primary Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PrimaryExpressionCompletion primaryExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryExpressionImpl()
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
    return AlfPackage.eINSTANCE.getPrimaryExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameOrPrimaryExpression getNameOrPrimaryExpression()
  {
    return nameOrPrimaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameOrPrimaryExpression(NameOrPrimaryExpression newNameOrPrimaryExpression, NotificationChain msgs)
  {
    NameOrPrimaryExpression oldNameOrPrimaryExpression = nameOrPrimaryExpression;
    nameOrPrimaryExpression = newNameOrPrimaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, oldNameOrPrimaryExpression, newNameOrPrimaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameOrPrimaryExpression(NameOrPrimaryExpression newNameOrPrimaryExpression)
  {
    if (newNameOrPrimaryExpression != nameOrPrimaryExpression)
    {
      NotificationChain msgs = null;
      if (nameOrPrimaryExpression != null)
        msgs = ((InternalEObject)nameOrPrimaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, null, msgs);
      if (newNameOrPrimaryExpression != null)
        msgs = ((InternalEObject)newNameOrPrimaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, null, msgs);
      msgs = basicSetNameOrPrimaryExpression(newNameOrPrimaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, newNameOrPrimaryExpression, newNameOrPrimaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseExpression getBaseExpression()
  {
    return baseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaseExpression(BaseExpression newBaseExpression, NotificationChain msgs)
  {
    BaseExpression oldBaseExpression = baseExpression;
    baseExpression = newBaseExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION, oldBaseExpression, newBaseExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaseExpression(BaseExpression newBaseExpression)
  {
    if (newBaseExpression != baseExpression)
    {
      NotificationChain msgs = null;
      if (baseExpression != null)
        msgs = ((InternalEObject)baseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION, null, msgs);
      if (newBaseExpression != null)
        msgs = ((InternalEObject)newBaseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION, null, msgs);
      msgs = basicSetBaseExpression(newBaseExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION, newBaseExpression, newBaseExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParenthesizedExpression getParenthesizedExpression()
  {
    return parenthesizedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParenthesizedExpression(ParenthesizedExpression newParenthesizedExpression, NotificationChain msgs)
  {
    ParenthesizedExpression oldParenthesizedExpression = parenthesizedExpression;
    parenthesizedExpression = newParenthesizedExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION, oldParenthesizedExpression, newParenthesizedExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParenthesizedExpression(ParenthesizedExpression newParenthesizedExpression)
  {
    if (newParenthesizedExpression != parenthesizedExpression)
    {
      NotificationChain msgs = null;
      if (parenthesizedExpression != null)
        msgs = ((InternalEObject)parenthesizedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION, null, msgs);
      if (newParenthesizedExpression != null)
        msgs = ((InternalEObject)newParenthesizedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION, null, msgs);
      msgs = basicSetParenthesizedExpression(newParenthesizedExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION, newParenthesizedExpression, newParenthesizedExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpressionCompletion getPrimaryExpressionCompletion()
  {
    return primaryExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryExpressionCompletion(PrimaryExpressionCompletion newPrimaryExpressionCompletion, NotificationChain msgs)
  {
    PrimaryExpressionCompletion oldPrimaryExpressionCompletion = primaryExpressionCompletion;
    primaryExpressionCompletion = newPrimaryExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION, oldPrimaryExpressionCompletion, newPrimaryExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryExpressionCompletion(PrimaryExpressionCompletion newPrimaryExpressionCompletion)
  {
    if (newPrimaryExpressionCompletion != primaryExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (primaryExpressionCompletion != null)
        msgs = ((InternalEObject)primaryExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION, null, msgs);
      if (newPrimaryExpressionCompletion != null)
        msgs = ((InternalEObject)newPrimaryExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPrimaryExpressionCompletion(newPrimaryExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION, newPrimaryExpressionCompletion, newPrimaryExpressionCompletion));
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
      case AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return basicSetNameOrPrimaryExpression(null, msgs);
      case AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION:
        return basicSetBaseExpression(null, msgs);
      case AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION:
        return basicSetParenthesizedExpression(null, msgs);
      case AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION:
        return basicSetPrimaryExpressionCompletion(null, msgs);
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
      case AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return getNameOrPrimaryExpression();
      case AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION:
        return getBaseExpression();
      case AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION:
        return getParenthesizedExpression();
      case AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION:
        return getPrimaryExpressionCompletion();
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
      case AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        setNameOrPrimaryExpression((NameOrPrimaryExpression)newValue);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION:
        setBaseExpression((BaseExpression)newValue);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION:
        setParenthesizedExpression((ParenthesizedExpression)newValue);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION:
        setPrimaryExpressionCompletion((PrimaryExpressionCompletion)newValue);
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
      case AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        setNameOrPrimaryExpression((NameOrPrimaryExpression)null);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION:
        setBaseExpression((BaseExpression)null);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION:
        setParenthesizedExpression((ParenthesizedExpression)null);
        return;
      case AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION:
        setPrimaryExpressionCompletion((PrimaryExpressionCompletion)null);
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
      case AlfPackage.PRIMARY_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return nameOrPrimaryExpression != null;
      case AlfPackage.PRIMARY_EXPRESSION__BASE_EXPRESSION:
        return baseExpression != null;
      case AlfPackage.PRIMARY_EXPRESSION__PARENTHESIZED_EXPRESSION:
        return parenthesizedExpression != null;
      case AlfPackage.PRIMARY_EXPRESSION__PRIMARY_EXPRESSION_COMPLETION:
        return primaryExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryExpressionImpl
