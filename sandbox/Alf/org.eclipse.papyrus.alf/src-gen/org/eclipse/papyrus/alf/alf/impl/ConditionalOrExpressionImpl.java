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
import org.eclipse.papyrus.alf.alf.ConditionalOrExpression;
import org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalOrExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalOrExpressionImpl#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalOrExpressionImpl extends MinimalEObjectImpl.Container implements ConditionalOrExpression
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
   * The cached value of the '{@link #getConditionalOrExpressionCompletion() <em>Conditional Or Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionalOrExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ConditionalOrExpressionCompletion conditionalOrExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalOrExpressionImpl()
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
    return AlfPackage.eINSTANCE.getConditionalOrExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalOrExpressionCompletion getConditionalOrExpressionCompletion()
  {
    return conditionalOrExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion newConditionalOrExpressionCompletion, NotificationChain msgs)
  {
    ConditionalOrExpressionCompletion oldConditionalOrExpressionCompletion = conditionalOrExpressionCompletion;
    conditionalOrExpressionCompletion = newConditionalOrExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION, oldConditionalOrExpressionCompletion, newConditionalOrExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionalOrExpressionCompletion(ConditionalOrExpressionCompletion newConditionalOrExpressionCompletion)
  {
    if (newConditionalOrExpressionCompletion != conditionalOrExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (conditionalOrExpressionCompletion != null)
        msgs = ((InternalEObject)conditionalOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newConditionalOrExpressionCompletion != null)
        msgs = ((InternalEObject)newConditionalOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetConditionalOrExpressionCompletion(newConditionalOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION, newConditionalOrExpressionCompletion, newConditionalOrExpressionCompletion));
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return basicSetConditionalOrExpressionCompletion(null, msgs);
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return getConditionalOrExpressionCompletion();
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        setConditionalOrExpressionCompletion((ConditionalOrExpressionCompletion)newValue);
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        setConditionalOrExpressionCompletion((ConditionalOrExpressionCompletion)null);
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
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.CONDITIONAL_OR_EXPRESSION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return conditionalOrExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalOrExpressionImpl
