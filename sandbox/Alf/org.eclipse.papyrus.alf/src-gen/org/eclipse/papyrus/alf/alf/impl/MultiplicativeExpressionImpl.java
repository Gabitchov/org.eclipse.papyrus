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
import org.eclipse.papyrus.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicativeExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.MultiplicativeExpressionImpl#getMultiplicativeExpressionCompletion <em>Multiplicative Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicativeExpressionImpl extends MinimalEObjectImpl.Container implements MultiplicativeExpression
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
   * The cached value of the '{@link #getMultiplicativeExpressionCompletion() <em>Multiplicative Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicativeExpressionCompletion()
   * @generated
   * @ordered
   */
  protected MultiplicativeExpressionCompletion multiplicativeExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicativeExpressionImpl()
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
    return AlfPackage.eINSTANCE.getMultiplicativeExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpressionCompletion getMultiplicativeExpressionCompletion()
  {
    return multiplicativeExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion newMultiplicativeExpressionCompletion, NotificationChain msgs)
  {
    MultiplicativeExpressionCompletion oldMultiplicativeExpressionCompletion = multiplicativeExpressionCompletion;
    multiplicativeExpressionCompletion = newMultiplicativeExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION, oldMultiplicativeExpressionCompletion, newMultiplicativeExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion newMultiplicativeExpressionCompletion)
  {
    if (newMultiplicativeExpressionCompletion != multiplicativeExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (multiplicativeExpressionCompletion != null)
        msgs = ((InternalEObject)multiplicativeExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION, null, msgs);
      if (newMultiplicativeExpressionCompletion != null)
        msgs = ((InternalEObject)newMultiplicativeExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetMultiplicativeExpressionCompletion(newMultiplicativeExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION, newMultiplicativeExpressionCompletion, newMultiplicativeExpressionCompletion));
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
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return basicSetMultiplicativeExpressionCompletion(null, msgs);
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
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return getMultiplicativeExpressionCompletion();
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
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        setMultiplicativeExpressionCompletion((MultiplicativeExpressionCompletion)newValue);
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
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        setMultiplicativeExpressionCompletion((MultiplicativeExpressionCompletion)null);
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
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_EXPRESSION_COMPLETION:
        return multiplicativeExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //MultiplicativeExpressionImpl
