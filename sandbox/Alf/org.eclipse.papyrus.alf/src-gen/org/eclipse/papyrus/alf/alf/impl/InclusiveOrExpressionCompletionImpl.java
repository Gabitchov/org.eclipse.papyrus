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
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpressionCompletion;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inclusive Or Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.InclusiveOrExpressionCompletionImpl#getExclusiveOrExpressionCompletion <em>Exclusive Or Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.InclusiveOrExpressionCompletionImpl#getExclusiveOrExpression <em>Exclusive Or Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InclusiveOrExpressionCompletionImpl extends MinimalEObjectImpl.Container implements InclusiveOrExpressionCompletion
{
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
   * The cached value of the '{@link #getExclusiveOrExpression() <em>Exclusive Or Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExclusiveOrExpression()
   * @generated
   * @ordered
   */
  protected EList<ExclusiveOrExpression> exclusiveOrExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InclusiveOrExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getInclusiveOrExpressionCompletion();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, oldExclusiveOrExpressionCompletion, newExclusiveOrExpressionCompletion);
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
        msgs = ((InternalEObject)exclusiveOrExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      if (newExclusiveOrExpressionCompletion != null)
        msgs = ((InternalEObject)newExclusiveOrExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetExclusiveOrExpressionCompletion(newExclusiveOrExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION, newExclusiveOrExpressionCompletion, newExclusiveOrExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExclusiveOrExpression> getExclusiveOrExpression()
  {
    if (exclusiveOrExpression == null)
    {
      exclusiveOrExpression = new EObjectContainmentEList<ExclusiveOrExpression>(ExclusiveOrExpression.class, this, AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION);
    }
    return exclusiveOrExpression;
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return basicSetExclusiveOrExpressionCompletion(null, msgs);
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION:
        return ((InternalEList<?>)getExclusiveOrExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return getExclusiveOrExpressionCompletion();
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION:
        return getExclusiveOrExpression();
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        setExclusiveOrExpressionCompletion((ExclusiveOrExpressionCompletion)newValue);
        return;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION:
        getExclusiveOrExpression().clear();
        getExclusiveOrExpression().addAll((Collection<? extends ExclusiveOrExpression>)newValue);
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        setExclusiveOrExpressionCompletion((ExclusiveOrExpressionCompletion)null);
        return;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION:
        getExclusiveOrExpression().clear();
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
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION_COMPLETION:
        return exclusiveOrExpressionCompletion != null;
      case AlfPackage.INCLUSIVE_OR_EXPRESSION_COMPLETION__EXCLUSIVE_OR_EXPRESSION:
        return exclusiveOrExpression != null && !exclusiveOrExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InclusiveOrExpressionCompletionImpl
