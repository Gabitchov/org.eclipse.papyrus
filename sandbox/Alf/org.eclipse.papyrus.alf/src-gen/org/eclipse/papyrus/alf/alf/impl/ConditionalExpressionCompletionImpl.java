/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ConditionalExpression;
import org.eclipse.papyrus.alf.alf.ConditionalExpressionCompletion;
import org.eclipse.papyrus.alf.alf.ConditionalOrExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalExpressionCompletionImpl#getConditionalOrExpressionCompletion <em>Conditional Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ConditionalExpressionCompletionImpl#getConditionalExpression <em>Conditional Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionCompletionImpl extends ExpressionCompletionImpl implements ConditionalExpressionCompletion
{
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
   * The cached value of the '{@link #getConditionalExpression() <em>Conditional Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionalExpression()
   * @generated
   * @ordered
   */
  protected ConditionalExpression conditionalExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getConditionalExpressionCompletion();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION, oldConditionalOrExpressionCompletion, newConditionalOrExpressionCompletion);
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
        msgs = ((InternalEObject)conditionalOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newConditionalOrExpressionCompletion != null)
        msgs = ((InternalEObject)newConditionalOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetConditionalOrExpressionCompletion(newConditionalOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION, newConditionalOrExpressionCompletion, newConditionalOrExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression getConditionalExpression()
  {
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionalExpression(ConditionalExpression newConditionalExpression, NotificationChain msgs)
  {
    ConditionalExpression oldConditionalExpression = conditionalExpression;
    conditionalExpression = newConditionalExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION, oldConditionalExpression, newConditionalExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionalExpression(ConditionalExpression newConditionalExpression)
  {
    if (newConditionalExpression != conditionalExpression)
    {
      NotificationChain msgs = null;
      if (conditionalExpression != null)
        msgs = ((InternalEObject)conditionalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION, null, msgs);
      if (newConditionalExpression != null)
        msgs = ((InternalEObject)newConditionalExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION, null, msgs);
      msgs = basicSetConditionalExpression(newConditionalExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION, newConditionalExpression, newConditionalExpression));
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
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return basicSetConditionalOrExpressionCompletion(null, msgs);
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION:
        return basicSetConditionalExpression(null, msgs);
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
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return getConditionalOrExpressionCompletion();
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION:
        return getConditionalExpression();
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
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        setConditionalOrExpressionCompletion((ConditionalOrExpressionCompletion)newValue);
        return;
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION:
        setConditionalExpression((ConditionalExpression)newValue);
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
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        setConditionalOrExpressionCompletion((ConditionalOrExpressionCompletion)null);
        return;
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION:
        setConditionalExpression((ConditionalExpression)null);
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
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_OR_EXPRESSION_COMPLETION:
        return conditionalOrExpressionCompletion != null;
      case AlfPackage.CONDITIONAL_EXPRESSION_COMPLETION__CONDITIONAL_EXPRESSION:
        return conditionalExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionCompletionImpl
