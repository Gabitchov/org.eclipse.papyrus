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
import org.eclipse.papyrus.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalAndExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalAndExpressionImpl#getConditionalAndExpressionCompletion <em>Conditional And Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalAndExpressionImpl extends MinimalEObjectImpl.Container implements ConditionalAndExpression
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
   * The cached value of the '{@link #getConditionalAndExpressionCompletion() <em>Conditional And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionalAndExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ConditionalAndExpressionCompletion conditionalAndExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalAndExpressionImpl()
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
    return AlfPackage.eINSTANCE.getConditionalAndExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpressionCompletion getConditionalAndExpressionCompletion()
  {
    return conditionalAndExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion newConditionalAndExpressionCompletion, NotificationChain msgs)
  {
    ConditionalAndExpressionCompletion oldConditionalAndExpressionCompletion = conditionalAndExpressionCompletion;
    conditionalAndExpressionCompletion = newConditionalAndExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION, oldConditionalAndExpressionCompletion, newConditionalAndExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionalAndExpressionCompletion(ConditionalAndExpressionCompletion newConditionalAndExpressionCompletion)
  {
    if (newConditionalAndExpressionCompletion != conditionalAndExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (conditionalAndExpressionCompletion != null)
        msgs = ((InternalEObject)conditionalAndExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION, null, msgs);
      if (newConditionalAndExpressionCompletion != null)
        msgs = ((InternalEObject)newConditionalAndExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetConditionalAndExpressionCompletion(newConditionalAndExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION, newConditionalAndExpressionCompletion, newConditionalAndExpressionCompletion));
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return basicSetConditionalAndExpressionCompletion(null, msgs);
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return getConditionalAndExpressionCompletion();
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        setConditionalAndExpressionCompletion((ConditionalAndExpressionCompletion)newValue);
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        setConditionalAndExpressionCompletion((ConditionalAndExpressionCompletion)null);
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
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.CONDITIONAL_AND_EXPRESSION__CONDITIONAL_AND_EXPRESSION_COMPLETION:
        return conditionalAndExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalAndExpressionImpl
