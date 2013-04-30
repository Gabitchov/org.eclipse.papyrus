/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AndExpressionCompletion;
import org.eclipse.papyrus.alf.alf.EqualityExpression;
import org.eclipse.papyrus.alf.alf.EqualityExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AndExpressionCompletionImpl#getEqualityExpressionCompletion <em>Equality Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AndExpressionCompletionImpl#getEqualityExpression <em>Equality Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndExpressionCompletionImpl extends MinimalEObjectImpl.Container implements AndExpressionCompletion
{
  /**
   * The cached value of the '{@link #getEqualityExpressionCompletion() <em>Equality Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualityExpressionCompletion()
   * @generated
   * @ordered
   */
  protected EqualityExpressionCompletion equalityExpressionCompletion;

  /**
   * The cached value of the '{@link #getEqualityExpression() <em>Equality Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualityExpression()
   * @generated
   * @ordered
   */
  protected EList<EqualityExpression> equalityExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AndExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getAndExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpressionCompletion getEqualityExpressionCompletion()
  {
    return equalityExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEqualityExpressionCompletion(EqualityExpressionCompletion newEqualityExpressionCompletion, NotificationChain msgs)
  {
    EqualityExpressionCompletion oldEqualityExpressionCompletion = equalityExpressionCompletion;
    equalityExpressionCompletion = newEqualityExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION, oldEqualityExpressionCompletion, newEqualityExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEqualityExpressionCompletion(EqualityExpressionCompletion newEqualityExpressionCompletion)
  {
    if (newEqualityExpressionCompletion != equalityExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (equalityExpressionCompletion != null)
        msgs = ((InternalEObject)equalityExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION, null, msgs);
      if (newEqualityExpressionCompletion != null)
        msgs = ((InternalEObject)newEqualityExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetEqualityExpressionCompletion(newEqualityExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION, newEqualityExpressionCompletion, newEqualityExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EqualityExpression> getEqualityExpression()
  {
    if (equalityExpression == null)
    {
      equalityExpression = new EObjectContainmentEList<EqualityExpression>(EqualityExpression.class, this, AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION);
    }
    return equalityExpression;
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
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION:
        return basicSetEqualityExpressionCompletion(null, msgs);
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION:
        return ((InternalEList<?>)getEqualityExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION:
        return getEqualityExpressionCompletion();
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION:
        return getEqualityExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION:
        setEqualityExpressionCompletion((EqualityExpressionCompletion)newValue);
        return;
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION:
        getEqualityExpression().clear();
        getEqualityExpression().addAll((Collection<? extends EqualityExpression>)newValue);
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
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION:
        setEqualityExpressionCompletion((EqualityExpressionCompletion)null);
        return;
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION:
        getEqualityExpression().clear();
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
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION_COMPLETION:
        return equalityExpressionCompletion != null;
      case AlfPackage.AND_EXPRESSION_COMPLETION__EQUALITY_EXPRESSION:
        return equalityExpression != null && !equalityExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AndExpressionCompletionImpl
