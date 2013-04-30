/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression;
import org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression;
import org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion;
import org.eclipse.papyrus.alf.alf.PostfixOrCastExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Or Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PostfixOrCastExpressionImpl#getNonNamePostfixOrCastExpression <em>Non Name Postfix Or Cast Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PostfixOrCastExpressionImpl#getNameOrPrimaryExpression <em>Name Or Primary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PostfixOrCastExpressionImpl#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixOrCastExpressionImpl extends UnaryExpressionImpl implements PostfixOrCastExpression
{
  /**
   * The cached value of the '{@link #getNonNamePostfixOrCastExpression() <em>Non Name Postfix Or Cast Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonNamePostfixOrCastExpression()
   * @generated
   * @ordered
   */
  protected NonNamePostfixOrCastExpression nonNamePostfixOrCastExpression;

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
   * The cached value of the '{@link #getPostFixExpressionCompletion() <em>Post Fix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostFixExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PostfixExpressionCompletion postFixExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixOrCastExpressionImpl()
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
    return AlfPackage.eINSTANCE.getPostfixOrCastExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNamePostfixOrCastExpression getNonNamePostfixOrCastExpression()
  {
    return nonNamePostfixOrCastExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression newNonNamePostfixOrCastExpression, NotificationChain msgs)
  {
    NonNamePostfixOrCastExpression oldNonNamePostfixOrCastExpression = nonNamePostfixOrCastExpression;
    nonNamePostfixOrCastExpression = newNonNamePostfixOrCastExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION, oldNonNamePostfixOrCastExpression, newNonNamePostfixOrCastExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonNamePostfixOrCastExpression(NonNamePostfixOrCastExpression newNonNamePostfixOrCastExpression)
  {
    if (newNonNamePostfixOrCastExpression != nonNamePostfixOrCastExpression)
    {
      NotificationChain msgs = null;
      if (nonNamePostfixOrCastExpression != null)
        msgs = ((InternalEObject)nonNamePostfixOrCastExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION, null, msgs);
      if (newNonNamePostfixOrCastExpression != null)
        msgs = ((InternalEObject)newNonNamePostfixOrCastExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION, null, msgs);
      msgs = basicSetNonNamePostfixOrCastExpression(newNonNamePostfixOrCastExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION, newNonNamePostfixOrCastExpression, newNonNamePostfixOrCastExpression));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, oldNameOrPrimaryExpression, newNameOrPrimaryExpression);
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
        msgs = ((InternalEObject)nameOrPrimaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, null, msgs);
      if (newNameOrPrimaryExpression != null)
        msgs = ((InternalEObject)newNameOrPrimaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, null, msgs);
      msgs = basicSetNameOrPrimaryExpression(newNameOrPrimaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION, newNameOrPrimaryExpression, newNameOrPrimaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpressionCompletion getPostFixExpressionCompletion()
  {
    return postFixExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostFixExpressionCompletion(PostfixExpressionCompletion newPostFixExpressionCompletion, NotificationChain msgs)
  {
    PostfixExpressionCompletion oldPostFixExpressionCompletion = postFixExpressionCompletion;
    postFixExpressionCompletion = newPostFixExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION, oldPostFixExpressionCompletion, newPostFixExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostFixExpressionCompletion(PostfixExpressionCompletion newPostFixExpressionCompletion)
  {
    if (newPostFixExpressionCompletion != postFixExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (postFixExpressionCompletion != null)
        msgs = ((InternalEObject)postFixExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION, null, msgs);
      if (newPostFixExpressionCompletion != null)
        msgs = ((InternalEObject)newPostFixExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPostFixExpressionCompletion(newPostFixExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION, newPostFixExpressionCompletion, newPostFixExpressionCompletion));
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
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
        return basicSetNonNamePostfixOrCastExpression(null, msgs);
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return basicSetNameOrPrimaryExpression(null, msgs);
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION:
        return basicSetPostFixExpressionCompletion(null, msgs);
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
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
        return getNonNamePostfixOrCastExpression();
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return getNameOrPrimaryExpression();
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION:
        return getPostFixExpressionCompletion();
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
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
        setNonNamePostfixOrCastExpression((NonNamePostfixOrCastExpression)newValue);
        return;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        setNameOrPrimaryExpression((NameOrPrimaryExpression)newValue);
        return;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION:
        setPostFixExpressionCompletion((PostfixExpressionCompletion)newValue);
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
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
        setNonNamePostfixOrCastExpression((NonNamePostfixOrCastExpression)null);
        return;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        setNameOrPrimaryExpression((NameOrPrimaryExpression)null);
        return;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION:
        setPostFixExpressionCompletion((PostfixExpressionCompletion)null);
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
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NON_NAME_POSTFIX_OR_CAST_EXPRESSION:
        return nonNamePostfixOrCastExpression != null;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__NAME_OR_PRIMARY_EXPRESSION:
        return nameOrPrimaryExpression != null;
      case AlfPackage.POSTFIX_OR_CAST_EXPRESSION__POST_FIX_EXPRESSION_COMPLETION:
        return postFixExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //PostfixOrCastExpressionImpl
