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
import org.eclipse.papyrus.alf.alf.NonNameExpression;
import org.eclipse.papyrus.alf.alf.NonNameUnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Name Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNameExpressionImpl#getNonNameUnaryExpression <em>Non Name Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNameExpressionImpl#getExpressionCompletion <em>Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonNameExpressionImpl extends MinimalEObjectImpl.Container implements NonNameExpression
{
  /**
   * The cached value of the '{@link #getNonNameUnaryExpression() <em>Non Name Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonNameUnaryExpression()
   * @generated
   * @ordered
   */
  protected NonNameUnaryExpression nonNameUnaryExpression;

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
  protected NonNameExpressionImpl()
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
    return AlfPackage.eINSTANCE.getNonNameExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNameUnaryExpression getNonNameUnaryExpression()
  {
    return nonNameUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNonNameUnaryExpression(NonNameUnaryExpression newNonNameUnaryExpression, NotificationChain msgs)
  {
    NonNameUnaryExpression oldNonNameUnaryExpression = nonNameUnaryExpression;
    nonNameUnaryExpression = newNonNameUnaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION, oldNonNameUnaryExpression, newNonNameUnaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonNameUnaryExpression(NonNameUnaryExpression newNonNameUnaryExpression)
  {
    if (newNonNameUnaryExpression != nonNameUnaryExpression)
    {
      NotificationChain msgs = null;
      if (nonNameUnaryExpression != null)
        msgs = ((InternalEObject)nonNameUnaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION, null, msgs);
      if (newNonNameUnaryExpression != null)
        msgs = ((InternalEObject)newNonNameUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION, null, msgs);
      msgs = basicSetNonNameUnaryExpression(newNonNameUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION, newNonNameUnaryExpression, newNonNameUnaryExpression));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION, oldExpressionCompletion, newExpressionCompletion);
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
        msgs = ((InternalEObject)expressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION, null, msgs);
      if (newExpressionCompletion != null)
        msgs = ((InternalEObject)newExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetExpressionCompletion(newExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION, newExpressionCompletion, newExpressionCompletion));
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
      case AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION:
        return basicSetNonNameUnaryExpression(null, msgs);
      case AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION:
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
      case AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION:
        return getNonNameUnaryExpression();
      case AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION:
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
      case AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION:
        setNonNameUnaryExpression((NonNameUnaryExpression)newValue);
        return;
      case AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION:
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
      case AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION:
        setNonNameUnaryExpression((NonNameUnaryExpression)null);
        return;
      case AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION:
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
      case AlfPackage.NON_NAME_EXPRESSION__NON_NAME_UNARY_EXPRESSION:
        return nonNameUnaryExpression != null;
      case AlfPackage.NON_NAME_EXPRESSION__EXPRESSION_COMPLETION:
        return expressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //NonNameExpressionImpl
