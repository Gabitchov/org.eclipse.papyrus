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
import org.eclipse.papyrus.alf.alf.ExpressionCompletion;
import org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion;
import org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary To Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryToExpressionCompletionImpl#getPostFixExpressionCompletion <em>Post Fix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryToExpressionCompletionImpl#getExpressionCompletion <em>Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryToExpressionCompletionImpl extends MinimalEObjectImpl.Container implements PrimaryToExpressionCompletion
{
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
   * The cached value of the '{@link #getExpressionCompletion() <em>Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ExpressionCompletion expressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryToExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getPrimaryToExpressionCompletion();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION, oldPostFixExpressionCompletion, newPostFixExpressionCompletion);
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
        msgs = ((InternalEObject)postFixExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION, null, msgs);
      if (newPostFixExpressionCompletion != null)
        msgs = ((InternalEObject)newPostFixExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPostFixExpressionCompletion(newPostFixExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION, newPostFixExpressionCompletion, newPostFixExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionCompletion getExpressionCompletion()
  {
    return expressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpressionCompletion(ExpressionCompletion newExpressionCompletion, NotificationChain msgs)
  {
    ExpressionCompletion oldExpressionCompletion = expressionCompletion;
    expressionCompletion = newExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION, oldExpressionCompletion, newExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionCompletion(ExpressionCompletion newExpressionCompletion)
  {
    if (newExpressionCompletion != expressionCompletion)
    {
      NotificationChain msgs = null;
      if (expressionCompletion != null)
        msgs = ((InternalEObject)expressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION, null, msgs);
      if (newExpressionCompletion != null)
        msgs = ((InternalEObject)newExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetExpressionCompletion(newExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION, newExpressionCompletion, newExpressionCompletion));
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
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION:
        return basicSetPostFixExpressionCompletion(null, msgs);
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION:
        return basicSetExpressionCompletion(null, msgs);
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
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION:
        return getPostFixExpressionCompletion();
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION:
        return getExpressionCompletion();
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
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION:
        setPostFixExpressionCompletion((PostfixExpressionCompletion)newValue);
        return;
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION:
        setExpressionCompletion((ExpressionCompletion)newValue);
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
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION:
        setPostFixExpressionCompletion((PostfixExpressionCompletion)null);
        return;
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION:
        setExpressionCompletion((ExpressionCompletion)null);
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
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__POST_FIX_EXPRESSION_COMPLETION:
        return postFixExpressionCompletion != null;
      case AlfPackage.PRIMARY_TO_EXPRESSION_COMPLETION__EXPRESSION_COMPLETION:
        return expressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryToExpressionCompletionImpl
