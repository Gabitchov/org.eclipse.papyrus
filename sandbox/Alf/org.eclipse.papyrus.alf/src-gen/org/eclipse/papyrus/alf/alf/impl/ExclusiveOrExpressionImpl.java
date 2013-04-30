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
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclusive Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ExclusiveOrExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ExclusiveOrExpressionImpl#getExclusiveOrExpressionCompletion <em>Exclusive Or Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExclusiveOrExpressionImpl extends MinimalEObjectImpl.Container implements ExclusiveOrExpression
{
  /**
   * The cached value of the '{@link #getUnaryExpression() <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryExpression()
   * @generated
   * @ordered
   */
  protected UnaryExpression unaryExpression;

  /**
   * The cached value of the '{@link #getExclusiveOrExpressionCompletion() <em>Exclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExclusiveOrExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ExclusiveOrExpressionCompletion exclusiveOrExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExclusiveOrExpressionImpl()
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
    return AlfPackage.eINSTANCE.getExclusiveOrExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression getUnaryExpression()
  {
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnaryExpression(UnaryExpression newUnaryExpression, NotificationChain msgs)
  {
    UnaryExpression oldUnaryExpression = unaryExpression;
    unaryExpression = newUnaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnaryExpression(UnaryExpression newUnaryExpression)
  {
    if (newUnaryExpression != unaryExpression)
    {
      NotificationChain msgs = null;
      if (unaryExpression != null)
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExclusiveOrExpressionCompletion getExclusiveOrExpressionCompletion()
  {
    return exclusiveOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion newExclusiveOrExpressionCompletion, NotificationChain msgs)
  {
    ExclusiveOrExpressionCompletion oldExclusiveOrExpressionCompletion = exclusiveOrExpressionCompletion;
    exclusiveOrExpressionCompletion = newExclusiveOrExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, oldExclusiveOrExpressionCompletion, newExclusiveOrExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExclusiveOrExpressionCompletion(ExclusiveOrExpressionCompletion newExclusiveOrExpressionCompletion)
  {
    if (newExclusiveOrExpressionCompletion != exclusiveOrExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (exclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)exclusiveOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newExclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)newExclusiveOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetExclusiveOrExpressionCompletion(newExclusiveOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, newExclusiveOrExpressionCompletion, newExclusiveOrExpressionCompletion));
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return basicSetExclusiveOrExpressionCompletion(null, msgs);
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return getExclusiveOrExpressionCompletion();
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        setExclusiveOrExpressionCompletion((ExclusiveOrExpressionCompletion)newValue);
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        setExclusiveOrExpressionCompletion((ExclusiveOrExpressionCompletion)null);
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
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return exclusiveOrExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //ExclusiveOrExpressionImpl
