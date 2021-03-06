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
import org.eclipse.papyrus.alf.alf.AndExpression;
import org.eclipse.papyrus.alf.alf.AndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AndExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AndExpressionImpl#getAndExpressionCompletion <em>And Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndExpressionImpl extends MinimalEObjectImpl.Container implements AndExpression
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
   * The cached value of the '{@link #getAndExpressionCompletion() <em>And Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndExpressionCompletion()
   * @generated
   * @ordered
   */
  protected AndExpressionCompletion andExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AndExpressionImpl()
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
    return AlfPackage.eINSTANCE.getAndExpression();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
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
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpressionCompletion getAndExpressionCompletion()
  {
    return andExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAndExpressionCompletion(AndExpressionCompletion newAndExpressionCompletion, NotificationChain msgs)
  {
    AndExpressionCompletion oldAndExpressionCompletion = andExpressionCompletion;
    andExpressionCompletion = newAndExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION, oldAndExpressionCompletion, newAndExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndExpressionCompletion(AndExpressionCompletion newAndExpressionCompletion)
  {
    if (newAndExpressionCompletion != andExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (andExpressionCompletion != null)
        msgs = ((InternalEObject)andExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION, null, msgs);
      if (newAndExpressionCompletion != null)
        msgs = ((InternalEObject)newAndExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetAndExpressionCompletion(newAndExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION, newAndExpressionCompletion, newAndExpressionCompletion));
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
      case AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION:
        return basicSetAndExpressionCompletion(null, msgs);
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
      case AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION:
        return getAndExpressionCompletion();
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
      case AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION:
        setAndExpressionCompletion((AndExpressionCompletion)newValue);
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
      case AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION:
        setAndExpressionCompletion((AndExpressionCompletion)null);
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
      case AlfPackage.AND_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.AND_EXPRESSION__AND_EXPRESSION_COMPLETION:
        return andExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //AndExpressionImpl
