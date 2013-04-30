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
import org.eclipse.papyrus.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inclusive Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.InclusiveOrExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.InclusiveOrExpressionImpl#getInclusiveOrExpressionCompletion <em>Inclusive Or Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InclusiveOrExpressionImpl extends MinimalEObjectImpl.Container implements InclusiveOrExpression
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
   * The cached value of the '{@link #getInclusiveOrExpressionCompletion() <em>Inclusive Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInclusiveOrExpressionCompletion()
   * @generated
   * @ordered
   */
  protected InclusiveOrExpressionCompletion inclusiveOrExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InclusiveOrExpressionImpl()
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
    return AlfPackage.eINSTANCE.getInclusiveOrExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpressionCompletion getInclusiveOrExpressionCompletion()
  {
    return inclusiveOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion newInclusiveOrExpressionCompletion, NotificationChain msgs)
  {
    InclusiveOrExpressionCompletion oldInclusiveOrExpressionCompletion = inclusiveOrExpressionCompletion;
    inclusiveOrExpressionCompletion = newInclusiveOrExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION, oldInclusiveOrExpressionCompletion, newInclusiveOrExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInclusiveOrExpressionCompletion(InclusiveOrExpressionCompletion newInclusiveOrExpressionCompletion)
  {
    if (newInclusiveOrExpressionCompletion != inclusiveOrExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (inclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)inclusiveOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newInclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)newInclusiveOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetInclusiveOrExpressionCompletion(newInclusiveOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION, newInclusiveOrExpressionCompletion, newInclusiveOrExpressionCompletion));
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return basicSetInclusiveOrExpressionCompletion(null, msgs);
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return getInclusiveOrExpressionCompletion();
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        setInclusiveOrExpressionCompletion((InclusiveOrExpressionCompletion)newValue);
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        setInclusiveOrExpressionCompletion((InclusiveOrExpressionCompletion)null);
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION__INCLUSIVE_OR_EXPRESSION_COMPLETION:
        return inclusiveOrExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //InclusiveOrExpressionImpl
