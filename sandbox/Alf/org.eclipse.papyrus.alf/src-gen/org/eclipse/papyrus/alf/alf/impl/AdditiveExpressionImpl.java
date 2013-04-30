/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AdditiveExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AdditiveExpressionImpl#getAdditiveExpressionCompletion <em>Additive Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdditiveExpressionImpl extends MinimalEObjectImpl.Container implements AdditiveExpression
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
   * The cached value of the '{@link #getAdditiveExpressionCompletion() <em>Additive Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditiveExpressionCompletion()
   * @generated
   * @ordered
   */
  protected AdditiveExpressionCompletion additiveExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AdditiveExpressionImpl()
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
    return AlfPackage.eINSTANCE.getAdditiveExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpressionCompletion getAdditiveExpressionCompletion()
  {
    return additiveExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdditiveExpressionCompletion(AdditiveExpressionCompletion newAdditiveExpressionCompletion, NotificationChain msgs)
  {
    AdditiveExpressionCompletion oldAdditiveExpressionCompletion = additiveExpressionCompletion;
    additiveExpressionCompletion = newAdditiveExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION, oldAdditiveExpressionCompletion, newAdditiveExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditiveExpressionCompletion(AdditiveExpressionCompletion newAdditiveExpressionCompletion)
  {
    if (newAdditiveExpressionCompletion != additiveExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (additiveExpressionCompletion != null)
        msgs = ((InternalEObject)additiveExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION, null, msgs);
      if (newAdditiveExpressionCompletion != null)
        msgs = ((InternalEObject)newAdditiveExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetAdditiveExpressionCompletion(newAdditiveExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION, newAdditiveExpressionCompletion, newAdditiveExpressionCompletion));
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
      case AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION:
        return basicSetAdditiveExpressionCompletion(null, msgs);
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
      case AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION:
        return getAdditiveExpressionCompletion();
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
      case AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION:
        setAdditiveExpressionCompletion((AdditiveExpressionCompletion)newValue);
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
      case AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION:
        setAdditiveExpressionCompletion((AdditiveExpressionCompletion)null);
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
      case AlfPackage.ADDITIVE_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.ADDITIVE_EXPRESSION__ADDITIVE_EXPRESSION_COMPLETION:
        return additiveExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //AdditiveExpressionImpl
